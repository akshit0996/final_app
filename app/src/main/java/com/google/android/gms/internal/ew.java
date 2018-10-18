package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.er.C0952a;

@ey
public final class ew extends C0952a {
    private final PlayStorePurchaseListener oN;

    public ew(PlayStorePurchaseListener playStorePurchaseListener) {
        this.oN = playStorePurchaseListener;
    }

    /* renamed from: a */
    public void mo1780a(eq eqVar) {
        this.oN.onInAppPurchaseFinished(new eu(eqVar));
    }

    public boolean isValidPurchase(String productId) {
        return this.oN.isValidPurchase(productId);
    }
}
