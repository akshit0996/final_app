package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.qo;
import com.google.android.gms.internal.qp;
import com.google.android.gms.internal.qq;
import com.google.android.gms.internal.qv;
import com.google.android.gms.internal.qw;
import java.io.IOException;

public final class ak extends qq<ak> {
    public String QG;
    public long QH;
    public long QI;
    public int versionCode;

    public ak() {
        iK();
    }

    /* renamed from: g */
    public static ak m3949g(byte[] bArr) throws qv {
        return (ak) qw.m1903a(new ak(), bArr);
    }

    /* renamed from: a */
    public void mo2113a(qp qpVar) throws IOException {
        qpVar.m1880t(1, this.versionCode);
        qpVar.m1871b(2, this.QG);
        qpVar.m1874c(3, this.QH);
        qpVar.m1874c(4, this.QI);
        super.mo2113a(qpVar);
    }

    /* renamed from: b */
    public /* synthetic */ qw mo2964b(qo qoVar) throws IOException {
        return m3953m(qoVar);
    }

    /* renamed from: c */
    protected int mo2114c() {
        return (((super.mo2114c() + qp.m1858v(1, this.versionCode)) + qp.m1855j(2, this.QG)) + qp.m1852e(3, this.QH)) + qp.m1852e(4, this.QI);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ak)) {
            return false;
        }
        ak akVar = (ak) o;
        if (this.versionCode != akVar.versionCode) {
            return false;
        }
        if (this.QG == null) {
            if (akVar.QG != null) {
                return false;
            }
        } else if (!this.QG.equals(akVar.QG)) {
            return false;
        }
        return (this.QH == akVar.QH && this.QI == akVar.QI) ? m3539a((qq) akVar) : false;
    }

    public int hashCode() {
        return (((((((this.QG == null ? 0 : this.QG.hashCode()) + ((this.versionCode + 527) * 31)) * 31) + ((int) (this.QH ^ (this.QH >>> 32)))) * 31) + ((int) (this.QI ^ (this.QI >>> 32)))) * 31) + rQ();
    }

    public ak iK() {
        this.versionCode = 1;
        this.QG = "";
        this.QH = -1;
        this.QI = -1;
        this.ayW = null;
        this.azh = -1;
        return this;
    }

    /* renamed from: m */
    public ak m3953m(qo qoVar) throws IOException {
        while (true) {
            int rz = qoVar.rz();
            switch (rz) {
                case 0:
                    break;
                case 8:
                    this.versionCode = qoVar.rC();
                    continue;
                case 18:
                    this.QG = qoVar.readString();
                    continue;
                case 24:
                    this.QH = qoVar.rF();
                    continue;
                case 32:
                    this.QI = qoVar.rF();
                    continue;
                default:
                    if (!m3538a(qoVar, rz)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }
}
