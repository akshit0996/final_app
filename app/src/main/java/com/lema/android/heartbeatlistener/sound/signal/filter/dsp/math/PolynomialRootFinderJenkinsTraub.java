package com.lema.android.heartbeatlistener.sound.signal.filter.dsp.math;

public class PolynomialRootFinderJenkinsTraub {

    private static class GlobalEnvironment {
        private static final double are = 2.22E-16d;
        private static final double base = 2.0d;
        private static final double cosr = Math.cos(rotationAngle);
        private static final double eta = 2.22E-16d;
        private static final double infin = 3.4028234663852886E38d;
        private static final double mre = 2.22E-16d;
        private static final double rotationAngle = 1.6406094968746698d;
        private static final double rotationAngleDeg = 94.0d;
        private static final double sinr = Math.sin(rotationAngle);
        private static final double smalno = 1.1754943508222875E-38d;
        /* renamed from: a */
        private double f72a;
        private double a1;
        private double a2;
        private double a3;
        private double a6;
        private double a7;
        /* renamed from: b */
        private double f73b;
        /* renamed from: c */
        private double f74c;
        /* renamed from: d */
        private double f75d;
        /* renamed from: e */
        private double f76e;
        /* renamed from: f */
        private double f77f;
        /* renamed from: g */
        private double f78g;
        /* renamed from: h */
        private double f79h;
        /* renamed from: k */
        private double[] f80k;
        private Complex lz;
        /* renamed from: n */
        private int f81n;
        private int nn;
        /* renamed from: p */
        private double[] f82p;
        private double[] qk;
        private double[] qp;
        private Complex sz;
        /* renamed from: u */
        private double f83u;
        /* renamed from: v */
        private double f84v;

        private static class RealitOut {
            boolean iflag;
            int nz;
            double sss;

            RealitOut(double sss, int nz, boolean iflag) {
                this.sss = sss;
                this.nz = nz;
                this.iflag = iflag;
            }
        }

        private GlobalEnvironment() {
        }

