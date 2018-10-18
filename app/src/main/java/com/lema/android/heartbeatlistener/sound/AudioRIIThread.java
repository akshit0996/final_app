package com.lema.android.heartbeatlistener.sound;

import android.media.AudioRecord;
import android.media.AudioTrack;
import com.lema.android.heartbeatlistener.sound.Recorder.AudioRecorderManager;
import com.lema.android.heartbeatlistener.sound.signal.Buffer;
import com.lema.android.heartbeatlistener.sound.signal.Extrapolator;
import com.lema.android.heartbeatlistener.sound.signal.filter.dsp.filter.IirFilter;
import com.lema.android.heartbeatlistener.sound.signal.filter.dsp.filter.IirFilterCoefficients;

public class AudioRIIThread extends Thread {
    private static final short maxValue = (short) 32700;
    double ampliFactor;
    IirFilter antiAliasingFilter1;
    IirFilter antiAliasingFilter2;
    AudioRecord audioRecord;
    AudioTrack audioTrack;
    int bufferSize = (AudioTrack.getMinBufferSize(this.sampleRateInt, 4, 2) * 2);
    double cutFreq;
    Extrapolator extrapolator;
    double finalSampleRate;
    AudioRecorderManager recorder;
    double sampleRate;
    int sampleRateInt;
    IirFilter soundFilter;
    double subSamplingRatio;
    double subSamplingRatio1;
    double subSamplingRatio2;

    public AudioRIIThread(IirFilterCoefficients antiAliasingFilterCoeffs1, IirFilterCoefficients antiAliasingFilterCoeffs2, IirFilterCoefficients soundFilterCoeffs, double sampleRate, double subsamplingRatio1, double subsamplingRatio2, double ampliFactor) {
        this.sampleRate = sampleRate;
        this.sampleRateInt = (int) sampleRate;
        this.antiAliasingFilter1 = new IirFilter(antiAliasingFilterCoeffs1);
        this.antiAliasingFilter2 = new IirFilter(antiAliasingFilterCoeffs2);
        this.soundFilter = new IirFilter(soundFilterCoeffs);
        this.subSamplingRatio1 = subsamplingRatio1;
        this.subSamplingRatio2 = subsamplingRatio2;
        this.subSamplingRatio = subsamplingRatio1 * subsamplingRatio2;
        this.finalSampleRate = sampleRate / this.subSamplingRatio;
        this.ampliFactor = ampliFactor;
        this.audioRecord = new AudioRecord(1, this.sampleRateInt, 16, 2, this.bufferSize);
        this.audioTrack = new AudioTrack(3, this.sampleRateInt, 4, 2, this.bufferSize, 1);
        this.extrapolator = new Extrapolator((int) this.subSamplingRatio);
        this.recorder = AudioRecorderManager.getInstance();
        this.recorder.reset(this.finalSampleRate);
    }

    public void run() {
        Buffer audioRecordBuffer = new Buffer(this.bufferSize);
        Buffer audioFilteredBuffer = new Buffer(this.bufferSize);
        Buffer audioPublishBuffer = new Buffer(this.bufferSize);
        this.audioRecord.startRecording();
        this.audioTrack.play();
        int cpt1 = 0;
        int cpt2 = 0;
        while (!isInterrupted()) {
            audioRecordBuffer.bufferSize = this.audioRecord.read(audioRecordBuffer.buffer, 0, this.bufferSize);
            if (audioRecordBuffer.bufferSize > 0) {
                int n = 0;
                for (int s = 0; s < audioRecordBuffer.bufferSize; s++) {
                    double signal = this.antiAliasingFilter1.step((double) audioRecordBuffer.buffer[s]);
                    cpt1++;
                    if (((double) cpt1) >= this.subSamplingRatio1) {
                        double signal2 = this.antiAliasingFilter2.step(signal);
                        cpt1 = 0;
                        cpt2++;
                        if (((double) cpt2) >= this.subSamplingRatio2) {
                            short var = (short) ((int) limitate(this.ampliFactor * this.soundFilter.step(signal2)));
                            audioFilteredBuffer.buffer[n] = var;
                            this.recorder.recordData(Short.valueOf(var));
                            n++;
                            cpt2 = 0;
                        }
                    }
                }
                audioFilteredBuffer.bufferSize = n;
                this.extrapolator.extrapolate(audioFilteredBuffer, audioPublishBuffer);
                this.audioTrack.write(audioPublishBuffer.buffer, 0, audioPublishBuffer.bufferSize);
                this.audioTrack.flush();
            }
        }
        this.audioRecord.stop();
        this.audioRecord.release();
        this.audioRecord = null;
        this.audioTrack.stop();
        this.audioTrack.release();
        this.audioTrack = null;
    }

    private static double limitate(double value) {
        if (Math.abs(value) > 32700.0d) {
            return 32700.0d * Math.signum(value);
        }
        return value;
    }

    public synchronized void setGain(double newGain) {
        this.ampliFactor = newGain;
    }

    public synchronized void setNewFilterCoeffs(IirFilterCoefficients newSoundFilterCoeffs) {
        this.soundFilter = new IirFilter(newSoundFilterCoeffs);
    }
}
