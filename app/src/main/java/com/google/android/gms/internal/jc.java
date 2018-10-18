package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;

public final class jc extends kj<C0474a, Drawable> {

    /* renamed from: com.google.android.gms.internal.jc$a */
    public static final class C0474a {
        public final int Mt;
        public final int Mu;

        public C0474a(int i, int i2) {
            this.Mt = i;
            this.Mu = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0474a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0474a c0474a = (C0474a) obj;
            return c0474a.Mt == this.Mt && c0474a.Mu == this.Mu;
        }

        public int hashCode() {
            return jv.hashCode(Integer.valueOf(this.Mt), Integer.valueOf(this.Mu));
        }
    }

    public jc() {
        super(10);
    }
}
