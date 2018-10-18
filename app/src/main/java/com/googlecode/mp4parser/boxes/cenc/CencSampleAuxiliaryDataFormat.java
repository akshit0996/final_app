package com.googlecode.mp4parser.boxes.cenc;

import com.coremedia.iso.Hex;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CencSampleAuxiliaryDataFormat {
    public byte[] iv;
    public List<Pair> pairs = new LinkedList();

    public class Pair {
        public int clear;
        public long encrypted;

        public Pair(int clear, long encrypted) {
            this.clear = clear;
            this.encrypted = encrypted;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair pair = (Pair) o;
            if (this.clear != pair.clear) {
                return false;
            }
            if (this.encrypted != pair.encrypted) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.clear * 31) + ((int) (this.encrypted ^ (this.encrypted >>> 32)));
        }

        public String toString() {
            return "clr:" + this.clear + " enc:" + this.encrypted;
        }
    }

    public int getSize() {
        int size = this.iv.length;
        if (this.pairs == null || this.pairs.size() <= 0) {
            return size;
        }
        return (size + 2) + (this.pairs.size() * 6);
    }

    public Pair createPair(int clear, long encrypted) {
        return new Pair(clear, encrypted);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CencSampleAuxiliaryDataFormat entry = (CencSampleAuxiliaryDataFormat) o;
        if (!new BigInteger(this.iv).equals(new BigInteger(entry.iv))) {
            return false;
        }
        if (this.pairs != null) {
            if (this.pairs.equals(entry.pairs)) {
                return true;
            }
        } else if (entry.pairs == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result;
        int i = 0;
        if (this.iv != null) {
            result = Arrays.hashCode(this.iv);
        } else {
            result = 0;
        }
        int i2 = result * 31;
        if (this.pairs != null) {
            i = this.pairs.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        return "Entry{iv=" + Hex.encodeHex(this.iv) + ", pairs=" + this.pairs + '}';
    }
}
