package com.google.android.gms.analytics;

import android.os.Build.VERSION;
import java.io.File;

/* renamed from: com.google.android.gms.analytics.t */
public class C0128t {
    public static boolean ag(String str) {
        if (C0128t.version() < 9) {
            return false;
        }
        File file = new File(str);
        file.setReadable(false, false);
        file.setWritable(false, false);
        file.setReadable(true, true);
        file.setWritable(true, true);
        return true;
    }

    public static int version() {
        try {
            return Integer.parseInt(VERSION.SDK);
        } catch (NumberFormatException e) {
            ae.m42T("Invalid version number: " + VERSION.SDK);
            return 0;
        }
    }
}
