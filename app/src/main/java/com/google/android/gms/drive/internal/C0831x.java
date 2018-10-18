package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DrivePreferencesApi;
import com.google.android.gms.drive.DrivePreferencesApi.FileUploadPreferencesResult;
import com.google.android.gms.drive.FileUploadPreferences;
import com.google.android.gms.drive.internal.C1499q.C1551a;

/* renamed from: com.google.android.gms.drive.internal.x */
public class C0831x implements DrivePreferencesApi {

    /* renamed from: com.google.android.gms.drive.internal.x$b */
    private class C1322b implements FileUploadPreferencesResult {
        private final Status Eb;
        final /* synthetic */ C0831x Qq;
        private final FileUploadPreferences Qs;

        private C1322b(C0831x c0831x, Status status, FileUploadPreferences fileUploadPreferences) {
            this.Qq = c0831x;
            this.Eb = status;
            this.Qs = fileUploadPreferences;
        }

        public FileUploadPreferences getFileUploadPreferences() {
            return this.Qs;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.x$a */
    private class C1502a extends C1312c {
        private final C0155b<FileUploadPreferencesResult> Ea;
        final /* synthetic */ C0831x Qq;

        private C1502a(C0831x c0831x, C0155b<FileUploadPreferencesResult> c0155b) {
            this.Qq = c0831x;
            this.Ea = c0155b;
        }

        /* renamed from: a */
        public void mo1006a(OnDeviceUsagePreferenceResponse onDeviceUsagePreferenceResponse) throws RemoteException {
            this.Ea.mo908b(new C1322b(Status.Kw, onDeviceUsagePreferenceResponse.iN()));
        }

        /* renamed from: n */
        public void mo1017n(Status status) throws RemoteException {
            this.Ea.mo908b(new C1322b(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.x$c */
    private abstract class C1554c extends C1499q<FileUploadPreferencesResult> {
        final /* synthetic */ C0831x Qq;

        public C1554c(C0831x c0831x, GoogleApiClient googleApiClient) {
            this.Qq = c0831x;
            super(googleApiClient);
        }

        /* renamed from: c */
        protected /* synthetic */ Result mo2958c(Status status) {
            return m5004t(status);
        }

        /* renamed from: t */
        protected FileUploadPreferencesResult m5004t(Status status) {
            return new C1322b(status, null);
        }
    }

    public PendingResult<FileUploadPreferencesResult> getFileUploadPreferences(GoogleApiClient apiClient) {
        return apiClient.mo926a(new C1554c(this, apiClient) {
            final /* synthetic */ C0831x Qq;

            /* renamed from: a */
            protected void m5303a(C1317r c1317r) throws RemoteException {
                c1317r.iG().mo1004h(new C1502a(this));
            }
        });
    }

    public PendingResult<Status> setFileUploadPreferences(GoogleApiClient apiClient, FileUploadPreferences fileUploadPreferences) {
        if (fileUploadPreferences instanceof FileUploadPreferencesImpl) {
            final FileUploadPreferencesImpl fileUploadPreferencesImpl = (FileUploadPreferencesImpl) fileUploadPreferences;
            return apiClient.mo928b(new C1551a(this, apiClient) {
                final /* synthetic */ C0831x Qq;

                /* renamed from: a */
                protected void m5305a(C1317r c1317r) throws RemoteException {
                    c1317r.iG().mo992a(new SetFileUploadPreferencesRequest(fileUploadPreferencesImpl), new bg(this));
                }
            });
        }
        throw new IllegalArgumentException("Invalid preference value");
    }
}
