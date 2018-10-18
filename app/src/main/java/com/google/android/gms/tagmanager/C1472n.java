package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tagmanager.ContainerHolder.ContainerAvailableListener;

/* renamed from: com.google.android.gms.tagmanager.n */
class C1472n implements ContainerHolder {
    private Status Eb;
    private final Looper JF;
    private boolean Pf;
    private Container aqu;
    private Container aqv;
    private C0643b aqw;
    private C0642a aqx;
    private TagManager aqy;

    /* renamed from: com.google.android.gms.tagmanager.n$a */
    public interface C0642a {
        void ct(String str);

        String pl();

        void pn();
    }

    /* renamed from: com.google.android.gms.tagmanager.n$b */
    private class C0643b extends Handler {
        final /* synthetic */ C1472n aqA;
        private final ContainerAvailableListener aqz;

        public C0643b(C1472n c1472n, ContainerAvailableListener containerAvailableListener, Looper looper) {
            this.aqA = c1472n;
            super(looper);
            this.aqz = containerAvailableListener;
        }

        public void cu(String str) {
            sendMessage(obtainMessage(1, str));
        }

        protected void cv(String str) {
            this.aqz.onContainerAvailable(this.aqA, str);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    cv((String) msg.obj);
                    return;
                default:
                    bh.m2114T("Don't know how to handle this message.");
                    return;
            }
        }
    }

    public C1472n(Status status) {
        this.Eb = status;
        this.JF = null;
    }

    public C1472n(TagManager tagManager, Looper looper, Container container, C0642a c0642a) {
        this.aqy = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.JF = looper;
        this.aqu = container;
        this.aqx = c0642a;
        this.Eb = Status.Kw;
        tagManager.m2087a(this);
    }

    private void pm() {
        if (this.aqw != null) {
            this.aqw.cu(this.aqv.pj());
        }
    }

    /* renamed from: a */
    public synchronized void m4685a(Container container) {
        if (!this.Pf) {
            if (container == null) {
                bh.m2114T("Unexpected null container.");
            } else {
                this.aqv = container;
                pm();
            }
        }
    }

    public synchronized void cr(String str) {
        if (!this.Pf) {
            this.aqu.cr(str);
        }
    }

    void ct(String str) {
        if (this.Pf) {
            bh.m2114T("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        } else {
            this.aqx.ct(str);
        }
    }

    public synchronized Container getContainer() {
        Container container = null;
        synchronized (this) {
            if (this.Pf) {
                bh.m2114T("ContainerHolder is released.");
            } else {
                if (this.aqv != null) {
                    this.aqu = this.aqv;
                    this.aqv = null;
                }
                container = this.aqu;
            }
        }
        return container;
    }

    String getContainerId() {
        if (!this.Pf) {
            return this.aqu.getContainerId();
        }
        bh.m2114T("getContainerId called on a released ContainerHolder.");
        return "";
    }

    public Status getStatus() {
        return this.Eb;
    }

    String pl() {
        if (!this.Pf) {
            return this.aqx.pl();
        }
        bh.m2114T("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        return "";
    }

    public synchronized void refresh() {
        if (this.Pf) {
            bh.m2114T("Refreshing a released ContainerHolder.");
        } else {
            this.aqx.pn();
        }
    }

    public synchronized void release() {
        if (this.Pf) {
            bh.m2114T("Releasing a released ContainerHolder.");
        } else {
            this.Pf = true;
            this.aqy.m2088b(this);
            this.aqu.release();
            this.aqu = null;
            this.aqv = null;
            this.aqx = null;
            this.aqw = null;
        }
    }

    public synchronized void setContainerAvailableListener(ContainerAvailableListener listener) {
        if (this.Pf) {
            bh.m2114T("ContainerHolder is released.");
        } else if (listener == null) {
            this.aqw = null;
        } else {
            this.aqw = new C0643b(this, listener, this.JF);
            if (this.aqv != null) {
                pm();
            }
        }
    }
}
