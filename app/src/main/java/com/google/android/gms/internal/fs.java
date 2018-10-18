package com.google.android.gms.internal;

import java.util.Map;
import java.util.concurrent.Future;

@ey
public final class fs {
    private final Object mH = new Object();
    gu mo;
    private String uE;
    private gj<fu> uF = new gj();
    public final cd uG = new C09701(this);
    public final cd uH = new C09712(this);

    /* renamed from: com.google.android.gms.internal.fs$1 */
    class C09701 implements cd {
        final /* synthetic */ fs uI;

        C09701(fs fsVar) {
            this.uI = fsVar;
        }

        /* renamed from: a */
        public void mo1660a(gu guVar, Map<String, String> map) {
            synchronized (this.uI.mH) {
                if (this.uI.uF.isDone()) {
                    return;
                }
                fu fuVar = new fu(1, map);
                gr.m1341W("Invalid " + fuVar.getType() + " request error: " + fuVar.cT());
                this.uI.uF.m1316a(fuVar);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.fs$2 */
    class C09712 implements cd {
        final /* synthetic */ fs uI;

        C09712(fs fsVar) {
            this.uI = fsVar;
        }

        /* renamed from: a */
        public void mo1660a(gu guVar, Map<String, String> map) {
            synchronized (this.uI.mH) {
                if (this.uI.uF.isDone()) {
                    return;
                }
                fu fuVar = new fu(-2, map);
                String url = fuVar.getUrl();
                if (url == null) {
                    gr.m1341W("URL missing in loadAdUrl GMSG.");
                    return;
                }
                if (url.contains("%40mediation_adapters%40")) {
                    String replaceAll = url.replaceAll("%40mediation_adapters%40", ge.m1277a(guVar.getContext(), (String) map.get("check_adapters"), this.uI.uE));
                    fuVar.setUrl(replaceAll);
                    gr.m1340V("Ad request URL modified to " + replaceAll);
                }
                this.uI.uF.m1316a(fuVar);
            }
        }
    }

    public fs(String str) {
        this.uE = str;
    }

    /* renamed from: b */
    public void m1236b(gu guVar) {
        jx.aU("setAdWebView must be called on the main thread.");
        this.mo = guVar;
    }

    public Future<fu> cR() {
        return this.uF;
    }

    public void cS() {
        jx.aU("destroyAdWebView must be called on the main thread.");
        if (this.mo != null) {
            this.mo.destroy();
            this.mo = null;
        }
    }
}
