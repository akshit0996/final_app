package com.google.android.gms.drive.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.C0197c;
import com.google.android.gms.drive.events.C0198d;
import com.google.android.gms.drive.events.DriveEventService;
import com.google.android.gms.drive.internal.C0825p.C1644j;
import com.google.android.gms.drive.internal.C1499q.C1551a;
import com.google.android.gms.drive.internal.ae.C0818a;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jl.C1399e;
import com.google.android.gms.internal.js;
import com.google.android.gms.internal.jt;
import com.google.android.gms.internal.jx;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.drive.internal.r */
public class C1317r extends jl<ae> {
    private final String DZ;
    private final String JK;
    private final Bundle PK;
    private final boolean PL;
    private DriveId PM;
    private DriveId PN;
    final ConnectionCallbacks PO;
    final Map<DriveId, Map<C0197c, aa>> PP = new HashMap();

    public C1317r(Context context, Looper looper, jg jgVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String[] strArr, Bundle bundle) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, strArr);
        this.DZ = (String) jx.m1578b(jgVar.hm(), (Object) "Must call Api.ClientBuilder.setAccountName()");
        this.JK = jgVar.hq();
        this.PO = connectionCallbacks;
        this.PK = bundle;
        Intent intent = new Intent(DriveEventService.ACTION_HANDLE_EVENT);
        intent.setPackage(context.getPackageName());
        List queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        switch (queryIntentServices.size()) {
            case 0:
                this.PL = false;
                return;
            case 1:
                ServiceInfo serviceInfo = ((ResolveInfo) queryIntentServices.get(0)).serviceInfo;
                if (serviceInfo.exported) {
                    this.PL = true;
                    return;
                }
                throw new IllegalStateException("Drive event service " + serviceInfo.name + " must be exported in AndroidManifest.xml");
            default:
                throw new IllegalStateException("AndroidManifest.xml can only define one service that handles the " + intent.getAction() + " action");
        }
    }

    /* renamed from: W */
    protected ae m3968W(IBinder iBinder) {
        return C0818a.m2551X(iBinder);
    }

    /* renamed from: a */
    PendingResult<Status> m3969a(GoogleApiClient googleApiClient, final DriveId driveId, final int i) {
        jx.m1580b(C0198d.m291a(i, driveId), (Object) "id");
        jx.m1576a(isConnected(), "Client must be connected");
        if (this.PL) {
            return googleApiClient.mo928b(new C1551a(this, googleApiClient) {
                final /* synthetic */ C1317r PT;

                /* renamed from: a */
                protected void m5285a(C1317r c1317r) throws RemoteException {
                    c1317r.iG().mo973a(new AddEventListenerRequest(driveId, i), null, null, new bg(this));
                }
            });
        }
        throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to add event subscriptions");
    }

    /* renamed from: a */
    PendingResult<Status> m3970a(GoogleApiClient googleApiClient, DriveId driveId, int i, C0197c c0197c) {
        PendingResult<Status> c1644j;
        jx.m1580b(C0198d.m291a(i, driveId), (Object) "id");
        jx.m1578b((Object) c0197c, (Object) "listener");
        jx.m1576a(isConnected(), "Client must be connected");
        synchronized (this.PP) {
            Map map;
            aa aaVar;
            Map map2 = (Map) this.PP.get(driveId);
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                this.PP.put(driveId, hashMap);
                map = hashMap;
            } else {
                map = map2;
            }
            aa aaVar2 = (aa) map.get(c0197c);
            if (aaVar2 == null) {
                aaVar = new aa(getLooper(), getContext(), i, c0197c);
                map.put(c0197c, aaVar);
            } else if (aaVar2.bx(i)) {
                c1644j = new C1644j(googleApiClient, Status.Kw);
            } else {
                aaVar = aaVar2;
            }
            aaVar.bw(i);
            final DriveId driveId2 = driveId;
            final int i2 = i;
            c1644j = googleApiClient.mo928b(new C1551a(this, googleApiClient) {
                final /* synthetic */ C1317r PT;

                /* renamed from: a */
                protected void m5281a(C1317r c1317r) throws RemoteException {
                    c1317r.iG().mo973a(new AddEventListenerRequest(driveId2, i2), aaVar, null, new bg(this));
                }
            });
        }
        return c1644j;
    }

    /* renamed from: a */
    protected void mo2968a(int i, IBinder iBinder, Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.PM = (DriveId) bundle.getParcelable("com.google.android.gms.drive.root_id");
            this.PN = (DriveId) bundle.getParcelable("com.google.android.gms.drive.appdata_id");
        }
        super.mo2968a(i, iBinder, bundle);
    }

    /* renamed from: a */
    protected void mo2969a(jt jtVar, C1399e c1399e) throws RemoteException {
        String packageName = getContext().getPackageName();
        jx.m1582i(c1399e);
        jx.m1582i(packageName);
        jx.m1582i(hv());
        Bundle bundle = new Bundle();
        if (!packageName.equals(this.JK)) {
            bundle.putString("proxy_package_name", this.JK);
        }
        bundle.putAll(this.PK);
        jtVar.mo1872a((js) c1399e, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, packageName, hv(), this.DZ, bundle);
    }

    /* renamed from: b */
    PendingResult<Status> m3973b(GoogleApiClient googleApiClient, final DriveId driveId, final int i) {
        jx.m1580b(C0198d.m291a(i, driveId), (Object) "id");
        jx.m1576a(isConnected(), "Client must be connected");
        return googleApiClient.mo928b(new C1551a(this, googleApiClient) {
            final /* synthetic */ C1317r PT;

            /* renamed from: a */
            protected void m5287a(C1317r c1317r) throws RemoteException {
                c1317r.iG().mo990a(new RemoveEventListenerRequest(driveId, i), null, null, new bg(this));
            }
        });
    }

    /* renamed from: b */
    PendingResult<Status> m3974b(GoogleApiClient googleApiClient, DriveId driveId, int i, C0197c c0197c) {
        PendingResult<Status> c1644j;
        jx.m1580b(C0198d.m291a(i, driveId), (Object) "id");
        jx.m1576a(isConnected(), "Client must be connected");
        jx.m1578b((Object) c0197c, (Object) "listener");
        synchronized (this.PP) {
            Map map = (Map) this.PP.get(driveId);
            if (map == null) {
                c1644j = new C1644j(googleApiClient, Status.Kw);
            } else {
                final aa aaVar = (aa) map.remove(c0197c);
                if (aaVar == null) {
                    c1644j = new C1644j(googleApiClient, Status.Kw);
                } else {
                    if (map.isEmpty()) {
                        this.PP.remove(driveId);
                    }
                    final DriveId driveId2 = driveId;
                    final int i2 = i;
                    c1644j = googleApiClient.mo928b(new C1551a(this, googleApiClient) {
                        final /* synthetic */ C1317r PT;

                        /* renamed from: a */
                        protected void m5283a(C1317r c1317r) throws RemoteException {
                            c1317r.iG().mo990a(new RemoveEventListenerRequest(driveId2, i2), aaVar, null, new bg(this));
                        }
                    });
                }
            }
        }
        return c1644j;
    }

    protected String bK() {
        return "com.google.android.gms.drive.ApiService.START";
    }

    protected String bL() {
        return "com.google.android.gms.drive.internal.IDriveService";
    }

    PendingResult<Status> cancelPendingActions(GoogleApiClient apiClient, final List<String> pendingTags) {
        boolean z = true;
        jx.m1575L(pendingTags != null);
        if (pendingTags.isEmpty()) {
            z = false;
        }
        jx.m1575L(z);
        jx.m1576a(isConnected(), "Client must be connected");
        return apiClient.mo928b(new C1551a(this, apiClient) {
            final /* synthetic */ C1317r PT;

            /* renamed from: a */
            protected void m5289a(C1317r c1317r) throws RemoteException {
                c1317r.iG().mo975a(new CancelPendingActionsRequest(pendingTags), new bg(this));
            }
        });
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                ((ae) hw()).mo983a(new DisconnectRequest());
            } catch (RemoteException e) {
            }
        }
        super.disconnect();
        this.PP.clear();
    }

    public ae iG() throws DeadObjectException {
        return (ae) hw();
    }

    public DriveId iH() {
        return this.PM;
    }

    public DriveId iI() {
        return this.PN;
    }

    public boolean iJ() {
        return this.PL;
    }

    /* renamed from: l */
    protected /* synthetic */ IInterface mo2972l(IBinder iBinder) {
        return m3968W(iBinder);
    }
}
