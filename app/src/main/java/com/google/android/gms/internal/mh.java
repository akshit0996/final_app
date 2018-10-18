package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.C0877b;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.ad;
import com.google.android.gms.fitness.request.ah;
import com.google.android.gms.fitness.result.BleDevicesResult;
import com.google.android.gms.internal.lu.C1401b;
import com.google.android.gms.internal.lu.C1525a;
import com.google.android.gms.internal.lu.C1569c;
import com.google.android.gms.internal.mp.C1038a;

public class mh implements BleApi {

    /* renamed from: com.google.android.gms.internal.mh$a */
    private static class C1402a extends C1038a {
        private final C0155b<BleDevicesResult> Ea;

        private C1402a(C0155b<BleDevicesResult> c0155b) {
            this.Ea = c0155b;
        }

        /* renamed from: a */
        public void mo1981a(BleDevicesResult bleDevicesResult) {
            this.Ea.mo908b(bleDevicesResult);
        }
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient client, final BleDevice bleDevice) {
        return client.mo928b(new C1569c(this, client) {
            final /* synthetic */ mh UX;

            /* renamed from: a */
            protected void m5552a(lu luVar) throws RemoteException {
                luVar.jM().mo1933a(new C0877b(bleDevice), new C1401b(this), luVar.getContext().getPackageName());
            }
        });
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient client, final String deviceAddress) {
        return client.mo928b(new C1569c(this, client) {
            final /* synthetic */ mh UX;

            /* renamed from: a */
            protected void m5550a(lu luVar) throws RemoteException {
                luVar.jM().mo1933a(new C0877b(deviceAddress), new C1401b(this), luVar.getContext().getPackageName());
            }
        });
    }

    public PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient client) {
        return client.mo926a(new C1525a<BleDevicesResult>(this, client) {
            final /* synthetic */ mh UX;

            /* renamed from: a */
            protected void m5097a(lu luVar) throws RemoteException {
                luVar.jM().mo1943a(new C1402a(this), luVar.getContext().getPackageName());
            }

            /* renamed from: c */
            protected /* synthetic */ Result mo2958c(Status status) {
                return m5099v(status);
            }

            /* renamed from: v */
            protected BleDevicesResult m5099v(Status status) {
                return BleDevicesResult.m2711C(status);
            }
        });
    }

    public PendingResult<Status> startBleScan(GoogleApiClient client, final StartBleScanRequest request) {
        return client.mo926a(new C1569c(this, client) {
            final /* synthetic */ mh UX;

            /* renamed from: a */
            protected void m5546a(lu luVar) throws RemoteException {
                luVar.jM().mo1927a(request, new C1401b(this), luVar.getContext().getPackageName());
            }
        });
    }

    public PendingResult<Status> stopBleScan(GoogleApiClient client, final BleScanCallback requestCallback) {
        return client.mo926a(new C1569c(this, client) {
            final /* synthetic */ mh UX;

            /* renamed from: a */
            protected void m5548a(lu luVar) throws RemoteException {
                md c1401b = new C1401b(this);
                String packageName = luVar.getContext().getPackageName();
                luVar.jM().mo1929a(new ad(requestCallback), c1401b, packageName);
            }
        });
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient client, BleDevice bleDevice) {
        return unclaimBleDevice(client, bleDevice.getAddress());
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient client, final String deviceAddress) {
        return client.mo928b(new C1569c(this, client) {
            final /* synthetic */ mh UX;

            /* renamed from: a */
            protected void m5554a(lu luVar) throws RemoteException {
                luVar.jM().mo1931a(new ah(deviceAddress), new C1401b(this), luVar.getContext().getPackageName());
            }
        });
    }
}
