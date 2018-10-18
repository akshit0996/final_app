package com.google.android.gms.internal;

import com.google.ads.AdSize;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.d */
public interface C0386d {

    /* renamed from: com.google.android.gms.internal.d$a */
    public static final class C1389a extends qq<C1389a> {
        private static volatile C1389a[] gu;
        public String gA;
        public long gB;
        public boolean gC;
        public C1389a[] gD;
        public int[] gE;
        public boolean gF;
        public String gv;
        public C1389a[] gw;
        public C1389a[] gx;
        public C1389a[] gy;
        public String gz;
        public int type;

        public C1389a() {
            m4346s();
        }

        /* renamed from: r */
        public static C1389a[] m4341r() {
            if (gu == null) {
                synchronized (qu.azg) {
                    if (gu == null) {
                        gu = new C1389a[0];
                    }
                }
            }
            return gu;
        }

        /* renamed from: a */
        public void mo2113a(qp qpVar) throws IOException {
            int i = 0;
            qpVar.m1880t(1, this.type);
            if (!this.gv.equals("")) {
                qpVar.m1871b(2, this.gv);
            }
            if (this.gw != null && this.gw.length > 0) {
                for (qw qwVar : this.gw) {
                    if (qwVar != null) {
                        qpVar.m1866a(3, qwVar);
                    }
                }
            }
            if (this.gx != null && this.gx.length > 0) {
                for (qw qwVar2 : this.gx) {
                    if (qwVar2 != null) {
                        qpVar.m1866a(4, qwVar2);
                    }
                }
            }
            if (this.gy != null && this.gy.length > 0) {
                for (qw qwVar22 : this.gy) {
                    if (qwVar22 != null) {
                        qpVar.m1866a(5, qwVar22);
                    }
                }
            }
            if (!this.gz.equals("")) {
                qpVar.m1871b(6, this.gz);
            }
            if (!this.gA.equals("")) {
                qpVar.m1871b(7, this.gA);
            }
            if (this.gB != 0) {
                qpVar.m1870b(8, this.gB);
            }
            if (this.gF) {
                qpVar.m1872b(9, this.gF);
            }
            if (this.gE != null && this.gE.length > 0) {
                for (int t : this.gE) {
                    qpVar.m1880t(10, t);
                }
            }
            if (this.gD != null && this.gD.length > 0) {
                while (i < this.gD.length) {
                    qw qwVar3 = this.gD[i];
                    if (qwVar3 != null) {
                        qpVar.m1866a(11, qwVar3);
                    }
                    i++;
                }
            }
            if (this.gC) {
                qpVar.m1872b(12, this.gC);
            }
            super.mo2113a(qpVar);
        }

        /* renamed from: b */
        public /* synthetic */ qw mo2964b(qo qoVar) throws IOException {
            return m4345l(qoVar);
        }

