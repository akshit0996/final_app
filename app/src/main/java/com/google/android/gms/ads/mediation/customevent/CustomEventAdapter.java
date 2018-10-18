package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.gr;

public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter {
    /* renamed from: n */
    private View f111n;
    private CustomEventBanner xu;
    private CustomEventInterstitial xv;

    /* renamed from: com.google.android.gms.ads.mediation.customevent.CustomEventAdapter$a */
    private static final class C1290a implements CustomEventBannerListener {
        /* renamed from: l */
        private final MediationBannerListener f109l;
        private final CustomEventAdapter xw;

        public C1290a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.xw = customEventAdapter;
            this.f109l = mediationBannerListener;
        }

        public void onAdClicked() {
            gr.m1337S("Custom event adapter called onAdClicked.");
            this.f109l.onAdClicked(this.xw);
        }

        public void onAdClosed() {
            gr.m1337S("Custom event adapter called onAdClosed.");
            this.f109l.onAdClosed(this.xw);
        }

        public void onAdFailedToLoad(int errorCode) {
            gr.m1337S("Custom event adapter called onAdFailedToLoad.");
            this.f109l.onAdFailedToLoad(this.xw, errorCode);
        }

        public void onAdLeftApplication() {
            gr.m1337S("Custom event adapter called onAdLeftApplication.");
            this.f109l.onAdLeftApplication(this.xw);
        }

        public void onAdLoaded(View view) {
            gr.m1337S("Custom event adapter called onAdLoaded.");
            this.xw.m3912a(view);
            this.f109l.onAdLoaded(this.xw);
        }

        public void onAdOpened() {
            gr.m1337S("Custom event adapter called onAdOpened.");
            this.f109l.onAdOpened(this.xw);
        }
    }

    /* renamed from: com.google.android.gms.ads.mediation.customevent.CustomEventAdapter$b */
    private class C1291b implements CustomEventInterstitialListener {
        /* renamed from: m */
        private final MediationInterstitialListener f110m;
        private final CustomEventAdapter xw;
        final /* synthetic */ CustomEventAdapter xx;

        public C1291b(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            this.xx = customEventAdapter;
            this.xw = customEventAdapter2;
            this.f110m = mediationInterstitialListener;
        }

        public void onAdClicked() {
            gr.m1337S("Custom event adapter called onAdClicked.");
            this.f110m.onAdClicked(this.xw);
        }

        public void onAdClosed() {
            gr.m1337S("Custom event adapter called onAdClosed.");
            this.f110m.onAdClosed(this.xw);
        }

        public void onAdFailedToLoad(int errorCode) {
            gr.m1337S("Custom event adapter called onFailedToReceiveAd.");
            this.f110m.onAdFailedToLoad(this.xw, errorCode);
        }

        public void onAdLeftApplication() {
            gr.m1337S("Custom event adapter called onAdLeftApplication.");
            this.f110m.onAdLeftApplication(this.xw);
        }

        public void onAdLoaded() {
            gr.m1337S("Custom event adapter called onReceivedAd.");
            this.f110m.onAdLoaded(this.xx);
        }

        public void onAdOpened() {
            gr.m1337S("Custom event adapter called onAdOpened.");
            this.f110m.onAdOpened(this.xw);
        }
    }

    /* renamed from: a */
    private static <T> T m3911a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            gr.m1341W("Could not instantiate custom event adapter: " + str + ". " + th.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    private void m3912a(View view) {
        this.f111n = view;
    }

    public View getBannerView() {
        return this.f111n;
    }

    public void onDestroy() {
        if (this.xu != null) {
            this.xu.onDestroy();
        }
        if (this.xv != null) {
            this.xv.onDestroy();
        }
    }

    public void onPause() {
        if (this.xu != null) {
            this.xu.onPause();
        }
        if (this.xv != null) {
            this.xv.onPause();
        }
    }

    public void onResume() {
        if (this.xu != null) {
            this.xu.onResume();
        }
        if (this.xv != null) {
            this.xv.onResume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener listener, Bundle serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle customEventExtras) {
        this.xu = (CustomEventBanner) m3911a(serverParameters.getString("class_name"));
        if (this.xu == null) {
            listener.onAdFailedToLoad(this, 0);
            return;
        }
        this.xu.requestBannerAd(context, new C1290a(this, listener), serverParameters.getString("parameter"), adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getBundle(serverParameters.getString("class_name")));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener listener, Bundle serverParameters, MediationAdRequest mediationAdRequest, Bundle customEventExtras) {
        this.xv = (CustomEventInterstitial) m3911a(serverParameters.getString("class_name"));
        if (this.xv == null) {
            listener.onAdFailedToLoad(this, 0);
            return;
        }
        this.xv.requestInterstitialAd(context, new C1291b(this, this, listener), serverParameters.getString("parameter"), mediationAdRequest, customEventExtras == null ? null : customEventExtras.getBundle(serverParameters.getString("class_name")));
    }

    public void showInterstitial() {
        this.xv.showInterstitial();
    }
}
