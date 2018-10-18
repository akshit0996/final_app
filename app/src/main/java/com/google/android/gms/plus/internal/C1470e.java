package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.jd;
import com.google.android.gms.internal.jj;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jl.C0476b;
import com.google.android.gms.internal.jl.C1000d;
import com.google.android.gms.internal.jl.C1399e;
import com.google.android.gms.internal.jr;
import com.google.android.gms.internal.js;
import com.google.android.gms.internal.jt;
import com.google.android.gms.internal.ky;
import com.google.android.gms.internal.lm;
import com.google.android.gms.internal.pf;
import com.google.android.gms.internal.pi;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.internal.C0595d.C1200a;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/* renamed from: com.google.android.gms.plus.internal.e */
public class C1470e extends jl<C0595d> {
    private Person anG;
    private final C1204h anH;

    /* renamed from: com.google.android.gms.plus.internal.e$d */
    final class C1201d extends C0476b<C0155b<Status>> {
        private final Status Eb;
        final /* synthetic */ C1470e anJ;

        public C1201d(C1470e c1470e, C0155b<Status> c0155b, Status status) {
            this.anJ = c1470e;
            super(c1470e, c0155b);
            this.Eb = status;
        }

        /* renamed from: g */
        protected /* synthetic */ void mo1853g(Object obj) {
            m3661m((C0155b) obj);
        }

        protected void hx() {
        }

