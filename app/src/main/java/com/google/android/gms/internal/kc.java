package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.C0152a;
import com.google.android.gms.common.api.Api.C0153b;
import com.google.android.gms.common.api.Api.C0154c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;

public final class kc {
    public static final Api<NoOptions> API = new Api(DR, DQ, new Scope[0]);
    public static final C0154c<kg> DQ = new C0154c();
    private static final C0153b<kg, NoOptions> DR = new C10111();
    public static final kd Nu = new ke();

    /* renamed from: com.google.android.gms.internal.kc$1 */
    static class C10111 implements C0153b<kg, NoOptions> {
        C10111() {
        }

        /* renamed from: a */
        public /* synthetic */ C0152a mo878a(Context context, Looper looper, jg jgVar, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m3368c(context, looper, jgVar, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        /* renamed from: c */
        public kg m3368c(Context context, Looper looper, jg jgVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new kg(context, looper, connectionCallbacks, onConnectionFailedListener, new String[0]);
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }
}
