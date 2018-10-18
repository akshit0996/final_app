package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.C0101a;
import java.util.Date;
import java.util.HashSet;

@ey
public final class dg {

    /* renamed from: com.google.android.gms.internal.dg$1 */
    static /* synthetic */ class C03961 {
        static final /* synthetic */ int[] rb = new int[Gender.values().length];

        static {
            rc = new int[ErrorCode.values().length];
            try {
                rc[ErrorCode.INTERNAL_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                rc[ErrorCode.INVALID_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                rc[ErrorCode.NETWORK_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                rc[ErrorCode.NO_FILL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                rb[Gender.FEMALE.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                rb[Gender.MALE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                rb[Gender.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    /* renamed from: a */
    public static int m1113a(ErrorCode errorCode) {
        switch (errorCode) {
            case INVALID_REQUEST:
                return 1;
            case NETWORK_ERROR:
                return 2;
            case NO_FILL:
                return 3;
            default:
                return 0;
        }
    }

    /* renamed from: b */
    public static AdSize m1114b(ay ayVar) {
        int i = 0;
        AdSize[] adSizeArr = new AdSize[]{AdSize.SMART_BANNER, AdSize.BANNER, AdSize.IAB_MRECT, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_WIDE_SKYSCRAPER};
        while (i < adSizeArr.length) {
            if (adSizeArr[i].getWidth() == ayVar.width && adSizeArr[i].getHeight() == ayVar.height) {
                return adSizeArr[i];
            }
            i++;
        }
        return new AdSize(C0101a.m10a(ayVar.width, ayVar.height, ayVar.op));
    }

    /* renamed from: d */
    public static MediationAdRequest m1115d(av avVar) {
        return new MediationAdRequest(new Date(avVar.od), m1116l(avVar.oe), avVar.of != null ? new HashSet(avVar.of) : null, avVar.og, avVar.ol);
    }

    /* renamed from: l */
    public static Gender m1116l(int i) {
        switch (i) {
            case 1:
                return Gender.MALE;
            case 2:
                return Gender.FEMALE;
            default:
                return Gender.UNKNOWN;
        }
    }
}
