package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0271c;
import com.google.android.gms.dynamic.C0275g;
import com.google.android.gms.dynamic.C1332e;
import com.google.android.gms.internal.qd.C1070a;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public class qi extends C0275g<qd> {
    private static qi awH;

    protected qi() {
        super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
    }

    /* renamed from: a */
    public static qa m3534a(Activity activity, C0271c c0271c, WalletFragmentOptions walletFragmentOptions, qb qbVar) throws GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
        if (isGooglePlayServicesAvailable != 0) {
            throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
        try {
            return ((qd) rg().m513L(activity)).mo2101a(C1332e.m4013k(activity), c0271c, walletFragmentOptions, qbVar);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
    }

    private static qi rg() {
        if (awH == null) {
            awH = new qi();
        }
        return awH;
    }

    protected qd bW(IBinder iBinder) {
        return C1070a.bS(iBinder);
    }

    /* renamed from: d */
    protected /* synthetic */ Object mo1672d(IBinder iBinder) {
        return bW(iBinder);
    }
}
