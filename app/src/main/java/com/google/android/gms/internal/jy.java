package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.C0275g;
import com.google.android.gms.dynamic.C0275g.C0274a;
import com.google.android.gms.dynamic.C1332e;
import com.google.android.gms.internal.ju.C1010a;

public final class jy extends C0275g<ju> {
    private static final jy Nt = new jy();

    private jy() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    /* renamed from: b */
    public static View m3363b(Context context, int i, int i2) throws C0274a {
        return Nt.m3364c(context, i, i2);
    }

    /* renamed from: c */
    private View m3364c(Context context, int i, int i2) throws C0274a {
        try {
            return (View) C1332e.m4012f(((ju) m513L(context)).mo1905a(C1332e.m4013k(context), i, i2));
        } catch (Throwable e) {
            throw new C0274a("Could not get button with size " + i + " and color " + i2, e);
        }
    }

    /* renamed from: S */
    public ju m3365S(IBinder iBinder) {
        return C1010a.m3362R(iBinder);
    }

    /* renamed from: d */
    public /* synthetic */ Object mo1672d(IBinder iBinder) {
        return m3365S(iBinder);
    }
}
