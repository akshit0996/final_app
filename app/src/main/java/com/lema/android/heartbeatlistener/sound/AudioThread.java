package com.lema.android.heartbeatlistener.sound;

import android.media.AudioRecord;
import android.media.AudioTrack;
import com.lema.android.heartbeatlistener.sound.Recorder.AudioRecorderManager;
import com.lema.android.heartbeatlistener.sound.signal.Buffer;
import com.lema.android.heartbeatlistener.sound.signal.Extrapolator;
import com.lema.android.heartbeatlistener.sound.signal.Sampler;
import com.lema.android.heartbeatlistener.sound.signal.filter.RIF;

public class AudioThread extends Thread {
    AudioRecord audioRecord;
    AudioTrack audioTrack;
    int bufferSize;
    float gain;
    AudioRecorderManager recorder = AudioRecorderManager.getInstance();
    int refBufferSize;
    RIF rifFilter;
    double sampleRate;
    int sampleRatio;

    public AudioThread(int refBufferSize, int bufferSize, int sampleRatio, AudioRecord audioRecord, AudioTrack audioTrack, RIF rifFilter, float gain, double sampleRate) {
        this.refBufferSize = refBufferSize;
        this.bufferSize = bufferSize;
        this.sampleRatio = sampleRatio;
        this.audioRecord = audioRecord;
        this.audioTrack = audioTrack;
        this.rifFilter = rifFilter;
        this.gain = gain;
        this.recorder.reset(sampleRate / ((double) sampleRatio));
    }

    public void run() {
        Buffer audioRecordBuffer = new Buffer(this.refBufferSize);
        Buffer audioSampledRecordBuffer = new Buffer(this.bufferSize);
        Buffer filteredRecordBuffer = new Buffer(this.bufferSize);
        Buffer audioPublishBuffer = new Buffer(this.refBufferSize);
        Sampler sampler = new Sampler(this.sampleRatio);
        Extrapolator extrapolator = new Extrapolator(this.sampleRatio);
        while (!isInterrupted()) {
            audioRecordBuffer.bufferSize = this.audioRecord.read(audioRecordBuffer.buffer, 0, this.refBufferSize);
            if (audioRecordBuffer.bufferSize > 0) {
                sampler.sample(audioRecordBuffer, audioSampledRecordBuffer);
                this.rifFilter.filterRIF(audioSampledRecordBuffer, filteredRecordBuffer, this.gain);
                this.recorder.recordData(filteredRecordBuffer);
                extrapolator.extrapolate(filteredRecordBuffer, audioPublishBuffer);
                this.audioTrack.write(audioPublishBuffer.buffer, 0, audioPublishBuffer.bufferSize);
                this.audioTrack.flush();
            }
        }
    }

    public synchronized void setAmpliFactor(float newGain) {
        this.gain = newGain;
    }

    public synchronized void setNewFilter(RIF newFilter) {
        this.rifFilter = newFilter;
    }
}
