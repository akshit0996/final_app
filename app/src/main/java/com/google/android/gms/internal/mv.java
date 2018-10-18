package com.google.android.gms.internal;

import java.io.IOException;

public interface mv {

    /* renamed from: com.google.android.gms.internal.mv$a */
    public static final class C1411a extends qq<C1411a> {
        public C1410a[] afu;

        /* renamed from: com.google.android.gms.internal.mv$a$a */
        public static final class C1410a extends qq<C1410a> {
            private static volatile C1410a[] afv;
            public String afw;
            public String afx;
            public int viewId;

            public C1410a() {
                mY();
            }

            public static C1410a[] mX() {
                if (afv == null) {
                    synchronized (qu.azg) {
                        if (afv == null) {
                            afv = new C1410a[0];
                        }
                    }
                }
                return afv;
            }

            /* renamed from: a */
            public void mo2113a(qp qpVar) throws IOException {
                if (!this.afw.equals("")) {
                    qpVar.m1871b(1, this.afw);
                }
                if (!this.afx.equals("")) {
                    qpVar.m1871b(2, this.afx);
                }
                if (this.viewId != 0) {
                    qpVar.m1880t(3, this.viewId);
                }
                super.mo2113a(qpVar);
            }

            /* renamed from: b */
            public /* synthetic */ qw mo2964b(qo qoVar) throws IOException {
                return m4477o(qoVar);
            }

            /* renamed from: c */
            protected int mo2114c() {
                int c = super.mo2114c();
                if (!this.afw.equals("")) {
                    c += qp.m1855j(1, this.afw);
                }
                if (!this.afx.equals("")) {
                    c += qp.m1855j(2, this.afx);
                }
                return this.viewId != 0 ? c + qp.m1858v(3, this.viewId) : c;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof C1410a)) {
                    return false;
                }
                C1410a c1410a = (C1410a) o;
                if (this.afw == null) {
                    if (c1410a.afw != null) {
                        return false;
                    }
                } else if (!this.afw.equals(c1410a.afw)) {
                    return false;
                }
                if (this.afx == null) {
                    if (c1410a.afx != null) {
                        return false;
                    }
                } else if (!this.afx.equals(c1410a.afx)) {
                    return false;
                }
                return this.viewId == c1410a.viewId ? m3539a((qq) c1410a) : false;
            }

            public int hashCode() {
                int i = 0;
                int hashCode = ((this.afw == null ? 0 : this.afw.hashCode()) + 527) * 31;
                if (this.afx != null) {
                    i = this.afx.hashCode();
                }
                return ((((hashCode + i) * 31) + this.viewId) * 31) + rQ();
            }

            public C1410a mY() {
                this.afw = "";
                this.afx = "";
                this.viewId = 0;
                this.ayW = null;
                this.azh = -1;
                return this;
            }

