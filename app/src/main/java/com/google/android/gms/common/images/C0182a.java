package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.images.ImageManager.OnImageLoadedListener;
import com.google.android.gms.internal.iz;
import com.google.android.gms.internal.ja;
import com.google.android.gms.internal.jb;
import com.google.android.gms.internal.jc;
import com.google.android.gms.internal.jc.C0474a;
import com.google.android.gms.internal.je;
import com.google.android.gms.internal.jv;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.common.images.a */
public abstract class C0182a {
    final C0181a LJ;
    protected int LK = 0;
    protected int LL = 0;
    protected boolean LM = false;
    protected OnImageLoadedListener LN;
    private boolean LO = true;
    private boolean LP = false;
    private boolean LQ = true;
    protected int LR;

    /* renamed from: com.google.android.gms.common.images.a$a */
    static final class C0181a {
        public final Uri uri;

        public C0181a(Uri uri) {
            this.uri = uri;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0181a) {
                return this == obj ? true : jv.equal(((C0181a) obj).uri, this.uri);
            } else {
                return false;
            }
        }

        public int hashCode() {
            return jv.hashCode(this.uri);
        }
    }

    /* renamed from: com.google.android.gms.common.images.a$b */
    public static final class C0813b extends C0182a {
        private WeakReference<ImageView> LS;

        public C0813b(ImageView imageView, int i) {
            super(null, i);
            je.m1497f(imageView);
            this.LS = new WeakReference(imageView);
        }

        public C0813b(ImageView imageView, Uri uri) {
            super(uri, 0);
            je.m1497f(imageView);
            this.LS = new WeakReference(imageView);
        }

        /* renamed from: a */
        private void m2506a(ImageView imageView, Drawable drawable, boolean z, boolean z2, boolean z3) {
            Object obj = (z2 || z3) ? null : 1;
            if (obj != null && (imageView instanceof jb)) {
                int hj = ((jb) imageView).hj();
                if (this.LL != 0 && hj == this.LL) {
                    return;
                }
            }
            boolean b = m199b(z, z2);
            Drawable newDrawable = (!this.LM || drawable == null) ? drawable : drawable.getConstantState().newDrawable();
            if (b) {
                newDrawable = m194a(imageView.getDrawable(), newDrawable);
            }
            imageView.setImageDrawable(newDrawable);
            if (imageView instanceof jb) {
                jb jbVar = (jb) imageView;
                jbVar.m1494g(z3 ? this.LJ.uri : null);
                jbVar.aB(obj != null ? this.LL : 0);
            }
            if (b) {
                ((iz) newDrawable).startTransition(250);
            }
        }

        /* renamed from: a */
        protected void mo960a(Drawable drawable, boolean z, boolean z2, boolean z3) {
            ImageView imageView = (ImageView) this.LS.get();
            if (imageView != null) {
                m2506a(imageView, drawable, z, z2, z3);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0813b)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageView imageView = (ImageView) this.LS.get();
            ImageView imageView2 = (ImageView) ((C0813b) obj).LS.get();
            boolean z = (imageView2 == null || imageView == null || !jv.equal(imageView2, imageView)) ? false : true;
            return z;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* renamed from: com.google.android.gms.common.images.a$c */
    public static final class C0814c extends C0182a {
        private WeakReference<OnImageLoadedListener> LT;

        public C0814c(OnImageLoadedListener onImageLoadedListener, Uri uri) {
            super(uri, 0);
            je.m1497f(onImageLoadedListener);
            this.LT = new WeakReference(onImageLoadedListener);
        }

        /* renamed from: a */
        protected void mo960a(Drawable drawable, boolean z, boolean z2, boolean z3) {
            if (!z2) {
                OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.LT.get();
                if (onImageLoadedListener != null) {
                    onImageLoadedListener.onImageLoaded(this.LJ.uri, drawable, z3);
                }
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0814c)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0814c c0814c = (C0814c) obj;
            OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.LT.get();
            OnImageLoadedListener onImageLoadedListener2 = (OnImageLoadedListener) c0814c.LT.get();
            boolean z = onImageLoadedListener2 != null && onImageLoadedListener != null && jv.equal(onImageLoadedListener2, onImageLoadedListener) && jv.equal(c0814c.LJ, this.LJ);
            return z;
        }

        public int hashCode() {
            return jv.hashCode(this.LJ);
        }
    }

    public C0182a(Uri uri, int i) {
        this.LJ = new C0181a(uri);
        this.LL = i;
    }

    /* renamed from: a */
    private Drawable m192a(Context context, jc jcVar, int i) {
        Resources resources = context.getResources();
        if (this.LR <= 0) {
            return resources.getDrawable(i);
        }
        C0474a c0474a = new C0474a(i, this.LR);
        Drawable drawable = (Drawable) jcVar.get(c0474a);
        if (drawable != null) {
            return drawable;
        }
        drawable = resources.getDrawable(i);
        if ((this.LR & 1) != 0) {
            drawable = m193a(resources, drawable);
        }
        jcVar.put(c0474a, drawable);
        return drawable;
    }

    /* renamed from: a */
    protected Drawable m193a(Resources resources, Drawable drawable) {
        return ja.m1492a(resources, drawable);
    }

    /* renamed from: a */
    protected iz m194a(Drawable drawable, Drawable drawable2) {
        if (drawable == null) {
            drawable = null;
        } else if (drawable instanceof iz) {
            drawable = ((iz) drawable).hh();
        }
        return new iz(drawable, drawable2);
    }

    /* renamed from: a */
    void m195a(Context context, Bitmap bitmap, boolean z) {
        je.m1497f(bitmap);
        if ((this.LR & 1) != 0) {
            bitmap = ja.m1490a(bitmap);
        }
        Drawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        if (this.LN != null) {
            this.LN.onImageLoaded(this.LJ.uri, bitmapDrawable, true);
        }
        mo960a(bitmapDrawable, z, false, true);
    }

    /* renamed from: a */
    void m196a(Context context, jc jcVar) {
        if (this.LQ) {
            Drawable drawable = null;
            if (this.LK != 0) {
                drawable = m192a(context, jcVar, this.LK);
            }
            mo960a(drawable, false, true, false);
        }
    }

    /* renamed from: a */
    void m197a(Context context, jc jcVar, boolean z) {
        Drawable drawable = null;
        if (this.LL != 0) {
            drawable = m192a(context, jcVar, this.LL);
        }
        if (this.LN != null) {
            this.LN.onImageLoaded(this.LJ.uri, drawable, false);
        }
        mo960a(drawable, z, false, false);
    }

    /* renamed from: a */
    protected abstract void mo960a(Drawable drawable, boolean z, boolean z2, boolean z3);

    public void az(int i) {
        this.LL = i;
    }

    /* renamed from: b */
    protected boolean m199b(boolean z, boolean z2) {
        return this.LO && !z2 && (!z || this.LP);
    }
}
