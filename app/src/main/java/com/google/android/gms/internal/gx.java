package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@ey
public class gx extends gv {
    public gx(gu guVar, boolean z) {
        super(guVar, z);
    }

    /* renamed from: d */
    protected WebResourceResponse m3211d(Context context, String str, String str2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
        WebResourceResponse webResourceResponse = true;
        try {
            gi.m1297a(context, str, true, httpURLConnection, true);
            httpURLConnection.addRequestProperty("Cache-Control", "max-stale=3600");
            httpURLConnection.connect();
            webResourceResponse = new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(gi.m1289a(new InputStreamReader(httpURLConnection.getInputStream())).getBytes("UTF-8")));
            return webResourceResponse;
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String url) {
        try {
            if (!"mraid.js".equalsIgnoreCase(new File(url).getName())) {
                return super.shouldInterceptRequest(webView, url);
            }
            if (webView instanceof gu) {
                gu guVar = (gu) webView;
                guVar.dD().cg();
                if (guVar.ac().oq) {
                    gr.m1340V("shouldInterceptRequest(https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_interstitial.js)");
                    return m3211d(guVar.getContext(), this.mo.dG().wS, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_interstitial.js");
                } else if (guVar.dH()) {
                    gr.m1340V("shouldInterceptRequest(https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_expanded_banner.js)");
                    return m3211d(guVar.getContext(), this.mo.dG().wS, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_expanded_banner.js");
                } else {
                    gr.m1340V("shouldInterceptRequest(https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_banner.js)");
                    return m3211d(guVar.getContext(), this.mo.dG().wS, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_banner.js");
                }
            }
            gr.m1341W("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return super.shouldInterceptRequest(webView, url);
        } catch (IOException e) {
            gr.m1341W("Could not fetch MRAID JS. " + e.getMessage());
            return super.shouldInterceptRequest(webView, url);
        }
    }
}
