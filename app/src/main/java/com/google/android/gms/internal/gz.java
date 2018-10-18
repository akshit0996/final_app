package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.net.URI;
import java.net.URISyntaxException;

@ey
public class gz extends WebViewClient {
    private final gu mo;
    private final String xr;
    private boolean xs = false;
    private final fb xt;

    public gz(fb fbVar, gu guVar, String str) {
        this.xr = m1378Z(str);
        this.mo = guVar;
        this.xt = fbVar;
    }

    /* renamed from: Z */
    private String m1378Z(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (str.endsWith("/")) {
                    str = str.substring(0, str.length() - 1);
                }
            } catch (IndexOutOfBoundsException e) {
                gr.m1338T(e.getMessage());
            }
        }
        return str;
    }

    /* renamed from: Y */
    protected boolean m1379Y(String str) {
        Object Z = m1378Z(str);
        if (TextUtils.isEmpty(Z)) {
            return false;
        }
        try {
            URI uri = new URI(Z);
            if ("passback".equals(uri.getScheme())) {
                gr.m1337S("Passback received");
                this.xt.cG();
                return true;
            } else if (TextUtils.isEmpty(this.xr)) {
                return false;
            } else {
                URI uri2 = new URI(this.xr);
                String host = uri2.getHost();
                String host2 = uri.getHost();
                String path = uri2.getPath();
                String path2 = uri.getPath();
                if (!jv.equal(host, host2) || !jv.equal(path, path2)) {
                    return false;
                }
                gr.m1337S("Passback received");
                this.xt.cG();
                return true;
            }
        } catch (URISyntaxException e) {
            gr.m1338T(e.getMessage());
            return false;
        }
    }

    public void onLoadResource(WebView view, String url) {
        gr.m1337S("JavascriptAdWebViewClient::onLoadResource: " + url);
        if (!m1379Y(url)) {
            this.mo.dD().onLoadResource(this.mo, url);
        }
    }

    public void onPageFinished(WebView view, String url) {
        gr.m1337S("JavascriptAdWebViewClient::onPageFinished: " + url);
        if (!this.xs) {
            this.xt.cF();
            this.xs = true;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        gr.m1337S("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + url);
        if (!m1379Y(url)) {
            return this.mo.dD().shouldOverrideUrlLoading(this.mo, url);
        }
        gr.m1337S("shouldOverrideUrlLoading: received passback url");
        return true;
    }
}
