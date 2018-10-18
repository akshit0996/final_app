package com.google.android.gms.drive.internal;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.ExecutionOptions.Builder;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.C0825p.C1548b;
import com.google.android.gms.drive.internal.C1499q.C1551a;
import com.google.android.gms.internal.jx;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.google.android.gms.drive.internal.s */
public class C0827s implements DriveContents {
    private final Contents PW;
    private boolean PX = false;
    private boolean PY = false;
    private boolean mClosed = false;

    /* renamed from: com.google.android.gms.drive.internal.s$3 */
    class C08263 implements ResultCallback<Status> {
        final /* synthetic */ C0827s PZ;

        C08263(C0827s c0827s) {
            this.PZ = c0827s;
        }

        /* renamed from: j */
        public void m2570j(Status status) {
            if (status.isSuccess()) {
                C0218w.m394m("DriveContentsImpl", "Contents discarded");
            } else {
                C0218w.m396p("DriveContentsImpl", "Error discarding contents");
            }
        }

        public /* synthetic */ void onResult(Result x0) {
            m2570j((Status) x0);
        }
    }

    public C0827s(Contents contents) {
        this.PW = (Contents) jx.m1582i(contents);
    }

    public PendingResult<Status> commit(GoogleApiClient apiClient, MetadataChangeSet changeSet) {
        return commit(apiClient, changeSet, null);
    }

    public PendingResult<Status> commit(GoogleApiClient apiClient, MetadataChangeSet changeSet, ExecutionOptions executionOptions) {
        if (executionOptions == null) {
            executionOptions = new Builder().build();
        }
        if (this.PW.getMode() == DriveFile.MODE_READ_ONLY) {
            throw new IllegalStateException("Cannot commit contents opened with MODE_READ_ONLY");
        } else if (!ExecutionOptions.ba(executionOptions.ix()) || this.PW.ip()) {
            ExecutionOptions.m275a(apiClient, executionOptions);
            if (it()) {
                throw new IllegalStateException("DriveContents already closed.");
            } else if (getDriveId() == null) {
                throw new IllegalStateException("Only DriveContents obtained through DriveFile.open can be committed.");
            } else {
                if (changeSet == null) {
                    changeSet = MetadataChangeSet.OE;
                }
                is();
                return apiClient.mo928b(new C1551a(this, apiClient) {
                    final /* synthetic */ C0827s PZ;

                    /* renamed from: a */
                    protected void m5293a(C1317r c1317r) throws RemoteException {
                        changeSet.iz().setContext(c1317r.getContext());
                        c1317r.iG().mo977a(new CloseContentsAndUpdateMetadataRequest(this.PZ.PW.getDriveId(), changeSet.iz(), this.PZ.PW, executionOptions), new bg(this));
                    }
                });
            }
        } else {
            throw new IllegalStateException("DriveContents must be valid for conflict detection.");
        }
    }

    public void discard(GoogleApiClient apiClient) {
        if (it()) {
            throw new IllegalStateException("DriveContents already closed.");
        }
        is();
        ((C16524) apiClient.mo928b(new C1551a(this, apiClient) {
            final /* synthetic */ C0827s PZ;

            /* renamed from: a */
            protected void m5295a(C1317r c1317r) throws RemoteException {
                c1317r.iG().mo978a(new CloseContentsRequest(this.PZ.PW, false), new bg(this));
            }
        })).setResultCallback(new C08263(this));
    }

    public DriveId getDriveId() {
        return this.PW.getDriveId();
    }

    public InputStream getInputStream() {
        if (it()) {
            throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
        } else if (this.PW.getMode() != DriveFile.MODE_READ_ONLY) {
            throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
        } else if (this.PX) {
            throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
        } else {
            this.PX = true;
            return this.PW.getInputStream();
        }
    }

    public int getMode() {
        return this.PW.getMode();
    }

    public OutputStream getOutputStream() {
        if (it()) {
            throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
        } else if (this.PW.getMode() != DriveFile.MODE_WRITE_ONLY) {
            throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
        } else if (this.PY) {
            throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
        } else {
            this.PY = true;
            return this.PW.getOutputStream();
        }
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        if (!it()) {
            return this.PW.getParcelFileDescriptor();
        }
        throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
    }

    public Contents ir() {
        return this.PW;
    }

    public void is() {
        this.mClosed = true;
    }

    public boolean it() {
        return this.mClosed;
    }

    public PendingResult<DriveContentsResult> reopenForWrite(GoogleApiClient apiClient) {
        if (it()) {
            throw new IllegalStateException("DriveContents already closed.");
        } else if (this.PW.getMode() != DriveFile.MODE_READ_ONLY) {
            throw new IllegalStateException("reopenForWrite can only be used with DriveContents opened with MODE_READ_ONLY.");
        } else {
            is();
            return apiClient.mo926a(new C1548b(this, apiClient) {
                final /* synthetic */ C0827s PZ;

                /* renamed from: a */
                protected void m5291a(C1317r c1317r) throws RemoteException {
                    c1317r.iG().mo988a(new OpenContentsRequest(this.PZ.getDriveId(), DriveFile.MODE_WRITE_ONLY, this.PZ.PW.getRequestId()), new az(this, null));
                }
            });
        }
    }
}