        private Complex[] rpoly(double[] coeffs) {
            int degree = coeffs.length - 1;
            Complex[] zeros = new Complex[degree];
            double xx = Math.sqrt(0.5d);
            double yy = -xx;
            this.f81n = degree;
            if (coeffs[0] == 0.0d) {
                throw new IllegalArgumentException("The leading coefficient must not be zero.");
            }
            int i;
            while (this.f81n > 0 && coeffs[this.f81n] == 0.0d) {
                zeros[degree - this.f81n] = Complex.ZERO;
                this.f81n--;
            }
            this.nn = this.f81n + 1;
            this.f82p = new double[(this.nn + 1)];
            for (i = 1; i <= this.nn; i++) {
                this.f82p[i] = coeffs[i - 1];
            }
            while (this.f81n >= 1) {
                if (this.f81n == 1) {
                    zeros[degree - 1] = new Complex((-this.f82p[2]) / this.f82p[1]);
                    break;
                } else if (this.f81n == 2) {
                    Complex[] temp1 = PolynomialRootFinderJenkinsTraub.quad(this.f82p[1], this.f82p[2], this.f82p[3]);
                    zeros[degree - 2] = temp1[0];
                    zeros[degree - 1] = temp1[1];
                    break;
                } else {
                    double x;
                    double xm;
                    double ff;
                    int nz;
                    double max = 0.0d;
                    double min = infin;
                    for (i = 1; i <= this.nn; i++) {
                        x = Math.abs(this.f82p[i]);
                        if (x > max) {
                            max = x;
                        }
                        if (x != 0.0d && x < min) {
                            min = x;
                        }
                    }
                    double sc = 5.295019598298592E-23d / min;
                    if (sc == 0.0d) {
                        sc = smalno;
                    }
                    if ((sc > 1.0d && infin / sc >= max) || (sc <= 1.0d && max > 10.0d)) {
                        double factor = Math.pow(base, (Math.log(sc) / Math.log(base)) + 0.5d);
                        if (factor != 1.0d) {
                            for (i = 1; i <= this.nn; i++) {
                                this.f82p[i] = this.f82p[i] * factor;
                            }
                        }
                    }
                    double[] pt = new double[(this.nn + 1)];
                    for (i = 1; i <= this.nn; i++) {
                        pt[i] = Math.abs(this.f82p[i]);
                    }
                    pt[this.nn] = -pt[this.nn];
                    x = Math.exp((Math.log(-pt[this.nn]) - Math.log(pt[1])) / ((double) this.f81n));
                    if (pt[this.f81n] != 0.0d) {
                        xm = (-pt[this.nn]) / pt[this.f81n];
                        if (xm < x) {
                            x = xm;
                        }
                    }
                    while (true) {
                        xm = x * 0.1d;
                        ff = pt[1];
                        for (i = 2; i <= this.nn; i++) {
                            ff = (ff * xm) + pt[i];
                        }
                        if (ff <= 0.0d) {
                            break;
                        }
                        x = xm;
                    }
                    double dx = x;
                    while (Math.abs(dx / x) > 0.005d) {
                        ff = pt[1];
                        double df = ff;
                        for (i = 2; i <= this.f81n; i++) {
                            ff = (ff * x) + pt[i];
                            df = (df * x) + ff;
                        }
                        dx = ((ff * x) + pt[this.nn]) / df;
                        x -= dx;
                    }
                    double bnd = x;
                    int nm1 = this.f81n - 1;
                    this.f80k = new double[(this.f81n + 1)];
                    for (i = 2; i <= this.f81n; i++) {
                        this.f80k[i] = (((double) (this.nn - i)) * this.f82p[i]) / ((double) this.f81n);
                    }
                    this.f80k[1] = this.f82p[1];
                    double aa = this.f82p[this.nn];
                    double bb = this.f82p[this.f81n];
                    boolean zerok = this.f80k[this.f81n] == 0.0d;
                    for (int jj = 1; jj <= 5; jj++) {
                        double cc = this.f80k[this.f81n];
                        int j;
                        if (zerok) {
                            for (i = 1; i <= nm1; i++) {
                                j = this.nn - i;
                                this.f80k[j] = this.f80k[j - 1];
                            }
                            this.f80k[1] = 0.0d;
                            if (this.f80k[this.f81n] == 0.0d) {
                                zerok = true;
                            } else {
                                zerok = false;
                            }
                        } else {
                            double t = (-aa) / cc;
                            for (i = 1; i <= nm1; i++) {
                                j = this.nn - i;
                                this.f80k[j] = (this.f80k[j - 1] * t) + this.f82p[j];
                            }
                            this.f80k[1] = this.f82p[1];
                            zerok = Math.abs(this.f80k[this.f81n]) <= (Math.abs(bb) * 2.22E-16d) * 10.0d;
                        }
                    }
                    double[] temp = new double[(this.f81n + 1)];
                    for (i = 1; i <= this.f81n; i++) {
                        temp[i] = this.f80k[i];
                    }
                    int cnt = 1;
                    while (true) {
                        double xxx = (cosr * xx) - (sinr * yy);
                        yy = (sinr * xx) + (cosr * yy);
                        xx = xxx;
                        double sr = bnd * xx;
                        this.f83u = -2.0d * sr;
                        this.f84v = bnd;
                        this.qp = new double[(this.nn + 1)];
                        this.qk = new double[(this.f81n + 1)];
                        nz = fxshfr(cnt * 20, sr);
                        if (nz > 0) {
                            break;
                        }
                        for (i = 1; i <= this.f81n; i++) {
                            this.f80k[i] = temp[i];
                        }
                        int cnt2 = cnt + 1;
                        if (cnt > 20) {
                            throw new RuntimeException("No convergence.");
                        }
                        cnt = cnt2;
                    }
                    zeros[degree - this.f81n] = this.sz;
                    if (nz > 1) {
                        zeros[(degree - this.f81n) + 1] = this.lz;
                    }
                    this.nn -= nz;
                    this.f81n = this.nn - 1;
                    for (i = 1; i <= this.nn; i++) {
                        this.f82p[i] = this.qp[i];
                    }
                    this.qp = null;
                    this.qk = null;
                }
            }
            return zeros;
        }

