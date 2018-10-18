package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class qp {
    private final int ayV;
    private final byte[] buffer;
    private int position;

    /* renamed from: com.google.android.gms.internal.qp$a */
    public static class C0500a extends IOException {
        C0500a(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    private qp(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.position = i;
        this.ayV = i + i2;
    }

    /* renamed from: D */
    public static int m1837D(long j) {
        return m1839G(j);
    }

    /* renamed from: E */
    public static int m1838E(long j) {
        return m1839G(m1840I(j));
    }

    /* renamed from: G */
    public static int m1839G(long j) {
        return (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    /* renamed from: I */
    public static long m1840I(long j) {
        return (j << 1) ^ (j >> 63);
    }

    /* renamed from: X */
    public static int m1841X(boolean z) {
        return 1;
    }

    /* renamed from: b */
    public static int m1842b(int i, double d) {
        return hc(i) + m1854f(d);
    }

    /* renamed from: b */
    public static int m1843b(int i, qw qwVar) {
        return (hc(i) * 2) + m1850d(qwVar);
    }

    /* renamed from: b */
    public static int m1844b(int i, byte[] bArr) {
        return hc(i) + m1857s(bArr);
    }

    /* renamed from: b */
    public static qp m1845b(byte[] bArr, int i, int i2) {
        return new qp(bArr, i, i2);
    }

    /* renamed from: c */
    public static int m1846c(int i, float f) {
        return hc(i) + m1851e(f);
    }

    /* renamed from: c */
    public static int m1847c(int i, qw qwVar) {
        return hc(i) + m1853e(qwVar);
    }

    /* renamed from: c */
    public static int m1848c(int i, boolean z) {
        return hc(i) + m1841X(z);
    }

    /* renamed from: d */
    public static int m1849d(int i, long j) {
        return hc(i) + m1837D(j);
    }

    /* renamed from: d */
    public static int m1850d(qw qwVar) {
        return qwVar.rZ();
    }

    public static int dk(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return bytes.length + he(bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    /* renamed from: e */
    public static int m1851e(float f) {
        return 4;
    }

    /* renamed from: e */
    public static int m1852e(int i, long j) {
        return hc(i) + m1838E(j);
    }

    /* renamed from: e */
    public static int m1853e(qw qwVar) {
        int rZ = qwVar.rZ();
        return rZ + he(rZ);
    }

    /* renamed from: f */
    public static int m1854f(double d) {
        return 8;
    }

    public static int gZ(int i) {
        return i >= 0 ? he(i) : 10;
    }

    public static int ha(int i) {
        return he(hg(i));
    }

    public static int hc(int i) {
        return he(qz.m1916y(i, 0));
    }

    public static int he(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (-268435456 & i) == 0 ? 4 : 5;
    }

    public static int hg(int i) {
        return (i << 1) ^ (i >> 31);
    }

    /* renamed from: j */
    public static int m1855j(int i, String str) {
        return hc(i) + dk(str);
    }

    /* renamed from: q */
    public static qp m1856q(byte[] bArr) {
        return m1845b(bArr, 0, bArr.length);
    }

    /* renamed from: s */
    public static int m1857s(byte[] bArr) {
        return he(bArr.length) + bArr.length;
    }

    /* renamed from: v */
    public static int m1858v(int i, int i2) {
        return hc(i) + gZ(i2);
    }

    /* renamed from: w */
    public static int m1859w(int i, int i2) {
        return hc(i) + ha(i2);
    }

    /* renamed from: B */
    public void m1860B(long j) throws IOException {
        m1862F(j);
    }

    /* renamed from: C */
    public void m1861C(long j) throws IOException {
        m1862F(m1840I(j));
    }

    /* renamed from: F */
    public void m1862F(long j) throws IOException {
        while ((-128 & j) != 0) {
            hb((((int) j) & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            j >>>= 7;
        }
        hb((int) j);
    }

    /* renamed from: H */
    public void m1863H(long j) throws IOException {
        hb(((int) j) & MotionEventCompat.ACTION_MASK);
        hb(((int) (j >> 8)) & MotionEventCompat.ACTION_MASK);
        hb(((int) (j >> 16)) & MotionEventCompat.ACTION_MASK);
        hb(((int) (j >> 24)) & MotionEventCompat.ACTION_MASK);
        hb(((int) (j >> 32)) & MotionEventCompat.ACTION_MASK);
        hb(((int) (j >> 40)) & MotionEventCompat.ACTION_MASK);
        hb(((int) (j >> 48)) & MotionEventCompat.ACTION_MASK);
        hb(((int) (j >> 56)) & MotionEventCompat.ACTION_MASK);
    }

    /* renamed from: W */
    public void m1864W(boolean z) throws IOException {
        hb(z ? 1 : 0);
    }

    /* renamed from: a */
    public void m1865a(int i, double d) throws IOException {
        m1883x(i, 1);
        m1878e(d);
    }

    /* renamed from: a */
    public void m1866a(int i, qw qwVar) throws IOException {
        m1883x(i, 2);
        m1875c(qwVar);
    }

    /* renamed from: a */
    public void m1867a(int i, byte[] bArr) throws IOException {
        m1883x(i, 2);
        m1879r(bArr);
    }

    /* renamed from: b */
    public void m1868b(byte b) throws IOException {
        if (this.position == this.ayV) {
            throw new C0500a(this.position, this.ayV);
        }
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = b;
    }

    /* renamed from: b */
    public void m1869b(int i, float f) throws IOException {
        m1883x(i, 5);
        m1877d(f);
    }

    /* renamed from: b */
    public void m1870b(int i, long j) throws IOException {
        m1883x(i, 0);
        m1860B(j);
    }

    /* renamed from: b */
    public void m1871b(int i, String str) throws IOException {
        m1883x(i, 2);
        dj(str);
    }

    /* renamed from: b */
    public void m1872b(int i, boolean z) throws IOException {
        m1883x(i, 0);
        m1864W(z);
    }

    /* renamed from: b */
    public void m1873b(qw qwVar) throws IOException {
        qwVar.mo2113a(this);
    }

    /* renamed from: c */
    public void m1874c(int i, long j) throws IOException {
        m1883x(i, 0);
        m1861C(j);
    }

    /* renamed from: c */
    public void m1875c(qw qwVar) throws IOException {
        hd(qwVar.rY());
        qwVar.mo2113a(this);
    }

    /* renamed from: c */
    public void m1876c(byte[] bArr, int i, int i2) throws IOException {
        if (this.ayV - this.position >= i2) {
            System.arraycopy(bArr, i, this.buffer, this.position, i2);
            this.position += i2;
            return;
        }
        throw new C0500a(this.position, this.ayV);
    }

    /* renamed from: d */
    public void m1877d(float f) throws IOException {
        hf(Float.floatToIntBits(f));
    }

    public void dj(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        hd(bytes.length);
        m1881t(bytes);
    }

    /* renamed from: e */
    public void m1878e(double d) throws IOException {
        m1863H(Double.doubleToLongBits(d));
    }

    public void gX(int i) throws IOException {
        if (i >= 0) {
            hd(i);
        } else {
            m1862F((long) i);
        }
    }

    public void gY(int i) throws IOException {
        hd(hg(i));
    }

    public void hb(int i) throws IOException {
        m1868b((byte) i);
    }

    public void hd(int i) throws IOException {
        while ((i & -128) != 0) {
            hb((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            i >>>= 7;
        }
        hb(i);
    }

    public void hf(int i) throws IOException {
        hb(i & MotionEventCompat.ACTION_MASK);
        hb((i >> 8) & MotionEventCompat.ACTION_MASK);
        hb((i >> 16) & MotionEventCompat.ACTION_MASK);
        hb((i >> 24) & MotionEventCompat.ACTION_MASK);
    }

    /* renamed from: r */
    public void m1879r(byte[] bArr) throws IOException {
        hd(bArr.length);
        m1881t(bArr);
    }

    public int rO() {
        return this.ayV - this.position;
    }

    public void rP() {
        if (rO() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: t */
    public void m1880t(int i, int i2) throws IOException {
        m1883x(i, 0);
        gX(i2);
    }

    /* renamed from: t */
    public void m1881t(byte[] bArr) throws IOException {
        m1876c(bArr, 0, bArr.length);
    }

    /* renamed from: u */
    public void m1882u(int i, int i2) throws IOException {
        m1883x(i, 0);
        gY(i2);
    }

    /* renamed from: x */
    public void m1883x(int i, int i2) throws IOException {
        hd(qz.m1916y(i, i2));
    }
}
