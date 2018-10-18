package com.google.android.gms.tagmanager;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.CampaignTrackingService;

public final class InstallReferrerService extends IntentService {
    CampaignTrackingService arF;
    Context arG;

    public InstallReferrerService() {
        super("InstallReferrerService");
    }

    public InstallReferrerService(String name) {
        super(name);
    }

    /* renamed from: a */
    private void m2083a(Context context, Intent intent) {
        if (this.arF == null) {
            this.arF = new CampaignTrackingService();
        }
        this.arF.processIntent(context, intent);
    }

    protected void onHandleIntent(Intent intent) {
        String stringExtra = intent.getStringExtra("referrer");
        Context applicationContext = this.arG != null ? this.arG : getApplicationContext();
        ay.m2104d(applicationContext, stringExtra);
        m2083a(applicationContext, intent);
    }
}
