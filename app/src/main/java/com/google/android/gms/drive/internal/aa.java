package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.drive.events.C0197c;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.CompletionListener;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.internal.ag.C0822a;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.List;

public class aa extends C0822a {
    private final int Pm;
    private final C0197c Qw;
    private final C0205a Qx;
    private final List<Integer> Qy = new ArrayList();

    /* renamed from: com.google.android.gms.drive.internal.aa$a */
    private static class C0205a extends Handler {
        private final Context mContext;

        private C0205a(Looper looper, Context context) {
            super(looper);
            this.mContext = context;
        }

        /* renamed from: a */
        public void m301a(C0197c c0197c, DriveEvent driveEvent) {
            sendMessage(obtainMessage(1, new Pair(c0197c, driveEvent)));
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Pair pair = (Pair) msg.obj;
                    C0197c c0197c = (C0197c) pair.first;
                    DriveEvent driveEvent = (DriveEvent) pair.second;
                    switch (driveEvent.getType()) {
                        case 1:
                            ((ChangeListener) c0197c).onChange((ChangeEvent) driveEvent);
                            return;
                        case 2:
                            ((CompletionListener) c0197c).onCompletion((CompletionEvent) driveEvent);
                            return;
                        default:
                            C0218w.m395o("EventCallback", "Unexpected event: " + driveEvent);
                            return;
                    }
                default:
                    C0218w.m393e(this.mContext, "EventCallback", "Don't know how to handle this event");
                    return;
            }
        }
    }

    public aa(Looper looper, Context context, int i, C0197c c0197c) {
        this.Pm = i;
        this.Qw = c0197c;
        this.Qx = new C0205a(looper, context);
    }

    public void bw(int i) {
        this.Qy.add(Integer.valueOf(i));
    }

    public boolean bx(int i) {
        return this.Qy.contains(Integer.valueOf(i));
    }

    /* renamed from: c */
    public void mo1019c(OnEventResponse onEventResponse) throws RemoteException {
        DriveEvent iQ = onEventResponse.iQ();
        jx.m1574K(this.Pm == iQ.getType());
        jx.m1574K(this.Qy.contains(Integer.valueOf(iQ.getType())));
        this.Qx.m301a(this.Qw, iQ);
    }
}
