package com.google.android.gms.internal;

import android.util.Base64;

/* renamed from: com.google.android.gms.internal.e */
class C0940e implements C0487m {
    C0940e() {
    }

    /* renamed from: a */
    public String mo1763a(byte[] bArr, boolean z) {
        return Base64.encodeToString(bArr, z ? 11 : 2);
    }

    /* renamed from: a */
    public byte[] mo1764a(String str, boolean z) throws IllegalArgumentException {
        return Base64.decode(str, z ? 11 : 2);
    }
}
