package com.google.android.gms.plus.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.C0275g;
import com.google.android.gms.dynamic.C1332e;
import com.google.android.gms.plus.PlusOneDummyView;
import com.google.android.gms.plus.internal.C0594c.C1198a;

/* renamed from: com.google.android.gms.plus.internal.g */
public final class C1203g extends C0275g<C0594c> {
    private static final C1203g anP = new C1203g();

    private C1203g() {
        super("com.google.android.gms.plus.plusone.PlusOneButtonCreatorImpl");
    }

    /* renamed from: a */
    public static View m3664a(Context context, int i, int i2, String str, int i3) {
        if (str != null) {
            return (View) C1332e.m4012f(((C0594c) anP.m513L(context)).mo2482a(C1332e.m4013k(context), i, i2, str, i3));
        }
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            return new PlusOneDummyView(context, i);
        }
    }

    protected C0594c bO(IBinder iBinder) {
        return C1198a.bL(iBinder);
    }

    /* renamed from: d */
    protected /* synthetic */ Object mo1672d(IBinder iBinder) {
        return bO(iBinder);
    }
}
