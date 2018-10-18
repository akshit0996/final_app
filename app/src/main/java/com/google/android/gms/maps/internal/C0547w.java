package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.Parcelable;

/* renamed from: com.google.android.gms.maps.internal.w */
public final class C0547w {
    private C0547w() {
    }

    /* renamed from: a */
    public static void m1973a(Bundle bundle, String str, Parcelable parcelable) {
        bundle.setClassLoader(C0547w.class.getClassLoader());
        Bundle bundle2 = bundle.getBundle("map_state");
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        bundle2.setClassLoader(C0547w.class.getClassLoader());
        bundle2.putParcelable(str, parcelable);
        bundle.putBundle("map_state", bundle2);
    }
}
