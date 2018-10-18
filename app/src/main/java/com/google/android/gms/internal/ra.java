package com.google.android.gms.internal;

import android.support.v4.util.TimeUtils;
import java.io.IOException;
import java.util.Arrays;

public interface ra {

    /* renamed from: com.google.android.gms.internal.ra$a */
    public static final class C1436a extends qq<C1436a> {
        public String[] azr;
        public String[] azs;
        public int[] azt;

        public C1436a() {
            sa();
        }

        /* renamed from: a */
        public void mo2113a(qp qpVar) throws IOException {
            int i = 0;
            if (this.azr != null && this.azr.length > 0) {
                for (String str : this.azr) {
                    if (str != null) {
                        qpVar.m1871b(1, str);
                    }
                }
            }
            if (this.azs != null && this.azs.length > 0) {
                for (String str2 : this.azs) {
                    if (str2 != null) {
                        qpVar.m1871b(2, str2);
                    }
                }
            }
            if (this.azt != null && this.azt.length > 0) {
                while (i < this.azt.length) {
                    qpVar.m1880t(3, this.azt[i]);
                    i++;
                }
            }
            super.mo2113a(qpVar);
        }

        /* renamed from: b */
        public /* synthetic */ qw mo2964b(qo qoVar) throws IOException {
            return m4578y(qoVar);
        }

