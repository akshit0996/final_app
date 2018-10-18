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
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;

public final class QuestsImpl implements Quests {

    private static abstract class AcceptImpl extends BaseGamesApiMethodImpl<AcceptQuestResult> {
        private AcceptImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public AcceptQuestResult ah(final Status status) {
            return new AcceptQuestResult(this) {
                final /* synthetic */ AcceptImpl abq;

                public Quest getQuest() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return ah(status);
        }
    }

    private static abstract class ClaimImpl extends BaseGamesApiMethodImpl<ClaimMilestoneResult> {
        private ClaimImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public ClaimMilestoneResult ai(final Status status) {
            return new ClaimMilestoneResult(this) {
                final /* synthetic */ ClaimImpl abr;

                public Milestone getMilestone() {
                    return null;
                }

                public Quest getQuest() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return ai(status);
        }
    }

    private static abstract class LoadsImpl extends BaseGamesApiMethodImpl<LoadQuestsResult> {
        private LoadsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadQuestsResult aj(final Status status) {
            return new LoadQuestsResult(this) {
                final /* synthetic */ LoadsImpl abs;

                public QuestBuffer getQuests() {
                    return new QuestBuffer(DataHolder.av(status.getStatusCode()));
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
            return aj(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl$5 */
    class C17155 extends LoadsImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String ZZ;
        final /* synthetic */ int aaA;
        final /* synthetic */ int[] abn;
        final /* synthetic */ String abp;

        /* renamed from: a */
        protected void m5485a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4146a((C0155b) this, this.ZZ, this.abp, this.abn, this.aaA, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl$6 */
    class C17166 extends LoadsImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String ZZ;
        final /* synthetic */ String[] abo;
        final /* synthetic */ String abp;

        /* renamed from: a */
        protected void m5487a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4145a((C0155b) this, this.ZZ, this.abp, this.ZW, this.abo);
        }
    }

    public PendingResult<AcceptQuestResult> accept(GoogleApiClient apiClient, final String questId) {
        return apiClient.mo928b(new AcceptImpl(this, apiClient) {
            final /* synthetic */ QuestsImpl abl;

            /* renamed from: a */
            protected void m5477a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m4215h((C0155b) this, questId);
            }
        });
    }

    public PendingResult<ClaimMilestoneResult> claim(GoogleApiClient apiClient, final String questId, final String milestoneId) {
        return apiClient.mo928b(new ClaimImpl(this, apiClient) {
            final /* synthetic */ QuestsImpl abl;

            /* renamed from: a */
            protected void m5479a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m4170b((C0155b) this, questId, milestoneId);
            }
        });
    }

    public Intent getQuestIntent(GoogleApiClient apiClient, String questId) {
        return Games.m659d(apiClient).bE(questId);
    }

    public Intent getQuestsIntent(GoogleApiClient apiClient, int[] questSelectors) {
        return Games.m659d(apiClient).m4163b(questSelectors);
    }

    public PendingResult<LoadQuestsResult> load(GoogleApiClient apiClient, int[] questSelectors, int sortOrder, boolean forceReload) {
        final int[] iArr = questSelectors;
        final int i = sortOrder;
        final boolean z = forceReload;
        return apiClient.mo926a(new LoadsImpl(this, apiClient) {
            final /* synthetic */ QuestsImpl abl;

            /* renamed from: a */
            protected void m5481a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m4155a((C0155b) this, iArr, i, z);
            }
        });
    }

    public PendingResult<LoadQuestsResult> loadByIds(GoogleApiClient apiClient, final boolean forceReload, final String... questIds) {
        return apiClient.mo926a(new LoadsImpl(this, apiClient) {
            final /* synthetic */ QuestsImpl abl;

            /* renamed from: a */
            protected void m5483a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m4176b((C0155b) this, forceReload, questIds);
            }
        });
    }

    public void registerQuestUpdateListener(GoogleApiClient apiClient, QuestUpdateListener listener) {
        Games.m659d(apiClient).m4190c(apiClient.mo933d(listener));
    }

    public void showStateChangedPopup(GoogleApiClient apiClient, String questId) {
        Games.m659d(apiClient).bF(questId);
    }

    public void unregisterQuestUpdateListener(GoogleApiClient apiClient) {
        Games.m659d(apiClient).lr();
    }
}
