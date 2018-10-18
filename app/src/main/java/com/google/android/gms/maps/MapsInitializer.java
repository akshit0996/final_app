package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.internal.C0527c;
import com.google.android.gms.maps.internal.C0548x;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class MapsInitializer {
    private MapsInitializer() {
    }

    /* renamed from: a */
    public static void m1945a(C0527c c0527c) {
        try {
            CameraUpdateFactory.m1944a(c0527c.nW());
            BitmapDescriptorFactory.m1980a(c0527c.nX());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static int initialize(Context context) {
        jx.m1582i(context);
        try {
            m1945a(C0548x.m1974S(context));
            return 0;
        } catch (GooglePlayServicesNotAvailableException e) {
            return e.errorCode;
        }
    }
}
