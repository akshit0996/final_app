package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.ah.C0367a;
import com.google.android.gms.internal.gv.C0447a;
import org.json.JSONObject;

@ey
public class aj implements ah {
    private final gu mo;

    public aj(Context context, gs gsVar) {
        this.mo = gu.m1350a(context, new ay(), false, false, null, gsVar);
    }

    private void runOnUiThread(Runnable runnable) {
        if (gq.dB()) {
            runnable.run();
        } else {
            gq.wR.post(runnable);
        }
    }

    /* renamed from: a */
    public void mo1662a(final C0367a c0367a) {
        this.mo.dD().m1366a(new C0447a(this) {
            final /* synthetic */ aj nn;

            /* renamed from: a */
            public void mo1661a(gu guVar) {
                c0367a.aR();
            }
        });
    }

    /* renamed from: a */
    public void mo1663a(C0503t c0503t, ds dsVar, cb cbVar, dv dvVar, boolean z, ce ceVar) {
        this.mo.dD().m1368a(c0503t, dsVar, cbVar, dvVar, z, ceVar, new C0511v(false));
    }

    /* renamed from: a */
    public void mo1664a(String str, cd cdVar) {
        this.mo.dD().m1369a(str, cdVar);
    }

    /* renamed from: a */
    public void mo1665a(final String str, final JSONObject jSONObject) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ aj nn;

            public void run() {
                this.nn.mo.m1356a(str, jSONObject);
            }
        });
    }

    public void destroy() {
        this.mo.destroy();
    }

    /* renamed from: f */
    public void mo1667f(final String str) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ aj nn;

            public void run() {
                this.nn.mo.loadUrl(str);
            }
        });
    }

    /* renamed from: g */
    public void mo1668g(String str) {
        this.mo.dD().m1369a(str, null);
    }

    public void pause() {
        gi.m1298a(this.mo);
    }

    public void resume() {
        gi.m1303b(this.mo);
    }
}
