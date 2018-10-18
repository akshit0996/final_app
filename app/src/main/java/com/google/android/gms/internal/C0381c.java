package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import com.google.android.gms.internal.C0386d.C1389a;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.c */
public interface C0381c {

    /* renamed from: com.google.android.gms.internal.c$a */
    public static final class C1378a extends qq<C1378a> {
        public int fn;
        public int fo;
        public int level;

        public C1378a() {
            m4277b();
        }

        /* renamed from: a */
        public C1378a m4275a(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case 0:
                        break;
                    case 8:
                        rz = qoVar.rC();
                        switch (rz) {
                            case 1:
                            case 2:
                            case 3:
                                this.level = rz;
                                break;
                            default:
                                continue;
                        }
                    case 16:
                        this.fn = qoVar.rC();
                        continue;
                    case 24:
                        this.fo = qoVar.rC();
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
            if (this.level != 1) {
                qpVar.m1880t(1, this.level);
            }
            if (this.fn != 0) {
                qpVar.m1880t(2, this.fn);
            }
            if (this.fo != 0) {
                qpVar.m1880t(3, this.fo);
            }
            super.mo2113a(qpVar);
        }

        /* renamed from: b */
        public C1378a m4277b() {
            this.level = 1;
            this.fn = 0;
            this.fo = 0;
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        /* renamed from: b */
        public /* synthetic */ qw mo2964b(qo qoVar) throws IOException {
            return m4275a(qoVar);
        }

        /* renamed from: c */
        protected int mo2114c() {
            int c = super.mo2114c();
            if (this.level != 1) {
                c += qp.m1858v(1, this.level);
            }
            if (this.fn != 0) {
                c += qp.m1858v(2, this.fn);
            }
            return this.fo != 0 ? c + qp.m1858v(3, this.fo) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1378a)) {
                return false;
            }
            C1378a c1378a = (C1378a) o;
            return (this.level == c1378a.level && this.fn == c1378a.fn && this.fo == c1378a.fo) ? m3539a((qq) c1378a) : false;
        }

