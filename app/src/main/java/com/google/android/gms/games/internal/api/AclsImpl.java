package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;

public final class AclsImpl implements Acls {

    private static abstract class LoadNotifyAclImpl extends BaseGamesApiMethodImpl<LoadAclResult> {
        /* renamed from: M */
        public LoadAclResult m5020M(Status status) {
            return AclsImpl.m3020K(status);
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m5020M(status);
        }
    }

    private static abstract class UpdateNotifyAclImpl extends BaseGamesApiMethodImpl<Status> {
        /* renamed from: b */
        public Status m5022b(Status status) {
            return status;
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m5022b(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AclsImpl$2 */
    class C16722 extends LoadNotifyAclImpl {
        /* renamed from: a */
        protected void m5337a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4214h(this);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AclsImpl$3 */
    class C16733 extends UpdateNotifyAclImpl {
        final /* synthetic */ String aae;

        /* renamed from: a */
        protected void m5339a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4227o((C0155b) this, this.aae);
        }
    }

    /* renamed from: K */
    private static LoadAclResult m3020K(final Status status) {
        return new LoadAclResult() {
            public Status getStatus() {
                return status;
            }

            public void release() {
            }
        };
    }
}
