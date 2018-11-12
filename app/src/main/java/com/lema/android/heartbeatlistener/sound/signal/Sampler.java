package com.lema.android.heartbeatlistener.sound.signal;

public class Sampler {
    public int offset = 0;
    int ratio;

    public Sampler(int ratio) {
        this.ratio = ratio;
    }

    public void sample(Buffer buffer, Buffer resultBuffer) {
        sample(buffer.buffer, buffer.bufferSize, resultBuffer);
    }

    public void sample(short[] buffer, int bufferSize, Buffer resultBuffer) {
        resultBuffer.bufferSize = 0;
        int n = 0;
        if (this.offset > 0) {
            resultBuffer.buffer[0] = buffer[0];
            n = 0 + 1;
        }
        int i = this.offset;
        while (i < bufferSize) {
            resultBuffer.buffer[n] = buffer[i];
            n++;
            i += this.ratio;
        }
        this.offset = i - bufferSize;
        resultBuffer.bufferSize = n;
    }
}
