package com.google.android.gms.internal;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.io.File;

@ey
public final class gm {
    /* renamed from: a */
    public static void m1321a(Context context, WebSettings webSettings) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            webSettings.setAppCachePath(cacheDir.getAbsolutePath());
            webSettings.setAppCacheMaxSize(0);
            webSettings.setAppCacheEnabled(true);
        }
        webSettings.setDatabasePath(context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
    }

    /* renamed from: a */
    public static void m1322a(Window window) {
        window.setFlags(ViewCompat.MEASURED_STATE_TOO_SMALL, ViewCompat.MEASURED_STATE_TOO_SMALL);
    }

    /* renamed from: a */
    public static void m1323a(WebView webView) {
        webView.onPause();
    }

    /* renamed from: b */
    public static void m1324b(WebView webView) {
        webView.onResume();
    }

    /* renamed from: i */
    public static void m1325i(View view) {
        view.setLayerType(1, null);
    }

    /* renamed from: j */
    public static void m1326j(View view) {
        view.setLayerType(0, null);
    }
}
