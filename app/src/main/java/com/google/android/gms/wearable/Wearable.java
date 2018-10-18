package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.C0153b;
import com.google.android.gms.common.api.Api.C0154c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.jg;
import com.google.android.gms.wearable.internal.C1272e;
import com.google.android.gms.wearable.internal.C1273f;
import com.google.android.gms.wearable.internal.ah;
import com.google.android.gms.wearable.internal.ak;
import com.google.android.gms.wearable.internal.ay;
import com.google.android.gms.wearable.internal.ba;

public class Wearable {
    public static final Api<WearableOptions> API = new Api(DR, DQ, new Scope[0]);
    public static final C0154c<ba> DQ = new C0154c();
    private static final C0153b<ba, WearableOptions> DR = new C12601();
    public static final DataApi DataApi = new C1273f();
    public static final MessageApi MessageApi = new ah();
    public static final NodeApi NodeApi = new ak();
    public static final C0698b axl = new C1272e();
    public static final C0701f axm = new ay();

    /* renamed from: com.google.android.gms.wearable.Wearable$1 */
    static class C12601 implements C0153b<ba, WearableOptions> {
        C12601() {
        }

        /* renamed from: a */
        public ba m3852a(Context context, Looper looper, jg jgVar, WearableOptions wearableOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (wearableOptions == null) {
                WearableOptions wearableOptions2 = new WearableOptions(new Builder());
            }
            return new ba(context, looper, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    public static final class WearableOptions implements Optional {

        public static class Builder {
            public WearableOptions build() {
                return new WearableOptions();
            }
        }

        private WearableOptions(Builder builder) {
        }
    }

    private Wearable() {
    }
}
