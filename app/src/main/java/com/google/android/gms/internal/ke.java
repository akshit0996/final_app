package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.kf.C1561a;

public final class ke implements kd {

    /* renamed from: com.google.android.gms.internal.ke$a */
    private static class C1517a extends kb {
        private final C0155b<Status> Ea;

        public C1517a(C0155b<Status> c0155b) {
            this.Ea = c0155b;
        }

        public void aI(int i) throws RemoteException {
            this.Ea.mo908b(new Status(i));
        }
    }

    /* renamed from: c */
    public PendingResult<Status> mo1906c(GoogleApiClient googleApiClient) {
        return new C1561a(this, googleApiClient) {
            final /* synthetic */ ke Nv;

            /* renamed from: a */
            protected void m5544a(kg kgVar) throws RemoteException {
                ((ki) kgVar.hw()).mo1908a(new C1517a(this));
            }
        }.gE();
    }
}
