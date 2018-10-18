package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;

class df {
    private Context mContext;
    private Tracker yO;
    private GoogleAnalytics yQ;

    /* renamed from: com.google.android.gms.tagmanager.df$a */
    static class C1224a implements Logger {
        C1224a() {
        }

        private static int fP(int i) {
            switch (i) {
                case 2:
                    return 0;
                case 3:
                case 4:
                    return 1;
                case 5:
                    return 2;
                default:
                    return 3;
            }
        }

        public void error(Exception exception) {
            bh.m2118b("", exception);
        }

        public void error(String message) {
            bh.m2114T(message);
        }

        public int getLogLevel() {
            return C1224a.fP(bh.getLogLevel());
        }

        public void info(String message) {
            bh.m2115U(message);
        }

        public void setLogLevel(int logLevel) {
            bh.m2117W("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
        }

        public void verbose(String message) {
            bh.m2116V(message);
        }

        public void warn(String message) {
            bh.m2117W(message);
        }
    }

    df(Context context) {
        this.mContext = context;
    }

    private synchronized void cX(String str) {
        if (this.yQ == null) {
            this.yQ = GoogleAnalytics.getInstance(this.mContext);
            this.yQ.setLogger(new C1224a());
            this.yO = this.yQ.newTracker(str);
        }
    }

    public Tracker cW(String str) {
        cX(str);
        return this.yO;
    }
}
