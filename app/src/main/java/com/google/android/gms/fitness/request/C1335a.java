package com.google.android.gms.fitness.request;

import android.os.RemoteException;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.C0325l.C0881a;
import com.google.android.gms.internal.jx;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.fitness.request.a */
public class C1335a extends C0881a {
    private final BleScanCallback VC;

    /* renamed from: com.google.android.gms.fitness.request.a$a */
    public static class C0311a {
        private static final C0311a VD = new C0311a();
        private final Map<BleScanCallback, C1335a> VE = new HashMap();

        private C0311a() {
        }

        public static C0311a jP() {
            return VD;
        }

        /* renamed from: a */
        public C1335a m611a(BleScanCallback bleScanCallback) {
            C1335a c1335a;
            synchronized (this.VE) {
                c1335a = (C1335a) this.VE.get(bleScanCallback);
                if (c1335a == null) {
                    c1335a = new C1335a(bleScanCallback);
                    this.VE.put(bleScanCallback, c1335a);
                }
            }
            return c1335a;
        }

        /* renamed from: b */
        public C1335a m612b(BleScanCallback bleScanCallback) {
            C1335a c1335a;
            synchronized (this.VE) {
                c1335a = (C1335a) this.VE.get(bleScanCallback);
                if (c1335a != null) {
                } else {
                    c1335a = new C1335a(bleScanCallback);
                }
            }
            return c1335a;
        }
    }

    private C1335a(BleScanCallback bleScanCallback) {
        this.VC = (BleScanCallback) jx.m1582i(bleScanCallback);
    }

    public void onDeviceFound(BleDevice device) throws RemoteException {
        this.VC.onDeviceFound(device);
    }

    public void onScanStopped() throws RemoteException {
        this.VC.onScanStopped();
    }
}
