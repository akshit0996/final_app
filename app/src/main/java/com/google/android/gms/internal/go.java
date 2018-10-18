package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebSettings;

@ey
public final class go {
    /* renamed from: a */
    public static void m1329a(Context context, WebSettings webSettings) {
        gm.m1321a(context, webSettings);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
    }

    public static String getDefaultUserAgent(Context context) {
        return WebSettings.getDefaultUserAgent(context);
    }
}
