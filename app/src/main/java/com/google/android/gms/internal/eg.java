package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.eq.C0950a;

@ey
public final class eg extends C0950a implements ServiceConnection {
    private Context mContext;
    private eb sF;
    private String sM;
    private ef sQ;
    private boolean sW = false;
    private int sX;
    private Intent sY;

    public eg(Context context, String str, boolean z, int i, Intent intent, ef efVar) {
        this.sM = str;
        this.sX = i;
        this.sY = intent;
        this.sW = z;
        this.mContext = context;
        this.sQ = efVar;
    }

    public void finishPurchase() {
        int d = ei.m1169d(this.sY);
        if (this.sX == -1 && d == 0) {
            this.sF = new eb(this.mContext);
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
            this.mContext.bindService(intent, this, 1);
        }
    }

    public String getProductId() {
        return this.sM;
    }

    public Intent getPurchaseData() {
        return this.sY;
    }

    public int getResultCode() {
        return this.sX;
    }

    public boolean isVerified() {
        return this.sW;
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        gr.m1339U("In-app billing service connected.");
        this.sF.m1160t(service);
        String E = ei.m1167E(ei.m1170e(this.sY));
        if (E != null) {
            if (this.sF.m1158c(this.mContext.getPackageName(), E) == 0) {
                eh.m1161j(this.mContext).m1163a(this.sQ);
            }
            this.mContext.unbindService(this);
            this.sF.destroy();
        }
    }

    public void onServiceDisconnected(ComponentName name) {
        gr.m1339U("In-app billing service disconnected.");
        this.sF.destroy();
    }
}
