package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.ah.C0367a;
import java.util.concurrent.Future;

@ey
public class ai {
    /* renamed from: a */
    protected ah m1003a(Context context, gs gsVar, final gj<ah> gjVar) {
        final ah ajVar = new aj(context, gsVar);
        ajVar.mo1662a(new C0367a(this) {
            final /* synthetic */ ai nj;

            public void aR() {
                gjVar.m1316a(ajVar);
            }
        });
        return ajVar;
    }

    /* renamed from: a */
    public Future<ah> m1004a(Context context, gs gsVar, String str) {
        final Future gjVar = new gj();
        final Context context2 = context;
        final gs gsVar2 = gsVar;
        final String str2 = str;
        gq.wR.post(new Runnable(this) {
            final /* synthetic */ ai nj;

            public void run() {
                this.nj.m1003a(context2, gsVar2, gjVar).mo1667f(str2);
            }
        });
        return gjVar;
    }
}
