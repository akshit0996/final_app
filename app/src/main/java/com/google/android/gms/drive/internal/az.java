package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;
import com.google.android.gms.drive.internal.C0825p.C1314a;

class az extends C1312c {
    private final C0155b<DriveContentsResult> Ea;
    private final DownloadProgressListener QU;

    az(C0155b<DriveContentsResult> c0155b, DownloadProgressListener downloadProgressListener) {
        this.Ea = c0155b;
        this.QU = downloadProgressListener;
    }

    /* renamed from: a */
    public void mo1005a(OnContentsResponse onContentsResponse) throws RemoteException {
        this.Ea.mo908b(new C1314a(onContentsResponse.iM() ? new Status(-1) : Status.Kw, new C0827s(onContentsResponse.iL())));
    }

    /* renamed from: a */
    public void mo1007a(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException {
        if (this.QU != null) {
            this.QU.onProgress(onDownloadProgressResponse.iO(), onDownloadProgressResponse.iP());
        }
    }

    /* renamed from: n */
    public void mo1017n(Status status) throws RemoteException {
        this.Ea.mo908b(new C1314a(status, null));
    }
}
