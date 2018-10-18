package com.google.ads.mediation.admob;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.gq;
import java.util.Date;
import java.util.Set;

public final class AdMobAdapter implements MediationBannerAdapter, MediationInterstitialAdapter {
    /* renamed from: i */
    private AdView f99i;
    /* renamed from: j */
    private InterstitialAd f100j;

    /* renamed from: com.google.ads.mediation.admob.AdMobAdapter$a */
    private static final class C0776a extends AdListener {
        /* renamed from: k */
        private final AdMobAdapter f91k;
        /* renamed from: l */
        private final MediationBannerListener f92l;

        public C0776a(AdMobAdapter adMobAdapter, MediationBannerListener mediationBannerListener) {
            this.f91k = adMobAdapter;
            this.f92l = mediationBannerListener;
        }

        public void onAdClosed() {
            this.f92l.onAdClosed(this.f91k);
        }

        public void onAdFailedToLoad(int errorCode) {
            this.f92l.onAdFailedToLoad(this.f91k, errorCode);
        }

        public void onAdLeftApplication() {
            this.f92l.onAdLeftApplication(this.f91k);
        }

        public void onAdLoaded() {
            this.f92l.onAdLoaded(this.f91k);
        }

        public void onAdOpened() {
            this.f92l.onAdClicked(this.f91k);
            this.f92l.onAdOpened(this.f91k);
        }
    }

    /* renamed from: com.google.ads.mediation.admob.AdMobAdapter$b */
    private static final class C0777b extends AdListener {
        /* renamed from: k */
        private final AdMobAdapter f93k;
        /* renamed from: m */
        private final MediationInterstitialListener f94m;

        public C0777b(AdMobAdapter adMobAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.f93k = adMobAdapter;
            this.f94m = mediationInterstitialListener;
        }

        public void onAdClosed() {
            this.f94m.onAdClosed(this.f93k);
        }

        public void onAdFailedToLoad(int errorCode) {
            this.f94m.onAdFailedToLoad(this.f93k, errorCode);
        }

        public void onAdLeftApplication() {
            this.f94m.onAdLeftApplication(this.f93k);
        }

        public void onAdLoaded() {
            this.f94m.onAdLoaded(this.f93k);
        }

        public void onAdOpened() {
            this.f94m.onAdOpened(this.f93k);
        }
    }

    /* renamed from: a */
    static AdRequest m3907a(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        Builder builder = new Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            builder.setGender(gender);
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String addKeyword : keywords) {
                builder.addKeyword(addKeyword);
            }
        }
        Location location = mediationAdRequest.getLocation();
        if (location != null) {
            builder.setLocation(location);
        }
        if (mediationAdRequest.isTesting()) {
            builder.addTestDevice(gq.m1336v(context));
        }
        if (bundle2.getInt("tagForChildDirectedTreatment") != -1) {
            builder.tagForChildDirectedTreatment(bundle2.getInt("tagForChildDirectedTreatment") == 1);
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("gw", 1);
        bundle.putString("mad_hac", bundle2.getString("mad_hac"));
        if (!TextUtils.isEmpty(bundle2.getString("adJson"))) {
            bundle.putString("_ad", bundle2.getString("adJson"));
        }
        bundle.putBoolean("_noRefresh", true);
        builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle);
        return builder.build();
    }

    public View getBannerView() {
        return this.f99i;
    }

    public void onDestroy() {
        if (this.f99i != null) {
            this.f99i.destroy();
            this.f99i = null;
        }
        if (this.f100j != null) {
            this.f100j = null;
        }
    }

    public void onPause() {
        if (this.f99i != null) {
            this.f99i.pause();
        }
    }

    public void onResume() {
        if (this.f99i != null) {
            this.f99i.resume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener bannerListener, Bundle serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle extras) {
        this.f99i = new AdView(context);
        this.f99i.setAdSize(new AdSize(adSize.getWidth(), adSize.getHeight()));
        this.f99i.setAdUnitId(serverParameters.getString("pubid"));
        this.f99i.setAdListener(new C0776a(this, bannerListener));
        this.f99i.loadAd(m3907a(context, mediationAdRequest, extras, serverParameters));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener interstitialListener, Bundle serverParameters, MediationAdRequest mediationAdRequest, Bundle extras) {
        this.f100j = new InterstitialAd(context);
        this.f100j.setAdUnitId(serverParameters.getString("pubid"));
        this.f100j.setAdListener(new C0777b(this, interstitialListener));
        this.f100j.loadAd(m3907a(context, mediationAdRequest, extras, serverParameters));
    }

    public void showInterstitial() {
        this.f100j.show();
    }
}