        /* renamed from: c */
        protected int mo2114c() {
            int i;
            int i2;
            int i3;
            int i4 = 0;
            int c = super.mo2114c();
            if (this.azr == null || this.azr.length <= 0) {
                i = c;
            } else {
                i2 = 0;
                i3 = 0;
                for (String str : this.azr) {
                    if (str != null) {
                        i3++;
                        i2 += qp.dk(str);
                    }
                }
                i = (c + i2) + (i3 * 1);
            }
            if (this.azs != null && this.azs.length > 0) {
                i3 = 0;
                c = 0;
                for (String str2 : this.azs) {
                    if (str2 != null) {
                        c++;
                        i3 += qp.dk(str2);
                    }
                }
                i = (i + i3) + (c * 1);
            }
            if (this.azt == null || this.azt.length <= 0) {
                return i;
            }
            i2 = 0;
            while (i4 < this.azt.length) {
                i2 += qp.gZ(this.azt[i4]);
                i4++;
            }
            return (i + i2) + (this.azt.length * 1);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1436a)) {
                return false;
            }
            C1436a c1436a = (C1436a) o;
            return (qu.equals(this.azr, c1436a.azr) && qu.equals(this.azs, c1436a.azs) && qu.equals(this.azt, c1436a.azt)) ? m3539a((qq) c1436a) : false;
        }

        public int hashCode() {
            return ((((((qu.hashCode(this.azr) + 527) * 31) + qu.hashCode(this.azs)) * 31) + qu.hashCode(this.azt)) * 31) + rQ();
        }

        public C1436a sa() {
            this.azr = qz.azo;
            this.azs = qz.azo;
            this.azt = qz.azj;
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        /* renamed from: y */
        public C1436a m4578y(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                int b;
                Object obj;
                switch (rz) {
                    case 0:
                        break;
                    case 10:
                        b = qz.m1915b(qoVar, 10);
                        rz = this.azr == null ? 0 : this.azr.length;
                        obj = new String[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.azr, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.readString();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.readString();
                        this.azr = obj;
                        continue;
                    case 18:
                        b = qz.m1915b(qoVar, 18);
                        rz = this.azs == null ? 0 : this.azs.length;
                        obj = new String[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.azs, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.readString();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.readString();
                        this.azs = obj;
                        continue;
                    case 24:
                        b = qz.m1915b(qoVar, 24);
                        rz = this.azt == null ? 0 : this.azt.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.azt, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.azt = obj;
                        continue;
                    case 26:
                        int gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.azt == null ? 0 : this.azt.length;
                        Object obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.azt, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.azt = obj2;
                        qoVar.gT(gS);
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

    /* renamed from: com.google.android.gms.internal.ra$b */
    public static final class C1437b extends qq<C1437b> {
        public int azu;
        public String azv;
        public String version;

        public C1437b() {
            sb();
        }

        /* renamed from: a */
        public void mo2113a(qp qpVar) throws IOException {
            if (this.azu != 0) {
                qpVar.m1880t(1, this.azu);
            }
            if (!this.azv.equals("")) {
                qpVar.m1871b(2, this.azv);
            }
            if (!this.version.equals("")) {
                qpVar.m1871b(3, this.version);
            }
            super.mo2113a(qpVar);
        }

        /* renamed from: b */
        public /* synthetic */ qw mo2964b(qo qoVar) throws IOException {
            return m4582z(qoVar);
        }

        /* renamed from: c */
        protected int mo2114c() {
            int c = super.mo2114c();
            if (this.azu != 0) {
                c += qp.m1858v(1, this.azu);
            }
            if (!this.azv.equals("")) {
                c += qp.m1855j(2, this.azv);
            }
            return !this.version.equals("") ? c + qp.m1855j(3, this.version) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1437b)) {
                return false;
            }
            C1437b c1437b = (C1437b) o;
            if (this.azu != c1437b.azu) {
                return false;
            }
            if (this.azv == null) {
                if (c1437b.azv != null) {
                    return false;
                }
            } else if (!this.azv.equals(c1437b.azv)) {
                return false;
            }
            if (this.version == null) {
                if (c1437b.version != null) {
                    return false;
                }
            } else if (!this.version.equals(c1437b.version)) {
                return false;
            }
            return m3539a((qq) c1437b);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.azv == null ? 0 : this.azv.hashCode()) + ((this.azu + 527) * 31)) * 31;
            if (this.version != null) {
                i = this.version.hashCode();
            }
            return ((hashCode + i) * 31) + rQ();
        }

        public C1437b sb() {
            this.azu = 0;
            this.azv = "";
            this.version = "";
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        /* renamed from: z */
        public C1437b m4582z(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case 0:
                        break;
                    case 8:
                        rz = qoVar.rC();
                        switch (rz) {
                            case 0:
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
                            case 18:
                            case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                            case 20:
                            case 21:
                            case 22:
                                this.azu = rz;
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.azv = qoVar.readString();
                        continue;
                    case 26:
                        this.version = qoVar.readString();
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

    /* renamed from: com.google.android.gms.internal.ra$c */
    public static final class C1438c extends qq<C1438c> {
        public C1439d[] azA;
        public C1437b azB;
        public byte[] azC;
        public byte[] azD;
        public byte[] azE;
        public C1436a azF;
        public String azG;
        public long azH;
        public long azw;
        public int azx;
        public int azy;
        public boolean azz;
        public String tag;

        public C1438c() {
            sc();
        }

        /* renamed from: A */
        public C1438c m4583A(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case 0:
                        break;
                    case 8:
                        this.azw = qoVar.rB();
                        continue;
                    case 18:
                        this.tag = qoVar.readString();
                        continue;
                    case 26:
                        int b = qz.m1915b(qoVar, 26);
                        rz = this.azA == null ? 0 : this.azA.length;
                        Object obj = new C1439d[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.azA, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1439d();
                            qoVar.m1834a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1439d();
                        qoVar.m1834a(obj[rz]);
                        this.azA = obj;
                        continue;
                    case 50:
                        this.azC = qoVar.readBytes();
                        continue;
                    case 58:
                        if (this.azF == null) {
                            this.azF = new C1436a();
                        }
                        qoVar.m1834a(this.azF);
                        continue;
                    case 66:
                        this.azD = qoVar.readBytes();
                        continue;
                    case 74:
                        if (this.azB == null) {
                            this.azB = new C1437b();
                        }
                        qoVar.m1834a(this.azB);
                        continue;
                    case 80:
                        this.azz = qoVar.rD();
                        continue;
                    case 88:
                        this.azx = qoVar.rC();
                        continue;
                    case 96:
                        this.azy = qoVar.rC();
                        continue;
                    case 106:
                        this.azE = qoVar.readBytes();
                        continue;
                    case 114:
                        this.azG = qoVar.readString();
                        continue;
                    case 120:
                        this.azH = qoVar.rF();
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

        /* renamed from: a */
        public void mo2113a(qp qpVar) throws IOException {
            if (this.azw != 0) {
                qpVar.m1870b(1, this.azw);
            }
            if (!this.tag.equals("")) {
                qpVar.m1871b(2, this.tag);
            }
            if (this.azA != null && this.azA.length > 0) {
                for (qw qwVar : this.azA) {
                    if (qwVar != null) {
                        qpVar.m1866a(3, qwVar);
                    }
                }
            }
            if (!Arrays.equals(this.azC, qz.azq)) {
                qpVar.m1867a(6, this.azC);
            }
            if (this.azF != null) {
                qpVar.m1866a(7, this.azF);
            }
            if (!Arrays.equals(this.azD, qz.azq)) {
                qpVar.m1867a(8, this.azD);
            }
            if (this.azB != null) {
                qpVar.m1866a(9, this.azB);
            }
            if (this.azz) {
                qpVar.m1872b(10, this.azz);
            }
            if (this.azx != 0) {
                qpVar.m1880t(11, this.azx);
            }
            if (this.azy != 0) {
                qpVar.m1880t(12, this.azy);
            }
            if (!Arrays.equals(this.azE, qz.azq)) {
                qpVar.m1867a(13, this.azE);
            }
            if (!this.azG.equals("")) {
                qpVar.m1871b(14, this.azG);
            }
            if (this.azH != 0) {
                qpVar.m1874c(15, this.azH);
            }
            super.mo2113a(qpVar);
        }

        /* renamed from: b */
        public /* synthetic */ qw mo2964b(qo qoVar) throws IOException {
            return m4583A(qoVar);
        }

        /* renamed from: c */
        protected int mo2114c() {
            int c = super.mo2114c();
            if (this.azw != 0) {
                c += qp.m1849d(1, this.azw);
            }
            if (!this.tag.equals("")) {
                c += qp.m1855j(2, this.tag);
            }
            if (this.azA != null && this.azA.length > 0) {
                int i = c;
                for (qw qwVar : this.azA) {
                    if (qwVar != null) {
                        i += qp.m1847c(3, qwVar);
                    }
                }
                c = i;
            }
            if (!Arrays.equals(this.azC, qz.azq)) {
                c += qp.m1844b(6, this.azC);
            }
            if (this.azF != null) {
                c += qp.m1847c(7, this.azF);
            }
            if (!Arrays.equals(this.azD, qz.azq)) {
                c += qp.m1844b(8, this.azD);
            }
            if (this.azB != null) {
                c += qp.m1847c(9, this.azB);
            }
            if (this.azz) {
                c += qp.m1848c(10, this.azz);
            }
            if (this.azx != 0) {
                c += qp.m1858v(11, this.azx);
            }
            if (this.azy != 0) {
                c += qp.m1858v(12, this.azy);
            }
            if (!Arrays.equals(this.azE, qz.azq)) {
                c += qp.m1844b(13, this.azE);
            }
            if (!this.azG.equals("")) {
                c += qp.m1855j(14, this.azG);
            }
            return this.azH != 0 ? c + qp.m1852e(15, this.azH) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1438c)) {
                return false;
            }
            C1438c c1438c = (C1438c) o;
            if (this.azw != c1438c.azw) {
                return false;
            }
            if (this.tag == null) {
                if (c1438c.tag != null) {
                    return false;
                }
            } else if (!this.tag.equals(c1438c.tag)) {
                return false;
            }
            if (this.azx != c1438c.azx || this.azy != c1438c.azy || this.azz != c1438c.azz || !qu.equals(this.azA, c1438c.azA)) {
                return false;
            }
            if (this.azB == null) {
                if (c1438c.azB != null) {
                    return false;
                }
            } else if (!this.azB.equals(c1438c.azB)) {
                return false;
            }
            if (!Arrays.equals(this.azC, c1438c.azC) || !Arrays.equals(this.azD, c1438c.azD) || !Arrays.equals(this.azE, c1438c.azE)) {
                return false;
            }
            if (this.azF == null) {
                if (c1438c.azF != null) {
                    return false;
                }
            } else if (!this.azF.equals(c1438c.azF)) {
                return false;
            }
            if (this.azG == null) {
                if (c1438c.azG != null) {
                    return false;
                }
            } else if (!this.azG.equals(c1438c.azG)) {
                return false;
            }
            return this.azH == c1438c.azH ? m3539a((qq) c1438c) : false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.azF == null ? 0 : this.azF.hashCode()) + (((((((((this.azB == null ? 0 : this.azB.hashCode()) + (((((this.azz ? 1231 : 1237) + (((((((this.tag == null ? 0 : this.tag.hashCode()) + ((((int) (this.azw ^ (this.azw >>> 32))) + 527) * 31)) * 31) + this.azx) * 31) + this.azy) * 31)) * 31) + qu.hashCode(this.azA)) * 31)) * 31) + Arrays.hashCode(this.azC)) * 31) + Arrays.hashCode(this.azD)) * 31) + Arrays.hashCode(this.azE)) * 31)) * 31;
            if (this.azG != null) {
                i = this.azG.hashCode();
            }
            return ((((hashCode + i) * 31) + ((int) (this.azH ^ (this.azH >>> 32)))) * 31) + rQ();
        }

        public C1438c sc() {
            this.azw = 0;
            this.tag = "";
            this.azx = 0;
            this.azy = 0;
            this.azz = false;
            this.azA = C1439d.sd();
            this.azB = null;
            this.azC = qz.azq;
            this.azD = qz.azq;
            this.azE = qz.azq;
            this.azF = null;
            this.azG = "";
            this.azH = 0;
            this.ayW = null;
            this.azh = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.ra$d */
    public static final class C1439d extends qq<C1439d> {
        private static volatile C1439d[] azI;
        public String fv;
        public String value;

        public C1439d() {
            se();
        }

        public static C1439d[] sd() {
            if (azI == null) {
                synchronized (qu.azg) {
                    if (azI == null) {
                        azI = new C1439d[0];
                    }
                }
            }
            return azI;
        }

        /* renamed from: B */
        public C1439d m4587B(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case 0:
                        break;
                    case 10:
                        this.fv = qoVar.readString();
                        continue;
                    case 18:
                        this.value = qoVar.readString();
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

        /* renamed from: a */
        public void mo2113a(qp qpVar) throws IOException {
            if (!this.fv.equals("")) {
                qpVar.m1871b(1, this.fv);
            }
            if (!this.value.equals("")) {
                qpVar.m1871b(2, this.value);
            }
            super.mo2113a(qpVar);
        }

        /* renamed from: b */
        public /* synthetic */ qw mo2964b(qo qoVar) throws IOException {
            return m4587B(qoVar);
        }

        /* renamed from: c */
        protected int mo2114c() {
            int c = super.mo2114c();
            if (!this.fv.equals("")) {
                c += qp.m1855j(1, this.fv);
            }
            return !this.value.equals("") ? c + qp.m1855j(2, this.value) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1439d)) {
                return false;
            }
            C1439d c1439d = (C1439d) o;
            if (this.fv == null) {
                if (c1439d.fv != null) {
                    return false;
                }
            } else if (!this.fv.equals(c1439d.fv)) {
                return false;
            }
            if (this.value == null) {
                if (c1439d.value != null) {
                    return false;
                }
            } else if (!this.value.equals(c1439d.value)) {
                return false;
            }
            return m3539a((qq) c1439d);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.fv == null ? 0 : this.fv.hashCode()) + 527) * 31;
            if (this.value != null) {
                i = this.value.hashCode();
            }
            return ((hashCode + i) * 31) + rQ();
        }

        public C1439d se() {
            this.fv = "";
            this.value = "";
            this.ayW = null;
            this.azh = -1;
            return this;
        }
    }
}
