package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0163d;
import com.google.android.gms.common.api.C0163d.C0162b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.C0825p.C1548b;

/* renamed from: com.google.android.gms.drive.internal.t */
public class C1318t extends C0832y implements DriveFile {

    /* renamed from: com.google.android.gms.drive.internal.t$a */
    private static class C0829a implements DownloadProgressListener {
        private final C0163d<DownloadProgressListener> Qe;

        public C0829a(C0163d<DownloadProgressListener> c0163d) {
            this.Qe = c0163d;
        }

        public void onProgress(long bytesDownloaded, long bytesExpected) {
            final long j = bytesDownloaded;
            final long j2 = bytesExpected;
            this.Qe.m161a(new C0162b<DownloadProgressListener>(this) {
                final /* synthetic */ C0829a Qh;

                /* renamed from: a */
                public void m2572a(DownloadProgressListener downloadProgressListener) {
                    downloadProgressListener.onProgress(j, j2);
                }

                /* renamed from: c */
                public /* synthetic */ void mo916c(Object obj) {
                    m2572a((DownloadProgressListener) obj);
                }

                public void gG() {
                }
            });
        }
    }

    public C1318t(DriveId driveId) {
        super(driveId);
    }

    /* renamed from: a */
    private static DownloadProgressListener m3976a(GoogleApiClient googleApiClient, DownloadProgressListener downloadProgressListener) {
        return downloadProgressListener == null ? null : new C0829a(googleApiClient.mo933d(downloadProgressListener));
    }

    public PendingResult<DriveContentsResult> open(GoogleApiClient apiClient, final int mode, DownloadProgressListener listener) {
        if (mode == DriveFile.MODE_READ_ONLY || mode == DriveFile.MODE_WRITE_ONLY || mode == DriveFile.MODE_READ_WRITE) {
            final DownloadProgressListener a = C1318t.m3976a(apiClient, listener);
            return apiClient.mo926a(new C1548b(this, apiClient) {
                final /* synthetic */ C1318t Qd;

                /* renamed from: a */
                protected void m5297a(C1317r c1317r) throws RemoteException {
                    c1317r.iG().mo988a(new OpenContentsRequest(this.Qd.getDriveId(), mode, 0), new az(this, a));
                }
            });
        }
        throw new IllegalArgumentException("Invalid mode provided.");
    }
}