        public int hashCode() {
            return ((((((this.level + 527) * 31) + this.fn) * 31) + this.fo) * 31) + rQ();
        }
    }

    /* renamed from: com.google.android.gms.internal.c$b */
    public static final class C1379b extends qq<C1379b> {
        private static volatile C1379b[] fp;
        public int[] fq;
        public int fr;
        public boolean fs;
        public boolean ft;
        public int name;

        public C1379b() {
            m4285e();
        }

        /* renamed from: d */
        public static C1379b[] m4280d() {
            if (fp == null) {
                synchronized (qu.azg) {
                    if (fp == null) {
                        fp = new C1379b[0];
                    }
                }
            }
            return fp;
        }

        /* renamed from: a */
        public void mo2113a(qp qpVar) throws IOException {
            if (this.ft) {
                qpVar.m1872b(1, this.ft);
            }
            qpVar.m1880t(2, this.fr);
            if (this.fq != null && this.fq.length > 0) {
                for (int t : this.fq) {
                    qpVar.m1880t(3, t);
                }
            }
            if (this.name != 0) {
                qpVar.m1880t(4, this.name);
            }
            if (this.fs) {
                qpVar.m1872b(6, this.fs);
            }
            super.mo2113a(qpVar);
        }

        /* renamed from: b */
        public /* synthetic */ qw mo2964b(qo qoVar) throws IOException {
            return m4284c(qoVar);
        }

        /* renamed from: c */
        protected int mo2114c() {
            int i = 0;
            int c = super.mo2114c();
            if (this.ft) {
                c += qp.m1848c(1, this.ft);
            }
            int v = qp.m1858v(2, this.fr) + c;
            if (this.fq == null || this.fq.length <= 0) {
                c = v;
            } else {
                for (int gZ : this.fq) {
                    i += qp.gZ(gZ);
                }
                c = (v + i) + (this.fq.length * 1);
            }
            if (this.name != 0) {
                c += qp.m1858v(4, this.name);
            }
            return this.fs ? c + qp.m1848c(6, this.fs) : c;
        }

        /* renamed from: c */
        public C1379b m4284c(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                int b;
                switch (rz) {
                    case 0:
                        break;
                    case 8:
                        this.ft = qoVar.rD();
                        continue;
                    case 16:
                        this.fr = qoVar.rC();
                        continue;
                    case 24:
                        b = qz.m1915b(qoVar, 24);
                        rz = this.fq == null ? 0 : this.fq.length;
                        Object obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fq, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.fq = obj;
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
                        b = this.fq == null ? 0 : this.fq.length;
                        Object obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.fq, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.fq = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 32:
                        this.name = qoVar.rC();
                        continue;
                    case 48:
                        this.fs = qoVar.rD();
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

        /* renamed from: e */
        public C1379b m4285e() {
            this.fq = qz.azj;
            this.fr = 0;
            this.name = 0;
            this.fs = false;
            this.ft = false;
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1379b)) {
                return false;
            }
            C1379b c1379b = (C1379b) o;
            return (qu.equals(this.fq, c1379b.fq) && this.fr == c1379b.fr && this.name == c1379b.name && this.fs == c1379b.fs && this.ft == c1379b.ft) ? m3539a((qq) c1379b) : false;
        }

        public int hashCode() {
            int i = 1231;
            int hashCode = ((this.fs ? 1231 : 1237) + ((((((qu.hashCode(this.fq) + 527) * 31) + this.fr) * 31) + this.name) * 31)) * 31;
            if (!this.ft) {
                i = 1237;
            }
            return ((hashCode + i) * 31) + rQ();
        }
    }

    /* renamed from: com.google.android.gms.internal.c$c */
    public static final class C1380c extends qq<C1380c> {
        private static volatile C1380c[] fu;
        public String fv;
        public long fw;
        public long fx;
        public boolean fy;
        public long fz;

        public C1380c() {
            m4291g();
        }

        /* renamed from: f */
        public static C1380c[] m4286f() {
            if (fu == null) {
                synchronized (qu.azg) {
                    if (fu == null) {
                        fu = new C1380c[0];
                    }
                }
            }
            return fu;
        }

        /* renamed from: a */
        public void mo2113a(qp qpVar) throws IOException {
            if (!this.fv.equals("")) {
                qpVar.m1871b(1, this.fv);
            }
            if (this.fw != 0) {
                qpVar.m1870b(2, this.fw);
            }
            if (this.fx != 2147483647L) {
                qpVar.m1870b(3, this.fx);
            }
            if (this.fy) {
                qpVar.m1872b(4, this.fy);
            }
            if (this.fz != 0) {
                qpVar.m1870b(5, this.fz);
            }
            super.mo2113a(qpVar);
        }

        /* renamed from: b */
        public /* synthetic */ qw mo2964b(qo qoVar) throws IOException {
            return m4290d(qoVar);
        }

        /* renamed from: c */
        protected int mo2114c() {
            int c = super.mo2114c();
            if (!this.fv.equals("")) {
                c += qp.m1855j(1, this.fv);
            }
            if (this.fw != 0) {
                c += qp.m1849d(2, this.fw);
            }
            if (this.fx != 2147483647L) {
                c += qp.m1849d(3, this.fx);
            }
            if (this.fy) {
                c += qp.m1848c(4, this.fy);
            }
            return this.fz != 0 ? c + qp.m1849d(5, this.fz) : c;
        }

        /* renamed from: d */
        public C1380c m4290d(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case 0:
                        break;
                    case 10:
                        this.fv = qoVar.readString();
                        continue;
                    case 16:
                        this.fw = qoVar.rB();
                        continue;
                    case 24:
                        this.fx = qoVar.rB();
                        continue;
                    case 32:
                        this.fy = qoVar.rD();
                        continue;
                    case 40:
                        this.fz = qoVar.rB();
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

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1380c)) {
                return false;
            }
            C1380c c1380c = (C1380c) o;
            if (this.fv == null) {
                if (c1380c.fv != null) {
                    return false;
                }
            } else if (!this.fv.equals(c1380c.fv)) {
                return false;
            }
            return (this.fw == c1380c.fw && this.fx == c1380c.fx && this.fy == c1380c.fy && this.fz == c1380c.fz) ? m3539a((qq) c1380c) : false;
        }

        /* renamed from: g */
        public C1380c m4291g() {
            this.fv = "";
            this.fw = 0;
            this.fx = 2147483647L;
            this.fy = false;
            this.fz = 0;
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        public int hashCode() {
            return (((((this.fy ? 1231 : 1237) + (((((((this.fv == null ? 0 : this.fv.hashCode()) + 527) * 31) + ((int) (this.fw ^ (this.fw >>> 32)))) * 31) + ((int) (this.fx ^ (this.fx >>> 32)))) * 31)) * 31) + ((int) (this.fz ^ (this.fz >>> 32)))) * 31) + rQ();
        }
    }

    /* renamed from: com.google.android.gms.internal.c$d */
    public static final class C1381d extends qq<C1381d> {
        public C1389a[] fA;
        public C1389a[] fB;
        public C1380c[] fC;

        public C1381d() {
            m4296h();
        }

        /* renamed from: a */
        public void mo2113a(qp qpVar) throws IOException {
            int i = 0;
            if (this.fA != null && this.fA.length > 0) {
                for (qw qwVar : this.fA) {
                    if (qwVar != null) {
                        qpVar.m1866a(1, qwVar);
                    }
                }
            }
            if (this.fB != null && this.fB.length > 0) {
                for (qw qwVar2 : this.fB) {
                    if (qwVar2 != null) {
                        qpVar.m1866a(2, qwVar2);
                    }
                }
            }
            if (this.fC != null && this.fC.length > 0) {
                while (i < this.fC.length) {
                    qw qwVar3 = this.fC[i];
                    if (qwVar3 != null) {
                        qpVar.m1866a(3, qwVar3);
                    }
                    i++;
                }
            }
            super.mo2113a(qpVar);
        }

        /* renamed from: b */
        public /* synthetic */ qw mo2964b(qo qoVar) throws IOException {
            return m4295e(qoVar);
        }

        /* renamed from: c */
        protected int mo2114c() {
            int i;
            int i2 = 0;
            int c = super.mo2114c();
            if (this.fA != null && this.fA.length > 0) {
                i = c;
                for (qw qwVar : this.fA) {
                    if (qwVar != null) {
                        i += qp.m1847c(1, qwVar);
                    }
                }
                c = i;
            }
            if (this.fB != null && this.fB.length > 0) {
                i = c;
                for (qw qwVar2 : this.fB) {
                    if (qwVar2 != null) {
                        i += qp.m1847c(2, qwVar2);
                    }
                }
                c = i;
            }
            if (this.fC != null && this.fC.length > 0) {
                while (i2 < this.fC.length) {
                    qw qwVar3 = this.fC[i2];
                    if (qwVar3 != null) {
                        c += qp.m1847c(3, qwVar3);
                    }
                    i2++;
                }
            }
            return c;
        }

        /* renamed from: e */
        public C1381d m4295e(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                int b;
                Object obj;
                switch (rz) {
                    case 0:
                        break;
                    case 10:
                        b = qz.m1915b(qoVar, 10);
                        rz = this.fA == null ? 0 : this.fA.length;
                        obj = new C1389a[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fA, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1389a();
                            qoVar.m1834a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1389a();
                        qoVar.m1834a(obj[rz]);
                        this.fA = obj;
                        continue;
                    case 18:
                        b = qz.m1915b(qoVar, 18);
                        rz = this.fB == null ? 0 : this.fB.length;
                        obj = new C1389a[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fB, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1389a();
                            qoVar.m1834a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1389a();
                        qoVar.m1834a(obj[rz]);
                        this.fB = obj;
                        continue;
                    case 26:
                        b = qz.m1915b(qoVar, 26);
                        rz = this.fC == null ? 0 : this.fC.length;
                        obj = new C1380c[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fC, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1380c();
                            qoVar.m1834a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1380c();
                        qoVar.m1834a(obj[rz]);
                        this.fC = obj;
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

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1381d)) {
                return false;
            }
            C1381d c1381d = (C1381d) o;
            return (qu.equals(this.fA, c1381d.fA) && qu.equals(this.fB, c1381d.fB) && qu.equals(this.fC, c1381d.fC)) ? m3539a((qq) c1381d) : false;
        }

        /* renamed from: h */
        public C1381d m4296h() {
            this.fA = C1389a.m4341r();
            this.fB = C1389a.m4341r();
            this.fC = C1380c.m4286f();
            this.ayW = null;
            this.azh = -1;
            return this;
        }

        public int hashCode() {
            return ((((((qu.hashCode(this.fA) + 527) * 31) + qu.hashCode(this.fB)) * 31) + qu.hashCode(this.fC)) * 31) + rQ();
        }
    }

    /* renamed from: com.google.android.gms.internal.c$e */
    public static final class C1382e extends qq<C1382e> {
        private static volatile C1382e[] fD;
        public int key;
        public int value;

        public C1382e() {
            m4302j();
        }

        /* renamed from: i */
        public static C1382e[] m4297i() {
            if (fD == null) {
                synchronized (qu.azg) {
                    if (fD == null) {
                        fD = new C1382e[0];
                    }
                }
            }
            return fD;
        }

        /* renamed from: a */
        public void mo2113a(qp qpVar) throws IOException {
            qpVar.m1880t(1, this.key);
            qpVar.m1880t(2, this.value);
            super.mo2113a(qpVar);
        }

        /* renamed from: b */
        public /* synthetic */ qw mo2964b(qo qoVar) throws IOException {
            return m4301f(qoVar);
        }

        /* renamed from: c */
        protected int mo2114c() {
            return (super.mo2114c() + qp.m1858v(1, this.key)) + qp.m1858v(2, this.value);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1382e)) {
                return false;
            }
            C1382e c1382e = (C1382e) o;
            return (this.key == c1382e.key && this.value == c1382e.value) ? m3539a((qq) c1382e) : false;
        }

        /* renamed from: f */
        public C1382e m4301f(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case 0:
                        break;
                    case 8:
                        this.key = qoVar.rC();
                        continue;
                    case 16:
                        this.value = qoVar.rC();
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

        public int hashCode() {
            return ((((this.key + 527) * 31) + this.value) * 31) + rQ();
        }

        /* renamed from: j */
        public C1382e m4302j() {
            this.key = 0;
            this.value = 0;
            this.ayW = null;
            this.azh = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c$f */
    public static final class C1383f extends qq<C1383f> {
        public String[] fE;
        public String[] fF;
        public C1389a[] fG;
        public C1382e[] fH;
        public C1379b[] fI;
        public C1379b[] fJ;
        public C1379b[] fK;
        public C1384g[] fL;
        public String fM;
        public String fN;
        public String fO;
        public C1378a fP;
        public float fQ;
        public boolean fR;
        public String[] fS;
        public int fT;
        public String version;

        public C1383f() {
            m4308k();
        }

        /* renamed from: a */
        public static C1383f m4303a(byte[] bArr) throws qv {
            return (C1383f) qw.m1903a(new C1383f(), bArr);
        }

        /* renamed from: a */
        public void mo2113a(qp qpVar) throws IOException {
            int i = 0;
            if (this.fF != null && this.fF.length > 0) {
                for (String str : this.fF) {
                    if (str != null) {
                        qpVar.m1871b(1, str);
                    }
                }
            }
            if (this.fG != null && this.fG.length > 0) {
                for (qw qwVar : this.fG) {
                    if (qwVar != null) {
                        qpVar.m1866a(2, qwVar);
                    }
                }
            }
            if (this.fH != null && this.fH.length > 0) {
                for (qw qwVar2 : this.fH) {
                    if (qwVar2 != null) {
                        qpVar.m1866a(3, qwVar2);
                    }
                }
            }
            if (this.fI != null && this.fI.length > 0) {
                for (qw qwVar22 : this.fI) {
                    if (qwVar22 != null) {
                        qpVar.m1866a(4, qwVar22);
                    }
                }
            }
            if (this.fJ != null && this.fJ.length > 0) {
                for (qw qwVar222 : this.fJ) {
                    if (qwVar222 != null) {
                        qpVar.m1866a(5, qwVar222);
                    }
                }
            }
            if (this.fK != null && this.fK.length > 0) {
                for (qw qwVar2222 : this.fK) {
                    if (qwVar2222 != null) {
                        qpVar.m1866a(6, qwVar2222);
                    }
                }
            }
            if (this.fL != null && this.fL.length > 0) {
                for (qw qwVar22222 : this.fL) {
                    if (qwVar22222 != null) {
                        qpVar.m1866a(7, qwVar22222);
                    }
                }
            }
            if (!this.fM.equals("")) {
                qpVar.m1871b(9, this.fM);
            }
            if (!this.fN.equals("")) {
                qpVar.m1871b(10, this.fN);
            }
            if (!this.fO.equals("0")) {
                qpVar.m1871b(12, this.fO);
            }
            if (!this.version.equals("")) {
                qpVar.m1871b(13, this.version);
            }
            if (this.fP != null) {
                qpVar.m1866a(14, this.fP);
            }
            if (Float.floatToIntBits(this.fQ) != Float.floatToIntBits(0.0f)) {
                qpVar.m1869b(15, this.fQ);
            }
            if (this.fS != null && this.fS.length > 0) {
                for (String str2 : this.fS) {
                    if (str2 != null) {
                        qpVar.m1871b(16, str2);
                    }
                }
            }
            if (this.fT != 0) {
                qpVar.m1880t(17, this.fT);
            }
            if (this.fR) {
                qpVar.m1872b(18, this.fR);
            }
            if (this.fE != null && this.fE.length > 0) {
                while (i < this.fE.length) {
                    String str3 = this.fE[i];
                    if (str3 != null) {
                        qpVar.m1871b(19, str3);
                    }
                    i++;
                }
            }
            super.mo2113a(qpVar);
        }

        /* renamed from: b */
        public /* synthetic */ qw mo2964b(qo qoVar) throws IOException {
            return m4307g(qoVar);
        }

        /* renamed from: c */
        protected int mo2114c() {
            int i;
            int i2;
            int i3;
            int i4 = 0;
            int c = super.mo2114c();
            if (this.fF == null || this.fF.length <= 0) {
                i = c;
            } else {
                i2 = 0;
                i3 = 0;
                for (String str : this.fF) {
                    if (str != null) {
                        i3++;
                        i2 += qp.dk(str);
                    }
                }
                i = (c + i2) + (i3 * 1);
            }
            if (this.fG != null && this.fG.length > 0) {
                i2 = i;
                for (qw qwVar : this.fG) {
                    if (qwVar != null) {
                        i2 += qp.m1847c(2, qwVar);
                    }
                }
                i = i2;
            }
            if (this.fH != null && this.fH.length > 0) {
                i2 = i;
                for (qw qwVar2 : this.fH) {
                    if (qwVar2 != null) {
                        i2 += qp.m1847c(3, qwVar2);
                    }
                }
                i = i2;
            }
            if (this.fI != null && this.fI.length > 0) {
                i2 = i;
                for (qw qwVar22 : this.fI) {
                    if (qwVar22 != null) {
                        i2 += qp.m1847c(4, qwVar22);
                    }
                }
                i = i2;
            }
            if (this.fJ != null && this.fJ.length > 0) {
                i2 = i;
                for (qw qwVar222 : this.fJ) {
                    if (qwVar222 != null) {
                        i2 += qp.m1847c(5, qwVar222);
                    }
                }
                i = i2;
            }
            if (this.fK != null && this.fK.length > 0) {
                i2 = i;
                for (qw qwVar2222 : this.fK) {
                    if (qwVar2222 != null) {
                        i2 += qp.m1847c(6, qwVar2222);
                    }
                }
                i = i2;
            }
            if (this.fL != null && this.fL.length > 0) {
                i2 = i;
                for (qw qwVar22222 : this.fL) {
                    if (qwVar22222 != null) {
                        i2 += qp.m1847c(7, qwVar22222);
                    }
                }
                i = i2;
            }
            if (!this.fM.equals("")) {
                i += qp.m1855j(9, this.fM);
            }
            if (!this.fN.equals("")) {
                i += qp.m1855j(10, this.fN);
            }
            if (!this.fO.equals("0")) {
                i += qp.m1855j(12, this.fO);
            }
            if (!this.version.equals("")) {
                i += qp.m1855j(13, this.version);
            }
            if (this.fP != null) {
                i += qp.m1847c(14, this.fP);
            }
            if (Float.floatToIntBits(this.fQ) != Float.floatToIntBits(0.0f)) {
                i += qp.m1846c(15, this.fQ);
            }
            if (this.fS != null && this.fS.length > 0) {
                i3 = 0;
                c = 0;
                for (String str2 : this.fS) {
                    if (str2 != null) {
                        c++;
                        i3 += qp.dk(str2);
                    }
                }
                i = (i + i3) + (c * 2);
            }
            if (this.fT != 0) {
                i += qp.m1858v(17, this.fT);
            }
            if (this.fR) {
                i += qp.m1848c(18, this.fR);
            }
            if (this.fE == null || this.fE.length <= 0) {
                return i;
            }
            i2 = 0;
            i3 = 0;
            while (i4 < this.fE.length) {
                String str3 = this.fE[i4];
                if (str3 != null) {
                    i3++;
                    i2 += qp.dk(str3);
                }
                i4++;
            }
            return (i + i2) + (i3 * 2);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1383f)) {
                return false;
            }
            C1383f c1383f = (C1383f) o;
            if (!qu.equals(this.fE, c1383f.fE) || !qu.equals(this.fF, c1383f.fF) || !qu.equals(this.fG, c1383f.fG) || !qu.equals(this.fH, c1383f.fH) || !qu.equals(this.fI, c1383f.fI) || !qu.equals(this.fJ, c1383f.fJ) || !qu.equals(this.fK, c1383f.fK) || !qu.equals(this.fL, c1383f.fL)) {
                return false;
            }
            if (this.fM == null) {
                if (c1383f.fM != null) {
                    return false;
                }
            } else if (!this.fM.equals(c1383f.fM)) {
                return false;
            }
            if (this.fN == null) {
                if (c1383f.fN != null) {
                    return false;
                }
            } else if (!this.fN.equals(c1383f.fN)) {
                return false;
            }
            if (this.fO == null) {
                if (c1383f.fO != null) {
                    return false;
                }
            } else if (!this.fO.equals(c1383f.fO)) {
                return false;
            }
            if (this.version == null) {
                if (c1383f.version != null) {
                    return false;
                }
            } else if (!this.version.equals(c1383f.version)) {
                return false;
            }
            if (this.fP == null) {
                if (c1383f.fP != null) {
                    return false;
                }
            } else if (!this.fP.equals(c1383f.fP)) {
                return false;
            }
            return (Float.floatToIntBits(this.fQ) == Float.floatToIntBits(c1383f.fQ) && this.fR == c1383f.fR && qu.equals(this.fS, c1383f.fS) && this.fT == c1383f.fT) ? m3539a((qq) c1383f) : false;
        }

        /* renamed from: g */
        public C1383f m4307g(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                int b;
                Object obj;
                switch (rz) {
                    case 0:
                        break;
                    case 10:
                        b = qz.m1915b(qoVar, 10);
                        rz = this.fF == null ? 0 : this.fF.length;
                        obj = new String[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fF, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.readString();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.readString();
                        this.fF = obj;
                        continue;
                    case 18:
                        b = qz.m1915b(qoVar, 18);
                        rz = this.fG == null ? 0 : this.fG.length;
                        obj = new C1389a[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fG, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1389a();
                            qoVar.m1834a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1389a();
                        qoVar.m1834a(obj[rz]);
                        this.fG = obj;
                        continue;
                    case 26:
                        b = qz.m1915b(qoVar, 26);
                        rz = this.fH == null ? 0 : this.fH.length;
                        obj = new C1382e[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fH, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1382e();
                            qoVar.m1834a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1382e();
                        qoVar.m1834a(obj[rz]);
                        this.fH = obj;
                        continue;
                    case 34:
                        b = qz.m1915b(qoVar, 34);
                        rz = this.fI == null ? 0 : this.fI.length;
                        obj = new C1379b[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fI, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1379b();
                            qoVar.m1834a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1379b();
                        qoVar.m1834a(obj[rz]);
                        this.fI = obj;
                        continue;
                    case 42:
                        b = qz.m1915b(qoVar, 42);
                        rz = this.fJ == null ? 0 : this.fJ.length;
                        obj = new C1379b[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fJ, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1379b();
                            qoVar.m1834a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1379b();
                        qoVar.m1834a(obj[rz]);
                        this.fJ = obj;
                        continue;
                    case 50:
                        b = qz.m1915b(qoVar, 50);
                        rz = this.fK == null ? 0 : this.fK.length;
                        obj = new C1379b[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fK, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1379b();
                            qoVar.m1834a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1379b();
                        qoVar.m1834a(obj[rz]);
                        this.fK = obj;
                        continue;
                    case 58:
                        b = qz.m1915b(qoVar, 58);
                        rz = this.fL == null ? 0 : this.fL.length;
                        obj = new C1384g[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fL, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1384g();
                            qoVar.m1834a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1384g();
                        qoVar.m1834a(obj[rz]);
                        this.fL = obj;
                        continue;
                    case 74:
                        this.fM = qoVar.readString();
                        continue;
                    case 82:
                        this.fN = qoVar.readString();
                        continue;
                    case 98:
                        this.fO = qoVar.readString();
                        continue;
                    case 106:
                        this.version = qoVar.readString();
                        continue;
                    case 114:
                        if (this.fP == null) {
                            this.fP = new C1378a();
                        }
                        qoVar.m1834a(this.fP);
                        continue;
                    case 125:
                        this.fQ = qoVar.readFloat();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                        b = qz.m1915b(qoVar, TransportMediator.KEYCODE_MEDIA_RECORD);
                        rz = this.fS == null ? 0 : this.fS.length;
                        obj = new String[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fS, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.readString();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.readString();
                        this.fS = obj;
                        continue;
                    case 136:
                        this.fT = qoVar.rC();
                        continue;
                    case 144:
                        this.fR = qoVar.rD();
                        continue;
                    case 154:
                        b = qz.m1915b(qoVar, 154);
                        rz = this.fE == null ? 0 : this.fE.length;
                        obj = new String[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fE, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.readString();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.readString();
                        this.fE = obj;
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

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.version == null ? 0 : this.version.hashCode()) + (((this.fO == null ? 0 : this.fO.hashCode()) + (((this.fN == null ? 0 : this.fN.hashCode()) + (((this.fM == null ? 0 : this.fM.hashCode()) + ((((((((((((((((qu.hashCode(this.fE) + 527) * 31) + qu.hashCode(this.fF)) * 31) + qu.hashCode(this.fG)) * 31) + qu.hashCode(this.fH)) * 31) + qu.hashCode(this.fI)) * 31) + qu.hashCode(this.fJ)) * 31) + qu.hashCode(this.fK)) * 31) + qu.hashCode(this.fL)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.fP != null) {
                i = this.fP.hashCode();
            }
            return (((((((this.fR ? 1231 : 1237) + ((((hashCode + i) * 31) + Float.floatToIntBits(this.fQ)) * 31)) * 31) + qu.hashCode(this.fS)) * 31) + this.fT) * 31) + rQ();
        }

        /* renamed from: k */
        public C1383f m4308k() {
            this.fE = qz.azo;
            this.fF = qz.azo;
            this.fG = C1389a.m4341r();
            this.fH = C1382e.m4297i();
            this.fI = C1379b.m4280d();
            this.fJ = C1379b.m4280d();
            this.fK = C1379b.m4280d();
            this.fL = C1384g.m4309l();
            this.fM = "";
            this.fN = "";
            this.fO = "0";
            this.version = "";
            this.fP = null;
            this.fQ = 0.0f;
            this.fR = false;
            this.fS = qz.azo;
            this.fT = 0;
            this.ayW = null;
            this.azh = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c$g */
    public static final class C1384g extends qq<C1384g> {
        private static volatile C1384g[] fU;
        public int[] fV;
        public int[] fW;
        public int[] fX;
        public int[] fY;
        public int[] fZ;
        public int[] ga;
        public int[] gb;
        public int[] gc;
        public int[] gd;
        public int[] ge;

        public C1384g() {
            m4314m();
        }

        /* renamed from: l */
        public static C1384g[] m4309l() {
            if (fU == null) {
                synchronized (qu.azg) {
                    if (fU == null) {
                        fU = new C1384g[0];
                    }
                }
            }
            return fU;
        }

        /* renamed from: a */
        public void mo2113a(qp qpVar) throws IOException {
            int i = 0;
            if (this.fV != null && this.fV.length > 0) {
                for (int t : this.fV) {
                    qpVar.m1880t(1, t);
                }
            }
            if (this.fW != null && this.fW.length > 0) {
                for (int t2 : this.fW) {
                    qpVar.m1880t(2, t2);
                }
            }
            if (this.fX != null && this.fX.length > 0) {
                for (int t22 : this.fX) {
                    qpVar.m1880t(3, t22);
                }
            }
            if (this.fY != null && this.fY.length > 0) {
                for (int t222 : this.fY) {
                    qpVar.m1880t(4, t222);
                }
            }
            if (this.fZ != null && this.fZ.length > 0) {
                for (int t2222 : this.fZ) {
                    qpVar.m1880t(5, t2222);
                }
            }
            if (this.ga != null && this.ga.length > 0) {
                for (int t22222 : this.ga) {
                    qpVar.m1880t(6, t22222);
                }
            }
            if (this.gb != null && this.gb.length > 0) {
                for (int t222222 : this.gb) {
                    qpVar.m1880t(7, t222222);
                }
            }
            if (this.gc != null && this.gc.length > 0) {
                for (int t2222222 : this.gc) {
                    qpVar.m1880t(8, t2222222);
                }
            }
            if (this.gd != null && this.gd.length > 0) {
                for (int t22222222 : this.gd) {
                    qpVar.m1880t(9, t22222222);
                }
            }
            if (this.ge != null && this.ge.length > 0) {
                while (i < this.ge.length) {
                    qpVar.m1880t(10, this.ge[i]);
                    i++;
                }
            }
            super.mo2113a(qpVar);
        }

        /* renamed from: b */
        public /* synthetic */ qw mo2964b(qo qoVar) throws IOException {
            return m4313h(qoVar);
        }

        /* renamed from: c */
        protected int mo2114c() {
            int i;
            int i2;
            int i3 = 0;
            int c = super.mo2114c();
            if (this.fV == null || this.fV.length <= 0) {
                i = c;
            } else {
                i2 = 0;
                for (int gZ : this.fV) {
                    i2 += qp.gZ(gZ);
                }
                i = (c + i2) + (this.fV.length * 1);
            }
            if (this.fW != null && this.fW.length > 0) {
                c = 0;
                for (int gZ2 : this.fW) {
                    c += qp.gZ(gZ2);
                }
                i = (i + c) + (this.fW.length * 1);
            }
            if (this.fX != null && this.fX.length > 0) {
                c = 0;
                for (int gZ22 : this.fX) {
                    c += qp.gZ(gZ22);
                }
                i = (i + c) + (this.fX.length * 1);
            }
            if (this.fY != null && this.fY.length > 0) {
                c = 0;
                for (int gZ222 : this.fY) {
                    c += qp.gZ(gZ222);
                }
                i = (i + c) + (this.fY.length * 1);
            }
            if (this.fZ != null && this.fZ.length > 0) {
                c = 0;
                for (int gZ2222 : this.fZ) {
                    c += qp.gZ(gZ2222);
                }
                i = (i + c) + (this.fZ.length * 1);
            }
            if (this.ga != null && this.ga.length > 0) {
                c = 0;
                for (int gZ22222 : this.ga) {
                    c += qp.gZ(gZ22222);
                }
                i = (i + c) + (this.ga.length * 1);
            }
            if (this.gb != null && this.gb.length > 0) {
                c = 0;
                for (int gZ222222 : this.gb) {
                    c += qp.gZ(gZ222222);
                }
                i = (i + c) + (this.gb.length * 1);
            }
            if (this.gc != null && this.gc.length > 0) {
                c = 0;
                for (int gZ2222222 : this.gc) {
                    c += qp.gZ(gZ2222222);
                }
                i = (i + c) + (this.gc.length * 1);
            }
            if (this.gd != null && this.gd.length > 0) {
                c = 0;
                for (int gZ22222222 : this.gd) {
                    c += qp.gZ(gZ22222222);
                }
                i = (i + c) + (this.gd.length * 1);
            }
            if (this.ge == null || this.ge.length <= 0) {
                return i;
            }
            i2 = 0;
            while (i3 < this.ge.length) {
                i2 += qp.gZ(this.ge[i3]);
                i3++;
            }
            return (i + i2) + (this.ge.length * 1);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1384g)) {
                return false;
            }
            C1384g c1384g = (C1384g) o;
            return (qu.equals(this.fV, c1384g.fV) && qu.equals(this.fW, c1384g.fW) && qu.equals(this.fX, c1384g.fX) && qu.equals(this.fY, c1384g.fY) && qu.equals(this.fZ, c1384g.fZ) && qu.equals(this.ga, c1384g.ga) && qu.equals(this.gb, c1384g.gb) && qu.equals(this.gc, c1384g.gc) && qu.equals(this.gd, c1384g.gd) && qu.equals(this.ge, c1384g.ge)) ? m3539a((qq) c1384g) : false;
        }

        /* renamed from: h */
        public C1384g m4313h(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                int b;
                Object obj;
                int gS;
                Object obj2;
                switch (rz) {
                    case 0:
                        break;
                    case 8:
                        b = qz.m1915b(qoVar, 8);
                        rz = this.fV == null ? 0 : this.fV.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fV, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.fV = obj;
                        continue;
                    case 10:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.fV == null ? 0 : this.fV.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.fV, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.fV = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 16:
                        b = qz.m1915b(qoVar, 16);
                        rz = this.fW == null ? 0 : this.fW.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fW, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.fW = obj;
                        continue;
                    case 18:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.fW == null ? 0 : this.fW.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.fW, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.fW = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 24:
                        b = qz.m1915b(qoVar, 24);
                        rz = this.fX == null ? 0 : this.fX.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fX, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.fX = obj;
                        continue;
                    case 26:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.fX == null ? 0 : this.fX.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.fX, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.fX = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 32:
                        b = qz.m1915b(qoVar, 32);
                        rz = this.fY == null ? 0 : this.fY.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fY, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.fY = obj;
                        continue;
                    case 34:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.fY == null ? 0 : this.fY.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.fY, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.fY = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 40:
                        b = qz.m1915b(qoVar, 40);
                        rz = this.fZ == null ? 0 : this.fZ.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.fZ, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.fZ = obj;
                        continue;
                    case 42:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.fZ == null ? 0 : this.fZ.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.fZ, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.fZ = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 48:
                        b = qz.m1915b(qoVar, 48);
                        rz = this.ga == null ? 0 : this.ga.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.ga, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.ga = obj;
                        continue;
                    case 50:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.ga == null ? 0 : this.ga.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.ga, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.ga = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 56:
                        b = qz.m1915b(qoVar, 56);
                        rz = this.gb == null ? 0 : this.gb.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.gb, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.gb = obj;
                        continue;
                    case 58:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.gb == null ? 0 : this.gb.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.gb, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.gb = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 64:
                        b = qz.m1915b(qoVar, 64);
                        rz = this.gc == null ? 0 : this.gc.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.gc, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.gc = obj;
                        continue;
                    case 66:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.gc == null ? 0 : this.gc.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.gc, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.gc = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 72:
                        b = qz.m1915b(qoVar, 72);
                        rz = this.gd == null ? 0 : this.gd.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.gd, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.gd = obj;
                        continue;
                    case 74:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.gd == null ? 0 : this.gd.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.gd, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.gd = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 80:
                        b = qz.m1915b(qoVar, 80);
                        rz = this.ge == null ? 0 : this.ge.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.ge, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.ge = obj;
                        continue;
                    case 82:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.ge == null ? 0 : this.ge.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.ge, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.ge = obj2;
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

        public int hashCode() {
            return ((((((((((((((((((((qu.hashCode(this.fV) + 527) * 31) + qu.hashCode(this.fW)) * 31) + qu.hashCode(this.fX)) * 31) + qu.hashCode(this.fY)) * 31) + qu.hashCode(this.fZ)) * 31) + qu.hashCode(this.ga)) * 31) + qu.hashCode(this.gb)) * 31) + qu.hashCode(this.gc)) * 31) + qu.hashCode(this.gd)) * 31) + qu.hashCode(this.ge)) * 31) + rQ();
        }

        /* renamed from: m */
        public C1384g m4314m() {
            this.fV = qz.azj;
            this.fW = qz.azj;
            this.fX = qz.azj;
            this.fY = qz.azj;
            this.fZ = qz.azj;
            this.ga = qz.azj;
            this.gb = qz.azj;
            this.gc = qz.azj;
            this.gd = qz.azj;
            this.ge = qz.azj;
            this.ayW = null;
            this.azh = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c$h */
    public static final class C1385h extends qq<C1385h> {
        public static final qr<C1389a, C1385h> gf = qr.m1884a(11, C1385h.class, 810);
        private static final C1385h[] gg = new C1385h[0];
        public int[] gh;
        public int[] gi;
        public int[] gj;
        public int gk;
        public int[] gl;
        public int gm;
        public int gn;

        public C1385h() {
            m4319n();
        }

        /* renamed from: a */
        public void mo2113a(qp qpVar) throws IOException {
            int i = 0;
            if (this.gh != null && this.gh.length > 0) {
                for (int t : this.gh) {
                    qpVar.m1880t(1, t);
                }
            }
            if (this.gi != null && this.gi.length > 0) {
                for (int t2 : this.gi) {
                    qpVar.m1880t(2, t2);
                }
            }
            if (this.gj != null && this.gj.length > 0) {
                for (int t22 : this.gj) {
                    qpVar.m1880t(3, t22);
                }
            }
            if (this.gk != 0) {
                qpVar.m1880t(4, this.gk);
            }
            if (this.gl != null && this.gl.length > 0) {
                while (i < this.gl.length) {
                    qpVar.m1880t(5, this.gl[i]);
                    i++;
                }
            }
            if (this.gm != 0) {
                qpVar.m1880t(6, this.gm);
            }
            if (this.gn != 0) {
                qpVar.m1880t(7, this.gn);
            }
            super.mo2113a(qpVar);
        }

        /* renamed from: b */
        public /* synthetic */ qw mo2964b(qo qoVar) throws IOException {
            return m4318i(qoVar);
        }

        /* renamed from: c */
        protected int mo2114c() {
            int i;
            int i2;
            int i3 = 0;
            int c = super.mo2114c();
            if (this.gh == null || this.gh.length <= 0) {
                i = c;
            } else {
                i2 = 0;
                for (int gZ : this.gh) {
                    i2 += qp.gZ(gZ);
                }
                i = (c + i2) + (this.gh.length * 1);
            }
            if (this.gi != null && this.gi.length > 0) {
                c = 0;
                for (int gZ2 : this.gi) {
                    c += qp.gZ(gZ2);
                }
                i = (i + c) + (this.gi.length * 1);
            }
            if (this.gj != null && this.gj.length > 0) {
                c = 0;
                for (int gZ22 : this.gj) {
                    c += qp.gZ(gZ22);
                }
                i = (i + c) + (this.gj.length * 1);
            }
            if (this.gk != 0) {
                i += qp.m1858v(4, this.gk);
            }
            if (this.gl != null && this.gl.length > 0) {
                i2 = 0;
                while (i3 < this.gl.length) {
                    i2 += qp.gZ(this.gl[i3]);
                    i3++;
                }
                i = (i + i2) + (this.gl.length * 1);
            }
            if (this.gm != 0) {
                i += qp.m1858v(6, this.gm);
            }
            return this.gn != 0 ? i + qp.m1858v(7, this.gn) : i;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1385h)) {
                return false;
            }
            C1385h c1385h = (C1385h) o;
            return (qu.equals(this.gh, c1385h.gh) && qu.equals(this.gi, c1385h.gi) && qu.equals(this.gj, c1385h.gj) && this.gk == c1385h.gk && qu.equals(this.gl, c1385h.gl) && this.gm == c1385h.gm && this.gn == c1385h.gn) ? m3539a((qq) c1385h) : false;
        }

        public int hashCode() {
            return ((((((((((((((qu.hashCode(this.gh) + 527) * 31) + qu.hashCode(this.gi)) * 31) + qu.hashCode(this.gj)) * 31) + this.gk) * 31) + qu.hashCode(this.gl)) * 31) + this.gm) * 31) + this.gn) * 31) + rQ();
        }

        /* renamed from: i */
        public C1385h m4318i(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                int b;
                Object obj;
                int gS;
                Object obj2;
                switch (rz) {
                    case 0:
                        break;
                    case 8:
                        b = qz.m1915b(qoVar, 8);
                        rz = this.gh == null ? 0 : this.gh.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.gh, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.gh = obj;
                        continue;
                    case 10:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.gh == null ? 0 : this.gh.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.gh, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.gh = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 16:
                        b = qz.m1915b(qoVar, 16);
                        rz = this.gi == null ? 0 : this.gi.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.gi, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.gi = obj;
                        continue;
                    case 18:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.gi == null ? 0 : this.gi.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.gi, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.gi = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 24:
                        b = qz.m1915b(qoVar, 24);
                        rz = this.gj == null ? 0 : this.gj.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.gj, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.gj = obj;
                        continue;
                    case 26:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.gj == null ? 0 : this.gj.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.gj, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.gj = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 32:
                        this.gk = qoVar.rC();
                        continue;
                    case 40:
                        b = qz.m1915b(qoVar, 40);
                        rz = this.gl == null ? 0 : this.gl.length;
                        obj = new int[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.gl, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = qoVar.rC();
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = qoVar.rC();
                        this.gl = obj;
                        continue;
                    case 42:
                        gS = qoVar.gS(qoVar.rG());
                        b = qoVar.getPosition();
                        rz = 0;
                        while (qoVar.rL() > 0) {
                            qoVar.rC();
                            rz++;
                        }
                        qoVar.gU(b);
                        b = this.gl == null ? 0 : this.gl.length;
                        obj2 = new int[(rz + b)];
                        if (b != 0) {
                            System.arraycopy(this.gl, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = qoVar.rC();
                            b++;
                        }
                        this.gl = obj2;
                        qoVar.gT(gS);
                        continue;
                    case 48:
                        this.gm = qoVar.rC();
                        continue;
                    case 56:
                        this.gn = qoVar.rC();
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

        /* renamed from: n */
        public C1385h m4319n() {
            this.gh = qz.azj;
            this.gi = qz.azj;
            this.gj = qz.azj;
            this.gk = 0;
            this.gl = qz.azj;
            this.gm = 0;
            this.gn = 0;
            this.ayW = null;
            this.azh = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c$i */
    public static final class C1386i extends qq<C1386i> {
        private static volatile C1386i[] go;
        public C1389a gp;
        public C1381d gq;
        public String name;

        public C1386i() {
            m4325p();
        }

        /* renamed from: o */
        public static C1386i[] m4320o() {
            if (go == null) {
                synchronized (qu.azg) {
                    if (go == null) {
                        go = new C1386i[0];
                    }
                }
            }
            return go;
        }

        /* renamed from: a */
        public void mo2113a(qp qpVar) throws IOException {
            if (!this.name.equals("")) {
                qpVar.m1871b(1, this.name);
            }
            if (this.gp != null) {
                qpVar.m1866a(2, this.gp);
            }
            if (this.gq != null) {
                qpVar.m1866a(3, this.gq);
            }
            super.mo2113a(qpVar);
        }

        /* renamed from: b */
        public /* synthetic */ qw mo2964b(qo qoVar) throws IOException {
            return m4324j(qoVar);
        }

        /* renamed from: c */
        protected int mo2114c() {
            int c = super.mo2114c();
            if (!this.name.equals("")) {
                c += qp.m1855j(1, this.name);
            }
            if (this.gp != null) {
                c += qp.m1847c(2, this.gp);
            }
            return this.gq != null ? c + qp.m1847c(3, this.gq) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1386i)) {
                return false;
            }
            C1386i c1386i = (C1386i) o;
            if (this.name == null) {
                if (c1386i.name != null) {
                    return false;
                }
            } else if (!this.name.equals(c1386i.name)) {
                return false;
            }
            if (this.gp == null) {
                if (c1386i.gp != null) {
                    return false;
                }
            } else if (!this.gp.equals(c1386i.gp)) {
                return false;
            }
            if (this.gq == null) {
                if (c1386i.gq != null) {
                    return false;
                }
            } else if (!this.gq.equals(c1386i.gq)) {
                return false;
            }
            return m3539a((qq) c1386i);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.gp == null ? 0 : this.gp.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + 527) * 31)) * 31;
            if (this.gq != null) {
                i = this.gq.hashCode();
            }
            return ((hashCode + i) * 31) + rQ();
        }

        /* renamed from: j */
        public C1386i m4324j(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case 0:
                        break;
                    case 10:
                        this.name = qoVar.readString();
                        continue;
                    case 18:
                        if (this.gp == null) {
                            this.gp = new C1389a();
                        }
                        qoVar.m1834a(this.gp);
                        continue;
                    case 26:
                        if (this.gq == null) {
                            this.gq = new C1381d();
                        }
                        qoVar.m1834a(this.gq);
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

        /* renamed from: p */
        public C1386i m4325p() {
            this.name = "";
            this.gp = null;
            this.gq = null;
            this.ayW = null;
            this.azh = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c$j */
    public static final class C1387j extends qq<C1387j> {
        public C1386i[] gr;
        public C1383f gs;
        public String gt;

        public C1387j() {
            m4331q();
        }

        /* renamed from: b */
        public static C1387j m4326b(byte[] bArr) throws qv {
            return (C1387j) qw.m1903a(new C1387j(), bArr);
        }

        /* renamed from: a */
        public void mo2113a(qp qpVar) throws IOException {
            if (this.gr != null && this.gr.length > 0) {
                for (qw qwVar : this.gr) {
                    if (qwVar != null) {
                        qpVar.m1866a(1, qwVar);
                    }
                }
            }
            if (this.gs != null) {
                qpVar.m1866a(2, this.gs);
            }
            if (!this.gt.equals("")) {
                qpVar.m1871b(3, this.gt);
            }
            super.mo2113a(qpVar);
        }

        /* renamed from: b */
        public /* synthetic */ qw mo2964b(qo qoVar) throws IOException {
            return m4330k(qoVar);
        }

        /* renamed from: c */
        protected int mo2114c() {
            int c = super.mo2114c();
            if (this.gr != null && this.gr.length > 0) {
                for (qw qwVar : this.gr) {
                    if (qwVar != null) {
                        c += qp.m1847c(1, qwVar);
                    }
                }
            }
            if (this.gs != null) {
                c += qp.m1847c(2, this.gs);
            }
            return !this.gt.equals("") ? c + qp.m1855j(3, this.gt) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1387j)) {
                return false;
            }
            C1387j c1387j = (C1387j) o;
            if (!qu.equals(this.gr, c1387j.gr)) {
                return false;
            }
            if (this.gs == null) {
                if (c1387j.gs != null) {
                    return false;
                }
            } else if (!this.gs.equals(c1387j.gs)) {
                return false;
            }
            if (this.gt == null) {
                if (c1387j.gt != null) {
                    return false;
                }
            } else if (!this.gt.equals(c1387j.gt)) {
                return false;
            }
            return m3539a((qq) c1387j);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.gs == null ? 0 : this.gs.hashCode()) + ((qu.hashCode(this.gr) + 527) * 31)) * 31;
            if (this.gt != null) {
                i = this.gt.hashCode();
            }
            return ((hashCode + i) * 31) + rQ();
        }

        /* renamed from: k */
        public C1387j m4330k(qo qoVar) throws IOException {
            while (true) {
                int rz = qoVar.rz();
                switch (rz) {
                    case 0:
                        break;
                    case 10:
                        int b = qz.m1915b(qoVar, 10);
                        rz = this.gr == null ? 0 : this.gr.length;
                        Object obj = new C1386i[(b + rz)];
                        if (rz != 0) {
                            System.arraycopy(this.gr, 0, obj, 0, rz);
                        }
                        while (rz < obj.length - 1) {
                            obj[rz] = new C1386i();
                            qoVar.m1834a(obj[rz]);
                            qoVar.rz();
                            rz++;
                        }
                        obj[rz] = new C1386i();
                        qoVar.m1834a(obj[rz]);
                        this.gr = obj;
                        continue;
                    case 18:
                        if (this.gs == null) {
                            this.gs = new C1383f();
                        }
                        qoVar.m1834a(this.gs);
                        continue;
                    case 26:
                        this.gt = qoVar.readString();
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

        /* renamed from: q */
        public C1387j m4331q() {
            this.gr = C1386i.m4320o();
            this.gs = null;
            this.gt = "";
            this.ayW = null;
            this.azh = -1;
            return this;
        }
    }
}
