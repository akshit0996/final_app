package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.C0153b;
import com.google.android.gms.common.api.Api.C0154c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;

public final class hc {
    public static final C0154c<hx> CG = new C0154c();
    private static final C0153b<hx, NoOptions> CH = new C09761();
    public static final Api<NoOptions> CI = new Api(CH, CG, new Scope[0]);
    public static final ht CJ = new hz();

    /* renamed from: com.google.android.gms.internal.hc$1 */
    static class C09761 implements C0153b<hx, NoOptions> {
        C09761() {
        }

        /* renamed from: a */
        public hx m3228a(Context context, Looper looper, jg jgVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new hx(context, looper, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }
}
