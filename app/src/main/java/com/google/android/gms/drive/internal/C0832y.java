package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.DriveResource.MetadataResult;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.internal.C0825p.C1316f;
import com.google.android.gms.drive.internal.C0825p.C1550g;
import com.google.android.gms.drive.internal.C1499q.C1551a;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.gms.drive.internal.y */
public class C0832y implements DriveResource {
    protected final DriveId Oj;

    /* renamed from: com.google.android.gms.drive.internal.y$c */
    private static class C1323c implements MetadataResult {
        private final Status Eb;
        private final Metadata Qv;

        public C1323c(Status status, Metadata metadata) {
            this.Eb = status;
            this.Qv = metadata;
        }

        public Metadata getMetadata() {
            return this.Qv;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.y$a */
    private static class C1503a extends C1312c {
        private final C0155b<MetadataBufferResult> Ea;

        public C1503a(C0155b<MetadataBufferResult> c0155b) {
            this.Ea = c0155b;
        }

        /* renamed from: a */
        public void mo1011a(OnListParentsResponse onListParentsResponse) throws RemoteException {
            this.Ea.mo908b(new C1316f(Status.Kw, new MetadataBuffer(onListParentsResponse.iT(), null), false));
        }

        /* renamed from: n */
        public void mo1017n(Status status) throws RemoteException {
            this.Ea.mo908b(new C1316f(status, null, false));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.y$b */
    private static class C1504b extends C1312c {
        private final C0155b<MetadataResult> Ea;

        public C1504b(C0155b<MetadataResult> c0155b) {
            this.Ea = c0155b;
        }

        /* renamed from: a */
        public void mo1013a(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.Ea.mo908b(new C1323c(Status.Kw, new C1313m(onMetadataResponse.iU())));
        }

        /* renamed from: n */
        public void mo1017n(Status status) throws RemoteException {
            this.Ea.mo908b(new C1323c(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.y$d */
    private abstract class C1555d extends C1499q<MetadataResult> {
        final /* synthetic */ C0832y Qt;

        private C1555d(C0832y c0832y, GoogleApiClient googleApiClient) {
            this.Qt = c0832y;
            super(googleApiClient);
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m5006u(status);
        }

        /* renamed from: u */
        public MetadataResult m5006u(Status status) {
            return new C1323c(status, null);
        }
    }

    protected C0832y(DriveId driveId) {
        this.Oj = driveId;
    }

    public PendingResult<Status> addChangeListener(GoogleApiClient apiClient, ChangeListener listener) {
        return ((C1317r) apiClient.mo925a(Drive.DQ)).m3970a(apiClient, this.Oj, 1, listener);
    }

    public PendingResult<Status> addChangeSubscription(GoogleApiClient apiClient) {
        return ((C1317r) apiClient.mo925a(Drive.DQ)).m3969a(apiClient, this.Oj, 1);
    }

    public DriveId getDriveId() {
        return this.Oj;
    }

    public PendingResult<MetadataResult> getMetadata(GoogleApiClient apiClient) {
        return apiClient.mo926a(new C1555d(this, apiClient) {
            final /* synthetic */ C0832y Qt;

            /* renamed from: a */
            protected void m5307a(C1317r c1317r) throws RemoteException {
                c1317r.iG().mo985a(new GetMetadataRequest(this.Qt.Oj), new C1504b(this));
            }
        });
    }

    public PendingResult<MetadataBufferResult> listParents(GoogleApiClient apiClient) {
        return apiClient.mo926a(new C1550g(this, apiClient) {
            final /* synthetic */ C0832y Qt;

            /* renamed from: a */
            protected void m5309a(C1317r c1317r) throws RemoteException {
                c1317r.iG().mo986a(new ListParentsRequest(this.Qt.Oj), new C1503a(this));
            }
        });
    }

    public PendingResult<Status> removeChangeListener(GoogleApiClient apiClient, ChangeListener listener) {
        return ((C1317r) apiClient.mo925a(Drive.DQ)).m3974b(apiClient, this.Oj, 1, listener);
    }

    public PendingResult<Status> removeChangeSubscription(GoogleApiClient apiClient) {
        return ((C1317r) apiClient.mo925a(Drive.DQ)).m3973b(apiClient, this.Oj, 1);
    }

    public PendingResult<Status> setParents(GoogleApiClient apiClient, Set<DriveId> parentIds) {
        if (parentIds == null) {
            throw new IllegalArgumentException("ParentIds must be provided.");
        } else if (parentIds.isEmpty()) {
            throw new IllegalArgumentException("ParentIds must contain at least one parent.");
        } else {
            final List arrayList = new ArrayList(parentIds);
            return apiClient.mo928b(new C1551a(this, apiClient) {
                final /* synthetic */ C0832y Qt;

                /* renamed from: a */
                protected void m5311a(C1317r c1317r) throws RemoteException {
                    c1317r.iG().mo993a(new SetResourceParentsRequest(this.Qt.Oj, arrayList), new bg(this));
                }
            });
        }
    }

    public PendingResult<MetadataResult> updateMetadata(GoogleApiClient apiClient, final MetadataChangeSet changeSet) {
        if (changeSet != null) {
            return apiClient.mo928b(new C1555d(this, apiClient) {
                final /* synthetic */ C0832y Qt;

                /* renamed from: a */
                protected void m5313a(C1317r c1317r) throws RemoteException {
                    changeSet.iz().setContext(c1317r.getContext());
                    c1317r.iG().mo995a(new UpdateMetadataRequest(this.Qt.Oj, changeSet.iz()), new C1504b(this));
                }
            });
        }
        throw new IllegalArgumentException("ChangeSet must be provided.");
    }
}
