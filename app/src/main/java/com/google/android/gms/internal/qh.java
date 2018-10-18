package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.jl.C1399e;
import com.google.android.gms.internal.qc.C1068a;
import com.google.android.gms.internal.qf.C1074a;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.WalletConstants;

public class qh extends jl<qc> {
    private final String DZ;
    private final int avV;
    private final int mTheme;
    private final Activity nB;

    /* renamed from: com.google.android.gms.internal.qh$a */
    private static class C1432a extends C1074a {
        private C1432a() {
        }

        /* renamed from: a */
        public void mo2103a(int i, FullWallet fullWallet, Bundle bundle) {
        }

        /* renamed from: a */
        public void mo2104a(int i, MaskedWallet maskedWallet, Bundle bundle) {
        }

        /* renamed from: a */
        public void mo2105a(int i, boolean z, Bundle bundle) {
        }

        /* renamed from: a */
        public void mo2106a(Status status, py pyVar, Bundle bundle) {
        }

        /* renamed from: i */
        public void mo2107i(int i, Bundle bundle) {
        }
    }

    /* renamed from: com.google.android.gms.internal.qh$b */
    final class C1528b extends C1432a {
        private final int My;
        final /* synthetic */ qh awG;

        public C1528b(qh qhVar, int i) {
            this.awG = qhVar;
            super();
            this.My = i;
        }

        /* renamed from: a */
        public void mo2103a(int i, FullWallet fullWallet, Bundle bundle) {
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(this.awG.nB, this.My);
                    return;
                } catch (Throwable e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                    return;
                }
            }
            int i2;
            Intent intent = new Intent();
            if (connectionResult.isSuccess()) {
                i2 = -1;
                intent.putExtra(WalletConstants.EXTRA_FULL_WALLET, fullWallet);
            } else {
                i2 = i == 408 ? 0 : 1;
                intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, i);
            }
            PendingIntent createPendingResult = this.awG.nB.createPendingResult(this.My, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onFullWalletLoaded");
                return;
            }
            try {
                createPendingResult.send(i2);
            } catch (Throwable e2) {
                Log.w("WalletClientImpl", "Exception setting pending result", e2);
            }
        }

        /* renamed from: a */
        public void mo2104a(int i, MaskedWallet maskedWallet, Bundle bundle) {
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(this.awG.nB, this.My);
                    return;
                } catch (Throwable e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                    return;
                }
            }
            int i2;
            Intent intent = new Intent();
            if (connectionResult.isSuccess()) {
                i2 = -1;
                intent.putExtra(WalletConstants.EXTRA_MASKED_WALLET, maskedWallet);
            } else {
                i2 = i == 408 ? 0 : 1;
                intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, i);
            }
            PendingIntent createPendingResult = this.awG.nB.createPendingResult(this.My, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onMaskedWalletLoaded");
                return;
            }
            try {
                createPendingResult.send(i2);
            } catch (Throwable e2) {
                Log.w("WalletClientImpl", "Exception setting pending result", e2);
            }
        }

        /* renamed from: a */
        public void mo2105a(int i, boolean z, Bundle bundle) {
            Intent intent = new Intent();
            intent.putExtra(WalletConstants.EXTRA_IS_USER_PREAUTHORIZED, z);
            PendingIntent createPendingResult = this.awG.nB.createPendingResult(this.My, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onPreAuthorizationDetermined");
                return;
            }
            try {
                createPendingResult.send(-1);
            } catch (Throwable e) {
                Log.w("WalletClientImpl", "Exception setting pending result", e);
            }
        }

        /* renamed from: i */
        public void mo2107i(int i, Bundle bundle) {
            jx.m1578b((Object) bundle, (Object) "Bundle should not be null");
            ConnectionResult connectionResult = new ConnectionResult(i, (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT"));
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(this.awG.nB, this.My);
                    return;
                } catch (Throwable e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                    return;
                }
            }
            Log.e("WalletClientImpl", "Create Wallet Objects confirmation UI will not be shown connection result: " + connectionResult);
            Intent intent = new Intent();
            intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, WalletConstants.ERROR_CODE_UNKNOWN);
            PendingIntent createPendingResult = this.awG.nB.createPendingResult(this.My, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onWalletObjectsCreated");
                return;
            }
            try {
                createPendingResult.send(1);
            } catch (Throwable e2) {
                Log.w("WalletClientImpl", "Exception setting pending result", e2);
            }
        }
    }

    public qh(Activity activity, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, int i, String str, int i2) {
        super(activity, looper, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.nB = activity;
        this.avV = i;
        this.DZ = str;
        this.mTheme = i2;
    }

    /* renamed from: a */
    public static Bundle m4550a(int i, String str, String str2, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("com.google.android.gms.wallet.EXTRA_ENVIRONMENT", i);
        bundle.putString("androidPackageName", str);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putParcelable("com.google.android.gms.wallet.EXTRA_BUYER_ACCOUNT", new Account(str2, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE));
        }
        bundle.putInt("com.google.android.gms.wallet.EXTRA_THEME", i2);
        return bundle;
    }

    private Bundle rf() {
        return m4550a(this.avV, this.nB.getPackageName(), this.DZ, this.mTheme);
    }

    /* renamed from: a */
    protected void mo2969a(jt jtVar, C1399e c1399e) throws RemoteException {
        jtVar.mo1893k(c1399e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName());
    }

    /* renamed from: a */
    public void m4553a(FullWalletRequest fullWalletRequest, int i) {
        qf c1528b = new C1528b(this, i);
        try {
            ((qc) hw()).mo2093a(fullWalletRequest, rf(), c1528b);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException getting full wallet", e);
            c1528b.mo2103a(8, null, Bundle.EMPTY);
        }
    }

    /* renamed from: a */
    public void m4554a(MaskedWalletRequest maskedWalletRequest, int i) {
        Bundle rf = rf();
        qf c1528b = new C1528b(this, i);
        try {
            ((qc) hw()).mo2095a(maskedWalletRequest, rf, c1528b);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException getting masked wallet", e);
            c1528b.mo2104a(8, null, Bundle.EMPTY);
        }
    }

    /* renamed from: a */
    public void m4555a(NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
        try {
            ((qc) hw()).mo2096a(notifyTransactionStatusRequest, rf());
        } catch (RemoteException e) {
        }
    }

    protected String bK() {
        return "com.google.android.gms.wallet.service.BIND";
    }

    protected String bL() {
        return "com.google.android.gms.wallet.internal.IOwService";
    }

    protected qc bV(IBinder iBinder) {
        return C1068a.bR(iBinder);
    }

    /* renamed from: d */
    public void m4556d(String str, String str2, int i) {
        Bundle rf = rf();
        Object c1528b = new C1528b(this, i);
        try {
            ((qc) hw()).mo2098a(str, str2, rf, c1528b);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException changing masked wallet", e);
            c1528b.mo2104a(8, null, Bundle.EMPTY);
        }
    }

    public void gk(int i) {
        Bundle rf = rf();
        qf c1528b = new C1528b(this, i);
        try {
            ((qc) hw()).mo2091a(rf, c1528b);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException during checkForPreAuthorization", e);
            c1528b.mo2105a(8, false, Bundle.EMPTY);
        }
    }

    /* renamed from: l */
    protected /* synthetic */ IInterface mo2972l(IBinder iBinder) {
        return bV(iBinder);
    }
}
