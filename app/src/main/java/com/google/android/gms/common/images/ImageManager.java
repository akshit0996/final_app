package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.images.C0182a.C0181a;
import com.google.android.gms.common.images.C0182a.C0813b;
import com.google.android.gms.common.images.C0182a.C0814c;
import com.google.android.gms.internal.jc;
import com.google.android.gms.internal.je;
import com.google.android.gms.internal.kj;
import com.google.android.gms.internal.ll;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    private static final Object Lu = new Object();
    private static HashSet<Uri> Lv = new HashSet();
    private static ImageManager Lw;
    private static ImageManager Lx;
    private final jc LA;
    private final Map<C0182a, ImageReceiver> LB;
    private final Map<Uri, ImageReceiver> LC;
    private final Map<Uri, Long> LD;
    private final ExecutorService Ly = Executors.newFixedThreadPool(4);
    private final C0812b Lz;
    private final Context mContext;
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    private final class ImageReceiver extends ResultReceiver {
        private final ArrayList<C0182a> LE = new ArrayList();
        final /* synthetic */ ImageManager LF;
        private final Uri mUri;

        ImageReceiver(ImageManager imageManager, Uri uri) {
            this.LF = imageManager;
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
        }

        /* renamed from: b */
        public void m176b(C0182a c0182a) {
            je.aU("ImageReceiver.addImageRequest() must be called in the main thread");
            this.LE.add(c0182a);
        }

        /* renamed from: c */
        public void m177c(C0182a c0182a) {
            je.aU("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.LE.remove(c0182a);
        }

        public void hg() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            this.LF.mContext.sendBroadcast(intent);
        }

        public void onReceiveResult(int resultCode, Bundle resultData) {
            this.LF.Ly.execute(new C0177c(this.LF, this.mUri, (ParcelFileDescriptor) resultData.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$a */
    private static final class C0176a {
        /* renamed from: a */
        static int m178a(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$c */
    private final class C0177c implements Runnable {
        final /* synthetic */ ImageManager LF;
        private final ParcelFileDescriptor LG;
        private final Uri mUri;

        public C0177c(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.LF = imageManager;
            this.mUri = uri;
            this.LG = parcelFileDescriptor;
        }

        public void run() {
            je.aV("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmap = null;
            if (this.LG != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.LG.getFileDescriptor());
                } catch (Throwable e) {
                    Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, e);
                    z = true;
                }
                try {
                    this.LG.close();
                } catch (Throwable e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.LF.mHandler.post(new C0180f(this.LF, this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$d */
    private final class C0178d implements Runnable {
        final /* synthetic */ ImageManager LF;
        private final C0182a LH;

        public C0178d(ImageManager imageManager, C0182a c0182a) {
            this.LF = imageManager;
            this.LH = c0182a;
        }

        public void run() {
            je.aU("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) this.LF.LB.get(this.LH);
            if (imageReceiver != null) {
                this.LF.LB.remove(this.LH);
                imageReceiver.m177c(this.LH);
            }
            C0181a c0181a = this.LH.LJ;
            if (c0181a.uri == null) {
                this.LH.m197a(this.LF.mContext, this.LF.LA, true);
                return;
            }
            Bitmap a = this.LF.m181a(c0181a);
            if (a != null) {
                this.LH.m195a(this.LF.mContext, a, true);
                return;
            }
            Long l = (Long) this.LF.LD.get(c0181a.uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.LH.m197a(this.LF.mContext, this.LF.LA, true);
                    return;
                }
                this.LF.LD.remove(c0181a.uri);
            }
            this.LH.m196a(this.LF.mContext, this.LF.LA);
            imageReceiver = (ImageReceiver) this.LF.LC.get(c0181a.uri);
            if (imageReceiver == null) {
                imageReceiver = new ImageReceiver(this.LF, c0181a.uri);
                this.LF.LC.put(c0181a.uri, imageReceiver);
            }
            imageReceiver.m176b(this.LH);
            if (!(this.LH instanceof C0814c)) {
                this.LF.LB.put(this.LH, imageReceiver);
            }
            synchronized (ImageManager.Lu) {
                if (!ImageManager.Lv.contains(c0181a.uri)) {
                    ImageManager.Lv.add(c0181a.uri);
                    imageReceiver.hg();
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$e */
    private static final class C0179e implements ComponentCallbacks2 {
        private final C0812b Lz;

        public C0179e(C0812b c0812b) {
            this.Lz = c0812b;
        }

        public void onConfigurationChanged(Configuration newConfig) {
        }

        public void onLowMemory() {
            this.Lz.evictAll();
        }

        public void onTrimMemory(int level) {
            if (level >= 60) {
                this.Lz.evictAll();
            } else if (level >= 20) {
                this.Lz.trimToSize(this.Lz.size() / 2);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$f */
    private final class C0180f implements Runnable {
        final /* synthetic */ ImageManager LF;
        private boolean LI;
        private final Bitmap mBitmap;
        private final Uri mUri;
        private final CountDownLatch mr;

        public C0180f(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.LF = imageManager;
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.LI = z;
            this.mr = countDownLatch;
        }

        /* renamed from: a */
        private void m179a(ImageReceiver imageReceiver, boolean z) {
            ArrayList a = imageReceiver.LE;
            int size = a.size();
            for (int i = 0; i < size; i++) {
                C0182a c0182a = (C0182a) a.get(i);
                if (z) {
                    c0182a.m195a(this.LF.mContext, this.mBitmap, false);
                } else {
                    this.LF.LD.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                    c0182a.m197a(this.LF.mContext, this.LF.LA, false);
                }
                if (!(c0182a instanceof C0814c)) {
                    this.LF.LB.remove(c0182a);
                }
            }
        }

        public void run() {
            je.aU("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (this.LF.Lz != null) {
                if (this.LI) {
                    this.LF.Lz.evictAll();
                    System.gc();
                    this.LI = false;
                    this.LF.mHandler.post(this);
                    return;
                } else if (z) {
                    this.LF.Lz.put(new C0181a(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) this.LF.LC.remove(this.mUri);
            if (imageReceiver != null) {
                m179a(imageReceiver, z);
            }
            this.mr.countDown();
            synchronized (ImageManager.Lu) {
                ImageManager.Lv.remove(this.mUri);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$b */
    private static final class C0812b extends kj<C0181a, Bitmap> {
        public C0812b(Context context) {
            super(C0812b.m2502I(context));
        }

        /* renamed from: I */
        private static int m2502I(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            int memoryClass = (((context.getApplicationInfo().flags & AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START) != 0 ? 1 : null) == null || !ll.ig()) ? activityManager.getMemoryClass() : C0176a.m178a(activityManager);
            return (int) (((float) (memoryClass * AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START)) * 0.33f);
        }

        /* renamed from: a */
        protected int m2503a(C0181a c0181a, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        /* renamed from: a */
        protected void m2504a(boolean z, C0181a c0181a, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, c0181a, bitmap, bitmap2);
        }

        protected /* synthetic */ void entryRemoved(boolean x0, Object x1, Object x2, Object x3) {
            m2504a(x0, (C0181a) x1, (Bitmap) x2, (Bitmap) x3);
        }

        protected /* synthetic */ int sizeOf(Object x0, Object x1) {
            return m2503a((C0181a) x0, (Bitmap) x1);
        }
    }

    private ImageManager(Context context, boolean withMemoryCache) {
        this.mContext = context.getApplicationContext();
        if (withMemoryCache) {
            this.Lz = new C0812b(this.mContext);
            if (ll.ij()) {
                hd();
            }
        } else {
            this.Lz = null;
        }
        this.LA = new jc();
        this.LB = new HashMap();
        this.LC = new HashMap();
        this.LD = new HashMap();
    }

    /* renamed from: a */
    private Bitmap m181a(C0181a c0181a) {
        return this.Lz == null ? null : (Bitmap) this.Lz.get(c0181a);
    }

    /* renamed from: c */
    public static ImageManager m184c(Context context, boolean z) {
        if (z) {
            if (Lx == null) {
                Lx = new ImageManager(context, true);
            }
            return Lx;
        }
        if (Lw == null) {
            Lw = new ImageManager(context, false);
        }
        return Lw;
    }

    public static ImageManager create(Context context) {
        return m184c(context, false);
    }

    private void hd() {
        this.mContext.registerComponentCallbacks(new C0179e(this.Lz));
    }

    /* renamed from: a */
    public void m191a(C0182a c0182a) {
        je.aU("ImageManager.loadImage() must be called in the main thread");
        new C0178d(this, c0182a).run();
    }

    public void loadImage(ImageView imageView, int resId) {
        m191a(new C0813b(imageView, resId));
    }

    public void loadImage(ImageView imageView, Uri uri) {
        m191a(new C0813b(imageView, uri));
    }

    public void loadImage(ImageView imageView, Uri uri, int defaultResId) {
        C0182a c0813b = new C0813b(imageView, uri);
        c0813b.az(defaultResId);
        m191a(c0813b);
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri) {
        m191a(new C0814c(listener, uri));
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri, int defaultResId) {
        C0182a c0814c = new C0814c(listener, uri);
        c0814c.az(defaultResId);
        m191a(c0814c);
    }
}
