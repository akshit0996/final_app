package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;

public final class ah implements MessageApi {

    /* renamed from: com.google.android.gms.wearable.internal.ah$b */
    public static class C1479b implements SendMessageResult {
        private final Status Eb;
        private final int ve;

        public C1479b(Status status, int i) {
            this.Eb = status;
            this.ve = i;
        }

        public int getRequestId() {
            return this.ve;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ah$a */
    private static final class C1594a extends C1540d<Status> {
        private IntentFilter[] axD;
        private MessageListener axV;

        private C1594a(GoogleApiClient googleApiClient, MessageListener messageListener, IntentFilter[] intentFilterArr) {
            super(googleApiClient);
            this.axV = messageListener;
            this.axD = intentFilterArr;
        }

        /* renamed from: a */
        protected void m5163a(ba baVar) throws RemoteException {
            baVar.m4730a((C0155b) this, this.axV, this.axD);
            this.axV = null;
            this.axD = null;
        }

        /* renamed from: b */
        public Status m5164b(Status status) {
            this.axV = null;
            this.axD = null;
            return status;
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m5164b(status);
        }
    }

    /* renamed from: a */
    private PendingResult<Status> m3902a(GoogleApiClient googleApiClient, MessageListener messageListener, IntentFilter[] intentFilterArr) {
        return googleApiClient.mo926a(new C1594a(googleApiClient, messageListener, intentFilterArr));
    }

    public PendingResult<Status> addListener(GoogleApiClient client, MessageListener listener) {
        return m3902a(client, listener, null);
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, final MessageListener listener) {
        return client.mo926a(new C1540d<Status>(this, client) {
            final /* synthetic */ ah axT;

            /* renamed from: a */
            protected void m5159a(ba baVar) throws RemoteException {
                baVar.m4729a((C0155b) this, listener);
            }

            /* renamed from: b */
            public Status m5160b(Status status) {
                return status;
            }

            /* renamed from: c */
            public /* synthetic */ Result mo2958c(Status status) {
                return m5160b(status);
            }
        });
    }

    public PendingResult<SendMessageResult> sendMessage(GoogleApiClient client, String nodeId, String action, byte[] data) {
        final String str = nodeId;
        final String str2 = action;
        final byte[] bArr = data;
        return client.mo926a(new C1540d<SendMessageResult>(this, client) {
            final /* synthetic */ ah axT;

            /* renamed from: a */
            protected void m5156a(ba baVar) throws RemoteException {
                baVar.m4733a(this, str, str2, bArr);
            }

            protected SendMessageResult aI(Status status) {
                return new C1479b(status, -1);
            }

            /* renamed from: c */
            protected /* synthetic */ Result mo2958c(Status status) {
                return aI(status);
            }
        });
    }
}
