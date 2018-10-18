package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.AppStateManager.StateConflictResult;
import com.google.android.gms.appstate.AppStateManager.StateDeletedResult;
import com.google.android.gms.appstate.AppStateManager.StateListResult;
import com.google.android.gms.appstate.AppStateManager.StateLoadedResult;
import com.google.android.gms.appstate.AppStateManager.StateResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.C0801b;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.id.C0987a;
import com.google.android.gms.internal.jl.C1399e;

public final class ib extends jl<id> {
    private final String DZ;

    /* renamed from: com.google.android.gms.internal.ib$b */
    private static final class C1393b implements StateDeletedResult {
        private final Status Eb;
        private final int Ec;

        public C1393b(Status status, int i) {
            this.Eb = status;
            this.Ec = i;
        }

        public int getStateKey() {
            return this.Ec;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    /* renamed from: com.google.android.gms.internal.ib$d */
    private static final class C1394d extends C0801b implements StateListResult {
        private final AppStateBuffer Ed;

        public C1394d(DataHolder dataHolder) {
            super(dataHolder);
            this.Ed = new AppStateBuffer(dataHolder);
        }

        public AppStateBuffer getStateBuffer() {
            return this.Ed;
        }
    }

    /* renamed from: com.google.android.gms.internal.ib$f */
    private static final class C1395f extends C0801b implements StateConflictResult, StateLoadedResult, StateResult {
        private final int Ec;
        private final AppStateBuffer Ed;

        public C1395f(int i, DataHolder dataHolder) {
            super(dataHolder);
            this.Ec = i;
            this.Ed = new AppStateBuffer(dataHolder);
        }

        private boolean fN() {
            return this.Eb.getStatusCode() == 2000;
        }

        public StateConflictResult getConflictResult() {
            return fN() ? this : null;
        }

        public StateLoadedResult getLoadedResult() {
            return fN() ? null : this;
        }

        public byte[] getLocalData() {
            return this.Ed.getCount() == 0 ? null : this.Ed.get(0).getLocalData();
        }

        public String getResolvedVersion() {
            return this.Ed.getCount() == 0 ? null : this.Ed.get(0).getConflictVersion();
        }

        public byte[] getServerData() {
            return this.Ed.getCount() == 0 ? null : this.Ed.get(0).getConflictData();
        }

        public int getStateKey() {
            return this.Ec;
        }

        public void release() {
            this.Ed.release();
        }
    }

    /* renamed from: com.google.android.gms.internal.ib$a */
    private static final class C1512a extends ia {
        private final C0155b<StateDeletedResult> Ea;

        public C1512a(C0155b<StateDeletedResult> c0155b) {
            this.Ea = (C0155b) jx.m1578b((Object) c0155b, (Object) "Result holder must not be null");
        }

        /* renamed from: e */
        public void mo1824e(int i, int i2) {
            this.Ea.mo908b(new C1393b(new Status(i), i2));
        }
    }

    /* renamed from: com.google.android.gms.internal.ib$c */
    private static final class C1513c extends ia {
        private final C0155b<StateListResult> Ea;

        public C1513c(C0155b<StateListResult> c0155b) {
            this.Ea = (C0155b) jx.m1578b((Object) c0155b, (Object) "Result holder must not be null");
        }

        /* renamed from: a */
        public void mo1823a(DataHolder dataHolder) {
            this.Ea.mo908b(new C1394d(dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.ib$e */
    private static final class C1514e extends ia {
        private final C0155b<StateResult> Ea;

        public C1514e(C0155b<StateResult> c0155b) {
            this.Ea = (C0155b) jx.m1578b((Object) c0155b, (Object) "Result holder must not be null");
        }

        /* renamed from: a */
        public void mo1822a(int i, DataHolder dataHolder) {
            this.Ea.mo908b(new C1395f(i, dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.ib$g */
    private static final class C1515g extends ia {
        private final C0155b<Status> Ea;

        public C1515g(C0155b<Status> c0155b) {
            this.Ea = (C0155b) jx.m1578b((Object) c0155b, (Object) "Holder must not be null");
        }

        public void fK() {
            this.Ea.mo908b(new Status(0));
        }
    }

    public ib(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, String[] strArr) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, strArr);
        this.DZ = (String) jx.m1582i(str);
    }

    /* renamed from: H */
    protected id m4407H(IBinder iBinder) {
        return C0987a.m3263J(iBinder);
    }

    /* renamed from: a */
    public void m4408a(C0155b<StateListResult> c0155b) {
        try {
            ((id) hw()).mo1826a(new C1513c(c0155b));
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    /* renamed from: a */
    public void m4409a(C0155b<StateDeletedResult> c0155b, int i) {
        try {
            ((id) hw()).mo1831b(new C1512a(c0155b), i);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    /* renamed from: a */
    public void m4410a(C0155b<StateResult> c0155b, int i, String str, byte[] bArr) {
        try {
            ((id) hw()).mo1828a(new C1514e(c0155b), i, str, bArr);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    /* renamed from: a */
    public void m4411a(C0155b<StateResult> c0155b, int i, byte[] bArr) {
        if (c0155b == null) {
            ic icVar = null;
        } else {
            Object c1514e = new C1514e(c0155b);
        }
        try {
            ((id) hw()).mo1829a(icVar, i, bArr);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    /* renamed from: a */
    protected void mo2969a(jt jtVar, C1399e c1399e) throws RemoteException {
        jtVar.mo1868a((js) c1399e, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.DZ, hv());
    }

    /* renamed from: b */
    public void m4413b(C0155b<Status> c0155b) {
        try {
            ((id) hw()).mo1830b(new C1515g(c0155b));
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    /* renamed from: b */
    public void m4414b(C0155b<StateResult> c0155b, int i) {
        try {
            ((id) hw()).mo1827a(new C1514e(c0155b), i);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    protected String bK() {
        return "com.google.android.gms.appstate.service.START";
    }

    protected String bL() {
        return "com.google.android.gms.appstate.internal.IAppStateService";
    }

    /* renamed from: c */
    protected void mo3132c(String... strArr) {
        boolean z = false;
        for (String equals : strArr) {
            if (equals.equals(Scopes.APP_STATE)) {
                z = true;
            }
        }
        jx.m1576a(z, String.format("App State APIs requires %s to function.", new Object[]{Scopes.APP_STATE}));
    }

    public int fL() {
        try {
            return ((id) hw()).fL();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    public int fM() {
        try {
            return ((id) hw()).fM();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    /* renamed from: l */
    protected /* synthetic */ IInterface mo2972l(IBinder iBinder) {
        return m4407H(iBinder);
    }
}
