package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.dynamic.C0275g;
import com.google.android.gms.dynamic.C1332e;
import com.google.android.gms.internal.dx.C0937a;
import com.google.android.gms.internal.dy.C0939a;

@ey
public final class dw extends C0275g<dy> {
    private static final dw sy = new dw();

    /* renamed from: com.google.android.gms.internal.dw$a */
    private static final class C0408a extends Exception {
        public C0408a(String str) {
            super(str);
        }
    }

    private dw() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    /* renamed from: b */
    public static dx m3112b(Activity activity) {
        try {
            if (!m3113c(activity)) {
                return sy.m3114d(activity);
            }
            gr.m1337S("Using AdOverlay from the client jar.");
            return new dp(activity);
        } catch (C0408a e) {
            gr.m1341W(e.getMessage());
            return null;
        }
    }

    /* renamed from: c */
    private static boolean m3113c(Activity activity) throws C0408a {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        throw new C0408a("Ad overlay requires the useClientJar flag in intent extras.");
    }

    /* renamed from: d */
    private dx m3114d(Activity activity) {
        try {
            return C0937a.m3118r(((dy) m513L(activity)).mo1762b(C1332e.m4013k(activity)));
        } catch (Throwable e) {
            gr.m1345d("Could not create remote AdOverlay.", e);
            return null;
        } catch (Throwable e2) {
            gr.m1345d("Could not create remote AdOverlay.", e2);
            return null;
        }
    }

    /* renamed from: d */
    protected /* synthetic */ Object mo1672d(IBinder iBinder) {
        return m3116q(iBinder);
    }

    /* renamed from: q */
    protected dy m3116q(IBinder iBinder) {
        return C0939a.m3120s(iBinder);
    }
}
