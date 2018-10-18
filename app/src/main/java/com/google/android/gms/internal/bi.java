package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.C0104b;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

public class bi {
    private final Context mContext;
    private final cx oH;
    private final ax oI;
    private bd oJ;
    private String oK;
    private InAppPurchaseListener oM;
    private PlayStorePurchaseListener oN;
    private C0104b oO;
    private PublisherInterstitialAd oP;
    private AdListener ob;
    private AppEventListener os;
    private String ou;

    public bi(Context context) {
        this(context, ax.bg(), null);
    }

    public bi(Context context, PublisherInterstitialAd publisherInterstitialAd) {
        this(context, ax.bg(), publisherInterstitialAd);
    }

    public bi(Context context, ax axVar, PublisherInterstitialAd publisherInterstitialAd) {
        this.oH = new cx();
        this.mContext = context;
        this.oI = axVar;
        this.oP = publisherInterstitialAd;
    }

    /* renamed from: v */
    private void m1078v(String str) throws RemoteException {
        if (this.ou == null) {
            m1079w(str);
        }
        this.oJ = au.m3046a(this.mContext, new ay(), this.ou, this.oH);
        if (this.ob != null) {
            this.oJ.mo1679a(new at(this.ob));
        }
        if (this.os != null) {
            this.oJ.mo1680a(new ba(this.os));
        }
        if (this.oM != null) {
            this.oJ.mo1682a(new es(this.oM));
        }
        if (this.oN != null) {
            this.oJ.mo1683a(new ew(this.oN), this.oK);
        }
        if (this.oO != null) {
            this.oJ.mo1681a(new bs(this.oO));
        }
    }

    /* renamed from: w */
    private void m1079w(String str) {
        if (this.oJ == null) {
            throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + str + " is called.");
        }
    }

    /* renamed from: a */
    public void m1080a(bg bgVar) {
        try {
            if (this.oJ == null) {
                m1078v("loadAd");
            }
            if (this.oJ.mo1684a(this.oI.m1039a(this.mContext, bgVar))) {
                this.oH.m4338d(bgVar.bj());
            }
        } catch (Throwable e) {
            gr.m1345d("Failed to load ad.", e);
        }
    }

    public AdListener getAdListener() {
        return this.ob;
    }

    public String getAdUnitId() {
        return this.ou;
    }

    public AppEventListener getAppEventListener() {
        return this.os;
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.oM;
    }

    public String getMediationAdapterClassName() {
        try {
            if (this.oJ != null) {
                return this.oJ.getMediationAdapterClassName();
            }
        } catch (Throwable e) {
            gr.m1345d("Failed to get the mediation adapter class name.", e);
        }
        return null;
    }

    public boolean isLoaded() {
        boolean z = false;
        try {
            if (this.oJ != null) {
                z = this.oJ.isReady();
            }
        } catch (Throwable e) {
            gr.m1345d("Failed to check if ad is ready.", e);
        }
        return z;
    }

    public void setAdListener(AdListener adListener) {
        try {
            this.ob = adListener;
            if (this.oJ != null) {
                this.oJ.mo1679a(adListener != null ? new at(adListener) : null);
            }
        } catch (Throwable e) {
            gr.m1345d("Failed to set the AdListener.", e);
        }
    }

    public void setAdUnitId(String adUnitId) {
        if (this.ou != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.ou = adUnitId;
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.os = appEventListener;
            if (this.oJ != null) {
                this.oJ.mo1680a(appEventListener != null ? new ba(appEventListener) : null);
            }
        } catch (Throwable e) {
            gr.m1345d("Failed to set the AppEventListener.", e);
        }
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        if (this.oN != null) {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        try {
            this.oM = inAppPurchaseListener;
            if (this.oJ != null) {
                this.oJ.mo1682a(inAppPurchaseListener != null ? new es(inAppPurchaseListener) : null);
            }
        } catch (Throwable e) {
            gr.m1345d("Failed to set the InAppPurchaseListener.", e);
        }
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String publicKey) {
        try {
            this.oN = playStorePurchaseListener;
            if (this.oJ != null) {
                this.oJ.mo1683a(playStorePurchaseListener != null ? new ew(playStorePurchaseListener) : null, publicKey);
            }
        } catch (Throwable e) {
            gr.m1345d("Failed to set the play store purchase parameter.", e);
        }
    }

    public void show() {
        try {
            m1079w("show");
            this.oJ.showInterstitial();
        } catch (Throwable e) {
            gr.m1345d("Failed to show interstitial.", e);
        }
    }
}