        private int fxshfr(int l2, double sr) {
            double ots = 0.0d;
            double otv = 0.0d;
            double betav = 0.25d;
            double betas = 0.25d;
            double oss = sr;
            double ovv = this.f84v;
            double[] temp1 = new double[2];
            PolynomialRootFinderJenkinsTraub.quadsd(this.nn, this.f83u, this.f84v, this.f82p, this.qp, temp1);
            this.f72a = temp1[0];
            this.f73b = temp1[1];
            int type = calcsc();
            for (int j = 1; j <= l2; j++) {
                nextk(type);
                type = calcsc();
                double[] temp2 = newest(type);
                double ui = temp2[0];
                double vi = temp2[1];
                double vv = vi;
                double ss = 0.0d;
                if (this.f80k[this.f81n] != 0.0d) {
                    ss = (-this.f82p[this.nn]) / this.f80k[this.f81n];
                }
                double tv = 1.0d;
                double ts = 1.0d;
                if (!(j == 1 || type == 3)) {
                    if (vv != 0.0d) {
                        tv = Math.abs((vv - ovv) / vv);
                    }
                    if (ss != 0.0d) {
                        ts = Math.abs((ss - oss) / ss);
                    }
                    double tvv = tv < otv ? tv * otv : 1.0d;
                    double tss = ts < ots ? ts * ots : 1.0d;
                    boolean vpass = tvv < betav;
                    boolean spass = tss < betas;
                    if (spass || vpass) {
                        int i;
                        double svu = this.f83u;
                        double svv = this.f84v;
                        double[] svk = new double[(this.f81n + 1)];
                        for (i = 1; i <= this.f81n; i++) {
                            svk[i] = this.f80k[i];
                        }
                        double s = ss;
                        boolean vtry = false;
                        boolean stry = false;
                        int state = (!spass || (vpass && tss >= tvv)) ? 20 : 40;
                        while (state != 70) {
                            switch (state) {
                                case 20:
                                    int nz = quadit(ui, vi);
                                    if (nz <= 0) {
                                        vtry = true;
                                        betav *= 0.25d;
                                        if (!stry && spass) {
                                            for (i = 1; i <= this.f81n; i++) {
                                                this.f80k[i] = svk[i];
                                            }
                                            state = 40;
                                            break;
                                        }
                                        state = 50;
                                        break;
                                    }
                                    return nz;
                                case 40:
                                    RealitOut realitOut = realit(s);
                                    if (realitOut.nz <= 0) {
                                        s = realitOut.sss;
                                        stry = true;
                                        betas *= 0.25d;
                                        if (!realitOut.iflag) {
                                            ui = -(s + s);
                                            vi = s * s;
                                            state = 20;
                                            break;
                                        }
                                        state = 50;
                                        break;
                                    }
                                    return realitOut.nz;
                                case 50:
                                    this.f83u = svu;
                                    this.f84v = svv;
                                    for (i = 1; i <= this.f81n; i++) {
                                        this.f80k[i] = svk[i];
                                    }
                                    if (vpass && !vtry) {
                                        state = 20;
                                        break;
                                    }
                                    double[] temp3 = new double[2];
                                    PolynomialRootFinderJenkinsTraub.quadsd(this.nn, this.f83u, this.f84v, this.f82p, this.qp, temp3);
                                    this.f72a = temp3[0];
                                    this.f73b = temp3[1];
                                    type = calcsc();
                                    state = 70;
                                    break;
                                default:
                                    throw new AssertionError();
                            }
                        }
                        continue;
                    }
                }
                ovv = vv;
                oss = ss;
                otv = tv;
                ots = ts;
            }
            return 0;
        }

