package com.google.android.gms.plus;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.C0153b;
import com.google.android.gms.common.api.Api.C0154c;
import com.google.android.gms.common.api.BaseImplementation.C1301a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.oy;
import com.google.android.gms.internal.oz;
import com.google.android.gms.internal.pa;
import com.google.android.gms.internal.pb;
import com.google.android.gms.internal.pc;
import com.google.android.gms.plus.internal.C1204h;
import com.google.android.gms.plus.internal.C1470e;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import java.util.HashSet;
import java.util.Set;

public final class Plus {
    public static final Api<PlusOptions> API = new Api(DR, DQ, new Scope[0]);
    public static final Account AccountApi = new oy();
    public static final C0154c<C1470e> DQ = new C0154c();
    static final C0153b<C1470e, PlusOptions> DR = new C11841();
    public static final Moments MomentsApi = new pb();
    public static final People PeopleApi = new pc();
    public static final Scope SCOPE_PLUS_LOGIN = new Scope(Scopes.PLUS_LOGIN);
    public static final Scope SCOPE_PLUS_PROFILE = new Scope(Scopes.PLUS_ME);
    public static final C0592b anp = new pa();
    public static final C0591a anq = new oz();

    /* renamed from: com.google.android.gms.plus.Plus$1 */
    static class C11841 implements C0153b<C1470e, PlusOptions> {
        C11841() {
        }

        /* renamed from: a */
        public C1470e m3621a(Context context, Looper looper, jg jgVar, PlusOptions plusOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (plusOptions == null) {
                plusOptions = new PlusOptions();
            }
            return new C1470e(context, looper, connectionCallbacks, onConnectionFailedListener, new C1204h(jgVar.hm(), jgVar.hp(), (String[]) plusOptions.ans.toArray(new String[0]), new String[0], context.getPackageName(), context.getPackageName(), null, new PlusCommonExtras()));
        }

        public int getPriority() {
            return 2;
        }
    }

    public static final class PlusOptions implements Optional {
        final String anr;
        final Set<String> ans;

        public static final class Builder {
            String anr;
            final Set<String> ans = new HashSet();

            public Builder addActivityTypes(String... activityTypes) {
                jx.m1578b((Object) activityTypes, (Object) "activityTypes may not be null.");
                for (Object add : activityTypes) {
                    this.ans.add(add);
                }
                return this;
            }

            public PlusOptions build() {
                return new PlusOptions();
            }

            public Builder setServerClientId(String clientId) {
                this.anr = clientId;
                return this;
            }
        }

        private PlusOptions() {
            this.anr = null;
            this.ans = new HashSet();
        }

        private PlusOptions(Builder builder) {
            this.anr = builder.anr;
            this.ans = builder.ans;
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    /* renamed from: com.google.android.gms.plus.Plus$a */
    public static abstract class C1531a<R extends Result> extends C1301a<R, C1470e> {
        public C1531a(GoogleApiClient googleApiClient) {
            super(Plus.DQ, googleApiClient);
        }
    }

    private Plus() {
    }

    /* renamed from: a */
    public static C1470e m2027a(GoogleApiClient googleApiClient, C0154c<C1470e> c0154c) {
        boolean z = true;
        jx.m1580b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        jx.m1576a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        C1470e c1470e = (C1470e) googleApiClient.mo925a((C0154c) c0154c);
        if (c1470e == null) {
            z = false;
        }
        jx.m1576a(z, "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        return c1470e;
    }
}
