package com.lema.android.heartbeatlistener.sound.signal.filter.dsp.filter;

import com.lema.android.heartbeatlistener.sound.signal.filter.dsp.util.ArrayUtils;

public class IirFilterDesignExstrom {
    /* renamed from: $SWITCH_TABLE$com$lema$android$heartbeatlistener$sound$signal$filter$dsp$filter$FilterPassType */
    private static /* synthetic */ int[] f67x5618f1a7;

    /* renamed from: $SWITCH_TABLE$com$lema$android$heartbeatlistener$sound$signal$filter$dsp$filter$FilterPassType */
    static /* synthetic */ int[] m2335x5618f1a7() {
        int[] iArr = f67x5618f1a7;
        if (iArr == null) {
            iArr = new int[FilterPassType.values().length];
            try {
                iArr[FilterPassType.bandpass.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[FilterPassType.bandstop.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[FilterPassType.highpass.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[FilterPassType.lowpass.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            f67x5618f1a7 = iArr;
        }
        return iArr;
    }

    private IirFilterDesignExstrom() {
    }

    public static IirFilterCoefficients design(FilterPassType filterPassType, int filterOrder, double fcf1, double fcf2) {
        if (filterOrder < 1) {
            throw new IllegalArgumentException("Invalid filterOrder.");
        } else if (fcf1 <= 0.0d || fcf1 >= 0.5d) {
            throw new IllegalArgumentException("Invalid fcf1.");
        } else if ((filterPassType == FilterPassType.bandpass || filterPassType == FilterPassType.bandstop) && (fcf2 <= 0.0d || fcf2 >= 0.5d)) {
            throw new IllegalArgumentException("Invalid fcf2.");
        } else {
            IirFilterCoefficients coeffs = new IirFilterCoefficients();
            coeffs.f65a = calculateACoefficients(filterPassType, filterOrder, fcf1, fcf2);
            coeffs.f66b = ArrayUtils.multiply(calculateBCoefficients(filterPassType, filterOrder, fcf1, fcf2), calculateScalingFactor(filterPassType, filterOrder, fcf1, fcf2));
            return coeffs;
        }
    }

    private static double[] calculateACoefficients(FilterPassType filterPassType, int filterOrder, double fcf1, double fcf2) {
        switch (m2335x5618f1a7()[filterPassType.ordinal()]) {
            case 1:
            case 2:
                return calculateACoefficients_lp_hp(filterOrder, fcf1);
            case 3:
            case 4:
                return calculateACoefficients_bp_bs(filterPassType, filterOrder, fcf1, fcf2);
            default:
                throw new AssertionError();
        }
    }

    private static double[] calculateACoefficients_lp_hp(int n, double fcf) {
        int k;
        double[] rcof = new double[(n * 2)];
        double theta = 6.283185307179586d * fcf;
        double st = Math.sin(theta);
        double ct = Math.cos(theta);
        for (k = 0; k < n; k++) {
            double parg = (3.141592653589793d * ((double) ((k * 2) + 1))) / ((double) (n * 2));
            double sparg = Math.sin(parg);
            double cparg = Math.cos(parg);
            double a = 1.0d + (st * sparg);
            rcof[k * 2] = (-ct) / a;
            rcof[(k * 2) + 1] = ((-st) * cparg) / a;
        }
        double[] wcof = binomial_mult(n, rcof);
        double[] dcof = new double[(n + 1)];
        dcof[0] = 1.0d;
        for (k = 1; k <= n; k++) {
            dcof[k] = wcof[(k * 2) - 2];
        }
        return dcof;
    }

    private static double[] calculateACoefficients_bp_bs(FilterPassType filterPassType, int n, double f1f, double f2f) {
        int k;
        double cp = Math.cos((6.283185307179586d * (f2f + f1f)) / 2.0d);
        double theta = (6.283185307179586d * (f2f - f1f)) / 2.0d;
        double st = Math.sin(theta);
        double ct = Math.cos(theta);
        double s2t = (2.0d * st) * ct;
        double c2t = ((2.0d * ct) * ct) - 1.0d;
        double[] rcof = new double[(n * 2)];
        double[] tcof = new double[(n * 2)];
        double flip = (double) (filterPassType == FilterPassType.bandstop ? -1 : 1);
        for (k = 0; k < n; k++) {
            double parg = (3.141592653589793d * ((double) ((k * 2) + 1))) / ((double) (n * 2));
            double sparg = Math.sin(parg);
            double cparg = Math.cos(parg);
            double a = 1.0d + (s2t * sparg);
            rcof[k * 2] = c2t / a;
            rcof[(k * 2) + 1] = ((s2t * cparg) / a) * flip;
            tcof[k * 2] = ((-2.0d * cp) * ((st * sparg) + ct)) / a;
            tcof[(k * 2) + 1] = ((((-2.0d * cp) * st) * cparg) / a) * flip;
        }
        double[] wcof = trinomial_mult(n, tcof, rcof);
        double[] dcof = new double[((n * 2) + 1)];
        dcof[0] = 1.0d;
        for (k = 1; k <= n * 2; k++) {
            dcof[k] = wcof[(k * 2) - 2];
        }
        return dcof;
    }

    private static double[] calculateBCoefficients(FilterPassType filterPassType, int filterOrder, double fcf1, double fcf2) {
        switch (m2335x5618f1a7()[filterPassType.ordinal()]) {
            case 1:
                return ArrayUtils.toDouble(calculateBCoefficients_lp(filterOrder));
            case 2:
                return ArrayUtils.toDouble(calculateBCoefficients_hp(filterOrder));
            case 3:
                return ArrayUtils.toDouble(calculateBCoefficients_bp(filterOrder));
            case 4:
                return calculateBCoefficients_bs(filterOrder, fcf1, fcf2);
            default:
                throw new AssertionError();
        }
    }

    private static int[] calculateBCoefficients_lp(int n) {
        int[] ccof = new int[(n + 1)];
        ccof[0] = 1;
        ccof[1] = n;
        int m = n / 2;
        for (int i = 2; i <= m; i++) {
            ccof[i] = (((n - i) + 1) * ccof[i - 1]) / i;
            ccof[n - i] = ccof[i];
        }
        ccof[n - 1] = n;
        ccof[n] = 1;
        return ccof;
    }

    private static int[] calculateBCoefficients_hp(int n) {
        int[] ccof = calculateBCoefficients_lp(n);
        for (int i = 1; i <= n; i += 2) {
            ccof[i] = -ccof[i];
        }
        return ccof;
    }

    private static int[] calculateBCoefficients_bp(int n) {
        int[] tcof = calculateBCoefficients_hp(n);
        int[] ccof = new int[((n * 2) + 1)];
        for (int i = 0; i < n; i++) {
            ccof[i * 2] = tcof[i];
            ccof[(i * 2) + 1] = 0;
        }
        ccof[n * 2] = tcof[n];
        return ccof;
    }

    private static double[] calculateBCoefficients_bs(int n, double f1f, double f2f) {
        double alpha = (-2.0d * Math.cos((6.283185307179586d * (f2f + f1f)) / 2.0d)) / Math.cos((6.283185307179586d * (f2f - f1f)) / 2.0d);
        double[] ccof = new double[((n * 2) + 1)];
        ccof[0] = 1.0d;
        ccof[1] = alpha;
        ccof[2] = 1.0d;
        for (int i = 1; i < n; i++) {
            int i2 = (i * 2) + 2;
            ccof[i2] = ccof[i2] + ccof[i * 2];
            for (int j = i * 2; j > 1; j--) {
                i2 = j + 1;
                ccof[i2] = ccof[i2] + ((ccof[j] * alpha) + ccof[j - 1]);
            }
            ccof[2] = ccof[2] + ((ccof[1] * alpha) + 1.0d);
            ccof[1] = ccof[1] + alpha;
        }
        return ccof;
    }

    private static double calculateScalingFactor(FilterPassType filterPassType, int filterOrder, double fcf1, double fcf2) {
        switch (m2335x5618f1a7()[filterPassType.ordinal()]) {
            case 1:
            case 2:
                return calculateScalingFactor_lp_hp(filterPassType, filterOrder, fcf1);
            case 3:
            case 4:
                return calculateScalingFactor_bp_bs(filterPassType, filterOrder, fcf1, fcf2);
            default:
                throw new AssertionError();
        }
    }

    private static double calculateScalingFactor_lp_hp(FilterPassType filterPassType, int n, double fcf) {
        double fomega2;
        double omega = 6.283185307179586d * fcf;
        double fomega = Math.sin(omega);
        double parg0 = 3.141592653589793d / ((double) (n * 2));
        int m = n / 2;
        double sf = 1.0d;
        for (int k = 0; k < n / 2; k++) {
            sf *= 1.0d + (Math.sin(((double) ((k * 2) + 1)) * parg0) * fomega);
        }
        switch (m2335x5618f1a7()[filterPassType.ordinal()]) {
            case 1:
                fomega2 = Math.sin(omega / 2.0d);
                if (n % 2 != 0) {
                    sf *= Math.cos(omega / 2.0d) + fomega2;
                    break;
                }
                break;
            case 2:
                fomega2 = Math.cos(omega / 2.0d);
                if (n % 2 != 0) {
                    sf *= Math.sin(omega / 2.0d) + fomega2;
                    break;
                }
                break;
            default:
                throw new AssertionError();
        }
        return Math.pow(fomega2, (double) n) / sf;
    }

    private static double calculateScalingFactor_bp_bs(FilterPassType filterPassType, int n, double f1f, double f2f) {
        double ctt_tt;
        double tt = Math.tan((6.283185307179586d * (f2f - f1f)) / 2.0d);
        if (filterPassType == FilterPassType.bandpass) {
            ctt_tt = 1.0d / tt;
        } else {
            ctt_tt = tt;
        }
        double sfr = 1.0d;
        double sfi = 0.0d;
        for (int k = 0; k < n; k++) {
            double parg = (3.141592653589793d * ((double) ((k * 2) + 1))) / ((double) (n * 2));
            double sparg = ctt_tt + Math.sin(parg);
            double cparg = Math.cos(parg);
            double a = (sfr + sfi) * (sparg - cparg);
            double b = sfr * sparg;
            double c = (-sfi) * cparg;
            sfr = b - c;
            sfi = (a - b) - c;
        }
        return 1.0d / sfr;
    }

    private static double[] binomial_mult(int n, double[] p) {
        double[] a = new double[(n * 2)];
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                int i2 = j * 2;
                a[i2] = a[i2] + ((p[i * 2] * a[(j - 1) * 2]) - (p[(i * 2) + 1] * a[((j - 1) * 2) + 1]));
                i2 = (j * 2) + 1;
                a[i2] = a[i2] + ((p[i * 2] * a[((j - 1) * 2) + 1]) + (p[(i * 2) + 1] * a[(j - 1) * 2]));
            }
            a[0] = a[0] + p[i * 2];
            a[1] = a[1] + p[(i * 2) + 1];
        }
        return a;
    }

    private static double[] trinomial_mult(int n, double[] b, double[] c) {
        double[] a = new double[(n * 4)];
        a[2] = c[0];
        a[3] = c[1];
        a[0] = b[0];
        a[1] = b[1];
        for (int i = 1; i < n; i++) {
            int i2 = ((i * 2) + 1) * 2;
            a[i2] = a[i2] + ((c[i * 2] * a[((i * 2) - 1) * 2]) - (c[(i * 2) + 1] * a[(((i * 2) - 1) * 2) + 1]));
            i2 = (((i * 2) + 1) * 2) + 1;
            a[i2] = a[i2] + ((c[i * 2] * a[(((i * 2) - 1) * 2) + 1]) + (c[(i * 2) + 1] * a[((i * 2) - 1) * 2]));
            for (int j = i * 2; j > 1; j--) {
                i2 = j * 2;
                a[i2] = a[i2] + ((((b[i * 2] * a[(j - 1) * 2]) - (b[(i * 2) + 1] * a[((j - 1) * 2) + 1])) + (c[i * 2] * a[(j - 2) * 2])) - (c[(i * 2) + 1] * a[((j - 2) * 2) + 1]));
                i2 = (j * 2) + 1;
                a[i2] = a[i2] + ((((b[i * 2] * a[((j - 1) * 2) + 1]) + (b[(i * 2) + 1] * a[(j - 1) * 2])) + (c[i * 2] * a[((j - 2) * 2) + 1])) + (c[(i * 2) + 1] * a[(j - 2) * 2]));
            }
            a[2] = a[2] + (((b[i * 2] * a[0]) - (b[(i * 2) + 1] * a[1])) + c[i * 2]);
            a[3] = a[3] + (((b[i * 2] * a[1]) + (b[(i * 2) + 1] * a[0])) + c[(i * 2) + 1]);
            a[0] = a[0] + b[i * 2];
            a[1] = a[1] + b[(i * 2) + 1];
        }
        return a;
    }
}
