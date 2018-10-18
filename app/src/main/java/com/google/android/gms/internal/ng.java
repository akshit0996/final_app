package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.C1086c.C0518a;
import com.google.android.gms.location.C1086c.C0519b;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GeofencingRequest.Builder;
import com.google.android.gms.location.LocationServices.C1530a;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.List;

public class ng implements GeofencingApi {

    /* renamed from: com.google.android.gms.internal.ng$a */
    private static abstract class C1582a extends C1530a<Status> {
        public C1582a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: b */
        public Status m5140b(Status status) {
            return status;
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m5140b(status);
        }
    }

    public PendingResult<Status> addGeofences(GoogleApiClient client, final GeofencingRequest geofencingRequest, final PendingIntent pendingIntent) {
        return client.mo928b(new C1582a(this, client) {
            final /* synthetic */ ng agN;

            /* renamed from: com.google.android.gms.internal.ng$1$1 */
            class C10451 implements C0518a {
                final /* synthetic */ C17651 agO;

                C10451(C17651 c17651) {
                    this.agO = c17651;
                }

                /* renamed from: a */
                public void mo1996a(int i, String[] strArr) {
                    this.agO.m2447b(LocationStatusCodes.eD(i));
                }
            }

            /* renamed from: a */
            protected void m5592a(nk nkVar) throws RemoteException {
                nkVar.m4947a(geofencingRequest, pendingIntent, new C10451(this));
            }
        });
    }

    @Deprecated
    public PendingResult<Status> addGeofences(GoogleApiClient client, List<Geofence> geofences, PendingIntent pendingIntent) {
        Builder builder = new Builder();
        builder.addGeofences(geofences);
        builder.setInitialTrigger(5);
        return addGeofences(client, builder.build(), pendingIntent);
    }

    public PendingResult<Status> removeGeofences(GoogleApiClient client, final PendingIntent pendingIntent) {
        return client.mo928b(new C1582a(this, client) {
            final /* synthetic */ ng agN;

            /* renamed from: com.google.android.gms.internal.ng$2$1 */
            class C10461 implements C0519b {
                final /* synthetic */ C17662 agP;

                C10461(C17662 c17662) {
                    this.agP = c17662;
                }

                /* renamed from: a */
                public void mo1997a(int i, PendingIntent pendingIntent) {
                    this.agP.m2447b(LocationStatusCodes.eD(i));
                }

                /* renamed from: b */
                public void mo1998b(int i, String[] strArr) {
                    Log.wtf("GeofencingImpl", "Request ID callback shouldn't have been called");
                }
            }

            /* renamed from: a */
            protected void m5594a(nk nkVar) throws RemoteException {
                nkVar.m4946a(pendingIntent, new C10461(this));
            }
        });
    }

    public PendingResult<Status> removeGeofences(GoogleApiClient client, final List<String> geofenceRequestIds) {
        return client.mo928b(new C1582a(this, client) {
            final /* synthetic */ ng agN;

            /* renamed from: com.google.android.gms.internal.ng$3$1 */
            class C10471 implements C0519b {
                final /* synthetic */ C17673 agR;

                C10471(C17673 c17673) {
                    this.agR = c17673;
                }

                /* renamed from: a */
                public void mo1997a(int i, PendingIntent pendingIntent) {
                    Log.wtf("GeofencingImpl", "PendingIntent callback shouldn't have been called");
                }

                /* renamed from: b */
                public void mo1998b(int i, String[] strArr) {
                    this.agR.m2447b(LocationStatusCodes.eD(i));
                }
            }

            /* renamed from: a */
            protected void m5596a(nk nkVar) throws RemoteException {
                nkVar.m4950a(geofenceRequestIds, new C10471(this));
            }
        });
    }
}
