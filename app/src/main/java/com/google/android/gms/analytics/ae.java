package com.google.android.gms.analytics;

public class ae {
    private static GoogleAnalytics BL;
    private static volatile boolean BM = false;
    private static Logger BN;

    private ae() {
    }

    /* renamed from: T */
    public static void m42T(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.error(str);
        }
    }

    /* renamed from: U */
    public static void m43U(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.info(str);
        }
    }

    /* renamed from: V */
    public static void m44V(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.verbose(str);
        }
    }

    /* renamed from: W */
    public static void m45W(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.warn(str);
        }
    }

    public static boolean ff() {
        return getLogger() != null && getLogger().getLogLevel() == 0;
    }

    static Logger getLogger() {
        synchronized (ae.class) {
            if (BM) {
                if (BN == null) {
                    BN = new C0786p();
                }
                Logger logger = BN;
                return logger;
            }
            if (BL == null) {
                BL = GoogleAnalytics.eY();
            }
            if (BL != null) {
                logger = BL.getLogger();
                return logger;
            }
            return null;
        }
    }
}
