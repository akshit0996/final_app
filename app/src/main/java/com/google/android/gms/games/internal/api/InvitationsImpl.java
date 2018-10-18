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
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

public final class InvitationsImpl implements Invitations {

    private static abstract class LoadInvitationsImpl extends BaseGamesApiMethodImpl<LoadInvitationsResult> {
        private LoadInvitationsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: T */
        public LoadInvitationsResult m5037T(final Status status) {
            return new LoadInvitationsResult(this) {
                final /* synthetic */ LoadInvitationsImpl aaD;

                public InvitationBuffer getInvitations() {
                    return new InvitationBuffer(DataHolder.av(14));
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
            return m5037T(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.InvitationsImpl$2 */
    class C16882 extends LoadInvitationsImpl {
        final /* synthetic */ String ZZ;
        final /* synthetic */ int aaA;

        /* renamed from: a */
        protected void m5389a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4202e((C0155b) this, this.ZZ, this.aaA);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.InvitationsImpl$3 */
    class C16893 extends LoadInvitationsImpl {
        final /* synthetic */ String aaC;

        /* renamed from: a */
        protected void m5391a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4226n((C0155b) this, this.aaC);
        }
    }

    public Intent getInvitationInboxIntent(GoogleApiClient apiClient) {
        return Games.m659d(apiClient).lo();
    }

    public PendingResult<LoadInvitationsResult> loadInvitations(GoogleApiClient apiClient) {
        return loadInvitations(apiClient, 0);
    }

    public PendingResult<LoadInvitationsResult> loadInvitations(GoogleApiClient apiClient, final int sortOrder) {
        return apiClient.mo926a(new LoadInvitationsImpl(this, apiClient) {
            final /* synthetic */ InvitationsImpl aaB;

            /* renamed from: a */
            protected void m5387a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m4180c((C0155b) this, sortOrder);
            }
        });
    }

    public void registerInvitationListener(GoogleApiClient apiClient, OnInvitationReceivedListener listener) {
        Games.m659d(apiClient).m4157a(apiClient.mo933d(listener));
    }

    public void unregisterInvitationListener(GoogleApiClient apiClient) {
        Games.m659d(apiClient).lp();
    }
}
