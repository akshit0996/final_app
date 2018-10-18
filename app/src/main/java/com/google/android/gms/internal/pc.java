package com.google.android.gms.internal;

import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.Plus.C1531a;
import com.google.android.gms.plus.internal.C1470e;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

public final class pc implements People {

    /* renamed from: com.google.android.gms.internal.pc$a */
    private static abstract class C1588a extends C1531a<LoadPeopleResult> {
        private C1588a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadPeopleResult aC(final Status status) {
            return new LoadPeopleResult(this) {
                final /* synthetic */ C1588a aol;

                public String getNextPageToken() {
                    return null;
                }

                public PersonBuffer getPersonBuffer() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return aC(status);
        }
    }

    public Person getCurrentPerson(GoogleApiClient googleApiClient) {
        return Plus.m2027a(googleApiClient, Plus.DQ).getCurrentPerson();
    }

    public PendingResult<LoadPeopleResult> load(GoogleApiClient googleApiClient, final Collection<String> personIds) {
        return googleApiClient.mo926a(new C1588a(this, googleApiClient) {
            final /* synthetic */ pc aoi;

            /* renamed from: a */
            protected void m5616a(C1470e c1470e) {
                c1470e.m4648a((C0155b) this, personIds);
            }
        });
    }

    public PendingResult<LoadPeopleResult> load(GoogleApiClient googleApiClient, final String... personIds) {
        return googleApiClient.mo926a(new C1588a(this, googleApiClient) {
            final /* synthetic */ pc aoi;

            /* renamed from: a */
            protected void m5618a(C1470e c1470e) {
                c1470e.m4650d(this, personIds);
            }
        });
    }

    public PendingResult<LoadPeopleResult> loadConnected(GoogleApiClient googleApiClient) {
        return googleApiClient.mo926a(new C1588a(this, googleApiClient) {
            final /* synthetic */ pc aoi;

            /* renamed from: a */
            protected void m5614a(C1470e c1470e) {
                c1470e.m4652k(this);
            }
        });
    }

    public PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, final int orderBy, final String pageToken) {
        return googleApiClient.mo926a(new C1588a(this, googleApiClient) {
            final /* synthetic */ pc aoi;

            /* renamed from: a */
            protected void m5610a(C1470e c1470e) {
                m2446a(c1470e.m4644a((C0155b) this, orderBy, pageToken));
            }
        });
    }

    public PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, final String pageToken) {
        return googleApiClient.mo926a(new C1588a(this, googleApiClient) {
            final /* synthetic */ pc aoi;

            /* renamed from: a */
            protected void m5612a(C1470e c1470e) {
                m2446a(c1470e.m4655q(this, pageToken));
            }
        });
    }
}
