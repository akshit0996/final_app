package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.LaunchOptions.Builder;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.C0153b;
import com.google.android.gms.common.api.Api.C0154c;
import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.BaseImplementation.C1301a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.im;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jx;
import java.io.IOException;

public final class Cast {
    public static final Api<CastOptions> API = new Api(DR, DQ, new Scope[0]);
    public static final CastApi CastApi = new C0795a();
    static final C0154c<im> DQ = new C0154c();
    private static final C0153b<im, CastOptions> DR = new C07941();
    public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
    public static final int MAX_MESSAGE_LENGTH = 65536;
    public static final int MAX_NAMESPACE_LENGTH = 128;

    public interface CastApi {

        /* renamed from: com.google.android.gms.cast.Cast$CastApi$a */
        public static final class C0795a implements CastApi {
            public ApplicationMetadata getApplicationMetadata(GoogleApiClient client) throws IllegalStateException {
                return ((im) client.mo925a(Cast.DQ)).getApplicationMetadata();
            }

            public String getApplicationStatus(GoogleApiClient client) throws IllegalStateException {
                return ((im) client.mo925a(Cast.DQ)).getApplicationStatus();
            }

            public double getVolume(GoogleApiClient client) throws IllegalStateException {
                return ((im) client.mo925a(Cast.DQ)).fZ();
            }

