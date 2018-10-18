package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.internal.gr;

public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    /* renamed from: n */
    private View f106n;
    /* renamed from: o */
    private CustomEventBanner f107o;
    /* renamed from: p */
    private CustomEventInterstitial f108p;

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter$a */
    private static final class C1288a implements CustomEventBannerListener {
        /* renamed from: q */
        private final CustomEventAdapter f101q;
        /* renamed from: r */
        private final MediationBannerListener f102r;

        public C1288a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.f101q = customEventAdapter;
            this.f102r = mediationBannerListener;
        }

        public void onClick() {
            gr.m1337S("Custom event adapter called onFailedToReceiveAd.");
            this.f102r.onClick(this.f101q);
        }

        public void onDismissScreen() {
            gr.m1337S("Custom event adapter called onFailedToReceiveAd.");
            this.f102r.onDismissScreen(this.f101q);
        }

        public void onFailedToReceiveAd() {
            gr.m1337S("Custom event adapter called onFailedToReceiveAd.");
            this.f102r.onFailedToReceiveAd(this.f101q, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            gr.m1337S("Custom event adapter called onFailedToReceiveAd.");
            this.f102r.onLeaveApplication(this.f101q);
        }

        public void onPresentScreen() {
            gr.m1337S("Custom event adapter called onFailedToReceiveAd.");
            this.f102r.onPresentScreen(this.f101q);
        }

        public void onReceivedAd(View view) {
            gr.m1337S("Custom event adapter called onReceivedAd.");
            this.f101q.m3909a(view);
            this.f102r.onReceivedAd(this.f101q);
        }
    }

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter$b */
    private class C1289b implements CustomEventInterstitialListener {
        /* renamed from: q */
        private final CustomEventAdapter f103q;
        /* renamed from: s */
        private final MediationInterstitialListener f104s;
        /* renamed from: t */
        final /* synthetic */ CustomEventAdapter f105t;

        public C1289b(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            this.f105t = customEventAdapter;
            this.f103q = customEventAdapter2;
            this.f104s = mediationInterstitialListener;
        }

        public void onDismissScreen() {
            gr.m1337S("Custom event adapter called onDismissScreen.");
            this.f104s.onDismissScreen(this.f103q);
        }

        public void onFailedToReceiveAd() {
            gr.m1337S("Custom event adapter called onFailedToReceiveAd.");
            this.f104s.onFailedToReceiveAd(this.f103q, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            gr.m1337S("Custom event adapter called onLeaveApplication.");
            this.f104s.onLeaveApplication(this.f103q);
        }

        public void onPresentScreen() {
            gr.m1337S("Custom event adapter called onPresentScreen.");
            this.f104s.onPresentScreen(this.f103q);
        }

        public void onReceivedAd() {
            gr.m1337S("Custom event adapter called onReceivedAd.");
            this.f104s.onReceivedAd(this.f105t);
        }
    }

    /* renamed from: a */
    private static <T> T m3908a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            gr.m1341W("Could not instantiate custom event adapter: " + str + ". " + th.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    private void m3909a(View view) {
        this.f106n = view;
    }

    public void destroy() {
        if (this.f107o != null) {
            this.f107o.destroy();
        }
        if (this.f108p != null) {
            this.f108p.destroy();
        }
    }

    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public View getBannerView() {
        return this.f106n;
    }

    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener listener, Activity activity, CustomEventServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f107o = (CustomEventBanner) m3908a(serverParameters.className);
        if (this.f107o == null) {
            listener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.f107o.requestBannerAd(new C1288a(this, listener), activity, serverParameters.label, serverParameters.parameter, adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener listener, Activity activity, CustomEventServerParameters serverParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f108p = (CustomEventInterstitial) m3908a(serverParameters.className);
        if (this.f108p == null) {
            listener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.f108p.requestInterstitialAd(new C1289b(this, this, listener), activity, serverParameters.label, serverParameters.parameter, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void showInterstitial() {
        this.f108p.showInterstitial();
    }
}
