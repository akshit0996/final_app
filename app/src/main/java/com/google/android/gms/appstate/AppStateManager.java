package com.google.android.gms.appstate;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.C0152a;
import com.google.android.gms.common.api.Api.C0153b;
import com.google.android.gms.common.api.Api.C0154c;
import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.BaseImplementation.C1301a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.ib;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jx;

@Deprecated
public final class AppStateManager {
    public static final Api<NoOptions> API = new Api(DR, DQ, SCOPE_APP_STATE);
    static final C0154c<ib> DQ = new C0154c();
    private static final C0153b<ib, NoOptions> DR = new C07931();
    public static final Scope SCOPE_APP_STATE = new Scope(Scopes.APP_STATE);

    /* renamed from: com.google.android.gms.appstate.AppStateManager$1 */
    static class C07931 implements C0153b<ib, NoOptions> {
        C07931() {
        }

        /* renamed from: a */
        public /* synthetic */ C0152a mo878a(Context context, Looper looper, jg jgVar, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m2430b(context, looper, jgVar, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        /* renamed from: b */
        public ib m2430b(Context context, Looper looper, jg jgVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new ib(context, looper, connectionCallbacks, onConnectionFailedListener, jgVar.hm(), (String[]) jgVar.ho().toArray(new String[0]));
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    public interface StateConflictResult extends Releasable, Result {
        byte[] getLocalData();

        String getResolvedVersion();

        byte[] getServerData();

        int getStateKey();
    }

    public interface StateDeletedResult extends Result {
        int getStateKey();
    }

    public interface StateListResult extends Result {
        AppStateBuffer getStateBuffer();
    }

    public interface StateLoadedResult extends Releasable, Result {
        byte[] getLocalData();

        int getStateKey();
    }

    public interface StateResult extends Releasable, Result {
        StateConflictResult getConflictResult();

        StateLoadedResult getLoadedResult();
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager$a */
    public static abstract class C1493a<R extends Result> extends C1301a<R, ib> {
        public C1493a(GoogleApiClient googleApiClient) {
            super(AppStateManager.DQ, googleApiClient);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager$b */
    private static abstract class C1541b extends C1493a<StateDeletedResult> {
        C1541b(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager$c */
    private static abstract class C1542c extends C1493a<StateListResult> {
        public C1542c(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m4980g(status);
        }

        /* renamed from: g */
        public StateListResult m4980g(final Status status) {
            return new StateListResult(this) {
                final /* synthetic */ C1542c DY;

                public AppStateBuffer getStateBuffer() {
                    return new AppStateBuffer(null);
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager$d */
    private static abstract class C1543d extends C1493a<Status> {
        public C1543d(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: b */
        public Status m4981b(Status status) {
            return status;
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m4981b(status);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager$e */
    private static abstract class C1544e extends C1493a<StateResult> {
        public C1544e(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m4984h(status);
        }

        /* renamed from: h */
        public StateResult m4984h(Status status) {
            return AppStateManager.m89d(status);
        }
    }

    private AppStateManager() {
    }

    /* renamed from: a */
    public static ib m88a(GoogleApiClient googleApiClient) {
        boolean z = true;
        jx.m1580b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        jx.m1576a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        ib ibVar = (ib) googleApiClient.mo925a(DQ);
        if (ibVar == null) {
            z = false;
        }
        jx.m1576a(z, "GoogleApiClient is not configured to use the AppState API. Pass AppStateManager.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return ibVar;
    }

    /* renamed from: d */
    private static StateResult m89d(final Status status) {
        return new StateResult() {
            public StateConflictResult getConflictResult() {
                return null;
            }

            public StateLoadedResult getLoadedResult() {
                return null;
            }

            public Status getStatus() {
                return status;
            }

            public void release() {
            }
        };
    }

    public static PendingResult<StateDeletedResult> delete(GoogleApiClient googleApiClient, final int stateKey) {
        return googleApiClient.mo928b(new C1541b(googleApiClient) {
            /* renamed from: a */
            protected void m5221a(ib ibVar) {
                ibVar.m4409a((C0155b) this, stateKey);
            }

            /* renamed from: c */
            public /* synthetic */ Result mo2958c(Status status) {
                return m5223f(status);
            }

            /* renamed from: f */
            public StateDeletedResult m5223f(final Status status) {
                return new StateDeletedResult(this) {
                    final /* synthetic */ C16185 DV;

                    public int getStateKey() {
                        return stateKey;
                    }

                    public Status getStatus() {
                        return status;
                    }
                };
            }
        });
    }

    public static int getMaxNumKeys(GoogleApiClient googleApiClient) {
        return m88a(googleApiClient).fM();
    }

    public static int getMaxStateSize(GoogleApiClient googleApiClient) {
        return m88a(googleApiClient).fL();
    }

    public static PendingResult<StateListResult> list(GoogleApiClient googleApiClient) {
        return googleApiClient.mo926a(new C1542c(googleApiClient) {
            /* renamed from: a */
            protected void m5227a(ib ibVar) {
                ibVar.m4408a(this);
            }
        });
    }

    public static PendingResult<StateResult> load(GoogleApiClient googleApiClient, final int stateKey) {
        return googleApiClient.mo926a(new C1544e(googleApiClient) {
            /* renamed from: a */
            protected void m5225a(ib ibVar) {
                ibVar.m4414b(this, stateKey);
            }
        });
    }

    public static PendingResult<StateResult> resolve(GoogleApiClient googleApiClient, final int stateKey, final String resolvedVersion, final byte[] resolvedData) {
        return googleApiClient.mo928b(new C1544e(googleApiClient) {
            /* renamed from: a */
            protected void m5229a(ib ibVar) {
                ibVar.m4410a(this, stateKey, resolvedVersion, resolvedData);
            }
        });
    }

    public static PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        return googleApiClient.mo928b(new C1543d(googleApiClient) {
            /* renamed from: a */
            protected void m5231a(ib ibVar) {
                ibVar.m4413b(this);
            }
        });
    }

    public static void update(GoogleApiClient googleApiClient, final int stateKey, final byte[] data) {
        googleApiClient.mo928b(new C1544e(googleApiClient) {
            /* renamed from: a */
            protected void m5217a(ib ibVar) {
                ibVar.m4411a(null, stateKey, data);
            }
        });
    }

    public static PendingResult<StateResult> updateImmediate(GoogleApiClient googleApiClient, final int stateKey, final byte[] data) {
        return googleApiClient.mo928b(new C1544e(googleApiClient) {
            /* renamed from: a */
            protected void m5219a(ib ibVar) {
                ibVar.m4411a(this, stateKey, data);
            }
        });
    }
}
