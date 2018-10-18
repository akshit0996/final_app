package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.gms.wearable.internal.f */
public final class C1273f implements DataApi {

    /* renamed from: com.google.android.gms.wearable.internal.f$b */
    public static class C1482b implements DataItemResult {
        private final Status Eb;
        private final DataItem axE;

        public C1482b(Status status, DataItem dataItem) {
            this.Eb = status;
            this.axE = dataItem;
        }

        public DataItem getDataItem() {
            return this.axE;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.f$c */
    public static class C1483c implements DeleteDataItemsResult {
        private final Status Eb;
        private final int axF;

        public C1483c(Status status, int i) {
            this.Eb = status;
            this.axF = i;
        }

        public int getNumDeleted() {
            return this.axF;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.f$d */
    public static class C1484d implements GetFdForAssetResult {
        private final Status Eb;
        private volatile InputStream ZO;
        private volatile ParcelFileDescriptor axG;
        private volatile boolean mClosed = false;

        public C1484d(Status status, ParcelFileDescriptor parcelFileDescriptor) {
            this.Eb = status;
            this.axG = parcelFileDescriptor;
        }

        public ParcelFileDescriptor getFd() {
            if (!this.mClosed) {
                return this.axG;
            }
            throw new IllegalStateException("Cannot access the file descriptor after release().");
        }

        public InputStream getInputStream() {
            if (this.mClosed) {
                throw new IllegalStateException("Cannot access the input stream after release().");
            } else if (this.axG == null) {
                return null;
            } else {
                if (this.ZO == null) {
                    this.ZO = new AutoCloseInputStream(this.axG);
                }
                return this.ZO;
            }
        }

        public Status getStatus() {
            return this.Eb;
        }

        public void release() {
            if (this.axG != null) {
                if (this.mClosed) {
                    throw new IllegalStateException("releasing an already released result.");
                }
                try {
                    if (this.ZO != null) {
                        this.ZO.close();
                    } else {
                        this.axG.close();
                    }
                    this.mClosed = true;
                    this.axG = null;
                    this.ZO = null;
                } catch (IOException e) {
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.f$a */
    private static final class C1615a extends C1540d<Status> {
        private DataListener axC;
        private IntentFilter[] axD;

        private C1615a(GoogleApiClient googleApiClient, DataListener dataListener, IntentFilter[] intentFilterArr) {
            super(googleApiClient);
            this.axC = dataListener;
            this.axD = intentFilterArr;
        }

        /* renamed from: a */
        protected void m5213a(ba baVar) throws RemoteException {
            baVar.m4727a((C0155b) this, this.axC, this.axD);
            this.axC = null;
            this.axD = null;
        }

        /* renamed from: b */
        public Status m5214b(Status status) {
            this.axC = null;
            this.axD = null;
            return status;
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m5214b(status);
        }
    }

    /* renamed from: a */
    private PendingResult<Status> m3903a(GoogleApiClient googleApiClient, DataListener dataListener, IntentFilter[] intentFilterArr) {
        return googleApiClient.mo926a(new C1615a(googleApiClient, dataListener, intentFilterArr));
    }

    /* renamed from: a */
    private void m3904a(Asset asset) {
        if (asset == null) {
            throw new IllegalArgumentException("asset is null");
        } else if (asset.getDigest() == null) {
            throw new IllegalArgumentException("invalid asset");
        } else if (asset.getData() != null) {
            throw new IllegalArgumentException("invalid asset");
        }
    }

    public PendingResult<Status> addListener(GoogleApiClient client, DataListener listener) {
        return m3903a(client, listener, null);
    }

    public PendingResult<DeleteDataItemsResult> deleteDataItems(GoogleApiClient client, final Uri uri) {
        return client.mo926a(new C1540d<DeleteDataItemsResult>(this, client) {
            final /* synthetic */ C1273f axy;

            /* renamed from: a */
            protected void m5200a(ba baVar) throws RemoteException {
                baVar.m4737c(this, uri);
            }

            protected DeleteDataItemsResult aG(Status status) {
                return new C1483c(status, 0);
            }

            /* renamed from: c */
            protected /* synthetic */ Result mo2958c(Status status) {
                return aG(status);
            }
        });
    }

    public PendingResult<DataItemResult> getDataItem(GoogleApiClient client, final Uri uri) {
        return client.mo926a(new C1540d<DataItemResult>(this, client) {
            final /* synthetic */ C1273f axy;

            /* renamed from: a */
            protected void m5191a(ba baVar) throws RemoteException {
                baVar.m4724a((C0155b) this, uri);
            }

            protected DataItemResult aE(Status status) {
                return new C1482b(status, null);
            }

            /* renamed from: c */
            protected /* synthetic */ Result mo2958c(Status status) {
                return aE(status);
            }
        });
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client) {
        return client.mo926a(new C1540d<DataItemBuffer>(this, client) {
            final /* synthetic */ C1273f axy;

            /* renamed from: a */
            protected void m5194a(ba baVar) throws RemoteException {
                baVar.m4739n(this);
            }

            protected DataItemBuffer aF(Status status) {
                return new DataItemBuffer(DataHolder.av(status.getStatusCode()));
            }

            /* renamed from: c */
            protected /* synthetic */ Result mo2958c(Status status) {
                return aF(status);
            }
        });
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client, final Uri uri) {
        return client.mo926a(new C1540d<DataItemBuffer>(this, client) {
            final /* synthetic */ C1273f axy;

            /* renamed from: a */
            protected void m5197a(ba baVar) throws RemoteException {
                baVar.m4735b((C0155b) this, uri);
            }

            protected DataItemBuffer aF(Status status) {
                return new DataItemBuffer(DataHolder.av(status.getStatusCode()));
            }

            /* renamed from: c */
            protected /* synthetic */ Result mo2958c(Status status) {
                return aF(status);
            }
        });
    }

    public PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient client, final Asset asset) {
        m3904a(asset);
        return client.mo926a(new C1540d<GetFdForAssetResult>(this, client) {
            final /* synthetic */ C1273f axy;

            /* renamed from: a */
            protected void m5203a(ba baVar) throws RemoteException {
                baVar.m4725a((C0155b) this, asset);
            }

            protected GetFdForAssetResult aH(Status status) {
                return new C1484d(status, null);
            }

            /* renamed from: c */
            protected /* synthetic */ Result mo2958c(Status status) {
                return aH(status);
            }
        });
    }

    public PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient client, final DataItemAsset asset) {
        return client.mo926a(new C1540d<GetFdForAssetResult>(this, client) {
            final /* synthetic */ C1273f axy;

            /* renamed from: a */
            protected void m5206a(ba baVar) throws RemoteException {
                baVar.m4728a((C0155b) this, asset);
            }

            protected GetFdForAssetResult aH(Status status) {
                return new C1484d(status, null);
            }

            /* renamed from: c */
            protected /* synthetic */ Result mo2958c(Status status) {
                return aH(status);
            }
        });
    }

    public PendingResult<DataItemResult> putDataItem(GoogleApiClient client, final PutDataRequest request) {
        return client.mo926a(new C1540d<DataItemResult>(this, client) {
            final /* synthetic */ C1273f axy;

            /* renamed from: a */
            protected void m5188a(ba baVar) throws RemoteException {
                baVar.m4732a((C0155b) this, request);
            }

            public DataItemResult aE(Status status) {
                return new C1482b(status, null);
            }

            /* renamed from: c */
            public /* synthetic */ Result mo2958c(Status status) {
                return aE(status);
            }
        });
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, final DataListener listener) {
        return client.mo926a(new C1540d<Status>(this, client) {
            final /* synthetic */ C1273f axy;

            /* renamed from: a */
            protected void m5209a(ba baVar) throws RemoteException {
                baVar.m4726a((C0155b) this, listener);
            }

            /* renamed from: b */
            public Status m5210b(Status status) {
                return status;
            }

            /* renamed from: c */
            public /* synthetic */ Result mo2958c(Status status) {
                return m5210b(status);
            }
        });
    }
}
