package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveApi.DriveIdResult;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.internal.C1499q.C1551a;
import com.google.android.gms.drive.query.Query;
import java.util.List;

/* renamed from: com.google.android.gms.drive.internal.p */
public class C0825p implements DriveApi {

    /* renamed from: com.google.android.gms.drive.internal.p$a */
    static class C1314a implements DriveContentsResult {
        private final Status Eb;
        private final DriveContents Om;

        public C1314a(Status status, DriveContents driveContents) {
            this.Eb = status;
            this.Om = driveContents;
        }

        public DriveContents getDriveContents() {
            return this.Om;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p$d */
    private static class C1315d implements DriveIdResult {
        private final Status Eb;
        private final DriveId Oj;

        public C1315d(Status status, DriveId driveId) {
            this.Eb = status;
            this.Oj = driveId;
        }

        public DriveId getDriveId() {
            return this.Oj;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p$f */
    static class C1316f implements MetadataBufferResult {
        private final Status Eb;
        private final MetadataBuffer PI;
        private final boolean PJ;

        public C1316f(Status status, MetadataBuffer metadataBuffer, boolean z) {
            this.Eb = status;
            this.PI = metadataBuffer;
            this.PJ = z;
        }

        public MetadataBuffer getMetadataBuffer() {
            return this.PI;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p$c */
    static class C1496c extends C1312c {
        private final C0155b<DriveIdResult> Ea;

        public C1496c(C0155b<DriveIdResult> c0155b) {
            this.Ea = c0155b;
        }

        /* renamed from: a */
        public void mo1008a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.Ea.mo908b(new C1315d(Status.Kw, onDriveIdResponse.getDriveId()));
        }

        /* renamed from: a */
        public void mo1013a(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.Ea.mo908b(new C1315d(Status.Kw, new C1313m(onMetadataResponse.iU()).getDriveId()));
        }

        /* renamed from: n */
        public void mo1017n(Status status) throws RemoteException {
            this.Ea.mo908b(new C1315d(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p$h */
    private static class C1497h extends C1312c {
        private final C0155b<DriveContentsResult> Ea;

        public C1497h(C0155b<DriveContentsResult> c0155b) {
            this.Ea = c0155b;
        }

        /* renamed from: a */
        public void mo1005a(OnContentsResponse onContentsResponse) throws RemoteException {
            this.Ea.mo908b(new C1314a(Status.Kw, new C0827s(onContentsResponse.iL())));
        }

        /* renamed from: n */
        public void mo1017n(Status status) throws RemoteException {
            this.Ea.mo908b(new C1314a(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p$i */
    private static class C1498i extends C1312c {
        private final C0155b<MetadataBufferResult> Ea;

        public C1498i(C0155b<MetadataBufferResult> c0155b) {
            this.Ea = c0155b;
        }

        /* renamed from: a */
        public void mo1010a(OnListEntriesResponse onListEntriesResponse) throws RemoteException {
            this.Ea.mo908b(new C1316f(Status.Kw, new MetadataBuffer(onListEntriesResponse.iR(), null), onListEntriesResponse.iS()));
        }

        /* renamed from: n */
        public void mo1017n(Status status) throws RemoteException {
            this.Ea.mo908b(new C1316f(status, null, false));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p$b */
    static abstract class C1548b extends C1499q<DriveContentsResult> {
        C1548b(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m4992o(status);
        }

        /* renamed from: o */
        public DriveContentsResult m4992o(Status status) {
            return new C1314a(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p$e */
    static abstract class C1549e extends C1499q<DriveIdResult> {
        C1549e(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m4994p(status);
        }

        /* renamed from: p */
        public DriveIdResult m4994p(Status status) {
            return new C1315d(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p$g */
    static abstract class C1550g extends C1499q<MetadataBufferResult> {
        C1550g(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m4996q(status);
        }

        /* renamed from: q */
        public MetadataBufferResult m4996q(Status status) {
            return new C1316f(status, null, false);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.p$j */
    static class C1644j extends C1551a {
        C1644j(GoogleApiClient googleApiClient, Status status) {
            super(googleApiClient);
            m2447b((Result) status);
        }

        /* renamed from: a */
        protected void m5279a(C1317r c1317r) {
        }
    }

    /* renamed from: a */
    public PendingResult<DriveContentsResult> m2569a(GoogleApiClient googleApiClient, final int i) {
        return googleApiClient.mo926a(new C1548b(this, googleApiClient) {
            final /* synthetic */ C0825p PF;

            /* renamed from: a */
            protected void m5273a(C1317r c1317r) throws RemoteException {
                c1317r.iG().mo979a(new CreateContentsRequest(i), new C1497h(this));
            }
        });
    }

    public PendingResult<Status> cancelPendingActions(GoogleApiClient apiClient, List<String> trackingTags) {
        return ((C1317r) apiClient.mo925a(Drive.DQ)).cancelPendingActions(apiClient, trackingTags);
    }

    public PendingResult<DriveIdResult> fetchDriveId(GoogleApiClient apiClient, final String resourceId) {
        return apiClient.mo926a(new C1549e(this, apiClient) {
            final /* synthetic */ C0825p PF;

            /* renamed from: a */
            protected void m5275a(C1317r c1317r) throws RemoteException {
                c1317r.iG().mo985a(new GetMetadataRequest(DriveId.bi(resourceId)), new C1496c(this));
            }
        });
    }

    public DriveFolder getAppFolder(GoogleApiClient apiClient) {
        if (apiClient.isConnected()) {
            DriveId iI = ((C1317r) apiClient.mo925a(Drive.DQ)).iI();
            return iI != null ? new C1321v(iI) : null;
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFile getFile(GoogleApiClient apiClient, DriveId driveId) {
        if (driveId == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (apiClient.isConnected()) {
            return new C1318t(driveId);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getFolder(GoogleApiClient apiClient, DriveId driveId) {
        if (driveId == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (apiClient.isConnected()) {
            return new C1321v(driveId);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getRootFolder(GoogleApiClient apiClient) {
        if (apiClient.isConnected()) {
            return new C1321v(((C1317r) apiClient.mo925a(Drive.DQ)).iH());
        }
        throw new IllegalStateException("Client must be connected");
    }

    public CreateFileActivityBuilder newCreateFileActivityBuilder() {
        return new CreateFileActivityBuilder();
    }

    public PendingResult<DriveContentsResult> newDriveContents(GoogleApiClient apiClient) {
        return m2569a(apiClient, DriveFile.MODE_WRITE_ONLY);
    }

    public OpenFileActivityBuilder newOpenFileActivityBuilder() {
        return new OpenFileActivityBuilder();
    }

    public PendingResult<MetadataBufferResult> query(GoogleApiClient apiClient, final Query query) {
        if (query != null) {
            return apiClient.mo926a(new C1550g(this, apiClient) {
                final /* synthetic */ C0825p PF;

                /* renamed from: a */
                protected void m5271a(C1317r c1317r) throws RemoteException {
                    c1317r.iG().mo989a(new QueryRequest(query), new C1498i(this));
                }
            });
        }
        throw new IllegalArgumentException("Query must be provided.");
    }

    public PendingResult<Status> requestSync(GoogleApiClient apiClient) {
        return apiClient.mo928b(new C1551a(this, apiClient) {
            final /* synthetic */ C0825p PF;

            /* renamed from: a */
            protected void m5277a(C1317r c1317r) throws RemoteException {
                c1317r.iG().mo996a(new bg(this));
            }
        });
    }
}
