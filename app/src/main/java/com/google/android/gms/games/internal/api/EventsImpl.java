package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class EventsImpl implements Events {

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadEventsResult> {
        private LoadImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: O */
        public LoadEventsResult m5026O(final Status status) {
            return new LoadEventsResult(this) {
                final /* synthetic */ LoadImpl aan;

                public EventBuffer getEvents() {
                    return new EventBuffer(DataHolder.av(14));
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
            return m5026O(status);
        }
    }

    private static abstract class UpdateImpl extends BaseGamesApiMethodImpl<Result> {
        private UpdateImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: c */
        public Result mo2958c(final Status status) {
            return new Result(this) {
                final /* synthetic */ UpdateImpl aao;

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    public void increment(GoogleApiClient apiClient, final String eventId, final int incrementAmount) {
        GamesClientImpl e = Games.m660e(apiClient);
        if (e.isConnected()) {
            e.m4228o(eventId, incrementAmount);
        } else {
            apiClient.mo928b(new UpdateImpl(this, apiClient) {
                final /* synthetic */ EventsImpl aak;

                /* renamed from: a */
                public void m5347a(GamesClientImpl gamesClientImpl) {
                    gamesClientImpl.m4228o(eventId, incrementAmount);
                }
            });
        }
    }

    public PendingResult<LoadEventsResult> load(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.mo926a(new LoadImpl(this, apiClient) {
            final /* synthetic */ EventsImpl aak;

            /* renamed from: a */
            public void m5345a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m4199d((C0155b) this, forceReload);
            }
        });
    }

    public PendingResult<LoadEventsResult> loadByIds(GoogleApiClient apiClient, final boolean forceReload, final String... eventIds) {
        return apiClient.mo926a(new LoadImpl(this, apiClient) {
            final /* synthetic */ EventsImpl aak;

            /* renamed from: a */
            public void m5343a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m4154a((C0155b) this, forceReload, eventIds);
            }
        });
    }
}