        private int quadit(double uu, double vv) {
            boolean tried = false;
            double omp = 0.0d;
            double relstp = 0.0d;
            this.f83u = uu;
            this.f84v = vv;
            int j = 0;
            while (true) {
                Complex[] zeros = PolynomialRootFinderJenkinsTraub.quad(1.0d, this.f83u, this.f84v);
                this.sz = zeros[0];
                this.lz = zeros[1];
                if (Math.abs(Math.abs(this.sz.re()) - Math.abs(this.lz.re())) > 0.01d * Math.abs(this.lz.re())) {
                    return 0;
                }
                int i;
                double[] temp1 = new double[2];
                PolynomialRootFinderJenkinsTraub.quadsd(this.nn, this.f83u, this.f84v, this.f82p, this.qp, temp1);
                this.f72a = temp1[0];
                this.f73b = temp1[1];
                double mp = Math.abs(this.f72a - (this.sz.re() * this.f73b)) + Math.abs(this.sz.im() * this.f73b);
                double zm = Math.sqrt(Math.abs(this.f84v));
                double ee = base * Math.abs(this.qp[1]);
                double t = (-this.sz.re()) * this.f73b;
                for (i = 2; i <= this.f81n; i++) {
                    ee = (ee * zm) + Math.abs(this.qp[i]);
                }
                if (mp <= 20.0d * (((1.998E-15d * ((ee * zm) + Math.abs(this.f72a + t))) - (1.554E-15d * (Math.abs(this.f72a + t) + (Math.abs(this.f73b) * zm)))) + (4.44E-16d * Math.abs(t)))) {
                    return 2;
                }
                j++;
                if (j > 20) {
                    return 0;
                }
                double[] temp2;
                if (j >= 2 && relstp <= 0.01d && mp >= omp && !tried) {
                    if (relstp < 2.22E-16d) {
                        relstp = 2.22E-16d;
                    }
                    relstp = Math.sqrt(relstp);
                    this.f83u -= this.f83u * relstp;
                    this.f84v += this.f84v * relstp;
                    temp2 = new double[2];
                    PolynomialRootFinderJenkinsTraub.quadsd(this.nn, this.f83u, this.f84v, this.f82p, this.qp, temp2);
                    this.f72a = temp2[0];
                    this.f73b = temp2[1];
                    for (i = 1; i <= 5; i++) {
                        nextk(calcsc());
                    }
                    tried = true;
                    j = 0;
                }
                omp = mp;
                nextk(calcsc());
                temp2 = newest(calcsc());
                double ui = temp2[0];
                double vi = temp2[1];
                if (vi == 0.0d) {
                    return 0;
                }
                relstp = Math.abs((vi - this.f84v) / vi);
                this.f83u = ui;
                this.f84v = vi;
            }
        }

