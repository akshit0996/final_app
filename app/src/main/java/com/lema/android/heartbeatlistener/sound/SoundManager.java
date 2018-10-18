package com.lema.android.heartbeatlistener.sound;

import com.lema.android.heartbeatlistener.sound.signal.filter.dsp.filter.FilterPassType;
import com.lema.android.heartbeatlistener.sound.signal.filter.dsp.filter.IirFilterCoefficients;
import com.lema.android.heartbeatlistener.sound.signal.filter.dsp.filter.IirFilterDesignExstrom;

public class SoundManager implements ISoundManager {
    public static final int REF_SAMPLE_RATE = 44100;
    protected static AudioRIIThread audioThread;
    protected double ampliFactor;
    protected double cutFreq;
    protected final double subSamplingRatio = 16.0d;
    protected final double subSamplingRatio1 = 4.0d;
    protected final double subSamplingRatio2 = 4.0d;

    public SoundManager(double ampliFactor, double cutFreq) {
        this.ampliFactor = ampliFactor;
        this.cutFreq = cutFreq;
    }

    public void launch() {
        if (audioThread == null) {
            IirFilterCoefficients antiAliasingCoeffs1 = IirFilterDesignExstrom.design(FilterPassType.lowpass, 5, 0.07692307692307693d, 0.0d);
            IirFilterCoefficients antiAliasingCoeffs2 = IirFilterDesignExstrom.design(FilterPassType.lowpass, 5, 0.07692307692307693d, 0.0d);
            double cutFreqHigh = Math.min(this.cutFreq / 2756.25d, 0.49d);
            audioThread = new AudioRIIThread(antiAliasingCoeffs1, antiAliasingCoeffs2, IirFilterDesignExstrom.design(FilterPassType.lowpass, 5, cutFreqHigh, cutFreqHigh), 44100.0d, 4.0d, 4.0d, this.ampliFactor);
            audioThread.start();
        }
    }

    public void interupt() {
        if (audioThread != null) {
            audioThread.interrupt();
            audioThread = null;
        }
    }

    public boolean isRunning() {
        return audioThread != null;
    }

    public void setNewAmplificationRatio(double newGain) {
        if (audioThread != null) {
            audioThread.setGain(newGain);
        }
        this.ampliFactor = newGain;
    }

    public void setNewNoiseReductionRatio(double newNoiseRed) {
        this.cutFreq = newNoiseRed;
        if (audioThread != null) {
            double cutFreqHigh = Math.min(this.cutFreq / 2756.25d, 0.49d);
            audioThread.setNewFilterCoeffs(IirFilterDesignExstrom.design(FilterPassType.lowpass, 3, cutFreqHigh, cutFreqHigh));
        }
    }
}
