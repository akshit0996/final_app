package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
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
import com.google.android.gms.internal.mw;

public final class Address {
    public static final Api<AddressOptions> API = new Api(DR, DQ, new Scope[0]);
    static final C0154c<mw> DQ = new C0154c();
    private static final C0153b<mw, AddressOptions> DR = new C08961();

    /* renamed from: com.google.android.gms.identity.intents.Address$1 */
    static class C08961 implements C0153b<mw, AddressOptions> {
        C08961() {
        }

        /* renamed from: a */
        public mw m3025a(Context context, Looper looper, jg jgVar, AddressOptions addressOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            jx.m1580b(context instanceof Activity, (Object) "An Activity must be used for Address APIs");
            if (addressOptions == null) {
                addressOptions = new AddressOptions();
            }
            return new mw((Activity) context, looper, connectionCallbacks, onConnectionFailedListener, jgVar.getAccountName(), addressOptions.theme);
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    public static final class AddressOptions implements HasOptions {
        public final int theme;

        public AddressOptions() {
            this.theme = 0;
        }

        public AddressOptions(int theme) {
            this.theme = theme;
        }
    }

    /* renamed from: com.google.android.gms.identity.intents.Address$a */
    private static abstract class C1509a extends C1301a<Status, mw> {
        public C1509a(GoogleApiClient googleApiClient) {
            super(Address.DQ, googleApiClient);
        }

        /* renamed from: b */
        public Status m4919b(Status status) {
            return status;
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m4919b(status);
        }
    }

    public static void requestUserAddress(GoogleApiClient googleApiClient, final UserAddressRequest request, final int requestCode) {
        googleApiClient.mo926a(new C1509a(googleApiClient) {
            /* renamed from: a */
            protected void m5089a(mw mwVar) throws RemoteException {
                mwVar.m4496a(request, requestCode);
                m2447b(Status.Kw);
            }
        });
    }
}
