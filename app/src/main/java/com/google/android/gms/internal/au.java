package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0275g;
import com.google.android.gms.dynamic.C1332e;
import com.google.android.gms.internal.bd.C0906a;
import com.google.android.gms.internal.be.C0908a;

@ey
public final class au extends C0275g<be> {
    private static final au oc = new au();

    private au() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    /* renamed from: a */
    public static bd m3046a(Context context, ay ayVar, String str, cx cxVar) {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0) {
            bd b = oc.m3047b(context, ayVar, str, cxVar);
            if (b != null) {
                return b;
            }
        }
        gr.m1337S("Using AdManager from the client jar.");
        return new C1440u(context, ayVar, str, cxVar, new gs(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, true));
    }

    /* renamed from: b */
    private bd m3047b(Context context, ay ayVar, String str, cx cxVar) {
        try {
            return C0906a.m3061f(((be) m513L(context)).mo1695a(C1332e.m4013k(context), ayVar, str, cxVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE));
        } catch (Throwable e) {
            gr.m1345d("Could not create remote AdManager.", e);
            return null;
        } catch (Throwable e2) {
            gr.m1345d("Could not create remote AdManager.", e2);
            return null;
        }
    }

    /* renamed from: c */
    protected be m3048c(IBinder iBinder) {
        return C0908a.m3063g(iBinder);
    }

    /* renamed from: d */
    protected /* synthetic */ Object mo1672d(IBinder iBinder) {
        return m3048c(iBinder);
    }
}
