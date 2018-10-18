package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.jl.C0477f;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class jn implements Callback {
    private static final Object Nd = new Object();
    private static jn Ne;
    private final HashMap<String, C0481a> Nf = new HashMap();
    private final Handler mHandler;
    private final Context mO;

    /* renamed from: com.google.android.gms.internal.jn$a */
    final class C0481a {
        private final String Ng;
        private final C0480a Nh = new C0480a(this);
        private final HashSet<C0477f> Ni = new HashSet();
        private boolean Nj;
        private IBinder Nk;
        private ComponentName Nl;
        final /* synthetic */ jn Nm;
        private int mState = 2;

        /* renamed from: com.google.android.gms.internal.jn$a$a */
        public class C0480a implements ServiceConnection {
            final /* synthetic */ C0481a Nn;

            public C0480a(C0481a c0481a) {
                this.Nn = c0481a;
            }

            public void onServiceConnected(ComponentName component, IBinder binder) {
                synchronized (this.Nn.Nm.Nf) {
                    this.Nn.Nk = binder;
                    this.Nn.Nl = component;
                    Iterator it = this.Nn.Ni.iterator();
                    while (it.hasNext()) {
                        ((C0477f) it.next()).onServiceConnected(component, binder);
                    }
                    this.Nn.mState = 1;
                }
            }

            public void onServiceDisconnected(ComponentName component) {
                synchronized (this.Nn.Nm.Nf) {
                    this.Nn.Nk = null;
                    this.Nn.Nl = component;
                    Iterator it = this.Nn.Ni.iterator();
                    while (it.hasNext()) {
                        ((C0477f) it.next()).onServiceDisconnected(component);
                    }
                    this.Nn.mState = 2;
                }
            }
        }

        public C0481a(jn jnVar, String str) {
            this.Nm = jnVar;
            this.Ng = str;
        }

        /* renamed from: a */
        public void m1509a(C0477f c0477f) {
            this.Ni.add(c0477f);
        }

        /* renamed from: b */
        public void m1510b(C0477f c0477f) {
            this.Ni.remove(c0477f);
        }

        /* renamed from: c */
        public boolean m1511c(C0477f c0477f) {
            return this.Ni.contains(c0477f);
        }

        public IBinder getBinder() {
            return this.Nk;
        }

        public ComponentName getComponentName() {
            return this.Nl;
        }

        public int getState() {
            return this.mState;
        }

        public void hA() {
            this.Nj = this.Nm.mO.bindService(new Intent(this.Ng).setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE), this.Nh, 129);
            if (this.Nj) {
                this.mState = 3;
            } else {
                this.Nm.mO.unbindService(this.Nh);
            }
        }

        public void hB() {
            this.Nm.mO.unbindService(this.Nh);
            this.Nj = false;
            this.mState = 2;
        }

        public String hC() {
            return this.Ng;
        }

        public boolean hD() {
            return this.Ni.isEmpty();
        }

        public boolean isBound() {
            return this.Nj;
        }
    }

    private jn(Context context) {
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.mO = context.getApplicationContext();
    }

    /* renamed from: J */
    public static jn m1512J(Context context) {
        synchronized (Nd) {
            if (Ne == null) {
                Ne = new jn(context.getApplicationContext());
            }
        }
        return Ne;
    }

    /* renamed from: a */
    public boolean m1515a(String str, C0477f c0477f) {
        boolean isBound;
        synchronized (this.Nf) {
            C0481a c0481a = (C0481a) this.Nf.get(str);
            if (c0481a != null) {
                this.mHandler.removeMessages(0, c0481a);
                if (!c0481a.m1511c(c0477f)) {
                    c0481a.m1509a((C0477f) c0477f);
                    switch (c0481a.getState()) {
                        case 1:
                            c0477f.onServiceConnected(c0481a.getComponentName(), c0481a.getBinder());
                            break;
                        case 2:
                            c0481a.hA();
                            break;
                        default:
                            break;
                    }
                }
                throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=" + str);
            }
            c0481a = new C0481a(this, str);
            c0481a.m1509a((C0477f) c0477f);
            c0481a.hA();
            this.Nf.put(str, c0481a);
            isBound = c0481a.isBound();
        }
        return isBound;
    }

    /* renamed from: b */
    public void m1516b(String str, C0477f c0477f) {
        synchronized (this.Nf) {
            C0481a c0481a = (C0481a) this.Nf.get(str);
            if (c0481a == null) {
                throw new IllegalStateException("Nonexistent connection status for service action: " + str);
            } else if (c0481a.m1511c(c0477f)) {
                c0481a.m1510b(c0477f);
                if (c0481a.hD()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, c0481a), 5000);
                }
            } else {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=" + str);
            }
        }
    }

    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case 0:
                C0481a c0481a = (C0481a) msg.obj;
                synchronized (this.Nf) {
                    if (c0481a.hD()) {
                        c0481a.hB();
                        this.Nf.remove(c0481a.hC());
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
