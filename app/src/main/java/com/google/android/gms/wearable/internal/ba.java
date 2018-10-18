package com.google.android.gms.wearable.internal;

import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jl.C1399e;
import com.google.android.gms.internal.jt;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.internal.af.C1267a;
import com.google.android.gms.wearable.internal.ag.C1268b;
import com.google.android.gms.wearable.internal.ag.C1269c;
import com.google.android.gms.wearable.internal.ag.C1270d;
import com.google.android.gms.wearable.internal.az.C1599b;
import com.google.android.gms.wearable.internal.az.C1600c;
import com.google.android.gms.wearable.internal.az.C1601d;
import com.google.android.gms.wearable.internal.az.C1602e;
import com.google.android.gms.wearable.internal.az.C1603f;
import com.google.android.gms.wearable.internal.az.C1604g;
import com.google.android.gms.wearable.internal.az.C1605i;
import com.google.android.gms.wearable.internal.az.C1606j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ba extends jl<af> {
    private final ExecutorService asJ = Executors.newCachedThreadPool();
    private final ag<DataListener> ayg = new C1268b();
    private final ag<MessageListener> ayh = new C1269c();
    private final ag<NodeListener> ayi = new C1270d();

    public ba(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, new String[0]);
    }

    /* renamed from: a */
    private FutureTask<Boolean> m4722a(final ParcelFileDescriptor parcelFileDescriptor, final byte[] bArr) {
        return new FutureTask(new Callable<Boolean>(this) {
            final /* synthetic */ ba ayk;

            public /* synthetic */ Object call() throws Exception {
                return rr();
            }

            public Boolean rr() {
                if (Log.isLoggable("WearableClient", 3)) {
                    Log.d("WearableClient", "processAssets: writing data to FD : " + parcelFileDescriptor);
                }
                AutoCloseOutputStream autoCloseOutputStream = new AutoCloseOutputStream(parcelFileDescriptor);
                try {
                    autoCloseOutputStream.write(bArr);
                    autoCloseOutputStream.flush();
                    if (Log.isLoggable("WearableClient", 3)) {
                        Log.d("WearableClient", "processAssets: wrote data: " + parcelFileDescriptor);
                    }
                    Boolean valueOf = Boolean.valueOf(true);
                    try {
                        if (Log.isLoggable("WearableClient", 3)) {
                            Log.d("WearableClient", "processAssets: closing: " + parcelFileDescriptor);
                        }
                        autoCloseOutputStream.close();
                        return valueOf;
                    } catch (IOException e) {
                        return valueOf;
                    }
                } catch (IOException e2) {
                    Log.w("WearableClient", "processAssets: writing data failed: " + parcelFileDescriptor);
                    try {
                        if (Log.isLoggable("WearableClient", 3)) {
                            Log.d("WearableClient", "processAssets: closing: " + parcelFileDescriptor);
                        }
                        autoCloseOutputStream.close();
                    } catch (IOException e3) {
                    }
                    return Boolean.valueOf(false);
                } catch (Throwable th) {
                    try {
                        if (Log.isLoggable("WearableClient", 3)) {
                            Log.d("WearableClient", "processAssets: closing: " + parcelFileDescriptor);
                        }
                        autoCloseOutputStream.close();
                    } catch (IOException e4) {
                    }
                    throw th;
                }
            }
        });
    }

    /* renamed from: a */
    protected void mo2968a(int i, IBinder iBinder, Bundle bundle) {
        if (Log.isLoggable("WearableClient", 2)) {
            Log.d("WearableClient", "onPostInitHandler: statusCode " + i);
        }
        if (i == 0) {
            this.ayg.ca(iBinder);
            this.ayh.ca(iBinder);
            this.ayi.ca(iBinder);
        }
        super.mo2968a(i, iBinder, bundle);
    }

    /* renamed from: a */
    public void m4724a(C0155b<DataItemResult> c0155b, Uri uri) throws RemoteException {
        ((af) hw()).mo2615a(new C1601d(c0155b), uri);
    }

    /* renamed from: a */
    public void m4725a(C0155b<GetFdForAssetResult> c0155b, Asset asset) throws RemoteException {
        ((af) hw()).mo2616a(new C1603f(c0155b), asset);
    }

    /* renamed from: a */
    public void m4726a(C0155b<Status> c0155b, DataListener dataListener) throws RemoteException {
        this.ayg.m2317a(this, c0155b, dataListener);
    }

    /* renamed from: a */
    public void m4727a(C0155b<Status> c0155b, DataListener dataListener, IntentFilter[] intentFilterArr) throws RemoteException {
        this.ayg.m2318a(this, c0155b, dataListener, intentFilterArr);
    }

    /* renamed from: a */
    public void m4728a(C0155b<GetFdForAssetResult> c0155b, DataItemAsset dataItemAsset) throws RemoteException {
        m4725a((C0155b) c0155b, Asset.createFromRef(dataItemAsset.getId()));
    }

    /* renamed from: a */
    public void m4729a(C0155b<Status> c0155b, MessageListener messageListener) throws RemoteException {
        this.ayh.m2317a(this, c0155b, messageListener);
    }

    /* renamed from: a */
    public void m4730a(C0155b<Status> c0155b, MessageListener messageListener, IntentFilter[] intentFilterArr) throws RemoteException {
        this.ayh.m2318a(this, c0155b, messageListener, intentFilterArr);
    }

    /* renamed from: a */
    public void m4731a(C0155b<Status> c0155b, NodeListener nodeListener) throws RemoteException, RemoteException {
        this.ayi.m2318a(this, c0155b, nodeListener, null);
    }

    /* renamed from: a */
    public void m4732a(C0155b<DataItemResult> c0155b, PutDataRequest putDataRequest) throws RemoteException {
        for (Entry value : putDataRequest.getAssets().entrySet()) {
            Asset asset = (Asset) value.getValue();
            if (asset.getData() == null && asset.getDigest() == null && asset.getFd() == null && asset.getUri() == null) {
                throw new IllegalArgumentException("Put for " + putDataRequest.getUri() + " contains invalid asset: " + asset);
            }
        }
        PutDataRequest k = PutDataRequest.m3850k(putDataRequest.getUri());
        k.setData(putDataRequest.getData());
        List arrayList = new ArrayList();
        for (Entry value2 : putDataRequest.getAssets().entrySet()) {
            Asset asset2 = (Asset) value2.getValue();
            if (asset2.getData() == null) {
                k.putAsset((String) value2.getKey(), (Asset) value2.getValue());
            } else {
                try {
                    ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                    if (Log.isLoggable("WearableClient", 3)) {
                        Log.d("WearableClient", "processAssets: replacing data with FD in asset: " + asset2 + " read:" + createPipe[0] + " write:" + createPipe[1]);
                    }
                    k.putAsset((String) value2.getKey(), Asset.createFromFd(createPipe[0]));
                    Runnable a = m4722a(createPipe[1], asset2.getData());
                    arrayList.add(a);
                    this.asJ.submit(a);
                } catch (Throwable e) {
                    throw new IllegalStateException("Unable to create ParcelFileDescriptor for asset in request: " + putDataRequest, e);
                }
            }
        }
        try {
            ((af) hw()).mo2617a(new C1605i(c0155b, arrayList), k);
        } catch (Throwable e2) {
            throw new IllegalStateException("Unable to putDataItem: " + putDataRequest, e2);
        }
    }

    /* renamed from: a */
    public void m4733a(C0155b<SendMessageResult> c0155b, String str, String str2, byte[] bArr) throws RemoteException {
        ((af) hw()).mo2622a(new C1606j(c0155b), str, str2, bArr);
    }

    /* renamed from: a */
    protected void mo2969a(jt jtVar, C1399e c1399e) throws RemoteException {
        jtVar.mo1881e(c1399e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName());
    }

    /* renamed from: b */
    public void m4735b(C0155b<DataItemBuffer> c0155b, Uri uri) throws RemoteException {
        ((af) hw()).mo2624b(new C1602e(c0155b), uri);
    }

    /* renamed from: b */
    public void m4736b(C0155b<Status> c0155b, NodeListener nodeListener) throws RemoteException {
        this.ayi.m2317a(this, c0155b, nodeListener);
    }

    protected String bK() {
        return "com.google.android.gms.wearable.BIND";
    }

    protected String bL() {
        return "com.google.android.gms.wearable.internal.IWearableService";
    }

    /* renamed from: c */
    public void m4737c(C0155b<DeleteDataItemsResult> c0155b, Uri uri) throws RemoteException {
        ((af) hw()).mo2628c(new C1599b(c0155b), uri);
    }

    protected af cb(IBinder iBinder) {
        return C1267a.bZ(iBinder);
    }

    public void disconnect() {
        this.ayg.m2319b(this);
        this.ayh.m2319b(this);
        this.ayi.m2319b(this);
        super.disconnect();
    }

    /* renamed from: l */
    protected /* synthetic */ IInterface mo2972l(IBinder iBinder) {
        return cb(iBinder);
    }

    /* renamed from: n */
    public void m4739n(C0155b<DataItemBuffer> c0155b) throws RemoteException {
        ((af) hw()).mo2623b(new C1602e(c0155b));
    }

    /* renamed from: o */
    public void m4740o(C0155b<GetLocalNodeResult> c0155b) throws RemoteException {
        ((af) hw()).mo2627c(new C1604g(c0155b));
    }

    /* renamed from: p */
    public void m4741p(C0155b<GetConnectedNodesResult> c0155b) throws RemoteException {
        ((af) hw()).mo2630d(new C1600c(c0155b));
    }
}
