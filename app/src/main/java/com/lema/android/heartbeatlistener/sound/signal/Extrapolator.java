package com.lema.android.heartbeatlistener.sound.signal;

public class Extrapolator {
    short last = (short) 0;
    int ratio;

    public Extrapolator(int ratio) {
        this.ratio = ratio;
    }

    public void extrapolate(Buffer buffer, Buffer resultBuffer) {
        extrapolate(buffer.buffer, buffer.bufferSize, resultBuffer);
    }

    public void extrapolate(short[] buffer, int bufferSize, Buffer resultBuffer) {
        resultBuffer.bufferSize = 0;
        int n = 0;
        for (int i = 0; i < bufferSize; i++) {
            short next = buffer[i];
            for (int j = 0; j < this.ratio; j++) {
                resultBuffer.buffer[n] = (short) ((int) (((double) this.last) + ((((double) (next - this.last)) / ((double) this.ratio)) * ((double) j))));
                n++;
            }
            this.last = next;
        }
        resultBuffer.bufferSize = n;
    }
}
