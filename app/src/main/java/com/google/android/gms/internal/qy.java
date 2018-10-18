package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

final class qy {
    final byte[] azi;
    final int tag;

    qy(int i, byte[] bArr) {
        this.tag = i;
        this.azi = bArr;
    }

    /* renamed from: a */
    void m1913a(qp qpVar) throws IOException {
        qpVar.hd(this.tag);
        qpVar.m1881t(this.azi);
    }

    /* renamed from: c */
    int m1914c() {
        return (0 + qp.he(this.tag)) + this.azi.length;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof qy)) {
            return false;
        }
        qy qyVar = (qy) o;
        return this.tag == qyVar.tag && Arrays.equals(this.azi, qyVar.azi);
    }

    public int hashCode() {
        return ((this.tag + 527) * 31) + Arrays.hashCode(this.azi);
    }
}
