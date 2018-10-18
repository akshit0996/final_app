package com.lema.android.heartbeatlistener.sound.signal.filter.dsp.filter;

import com.lema.android.heartbeatlistener.sound.signal.filter.dsp.math.Complex;
import com.lema.android.heartbeatlistener.sound.signal.filter.dsp.math.PolynomialRootFinderJenkinsTraub;
import com.lema.android.heartbeatlistener.sound.signal.filter.dsp.math.PolynomialUtils;
import com.lema.android.heartbeatlistener.sound.signal.filter.dsp.math.PolynomialUtils.RationalFraction;
import com.lema.android.heartbeatlistener.sound.signal.filter.dsp.util.ArrayUtils;

public class BesselFilterDesign {
    private BesselFilterDesign() {
    }

    public static double[] computePolynomialCoefficients(int n) {
        int i;
        double m = 1.0d;
        for (i = 1; i <= n; i++) {
            m = (((double) (n + i)) * m) / 2.0d;
        }
        double[] a = new double[(n + 1)];
        a[0] = m;
        a[n] = 1.0d;
        for (i = 1; i < n; i++) {
            a[i] = (((a[i - 1] * 2.0d) * ((double) ((n - i) + 1))) / ((double) (((n * 2) - i) + 1))) / ((double) i);
        }
        return a;
    }

    public static Complex transferFunction(double[] polyCoeffs, Complex s) {
        RationalFraction f = new RationalFraction();
        f.top = new double[]{polyCoeffs[polyCoeffs.length - 1]};
        f.bottom = polyCoeffs;
        return PolynomialUtils.evaluate(f, s);
    }

    public static double computeGain(double[] polyCoeffs, double w) {
        return transferFunction(polyCoeffs, new Complex(0.0d, w)).abs();
    }

    public static double findFrequencyForGain(double[] polyCoeffs, double gain) {
        if (gain > 0.999999d || gain < 1.0E-6d) {
            throw new IllegalArgumentException();
        }
        int ctr;
        double wLo = 1.0d;
        int ctr2 = 0;
        while (computeGain(polyCoeffs, wLo) < gain) {
            wLo /= 2.0d;
            ctr = ctr2 + 1;
            if (ctr2 > 100) {
                throw new AssertionError();
            }
            ctr2 = ctr;
        }
        double wHi = 1.0d;
        ctr2 = 0;
        while (computeGain(polyCoeffs, wHi) > gain) {
            wHi *= 2.0d;
            ctr = ctr2 + 1;
            if (ctr2 > 100) {
                throw new AssertionError();
            }
            ctr2 = ctr;
        }
        ctr = 0;
        while (wHi - wLo >= 1.0E-15d) {
            double wm = (wHi + wLo) / 2.0d;
            if (computeGain(polyCoeffs, wm) > gain) {
                wLo = wm;
            } else {
                wHi = wm;
            }
            ctr2 = ctr + 1;
            if (ctr > 1000) {
                throw new AssertionError("No convergence.");
            }
            ctr = ctr2;
        }
        return wLo;
    }

    public static double findFrequencyScalingFactor(double[] polyCoeffs) {
        return findFrequencyForGain(polyCoeffs, 1.0d / Math.sqrt(2.0d));
    }

    public static Complex[] computePoles(int n) {
        double[] polyCoeffs = ArrayUtils.reverse(computePolynomialCoefficients(n));
        return ArrayUtils.divide(PolynomialRootFinderJenkinsTraub.findRoots(polyCoeffs), findFrequencyScalingFactor(polyCoeffs));
    }
}
