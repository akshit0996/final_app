package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.jx;

/* renamed from: com.google.android.gms.common.api.g */
public class C0808g extends Fragment implements OnCancelListener, LoaderCallbacks<ConnectionResult> {
    private boolean KC;
    private int KD = -1;
    private ConnectionResult KE;
    private final Handler KF = new Handler(Looper.getMainLooper());
    private final SparseArray<C0166b> KG = new SparseArray();

    /* renamed from: com.google.android.gms.common.api.g$b */
    private static class C0166b {
        public final GoogleApiClient KH;
        public final OnConnectionFailedListener KK;

        private C0166b(GoogleApiClient googleApiClient, OnConnectionFailedListener onConnectionFailedListener) {
            this.KH = googleApiClient;
            this.KK = onConnectionFailedListener;
        }
    }

    /* renamed from: com.google.android.gms.common.api.g$c */
    private class C0167c implements Runnable {
        private final int KL;
        private final ConnectionResult KM;
        final /* synthetic */ C0808g KN;

        public C0167c(C0808g c0808g, int i, ConnectionResult connectionResult) {
            this.KN = c0808g;
            this.KL = i;
            this.KM = connectionResult;
        }

        public void run() {
            if (this.KM.hasResolution()) {
                try {
                    this.KM.startResolutionForResult(this.KN.getActivity(), ((this.KN.getActivity().getSupportFragmentManager().getFragments().indexOf(this.KN) + 1) << 16) + 1);
                } catch (SendIntentException e) {
                    this.KN.gR();
                }
            } else if (GooglePlayServicesUtil.isUserRecoverableError(this.KM.getErrorCode())) {
                GooglePlayServicesUtil.showErrorDialogFragment(this.KM.getErrorCode(), this.KN.getActivity(), this.KN, 2, this.KN);
            } else {
                this.KN.m2484b(this.KL, this.KM);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.g$a */
    static class C1305a extends Loader<ConnectionResult> implements ConnectionCallbacks, OnConnectionFailedListener {
        public final GoogleApiClient KH;
        private boolean KI;
        private ConnectionResult KJ;

        public C1305a(Context context, GoogleApiClient googleApiClient) {
            super(context);
            this.KH = googleApiClient;
        }

        /* renamed from: a */
        private void m3935a(ConnectionResult connectionResult) {
            this.KJ = connectionResult;
            if (isStarted() && !isAbandoned()) {
                deliverResult(connectionResult);
            }
        }

        public void gS() {
            if (this.KI) {
                this.KI = false;
                if (isStarted() && !isAbandoned()) {
                    this.KH.connect();
                }
            }
        }

        public void onConnected(Bundle connectionHint) {
            this.KI = false;
            m3935a(ConnectionResult.Iu);
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.KI = true;
            m3935a(result);
        }

        public void onConnectionSuspended(int cause) {
        }

        protected void onReset() {
            this.KJ = null;
            this.KI = false;
            this.KH.unregisterConnectionCallbacks(this);
            this.KH.unregisterConnectionFailedListener(this);
            this.KH.disconnect();
        }

        protected void onStartLoading() {
            super.onStartLoading();
            this.KH.registerConnectionCallbacks(this);
            this.KH.registerConnectionFailedListener(this);
            if (this.KJ != null) {
                deliverResult(this.KJ);
            }
            if (!this.KH.isConnected() && !this.KH.isConnecting() && !this.KI) {
                this.KH.connect();
            }
        }

        protected void onStopLoading() {
            this.KH.disconnect();
        }
    }

    /* renamed from: a */
    public static C0808g m2480a(FragmentActivity fragmentActivity) {
        jx.aU("Must be called from main thread of process");
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        try {
            C0808g c0808g = (C0808g) supportFragmentManager.findFragmentByTag("GmsSupportLifecycleFragment");
            if (c0808g != null && !c0808g.isRemoving()) {
                return c0808g;
            }
            Fragment c0808g2 = new C0808g();
            supportFragmentManager.beginTransaction().add(c0808g2, "GmsSupportLifecycleFragment").commit();
            supportFragmentManager.executePendingTransactions();
            return c0808g2;
        } catch (Throwable e) {
            throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFragment is not a SupportLifecycleFragment", e);
        }
    }

    /* renamed from: a */
    private void m2481a(int i, ConnectionResult connectionResult) {
        if (!this.KC) {
            this.KC = true;
            this.KD = i;
            this.KE = connectionResult;
            this.KF.post(new C0167c(this, i, connectionResult));
        }
    }

    private void aq(int i) {
        if (i == this.KD) {
            gR();
        }
    }

    /* renamed from: b */
    private void m2484b(int i, ConnectionResult connectionResult) {
        Log.w("GmsSupportLifecycleFragment", "Unresolved error while connecting client. Stopping auto-manage.");
        C0166b c0166b = (C0166b) this.KG.get(i);
        if (c0166b != null) {
            ao(i);
            OnConnectionFailedListener onConnectionFailedListener = c0166b.KK;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
        gR();
    }

    private void gR() {
        int i = 0;
        this.KC = false;
        this.KD = -1;
        this.KE = null;
        LoaderManager loaderManager = getLoaderManager();
        while (i < this.KG.size()) {
            int keyAt = this.KG.keyAt(i);
            C1305a ap = ap(keyAt);
            if (ap != null) {
                ap.gS();
            }
            loaderManager.initLoader(keyAt, null, this);
            i++;
        }
    }

    /* renamed from: a */
    public void m2485a(int i, GoogleApiClient googleApiClient, OnConnectionFailedListener onConnectionFailedListener) {
        jx.m1578b((Object) googleApiClient, (Object) "GoogleApiClient instance cannot be null");
        jx.m1576a(this.KG.indexOfKey(i) < 0, "Already managing a GoogleApiClient with id " + i);
        this.KG.put(i, new C0166b(googleApiClient, onConnectionFailedListener));
        if (getActivity() != null) {
            getLoaderManager().initLoader(i, null, this);
        }
    }

    /* renamed from: a */
    public void m2486a(Loader<ConnectionResult> loader, ConnectionResult connectionResult) {
        if (connectionResult.isSuccess()) {
            aq(loader.getId());
        } else {
            m2481a(loader.getId(), connectionResult);
        }
    }

    public GoogleApiClient an(int i) {
        if (getActivity() != null) {
            C1305a ap = ap(i);
            if (ap != null) {
                return ap.KH;
            }
        }
        return null;
    }

    public void ao(int i) {
        getLoaderManager().destroyLoader(i);
        this.KG.remove(i);
    }

    C1305a ap(int i) {
        try {
            return (C1305a) getLoaderManager().getLoader(i);
        } catch (Throwable e) {
            throw new IllegalStateException("Unknown loader in SupportLifecycleFragment", e);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r4, int r5, android.content.Intent r6) {
        /*
        r3 = this;
        r0 = 1;
        r1 = 0;
        switch(r4) {
            case 1: goto L_0x0017;
            case 2: goto L_0x000c;
            default: goto L_0x0005;
        };
    L_0x0005:
        r0 = r1;
    L_0x0006:
        if (r0 == 0) goto L_0x001b;
    L_0x0008:
        r3.gR();
    L_0x000b:
        return;
    L_0x000c:
        r2 = r3.getActivity();
        r2 = com.google.android.gms.common.GooglePlayServicesUtil.isGooglePlayServicesAvailable(r2);
        if (r2 != 0) goto L_0x0005;
    L_0x0016:
        goto L_0x0006;
    L_0x0017:
        r2 = -1;
        if (r5 != r2) goto L_0x0005;
    L_0x001a:
        goto L_0x0006;
    L_0x001b:
        r0 = r3.KD;
        r1 = r3.KE;
        r3.m2484b(r0, r1);
        goto L_0x000b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.g.onActivityResult(int, int, android.content.Intent):void");
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        int i = 0;
        while (i < this.KG.size()) {
            int keyAt = this.KG.keyAt(i);
            C1305a ap = ap(keyAt);
            if (ap == null || ((C0166b) this.KG.valueAt(i)).KH == ap.KH) {
                getLoaderManager().initLoader(keyAt, null, this);
            } else {
                getLoaderManager().restartLoader(keyAt, null, this);
            }
            i++;
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        m2484b(this.KD, this.KE);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            this.KC = savedInstanceState.getBoolean("resolving_error", false);
            this.KD = savedInstanceState.getInt("failed_client_id", -1);
            if (this.KD >= 0) {
                this.KE = new ConnectionResult(savedInstanceState.getInt("failed_status"), (PendingIntent) savedInstanceState.getParcelable("failed_resolution"));
            }
        }
    }

    public Loader<ConnectionResult> onCreateLoader(int id, Bundle args) {
        return new C1305a(getActivity(), ((C0166b) this.KG.get(id)).KH);
    }

    public /* synthetic */ void onLoadFinished(Loader x0, Object x1) {
        m2486a(x0, (ConnectionResult) x1);
    }

    public void onLoaderReset(Loader<ConnectionResult> loader) {
        if (loader.getId() == this.KD) {
            gR();
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("resolving_error", this.KC);
        if (this.KD >= 0) {
            outState.putInt("failed_client_id", this.KD);
            outState.putInt("failed_status", this.KE.getErrorCode());
            outState.putParcelable("failed_resolution", this.KE.getResolution());
        }
    }

    public void onStart() {
        super.onStart();
        if (!this.KC) {
            for (int i = 0; i < this.KG.size(); i++) {
                getLoaderManager().initLoader(this.KG.keyAt(i), null, this);
            }
        }
    }
}
