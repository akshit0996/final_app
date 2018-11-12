package com.lema.android.heartbeatlistener.sound.signal.filter.dsp.math;

import com.lema.android.heartbeatlistener.sound.signal.filter.dsp.util.ArrayUtils;

public class PolynomialRootFinderLaguerre {
    private static final double EPSS = 1.0E-14d;

    private PolynomialRootFinderLaguerre() {
    }

    public static Complex[] findRoots(double[] coeffs) {
        return findRoots(ArrayUtils.toComplex(coeffs));
    }

    public static Complex[] findRoots(Complex[] coeffs) {
        int i;
        int n = coeffs.length - 1;
        Complex[] zeros = new Complex[n];
        Complex[] a = coeffs;
        for (i = 0; i < n; i++) {
            Complex zero;
            int i2 = 0;
            while (true) {
                zero = laguer(a, i2 == 0 ? new Complex(0.0d) : randomStart());
                if (zero != null) {
                    break;
                }
                int ctr = i2 + 1;
                if (i2 > 1000) {
                    throw new RuntimeException("Root finding aborted in random loop.");
                }
                i2 = ctr;
            }
            zeros[i] = zero;
            a = PolynomialUtils.deflate(a, zero, 0.0d);
        }
        for (i = 0; i < n; i++) {
            zeros[i] = laguer(coeffs, zeros[i]);
            if (zeros[i] == null) {
                throw new RuntimeException("Polish failed.");
            }
        }
        return zeros;
    }

    private static Complex laguer(Complex[] a, Complex startX) {
        int n = a.length - 1;
        Complex cn = new Complex((double) n);
        Complex x = startX;
        for (int iter = 0; iter < 80; iter++) {
            Complex b = a[0];
            double err = b.abs();
            Complex d = Complex.ZERO;
            Complex f = Complex.ZERO;
            double absX = x.abs();
            for (int i = 1; i <= n; i++) {
                f = x.mul(f).add(d);
                d = x.mul(d).add(b);
                b = x.mul(b).add(a[i]);
                err = b.abs() + (absX * err);
            }
            if (b.abs() <= err * EPSS) {
                return x;
            }
            Complex dx;
            Complex g = d.div(b);
            Complex g2 = g.mul(g);
            Complex sq = cn.sub(Complex.ONE).mul(cn.mul(g2.sub(Complex.TWO.mul(f.div(b)))).sub(g2)).sqrt();
            Complex gp = g.add(sq);
            Complex gm = g.sub(sq);
            double abp = gp.abs();
            double abm = gm.abs();
            if (abp < abm) {
                gp = gm;
            }
            if (abp > 0.0d || abm > 0.0d) {
                dx = cn.div(gp);
            } else {
                dx = new Complex(Math.log(1.0d + absX), (double) (iter + 1)).exp();
            }
            x = x.sub(dx);
        }
        return null;
    }

    private static Complex randomStart() {
        return new Complex((Math.random() * 2.0d) - 1.0d, (Math.random() * 2.0d) - 1.0d);
    }
}
