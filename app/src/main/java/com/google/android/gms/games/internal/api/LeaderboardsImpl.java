package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;

public final class LeaderboardsImpl implements Leaderboards {

    private static abstract class LoadMetadataImpl extends BaseGamesApiMethodImpl<LeaderboardMetadataResult> {
        private LoadMetadataImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: U */
        public LeaderboardMetadataResult m5039U(final Status status) {
            return new LeaderboardMetadataResult(this) {
                final /* synthetic */ LoadMetadataImpl aaN;

                public LeaderboardBuffer getLeaderboards() {
                    return new LeaderboardBuffer(DataHolder.av(14));
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
            return m5039U(status);
        }
    }

    private static abstract class LoadPlayerScoreImpl extends BaseGamesApiMethodImpl<LoadPlayerScoreResult> {
        private LoadPlayerScoreImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: V */
        public LoadPlayerScoreResult m5041V(final Status status) {
            return new LoadPlayerScoreResult(this) {
                final /* synthetic */ LoadPlayerScoreImpl aaO;

                public LeaderboardScore getScore() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m5041V(status);
        }
    }

    private static abstract class LoadScoresImpl extends BaseGamesApiMethodImpl<LoadScoresResult> {
        private LoadScoresImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: W */
        public LoadScoresResult m5043W(final Status status) {
            return new LoadScoresResult(this) {
                final /* synthetic */ LoadScoresImpl aaP;

                public Leaderboard getLeaderboard() {
                    return null;
                }

                public LeaderboardScoreBuffer getScores() {
                    return new LeaderboardScoreBuffer(DataHolder.av(14));
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
            return m5043W(status);
        }
    }

    protected static abstract class SubmitScoreImpl extends BaseGamesApiMethodImpl<SubmitScoreResult> {
        protected SubmitScoreImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: X */
        public SubmitScoreResult m5045X(final Status status) {
            return new SubmitScoreResult(this) {
                final /* synthetic */ SubmitScoreImpl aaQ;

                public ScoreSubmissionData getScoreData() {
                    return new ScoreSubmissionData(DataHolder.av(14));
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
            return m5045X(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl$10 */
    class AnonymousClass10 extends LoadScoresImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String ZZ;
        final /* synthetic */ String aaF;
        final /* synthetic */ int aaG;
        final /* synthetic */ int aaH;
        final /* synthetic */ int aaI;

        /* renamed from: a */
        protected void m5393a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4141a((C0155b) this, this.ZZ, this.aaF, this.aaG, this.aaH, this.aaI, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl$11 */
    class AnonymousClass11 extends LoadScoresImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String ZZ;
        final /* synthetic */ String aaF;
        final /* synthetic */ int aaG;
        final /* synthetic */ int aaH;
        final /* synthetic */ int aaI;

        /* renamed from: a */
        protected void m5395a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4171b(this, this.ZZ, this.aaF, this.aaG, this.aaH, this.aaI, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl$8 */
    class C16978 extends LoadMetadataImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String ZZ;

        /* renamed from: a */
        protected void m5411a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4198d((C0155b) this, this.ZZ, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl$9 */
    class C16989 extends LoadMetadataImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String ZZ;
        final /* synthetic */ String aaF;

        /* renamed from: a */
        protected void m5413a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4144a((C0155b) this, this.ZZ, this.aaF, this.ZW);
        }
    }

    public Intent getAllLeaderboardsIntent(GoogleApiClient apiClient) {
        return Games.m659d(apiClient).ll();
    }

    public Intent getLeaderboardIntent(GoogleApiClient apiClient, String leaderboardId) {
        return getLeaderboardIntent(apiClient, leaderboardId, -1);
    }

    public Intent getLeaderboardIntent(GoogleApiClient apiClient, String leaderboardId, int timeSpan) {
        return Games.m659d(apiClient).m4225n(leaderboardId, timeSpan);
    }

    public PendingResult<LoadPlayerScoreResult> loadCurrentPlayerLeaderboardScore(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection) {
        final String str = leaderboardId;
        final int i = span;
        final int i2 = leaderboardCollection;
        return apiClient.mo926a(new LoadPlayerScoreImpl(this, apiClient) {
            final /* synthetic */ LeaderboardsImpl aaE;

            /* renamed from: a */
            protected void m5401a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m4139a((C0155b) this, null, str, i, i2);
            }
        });
    }

    public PendingResult<LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient apiClient, final String leaderboardId, final boolean forceReload) {
        return apiClient.mo926a(new LoadMetadataImpl(this, apiClient) {
            final /* synthetic */ LeaderboardsImpl aaE;

            /* renamed from: a */
            protected void m5399a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m4174b((C0155b) this, leaderboardId, forceReload);
            }
        });
    }

    public PendingResult<LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.mo926a(new LoadMetadataImpl(this, apiClient) {
            final /* synthetic */ LeaderboardsImpl aaE;

            /* renamed from: a */
            protected void m5397a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m4175b((C0155b) this, forceReload);
            }
        });
    }

    public PendingResult<LoadScoresResult> loadMoreScores(GoogleApiClient apiClient, LeaderboardScoreBuffer buffer, int maxResults, int pageDirection) {
        final LeaderboardScoreBuffer leaderboardScoreBuffer = buffer;
        final int i = maxResults;
        final int i2 = pageDirection;
        return apiClient.mo926a(new LoadScoresImpl(this, apiClient) {
            final /* synthetic */ LeaderboardsImpl aaE;

            /* renamed from: a */
            protected void m5407a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m4128a((C0155b) this, leaderboardScoreBuffer, i, i2);
            }
        });
    }

    public PendingResult<LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults) {
        return loadPlayerCenteredScores(apiClient, leaderboardId, span, leaderboardCollection, maxResults, false);
    }

    public PendingResult<LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        final String str = leaderboardId;
        final int i = span;
        final int i2 = leaderboardCollection;
        final int i3 = maxResults;
        final boolean z = forceReload;
        return apiClient.mo926a(new LoadScoresImpl(this, apiClient) {
            final /* synthetic */ LeaderboardsImpl aaE;

            /* renamed from: a */
            protected void m5405a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m4168b((C0155b) this, str, i, i2, i3, z);
            }
        });
    }

    public PendingResult<LoadScoresResult> loadTopScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults) {
        return loadTopScores(apiClient, leaderboardId, span, leaderboardCollection, maxResults, false);
    }

