package com.google.android.gms.fitness.service;

import android.os.RemoteException;
import com.google.android.gms.fitness.data.C0291k;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.internal.jx;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.service.b */
class C0888b implements SensorEventDispatcher {
    private final C0291k VW;

    C0888b(C0291k c0291k) {
        this.VW = (C0291k) jx.m1582i(c0291k);
    }

    public void publish(DataPoint dataPoint) throws RemoteException {
        this.VW.mo1160c(dataPoint);
    }

    public void publish(List<DataPoint> dataPoints) throws RemoteException {
        for (DataPoint publish : dataPoints) {
            publish(publish);
        }
    }
}
