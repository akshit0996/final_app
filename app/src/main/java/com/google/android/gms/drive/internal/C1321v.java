package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveFolder.DriveFileResult;
import com.google.android.gms.drive.DriveFolder.DriveFolderResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.ExecutionOptions.Builder;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.SearchableField;

/* renamed from: com.google.android.gms.drive.internal.v */
public class C1321v extends C0832y implements DriveFolder {

    /* renamed from: com.google.android.gms.drive.internal.v$c */
    private static class C1319c implements DriveFileResult {
        private final Status Eb;
        private final DriveFile Qn;

        public C1319c(Status status, DriveFile driveFile) {
            this.Eb = status;
            this.Qn = driveFile;
        }

        public DriveFile getDriveFile() {
            return this.Qn;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.v$e */
    private static class C1320e implements DriveFolderResult {
        private final Status Eb;
        private final DriveFolder Qo;

        public C1320e(Status status, DriveFolder driveFolder) {
            this.Eb = status;
            this.Qo = driveFolder;
        }

        public DriveFolder getDriveFolder() {
            return this.Qo;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.v$a */
    private static class C1500a extends C1312c {
        private final C0155b<DriveFileResult> Ea;

        public C1500a(C0155b<DriveFileResult> c0155b) {
            this.Ea = c0155b;
        }

        /* renamed from: a */
        public void mo1008a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.Ea.mo908b(new C1319c(Status.Kw, new C1318t(onDriveIdResponse.getDriveId())));
        }

        /* renamed from: n */
        public void mo1017n(Status status) throws RemoteException {
            this.Ea.mo908b(new C1319c(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.v$b */
    private static class C1501b extends C1312c {
        private final C0155b<DriveFolderResult> Ea;

        public C1501b(C0155b<DriveFolderResult> c0155b) {
            this.Ea = c0155b;
        }

        /* renamed from: a */
        public void mo1008a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.Ea.mo908b(new C1320e(Status.Kw, new C1321v(onDriveIdResponse.getDriveId())));
        }

        /* renamed from: n */
        public void mo1017n(Status status) throws RemoteException {
            this.Ea.mo908b(new C1320e(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.v$d */
    static abstract class C1552d extends C1499q<DriveFileResult> {
        C1552d(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m5000r(status);
        }

        /* renamed from: r */
        public DriveFileResult m5000r(Status status) {
            return new C1319c(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.v$f */
    static abstract class C1553f extends C1499q<DriveFolderResult> {
        C1553f(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m5002s(status);
        }

        /* renamed from: s */
        public DriveFolderResult m5002s(Status status) {
            return new C1320e(status, null);
        }
    }

    public C1321v(DriveId driveId) {
        super(driveId);
    }

    /* renamed from: a */
    private PendingResult<DriveFileResult> m3977a(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, int i, int i2, ExecutionOptions executionOptions) {
        ExecutionOptions.m275a(googleApiClient, executionOptions);
        final MetadataChangeSet metadataChangeSet2 = metadataChangeSet;
        final int i3 = i;
        final int i4 = i2;
        final ExecutionOptions executionOptions2 = executionOptions;
        return googleApiClient.mo928b(new C1552d(this, googleApiClient) {
            final /* synthetic */ C1321v Qm;

            /* renamed from: a */
            protected void m5299a(C1317r c1317r) throws RemoteException {
                metadataChangeSet2.iz().setContext(c1317r.getContext());
                c1317r.iG().mo980a(new CreateFileRequest(this.Qm.getDriveId(), metadataChangeSet2.iz(), i3, i4, executionOptions2), new C1500a(this));
            }
        });
    }

    /* renamed from: a */
    private PendingResult<DriveFileResult> m3978a(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, DriveContents driveContents, ExecutionOptions executionOptions) {
        int i;
        if (driveContents == null) {
            i = 1;
        } else if (!(driveContents instanceof C0827s)) {
            throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
        } else if (driveContents.getDriveId() != null) {
            throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
        } else if (driveContents.it()) {
            throw new IllegalArgumentException("DriveContents are already closed.");
        } else {
            i = driveContents.ir().getRequestId();
            driveContents.is();
        }
        if (metadataChangeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        } else if (!DriveFolder.MIME_TYPE.equals(metadataChangeSet.getMimeType())) {
            return m3977a(googleApiClient, metadataChangeSet, i, 0, executionOptions);
        } else {
            throw new IllegalArgumentException("May not create folders (mimetype: application/vnd.google-apps.folder) using this method. Use DriveFolder.createFolder() instead.");
        }
    }

    public PendingResult<DriveFileResult> createFile(GoogleApiClient apiClient, MetadataChangeSet changeSet, DriveContents driveContents) {
        return createFile(apiClient, changeSet, driveContents, null);
    }

    public PendingResult<DriveFileResult> createFile(GoogleApiClient apiClient, MetadataChangeSet changeSet, DriveContents driveContents, ExecutionOptions executionOptions) {
        if (executionOptions == null) {
            executionOptions = new Builder().build();
        }
        if (executionOptions.ix() == 0) {
            return m3978a(apiClient, changeSet, driveContents, executionOptions);
        }
        throw new IllegalStateException("May not set a conflict strategy for calls to createFile.");
    }

    public PendingResult<DriveFolderResult> createFolder(GoogleApiClient apiClient, final MetadataChangeSet changeSet) {
        if (changeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        } else if (changeSet.getMimeType() == null || changeSet.getMimeType().equals(DriveFolder.MIME_TYPE)) {
            return apiClient.mo928b(new C1553f(this, apiClient) {
                final /* synthetic */ C1321v Qm;

                /* renamed from: a */
                protected void m5301a(C1317r c1317r) throws RemoteException {
                    changeSet.iz().setContext(c1317r.getContext());
                    c1317r.iG().mo981a(new CreateFolderRequest(this.Qm.getDriveId(), changeSet.iz()), new C1501b(this));
                }
            });
        } else {
            throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
        }
    }

    public PendingResult<MetadataBufferResult> listChildren(GoogleApiClient apiClient) {
        return queryChildren(apiClient, null);
    }

    public PendingResult<MetadataBufferResult> queryChildren(GoogleApiClient apiClient, Query query) {
        Query.Builder addFilter = new Query.Builder().addFilter(Filters.in(SearchableField.PARENTS, getDriveId()));
        if (query != null) {
            if (query.getFilter() != null) {
                addFilter.addFilter(query.getFilter());
            }
            addFilter.setPageToken(query.getPageToken());
            addFilter.setSortOrder(query.getSortOrder());
        }
        return new C0825p().query(apiClient, addFilter.build());
    }
}
