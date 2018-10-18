package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

@ey
public final class dm {
    /* renamed from: a */
    public static boolean m1136a(Context context, C0934do c0934do, dv dvVar) {
        if (c0934do == null) {
            gr.m1341W("No intent data for launcher overlay.");
            return false;
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(c0934do.rH)) {
            gr.m1341W("Open GMSG did not contain a URL.");
            return false;
        }
        if (TextUtils.isEmpty(c0934do.mimeType)) {
            intent.setData(Uri.parse(c0934do.rH));
        } else {
            intent.setDataAndType(Uri.parse(c0934do.rH), c0934do.mimeType);
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(c0934do.packageName)) {
            intent.setPackage(c0934do.packageName);
        }
        if (!TextUtils.isEmpty(c0934do.rI)) {
            String[] split = c0934do.rI.split("/", 2);
            if (split.length < 2) {
                gr.m1341W("Could not parse component name from open GMSG: " + c0934do.rI);
                return false;
            }
            intent.setClassName(split[0], split[1]);
        }
        try {
            gr.m1340V("Launching an intent: " + intent);
            context.startActivity(intent);
            dvVar.af();
            return true;
        } catch (ActivityNotFoundException e) {
            gr.m1341W(e.getMessage());
            return false;
        }
    }
}
