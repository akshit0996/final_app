package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* renamed from: com.google.android.gms.analytics.u */
class C0129u extends BroadcastReceiver {
    static final String yR = C0129u.class.getName();
    private final aj yS;

    C0129u(aj ajVar) {
        this.yS = ajVar;
    }

    public void onReceive(Context ctx, Intent intent) {
        boolean z = false;
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            aj ajVar = this.yS;
            if (!booleanExtra) {
                z = true;
            }
            ajVar.mo854C(z);
        } else if ("com.google.analytics.RADIO_POWERED".equals(action) && !intent.hasExtra(yR)) {
            this.yS.ey();
        }
    }

    /* renamed from: z */
    public void m80z(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(this, intentFilter);
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.analytics.RADIO_POWERED");
        intentFilter.addCategory(context.getPackageName());
        context.registerReceiver(this, intentFilter);
    }
}
