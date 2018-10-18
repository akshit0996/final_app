package com.google.android.gms.fitness;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.C0152a;
import com.google.android.gms.common.api.Api.C0153b;
import com.google.android.gms.common.api.Api.C0154c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.lu;
import com.google.android.gms.internal.lv;
import com.google.android.gms.internal.mf;
import com.google.android.gms.internal.mh;
import com.google.android.gms.internal.mi;
import com.google.android.gms.internal.mj;
import com.google.android.gms.internal.mk;
import com.google.android.gms.internal.ml;
import com.google.android.gms.internal.mm;
import com.google.android.gms.internal.mn;
import com.google.android.gms.internal.mo;
import java.util.concurrent.TimeUnit;

public class Fitness {
    public static final String ACTION_TRACK = "vnd.google.fitness.TRACK";
    public static final String ACTION_VIEW = "vnd.google.fitness.VIEW";
    public static final String ACTION_VIEW_GOAL = "vnd.google.fitness.VIEW_GOAL";
    public static final Api<NoOptions> API = new Api(DR, DQ, new Scope[0]);
    public static final BleApi BleApi = jj();
    public static final ConfigApi ConfigApi = new mi();
    public static final C0154c<lu> DQ = new C0154c();
    private static final C0153b<lu, NoOptions> DR = new C08721();
    public static final String EXTRA_END_TIME = "vnd.google.fitness.end_time";
    public static final String EXTRA_START_TIME = "vnd.google.fitness.start_time";
    public static final HistoryApi HistoryApi = new mj();
    public static final RecordingApi RecordingApi = new ml();
    public static final Scope SCOPE_ACTIVITY_READ = new Scope(Scopes.FITNESS_ACTIVITY_READ);
    public static final Scope SCOPE_ACTIVITY_READ_WRITE = new Scope(Scopes.FITNESS_ACTIVITY_READ_WRITE);
    public static final Scope SCOPE_BODY_READ = new Scope(Scopes.FITNESS_BODY_READ);
    public static final Scope SCOPE_BODY_READ_WRITE = new Scope(Scopes.FITNESS_BODY_READ_WRITE);
    public static final Scope SCOPE_LOCATION_READ = new Scope(Scopes.FITNESS_LOCATION_READ);
    public static final Scope SCOPE_LOCATION_READ_WRITE = new Scope(Scopes.FITNESS_LOCATION_READ_WRITE);
    public static final SensorsApi SensorsApi = new mm();
    public static final SessionsApi SessionsApi = new mn();
    public static final mf TK = new mk();

    /* renamed from: com.google.android.gms.fitness.Fitness$1 */
    static class C08721 implements C0153b<lu, NoOptions> {
        C08721() {
        }

        /* renamed from: a */
        public /* synthetic */ C0152a mo878a(Context context, Looper looper, jg jgVar, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m2667d(context, looper, jgVar, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        /* renamed from: d */
        public lu m2667d(Context context, Looper looper, jg jgVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new lv(context, looper, connectionCallbacks, onConnectionFailedListener, jgVar.hm(), C0276a.m517e(jgVar.ho()));
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    private Fitness() {
    }

    public static long getEndTime(Intent intent, TimeUnit timeUnit) {
        long longExtra = intent.getLongExtra(EXTRA_END_TIME, -1);
        return longExtra == -1 ? -1 : timeUnit.convert(longExtra, TimeUnit.MILLISECONDS);
    }

    public static long getStartTime(Intent intent, TimeUnit timeUnit) {
        long longExtra = intent.getLongExtra(EXTRA_START_TIME, -1);
        return longExtra == -1 ? -1 : timeUnit.convert(longExtra, TimeUnit.MILLISECONDS);
    }

    private static BleApi jj() {
        return VERSION.SDK_INT >= 18 ? new mh() : new mo();
    }
}
