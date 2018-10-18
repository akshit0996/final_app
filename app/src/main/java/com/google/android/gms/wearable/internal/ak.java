package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import java.util.List;

public final class ak implements NodeApi {

    /* renamed from: com.google.android.gms.wearable.internal.ak$b */
    public static class C1480b implements GetConnectedNodesResult {
        private final Status Eb;
        private final List<Node> aya;

        public C1480b(Status status, List<Node> list) {
            this.Eb = status;
            this.aya = list;
        }

        public List<Node> getNodes() {
            return this.aya;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ak$c */
    public static class C1481c implements GetLocalNodeResult {
        private final Status Eb;
        private final Node ayb;

        public C1481c(Status status, Node node) {
            this.Eb = status;
            this.ayb = node;
        }

        public Node getNode() {
            return this.ayb;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ak$a */
    private static final class C1598a extends C1540d<Status> {
        private NodeListener axZ;

        private C1598a(GoogleApiClient googleApiClient, NodeListener nodeListener) {
            super(googleApiClient);
            this.axZ = nodeListener;
        }

        /* renamed from: a */
        protected void m5177a(ba baVar) throws RemoteException {
            baVar.m4731a((C0155b) this, this.axZ);
            this.axZ = null;
        }

        /* renamed from: b */
        public Status m5178b(Status status) {
            this.axZ = null;
            return status;
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m5178b(status);
        }
    }

    public PendingResult<Status> addListener(GoogleApiClient client, NodeListener listener) {
        return client.mo926a(new C1598a(client, listener));
    }

    public PendingResult<GetConnectedNodesResult> getConnectedNodes(GoogleApiClient client) {
        return client.mo926a(new C1540d<GetConnectedNodesResult>(this, client) {
            final /* synthetic */ ak axX;

            /* renamed from: a */
            protected void m5170a(ba baVar) throws RemoteException {
                baVar.m4741p(this);
            }

            protected GetConnectedNodesResult aK(Status status) {
                return new C1480b(status, null);
            }

            /* renamed from: c */
            protected /* synthetic */ Result mo2958c(Status status) {
                return aK(status);
            }
        });
    }

    public PendingResult<GetLocalNodeResult> getLocalNode(GoogleApiClient client) {
        return client.mo926a(new C1540d<GetLocalNodeResult>(this, client) {
            final /* synthetic */ ak axX;

            /* renamed from: a */
            protected void m5167a(ba baVar) throws RemoteException {
                baVar.m4740o(this);
            }

            protected GetLocalNodeResult aJ(Status status) {
                return new C1481c(status, null);
            }

            /* renamed from: c */
            protected /* synthetic */ Result mo2958c(Status status) {
                return aJ(status);
            }
        });
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, final NodeListener listener) {
        return client.mo926a(new C1540d<Status>(this, client) {
            final /* synthetic */ ak axX;

            /* renamed from: a */
            protected void m5173a(ba baVar) throws RemoteException {
                baVar.m4736b((C0155b) this, listener);
            }

            /* renamed from: b */
            public Status m5174b(Status status) {
                return status;
            }

            /* renamed from: c */
            public /* synthetic */ Result mo2958c(Status status) {
                return m5174b(status);
            }
        });
    }
}
