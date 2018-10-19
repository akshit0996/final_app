package com.lema.android.heartbeatlistener.sound.signal.filter;

import com.lema.android.heartbeatlistener.sound.signal.Buffer;

public class RIF {
    /* renamed from: M */
    private  int f62N=0;
    private  int f61M = ((this.f62N * 2) + 1);
    /* renamed from: N */

    float[] coef = new float[this.f61M];
    float lastFilteredValue = 0.0f;
    float[] previousData = new float[this.f61M];

    public RIF(int n, float Te) {
        this.f62N = n;
        for (int i = 0; i < this.f61M; i++) {
            this.coef[i] = 1.0f / ((float) this.f61M);
            float[] fArr = this.coef;
            fArr[i] = fArr[i] * ((float) (0.54d - (0.46d * Math.cos((((double) (i * 2)) * 3.141592653589793d) / ((double) ((float) (this.f61M - 1)))))));
        }
    }

    public void filterRIF(Buffer buffer, Buffer resultBuffer, float gain) {
        int i;
        int bufferSize = buffer.bufferSize;
        float[] data = new float[(this.f61M + bufferSize)];
        float[] filteredData = new float[bufferSize];
        for (i = 0; i < this.f61M; i++) {
            data[i] = this.previousData[i];
        }
        for (i = 0; i < bufferSize; i++) {
            data[this.f61M + i] = ((float) buffer.buffer[i]) / 32767.0f;
        }
        for (i = bufferSize; i < this.f61M + bufferSize; i++) {
            this.previousData[i - bufferSize] = data[i];
        }
        for (i = 0; i < bufferSize; i++) {
            float temp = 0.0f;
            for (int j = 0; j < this.f61M; j++) {
                temp += this.coef[j] * data[i + j];
            }
            filteredData[i] = temp;
        }
        for (i = 0; i < bufferSize; i++) {
            filteredData[i] = filteredData[i] * gain;
        }
        for (i = 0; i < bufferSize; i++) {
            resultBuffer.buffer[i] = (short) ((int) (filteredData[i] * 32767.0f));
        }
        resultBuffer.bufferSize = bufferSize;
    }
}
