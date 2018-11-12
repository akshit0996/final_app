package com.lema.android.heartbeatlistener.sound.signal;

import java.util.ArrayList;

public class Buffer {
    public short[] buffer;
    public int bufferSize;

    public Buffer(int refSize) {
        this.buffer = new short[refSize];
        this.bufferSize = 0;
    }

    public Buffer(ArrayList<Short> shortList) {
        this.buffer = new short[shortList.size()];
        this.bufferSize = shortList.size();
        for (int i = 0; i < this.bufferSize; i++) {
            this.buffer[i] = ((Short) shortList.get(i)).shortValue();
        }
    }
}
