package com.google.android.gms.internal;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.HashMap;
import java.util.Map;

@ey
public class gv extends WebViewClient {
    private final Object mH;
    protected final gu mo;
    private cb pP;
    private cg qa;
    private ce qc;
    private C0511v qd;
    private C0447a tu;
    private final HashMap<String, cd> xe;
    private C0503t xf;
    private ds xg;
    private boolean xh;
    private boolean xi;
    private dv xj;
    private final dl xk;

    /* renamed from: com.google.android.gms.internal.gv$a */
    public interface C0447a {
        /* renamed from: a */
        void mo1661a(gu guVar);
    }

    public gv(gu guVar, boolean z) {
        this(guVar, z, new dl(guVar, guVar.getContext(), new bl(guVar.getContext())));
    }

    gv(gu guVar, boolean z, dl dlVar) {
        this.xe = new HashMap();
        this.mH = new Object();
        this.xh = false;
        this.mo = guVar;
        this.xi = z;
        this.xk = dlVar;
    }

    /* renamed from: d */
    private static boolean m1361d(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    /* renamed from: e */
    private void m1362e(Uri uri) {
        String path = uri.getPath();
        cd cdVar = (cd) this.xe.get(path);
        if (cdVar != null) {
            Map c = gi.m1305c(uri);
            if (gr.m1346v(2)) {
                gr.m1340V("Received GMSG: " + path);
                for (String path2 : c.keySet()) {
                    gr.m1340V("  " + path2 + ": " + ((String) c.get(path2)));
                }
            }
            cdVar.mo1660a(this.mo, c);
            return;
        }
        gr.m1340V("No GMSG handler found for GMSG: " + uri);
    }

    /* renamed from: A */
    public final void m1363A(boolean z) {
        this.xh = z;
    }

    /* renamed from: a */
    public final void m1364a(C0934do c0934do) {
        ds dsVar = null;
        boolean dH = this.mo.dH();
        C0503t c0503t = (!dH || this.mo.ac().oq) ? this.xf : null;
        if (!dH) {
            dsVar = this.xg;
        }
        m1365a(new dr(c0934do, c0503t, dsVar, this.xj, this.mo.dG()));
    }

    /* renamed from: a */
    protected void m1365a(dr drVar) {
        dp.m4358a(this.mo.getContext(), drVar);
    }

    /* renamed from: a */
    public final void m1366a(C0447a c0447a) {
        this.tu = c0447a;
    }

    /* renamed from: a */
    public void m1367a(C0503t c0503t, ds dsVar, cb cbVar, dv dvVar, boolean z, ce ceVar, cg cgVar, C0511v c0511v) {
        m1368a(c0503t, dsVar, cbVar, dvVar, z, ceVar, c0511v);
        m1369a("/setInterstitialProperties", new cf(cgVar));
        this.qa = cgVar;
    }

    /* renamed from: a */
    public void m1368a(C0503t c0503t, ds dsVar, cb cbVar, dv dvVar, boolean z, ce ceVar, C0511v c0511v) {
        if (c0511v == null) {
            c0511v = new C0511v(false);
        }
        m1369a("/appEvent", new ca(cbVar));
        m1369a("/canOpenURLs", cc.pR);
        m1369a("/canOpenIntents", cc.pS);
        m1369a("/click", cc.pT);
        m1369a("/close", cc.pU);
        m1369a("/customClose", cc.pV);
        m1369a("/httpTrack", cc.pW);
        m1369a("/log", cc.pX);
        m1369a("/open", new ci(ceVar, c0511v));
        m1369a("/touch", cc.pY);
        m1369a("/video", cc.pZ);
        m1369a("/mraid", new ch());
        this.xf = c0503t;
        this.xg = dsVar;
        this.pP = cbVar;
        this.qc = ceVar;
        this.xj = dvVar;
        this.qd = c0511v;
        m1363A(z);
    }

    /* renamed from: a */
    public final void m1369a(String str, cd cdVar) {
        this.xe.put(str, cdVar);
    }

    /* renamed from: a */
    public final void m1370a(boolean z, int i) {
        C0503t c0503t = (!this.mo.dH() || this.mo.ac().oq) ? this.xf : null;
        m1365a(new dr(c0503t, this.xg, this.xj, this.mo, z, i, this.mo.dG()));
    }

    /* renamed from: a */
    public final void m1371a(boolean z, int i, String str) {
        ds dsVar = null;
        boolean dH = this.mo.dH();
        C0503t c0503t = (!dH || this.mo.ac().oq) ? this.xf : null;
        if (!dH) {
            dsVar = this.xg;
        }
        m1365a(new dr(c0503t, dsVar, this.pP, this.xj, this.mo, z, i, str, this.mo.dG(), this.qc));
    }

    /* renamed from: a */
    public final void m1372a(boolean z, int i, String str, String str2) {
        boolean dH = this.mo.dH();
        C0503t c0503t = (!dH || this.mo.ac().oq) ? this.xf : null;
        m1365a(new dr(c0503t, dH ? null : this.xg, this.pP, this.xj, this.mo, z, i, str, str2, this.mo.dG(), this.qc));
    }

    public final void cg() {
        synchronized (this.mH) {
            this.xh = false;
            this.xi = true;
            final dp dC = this.mo.dC();
            if (dC != null) {
                if (gq.dB()) {
                    dC.cg();
                } else {
                    gq.wR.post(new Runnable(this) {
                        final /* synthetic */ gv xm;

                        public void run() {
                            dC.cg();
                        }
                    });
                }
            }
        }
    }

    public C0511v dM() {
        return this.qd;
    }

    public boolean dN() {
        boolean z;
        synchronized (this.mH) {
            z = this.xi;
        }
        return z;
    }

    public void dO() {
        if (dN()) {
            this.xk.bY();
        }
    }

    public final void onLoadResource(WebView webView, String url) {
        gr.m1340V("Loading resource: " + url);
        Uri parse = Uri.parse(url);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            m1362e(parse);
        }
    }

    public final void onPageFinished(WebView webView, String url) {
        if (this.tu != null) {
            this.tu.mo1661a(this.mo);
            this.tu = null;
        }
    }

    public final void reset() {
        synchronized (this.mH) {
            this.xe.clear();
            this.xf = null;
            this.xg = null;
            this.tu = null;
            this.pP = null;
            this.xh = false;
            this.xi = false;
            this.qc = null;
            this.xj = null;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String url) {
        gr.m1340V("AdWebView shouldOverrideUrlLoading: " + url);
        Uri parse = Uri.parse(url);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            m1362e(parse);
        } else if (this.xh && webView == this.mo && m1361d(parse)) {
            return super.shouldOverrideUrlLoading(webView, url);
        } else {
            if (this.mo.willNotDraw()) {
                gr.m1341W("AdWebView unable to handle URL: " + url);
            } else {
                Uri uri;
                try {
                    C0484k dF = this.mo.dF();
                    if (dF != null && dF.m1595b(parse)) {
                        parse = dF.m1592a(parse, this.mo.getContext());
                    }
                    uri = parse;
                } catch (C0486l e) {
                    gr.m1341W("Unable to append parameter to URL: " + url);
                    uri = parse;
                }
                if (this.qd == null || this.qd.az()) {
                    m1364a(new C0934do("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
                } else {
                    this.qd.m1927d(url);
                }
            }
        }
        return true;
    }
}
