package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.internal.en.C0944a;

@ey
public final class es extends C0944a {
    private final InAppPurchaseListener oM;

    public es(InAppPurchaseListener inAppPurchaseListener) {
        this.oM = inAppPurchaseListener;
    }

    /* renamed from: a */
    public void mo1770a(em emVar) {
        this.oM.onInAppPurchaseRequested(new ev(emVar));
    }
}
