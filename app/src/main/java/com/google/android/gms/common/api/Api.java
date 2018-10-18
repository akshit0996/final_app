package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.jg;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Api<O extends ApiOptions> {
    private final C0153b<?, O> Jm;
    private final C0154c<?> Jn;
    private final ArrayList<Scope> Jo;

    public interface ApiOptions {

        public interface HasOptions extends ApiOptions {
        }

        public interface NotRequiredOptions extends ApiOptions {
        }

        public static final class NoOptions implements NotRequiredOptions {
            private NoOptions() {
            }
        }

        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    /* renamed from: com.google.android.gms.common.api.Api$a */
    public interface C0152a {
        void connect();

        void disconnect();

        boolean isConnected();
    }

    /* renamed from: com.google.android.gms.common.api.Api$b */
    public interface C0153b<T extends C0152a, O> {
        /* renamed from: a */
        T mo878a(Context context, Looper looper, jg jgVar, O o, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener);

        int getPriority();
    }

    /* renamed from: com.google.android.gms.common.api.Api$c */
    public static final class C0154c<C extends C0152a> {
    }

    public <C extends C0152a> Api(C0153b<C, O> clientBuilder, C0154c<C> clientKey, Scope... impliedScopes) {
        this.Jm = clientBuilder;
        this.Jn = clientKey;
        this.Jo = new ArrayList(Arrays.asList(impliedScopes));
    }

    public C0153b<?, O> gx() {
        return this.Jm;
    }

    public List<Scope> gy() {
        return this.Jo;
    }

    public C0154c<?> gz() {
        return this.Jn;
    }
}