        private RealitOut realit(double sss) {
            double omp = 0.0d;
            double t = 0.0d;
            double s = sss;
            int j = 0;
            while (true) {
                int i;
                double pv = this.f82p[1];
                this.qp[1] = pv;
                for (i = 2; i <= this.nn; i++) {
                    pv = (pv * s) + this.f82p[i];
                    this.qp[i] = pv;
                }
                double mp = Math.abs(pv);
                double ms = Math.abs(s);
                double ee = 0.5d * Math.abs(this.qp[1]);
                for (i = 2; i <= this.nn; i++) {
                    ee = (ee * ms) + Math.abs(this.qp[i]);
                }
                if (mp <= 20.0d * ((4.44E-16d * ee) - (2.22E-16d * mp))) {
                    this.sz = new Complex(s);
                    return new RealitOut(sss, 1, false);
                }
                j++;
                if (j > 10) {
                    return new RealitOut(sss, 0, false);
                }
                if (j >= 2 && Math.abs(t) <= 0.001d * Math.abs(s - t) && mp > omp) {
                    return new RealitOut(s, 0, true);
                }
                omp = mp;
                double kv = this.f80k[1];
                this.qk[1] = kv;
                for (i = 2; i <= this.f81n; i++) {
                    kv = (kv * s) + this.f80k[i];
                    this.qk[i] = kv;
                }
                if (Math.abs(kv) <= (Math.abs(this.f80k[this.f81n]) * 10.0d) * 2.22E-16d) {
                    this.f80k[1] = 0.0d;
                    for (i = 2; i <= this.f81n; i++) {
                        this.f80k[i] = this.qk[i - 1];
                    }
                } else {
                    t = (-pv) / kv;
                    this.f80k[1] = this.qp[1];
                    for (i = 2; i <= this.f81n; i++) {
                        this.f80k[i] = (this.qk[i - 1] * t) + this.qp[i];
                    }
                }
                kv = this.f80k[1];
                for (i = 2; i <= this.f81n; i++) {
                    kv = (kv * s) + this.f80k[i];
                }
                t = 0.0d;
                if (Math.abs(kv) > (Math.abs(this.f80k[this.f81n]) * 10.0d) * 2.22E-16d) {
                    t = (-pv) / kv;
                }
                s += t;
            }
        }

        private int calcsc() {
            double[] temp = new double[2];
            PolynomialRootFinderJenkinsTraub.quadsd(this.f81n, this.f83u, this.f84v, this.f80k, this.qk, temp);
            this.f74c = temp[0];
            this.f75d = temp[1];
            if (Math.abs(this.f74c) <= (Math.abs(this.f80k[this.f81n]) * 100.0d) * 2.22E-16d || Math.abs(this.f75d) <= (Math.abs(this.f80k[this.f81n - 1]) * 100.0d) * 2.22E-16d) {
                return 3;
            }
            if (Math.abs(this.f75d) < Math.abs(this.f74c)) {
                this.f76e = this.f72a / this.f74c;
                this.f77f = this.f75d / this.f74c;
                this.f78g = this.f83u * this.f76e;
                this.f79h = this.f84v * this.f73b;
                this.a3 = (this.f72a * this.f76e) + (((this.f79h / this.f74c) + this.f78g) * this.f73b);
                this.a1 = this.f73b - (this.f72a * (this.f75d / this.f74c));
                this.a7 = (this.f72a + (this.f78g * this.f75d)) + (this.f79h * this.f77f);
                return 1;
            }
            this.f76e = this.f72a / this.f75d;
            this.f77f = this.f74c / this.f75d;
            this.f78g = this.f83u * this.f73b;
            this.f79h = this.f84v * this.f73b;
            this.a3 = ((this.f72a + this.f78g) * this.f76e) + (this.f79h * (this.f73b / this.f75d));
            this.a1 = (this.f73b * this.f77f) - this.f72a;
            this.a7 = ((this.f77f + this.f83u) * this.f72a) + this.f79h;
            return 2;
        }

        private void nextk(int type) {
            int i;
            if (type == 3) {
                this.f80k[1] = 0.0d;
                this.f80k[2] = 0.0d;
                for (i = 3; i <= this.f81n; i++) {
                    this.f80k[i] = this.qk[i - 2];
                }
                return;
            }
            if (Math.abs(this.a1) > (Math.abs(type == 1 ? this.f73b : this.f72a) * 2.22E-16d) * 10.0d) {
                this.a7 /= this.a1;
                this.a3 /= this.a1;
                this.f80k[1] = this.qp[1];
                this.f80k[2] = this.qp[2] - (this.a7 * this.qp[1]);
                for (i = 3; i <= this.f81n; i++) {
                    this.f80k[i] = ((this.a3 * this.qk[i - 2]) - (this.a7 * this.qp[i - 1])) + this.qp[i];
                }
                return;
            }
            this.f80k[1] = 0.0d;
            this.f80k[2] = (-this.a7) * this.qp[1];
            for (i = 3; i <= this.f81n; i++) {
                this.f80k[i] = (this.a3 * this.qk[i - 2]) - (this.a7 * this.qp[i - 1]);
            }
        }

