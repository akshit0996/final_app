package com.google.android.gms.internal;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.p */
class C1062p implements C0489n {
    private qp lb;
    private byte[] lc;
    private final int ld;

    public C1062p(int i) {
        this.ld = i;
        reset();
    }

    /* renamed from: D */
    public byte[] mo2062D() throws IOException {
        int rO = this.lb.rO();
        if (rO < 0) {
            throw new IOException();
        } else if (rO == 0) {
            return this.lc;
        } else {
            Object obj = new byte[(this.lc.length - rO)];
            System.arraycopy(this.lc, 0, obj, 0, obj.length);
            return obj;
        }
    }

    /* renamed from: b */
    public void mo2063b(int i, long j) throws IOException {
        this.lb.m1870b(i, j);
    }

    /* renamed from: b */
    public void mo2064b(int i, String str) throws IOException {
        this.lb.m1871b(i, str);
    }

    public void reset() {
        this.lc = new byte[this.ld];
        this.lb = qp.m1856q(this.lc);
    }
}
