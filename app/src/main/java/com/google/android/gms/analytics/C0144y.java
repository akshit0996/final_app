package com.google.android.gms.analytics;

import java.util.SortedSet;
import java.util.TreeSet;

/* renamed from: com.google.android.gms.analytics.y */
class C0144y {
    private static final C0144y zV = new C0144y();
    private SortedSet<C0143a> zS = new TreeSet();
    private StringBuilder zT = new StringBuilder();
    private boolean zU = false;

    /* renamed from: com.google.android.gms.analytics.y$a */
    public enum C0143a {
        MAP_BUILDER_SET,
        MAP_BUILDER_SET_ALL,
        MAP_BUILDER_GET,
        MAP_BUILDER_SET_CAMPAIGN_PARAMS,
        BLANK_04,
        BLANK_05,
        BLANK_06,
        BLANK_07,
        BLANK_08,
        GET,
        SET,
        SEND,
        BLANK_12,
        BLANK_13,
        BLANK_14,
        BLANK_15,
        BLANK_16,
        BLANK_17,
        BLANK_18,
        BLANK_19,
        BLANK_20,
        BLANK_21,
        BLANK_22,
        BLANK_23,
        BLANK_24,
        BLANK_25,
        BLANK_26,
        BLANK_27,
        BLANK_28,
        BLANK_29,
        SET_EXCEPTION_PARSER,
        GET_EXCEPTION_PARSER,
        CONSTRUCT_TRANSACTION,
        CONSTRUCT_EXCEPTION,
        CONSTRUCT_RAW_EXCEPTION,
        CONSTRUCT_TIMING,
        CONSTRUCT_SOCIAL,
        BLANK_37,
        BLANK_38,
        GET_TRACKER,
        GET_DEFAULT_TRACKER,
        SET_DEFAULT_TRACKER,
        SET_APP_OPT_OUT,
        GET_APP_OPT_OUT,
        DISPATCH,
        SET_DISPATCH_PERIOD,
        BLANK_46,
        REPORT_UNCAUGHT_EXCEPTIONS,
        SET_AUTO_ACTIVITY_TRACKING,
        SET_SESSION_TIMEOUT,
        CONSTRUCT_EVENT,
        CONSTRUCT_ITEM,
        BLANK_52,
        BLANK_53,
        SET_DRY_RUN,
        GET_DRY_RUN,
        SET_LOGGER,
        SET_FORCE_LOCAL_DISPATCH,
        GET_TRACKER_NAME,
        CLOSE_TRACKER,
        EASY_TRACKER_ACTIVITY_START,
        EASY_TRACKER_ACTIVITY_STOP,
        CONSTRUCT_APP_VIEW
    }

    private C0144y() {
    }

    public static C0144y eK() {
        return zV;
    }

    /* renamed from: D */
    public synchronized void m85D(boolean z) {
        this.zU = z;
    }

    /* renamed from: a */
    public synchronized void m86a(C0143a c0143a) {
        if (!this.zU) {
            this.zS.add(c0143a);
            this.zT.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(c0143a.ordinal()));
        }
    }

    public synchronized String eL() {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder();
        int i = 6;
        int i2 = 0;
        while (this.zS.size() > 0) {
            C0143a c0143a = (C0143a) this.zS.first();
            this.zS.remove(c0143a);
            int ordinal = c0143a.ordinal();
            while (ordinal >= i) {
                stringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i2));
                i += 6;
                i2 = 0;
            }
            i2 += 1 << (c0143a.ordinal() % 6);
        }
        if (i2 > 0 || stringBuilder.length() == 0) {
            stringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i2));
        }
        this.zS.clear();
        return stringBuilder.toString();
    }

    public synchronized String eM() {
        String stringBuilder;
        if (this.zT.length() > 0) {
            this.zT.insert(0, ".");
        }
        stringBuilder = this.zT.toString();
        this.zT = new StringBuilder();
        return stringBuilder;
    }
}
