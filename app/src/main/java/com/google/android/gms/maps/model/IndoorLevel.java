package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.model.internal.C0566k;

public final class IndoorLevel {
    private final C0566k amj;

    public IndoorLevel(C0566k delegate) {
        this.amj = (C0566k) jx.m1582i(delegate);
    }

    public void activate() {
        try {
            this.amj.activate();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean equals(Object other) {
        if (!(other instanceof IndoorLevel)) {
            return false;
        }
        try {
            return this.amj.mo2405a(((IndoorLevel) other).amj);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getName() {
        try {
            return this.amj.getName();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getShortName() {
        try {
            return this.amj.getShortName();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.amj.hashCodeRemote();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