    public PendingResult<LoadScoresResult> loadTopScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        final String str = leaderboardId;
        final int i = span;
        final int i2 = leaderboardCollection;
        final int i3 = maxResults;
        final boolean z = forceReload;
        return apiClient.mo926a(new LoadScoresImpl(this, apiClient) {
            final /* synthetic */ LeaderboardsImpl aaE;

            /* renamed from: a */
            protected void m5403a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m4133a((C0155b) this, str, i, i2, i3, z);
            }
        });
    }

    public void submitScore(GoogleApiClient apiClient, String leaderboardId, long score) {
        submitScore(apiClient, leaderboardId, score, null);
    }

    public void submitScore(GoogleApiClient apiClient, String leaderboardId, long score, String scoreTag) {
        Games.m659d(apiClient).m4137a(null, leaderboardId, score, scoreTag);
    }

    public PendingResult<SubmitScoreResult> submitScoreImmediate(GoogleApiClient apiClient, String leaderboardId, long score) {
        return submitScoreImmediate(apiClient, leaderboardId, score, null);
    }

    public PendingResult<SubmitScoreResult> submitScoreImmediate(GoogleApiClient apiClient, String leaderboardId, long score, String scoreTag) {
        final String str = leaderboardId;
        final long j = score;
        final String str2 = scoreTag;
        return apiClient.mo928b(new SubmitScoreImpl(this, apiClient) {
            final /* synthetic */ LeaderboardsImpl aaE;

            /* renamed from: a */
            protected void m5409a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m4137a((C0155b) this, str, j, str2);
            }
        });
    }
}
