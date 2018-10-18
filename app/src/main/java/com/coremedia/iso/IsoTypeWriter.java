package com.coremedia.iso;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import java.nio.ByteBuffer;

public final class IsoTypeWriter {
    static final /* synthetic */ boolean $assertionsDisabled = (!IsoTypeWriter.class.desiredAssertionStatus());

    public static void writeUInt64(ByteBuffer bb, long u) {
        if ($assertionsDisabled || u >= 0) {
            bb.putLong(u);
            return;
        }
        throw new AssertionError("The given long is negative");
    }

    public static void writeUInt32(ByteBuffer bb, long u) {
        if ($assertionsDisabled || (u >= 0 && u <= 4294967296L)) {
            bb.putInt((int) u);
            return;
        }
        throw new AssertionError("The given long is not in the range of uint32 (" + u + ")");
    }

    public static void writeUInt32BE(ByteBuffer bb, long u) {
        if ($assertionsDisabled || (u >= 0 && u <= 4294967296L)) {
            writeUInt16BE(bb, ((int) u) & 65535);
            writeUInt16BE(bb, (int) ((u >> 16) & 65535));
            return;
        }
        throw new AssertionError("The given long is not in the range of uint32 (" + u + ")");
    }

    public static void writeUInt24(ByteBuffer bb, int i) {
        i &= ViewCompat.MEASURED_SIZE_MASK;
        writeUInt16(bb, i >> 8);
        writeUInt8(bb, i);
    }

    public static void writeUInt16(ByteBuffer bb, int i) {
        i &= 65535;
        writeUInt8(bb, i >> 8);
        writeUInt8(bb, i & MotionEventCompat.ACTION_MASK);
    }

    public static void writeUInt16BE(ByteBuffer bb, int i) {
        i &= 65535;
        writeUInt8(bb, i & MotionEventCompat.ACTION_MASK);
        writeUInt8(bb, i >> 8);
    }

    public static void writeUInt8(ByteBuffer bb, int i) {
        bb.put((byte) (i & MotionEventCompat.ACTION_MASK));
    }

    public static void writeFixedPoint1616(ByteBuffer bb, double v) {
        int result = (int) (65536.0d * v);
        bb.put((byte) ((ViewCompat.MEASURED_STATE_MASK & result) >> 24));
        bb.put((byte) ((16711680 & result) >> 16));
        bb.put((byte) ((MotionEventCompat.ACTION_POINTER_INDEX_MASK & result) >> 8));
        bb.put((byte) (result & MotionEventCompat.ACTION_MASK));
    }

    public static void writeFixedPoint0230(ByteBuffer bb, double v) {
        int result = (int) (1.073741824E9d * v);
        bb.put((byte) ((ViewCompat.MEASURED_STATE_MASK & result) >> 24));
        bb.put((byte) ((16711680 & result) >> 16));
        bb.put((byte) ((MotionEventCompat.ACTION_POINTER_INDEX_MASK & result) >> 8));
        bb.put((byte) (result & MotionEventCompat.ACTION_MASK));
    }

    public static void writeFixedPoint88(ByteBuffer bb, double v) {
        short result = (short) ((int) (256.0d * v));
        bb.put((byte) ((MotionEventCompat.ACTION_POINTER_INDEX_MASK & result) >> 8));
        bb.put((byte) (result & MotionEventCompat.ACTION_MASK));
    }

    public static void writeIso639(ByteBuffer bb, String language) {
        if (language.getBytes().length != 3) {
            throw new IllegalArgumentException("\"" + language + "\" language string isn't exactly 3 characters long!");
        }
        int bits = 0;
        for (int i = 0; i < 3; i++) {
            bits += (language.getBytes()[i] - 96) << ((2 - i) * 5);
        }
        writeUInt16(bb, bits);
    }

    public static void writePascalUtfString(ByteBuffer bb, String string) {
        byte[] b = Utf8.convert(string);
        if ($assertionsDisabled || b.length < MotionEventCompat.ACTION_MASK) {
            writeUInt8(bb, b.length);
            bb.put(b);
            return;
        }
        throw new AssertionError();
    }

    public static void writeZeroTermUtf8String(ByteBuffer bb, String string) {
        bb.put(Utf8.convert(string));
        writeUInt8(bb, 0);
    }

    public static void writeUtf8String(ByteBuffer bb, String string) {
        bb.put(Utf8.convert(string));
        writeUInt8(bb, 0);
    }
}
