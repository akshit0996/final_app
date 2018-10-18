package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NotRequiredOptions;
import com.google.android.gms.common.api.Api.C0152a;
import com.google.android.gms.common.api.Api.C0154c;
import com.google.android.gms.common.api.BaseImplementation.C1301a;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jx;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface GoogleApiClient {

    public static final class Builder {
        private String DZ;
        private Looper JF;
        private final Set<String> JH;
        private int JI;
        private View JJ;
        private String JK;
        private final Map<Api<?>, ApiOptions> JL;
        private FragmentActivity JM;
        private int JN;
        private OnConnectionFailedListener JO;
        private final Set<ConnectionCallbacks> JP;
        private final Set<OnConnectionFailedListener> JQ;
        private final Context mContext;

        public Builder(Context context) {
            this.JH = new HashSet();
            this.JL = new HashMap();
            this.JN = -1;
            this.JP = new HashSet();
            this.JQ = new HashSet();
            this.mContext = context;
            this.JF = context.getMainLooper();
            this.JK = context.getPackageName();
        }

        public Builder(Context context, ConnectionCallbacks connectedListener, OnConnectionFailedListener connectionFailedListener) {
            this(context);
            jx.m1578b((Object) connectedListener, (Object) "Must provide a connected listener");
            this.JP.add(connectedListener);
            jx.m1578b((Object) connectionFailedListener, (Object) "Must provide a connection failed listener");
            this.JQ.add(connectionFailedListener);
        }

        private GoogleApiClient gI() {
            C0808g a = C0808g.m2480a(this.JM);
            GoogleApiClient an = a.an(this.JN);
            if (an == null) {
                an = new C0807c(this.mContext.getApplicationContext(), this.JF, gH(), this.JL, this.JP, this.JQ, this.JN);
            }
            a.m2485a(this.JN, an, this.JO);
            return an;
        }

        public Builder addApi(Api<? extends NotRequiredOptions> api) {
            this.JL.put(api, null);
            List gy = api.gy();
            int size = gy.size();
            for (int i = 0; i < size; i++) {
                this.JH.add(((Scope) gy.get(i)).gO());
            }
            return this;
        }

        public <O extends HasOptions> Builder addApi(Api<O> api, O options) {
            jx.m1578b((Object) options, (Object) "Null options are not permitted for this Api");
            this.JL.put(api, options);
            List gy = api.gy();
            int size = gy.size();
            for (int i = 0; i < size; i++) {
                this.JH.add(((Scope) gy.get(i)).gO());
            }
            return this;
        }

        public Builder addConnectionCallbacks(ConnectionCallbacks listener) {
            this.JP.add(listener);
            return this;
        }

        public Builder addOnConnectionFailedListener(OnConnectionFailedListener listener) {
            this.JQ.add(listener);
            return this;
        }

        public Builder addScope(Scope scope) {
            this.JH.add(scope.gO());
            return this;
        }

        public GoogleApiClient build() {
            jx.m1580b(!this.JL.isEmpty(), (Object) "must call addApi() to add at least one API");
            return this.JN >= 0 ? gI() : new C0807c(this.mContext, this.JF, gH(), this.JL, this.JP, this.JQ, -1);
        }

        public Builder enableAutoManage(FragmentActivity fragmentActivity, int clientId, OnConnectionFailedListener unresolvedConnectionFailedListener) {
            jx.m1580b(clientId >= 0, (Object) "clientId must be non-negative");
            this.JN = clientId;
            this.JM = (FragmentActivity) jx.m1578b((Object) fragmentActivity, (Object) "Null activity is not permitted.");
            this.JO = unresolvedConnectionFailedListener;
            return this;
        }

        public jg gH() {
            return new jg(this.DZ, this.JH, this.JI, this.JJ, this.JK);
        }

        public Builder setAccountName(String accountName) {
            this.DZ = accountName;
            return this;
        }

        public Builder setGravityForPopups(int gravityForPopups) {
            this.JI = gravityForPopups;
            return this;
        }

        public Builder setHandler(Handler handler) {
            jx.m1578b((Object) handler, (Object) "Handler must not be null");
            this.JF = handler.getLooper();
            return this;
        }

        public Builder setViewForPopups(View viewForPopups) {
            this.JJ = viewForPopups;
            return this;
        }

        public Builder useDefaultAccount() {
            return setAccountName("<<default account>>");
        }
    }

    public interface ConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface OnConnectionFailedListener extends com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    /* renamed from: a */
    <C extends C0152a> C mo925a(C0154c<C> c0154c);

    /* renamed from: a */
    <A extends C0152a, R extends Result, T extends C1301a<R, A>> T mo926a(T t);

    /* renamed from: a */
    boolean mo927a(Scope scope);

    /* renamed from: b */
    <A extends C0152a, T extends C1301a<? extends Result, A>> T mo928b(T t);

    ConnectionResult blockingConnect();

    ConnectionResult blockingConnect(long j, TimeUnit timeUnit);

    PendingResult<Status> clearDefaultAccountAndReconnect();

    void connect();

    /* renamed from: d */
    <L> C0163d<L> mo933d(L l);

    void disconnect();

    Looper getLooper();

    boolean isConnected();

    boolean isConnecting();

    boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks);

    boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener);

    void reconnect();

    void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    void stopAutoManage(FragmentActivity fragmentActivity);

    void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);
}
