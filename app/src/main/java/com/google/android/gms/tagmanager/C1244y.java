package com.google.android.gms.tagmanager;

import android.content.Context;
import java.net.URLEncoder;

/* renamed from: com.google.android.gms.tagmanager.y */
class C1244y implements aq {
    private static C1244y arl;
    private static final Object xO = new Object();
    private cg aqC;
    private String arm;
    private String arn;
    private ar aro;

    private C1244y(Context context) {
        this(as.m3679Z(context), new cw());
    }

    C1244y(ar arVar, cg cgVar) {
        this.aro = arVar;
        this.aqC = cgVar;
    }

    /* renamed from: X */
    public static aq m3797X(Context context) {
        aq aqVar;
        synchronized (xO) {
            if (arl == null) {
                arl = new C1244y(context);
            }
            aqVar = arl;
        }
        return aqVar;
    }

    public boolean cB(String str) {
        if (this.aqC.fe()) {
            if (!(this.arm == null || this.arn == null)) {
                try {
                    str = this.arm + "?" + this.arn + "=" + URLEncoder.encode(str, "UTF-8");
                    bh.m2116V("Sending wrapped url hit: " + str);
                } catch (Throwable e) {
                    bh.m2119d("Error wrapping URL for testing.", e);
                    return false;
                }
            }
            this.aro.cE(str);
            return true;
        }
        bh.m2117W("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
        return false;
    }
}