            public boolean isMute(GoogleApiClient client) throws IllegalStateException {
                return ((im) client.mo925a(Cast.DQ)).isMute();
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client) {
                return client.mo928b(new C1546c(this, client) {
                    final /* synthetic */ C0795a Fv;

                    /* renamed from: a */
                    protected void m5243a(im imVar) throws RemoteException {
                        try {
                            imVar.m4456b(null, null, this);
                        } catch (IllegalStateException e) {
                            m4750W(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client, final String applicationId) {
                return client.mo928b(new C1546c(this, client) {
                    final /* synthetic */ C0795a Fv;

                    /* renamed from: a */
                    protected void m5241a(im imVar) throws RemoteException {
                        try {
                            imVar.m4456b(applicationId, null, this);
                        } catch (IllegalStateException e) {
                            m4750W(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client, final String applicationId, final String sessionId) {
                return client.mo928b(new C1546c(this, client) {
                    final /* synthetic */ C0795a Fv;

                    /* renamed from: a */
                    protected void m5239a(im imVar) throws RemoteException {
                        try {
                            imVar.m4456b(applicationId, sessionId, this);
                        } catch (IllegalStateException e) {
                            m4750W(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, final String applicationId) {
                return client.mo928b(new C1546c(this, client) {
                    final /* synthetic */ C0795a Fv;

                    /* renamed from: a */
                    protected void m5235a(im imVar) throws RemoteException {
                        try {
                            imVar.m4455a(applicationId, false, (C0155b) this);
                        } catch (IllegalStateException e) {
                            m4750W(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, final String applicationId, final LaunchOptions options) {
                return client.mo928b(new C1546c(this, client) {
                    final /* synthetic */ C0795a Fv;

                    /* renamed from: a */
                    protected void m5237a(im imVar) throws RemoteException {
                        try {
                            imVar.m4452a(applicationId, options, (C0155b) this);
                        } catch (IllegalStateException e) {
                            m4750W(2001);
                        }
                    }
                });
            }

            @Deprecated
            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, String applicationId, boolean relaunchIfRunning) {
                return launchApplication(client, applicationId, new Builder().setRelaunchIfRunning(relaunchIfRunning).build());
            }

            public PendingResult<Status> leaveApplication(GoogleApiClient client) {
                return client.mo928b(new C1545b(this, client) {
                    final /* synthetic */ C0795a Fv;

                    /* renamed from: a */
                    protected void m5245a(im imVar) throws RemoteException {
                        try {
                            imVar.m4457d((C0155b) this);
                        } catch (IllegalStateException e) {
                            m4750W(2001);
                        }
                    }
                });
            }

            public void removeMessageReceivedCallbacks(GoogleApiClient client, String namespace) throws IOException, IllegalArgumentException {
                try {
                    ((im) client.mo925a(Cast.DQ)).aE(namespace);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void requestStatus(GoogleApiClient client) throws IOException, IllegalStateException {
                try {
                    ((im) client.mo925a(Cast.DQ)).fY();
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> sendMessage(GoogleApiClient client, final String namespace, final String message) {
                return client.mo928b(new C1545b(this, client) {
                    final /* synthetic */ C0795a Fv;

                    /* renamed from: a */
                    protected void m5233a(im imVar) throws RemoteException {
                        try {
                            imVar.m4454a(namespace, message, (C0155b) this);
                        } catch (IllegalArgumentException e) {
                            m4750W(2001);
                        } catch (IllegalStateException e2) {
                            m4750W(2001);
                        }
                    }
                });
            }

            public void setMessageReceivedCallbacks(GoogleApiClient client, String namespace, MessageReceivedCallback callbacks) throws IOException, IllegalStateException {
                try {
                    ((im) client.mo925a(Cast.DQ)).m4451a(namespace, callbacks);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setMute(GoogleApiClient client, boolean mute) throws IOException, IllegalStateException {
                try {
                    ((im) client.mo925a(Cast.DQ)).m4446I(mute);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setVolume(GoogleApiClient client, double volume) throws IOException, IllegalArgumentException, IllegalStateException {
                try {
                    ((im) client.mo925a(Cast.DQ)).m4448a(volume);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> stopApplication(GoogleApiClient client) {
                return client.mo928b(new C1545b(this, client) {
                    final /* synthetic */ C0795a Fv;

                    /* renamed from: a */
                    protected void m5247a(im imVar) throws RemoteException {
                        try {
                            imVar.m4453a("", (C0155b) this);
                        } catch (IllegalStateException e) {
                            m4750W(2001);
                        }
                    }
                });
            }

            public PendingResult<Status> stopApplication(GoogleApiClient client, final String sessionId) {
                return client.mo928b(new C1545b(this, client) {
                    final /* synthetic */ C0795a Fv;

                    /* renamed from: a */
                    protected void m5249a(im imVar) throws RemoteException {
                        if (TextUtils.isEmpty(sessionId)) {
                            m4751e(2001, "IllegalArgument: sessionId cannot be null or empty");
                            return;
                        }
                        try {
                            imVar.m4453a(sessionId, (C0155b) this);
                        } catch (IllegalStateException e) {
                            m4750W(2001);
                        }
                    }
                });
            }
        }

        ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient) throws IllegalStateException;

        String getApplicationStatus(GoogleApiClient googleApiClient) throws IllegalStateException;

        double getVolume(GoogleApiClient googleApiClient) throws IllegalStateException;

        boolean isMute(GoogleApiClient googleApiClient) throws IllegalStateException;

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str, String str2);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, LaunchOptions launchOptions);

        @Deprecated
        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, boolean z);

        PendingResult<Status> leaveApplication(GoogleApiClient googleApiClient);

        void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str) throws IOException, IllegalArgumentException;

        void requestStatus(GoogleApiClient googleApiClient) throws IOException, IllegalStateException;

        PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, String str, String str2);

        void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback) throws IOException, IllegalStateException;

        void setMute(GoogleApiClient googleApiClient, boolean z) throws IOException, IllegalStateException;

        void setVolume(GoogleApiClient googleApiClient, double d) throws IOException, IllegalArgumentException, IllegalStateException;

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient);

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, String str);
    }

    public static class Listener {
        /* renamed from: X */
        public void m98X(int i) {
        }

        /* renamed from: Y */
        public void m99Y(int i) {
        }

        public void onApplicationDisconnected(int statusCode) {
        }

        public void onApplicationMetadataChanged(ApplicationMetadata applicationMetadata) {
        }

        public void onApplicationStatusChanged() {
        }

        public void onVolumeChanged() {
        }
    }

    public interface MessageReceivedCallback {
        void onMessageReceived(CastDevice castDevice, String str, String str2);
    }

    /* renamed from: com.google.android.gms.cast.Cast$1 */
    static class C07941 implements C0153b<im, CastOptions> {
        C07941() {
        }

        /* renamed from: a */
        public im m2432a(Context context, Looper looper, jg jgVar, CastOptions castOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            jx.m1578b((Object) castOptions, (Object) "Setting the API options is required.");
            return new im(context, looper, castOptions.Fz, (long) castOptions.FB, castOptions.FA, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    public interface ApplicationConnectionResult extends Result {
        ApplicationMetadata getApplicationMetadata();

        String getApplicationStatus();

        String getSessionId();

        boolean getWasLaunched();
    }

    public static final class CastOptions implements HasOptions {
        final Listener FA;
        private final int FB;
        final CastDevice Fz;

        public static final class Builder {
            CastDevice FC;
            Listener FD;
            private int FE;

            private Builder(CastDevice castDevice, Listener castListener) {
                jx.m1578b((Object) castDevice, (Object) "CastDevice parameter cannot be null");
                jx.m1578b((Object) castListener, (Object) "CastListener parameter cannot be null");
                this.FC = castDevice;
                this.FD = castListener;
                this.FE = 0;
            }

            public CastOptions build() {
                return new CastOptions();
            }

            public Builder setVerboseLoggingEnabled(boolean enabled) {
                if (enabled) {
                    this.FE |= 1;
                } else {
                    this.FE &= -2;
                }
                return this;
            }
        }

        private CastOptions(Builder builder) {
            this.Fz = builder.FC;
            this.FA = builder.FD;
            this.FB = builder.FE;
        }

        public static Builder builder(CastDevice castDevice, Listener castListener) {
            return new Builder(castDevice, castListener);
        }
    }

    /* renamed from: com.google.android.gms.cast.Cast$a */
    protected static abstract class C1494a<R extends Result> extends C1301a<R, im> {
        public C1494a(GoogleApiClient googleApiClient) {
            super(Cast.DQ, googleApiClient);
        }

        /* renamed from: W */
        public void m4750W(int i) {
            m2447b(mo2958c(new Status(i)));
        }

        /* renamed from: e */
        public void m4751e(int i, String str) {
            m2447b(mo2958c(new Status(i, str, null)));
        }
    }

    /* renamed from: com.google.android.gms.cast.Cast$b */
    private static abstract class C1545b extends C1494a<Status> {
        C1545b(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: b */
        public Status m4985b(Status status) {
            return status;
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m4985b(status);
        }
    }

    /* renamed from: com.google.android.gms.cast.Cast$c */
    private static abstract class C1546c extends C1494a<ApplicationConnectionResult> {
        public C1546c(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m4988i(status);
        }

        /* renamed from: i */
        public ApplicationConnectionResult m4988i(final Status status) {
            return new ApplicationConnectionResult(this) {
                final /* synthetic */ C1546c FF;

                public ApplicationMetadata getApplicationMetadata() {
                    return null;
                }

                public String getApplicationStatus() {
                    return null;
                }

                public String getSessionId() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }

                public boolean getWasLaunched() {
                    return false;
                }
            };
        }
    }

    private Cast() {
    }
}
