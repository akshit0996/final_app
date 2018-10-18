package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* renamed from: com.google.android.gms.internal.h */
public abstract class C0973h implements C0434g {
    protected MotionEvent kw;
    protected DisplayMetrics kx;
    protected C0487m ky;
    private C0489n kz;

    protected C0973h(Context context, C0487m c0487m, C0489n c0489n) {
        this.ky = c0487m;
        this.kz = c0489n;
        try {
            this.kx = context.getResources().getDisplayMetrics();
        } catch (UnsupportedOperationException e) {
            this.kx = new DisplayMetrics();
            this.kx.density = 1.0f;
        }
    }

    /* renamed from: a */
    private String m3212a(Context context, String str, boolean z) {
        try {
            byte[] u;
            synchronized (this) {
                m3213t();
                if (z) {
                    mo3328c(context);
                } else {
                    mo3327b(context);
                }
                u = m3214u();
            }
            return u.length == 0 ? Integer.toString(5) : m3217a(u, str);
        } catch (NoSuchAlgorithmException e) {
            return Integer.toString(7);
        } catch (UnsupportedEncodingException e2) {
            return Integer.toString(7);
        } catch (IOException e3) {
            return Integer.toString(3);
        }
    }

    /* renamed from: t */
    private void m3213t() {
        this.kz.reset();
    }

    /* renamed from: u */
    private byte[] m3214u() throws IOException {
        return this.kz.mo2062D();
    }

    /* renamed from: a */
    public String mo1798a(Context context) {
        return m3212a(context, null, false);
    }

    /* renamed from: a */
    public String mo1799a(Context context, String str) {
        return m3212a(context, str, true);
    }

    /* renamed from: a */
    String m3217a(byte[] bArr, String str) throws NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
        byte[] bArr2;
        if (bArr.length > 239) {
            m3213t();
            m3219a(20, 1);
            bArr = m3214u();
        }
        if (bArr.length < 239) {
            bArr2 = new byte[(239 - bArr.length)];
            new SecureRandom().nextBytes(bArr2);
            bArr2 = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            bArr2 = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).array();
        }
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(bArr2);
        bArr2 = ByteBuffer.allocate(256).put(instance.digest()).put(bArr2).array();
        byte[] bArr3 = new byte[256];
        new C0415f().m1191a(bArr2, bArr3);
        if (str != null && str.length() > 0) {
            m3222a(str, bArr3);
        }
        return this.ky.mo1763a(bArr3, true);
    }

    /* renamed from: a */
    public void mo1800a(int i, int i2, int i3) {
        if (this.kw != null) {
            this.kw.recycle();
        }
        this.kw = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * this.kx.density, ((float) i2) * this.kx.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
    }

    /* renamed from: a */
    protected void m3219a(int i, long j) throws IOException {
        this.kz.mo2063b(i, j);
    }

    /* renamed from: a */
    protected void m3220a(int i, String str) throws IOException {
        this.kz.mo2064b(i, str);
    }

    /* renamed from: a */
    public void mo1801a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.kw != null) {
                this.kw.recycle();
            }
            this.kw = MotionEvent.obtain(motionEvent);
        }
    }

    /* renamed from: a */
    void m3222a(String str, byte[] bArr) throws UnsupportedEncodingException {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        new qn(str.getBytes("UTF-8")).m1830o(bArr);
    }

    /* renamed from: b */
    protected abstract void mo3327b(Context context);

    /* renamed from: c */
    protected abstract void mo3328c(Context context);
}
