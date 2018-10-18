package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;

/* renamed from: com.google.android.gms.common.data.d */
public abstract class C0174d {
    protected final DataHolder JG;
    protected int KZ;
    private int La;

    public C0174d(DataHolder dataHolder, int i) {
        this.JG = (DataHolder) jx.m1582i(dataHolder);
        as(i);
    }

    /* renamed from: a */
    protected void m172a(String str, CharArrayBuffer charArrayBuffer) {
        this.JG.m2491a(str, this.KZ, this.La, charArrayBuffer);
    }

    public boolean aQ(String str) {
        return this.JG.aQ(str);
    }

    protected Uri aR(String str) {
        return this.JG.m2498g(str, this.KZ, this.La);
    }

    protected boolean aS(String str) {
        return this.JG.m2499h(str, this.KZ, this.La);
    }

    protected void as(int i) {
        boolean z = i >= 0 && i < this.JG.getCount();
        jx.m1574K(z);
        this.KZ = i;
        this.La = this.JG.au(this.KZ);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0174d)) {
            return false;
        }
        C0174d c0174d = (C0174d) obj;
        return jv.equal(Integer.valueOf(c0174d.KZ), Integer.valueOf(this.KZ)) && jv.equal(Integer.valueOf(c0174d.La), Integer.valueOf(this.La)) && c0174d.JG == this.JG;
    }

    protected int gW() {
        return this.KZ;
    }

    protected boolean getBoolean(String column) {
        return this.JG.m2494d(column, this.KZ, this.La);
    }

    protected byte[] getByteArray(String column) {
        return this.JG.m2497f(column, this.KZ, this.La);
    }

    protected float getFloat(String column) {
        return this.JG.m2495e(column, this.KZ, this.La);
    }

    protected int getInteger(String column) {
        return this.JG.m2492b(column, this.KZ, this.La);
    }

    protected long getLong(String column) {
        return this.JG.m2490a(column, this.KZ, this.La);
    }

    protected String getString(String column) {
        return this.JG.m2493c(column, this.KZ, this.La);
    }

    public int hashCode() {
        return jv.hashCode(Integer.valueOf(this.KZ), Integer.valueOf(this.La), this.JG);
    }

    public boolean isDataValid() {
        return !this.JG.isClosed();
    }
}
