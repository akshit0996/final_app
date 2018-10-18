package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.fy.C0432a;

@ey
public final class fc {

    /* renamed from: com.google.android.gms.internal.fc$a */
    public interface C0420a {
        /* renamed from: a */
        void mo3585a(fy fyVar);
    }

    /* renamed from: a */
    public static gf m1204a(Context context, C1440u c1440u, C0432a c0432a, gu guVar, cy cyVar, C0420a c0420a) {
        gf fmVar;
        if (c0432a.vK.ug) {
            fmVar = new fm(context, c1440u, new ai(), c0432a, c0420a);
        } else {
            fmVar = new fd(context, c0432a, guVar, cyVar, c0420a);
        }
        fmVar.start();
        return fmVar;
    }
}
