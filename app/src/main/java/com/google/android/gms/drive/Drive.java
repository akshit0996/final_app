package com.google.android.gms.drive;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.C0153b;
import com.google.android.gms.common.api.Api.C0154c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.drive.internal.C0825p;
import com.google.android.gms.drive.internal.C0830u;
import com.google.android.gms.drive.internal.C0831x;
import com.google.android.gms.drive.internal.C0833z;
import com.google.android.gms.drive.internal.C1317r;
import com.google.android.gms.internal.jg;
import java.util.List;

public final class Drive {
    public static final Api<NoOptions> API = new Api(new C13081(), DQ, new Scope[0]);
    public static final C0154c<C1317r> DQ = new C0154c();
    public static final DriveApi DriveApi = new C0825p();
    public static final DrivePreferencesApi DrivePreferencesApi = new C0831x();
    public static final Scope Oo = new Scope("https://www.googleapis.com/auth/drive");
    public static final Scope Op = new Scope("https://www.googleapis.com/auth/drive.apps");
    public static final Api<C1495b> Oq = new Api(new C13092(), DQ, new Scope[0]);
    public static final C0189b Or = new C0830u();
    public static final C0192e Os = new C0833z();
    public static final Scope SCOPE_APPFOLDER = new Scope(Scopes.DRIVE_APPFOLDER);
    public static final Scope SCOPE_FILE = new Scope(Scopes.DRIVE_FILE);

    /* renamed from: com.google.android.gms.drive.Drive$a */
    public static abstract class C0816a<O extends ApiOptions> implements C0153b<C1317r, O> {
        /* renamed from: a */
        protected abstract Bundle mo2960a(O o);

        /* renamed from: a */
        public C1317r m2511a(Context context, Looper looper, jg jgVar, O o, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            List ho = jgVar.ho();
            return new C1317r(context, looper, jgVar, connectionCallbacks, onConnectionFailedListener, (String[]) ho.toArray(new String[ho.size()]), mo2960a(o));
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    /* renamed from: com.google.android.gms.drive.Drive$1 */
    static class C13081 extends C0816a<NoOptions> {
        C13081() {
        }

        /* renamed from: a */
        protected Bundle m3937a(NoOptions noOptions) {
            return new Bundle();
        }
    }

    /* renamed from: com.google.android.gms.drive.Drive$2 */
    static class C13092 extends C0816a<C1495b> {
        C13092() {
        }

        /* renamed from: a */
        protected Bundle m3940a(C1495b c1495b) {
            return c1495b == null ? new Bundle() : c1495b.iq();
        }
    }

    /* renamed from: com.google.android.gms.drive.Drive$b */
    public static class C1495b implements Optional {
        private final Bundle DJ;

        private C1495b() {
            this(new Bundle());
        }

        private C1495b(Bundle bundle) {
            this.DJ = bundle;
        }

        public Bundle iq() {
            return this.DJ;
        }
    }

    private Drive() {
    }
}
