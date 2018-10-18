package com.google.android.gms.internal;

import java.io.IOException;

public abstract class qw {
    protected volatile int azh = -1;

    /* renamed from: a */
    public static final <T extends qw> T m1903a(T t, byte[] bArr) throws qv {
        return m1905b(t, bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static final void m1904a(qw qwVar, byte[] bArr, int i, int i2) {
        try {
            qp b = qp.m1845b(bArr, i, i2);
            qwVar.mo2113a(b);
            b.rP();
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    /* renamed from: b */
    public static final <T extends qw> T m1905b(T t, byte[] bArr, int i, int i2) throws qv {
        try {
            qo a = qo.m1832a(bArr, i, i2);
            t.mo2964b(a);
            a.gP(0);
            return t;
        } catch (qv e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    /* renamed from: f */
    public static final byte[] m1906f(qw qwVar) {
        byte[] bArr = new byte[qwVar.rZ()];
        m1904a(qwVar, bArr, 0, bArr.length);
        return bArr;
    }

    /* renamed from: a */
    public void mo2113a(qp qpVar) throws IOException {
    }

    /* renamed from: b */
    public abstract qw mo2964b(qo qoVar) throws IOException;

    /* renamed from: c */
    protected int mo2114c() {
        return 0;
    }

    public int rY() {
        if (this.azh < 0) {
            rZ();
        }
        return this.azh;
    }

    public int rZ() {
        int c = mo2114c();
        this.azh = c;
        return c;
    }

    public String toString() {
        return qx.m1912g(this);
    }
}
