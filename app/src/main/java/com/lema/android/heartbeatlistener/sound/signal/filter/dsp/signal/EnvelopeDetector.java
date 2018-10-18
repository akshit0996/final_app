package com.lema.android.heartbeatlistener.sound.signal.filter.dsp.signal;

import com.lema.android.heartbeatlistener.sound.signal.filter.dsp.filter.FilterCharacteristicsType;
import com.lema.android.heartbeatlistener.sound.signal.filter.dsp.filter.FilterPassType;
import com.lema.android.heartbeatlistener.sound.signal.filter.dsp.filter.IirFilter;
import com.lema.android.heartbeatlistener.sound.signal.filter.dsp.filter.IirFilterDesignFisher;

public class EnvelopeDetector {
    private double gAttack;
    private double gRelease;
    private IirFilter iirFilter;
    private double level;

    public EnvelopeDetector(int samplingRate) {
        int i = samplingRate;
        init(i, 0.0015d, 0.03d, new IirFilter(IirFilterDesignFisher.design(FilterPassType.bandpass, FilterCharacteristicsType.chebyshev, 4, -0.5d, 130.0d / ((double) samplingRate), 4700.0d / ((double) samplingRate))));
    }

    public EnvelopeDetector(int samplingRate, double attackTime, double releaseTime, IirFilter iirFilter) {
        init(samplingRate, attackTime, releaseTime, iirFilter);
    }

    private void init(int samplingRate, double attackTime, double releaseTime, IirFilter iirFilter) {
        this.gAttack = Math.exp(-1.0d / (((double) samplingRate) * attackTime));
        this.gRelease = Math.exp(-1.0d / (((double) samplingRate) * releaseTime));
        this.iirFilter = iirFilter;
    }

    public double step(double inputValue) {
        double inLevel = Math.abs(this.iirFilter == null ? inputValue : this.iirFilter.step(inputValue));
        double g = inLevel > this.level ? this.gAttack : this.gRelease;
        this.level = (this.level * g) + ((1.0d - g) * inLevel);
        return this.level;
    }

    public float[] process(float[] in) {
        float[] out = new float[in.length];
        for (int i = 0; i < in.length; i++) {
            out[i] = (float) step((double) in[i]);
        }
        return out;
    }
}
