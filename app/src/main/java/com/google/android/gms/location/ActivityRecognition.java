package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.C0152a;
import com.google.android.gms.common.api.Api.C0153b;
import com.google.android.gms.common.api.Api.C0154c;
import com.google.android.gms.common.api.BaseImplementation.C1301a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.nb;
import com.google.android.gms.internal.nk;

public class ActivityRecognition {
    public static final Api<NoOptions> API = new Api(DR, DQ, new Scope[0]);
    public static ActivityRecognitionApi ActivityRecognitionApi = new nb();
    public static final String CLIENT_NAME = "activity_recognition";
    private static final C0154c<nk> DQ = new C0154c();
    private static final C0153b<nk, NoOptions> DR = new C10821();

    /* renamed from: com.google.android.gms.location.ActivityRecognition$1 */
    static class C10821 implements C0153b<nk, NoOptions> {
        C10821() {
        }

        /* renamed from: a */
        public /* synthetic */ C0152a mo878a(Context context, Looper looper, jg jgVar, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m3557e(context, looper, jgVar, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        /* renamed from: e */
        public nk m3557e(Context context, Looper looper, jg jgVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new nk(context, looper, context.getPackageName(), connectionCallbacks, onConnectionFailedListener, ActivityRecognition.CLIENT_NAME);
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    /* renamed from: com.google.android.gms.location.ActivityRecognition$a */
    public static abstract class C1529a<R extends Result> extends C1301a<R, nk> {
        public C1529a(GoogleApiClient googleApiClient) {
            super(ActivityRecognition.DQ, googleApiClient);
        }
    }

    private ActivityRecognition() {
    }
}
