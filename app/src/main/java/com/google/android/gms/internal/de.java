package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.dynamic.C0272d;
import com.google.android.gms.dynamic.C1332e;
import com.google.android.gms.internal.cz.C0931a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

@ey
public final class de<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends C0931a {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> qX;
    private final NETWORK_EXTRAS qY;

    public de(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.qX = mediationAdapter;
        this.qY = network_extras;
    }

    /* renamed from: b */
    private SERVER_PARAMETERS m4352b(String str, int i, String str2) throws RemoteException {
        Map hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    hashMap.put(str3, jSONObject.getString(str3));
                }
            } catch (Throwable th) {
                gr.m1345d("Could not get MediationServerParameters.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class serverParametersType = this.qX.getServerParametersType();
        if (serverParametersType == null) {
            return null;
        }
        MediationServerParameters mediationServerParameters = (MediationServerParameters) serverParametersType.newInstance();
        mediationServerParameters.load(hashMap);
        return mediationServerParameters;
    }

    /* renamed from: a */
    public void mo1709a(C0272d c0272d, av avVar, String str, da daVar) throws RemoteException {
        mo1710a(c0272d, avVar, str, null, daVar);
    }

    /* renamed from: a */
    public void mo1710a(C0272d c0272d, av avVar, String str, String str2, da daVar) throws RemoteException {
        if (this.qX instanceof MediationInterstitialAdapter) {
            gr.m1337S("Requesting interstitial ad from adapter.");
            try {
                ((MediationInterstitialAdapter) this.qX).requestInterstitialAd(new df(daVar), (Activity) C1332e.m4012f(c0272d), m4352b(str, avVar.oh, str2), dg.m1115d(avVar), this.qY);
            } catch (Throwable th) {
                gr.m1345d("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            gr.m1341W("MediationAdapter is not a MediationInterstitialAdapter: " + this.qX.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    /* renamed from: a */
    public void mo1711a(C0272d c0272d, ay ayVar, av avVar, String str, da daVar) throws RemoteException {
        mo1712a(c0272d, ayVar, avVar, str, null, daVar);
    }

    /* renamed from: a */
    public void mo1712a(C0272d c0272d, ay ayVar, av avVar, String str, String str2, da daVar) throws RemoteException {
        if (this.qX instanceof MediationBannerAdapter) {
            gr.m1337S("Requesting banner ad from adapter.");
            try {
                ((MediationBannerAdapter) this.qX).requestBannerAd(new df(daVar), (Activity) C1332e.m4012f(c0272d), m4352b(str, avVar.oh, str2), dg.m1114b(ayVar), dg.m1115d(avVar), this.qY);
            } catch (Throwable th) {
                gr.m1345d("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            gr.m1341W("MediationAdapter is not a MediationBannerAdapter: " + this.qX.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void destroy() throws RemoteException {
        try {
            this.qX.destroy();
        } catch (Throwable th) {
            gr.m1345d("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public C0272d getView() throws RemoteException {
        if (this.qX instanceof MediationBannerAdapter) {
            try {
                return C1332e.m4013k(((MediationBannerAdapter) this.qX).getBannerView());
            } catch (Throwable th) {
                gr.m1345d("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            gr.m1341W("MediationAdapter is not a MediationBannerAdapter: " + this.qX.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void pause() throws RemoteException {
        throw new RemoteException();
    }

    public void resume() throws RemoteException {
        throw new RemoteException();
    }

    public void showInterstitial() throws RemoteException {
        if (this.qX instanceof MediationInterstitialAdapter) {
            gr.m1337S("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.qX).showInterstitial();
            } catch (Throwable th) {
                gr.m1345d("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            gr.m1341W("MediationAdapter is not a MediationInterstitialAdapter: " + this.qX.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }
}
