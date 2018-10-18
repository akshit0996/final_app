package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.google.android.gms.common.a */
public class C0151a implements ServiceConnection {
    boolean Is = false;
    private final BlockingQueue<IBinder> It = new LinkedBlockingQueue();

    public IBinder gs() throws InterruptedException {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("BlockingServiceConnection.getService() called on main thread");
        } else if (this.Is) {
            throw new IllegalStateException();
        } else {
            this.Is = true;
            return (IBinder) this.It.take();
        }
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        this.It.add(service);
    }

    public void onServiceDisconnected(ComponentName name) {
    }
}