        private double[] newest(int type) {
            if (type == 3) {
                double[] dArr = new double[2];
                return new double[]{0.0d, 0.0d};
            }
            double a4;
            double a5;
            if (type == 2) {
                a4 = ((this.f72a + this.f78g) * this.f77f) + this.f79h;
                a5 = ((this.f77f + this.f83u) * this.f74c) + (this.f84v * this.f75d);
            } else {
                a4 = (this.f72a + (this.f83u * this.f73b)) + (this.f79h * this.f77f);
                a5 = this.f74c + ((this.f83u + (this.f84v * this.f77f)) * this.f75d);
            }
            double b1 = (-this.f80k[this.f81n]) / this.f82p[this.nn];
            double b2 = (-(this.f80k[this.f81n - 1] + (this.f82p[this.f81n] * b1))) / this.f82p[this.nn];
            double c2 = b1 * this.a7;
            double c3 = (b1 * b1) * this.a3;
            double c4 = (((this.f84v * b2) * this.a1) - c2) - c3;
            double temp = ((b1 * a4) + a5) - c4;
            if (temp == 0.0d) {
                dArr = new double[2];
                return new double[]{0.0d, 0.0d};
            }
            double uu = this.f83u - (((this.f83u * (c3 + c2)) + (this.f84v * ((this.a1 * b1) + (this.a7 * b2)))) / temp);
            double vv = this.f84v * (1.0d + (c4 / temp));
            return new double[]{uu, vv};
        }
    }

    private PolynomialRootFinderJenkinsTraub() {
    }

    public static Complex[] findRoots(double[] coeffs) {
        return new GlobalEnvironment().rpoly(coeffs);
    }

    private static void quadsd(int nn, double u, double v, double[] p, double[] q, double[] rem) {
        double b = p[1];
        q[1] = b;
        double a = p[2] - (u * b);
        q[2] = a;
        for (int i = 3; i <= nn; i++) {
            double c = (p[i] - (u * a)) - (v * b);
            q[i] = c;
            b = a;
            a = c;
        }
        rem[0] = a;
        rem[1] = b;
    }

    private static Complex[] quad(double a, double b, double c) {
        if (a == 0.0d && b == 0.0d) {
            return new Complex[]{new Complex(0.0d), new Complex(0.0d)};
        } else if (a == 0.0d) {
            return new Complex[]{new Complex((-c) / b), new Complex(0.0d)};
        } else if (c == 0.0d) {
            return new Complex[]{new Complex(0.0d), new Complex((-b) / a)};
        } else {
            double e;
            double d;
            double b2 = b / 2.0d;
            if (Math.abs(b2) < Math.abs(c)) {
                e = ((b2 / Math.abs(c)) * b2) - (c >= 0.0d ? a : -a);
                d = Math.sqrt(Math.abs(e)) * Math.sqrt(Math.abs(c));
            } else {
                e = 1.0d - ((a / b2) * (c / b2));
                d = Math.sqrt(Math.abs(e)) * Math.abs(b2);
            }
            if (e >= 0.0d) {
                double d2;
                if (b2 >= 0.0d) {
                    d2 = -d;
                } else {
                    d2 = d;
                }
                double lr = ((-b2) + d2) / a;
                double sr = lr != 0.0d ? (c / lr) / a : 0.0d;
                return new Complex[]{new Complex(sr), new Complex(lr)};
            }
            Complex z1 = new Complex((-b2) / a, Math.abs(d / a));
            return new Complex[]{z1, z1.conj()};
        }
    }
}
