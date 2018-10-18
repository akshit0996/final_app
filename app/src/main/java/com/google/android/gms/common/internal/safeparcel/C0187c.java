package com.google.android.gms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.jx;

/* renamed from: com.google.android.gms.common.internal.safeparcel.c */
public final class C0187c {
    /* renamed from: a */
    public static <T extends SafeParcelable> T m271a(Intent intent, String str, Creator<T> creator) {
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        return byteArrayExtra == null ? null : C0187c.m272a(byteArrayExtra, creator);
    }

    /* renamed from: a */
    public static <T extends SafeParcelable> T m272a(byte[] bArr, Creator<T> creator) {
        jx.m1582i(creator);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable) creator.createFromParcel(obtain);
        obtain.recycle();
        return safeParcelable;
    }

    /* renamed from: a */
    public static <T extends SafeParcelable> void m273a(T t, Intent intent, String str) {
        intent.putExtra(str, C0187c.m274a(t));
    }

    /* renamed from: a */
    public static <T extends SafeParcelable> byte[] m274a(T t) {
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }
}
