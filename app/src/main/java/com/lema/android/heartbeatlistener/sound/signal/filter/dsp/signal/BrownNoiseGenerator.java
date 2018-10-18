package com.lema.android.heartbeatlistener.sound.signal.filter.dsp.signal;

import java.util.Random;

public class BrownNoiseGenerator {
    private double centerValue;
    private double currentValue;
    private double hpFilter;
    private double maxValue;
    private double minValue;
    private Random random;
    private double slope;
    private double valueRange;

    public BrownNoiseGenerator() {
        this(-1.0d, 1.0d);
    }

    public BrownNoiseGenerator(double minValue, double maxValue) {
        this(minValue, maxValue, (maxValue - minValue) / 20.0d, 0.02d);
    }

    public BrownNoiseGenerator(double minValue, double maxValue, double slope, double hpFilter) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.slope = slope;
        this.hpFilter = hpFilter;
        if (minValue >= maxValue) {
            throw new IllegalArgumentException("Invalid minValue/maxValue.");
        }
        this.valueRange = maxValue - minValue;
        if (slope <= 0.0d || slope >= this.valueRange / 2.0d) {
            throw new IllegalArgumentException("Invalid slope.");
        } else if (hpFilter < 0.0d || hpFilter >= 1.0d) {
            throw new IllegalArgumentException("Invalid hpFilter value.");
        } else {
            this.centerValue = (minValue + maxValue) / 2.0d;
            this.currentValue = this.centerValue;
            this.random = new Random();
        }
    }

    public double getNext() {
        double whiteNoise = ((double) ((this.random.nextFloat() * 2.0f) - 1.0f)) * this.slope;
        double v = this.currentValue;
        if (this.hpFilter > 0.0d) {
            v -= (v - this.centerValue) * this.hpFilter;
        }
        double next = v + whiteNoise;
        if (next < this.minValue || next > this.maxValue) {
            next = v - whiteNoise;
        }
        this.currentValue = next;
        return next;
    }
}