        /* renamed from: m */
        protected void m3661m(C0155b<Status> c0155b) {
            if (c0155b != null) {
                c0155b.mo908b(this.Eb);
            }
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e$h */
    final class C1202h extends C0476b<C0155b<Status>> {
        private final Status Eb;
        final /* synthetic */ C1470e anJ;

        public C1202h(C1470e c1470e, C0155b<Status> c0155b, Status status) {
            this.anJ = c1470e;
            super(c1470e, c0155b);
            this.Eb = status;
        }

        /* renamed from: g */
        protected /* synthetic */ void mo1853g(Object obj) {
            m3663m((C0155b) obj);
        }

        protected void hx() {
        }

        /* renamed from: m */
        protected void m3663m(C0155b<Status> c0155b) {
            this.anJ.disconnect();
            if (c0155b != null) {
                c0155b.mo908b(this.Eb);
            }
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e$c */
    final class C1468c extends C1000d<C0155b<LoadMomentsResult>> implements LoadMomentsResult {
        private final Status Eb;
        private final String OB;
        final /* synthetic */ C1470e anJ;
        private final String anK;
        private MomentBuffer anL;

        public C1468c(C1470e c1470e, C0155b<LoadMomentsResult> c0155b, Status status, DataHolder dataHolder, String str, String str2) {
            this.anJ = c1470e;
            super(c1470e, c0155b, dataHolder);
            this.Eb = status;
            this.OB = str;
            this.anK = str2;
        }

        /* renamed from: a */
        protected void m4640a(C0155b<LoadMomentsResult> c0155b, DataHolder dataHolder) {
            this.anL = dataHolder != null ? new MomentBuffer(dataHolder) : null;
            c0155b.mo908b(this);
        }

        /* renamed from: b */
        protected /* synthetic */ void mo3605b(Object obj, DataHolder dataHolder) {
            m4640a((C0155b) obj, dataHolder);
        }

        public MomentBuffer getMomentBuffer() {
            return this.anL;
        }

        public String getNextPageToken() {
            return this.OB;
        }

        public Status getStatus() {
            return this.Eb;
        }

        public String getUpdated() {
            return this.anK;
        }

        public void release() {
            if (this.anL != null) {
                this.anL.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e$f */
    final class C1469f extends C1000d<C0155b<LoadPeopleResult>> implements LoadPeopleResult {
        private final Status Eb;
        private final String OB;
        final /* synthetic */ C1470e anJ;
        private PersonBuffer anM;

        public C1469f(C1470e c1470e, C0155b<LoadPeopleResult> c0155b, Status status, DataHolder dataHolder, String str) {
            this.anJ = c1470e;
            super(c1470e, c0155b, dataHolder);
            this.Eb = status;
            this.OB = str;
        }

        /* renamed from: a */
        protected void m4642a(C0155b<LoadPeopleResult> c0155b, DataHolder dataHolder) {
            this.anM = dataHolder != null ? new PersonBuffer(dataHolder) : null;
            c0155b.mo908b(this);
        }

        /* renamed from: b */
        protected /* synthetic */ void mo3605b(Object obj, DataHolder dataHolder) {
            m4642a((C0155b) obj, dataHolder);
        }

        public String getNextPageToken() {
            return this.OB;
        }

        public PersonBuffer getPersonBuffer() {
            return this.anM;
        }

        public Status getStatus() {
            return this.Eb;
        }

        public void release() {
            if (this.anM != null) {
                this.anM.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e$a */
    final class C1532a extends C1467a {
        private final C0155b<Status> anI;
        final /* synthetic */ C1470e anJ;

        public C1532a(C1470e c1470e, C0155b<Status> c0155b) {
            this.anJ = c1470e;
            this.anI = c0155b;
        }

        public void aA(Status status) {
            this.anJ.m3310a(new C1201d(this.anJ, this.anI, status));
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e$b */
    final class C1533b extends C1467a {
        private final C0155b<LoadMomentsResult> anI;
        final /* synthetic */ C1470e anJ;

        public C1533b(C1470e c1470e, C0155b<LoadMomentsResult> c0155b) {
            this.anJ = c1470e;
            this.anI = c0155b;
        }

        /* renamed from: a */
        public void mo2477a(DataHolder dataHolder, String str, String str2) {
            DataHolder dataHolder2;
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.gV() != null ? (PendingIntent) dataHolder.gV().getParcelable("pendingIntent") : null);
            if (status.isSuccess() || dataHolder == null) {
                dataHolder2 = dataHolder;
            } else {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder2 = null;
            }
            this.anJ.m3310a(new C1468c(this.anJ, this.anI, status, dataHolder2, str, str2));
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e$e */
    final class C1534e extends C1467a {
        private final C0155b<LoadPeopleResult> anI;
        final /* synthetic */ C1470e anJ;

        public C1534e(C1470e c1470e, C0155b<LoadPeopleResult> c0155b) {
            this.anJ = c1470e;
            this.anI = c0155b;
        }

        /* renamed from: a */
        public void mo2476a(DataHolder dataHolder, String str) {
            DataHolder dataHolder2;
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.gV() != null ? (PendingIntent) dataHolder.gV().getParcelable("pendingIntent") : null);
            if (status.isSuccess() || dataHolder == null) {
                dataHolder2 = dataHolder;
            } else {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder2 = null;
            }
            this.anJ.m3310a(new C1469f(this.anJ, this.anI, status, dataHolder2, str));
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e$g */
    final class C1535g extends C1467a {
        private final C0155b<Status> anI;
        final /* synthetic */ C1470e anJ;

        public C1535g(C1470e c1470e, C0155b<Status> c0155b) {
            this.anJ = c1470e;
            this.anI = c0155b;
        }

        /* renamed from: h */
        public void mo2481h(int i, Bundle bundle) {
            this.anJ.m3310a(new C1202h(this.anJ, this.anI, new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null)));
        }
    }

    public C1470e(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, C1204h c1204h) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, c1204h.oz());
        this.anH = c1204h;
    }

    /* renamed from: a */
    public jr m4644a(C0155b<LoadPeopleResult> c0155b, int i, String str) {
        dS();
        Object c1534e = new C1534e(this, c0155b);
        try {
            return ((C0595d) hw()).mo2484a(c1534e, 1, i, -1, str);
        } catch (RemoteException e) {
            c1534e.mo2476a(DataHolder.av(8), null);
            return null;
        }
    }

    /* renamed from: a */
    protected void mo2968a(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 && bundle != null && bundle.containsKey("loaded_person")) {
            this.anG = pi.m4537i(bundle.getByteArray("loaded_person"));
        }
        super.mo2968a(i, iBinder, bundle);
    }

    /* renamed from: a */
    public void m4646a(C0155b<LoadMomentsResult> c0155b, int i, String str, Uri uri, String str2, String str3) {
        dS();
        Object c1533b = c0155b != null ? new C1533b(this, c0155b) : null;
        try {
            ((C0595d) hw()).mo2487a(c1533b, i, str, uri, str2, str3);
        } catch (RemoteException e) {
            c1533b.mo2477a(DataHolder.av(8), null, null);
        }
    }

    /* renamed from: a */
    public void m4647a(C0155b<Status> c0155b, Moment moment) {
        dS();
        C0593b c1532a = c0155b != null ? new C1532a(this, c0155b) : null;
        try {
            ((C0595d) hw()).mo2489a(c1532a, ky.m3391a((pf) moment));
        } catch (Throwable e) {
            if (c1532a == null) {
                throw new IllegalStateException(e);
            }
            c1532a.aA(new Status(8, null, null));
        }
    }

    /* renamed from: a */
    public void m4648a(C0155b<LoadPeopleResult> c0155b, Collection<String> collection) {
        dS();
        C0593b c1534e = new C1534e(this, c0155b);
        try {
            ((C0595d) hw()).mo2492a(c1534e, new ArrayList(collection));
        } catch (RemoteException e) {
            c1534e.mo2476a(DataHolder.av(8), null);
        }
    }

    /* renamed from: a */
    protected void mo2969a(jt jtVar, C1399e c1399e) throws RemoteException {
        Bundle oH = this.anH.oH();
        oH.putStringArray("request_visible_actions", this.anH.oA());
        oH.putString("auth_package", this.anH.oC());
        jtVar.mo1873a((js) c1399e, new jj(2).aX(this.anH.oD()).m3292a(jd.aT(this.anH.getAccountName())).m3293a(lm.m1647d(hv())).m3294e(oH));
    }

    protected String bK() {
        return "com.google.android.gms.plus.service.START";
    }

    protected String bL() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    protected C0595d bN(IBinder iBinder) {
        return C1200a.bM(iBinder);
    }

    public boolean cj(String str) {
        return Arrays.asList(hv()).contains(str);
    }

    public void clearDefaultAccount() {
        dS();
        try {
            this.anG = null;
            ((C0595d) hw()).clearDefaultAccount();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    /* renamed from: d */
    public void m4650d(C0155b<LoadPeopleResult> c0155b, String[] strArr) {
        m4648a((C0155b) c0155b, Arrays.asList(strArr));
    }

    public String getAccountName() {
        dS();
        try {
            return ((C0595d) hw()).getAccountName();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public Person getCurrentPerson() {
        dS();
        return this.anG;
    }

    /* renamed from: j */
    public void m4651j(C0155b<LoadMomentsResult> c0155b) {
        m4646a(c0155b, 20, null, null, null, "me");
    }

    /* renamed from: k */
    public void m4652k(C0155b<LoadPeopleResult> c0155b) {
        dS();
        Object c1534e = new C1534e(this, c0155b);
        try {
            ((C0595d) hw()).mo2484a(c1534e, 2, 1, -1, null);
        } catch (RemoteException e) {
            c1534e.mo2476a(DataHolder.av(8), null);
        }
    }

    /* renamed from: l */
    protected /* synthetic */ IInterface mo2972l(IBinder iBinder) {
        return bN(iBinder);
    }

    /* renamed from: l */
    public void m4654l(C0155b<Status> c0155b) {
        dS();
        clearDefaultAccount();
        Object c1535g = new C1535g(this, c0155b);
        try {
            ((C0595d) hw()).mo2494b(c1535g);
        } catch (RemoteException e) {
            c1535g.mo2481h(8, null);
        }
    }

    /* renamed from: q */
    public jr m4655q(C0155b<LoadPeopleResult> c0155b, String str) {
        return m4644a((C0155b) c0155b, 0, str);
    }

    public void removeMoment(String momentId) {
        dS();
        try {
            ((C0595d) hw()).removeMoment(momentId);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
