package com.google.android.gms.wallet;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.C0153b;
import com.google.android.gms.common.api.Api.C0154c;
import com.google.android.gms.common.api.BaseImplementation.C1301a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.pv;
import com.google.android.gms.internal.qg;
import com.google.android.gms.internal.qh;
import com.google.android.gms.internal.qj;
import com.google.android.gms.internal.qk;
import com.google.android.gms.wallet.wobs.C0691r;
import java.util.Locale;

public final class Wallet {
    public static final Api<WalletOptions> API = new Api(DR, DQ, new Scope[0]);
    private static final C0154c<qh> DQ = new C0154c();
    private static final C0153b<qh, WalletOptions> DR = new C12461();
    public static final Payments Payments = new qg();
    public static final C0691r avT = new qk();
    public static final pv avU = new qj();

    /* renamed from: com.google.android.gms.wallet.Wallet$1 */
    static class C12461 implements C0153b<qh, WalletOptions> {
        C12461() {
        }

        /* renamed from: a */
        public qh m3801a(Context context, Looper looper, jg jgVar, WalletOptions walletOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            jx.m1580b(context instanceof Activity, (Object) "An Activity must be used for Wallet APIs");
            Activity activity = (Activity) context;
            if (walletOptions == null) {
                walletOptions = new WalletOptions();
            }
            return new qh(activity, looper, connectionCallbacks, onConnectionFailedListener, walletOptions.environment, jgVar.getAccountName(), walletOptions.theme);
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    public static final class WalletOptions implements HasOptions {
        public final int environment;
        public final int theme;

        public static final class Builder {
            private int avV = 0;
            private int mTheme = 0;

            public WalletOptions build() {
                return new WalletOptions();
            }

            public Builder setEnvironment(int environment) {
                if (environment == 0 || environment == 2 || environment == 1) {
                    this.avV = environment;
                    return this;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid environment value %d", new Object[]{Integer.valueOf(environment)}));
            }

            public Builder setTheme(int theme) {
                if (theme == 0 || theme == 1) {
                    this.mTheme = theme;
                    return this;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid theme value %d", new Object[]{Integer.valueOf(theme)}));
            }
        }

        private WalletOptions() {
            this(new Builder());
        }

        private WalletOptions(Builder builder) {
            this.environment = builder.avV;
            this.theme = builder.mTheme;
        }
    }

    /* renamed from: com.google.android.gms.wallet.Wallet$a */
    public static abstract class C1537a<R extends Result> extends C1301a<R, qh> {
        public C1537a(GoogleApiClient googleApiClient) {
            super(Wallet.DQ, googleApiClient);
        }
    }

    /* renamed from: com.google.android.gms.wallet.Wallet$b */
    public static abstract class C1589b extends C1537a<Status> {
        public C1589b(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: b */
        protected Status m5151b(Status status) {
            return status;
        }

        /* renamed from: c */
        protected /* synthetic */ Result mo2958c(Status status) {
            return m5151b(status);
        }
    }

    private Wallet() {
    }

    @Deprecated
    public static void changeMaskedWallet(GoogleApiClient googleApiClient, String googleTransactionId, String merchantTransactionId, int requestCode) {
        Payments.changeMaskedWallet(googleApiClient, googleTransactionId, merchantTransactionId, requestCode);
    }

    @Deprecated
    public static void checkForPreAuthorization(GoogleApiClient googleApiClient, int requestCode) {
        Payments.checkForPreAuthorization(googleApiClient, requestCode);
    }

    @Deprecated
    public static void loadFullWallet(GoogleApiClient googleApiClient, FullWalletRequest request, int requestCode) {
        Payments.loadFullWallet(googleApiClient, request, requestCode);
    }

    @Deprecated
    public static void loadMaskedWallet(GoogleApiClient googleApiClient, MaskedWalletRequest request, int requestCode) {
        Payments.loadMaskedWallet(googleApiClient, request, requestCode);
    }

    @Deprecated
    public static void notifyTransactionStatus(GoogleApiClient googleApiClient, NotifyTransactionStatusRequest request) {
        Payments.notifyTransactionStatus(googleApiClient, request);
    }
}
