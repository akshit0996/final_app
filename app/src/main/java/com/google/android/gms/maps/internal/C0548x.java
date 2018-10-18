package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C1332e;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.internal.C0527c.C1118a;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* renamed from: com.google.android.gms.maps.internal.x */
public class C0548x {
    private static Context alI;
    private static C0527c alJ;

    /* renamed from: S */
    public static C0527c m1974S(Context context) throws GooglePlayServicesNotAvailableException {
        jx.m1582i(context);
        if (alJ != null) {
            return alJ;
        }
        C0548x.m1975T(context);
        alJ = C0548x.m1976U(context);
        try {
            alJ.mo2303a(C1332e.m4013k(C0548x.getRemoteContext(context).getResources()), (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            return alJ;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: T */
    private static void m1975T(Context context) throws GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        switch (isGooglePlayServicesAvailable) {
            case 0:
                return;
            default:
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
    }

    /* renamed from: U */
    private static C0527c m1976U(Context context) {
        if (C0548x.nY()) {
            Log.i(C0548x.class.getSimpleName(), "Making Creator statically");
            return (C0527c) C0548x.m1978c(C0548x.nZ());
        }
        Log.i(C0548x.class.getSimpleName(), "Making Creator dynamically");
        return C1118a.aS((IBinder) C0548x.m1977a(C0548x.getRemoteContext(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
    }

    /* renamed from: a */
    private static <T> T m1977a(ClassLoader classLoader, String str) {
        try {
            return C0548x.m1978c(((ClassLoader) jx.m1582i(classLoader)).loadClass(str));
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Unable to find dynamic class " + str);
        }
    }

    /* renamed from: c */
    private static <T> T m1978c(Class<?> cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            throw new IllegalStateException("Unable to instantiate the dynamic class " + cls.getName());
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unable to call the default constructor of " + cls.getName());
        }
    }

    private static Context getRemoteContext(Context context) {
        if (alI == null) {
            if (C0548x.nY()) {
                alI = context.getApplicationContext();
            } else {
                alI = GooglePlayServicesUtil.getRemoteContext(context);
            }
        }
        return alI;
    }

    public static boolean nY() {
        return false;
    }

    private static Class<?> nZ() {
        try {
            return VERSION.SDK_INT < 15 ? Class.forName("com.google.android.gms.maps.internal.CreatorImplGmm6") : Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