            /* renamed from: o */
            public C1410a m4477o(qo qoVar) throws IOException {
                while (true) {
                    int rz = qoVar.rz();
                    switch (rz) {
                        case 0:
                            break;
                        case 10:
                            this.afw = qoVar.readString();
                            continue;
                        case 18:
                            this.afx = qoVar.readString();
                            continue;
                        case 24:
                            this.viewId = qoVar.rC();
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

        public C1411a() {
            mW();
        }

        /* renamed from: a */
        public void mo2113a(qp qpVar) throws IOException {
            if (this.afu != null && this.afu.length > 0) {
                for (qw qwVar : this.afu) {
                    if (qwVar != null) {
                        qpVar.m1866a(1, qwVar);
                    }
                }
            }
            super.mo2113a(qpVar);
        }

        /* renamed from: b */
        public /* synthetic */ qw mo2964b(qo qoVar) throws IOException {
            return m4481n(qoVar);
        }

        /* renamed from: c */
        protected int mo2114c() {
            int c = super.mo2114c();
            if (this.afu != null && this.afu.length > 0) {
                for (qw qwVar : this.afu) {
                    if (qwVar != null) {
                        c += qp.m1847c(1, qwVar);
                    }
                }
            }
            return c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1411a)) {
                return false;
            }
            C1411a c1411a = (C1411a) o;
            return qu.equals(this.afu, c1411a.afu) ? m3539a((qq) c1411a) : false;
        }

        public int hashCode() {
            return ((qu.hashCode(this.afu) + 527) * 31) + rQ();
        }

        public C1411a mW() {
            this.afu = C1410a.mX();
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        /* renamed from: n */
        public C1411a m4481n(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case 0:
                        break;
                    case 10:
                        int b = qz.m1915b(qoVar, 10);
                        rz = this.afu == null ? 0 : this.afu.length;
                        Object obj = new C1410a[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.afu, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1410a();
                            qoVar.m1834a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1410a();
                        qoVar.m1834a(obj[rz]);
                        this.afu = obj;
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

    /* renamed from: com.google.android.gms.internal.mv$b */
    public static final class C1412b extends qq<C1412b> {
        private static volatile C1412b[] afy;
        public C1414d afz;
        public String name;

        public C1412b() {
            na();
        }

        public static C1412b[] mZ() {
            if (afy == null) {
                synchronized (qu.azg) {
                    if (afy == null) {
                        afy = new C1412b[0];
                    }
                }
            }
            return afy;
        }

        /* renamed from: a */
        public void mo2113a(qp qpVar) throws IOException {
            if (!this.name.equals("")) {
                qpVar.m1871b(1, this.name);
            }
            if (this.afz != null) {
                qpVar.m1866a(2, this.afz);
            }
            super.mo2113a(qpVar);
        }

        /* renamed from: b */
        public /* synthetic */ qw mo2964b(qo qoVar) throws IOException {
            return m4485p(qoVar);
        }

        /* renamed from: c */
        protected int mo2114c() {
            int c = super.mo2114c();
            if (!this.name.equals("")) {
                c += qp.m1855j(1, this.name);
            }
            return this.afz != null ? c + qp.m1847c(2, this.afz) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1412b)) {
                return false;
            }
            C1412b c1412b = (C1412b) o;
            if (this.name == null) {
                if (c1412b.name != null) {
                    return false;
                }
            } else if (!this.name.equals(c1412b.name)) {
                return false;
            }
            if (this.afz == null) {
                if (c1412b.afz != null) {
                    return false;
                }
            } else if (!this.afz.equals(c1412b.afz)) {
                return false;
            }
            return m3539a((qq) c1412b);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.name == null ? 0 : this.name.hashCode()) + 527) * 31;
            if (this.afz != null) {
                i = this.afz.hashCode();
            }
            return ((hashCode + i) * 31) + rQ();
        }

        public C1412b na() {
            this.name = "";
            this.afz = null;
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        /* renamed from: p */
        public C1412b m4485p(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case 0:
                        break;
                    case 10:
                        this.name = qoVar.readString();
                        continue;
                    case 18:
                        if (this.afz == null) {
                            this.afz = new C1414d();
                        }
                        qoVar.m1834a(this.afz);
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

    /* renamed from: com.google.android.gms.internal.mv$c */
    public static final class C1413c extends qq<C1413c> {
        public C1412b[] afA;
        public String type;

        public C1413c() {
            nb();
        }

        /* renamed from: a */
        public void mo2113a(qp qpVar) throws IOException {
            if (!this.type.equals("")) {
                qpVar.m1871b(1, this.type);
            }
            if (this.afA != null && this.afA.length > 0) {
                for (qw qwVar : this.afA) {
                    if (qwVar != null) {
                        qpVar.m1866a(2, qwVar);
                    }
                }
            }
            super.mo2113a(qpVar);
        }

        /* renamed from: b */
        public /* synthetic */ qw mo2964b(qo qoVar) throws IOException {
            return m4489q(qoVar);
        }

        /* renamed from: c */
        protected int mo2114c() {
            int c = super.mo2114c();
            if (!this.type.equals("")) {
                c += qp.m1855j(1, this.type);
            }
            if (this.afA == null || this.afA.length <= 0) {
                return c;
            }
            int i = c;
            for (qw qwVar : this.afA) {
                if (qwVar != null) {
                    i += qp.m1847c(2, qwVar);
                }
            }
            return i;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1413c)) {
                return false;
            }
            C1413c c1413c = (C1413c) o;
            if (this.type == null) {
                if (c1413c.type != null) {
                    return false;
                }
            } else if (!this.type.equals(c1413c.type)) {
                return false;
            }
            return qu.equals(this.afA, c1413c.afA) ? m3539a((qq) c1413c) : false;
        }

        public int hashCode() {
            return (((((this.type == null ? 0 : this.type.hashCode()) + 527) * 31) + qu.hashCode(this.afA)) * 31) + rQ();
        }

        public C1413c nb() {
            this.type = "";
            this.afA = C1412b.mZ();
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        /* renamed from: q */
        public C1413c m4489q(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case 0:
                        break;
                    case 10:
                        this.type = qoVar.readString();
                        continue;
                    case 18:
                        int b = qz.m1915b(qoVar, 18);
                        rz = this.afA == null ? 0 : this.afA.length;
                        Object obj = new C1412b[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.afA, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1412b();
                            qoVar.m1834a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1412b();
                        qoVar.m1834a(obj[rz]);
                        this.afA = obj;
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

    /* renamed from: com.google.android.gms.internal.mv$d */
    public static final class C1414d extends qq<C1414d> {
        public String NJ;
        public boolean afB;
        public long afC;
        public double afD;
        public C1413c afE;

        public C1414d() {
            nc();
        }

        /* renamed from: a */
        public void mo2113a(qp qpVar) throws IOException {
            if (this.afB) {
                qpVar.m1872b(1, this.afB);
            }
            if (!this.NJ.equals("")) {
                qpVar.m1871b(2, this.NJ);
            }
            if (this.afC != 0) {
                qpVar.m1870b(3, this.afC);
            }
            if (Double.doubleToLongBits(this.afD) != Double.doubleToLongBits(0.0d)) {
                qpVar.m1865a(4, this.afD);
            }
            if (this.afE != null) {
                qpVar.m1866a(5, this.afE);
            }
            super.mo2113a(qpVar);
        }

        /* renamed from: b */
        public /* synthetic */ qw mo2964b(qo qoVar) throws IOException {
            return m4493r(qoVar);
        }

        /* renamed from: c */
        protected int mo2114c() {
            int c = super.mo2114c();
            if (this.afB) {
                c += qp.m1848c(1, this.afB);
            }
            if (!this.NJ.equals("")) {
                c += qp.m1855j(2, this.NJ);
            }
            if (this.afC != 0) {
                c += qp.m1849d(3, this.afC);
            }
            if (Double.doubleToLongBits(this.afD) != Double.doubleToLongBits(0.0d)) {
                c += qp.m1842b(4, this.afD);
            }
            return this.afE != null ? c + qp.m1847c(5, this.afE) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1414d)) {
                return false;
            }
            C1414d c1414d = (C1414d) o;
            if (this.afB != c1414d.afB) {
                return false;
            }
            if (this.NJ == null) {
                if (c1414d.NJ != null) {
                    return false;
                }
            } else if (!this.NJ.equals(c1414d.NJ)) {
                return false;
            }
            if (this.afC != c1414d.afC || Double.doubleToLongBits(this.afD) != Double.doubleToLongBits(c1414d.afD)) {
                return false;
            }
            if (this.afE == null) {
                if (c1414d.afE != null) {
                    return false;
                }
            } else if (!this.afE.equals(c1414d.afE)) {
                return false;
            }
            return m3539a((qq) c1414d);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = (((this.NJ == null ? 0 : this.NJ.hashCode()) + (((this.afB ? 1231 : 1237) + 527) * 31)) * 31) + ((int) (this.afC ^ (this.afC >>> 32)));
            long doubleToLongBits = Double.doubleToLongBits(this.afD);
            hashCode = ((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
            if (this.afE != null) {
                i = this.afE.hashCode();
            }
            return ((hashCode + i) * 31) + rQ();
        }

        public C1414d nc() {
            this.afB = false;
            this.NJ = "";
            this.afC = 0;
            this.afD = 0.0d;
            this.afE = null;
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        /* renamed from: r */
        public C1414d m4493r(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case 0:
                        break;
                    case 8:
                        this.afB = qoVar.rD();
                        continue;
                    case 18:
                        this.NJ = qoVar.readString();
                        continue;
                    case 24:
                        this.afC = qoVar.rB();
                        continue;
                    case 33:
                        this.afD = qoVar.readDouble();
                        continue;
                    case 42:
                        if (this.afE == null) {
                            this.afE = new C1413c();
                        }
                        qoVar.m1834a(this.afE);
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
