package com.lema.android.heartbeatlistener.sound.signal.filter.dsp.math;

public final class Complex {
    public static final Complex I = new Complex(0.0d, 1.0d);
    public static final Complex INF = new Complex(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    public static final Complex NaN = new Complex(Double.NaN, Double.NaN);
    public static final Complex ONE = new Complex(1.0d);
    public static final Complex TWO = new Complex(2.0d);
    public static final Complex ZERO = new Complex(0.0d);
    private final double im;
    private final double re;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public Complex(double re) {
        this(re, 0.0d);
    }

    public double re() {
        return this.re;
    }

    public double im() {
        return this.im;
    }

    public double toDouble(double eps) {
        double absIm = Math.abs(this.im);
        if (absIm <= eps || absIm <= Math.abs(this.re) * eps) {
            return this.re;
        }
        throw new RuntimeException("The imaginary part of the complex number is not neglectable small for the conversion to a real number. re=" + this.re + " im=" + this.im + " eps=" + eps + ".");
    }

    public boolean isNaN() {
        return Double.isNaN(this.re) || Double.isNaN(this.im);
    }

    public boolean isInfinite() {
        return Double.isInfinite(this.re) || Double.isInfinite(this.im);
    }

    public static Complex expj(double arg) {
        return new Complex(Math.cos(arg), Math.sin(arg));
    }

    public static Complex fromPolar(double abs, double arg) {
        return new Complex(Math.cos(arg) * abs, Math.sin(arg) * abs);
    }

    public double abs() {
        return Math.hypot(this.re, this.im);
    }

    public double arg() {
        return Math.atan2(this.im, this.re);
    }

    public Complex conj() {
        return new Complex(this.re, -this.im);
    }

    public Complex neg() {
        return new Complex(-this.re, -this.im);
    }

    public Complex reciprocal() {
        if (isNaN()) {
            return NaN;
        }
        if (isInfinite()) {
            return new Complex(0.0d, 0.0d);
        }
        double scale = (this.re * this.re) + (this.im * this.im);
        if (scale == 0.0d) {
            return INF;
        }
        return new Complex(this.re / scale, (-this.im) / scale);
    }

    public Complex exp() {
        return fromPolar(Math.exp(this.re), this.im);
    }

    public Complex log() {
        return new Complex(Math.log(abs()), arg());
    }

    public Complex sqr() {
        return new Complex((this.re * this.re) - (this.im * this.im), (2.0d * this.re) * this.im);
    }

    public Complex sqrt() {
        if (this.re == 0.0d && this.im == 0.0d) {
            return new Complex(0.0d, 0.0d);
        }
        double m = abs();
        return new Complex(Math.sqrt((this.re + m) / 2.0d), Math.copySign(1.0d, this.im) * Math.sqrt((m - this.re) / 2.0d));
    }

    public Complex add(double x) {
        return new Complex(this.re + x, this.im);
    }

    public Complex add(Complex x) {
        return new Complex(this.re + x.re, this.im + x.im);
    }

    public Complex sub(double x) {
        return new Complex(this.re - x, this.im);
    }

    public Complex sub(Complex x) {
        return new Complex(this.re - x.re, this.im - x.im);
    }

    public static Complex sub(double x, Complex y) {
        return new Complex(x - y.re, -y.im);
    }

    public Complex mul(double x) {
        return new Complex(this.re * x, this.im * x);
    }

    public Complex mul(Complex x) {
        return new Complex((this.re * x.re) - (this.im * x.im), (this.re * x.im) + (this.im * x.re));
    }

    public Complex div(double x) {
        return new Complex(this.re / x, this.im / x);
    }

    public Complex div(Complex x) {
        double m = (x.re * x.re) + (x.im * x.im);
        return new Complex(((this.re * x.re) + (this.im * x.im)) / m, ((this.im * x.re) - (this.re * x.im)) / m);
    }

    public static Complex div(double x, Complex y) {
        double m = (y.re * y.re) + (y.im * y.im);
        return new Complex((y.re * x) / m, ((-x) * y.im) / m);
    }

    public Complex pow(int x) {
        return fromPolar(Math.pow(abs(), (double) x), arg() * ((double) x));
    }

    public Complex pow(double x) {
        return log().mul(x).exp();
    }

    public Complex pow(Complex x) {
        return log().mul(x).exp();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Complex)) {
            return false;
        }
        Complex x = (Complex) obj;
        if (this.re == x.re && this.im == x.im) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long b1 = Double.doubleToLongBits(this.re);
        long b2 = Double.doubleToLongBits(this.im);
        return (int) ((((b1 >>> 32) ^ b1) ^ b2) ^ (b2 >>> 32));
    }

    public String toString() {
        return "(" + this.re + ", " + this.im + ")";
    }
}
