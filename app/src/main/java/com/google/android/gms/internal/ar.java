package com.google.android.gms.internal;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import java.security.MessageDigest;

public class ar extends ao {
    private MessageDigest nZ;

    /* renamed from: a */
    byte[] m3043a(String[] strArr) {
        byte[] bArr = new byte[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            bArr[i] = m3044e(aq.m1028o(strArr[i]));
        }
        return bArr;
    }

    /* renamed from: e */
    byte m3044e(int i) {
        return (byte) ((((i & MotionEventCompat.ACTION_MASK) ^ ((MotionEventCompat.ACTION_POINTER_INDEX_MASK & i) >> 8)) ^ ((16711680 & i) >> 16)) ^ ((ViewCompat.MEASURED_STATE_MASK & i) >> 24));
    }

    /* renamed from: l */
    public byte[] mo1671l(String str) {
        byte[] a = m3043a(str.split(" "));
        this.nZ = bf();
        synchronized (this.mH) {
            if (this.nZ == null) {
                a = new byte[0];
            } else {
                this.nZ.reset();
                this.nZ.update(a);
                Object digest = this.nZ.digest();
                int i = 4;
                if (digest.length <= 4) {
                    i = digest.length;
                }
                a = new byte[i];
                System.arraycopy(digest, 0, a, 0, a.length);
            }
        }
        return a;
    }
}
