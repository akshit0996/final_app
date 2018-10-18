package com.googlecode.mp4parser.boxes.apple;

import java.nio.ByteBuffer;
import java.util.logging.Logger;

public class AppleCoverBox extends AppleDataBox {
    private byte[] data;
    private Logger logger = Logger.getLogger(getClass().getName());

    public AppleCoverBox() {
        super("covr", 1);
    }

    protected byte[] writeData() {
        return this.data;
    }

    protected void parseData(ByteBuffer data) {
        this.data = new byte[data.limit()];
        data.get(this.data);
    }

    protected int getDataLength() {
        return this.data.length;
    }
}
