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
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.Players.LoadOwnerCoverPhotoUrisResult;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadProfileSettingsResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class PlayersImpl implements Players {

    private static abstract class LoadOwnerCoverPhotoUrisImpl extends BaseGamesApiMethodImpl<LoadOwnerCoverPhotoUrisResult> {
        public LoadOwnerCoverPhotoUrisResult ac(final Status status) {
            return new LoadOwnerCoverPhotoUrisResult(this) {
                final /* synthetic */ LoadOwnerCoverPhotoUrisImpl abf;

                public Status getStatus() {
                    return status;
                }
            };
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return ac(status);
        }
    }

    private static abstract class LoadPlayersImpl extends BaseGamesApiMethodImpl<LoadPlayersResult> {
        private LoadPlayersImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadPlayersResult ad(final Status status) {
            return new LoadPlayersResult(this) {
                final /* synthetic */ LoadPlayersImpl abg;

                public PlayerBuffer getPlayers() {
                    return new PlayerBuffer(DataHolder.av(14));
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
            return ad(status);
        }
    }

    private static abstract class LoadProfileSettingsResultImpl extends BaseGamesApiMethodImpl<LoadProfileSettingsResult> {
        protected LoadProfileSettingsResult ae(final Status status) {
            return new LoadProfileSettingsResult(this) {
                final /* synthetic */ LoadProfileSettingsResultImpl abh;

                public Status getStatus() {
                    return status;
                }

                public boolean isProfileVisible() {
                    return true;
                }

                public boolean isVisibilityExplicitlySet() {
                    return false;
                }
            };
        }

        /* renamed from: c */
        protected /* synthetic */ Result mo2958c(Status status) {
            return ae(status);
        }
    }

    private static abstract class LoadXpForGameCategoriesResultImpl extends BaseGamesApiMethodImpl<LoadXpForGameCategoriesResult> {
        public LoadXpForGameCategoriesResult af(final Status status) {
            return new LoadXpForGameCategoriesResult(this) {
                final /* synthetic */ LoadXpForGameCategoriesResultImpl abi;

                public Status getStatus() {
                    return status;
                }
            };
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return af(status);
        }
    }

    private static abstract class LoadXpStreamResultImpl extends BaseGamesApiMethodImpl<LoadXpStreamResult> {
        public LoadXpStreamResult ag(final Status status) {
            return new LoadXpStreamResult(this) {
                final /* synthetic */ LoadXpStreamResultImpl abj;

                public Status getStatus() {
                    return status;
                }
            };
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return ag(status);
        }
    }

    private static abstract class UpdateProfileSettingsResultImpl extends BaseGamesApiMethodImpl<Status> {
        /* renamed from: b */
        protected Status m5068b(Status status) {
            return status;
        }

        /* renamed from: c */
        protected /* synthetic */ Result mo2958c(Status status) {
            return m5068b(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$10 */
    class AnonymousClass10 extends LoadPlayersImpl {
        final /* synthetic */ String ZZ;
        final /* synthetic */ int aar;

        /* renamed from: a */
        protected void m5421a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4142a((C0155b) this, "nearby", this.ZZ, this.aar, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$11 */
    class AnonymousClass11 extends LoadPlayersImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String ZZ;
        final /* synthetic */ int aar;

        /* renamed from: a */
        protected void m5423a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4142a((C0155b) this, "played_with", this.ZZ, this.aar, false, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$12 */
    class AnonymousClass12 extends LoadPlayersImpl {
        final /* synthetic */ String ZZ;
        final /* synthetic */ int aar;

        /* renamed from: a */
        protected void m5425a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4142a((C0155b) this, "played_with", this.ZZ, this.aar, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$13 */
    class AnonymousClass13 extends LoadPlayersImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ int aar;

        /* renamed from: a */
        protected void m5427a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4165b((C0155b) this, this.aar, false, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$14 */
    class AnonymousClass14 extends LoadPlayersImpl {
        final /* synthetic */ int aar;

        /* renamed from: a */
        protected void m5429a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4165b((C0155b) this, this.aar, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$15 */
    class AnonymousClass15 extends LoadPlayersImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ int aar;

        /* renamed from: a */
        protected void m5431a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4181c((C0155b) this, this.aar, false, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$16 */
    class AnonymousClass16 extends LoadPlayersImpl {
        final /* synthetic */ int aar;

        /* renamed from: a */
        protected void m5433a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4181c((C0155b) this, this.aar, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$17 */
    class AnonymousClass17 extends LoadPlayersImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ int aar;

        /* renamed from: a */
        protected void m5435a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4193d(this, this.aar, false, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$18 */
    class AnonymousClass18 extends LoadPlayersImpl {
        final /* synthetic */ int aar;

        /* renamed from: a */
        protected void m5437a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4193d(this, this.aar, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$19 */
    class AnonymousClass19 extends LoadPlayersImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ int aar;
        final /* synthetic */ String aat;

        /* renamed from: a */
        protected void m5439a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4209f(this, this.aat, this.aar, false, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$20 */
    class AnonymousClass20 extends LoadPlayersImpl {
        final /* synthetic */ int aar;
        final /* synthetic */ String aat;

        /* renamed from: a */
        protected void m5443a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4209f(this, this.aat, this.aar, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$21 */
    class AnonymousClass21 extends LoadPlayersImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String aaR;
        final /* synthetic */ int aar;
        final /* synthetic */ String aba;

        /* renamed from: a */
        protected void m5445a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4172b((C0155b) this, this.aba, this.aaR, this.aar, false, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$22 */
    class AnonymousClass22 extends LoadPlayersImpl {
        final /* synthetic */ String aaR;
        final /* synthetic */ int aar;
        final /* synthetic */ String aba;

        /* renamed from: a */
        protected void m5447a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4172b((C0155b) this, this.aba, this.aaR, this.aar, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$23 */
    class AnonymousClass23 extends LoadOwnerCoverPhotoUrisImpl {
        /* renamed from: a */
        protected void m5449a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4211g(this);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$24 */
    class AnonymousClass24 extends LoadXpForGameCategoriesResultImpl {
        final /* synthetic */ String abb;

        /* renamed from: a */
        protected void m5451a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4224m(this, this.abb);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$25 */
    class AnonymousClass25 extends LoadXpStreamResultImpl {
        final /* synthetic */ String abb;
        final /* synthetic */ int abc;

        /* renamed from: a */
        protected void m5453a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4183c((C0155b) this, this.abb, this.abc);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$26 */
    class AnonymousClass26 extends LoadXpStreamResultImpl {
        final /* synthetic */ String abb;
        final /* synthetic */ int abc;

        /* renamed from: a */
        protected void m5455a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4195d((C0155b) this, this.abb, this.abc);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$27 */
    class AnonymousClass27 extends LoadProfileSettingsResultImpl {
        final /* synthetic */ boolean ZW;

        /* renamed from: a */
        protected void m5457a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4210f((C0155b) this, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$28 */
    class AnonymousClass28 extends UpdateProfileSettingsResultImpl {
        final /* synthetic */ boolean abd;

        /* renamed from: a */
        protected void m5459a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4213g((C0155b) this, this.abd);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$3 */
    class C17043 extends LoadPlayersImpl {
        final /* synthetic */ String[] abe;

        /* renamed from: a */
        protected void m5463a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4156a((C0155b) this, this.abe);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$9 */
    class C17109 extends LoadPlayersImpl {
        final /* synthetic */ String ZZ;
        final /* synthetic */ int aar;

        /* renamed from: a */
        protected void m5475a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4142a((C0155b) this, "nearby", this.ZZ, this.aar, false, false);
        }
    }

    public Player getCurrentPlayer(GoogleApiClient apiClient) {
        return Games.m659d(apiClient).lj();
    }

    public String getCurrentPlayerId(GoogleApiClient apiClient) {
        return Games.m659d(apiClient).li();
    }

    public Intent getPlayerSearchIntent(GoogleApiClient apiClient) {
        return Games.m659d(apiClient).lt();
    }

    public PendingResult<LoadPlayersResult> loadConnectedPlayers(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.mo926a(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl aaZ;

            /* renamed from: a */
            protected void m5473a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m4152a((C0155b) this, forceReload);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadInvitablePlayers(GoogleApiClient apiClient, final int pageSize, final boolean forceReload) {
        return apiClient.mo926a(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl aaZ;

            /* renamed from: a */
            protected void m5465a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m4126a((C0155b) this, pageSize, false, forceReload);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient apiClient, final int pageSize) {
        return apiClient.mo926a(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl aaZ;

            /* renamed from: a */
            protected void m5467a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m4126a((C0155b) this, pageSize, true, false);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient apiClient, final int pageSize) {
        return apiClient.mo926a(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl aaZ;

            /* renamed from: a */
            protected void m5471a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m4134a((C0155b) this, "played_with", pageSize, true, false);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient apiClient, final String playerId) {
        return apiClient.mo926a(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl aaZ;

            /* renamed from: a */
            protected void m5441a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m4148a((C0155b) this, playerId, false);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient apiClient, final String playerId, final boolean forceReload) {
        return apiClient.mo926a(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl aaZ;

            /* renamed from: a */
            protected void m5461a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m4148a((C0155b) this, playerId, forceReload);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient apiClient, final int pageSize, final boolean forceReload) {
        return apiClient.mo926a(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl aaZ;

            /* renamed from: a */
            protected void m5469a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m4134a((C0155b) this, "played_with", pageSize, false, forceReload);
            }
        });
    }
}
