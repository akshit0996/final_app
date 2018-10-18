package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;

/* renamed from: com.google.android.gms.internal.k */
public class C0484k {
    private String kU = "googleads.g.doubleclick.net";
    private String kV = "/pagead/ads";
    private String kW = "ad.doubleclick.net";
    private String[] kX = new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private C0434g kY;

    public C0484k(C0434g c0434g) {
        this.kY = c0434g;
    }

    /* renamed from: a */
    private Uri m1588a(Uri uri, Context context, String str, boolean z) throws C0486l {
        try {
            boolean a = m1594a(uri);
            if (a) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new C0486l("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new C0486l("Query parameter already exists: ms");
            }
            String a2 = z ? this.kY.mo1799a(context, str) : this.kY.mo1798a(context);
            return a ? m1590b(uri, "dc_ms", a2) : m1589a(uri, "ms", a2);
        } catch (UnsupportedOperationException e) {
            throw new C0486l("Provided Uri is not in a valid state");
        }
    }

    /* renamed from: a */
    private Uri m1589a(Uri uri, String str, String str2) throws UnsupportedOperationException {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl");
        }
        return indexOf != -1 ? Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str).append("=").append(str2).append("&").append(uri2.substring(indexOf + 1)).toString()) : uri.buildUpon().appendQueryParameter(str, str2).build();
    }

    /* renamed from: b */
    private Uri m1590b(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf(";adurl");
        if (indexOf != -1) {
            return Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str).append("=").append(str2).append(";").append(uri2.substring(indexOf + 1)).toString());
        }
        String encodedPath = uri.getEncodedPath();
        int indexOf2 = uri2.indexOf(encodedPath);
        return Uri.parse(new StringBuilder(uri2.substring(0, encodedPath.length() + indexOf2)).append(";").append(str).append("=").append(str2).append(";").append(uri2.substring(encodedPath.length() + indexOf2)).toString());
    }

    /* renamed from: C */
    public C0434g m1591C() {
        return this.kY;
    }

    /* renamed from: a */
    public Uri m1592a(Uri uri, Context context) throws C0486l {
        try {
            return m1588a(uri, context, uri.getQueryParameter("ai"), true);
        } catch (UnsupportedOperationException e) {
            throw new C0486l("Provided Uri is not in a valid state");
        }
    }

    /* renamed from: a */
    public void m1593a(MotionEvent motionEvent) {
        this.kY.mo1801a(motionEvent);
    }

    /* renamed from: a */
    public boolean m1594a(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.kW);
        } catch (NullPointerException e) {
            return false;
        }
    }

    /* renamed from: b */
    public boolean m1595b(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String endsWith : this.kX) {
                if (host.endsWith(endsWith)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }
}
