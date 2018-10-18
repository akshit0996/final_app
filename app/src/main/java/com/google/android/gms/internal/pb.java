package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.Plus.C1531a;
import com.google.android.gms.plus.internal.C1470e;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;

public final class pb implements Moments {

    /* renamed from: com.google.android.gms.internal.pb$a */
    private static abstract class C1585a extends C1531a<LoadMomentsResult> {
        private C1585a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadMomentsResult aB(final Status status) {
            return new LoadMomentsResult(this) {
                final /* synthetic */ C1585a aog;

                public MomentBuffer getMomentBuffer() {
                    return null;
                }

                public String getNextPageToken() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }

                public String getUpdated() {
                    return null;
                }

                public void release() {
                }
            };
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return aB(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.pb$b */
    private static abstract class C1586b extends C1531a<Status> {
        private C1586b(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: b */
        public Status m5146b(Status status) {
            return status;
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m5146b(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.pb$c */
    private static abstract class C1587c extends C1531a<Status> {
        private C1587c(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: b */
        public Status m5148b(Status status) {
            return status;
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m5148b(status);
        }
    }

    public PendingResult<LoadMomentsResult> load(GoogleApiClient googleApiClient) {
        return googleApiClient.mo926a(new C1585a(this, googleApiClient) {
            final /* synthetic */ pb anZ;

            /* renamed from: a */
            protected void m5602a(C1470e c1470e) {
                c1470e.m4651j(this);
            }
        });
    }

    public PendingResult<LoadMomentsResult> load(GoogleApiClient googleApiClient, int maxResults, String pageToken, Uri targetUrl, String type, String userId) {
        final int i = maxResults;
        final String str = pageToken;
        final Uri uri = targetUrl;
        final String str2 = type;
        final String str3 = userId;
        return googleApiClient.mo926a(new C1585a(this, googleApiClient) {
            final /* synthetic */ pb anZ;

            /* renamed from: a */
            protected void m5604a(C1470e c1470e) {
                c1470e.m4646a(this, i, str, uri, str2, str3);
            }
        });
    }

    public PendingResult<Status> remove(GoogleApiClient googleApiClient, final String momentId) {
        return googleApiClient.mo928b(new C1586b(this, googleApiClient) {
            final /* synthetic */ pb anZ;

            /* renamed from: a */
            protected void m5608a(C1470e c1470e) {
                c1470e.removeMoment(momentId);
                m2447b(Status.Kw);
            }
        });
    }

    public PendingResult<Status> write(GoogleApiClient googleApiClient, final Moment moment) {
        return googleApiClient.mo928b(new C1587c(this, googleApiClient) {
            final /* synthetic */ pb anZ;

            /* renamed from: a */
            protected void m5606a(C1470e c1470e) {
                c1470e.m4647a((C0155b) this, moment);
            }
        });
    }
}
