package com.lema.android.heartbeatlistener.sound.signal.filter.dsp.filter;

public class IirFilter {
    private double[] a;
    private double[] b;
    private double[] buf1;
    private double[] buf2;
    private int n1;
    private int n2;
    private int pos1;
    private int pos2;

    public IirFilter(IirFilterCoefficients coeffs) {
        this.a = coeffs.a;
        this.b = coeffs.b;
        if (this.a.length < 1 || this.b.length < 1 || this.a[0] != 1.0d) {
            throw new IllegalArgumentException("Invalid coefficients.");
        }
        this.n1 = this.b.length - 1;
        this.n2 = this.a.length - 1;
        this.buf1 = new double[this.n1];
        this.buf2 = new double[this.n2];
    }

    public double step(double inputValue) {
        int j;
        double acc = this.b[0] * inputValue;
        for (j = 1; j <= this.n1; j++) {
            acc += this.b[j] * this.buf1[((this.pos1 + this.n1) - j) % this.n1];
        }
        for (j = 1; j <= this.n2; j++) {
            acc -= this.a[j] * this.buf2[((this.pos2 + this.n2) - j) % this.n2];
        }
        if (this.n1 > 0) {
            this.buf1[this.pos1] = inputValue;
            this.pos1 = (this.pos1 + 1) % this.n1;
        }
        if (this.n2 > 0) {
            this.buf2[this.pos2] = acc;
            this.pos2 = (this.pos2 + 1) % this.n2;
        }
        return acc;
    }
}
