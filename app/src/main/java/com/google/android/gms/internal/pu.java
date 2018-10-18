package com.google.android.gms.internal;

import com.google.android.gms.internal.C0381c.C1383f;
import com.google.android.gms.internal.C0381c.C1387j;
import java.io.IOException;

public interface pu {

    /* renamed from: com.google.android.gms.internal.pu$a */
    public static final class C1431a extends qq<C1431a> {
        public long auB;
        public C1387j auC;
        public C1383f gs;

        public C1431a() {
            rc();
        }

        /* renamed from: l */
        public static C1431a m4540l(byte[] bArr) throws qv {
            return (C1431a) qw.m1903a(new C1431a(), bArr);
        }

        /* renamed from: a */
        public void mo2113a(qp qpVar) throws IOException {
            qpVar.m1870b(1, this.auB);
            if (this.gs != null) {
                qpVar.m1866a(2, this.gs);
            }
            if (this.auC != null) {
                qpVar.m1866a(3, this.auC);
            }
            super.mo2113a(qpVar);
        }

        /* renamed from: b */
        public /* synthetic */ qw mo2964b(qo qoVar) throws IOException {
            return m4544s(qoVar);
        }

        /* renamed from: c */
        protected int mo2114c() {
            int c = super.mo2114c() + qp.m1849d(1, this.auB);
            if (this.gs != null) {
                c += qp.m1847c(2, this.gs);
            }
            return this.auC != null ? c + qp.m1847c(3, this.auC) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1431a)) {
                return false;
            }
            C1431a c1431a = (C1431a) o;
            if (this.auB != c1431a.auB) {
                return false;
            }
            if (this.gs == null) {
                if (c1431a.gs != null) {
                    return false;
                }
            } else if (!this.gs.equals(c1431a.gs)) {
                return false;
            }
            if (this.auC == null) {
                if (c1431a.auC != null) {
                    return false;
                }
            } else if (!this.auC.equals(c1431a.auC)) {
                return false;
            }
            return m3539a((qq) c1431a);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.gs == null ? 0 : this.gs.hashCode()) + ((((int) (this.auB ^ (this.auB >>> 32))) + 527) * 31)) * 31;
            if (this.auC != null) {
                i = this.auC.hashCode();
            }
            return ((hashCode + i) * 31) + rQ();
        }

        public C1431a rc() {
            this.auB = 0;
            this.gs = null;
            this.auC = null;
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        /* renamed from: s */
        public C1431a m4544s(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case 0:
                        break;
                    case 8:
                        this.auB = qoVar.rB();
                        continue;
                    case 18:
                        if (this.gs == null) {
                            this.gs = new C1383f();
                        }
                        qoVar.m1834a(this.gs);
                        continue;
                    case 26:
                        if (this.auC == null) {
                            this.auC = new C1387j();
                        }
                        qoVar.m1834a(this.auC);
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
}
