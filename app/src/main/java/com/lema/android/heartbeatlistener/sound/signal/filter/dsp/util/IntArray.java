package com.lema.android.heartbeatlistener.sound.signal.filter.dsp.util;

import android.support.v4.view.MotionEventCompat;

public final class IntArray {
    private static final int defaultInitialCapacity = 16;
    private int[] a;
    private int initialCapacity;
    private int size;

    public IntArray() {
        this(16);
    }

    public IntArray(int initialCapacity) {
        this.initialCapacity = initialCapacity;
    }

    public IntArray(int[] a2) {
        this();
        addAll(a2);
    }

    public void clear() {
        setSize(0);
    }

    public int size() {
        return this.size;
    }

    public void setSize(int newSize) {
        ensureCapacity(newSize);
        this.size = newSize;
    }

    public void add(int element) {
        ensureCapacity(this.size + 1);
        int[] iArr = this.a;
        int i = this.size;
        this.size = i + 1;
        iArr[i] = element;
    }

    public void addAll(int[] a2) {
        int p = this.size;
        setSize(this.size + a2.length);
        System.arraycopy(a2, 0, this.a, p, a2.length);
    }

    public void set(int index, int element) {
        this.a[index] = element;
    }

    public int get(int index) {
        return this.a[index];
    }

    public void ensureCapacity(int minCapacity) {
        int oldCapacity = this.a == null ? 0 : this.a.length;
        if (oldCapacity < minCapacity) {
            int newCapacity = Math.max(Math.max(minCapacity, oldCapacity * 2), this.initialCapacity);
            if (newCapacity > 0) {
                int[] newArray = new int[newCapacity];
                if (this.size > 0) {
                    System.arraycopy(this.a, 0, newArray, 0, this.size);
                }
                this.a = newArray;
            }
        }
    }

    public int[] toArray() {
        int[] a2 = new int[this.size];
        if (this.size > 0) {
            System.arraycopy(this.a, 0, a2, 0, this.size);
        }
        return a2;
    }

    public String toString(String delimiter) {
        StringBuilder s = new StringBuilder(512);
        for (int p = 0; p < this.size; p++) {
            if (p > 0) {
                s.append(delimiter);
            }
            s.append(Integer.toString(this.a[p]));
        }
        return s.toString();
    }

    public String toString() {
        return toString(" ");
    }

    public static IntArray parse(String s) {
        IntArray a = parseOrNull(s);
        if (a == null) {
            return new IntArray(0);
        }
        return a;
    }

    public static IntArray parseOrNull(String s) {
        IntArray a = null;
        int p = 0;
        while (true) {
            int p0 = skipListDelimiters(s, p, true);
            if (p0 >= s.length()) {
                return a;
            }
            p = skipListDelimiters(s, p0, false);
            int i = Integer.parseInt(s.substring(p0, p));
            if (a == null) {
                a = new IntArray();
            }
            a.add(i);
        }
    }

    private static int skipListDelimiters(String s, int p, boolean mode) {
        while (p < s.length()) {
            char c = s.charAt(p);
            boolean z = Character.isWhitespace(c) || c == ',' || c == ';' || c == '+';
            if (z != mode) {
                break;
            }
            p++;
        }
        return p;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof IntArray)) {
            return false;
        }
        IntArray ia2 = (IntArray) o;
        if (ia2.size != this.size) {
            return false;
        }
        if (this.size == 0) {
            return true;
        }
        int[] a2 = ia2.a;
        if (this.size >= 16 && (this.a[0] != a2[0] || this.a[this.size / 2] != a2[this.size / 2] || this.a[this.size - 1] != a2[this.size - 1])) {
            return false;
        }
        for (int i = 0; i < this.size; i++) {
            if (this.a[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }

    public static IntArray unpack(byte[] b, int p0, int bitsPerEntry, int n) {
        IntArray a = new IntArray(n);
        a.setSize(n);
        int vMask = (1 << bitsPerEntry) - 1;
        int w = 0;
        int bits = 0;
        int op = 0;
        int ip = p0;
        while (op < n) {
            if (bits >= bitsPerEntry) {
                int op2 = op + 1;
                a.set(op, (w >>> (bits - bitsPerEntry)) & vMask);
                bits -= bitsPerEntry;
                op = op2;
            } else {
                w = ((8388607 & w) << 8) | (b[ip] & MotionEventCompat.ACTION_MASK);
                bits += 8;
                ip++;
            }
        }
        return a;
    }
}
