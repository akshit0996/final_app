package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.appcontent.AppContents.LoadAppContentResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AppContentsImpl implements AppContents {

    private static abstract class LoadsImpl extends BaseGamesApiMethodImpl<LoadAppContentResult> {
        /* renamed from: N */
        public LoadAppContentResult m5024N(final Status status) {
            return new LoadAppContentResult(this) {
                final /* synthetic */ LoadsImpl aai;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m5024N(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AppContentsImpl$1 */
    class C16741 extends LoadsImpl {
        final /* synthetic */ boolean ZW;
        final /* synthetic */ int aaf;
        final /* synthetic */ String aag;
        final /* synthetic */ String[] aah;

        /* renamed from: a */
        protected void m5341a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m4125a((C0155b) this, this.aaf, this.aag, this.aah, this.ZW);
        }
    }
}
