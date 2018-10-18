package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.jl.C1399e;
import com.google.android.gms.internal.oq.C1061a;
import com.google.android.gms.internal.os.C0495a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ox extends jl<oq> {
    private final String CS;
    private final ou anm;
    private final os ann = new os();
    private boolean ano = true;
    private final Object mH = new Object();

    public ox(Context context, ou ouVar) {
        super(context, ouVar, ouVar, new String[0]);
        this.CS = context.getPackageName();
        this.anm = (ou) jx.m1582i(ouVar);
        this.anm.m3510a(this);
    }

    /* renamed from: c */
    private void m4509c(ov ovVar, or orVar) {
        this.ann.m1767a(ovVar, orVar);
    }

    /* renamed from: d */
    private void m4510d(ov ovVar, or orVar) {
        try {
            or();
            ((oq) hw()).mo2054a(this.CS, ovVar, orVar);
        } catch (RemoteException e) {
            Log.e("PlayLoggerImpl", "Couldn't send log event.  Will try caching.");
            m4509c(ovVar, orVar);
        } catch (IllegalStateException e2) {
            Log.e("PlayLoggerImpl", "Service was disconnected.  Will try caching.");
            m4509c(ovVar, orVar);
        }
    }

    private void or() {
        je.m1495K(!this.ano);
        if (!this.ann.isEmpty()) {
            ov ovVar = null;
            try {
                List arrayList = new ArrayList();
                Iterator it = this.ann.op().iterator();
                while (it.hasNext()) {
                    C0495a c0495a = (C0495a) it.next();
                    if (c0495a.and != null) {
                        ((oq) hw()).mo2056a(this.CS, c0495a.anb, qw.m1906f(c0495a.and));
                    } else {
                        ov ovVar2;
                        if (c0495a.anb.equals(ovVar)) {
                            arrayList.add(c0495a.anc);
                            ovVar2 = ovVar;
                        } else {
                            if (!arrayList.isEmpty()) {
                                ((oq) hw()).mo2055a(this.CS, ovVar, arrayList);
                                arrayList.clear();
                            }
                            ov ovVar3 = c0495a.anb;
                            arrayList.add(c0495a.anc);
                            ovVar2 = ovVar3;
                        }
                        ovVar = ovVar2;
                    }
                }
                if (!arrayList.isEmpty()) {
                    ((oq) hw()).mo2055a(this.CS, ovVar, arrayList);
                }
                this.ann.clear();
            } catch (RemoteException e) {
                Log.e("PlayLoggerImpl", "Couldn't send cached log events to AndroidLog service.  Retaining in memory cache.");
            }
        }
    }

    /* renamed from: U */
    void m4511U(boolean z) {
        synchronized (this.mH) {
            boolean z2 = this.ano;
            this.ano = z;
            if (z2 && !this.ano) {
                or();
            }
        }
    }

    /* renamed from: a */
    protected void mo2969a(jt jtVar, C1399e c1399e) throws RemoteException {
        jtVar.mo1884f(c1399e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), new Bundle());
    }

    /* renamed from: b */
    public void m4513b(ov ovVar, or orVar) {
        synchronized (this.mH) {
            if (this.ano) {
                m4509c(ovVar, orVar);
            } else {
                m4510d(ovVar, orVar);
            }
        }
    }

    protected oq bJ(IBinder iBinder) {
        return C1061a.bI(iBinder);
    }

    protected String bK() {
        return "com.google.android.gms.playlog.service.START";
    }

    protected String bL() {
        return "com.google.android.gms.playlog.internal.IPlayLogService";
    }

    /* renamed from: l */
    protected /* synthetic */ IInterface mo2972l(IBinder iBinder) {
        return bJ(iBinder);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void start() {
        /*
        r3 = this;
        r1 = r3.mH;
        monitor-enter(r1);
        r0 = r3.isConnecting();	 Catch:{ all -> 0x001c }
        if (r0 != 0) goto L_0x000f;
    L_0x0009:
        r0 = r3.isConnected();	 Catch:{ all -> 0x001c }
        if (r0 == 0) goto L_0x0011;
    L_0x000f:
        monitor-exit(r1);	 Catch:{ all -> 0x001c }
    L_0x0010:
        return;
    L_0x0011:
        r0 = r3.anm;	 Catch:{ all -> 0x001c }
        r2 = 1;
        r0.m3509T(r2);	 Catch:{ all -> 0x001c }
        r3.connect();	 Catch:{ all -> 0x001c }
        monitor-exit(r1);	 Catch:{ all -> 0x001c }
        goto L_0x0010;
    L_0x001c:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001c }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ox.start():void");
    }

    public void stop() {
        synchronized (this.mH) {
            this.anm.m3509T(false);
            disconnect();
        }
    }
}
