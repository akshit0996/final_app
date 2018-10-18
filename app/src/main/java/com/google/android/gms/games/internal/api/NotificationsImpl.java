package com.google.android.gms.games.internal.api;

import android.os.Bundle;
import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class NotificationsImpl implements Notifications {

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$1 */
    class C15561 extends BaseGamesApiMethodImpl<GameMuteStatusChangeResult> {
        final /* synthetic */ String aaR;

        /* renamed from: Y */
        public GameMuteStatusChangeResult m5047Y(final Status status) {
            return new GameMuteStatusChangeResult(this) {
                final /* synthetic */ C15561 aaS;

                public Status getStatus() {
                    return status;
                }
            };
        }

        /* renamed from: a */
        protected void m5049a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4204e((C0155b) this, this.aaR, true);
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m5047Y(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$2 */
    class C15572 extends BaseGamesApiMethodImpl<GameMuteStatusChangeResult> {
        final /* synthetic */ String aaR;

        /* renamed from: Y */
        public GameMuteStatusChangeResult m5051Y(final Status status) {
            return new GameMuteStatusChangeResult(this) {
                final /* synthetic */ C15572 aaT;

                public Status getStatus() {
                    return status;
                }
            };
        }

        /* renamed from: a */
        protected void m5053a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4204e((C0155b) this, this.aaR, false);
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m5051Y(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$3 */
    class C15583 extends BaseGamesApiMethodImpl<GameMuteStatusLoadResult> {
        final /* synthetic */ String aaR;

        /* renamed from: Z */
        public GameMuteStatusLoadResult m5055Z(final Status status) {
            return new GameMuteStatusLoadResult(this) {
                final /* synthetic */ C15583 aaU;

                public Status getStatus() {
                    return status;
                }
            };
        }

        /* renamed from: a */
        protected void m5057a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4229p((C0155b) this, this.aaR);
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m5055Z(status);
        }
    }

    private static abstract class ContactSettingLoadImpl extends BaseGamesApiMethodImpl<ContactSettingLoadResult> {
        public ContactSettingLoadResult aa(final Status status) {
            return new ContactSettingLoadResult(this) {
                final /* synthetic */ ContactSettingLoadImpl aaX;

                public Status getStatus() {
                    return status;
                }
            };
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return aa(status);
        }
    }

    private static abstract class ContactSettingUpdateImpl extends BaseGamesApiMethodImpl<Status> {
        /* renamed from: b */
        public Status m5060b(Status status) {
            return status;
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m5060b(status);
        }
    }

    private static abstract class InboxCountImpl extends BaseGamesApiMethodImpl<InboxCountResult> {
        public InboxCountResult ab(final Status status) {
            return new InboxCountResult(this) {
                final /* synthetic */ InboxCountImpl aaY;

                public Status getStatus() {
                    return status;
                }
            };
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return ab(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$4 */
    class C16994 extends ContactSettingLoadImpl {
        final /* synthetic */ boolean ZW;

        /* renamed from: a */
        protected void m5415a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4216h((C0155b) this, this.ZW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$5 */
    class C17005 extends ContactSettingUpdateImpl {
        final /* synthetic */ boolean aaV;
        final /* synthetic */ Bundle aaW;

        /* renamed from: a */
        protected void m5417a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4153a((C0155b) this, this.aaV, this.aaW);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$6 */
    class C17016 extends InboxCountImpl {
        /* renamed from: a */
        protected void m5419a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4217i(this);
        }
    }

    public void clear(GoogleApiClient apiClient, int notificationTypes) {
        Games.m659d(apiClient).dT(notificationTypes);
    }

    public void clearAll(GoogleApiClient apiClient) {
        clear(apiClient, 31);
    }
}
