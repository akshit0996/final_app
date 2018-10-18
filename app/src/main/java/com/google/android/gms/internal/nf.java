package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationServices.C1530a;

public class nf implements FusedLocationProviderApi {

    /* renamed from: com.google.android.gms.internal.nf$a */
    private static abstract class C1581a extends C1530a<Status> {
        public C1581a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: b */
        public Status m5138b(Status status) {
            return status;
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m5138b(status);
        }
    }

    public Location getLastLocation(GoogleApiClient client) {
        try {
            return LocationServices.m1937f(client).nl();
        } catch (Exception e) {
            return null;
        }
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient client, final PendingIntent callbackIntent) {
        return client.mo928b(new C1581a(this, client) {
            final /* synthetic */ nf agH;

            /* renamed from: a */
            protected void m5588a(nk nkVar) throws RemoteException {
                nkVar.m4953c(callbackIntent);
                m2447b(Status.Kw);
            }
        });
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient client, final LocationListener listener) {
        return client.mo928b(new C1581a(this, client) {
            final /* synthetic */ nf agH;

            /* renamed from: a */
            protected void m5586a(nk nkVar) throws RemoteException {
                nkVar.m4948a(listener);
                m2447b(Status.Kw);
            }
        });
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, final LocationRequest request, final PendingIntent callbackIntent) {
        return client.mo928b(new C1581a(this, client) {
            final /* synthetic */ nf agH;

            /* renamed from: a */
            protected void m5584a(nk nkVar) throws RemoteException {
                nkVar.m4952b(request, callbackIntent);
                m2447b(Status.Kw);
            }
        });
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, final LocationRequest request, final LocationListener listener) {
        return client.mo928b(new C1581a(this, client) {
            final /* synthetic */ nf agH;

            /* renamed from: a */
            protected void m5578a(nk nkVar) throws RemoteException {
                nkVar.m4949a(request, listener, null);
                m2447b(Status.Kw);
            }
        });
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, LocationRequest request, LocationListener listener, Looper looper) {
        final LocationRequest locationRequest = request;
        final LocationListener locationListener = listener;
        final Looper looper2 = looper;
        return client.mo928b(new C1581a(this, client) {
            final /* synthetic */ nf agH;

            /* renamed from: a */
            protected void m5582a(nk nkVar) throws RemoteException {
                nkVar.m4949a(locationRequest, locationListener, looper2);
                m2447b(Status.Kw);
            }
        });
    }

    public PendingResult<Status> setMockLocation(GoogleApiClient client, final Location mockLocation) {
        return client.mo928b(new C1581a(this, client) {
            final /* synthetic */ nf agH;

            /* renamed from: a */
            protected void m5580a(nk nkVar) throws RemoteException {
                nkVar.m4951b(mockLocation);
                m2447b(Status.Kw);
            }
        });
    }

    public PendingResult<Status> setMockMode(GoogleApiClient client, final boolean isMockMode) {
        return client.mo928b(new C1581a(this, client) {
            final /* synthetic */ nf agH;

            /* renamed from: a */
            protected void m5590a(nk nkVar) throws RemoteException {
                nkVar.m4943S(isMockMode);
                m2447b(Status.Kw);
            }
        });
    }
}
