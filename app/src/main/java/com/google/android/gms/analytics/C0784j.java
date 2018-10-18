package com.google.android.gms.analytics;

import com.google.android.gms.wallet.WalletConstants;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.analytics.j */
public class C0784j implements C0124o {
    private final Set<Integer> yo = new HashSet();

    C0784j() {
        this.yo.add(Integer.valueOf(302));
        this.yo.add(Integer.valueOf(WalletConstants.ERROR_CODE_INVALID_PARAMETERS));
        this.yo.add(Integer.valueOf(502));
    }

    public int eb() {
        return 2036;
    }

    public int ec() {
        return 8192;
    }

    public int ed() {
        return 8192;
    }

    public int ee() {
        return 20;
    }

    public long ef() {
        return 3600;
    }

    public String eg() {
        return "/collect";
    }

    public String eh() {
        return "/batch";
    }

    public C0118i ei() {
        return C0118i.BATCH_BY_SESSION;
    }

    public C0120l ej() {
        return C0120l.GZIP;
    }

    public Set<Integer> ek() {
        return this.yo;
    }
}