        /* renamed from: c */
        protected int mo2114c() {
            int i;
            int i2 = 0;
            int c = super.mo2114c() + qp.m1858v(1, this.type);
            if (!this.gv.equals("")) {
                c += qp.m1855j(2, this.gv);
            }
            if (this.gw != null && this.gw.length > 0) {
                i = c;
                for (qw qwVar : this.gw) {
                    if (qwVar != null) {
                        i += qp.m1847c(3, qwVar);
                    }
                }
                c = i;
            }
            if (this.gx != null && this.gx.length > 0) {
                i = c;
                for (qw qwVar2 : this.gx) {
                    if (qwVar2 != null) {
                        i += qp.m1847c(4, qwVar2);
                    }
                }
                c = i;
            }
            if (this.gy != null && this.gy.length > 0) {
                i = c;
                for (qw qwVar22 : this.gy) {
                    if (qwVar22 != null) {
                        i += qp.m1847c(5, qwVar22);
                    }
                }
                c = i;
            }
            if (!this.gz.equals("")) {
                c += qp.m1855j(6, this.gz);
            }
            if (!this.gA.equals("")) {
                c += qp.m1855j(7, this.gA);
            }
            if (this.gB != 0) {
                c += qp.m1849d(8, this.gB);
            }
            if (this.gF) {
                c += qp.m1848c(9, this.gF);
            }
            if (this.gE != null && this.gE.length > 0) {
                int i3 = 0;
                for (int gZ : this.gE) {
                    i3 += qp.gZ(gZ);
                }
                c = (c + i3) + (this.gE.length * 1);
            }
            if (this.gD != null && this.gD.length > 0) {
                while (i2 < this.gD.length) {
                    qw qwVar3 = this.gD[i2];
                    if (qwVar3 != null) {
                        c += qp.m1847c(11, qwVar3);
                    }
                    i2++;
                }
            }
            return this.gC ? c + qp.m1848c(12, this.gC) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1389a)) {
                return false;
            }
            C1389a c1389a = (C1389a) o;
            if (this.type != c1389a.type) {
                return false;
            }
            if (this.gv == null) {
                if (c1389a.gv != null) {
                    return false;
                }
            } else if (!this.gv.equals(c1389a.gv)) {
                return false;
            }
            if (!qu.equals(this.gw, c1389a.gw) || !qu.equals(this.gx, c1389a.gx) || !qu.equals(this.gy, c1389a.gy)) {
                return false;
            }
            if (this.gz == null) {
                if (c1389a.gz != null) {
                    return false;
                }
            } else if (!this.gz.equals(c1389a.gz)) {
                return false;
            }
            if (this.gA == null) {
                if (c1389a.gA != null) {
                    return false;
                }
            } else if (!this.gA.equals(c1389a.gA)) {
                return false;
            }
            return (this.gB == c1389a.gB && this.gC == c1389a.gC && qu.equals(this.gD, c1389a.gD) && qu.equals(this.gE, c1389a.gE) && this.gF == c1389a.gF) ? m3539a((qq) c1389a) : false;
        }

        public int hashCode() {
            int i = 1231;
            int i2 = 0;
            int hashCode = ((this.gz == null ? 0 : this.gz.hashCode()) + (((((((((this.gv == null ? 0 : this.gv.hashCode()) + ((this.type + 527) * 31)) * 31) + qu.hashCode(this.gw)) * 31) + qu.hashCode(this.gx)) * 31) + qu.hashCode(this.gy)) * 31)) * 31;
            if (this.gA != null) {
                i2 = this.gA.hashCode();
            }
            hashCode = ((((((this.gC ? 1231 : 1237) + ((((hashCode + i2) * 31) + ((int) (this.gB ^ (this.gB >>> 32)))) * 31)) * 31) + qu.hashCode(this.gD)) * 31) + qu.hashCode(this.gE)) * 31;
            if (!this.gF) {
                i = 1237;
            }
            return ((hashCode + i) * 31) + rQ();
        }

        /* renamed from: l */
        public C1389a m4345l(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                int b;
                Object obj;
                int i;
                switch (rz) {
                    case 0:
                        break;
                    case 8:
                        rz = qoVar.rC();
                        switch (rz) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                this.type = rz;
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.gv = qoVar.readString();
                        continue;
                    case 26:
                        b = qz.m1915b(qoVar, 26);
                        rz = this.gw == null ? 0 : this.gw.length;
                        obj = new C1389a[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.gw, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1389a();
                            qoVar.m1834a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1389a();
                        qoVar.m1834a(obj[rz]);
                        this.gw = obj;
                        continue;
                    case 34:
                        b = qz.m1915b(qoVar, 34);
                        rz = this.gx == null ? 0 : this.gx.length;
                        obj = new C1389a[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.gx, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1389a();
                            qoVar.m1834a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1389a();
                        qoVar.m1834a(obj[rz]);
                        this.gx = obj;
                        continue;
                    case 42:
                        b = qz.m1915b(qoVar, 42);
                        rz = this.gy == null ? 0 : this.gy.length;
                        obj = new C1389a[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.gy, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1389a();
                            qoVar.m1834a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1389a();
                        qoVar.m1834a(obj[rz]);
                        this.gy = obj;
                        continue;
                    case 50:
                        this.gz = qoVar.readString();
                        continue;
                    case 58:
                        this.gA = qoVar.readString();
                        continue;
                    case 64:
                        this.gB = qoVar.rB();
                        continue;
                    case 72:
                        this.gF = qoVar.rD();
                        continue;
                    case 80:
                        int b2 = qz.m1915b(qoVar, 80);
                        Object obj2 = new int[b2];
                        i = 0;
                        b = 0;
                        while (i < b2) {
                            if (i != 0) {
                                qoVar.rz();
                            }
                            int rC = qoVar.rC();
                            switch (rC) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                    rz = b + 1;
                                    obj2[b] = rC;
                                    break;
                                default:
                                    rz = b;
                                    break;
                            }
                            i++;
                            b = rz;
                        }
                        if (b != 0) {
                            rz = this.gE == null ? 0 : this.gE.length;
                            if (rz != 0 || b != obj2.length) {
                                Object obj3 = new int[(rz + b)];
                                if (rz != 0) {
                                    System.arraycopy(this.gE, 0, obj3, 0, rz);
                                }
                                System.arraycopy(obj2, 0, obj3, rz, b);
                                this.gE = obj3;
                                break;
                            }
                            this.gE = obj2;
                            break;
                        }
                        continue;
                    case 82:
                        i = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            switch (qoVar.rC()) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                    rz++;
                                    break;
                                default:
                                    break;
                            }
                        }
                        if (rz != 0) {
                            qoVar.gU(b);
                            b = this.gE == null ? 0 : this.gE.length;
                            Object obj4 = new int[(rz + b)];
                            if (b != 0) {
                                System.arraycopy(this.gE, 0, obj4, 0, b);
                            }
                            while (qoVar.rL() > 0) {
                                int rC2 = qoVar.rC();
                                switch (rC2) {
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                    case 9:
                                    case 10:
                                    case 11:
                                    case 12:
                                    case 13:
                                    case 14:
                                    case 15:
                                    case 16:
                                    case 17:
                                        rz = b + 1;
                                        obj4[b] = rC2;
                                        b = rz;
                                        break;
                                    default:
                                        break;
                                }
                            }
                            this.gE = obj4;
                        }
                        qoVar.gT(i);
                        continue;
                    case AdSize.LARGE_AD_HEIGHT /*90*/:
                        b = qz.m1915b(qoVar, 90);
                        rz = this.gD == null ? 0 : this.gD.length;
                        obj = new C1389a[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.gD, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1389a();
                            qoVar.m1834a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1389a();
                        qoVar.m1834a(obj[rz]);
                        this.gD = obj;
                        continue;
                    case 96:
                        this.gC = qoVar.rD();
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

        /* renamed from: s */
        public C1389a m4346s() {
            this.type = 1;
            this.gv = "";
            this.gw = C1389a.m4341r();
            this.gx = C1389a.m4341r();
            this.gy = C1389a.m4341r();
            this.gz = "";
            this.gA = "";
            this.gB = 0;
            this.gC = false;
            this.gD = C1389a.m4341r();
            this.gE = qz.azj;
            this.gF = false;
            this.ayW = null;
            this.azh = -1;
            return this;
        }
    }
}
