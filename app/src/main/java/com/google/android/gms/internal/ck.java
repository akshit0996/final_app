package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

@ey
public final class ck {

    /* renamed from: com.google.android.gms.internal.ck$b */
    public interface C0382b {
        /* renamed from: a */
        void mo1797a(Bundle bundle);
    }

    /* renamed from: com.google.android.gms.internal.ck$a */
    public static final class C1388a implements ConnectionCallbacks, OnConnectionFailedListener {
        private final Object mH;
        private final C0382b qe;
        private final cl qf;

        public C1388a(Context context, C0382b c0382b) {
            this(context, c0382b, false);
        }

        C1388a(Context context, C0382b c0382b, boolean z) {
            this.mH = new Object();
            this.qe = c0382b;
            this.qf = new cl(context, this, this, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            if (!z) {
                this.qf.connect();
            }
        }

        public void onConnected(Bundle connectionHint) {
            Bundle bN;
            Bundle by = bn.by();
            synchronized (this.mH) {
                try {
                    cm bM = this.qf.bM();
                    bN = bM != null ? bM.bN() : by;
                    if (this.qf.isConnected() || this.qf.isConnecting()) {
                        this.qf.disconnect();
                    }
                } catch (Throwable e) {
                    gr.m1345d("Error when get Gservice values", e);
                    if (this.qf.isConnected() || this.qf.isConnecting()) {
                        this.qf.disconnect();
                        bN = by;
                    }
                    bN = by;
                } catch (Throwable e2) {
                    gr.m1345d("Error when get Gservice values", e2);
                    if (this.qf.isConnected() || this.qf.isConnecting()) {
                        this.qf.disconnect();
                        bN = by;
                    }
                    bN = by;
                } catch (Throwable th) {
                    if (this.qf.isConnected() || this.qf.isConnecting()) {
                        this.qf.disconnect();
                    }
                }
            }
            this.qe.mo1797a(bN);
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.qe.mo1797a(bn.by());
        }

        public void onConnectionSuspended(int cause) {
            gr.m1337S("Disconnected from remote ad request service.");
        }
    }

    /* renamed from: a */
    public static void m1100a(Context context, C0382b c0382b) {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) != 0) {
            c0382b.mo1797a(bn.by());
        } else {
            C1388a c1388a = new C1388a(context, c0382b);
        }
    }
}
