package com.google.android.gms.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.purchase.InAppPurchaseActivity;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.eo.C0946a;

@ey
public class ee extends C0946a implements ServiceConnection {
    private final Activity nB;
    private eb sF;
    private final eh sG;
    private ek sI;
    private Context sO;
    private em sP;
    private ef sQ;
    private ej sR;
    private String sS = null;

    public ee(Activity activity) {
        this.nB = activity;
        this.sG = eh.m1161j(this.nB.getApplicationContext());
    }

    /* renamed from: a */
    public static void m4368a(Context context, boolean z, ea eaVar) {
        Intent intent = new Intent();
        intent.setClassName(context, InAppPurchaseActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.purchase.useClientJar", z);
        ea.m3123a(intent, eaVar);
        context.startActivity(intent);
    }

    /* renamed from: a */
    private void m4369a(String str, boolean z, int i, Intent intent) {
        if (this.sR != null) {
            this.sR.mo3587a(str, z, i, intent, this.sQ);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1001) {
            boolean z = false;
            try {
                int d = ei.m1169d(data);
                if (resultCode != -1 || d != 0) {
                    this.sG.m1163a(this.sQ);
                } else if (this.sI.m1173a(this.sS, resultCode, data)) {
                    z = true;
                }
                this.sP.recordPlayBillingResolution(d);
                this.nB.finish();
                m4369a(this.sP.getProductId(), z, resultCode, data);
            } catch (RemoteException e) {
                gr.m1341W("Fail to process purchase result.");
                this.nB.finish();
            } finally {
                this.sS = null;
            }
        }
    }

    public void onCreate() {
        ea c = ea.m3124c(this.nB.getIntent());
        this.sR = c.sB;
        this.sI = c.md;
        this.sP = c.sz;
        this.sF = new eb(this.nB.getApplicationContext());
        this.sO = c.sA;
        if (this.nB.getResources().getConfiguration().orientation == 2) {
            this.nB.setRequestedOrientation(6);
        } else {
            this.nB.setRequestedOrientation(7);
        }
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
        this.nB.bindService(intent, this, 1);
    }

    public void onDestroy() {
        this.nB.unbindService(this);
        this.sF.destroy();
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        Throwable e;
        this.sF.m1160t(service);
        try {
            this.sS = this.sI.cC();
            Bundle a = this.sF.m1157a(this.nB.getPackageName(), this.sP.getProductId(), this.sS);
            PendingIntent pendingIntent = (PendingIntent) a.getParcelable("BUY_INTENT");
            if (pendingIntent == null) {
                int b = ei.m1168b(a);
                this.sP.recordPlayBillingResolution(b);
                m4369a(this.sP.getProductId(), false, b, null);
                this.nB.finish();
                return;
            }
            this.sQ = new ef(this.sP.getProductId(), this.sS);
            this.sG.m1164b(this.sQ);
            this.nB.startIntentSenderForResult(pendingIntent.getIntentSender(), 1001, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
        } catch (RemoteException e2) {
            e = e2;
            gr.m1345d("Error when connecting in-app billing service", e);
            this.nB.finish();
        } catch (SendIntentException e3) {
            e = e3;
            gr.m1345d("Error when connecting in-app billing service", e);
            this.nB.finish();
        }
    }

    public void onServiceDisconnected(ComponentName name) {
        gr.m1339U("In-app billing service disconnected.");
        this.sF.destroy();
    }
}
