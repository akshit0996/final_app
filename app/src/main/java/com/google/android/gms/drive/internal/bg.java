package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.Status;

public class bg extends C1312c {
    private final C0155b<Status> Ea;

    public bg(C0155b<Status> c0155b) {
        this.Ea = c0155b;
    }

    /* renamed from: n */
    public void mo1017n(Status status) throws RemoteException {
        this.Ea.mo908b(status);
    }

    public void onSuccess() throws RemoteException {
        this.Ea.mo908b(Status.Kw);
    }
}
