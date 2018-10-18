package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.GamesMetadata.LoadExtendedGamesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class GamesMetadataImpl implements GamesMetadata {

    private static abstract class LoadExtendedGamesImpl extends BaseGamesApiMethodImpl<LoadExtendedGamesResult> {
        /* renamed from: P */
        public LoadExtendedGamesResult m5029P(final Status status) {
            return new LoadExtendedGamesResult(this) {
                final /* synthetic */ LoadExtendedGamesImpl aaw;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m5029P(status);
        }
    }

    private static abstract class LoadGameInstancesImpl extends BaseGamesApiMethodImpl<LoadGameInstancesResult> {
        /* renamed from: Q */
        public LoadGameInstancesResult m5031Q(final Status status) {
            return new LoadGameInstancesResult(this) {
                final /* synthetic */ LoadGameInstancesImpl aax;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m5031Q(status);
        }
    }

    private static abstract class LoadGameSearchSuggestionsImpl extends BaseGamesApiMethodImpl<LoadGameSearchSuggestionsResult> {
        /* renamed from: R */
        public LoadGameSearchSuggestionsResult m5033R(final Status status) {
            return new LoadGameSearchSuggestionsResult(this) {
                final /* synthetic */ LoadGameSearchSuggestionsImpl aay;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m5033R(status);
        }
    }

    private static abstract class LoadGamesImpl extends BaseGamesApiMethodImpl<LoadGamesResult> {
        private LoadGamesImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: S */
        public LoadGamesResult m5035S(final Status status) {
            return new LoadGamesResult(this) {
                final /* synthetic */ LoadGamesImpl aaz;

                public GameBuffer getGames() {
                    return new GameBuffer(DataHolder.av(14));
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
            return m5035S(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$10 */
    class AnonymousClass10 extends LoadExtendedGamesImpl {
        final /* synthetic */ String aaq;
        final /* synthetic */ int aar;
        final /* synthetic */ boolean aas;

        /* renamed from: a */
        protected void m5349a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4135a((C0155b) this, this.aaq, this.aar, false, true, false, this.aas);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$11 */
    class AnonymousClass11 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String ZY;
        final /* synthetic */ int aar;

        /* renamed from: a */
        protected void m5351a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4184c(this, this.ZY, this.aar, false, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$12 */
    class AnonymousClass12 extends LoadExtendedGamesImpl {
        final /* synthetic */ String ZY;
        final /* synthetic */ int aar;

        /* renamed from: a */
        protected void m5353a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4184c(this, this.ZY, this.aar, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$13 */
    class AnonymousClass13 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String ZY;
        final /* synthetic */ int aar;

        /* renamed from: a */
        protected void m5355a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4196d(this, this.ZY, this.aar, false, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$14 */
    class AnonymousClass14 extends LoadExtendedGamesImpl {
        final /* synthetic */ String ZY;
        final /* synthetic */ int aar;

        /* renamed from: a */
        protected void m5357a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4196d(this, this.ZY, this.aar, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$15 */
    class AnonymousClass15 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String aaq;
        final /* synthetic */ int aar;
        final /* synthetic */ boolean aas;

        /* renamed from: a */
        protected void m5359a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4135a((C0155b) this, this.aaq, this.aar, true, false, this.ZW, this.aas);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$16 */
    class AnonymousClass16 extends LoadExtendedGamesImpl {
        final /* synthetic */ String aaq;
        final /* synthetic */ int aar;
        final /* synthetic */ boolean aas;

        /* renamed from: a */
        protected void m5361a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4135a((C0155b) this, this.aaq, this.aar, true, true, false, this.aas);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$17 */
    class AnonymousClass17 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ int aar;
        final /* synthetic */ String aat;

        /* renamed from: a */
        protected void m5363a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4203e(this, this.aat, this.aar, false, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$18 */
    class AnonymousClass18 extends LoadExtendedGamesImpl {
        final /* synthetic */ int aar;
        final /* synthetic */ String aat;

        /* renamed from: a */
        protected void m5365a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4203e(this, this.aat, this.aar, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$19 */
    class AnonymousClass19 extends LoadGameSearchSuggestionsImpl {
        final /* synthetic */ String aat;

        /* renamed from: a */
        protected void m5367a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4223l(this, this.aat);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$2 */
    class C16792 extends LoadExtendedGamesImpl {
        final /* synthetic */ String ZZ;

        /* renamed from: a */
        protected void m5371a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4219j(this, this.ZZ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$3 */
    class C16803 extends LoadGameInstancesImpl {
        final /* synthetic */ String ZZ;

        /* renamed from: a */
        protected void m5373a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4221k(this, this.ZZ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$4 */
    class C16814 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ int aar;

        /* renamed from: a */
        protected void m5375a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4169b(this, null, this.aar, false, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$5 */
    class C16825 extends LoadExtendedGamesImpl {
        final /* synthetic */ int aar;

        /* renamed from: a */
        protected void m5377a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4169b(this, null, this.aar, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$6 */
    class C16836 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String ZY;
        final /* synthetic */ int aar;

        /* renamed from: a */
        protected void m5379a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4169b(this, this.ZY, this.aar, false, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$7 */
    class C16847 extends LoadExtendedGamesImpl {
        final /* synthetic */ String ZY;
        final /* synthetic */ int aar;

        /* renamed from: a */
        protected void m5381a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4169b(this, this.ZY, this.aar, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$8 */
    class C16858 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ int aar;
        final /* synthetic */ int aau;
        final /* synthetic */ boolean aav;

        /* renamed from: a */
        protected void m5383a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4124a((C0155b) this, this.aar, this.aau, this.aav, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$9 */
    class C16869 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ String aaq;
        final /* synthetic */ int aar;
        final /* synthetic */ boolean aas;

        /* renamed from: a */
        protected void m5385a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4135a((C0155b) this, this.aaq, this.aar, false, false, this.ZW, this.aas);
        }
    }

    public Game getCurrentGame(GoogleApiClient apiClient) {
        return Games.m659d(apiClient).lk();
    }

    public PendingResult<LoadGamesResult> loadGame(GoogleApiClient apiClient) {
        return apiClient.mo926a(new LoadGamesImpl(this, apiClient) {
            final /* synthetic */ GamesMetadataImpl aap;

            /* renamed from: a */
            protected void m5369a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m4206f(this);
            }
        });
    }
}
