package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.op.C0493a;

public class ou implements ConnectionCallbacks, OnConnectionFailedListener {
    private ox amU = null;
    private final C0493a ane;
    private boolean anf = true;

    public ou(C0493a c0493a) {
        this.ane = c0493a;
    }

    /* renamed from: T */
    public void m3509T(boolean z) {
        this.anf = z;
    }

    /* renamed from: a */
    public void m3510a(ox oxVar) {
        this.amU = oxVar;
    }

    public void onConnected(Bundle connectionHint) {
        this.amU.m4511U(false);
        if (this.anf && this.ane != null) {
            this.ane.on();
        }
        this.anf = false;
    }

    public void onConnectionFailed(ConnectionResult result) {
        this.amU.m4511U(true);
        if (this.anf && this.ane != null) {
            if (result.hasResolution()) {
                this.ane.mo2051d(result.getResolution());
            } else {
                this.ane.oo();
            }
        }
        this.anf = false;
    }

    public void onDisconnected() {
        this.amU.m4511U(true);
    }
}
