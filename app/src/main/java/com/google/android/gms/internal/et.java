package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.dynamic.C0275g;
import com.google.android.gms.dynamic.C1332e;
import com.google.android.gms.internal.eo.C0946a;
import com.google.android.gms.internal.ep.C0948a;

@ey
public final class et extends C0275g<ep> {
    private static final et td = new et();

    /* renamed from: com.google.android.gms.internal.et$a */
    private static final class C0411a extends Exception {
        public C0411a(String str) {
            super(str);
        }
    }

    private et() {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }

    /* renamed from: c */
    private static boolean m3140c(Activity activity) throws C0411a {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false);
        }
        throw new C0411a("InAppPurchaseManager requires the useClientJar flag in intent extras.");
    }

    /* renamed from: e */
    public static eo m3141e(Activity activity) {
        try {
            if (!m3140c(activity)) {
                return td.m3142f(activity);
            }
            gr.m1337S("Using AdOverlay from the client jar.");
            return new ee(activity);
        } catch (C0411a e) {
            gr.m1341W(e.getMessage());
            return null;
        }
    }

    /* renamed from: f */
    private eo m3142f(Activity activity) {
        try {
            return C0946a.m3134w(((ep) m513L(activity)).mo1774c(C1332e.m4013k(activity)));
        } catch (Throwable e) {
            gr.m1345d("Could not create remote InAppPurchaseManager.", e);
            return null;
        } catch (Throwable e2) {
            gr.m1345d("Could not create remote InAppPurchaseManager.", e2);
            return null;
        }
    }

    /* renamed from: A */
    protected ep m3143A(IBinder iBinder) {
        return C0948a.m3136x(iBinder);
    }

    /* renamed from: d */
    protected /* synthetic */ Object mo1672d(IBinder iBinder) {
        return m3143A(iBinder);
    }
}
