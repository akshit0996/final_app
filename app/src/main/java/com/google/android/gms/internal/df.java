package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

@ey
public final class df<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final da qW;

    /* renamed from: com.google.android.gms.internal.df$1 */
    class C03871 implements Runnable {
        final /* synthetic */ df qZ;

        C03871(df dfVar) {
            this.qZ = dfVar;
        }

        public void run() {
            try {
                this.qZ.qW.onAdClicked();
            } catch (Throwable e) {
                gr.m1345d("Could not call onAdClicked.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.df$2 */
    class C03882 implements Runnable {
        final /* synthetic */ df qZ;

        C03882(df dfVar) {
            this.qZ = dfVar;
        }

        public void run() {
            try {
                this.qZ.qW.onAdOpened();
            } catch (Throwable e) {
                gr.m1345d("Could not call onAdOpened.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.df$3 */
    class C03893 implements Runnable {
        final /* synthetic */ df qZ;

        C03893(df dfVar) {
            this.qZ = dfVar;
        }

        public void run() {
            try {
                this.qZ.qW.onAdLoaded();
            } catch (Throwable e) {
                gr.m1345d("Could not call onAdLoaded.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.df$4 */
    class C03904 implements Runnable {
        final /* synthetic */ df qZ;

        C03904(df dfVar) {
            this.qZ = dfVar;
        }

        public void run() {
            try {
                this.qZ.qW.onAdClosed();
            } catch (Throwable e) {
                gr.m1345d("Could not call onAdClosed.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.df$6 */
    class C03926 implements Runnable {
        final /* synthetic */ df qZ;

        C03926(df dfVar) {
            this.qZ = dfVar;
        }

        public void run() {
            try {
                this.qZ.qW.onAdLeftApplication();
            } catch (Throwable e) {
                gr.m1345d("Could not call onAdLeftApplication.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.df$7 */
    class C03937 implements Runnable {
        final /* synthetic */ df qZ;

        C03937(df dfVar) {
            this.qZ = dfVar;
        }

        public void run() {
            try {
                this.qZ.qW.onAdOpened();
            } catch (Throwable e) {
                gr.m1345d("Could not call onAdOpened.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.df$8 */
    class C03948 implements Runnable {
        final /* synthetic */ df qZ;

        C03948(df dfVar) {
            this.qZ = dfVar;
        }

        public void run() {
            try {
                this.qZ.qW.onAdLoaded();
            } catch (Throwable e) {
                gr.m1345d("Could not call onAdLoaded.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.df$9 */
    class C03959 implements Runnable {
        final /* synthetic */ df qZ;

        C03959(df dfVar) {
            this.qZ = dfVar;
        }

        public void run() {
            try {
                this.qZ.qW.onAdClosed();
            } catch (Throwable e) {
                gr.m1345d("Could not call onAdClosed.", e);
            }
        }
    }

    public df(da daVar) {
        this.qW = daVar;
    }

    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        gr.m1337S("Adapter called onClick.");
        if (gq.dB()) {
            try {
                this.qW.onAdClicked();
                return;
            } catch (Throwable e) {
                gr.m1345d("Could not call onAdClicked.", e);
                return;
            }
        }
        gr.m1341W("onClick must be called on the main UI thread.");
        gq.wR.post(new C03871(this));
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        gr.m1337S("Adapter called onDismissScreen.");
        if (gq.dB()) {
            try {
                this.qW.onAdClosed();
                return;
            } catch (Throwable e) {
                gr.m1345d("Could not call onAdClosed.", e);
                return;
            }
        }
        gr.m1341W("onDismissScreen must be called on the main UI thread.");
        gq.wR.post(new C03904(this));
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        gr.m1337S("Adapter called onDismissScreen.");
        if (gq.dB()) {
            try {
                this.qW.onAdClosed();
                return;
            } catch (Throwable e) {
                gr.m1345d("Could not call onAdClosed.", e);
                return;
            }
        }
        gr.m1341W("onDismissScreen must be called on the main UI thread.");
        gq.wR.post(new C03959(this));
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, final ErrorCode errorCode) {
        gr.m1337S("Adapter called onFailedToReceiveAd with error. " + errorCode);
        if (gq.dB()) {
            try {
                this.qW.onAdFailedToLoad(dg.m1113a(errorCode));
                return;
            } catch (Throwable e) {
                gr.m1345d("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        gr.m1341W("onFailedToReceiveAd must be called on the main UI thread.");
        gq.wR.post(new Runnable(this) {
            final /* synthetic */ df qZ;

            public void run() {
                try {
                    this.qZ.qW.onAdFailedToLoad(dg.m1113a(errorCode));
                } catch (Throwable e) {
                    gr.m1345d("Could not call onAdFailedToLoad.", e);
                }
            }
        });
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, final ErrorCode errorCode) {
        gr.m1337S("Adapter called onFailedToReceiveAd with error " + errorCode + ".");
        if (gq.dB()) {
            try {
                this.qW.onAdFailedToLoad(dg.m1113a(errorCode));
                return;
            } catch (Throwable e) {
                gr.m1345d("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        gr.m1341W("onFailedToReceiveAd must be called on the main UI thread.");
        gq.wR.post(new Runnable(this) {
            final /* synthetic */ df qZ;

            public void run() {
                try {
                    this.qZ.qW.onAdFailedToLoad(dg.m1113a(errorCode));
                } catch (Throwable e) {
                    gr.m1345d("Could not call onAdFailedToLoad.", e);
                }
            }
        });
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        gr.m1337S("Adapter called onLeaveApplication.");
        if (gq.dB()) {
            try {
                this.qW.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                gr.m1345d("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        gr.m1341W("onLeaveApplication must be called on the main UI thread.");
        gq.wR.post(new C03926(this));
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        gr.m1337S("Adapter called onLeaveApplication.");
        if (gq.dB()) {
            try {
                this.qW.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                gr.m1345d("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        gr.m1341W("onLeaveApplication must be called on the main UI thread.");
        gq.wR.post(new Runnable(this) {
            final /* synthetic */ df qZ;

            {
                this.qZ = r1;
            }

            public void run() {
                try {
                    this.qZ.qW.onAdLeftApplication();
                } catch (Throwable e) {
                    gr.m1345d("Could not call onAdLeftApplication.", e);
                }
            }
        });
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        gr.m1337S("Adapter called onPresentScreen.");
        if (gq.dB()) {
            try {
                this.qW.onAdOpened();
                return;
            } catch (Throwable e) {
                gr.m1345d("Could not call onAdOpened.", e);
                return;
            }
        }
        gr.m1341W("onPresentScreen must be called on the main UI thread.");
        gq.wR.post(new C03937(this));
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        gr.m1337S("Adapter called onPresentScreen.");
        if (gq.dB()) {
            try {
                this.qW.onAdOpened();
                return;
            } catch (Throwable e) {
                gr.m1345d("Could not call onAdOpened.", e);
                return;
            }
        }
        gr.m1341W("onPresentScreen must be called on the main UI thread.");
        gq.wR.post(new C03882(this));
    }

    public void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        gr.m1337S("Adapter called onReceivedAd.");
        if (gq.dB()) {
            try {
                this.qW.onAdLoaded();
                return;
            } catch (Throwable e) {
                gr.m1345d("Could not call onAdLoaded.", e);
                return;
            }
        }
        gr.m1341W("onReceivedAd must be called on the main UI thread.");
        gq.wR.post(new C03948(this));
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        gr.m1337S("Adapter called onReceivedAd.");
        if (gq.dB()) {
            try {
                this.qW.onAdLoaded();
                return;
            } catch (Throwable e) {
                gr.m1345d("Could not call onAdLoaded.", e);
                return;
            }
        }
        gr.m1341W("onReceivedAd must be called on the main UI thread.");
        gq.wR.post(new C03893(this));
    }
}
