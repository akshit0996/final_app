package com.google.android.gms.plus;

import android.net.Uri;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.internal.C1470e;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

@Deprecated
public class PlusClient implements GooglePlayServicesClient {
    final C1470e ant;

    @Deprecated
    public interface OnAccessRevokedListener {
        void onAccessRevoked(ConnectionResult connectionResult);
    }

    @Deprecated
    public interface OnMomentsLoadedListener {
        @Deprecated
        void onMomentsLoaded(ConnectionResult connectionResult, MomentBuffer momentBuffer, String str, String str2);
    }

    @Deprecated
    public interface OnPeopleLoadedListener {
        void onPeopleLoaded(ConnectionResult connectionResult, PersonBuffer personBuffer, String str);
    }

    @Deprecated
    public void clearDefaultAccount() {
        this.ant.clearDefaultAccount();
    }

    @Deprecated
    public void connect() {
        this.ant.connect();
    }

    @Deprecated
    public void disconnect() {
        this.ant.disconnect();
    }

    @Deprecated
    public String getAccountName() {
        return this.ant.getAccountName();
    }

    @Deprecated
    public Person getCurrentPerson() {
        return this.ant.getCurrentPerson();
    }

    @Deprecated
    public boolean isConnected() {
        return this.ant.isConnected();
    }

    @Deprecated
    public boolean isConnecting() {
        return this.ant.isConnecting();
    }

    @Deprecated
    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        return this.ant.isConnectionCallbacksRegistered(listener);
    }

    @Deprecated
    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        return this.ant.isConnectionFailedListenerRegistered(listener);
    }

    @Deprecated
    public void loadMoments(final OnMomentsLoadedListener listener) {
        this.ant.m4651j(new C0155b<LoadMomentsResult>(this) {
            final /* synthetic */ PlusClient anv;

            /* renamed from: a */
            public void m3622a(LoadMomentsResult loadMomentsResult) {
                listener.onMomentsLoaded(loadMomentsResult.getStatus().gQ(), loadMomentsResult.getMomentBuffer(), loadMomentsResult.getNextPageToken(), loadMomentsResult.getUpdated());
            }

            /* renamed from: b */
            public /* synthetic */ void mo908b(Object obj) {
                m3622a((LoadMomentsResult) obj);
            }
        });
    }

    @Deprecated
    public void loadMoments(final OnMomentsLoadedListener listener, int maxResults, String pageToken, Uri targetUrl, String type, String userId) {
        this.ant.m4646a(new C0155b<LoadMomentsResult>(this) {
            final /* synthetic */ PlusClient anv;

            /* renamed from: a */
            public void m3624a(LoadMomentsResult loadMomentsResult) {
                listener.onMomentsLoaded(loadMomentsResult.getStatus().gQ(), loadMomentsResult.getMomentBuffer(), loadMomentsResult.getNextPageToken(), loadMomentsResult.getUpdated());
            }

            /* renamed from: b */
            public /* synthetic */ void mo908b(Object obj) {
                m3624a((LoadMomentsResult) obj);
            }
        }, maxResults, pageToken, targetUrl, type, userId);
    }

    @Deprecated
    public void loadPeople(final OnPeopleLoadedListener listener, Collection<String> personIds) {
        this.ant.m4648a(new C0155b<LoadPeopleResult>(this) {
            final /* synthetic */ PlusClient anv;

            /* renamed from: a */
            public void m3630a(LoadPeopleResult loadPeopleResult) {
                listener.onPeopleLoaded(loadPeopleResult.getStatus().gQ(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
            }

            /* renamed from: b */
            public /* synthetic */ void mo908b(Object obj) {
                m3630a((LoadPeopleResult) obj);
            }
        }, (Collection) personIds);
    }

    @Deprecated
    public void loadPeople(final OnPeopleLoadedListener listener, String... personIds) {
        this.ant.m4650d(new C0155b<LoadPeopleResult>(this) {
            final /* synthetic */ PlusClient anv;

            /* renamed from: a */
            public void m3632a(LoadPeopleResult loadPeopleResult) {
                listener.onPeopleLoaded(loadPeopleResult.getStatus().gQ(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
            }

            /* renamed from: b */
            public /* synthetic */ void mo908b(Object obj) {
                m3632a((LoadPeopleResult) obj);
            }
        }, personIds);
    }

    @Deprecated
    public void loadVisiblePeople(final OnPeopleLoadedListener listener, int orderBy, String pageToken) {
        this.ant.m4644a(new C0155b<LoadPeopleResult>(this) {
            final /* synthetic */ PlusClient anv;

            /* renamed from: a */
            public void m3626a(LoadPeopleResult loadPeopleResult) {
                listener.onPeopleLoaded(loadPeopleResult.getStatus().gQ(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
            }

            /* renamed from: b */
            public /* synthetic */ void mo908b(Object obj) {
                m3626a((LoadPeopleResult) obj);
            }
        }, orderBy, pageToken);
    }

    @Deprecated
    public void loadVisiblePeople(final OnPeopleLoadedListener listener, String pageToken) {
        this.ant.m4655q(new C0155b<LoadPeopleResult>(this) {
            final /* synthetic */ PlusClient anv;

            /* renamed from: a */
            public void m3628a(LoadPeopleResult loadPeopleResult) {
                listener.onPeopleLoaded(loadPeopleResult.getStatus().gQ(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
            }

            /* renamed from: b */
            public /* synthetic */ void mo908b(Object obj) {
                m3628a((LoadPeopleResult) obj);
            }
        }, pageToken);
    }

    C1470e os() {
        return this.ant;
    }

    @Deprecated
    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.ant.registerConnectionCallbacks(listener);
    }

    @Deprecated
    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.ant.registerConnectionFailedListener(listener);
    }

    @Deprecated
    public void removeMoment(String momentId) {
        this.ant.removeMoment(momentId);
    }

    @Deprecated
    public void revokeAccessAndDisconnect(final OnAccessRevokedListener listener) {
        this.ant.m4654l(new C0155b<Status>(this) {
            final /* synthetic */ PlusClient anv;

            public void az(Status status) {
                listener.onAccessRevoked(status.getStatus().gQ());
            }

            /* renamed from: b */
            public /* synthetic */ void mo908b(Object obj) {
                az((Status) obj);
            }
        });
    }

    @Deprecated
    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        this.ant.unregisterConnectionCallbacks(listener);
    }

    @Deprecated
    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        this.ant.unregisterConnectionFailedListener(listener);
    }

    @Deprecated
    public void writeMoment(Moment moment) {
        this.ant.m4647a(null, moment);
    }
}
