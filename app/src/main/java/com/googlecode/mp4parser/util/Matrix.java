package com.googlecode.mp4parser.util;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import java.nio.ByteBuffer;

public class Matrix {
    public static final Matrix ROTATE_0 = new Matrix(1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    public static final Matrix ROTATE_180 = new Matrix(-1.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    public static final Matrix ROTATE_270 = new Matrix(0.0d, -1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    public static final Matrix ROTATE_90 = new Matrix(0.0d, 1.0d, -1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    /* renamed from: a */
    double f52a;
    /* renamed from: b */
    double f53b;
    /* renamed from: c */
    double f54c;
    /* renamed from: d */
    double f55d;
    double tx;
    double ty;
    /* renamed from: u */
    double f56u;
    /* renamed from: v */
    double f57v;
    /* renamed from: w */
    double f58w;

    public Matrix(double a, double b, double c, double d, double u, double v, double w, double tx, double ty) {
        this.f56u = u;
        this.f57v = v;
        this.f58w = w;
        this.f52a = a;
        this.f53b = b;
        this.f54c = c;
        this.f55d = d;
        this.tx = tx;
        this.ty = ty;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Matrix matrix = (Matrix) o;
        if (Double.compare(matrix.f52a, this.f52a) != 0) {
            return false;
        }
        if (Double.compare(matrix.f53b, this.f53b) != 0) {
            return false;
        }
        if (Double.compare(matrix.f54c, this.f54c) != 0) {
            return false;
        }
        if (Double.compare(matrix.f55d, this.f55d) != 0) {
            return false;
        }
        if (Double.compare(matrix.tx, this.tx) != 0) {
            return false;
        }
        if (Double.compare(matrix.ty, this.ty) != 0) {
            return false;
        }
        if (Double.compare(matrix.f56u, this.f56u) != 0) {
            return false;
        }
        if (Double.compare(matrix.f57v, this.f57v) != 0) {
            return false;
        }
        if (Double.compare(matrix.f58w, this.f58w) != 0) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long temp = Double.doubleToLongBits(this.f56u);
        int result = (int) ((temp >>> 32) ^ temp);
        temp = Double.doubleToLongBits(this.f57v);
        result = (result * 31) + ((int) ((temp >>> 32) ^ temp));
        temp = Double.doubleToLongBits(this.f58w);
        result = (result * 31) + ((int) ((temp >>> 32) ^ temp));
        temp = Double.doubleToLongBits(this.f52a);
        result = (result * 31) + ((int) ((temp >>> 32) ^ temp));
        temp = Double.doubleToLongBits(this.f53b);
        result = (result * 31) + ((int) ((temp >>> 32) ^ temp));
        temp = Double.doubleToLongBits(this.f54c);
        result = (result * 31) + ((int) ((temp >>> 32) ^ temp));
        temp = Double.doubleToLongBits(this.f55d);
        result = (result * 31) + ((int) ((temp >>> 32) ^ temp));
        temp = Double.doubleToLongBits(this.tx);
        result = (result * 31) + ((int) ((temp >>> 32) ^ temp));
        temp = Double.doubleToLongBits(this.ty);
        return (result * 31) + ((int) ((temp >>> 32) ^ temp));
    }

    public String toString() {
        if (equals(ROTATE_0)) {
            return "Rotate 0°";
        }
        if (equals(ROTATE_90)) {
            return "Rotate 90°";
        }
        if (equals(ROTATE_180)) {
            return "Rotate 180°";
        }
        if (equals(ROTATE_270)) {
            return "Rotate 270°";
        }
        return "Matrix{u=" + this.f56u + ", v=" + this.f57v + ", w=" + this.f58w + ", a=" + this.f52a + ", b=" + this.f53b + ", c=" + this.f54c + ", d=" + this.f55d + ", tx=" + this.tx + ", ty=" + this.ty + '}';
    }

    public static Matrix fromFileOrder(double a, double b, double u, double c, double d, double v, double tx, double ty, double w) {
        return new Matrix(a, b, c, d, u, v, w, tx, ty);
    }

    public static Matrix fromByteBuffer(ByteBuffer byteBuffer) {
        return fromFileOrder(IsoTypeReader.readFixedPoint1616(byteBuffer), IsoTypeReader.readFixedPoint1616(byteBuffer), IsoTypeReader.readFixedPoint0230(byteBuffer), IsoTypeReader.readFixedPoint1616(byteBuffer), IsoTypeReader.readFixedPoint1616(byteBuffer), IsoTypeReader.readFixedPoint0230(byteBuffer), IsoTypeReader.readFixedPoint1616(byteBuffer), IsoTypeReader.readFixedPoint1616(byteBuffer), IsoTypeReader.readFixedPoint0230(byteBuffer));
    }

    public void getContent(ByteBuffer byteBuffer) {
        IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.f52a);
        IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.f53b);
        IsoTypeWriter.writeFixedPoint0230(byteBuffer, this.f56u);
        IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.f54c);
        IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.f55d);
        IsoTypeWriter.writeFixedPoint0230(byteBuffer, this.f57v);
        IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.tx);
        IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.ty);
        IsoTypeWriter.writeFixedPoint0230(byteBuffer, this.f58w);
    }
}
