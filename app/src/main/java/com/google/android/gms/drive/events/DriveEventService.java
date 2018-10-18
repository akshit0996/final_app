package com.google.android.gms.drive.events;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.drive.internal.C0218w;
import com.google.android.gms.drive.internal.OnEventResponse;
import com.google.android.gms.drive.internal.ag.C0822a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class DriveEventService extends Service implements ChangeListener, CompletionListener {
    public static final String ACTION_HANDLE_EVENT = "com.google.android.gms.drive.events.HANDLE_EVENT";
    private CountDownLatch Pg;
    C0194a Ph;
    boolean Pi;
    int Pj;
    private final String mName;

    /* renamed from: com.google.android.gms.drive.events.DriveEventService$a */
    final class C0194a extends Handler {
        final /* synthetic */ DriveEventService Pl;

        C0194a(DriveEventService driveEventService) {
            this.Pl = driveEventService;
        }

        /* renamed from: b */
        private Message m286b(OnEventResponse onEventResponse) {
            return obtainMessage(1, onEventResponse);
        }

        private Message iE() {
            return obtainMessage(2);
        }

        public void handleMessage(Message msg) {
            C0218w.m394m("DriveEventService", "handleMessage message type:" + msg.what);
            switch (msg.what) {
                case 1:
                    this.Pl.m3946a((OnEventResponse) msg.obj);
                    return;
                case 2:
                    getLooper().quit();
                    return;
                default:
                    C0218w.m395o("DriveEventService", "Unexpected message type:" + msg.what);
                    return;
            }
        }
    }

    /* renamed from: com.google.android.gms.drive.events.DriveEventService$b */
    final class C1311b extends C0822a {
        final /* synthetic */ DriveEventService Pl;

        C1311b(DriveEventService driveEventService) {
            this.Pl = driveEventService;
        }

        /* renamed from: c */
        public void mo1019c(OnEventResponse onEventResponse) throws RemoteException {
            synchronized (this.Pl) {
                C0218w.m394m("DriveEventService", "onEvent: " + onEventResponse);
                this.Pl.iD();
                if (this.Pl.Ph != null) {
                    this.Pl.Ph.sendMessage(this.Pl.Ph.m286b(onEventResponse));
                } else {
                    C0218w.m396p("DriveEventService", "Receiving event before initialize is completed.");
                }
            }
        }
    }

    protected DriveEventService() {
        this("DriveEventService");
    }

    protected DriveEventService(String name) {
        this.Pi = false;
        this.Pj = -1;
        this.mName = name;
    }

    /* renamed from: a */
    private void m3946a(OnEventResponse onEventResponse) {
        DriveEvent iQ = onEventResponse.iQ();
        C0218w.m394m("DriveEventService", "handleEventMessage: " + iQ);
        try {
            switch (iQ.getType()) {
                case 1:
                    onChange((ChangeEvent) iQ);
                    return;
                case 2:
                    onCompletion((CompletionEvent) iQ);
                    return;
                default:
                    C0218w.m395o(this.mName, "Unhandled event: " + iQ);
                    return;
            }
        } catch (Throwable e) {
            C0218w.m392a(this.mName, e, "Error handling event: " + iQ);
        }
        C0218w.m392a(this.mName, e, "Error handling event: " + iQ);
    }

    private boolean bh(int i) {
        String str = GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE;
        String[] packagesForUid = getPackageManager().getPackagesForUid(i);
        if (packagesForUid == null) {
            return false;
        }
        for (Object equals : packagesForUid) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    private void iD() throws SecurityException {
        int callingUid = getCallingUid();
        if (callingUid != this.Pj) {
            if (GooglePlayServicesUtil.m137b(getPackageManager(), GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE) && bh(callingUid)) {
                this.Pj = callingUid;
                return;
            }
            throw new SecurityException("Caller is not GooglePlayServices");
        }
    }

    protected int getCallingUid() {
        return Binder.getCallingUid();
    }

    public final synchronized IBinder onBind(Intent intent) {
        IBinder asBinder;
        if (ACTION_HANDLE_EVENT.equals(intent.getAction())) {
            if (this.Ph == null && !this.Pi) {
                this.Pi = true;
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                this.Pg = new CountDownLatch(1);
                new Thread(this) {
                    final /* synthetic */ DriveEventService Pl;

                    public void run() {
                        try {
                            Looper.prepare();
                            this.Pl.Ph = new C0194a(this.Pl);
                            this.Pl.Pi = false;
                            countDownLatch.countDown();
                            C0218w.m394m("DriveEventService", "Bound and starting loop");
                            Looper.loop();
                            C0218w.m394m("DriveEventService", "Finished loop");
                        } finally {
                            if (this.Pl.Pg != null) {
                                this.Pl.Pg.countDown();
                            }
                        }
                    }
                }.start();
                try {
                    if (!countDownLatch.await(5000, TimeUnit.MILLISECONDS)) {
                        C0218w.m396p("DriveEventService", "Failed to synchronously initialize event handler.");
                    }
                } catch (Throwable e) {
                    throw new RuntimeException("Unable to start event handler", e);
                }
            }
            asBinder = new C1311b(this).asBinder();
        } else {
            asBinder = null;
        }
        return asBinder;
    }

    public void onChange(ChangeEvent event) {
        C0218w.m395o(this.mName, "Unhandled change event: " + event);
    }

    public void onCompletion(CompletionEvent event) {
        C0218w.m395o(this.mName, "Unhandled completion event: " + event);
    }

    public synchronized void onDestroy() {
        C0218w.m394m("DriveEventService", "onDestroy");
        if (this.Ph != null) {
            this.Ph.sendMessage(this.Ph.iE());
            this.Ph = null;
            try {
                if (!this.Pg.await(5000, TimeUnit.MILLISECONDS)) {
                    C0218w.m395o("DriveEventService", "Failed to synchronously quit event handler. Will quit itself");
                }
            } catch (InterruptedException e) {
            }
            this.Pg = null;
        }
        super.onDestroy();
    }

    public boolean onUnbind(Intent intent) {
        return true;
    }
}
