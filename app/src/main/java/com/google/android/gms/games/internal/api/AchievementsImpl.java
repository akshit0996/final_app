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
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AchievementsImpl implements Achievements {

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadAchievementsResult> {
        private LoadImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: I */
        public LoadAchievementsResult m5015I(final Status status) {
            return new LoadAchievementsResult(this) {
                final /* synthetic */ LoadImpl aac;

                public AchievementBuffer getAchievements() {
                    return new AchievementBuffer(DataHolder.av(14));
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
            return m5015I(status);
        }
    }

    private static abstract class UpdateImpl extends BaseGamesApiMethodImpl<UpdateAchievementResult> {
        private final String CE;

        public UpdateImpl(String id, GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.CE = id;
        }

        /* renamed from: J */
        public UpdateAchievementResult m5018J(final Status status) {
            return new UpdateAchievementResult(this) {
                final /* synthetic */ UpdateImpl aad;

                public String getAchievementId() {
                    return this.aad.CE;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m5018J(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl$10 */
    class AnonymousClass10 extends LoadImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String ZY;
        final /* synthetic */ String ZZ;

        /* renamed from: a */
        public void m5317a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4173b((C0155b) this, this.ZY, this.ZZ, this.ZW);
        }
    }

    public Intent getAchievementsIntent(GoogleApiClient apiClient) {
        return Games.m659d(apiClient).lm();
    }

    public void increment(GoogleApiClient apiClient, String id, int numSteps) {
        final String str = id;
        final int i = numSteps;
        apiClient.mo928b(new UpdateImpl(this, id, apiClient) {
            final /* synthetic */ AchievementsImpl ZX;

            /* renamed from: a */
            public void m5329a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m4132a(null, str, i);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> incrementImmediate(GoogleApiClient apiClient, String id, int numSteps) {
        final String str = id;
        final int i = numSteps;
        return apiClient.mo928b(new UpdateImpl(this, id, apiClient) {
            final /* synthetic */ AchievementsImpl ZX;

            /* renamed from: a */
            public void m5331a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m4132a((C0155b) this, str, i);
            }
        });
    }

    public PendingResult<LoadAchievementsResult> load(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.mo926a(new LoadImpl(this, apiClient) {
            final /* synthetic */ AchievementsImpl ZX;

            /* renamed from: a */
            public void m5319a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m4188c((C0155b) this, forceReload);
            }
        });
    }

    public void reveal(GoogleApiClient apiClient, final String id) {
        apiClient.mo928b(new UpdateImpl(this, apiClient, id) {
            final /* synthetic */ AchievementsImpl ZX;

            /* renamed from: a */
            public void m5321a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m4131a(null, id);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> revealImmediate(GoogleApiClient apiClient, final String id) {
        return apiClient.mo928b(new UpdateImpl(this, apiClient, id) {
            final /* synthetic */ AchievementsImpl ZX;

            /* renamed from: a */
            public void m5323a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m4131a((C0155b) this, id);
            }
        });
    }

    public void setSteps(GoogleApiClient apiClient, String id, int numSteps) {
        final String str = id;
        final int i = numSteps;
        apiClient.mo928b(new UpdateImpl(this, id, apiClient) {
            final /* synthetic */ AchievementsImpl ZX;

            /* renamed from: a */
            public void m5333a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m4167b(null, str, i);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> setStepsImmediate(GoogleApiClient apiClient, String id, int numSteps) {
        final String str = id;
        final int i = numSteps;
        return apiClient.mo928b(new UpdateImpl(this, id, apiClient) {
            final /* synthetic */ AchievementsImpl ZX;

            /* renamed from: a */
            public void m5335a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m4167b((C0155b) this, str, i);
            }
        });
    }

    public void unlock(GoogleApiClient apiClient, final String id) {
        apiClient.mo928b(new UpdateImpl(this, apiClient, id) {
            final /* synthetic */ AchievementsImpl ZX;

            /* renamed from: a */
            public void m5325a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m4166b(null, id);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> unlockImmediate(GoogleApiClient apiClient, final String id) {
        return apiClient.mo928b(new UpdateImpl(this, apiClient, id) {
            final /* synthetic */ AchievementsImpl ZX;

            /* renamed from: a */
            public void m5327a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m4166b((C0155b) this, id);
            }
        });
    }
}
