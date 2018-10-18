package com.google.android.gms.internal;

import java.io.IOException;

public abstract class qq<M extends qq<M>> extends qw {
    protected qs ayW;

    /* renamed from: a */
    public final <T> T m3536a(qr<M, T> qrVar) {
        if (this.ayW == null) {
            return null;
        }
        qt hh = this.ayW.hh(qz.hl(qrVar.tag));
        return hh != null ? hh.m1901b(qrVar) : null;
    }

    /* renamed from: a */
    public void mo2113a(qp qpVar) throws IOException {
        if (this.ayW != null) {
            for (int i = 0; i < this.ayW.size(); i++) {
                this.ayW.hi(i).m1899a(qpVar);
            }
        }
    }

    /* renamed from: a */
    protected final boolean m3538a(qo qoVar, int i) throws IOException {
        int position = qoVar.getPosition();
        if (!qoVar.gQ(i)) {
            return false;
        }
        int hl = qz.hl(i);
        qy qyVar = new qy(i, qoVar.m1836s(position, qoVar.getPosition() - position));
        qt qtVar = null;
        if (this.ayW == null) {
            this.ayW = new qs();
        } else {
            qtVar = this.ayW.hh(hl);
        }
        if (qtVar == null) {
            qtVar = new qt();
            this.ayW.m1898a(hl, qtVar);
        }
        qtVar.m1900a(qyVar);
        return true;
    }

    /* renamed from: a */
    protected final boolean m3539a(M m) {
        return (this.ayW == null || this.ayW.isEmpty()) ? m.ayW == null || m.ayW.isEmpty() : this.ayW.equals(m.ayW);
    }

    /* renamed from: c */
    protected int mo2114c() {
        int i = 0;
        if (this.ayW == null) {
            return 0;
        }
        int i2 = 0;
        while (i < this.ayW.size()) {
            i2 += this.ayW.hi(i).m1902c();
            i++;
        }
        return i2;
    }

    protected final int rQ() {
        return (this.ayW == null || this.ayW.isEmpty()) ? 0 : this.ayW.hashCode();
    }
}
