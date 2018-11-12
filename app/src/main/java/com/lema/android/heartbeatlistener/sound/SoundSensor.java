package com.lema.android.heartbeatlistener.sound;

import android.media.AudioRecord;
import android.media.AudioTrack;
import com.lema.android.heartbeatlistener.sound.signal.filter.RIF;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class SoundSensor implements ISoundManager {
    protected static AudioThread mainThread;
    float alpha = (this.samplePeriod / (this.samplePeriod + this.tau));
    String audioFilePath = "/data/heartBeatRecord.wav";
    int audioFormat;
    AudioRecord audioRecord;
    AudioTrack audioTrack;
    int bufferSize = (this.refBufferSize / this.sampleRatio);
    long fileMaxSize = 0;
    int filterWindowSize = 100;
    float gain = 5.0f;
    ArrayList<Short> recordBuffer;
    FileOutputStream recordStream;
    int refBufferSize;
    int refSampleFreq = SoundManager.REF_SAMPLE_RATE;
    RIF rifFilter;
    int sampleFreq = (this.refSampleFreq / this.sampleRatio);
    float samplePeriod = (1.0f / ((float) this.sampleFreq));
    int sampleRatio = 4;
    int sampleSize;
    int samplingRatio = 100;
    short saturationLevel = (short) 30000;
    float tau = ((float) (1.0d / (((double) (this.filterWindowSize * 2)) * 3.141592653589793d)));
    int usedBufferSize;

    public SoundSensor(float gain, int bufferWindowSize) {
        this.gain = gain;
        this.filterWindowSize = bufferWindowSize;
        this.audioFormat = 2;
        this.refBufferSize = AudioTrack.getMinBufferSize(this.refSampleFreq, 4, this.audioFormat) * 2;
        this.bufferSize = (this.refBufferSize / this.sampleRatio) + 1;
        this.usedBufferSize = 0;
        this.sampleSize = this.bufferSize / this.samplingRatio;
        this.rifFilter = new RIF(bufferWindowSize, this.samplePeriod);
    }

    public void launch() {
        if (mainThread == null) {
            this.audioRecord = new AudioRecord(1, this.refSampleFreq, 16, 2, this.refBufferSize);
            this.audioTrack = new AudioTrack(3, this.refSampleFreq, 4, this.audioFormat, this.refBufferSize, 1);
            mainThread = new AudioThread(this.refBufferSize, this.bufferSize, this.sampleRatio, this.audioRecord, this.audioTrack, this.rifFilter, this.gain, (double) this.refSampleFreq);
            this.audioRecord.startRecording();
            this.audioTrack.play();
            mainThread.start();
        }
    }

    public synchronized void interupt() {
        if (mainThread != null) {
            mainThread.interrupt();
            mainThread = null;
            if (this.audioTrack != null) {
                this.audioTrack.stop();
                this.audioTrack.release();
            }
            if (this.audioRecord != null) {
                this.audioRecord.stop();
                this.audioRecord.release();
            }
        }
    }

    public boolean isRunning() {
        return mainThread != null;
    }

    public void setNewAmplificationRatio(double newGain) {
        this.gain = (float) newGain;
        if (mainThread != null) {
            mainThread.setAmpliFactor((float) newGain);
        }
    }

    public void setNewNoiseReductionRatio(double newNoiseRed) {
        this.filterWindowSize = (int) newNoiseRed;
        this.rifFilter = new RIF(this.filterWindowSize, this.samplePeriod);
        if (mainThread != null) {
            mainThread.setNewFilter(this.rifFilter);
        }
    }
}
