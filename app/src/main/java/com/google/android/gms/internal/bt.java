package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.dynamic.C0272d;
import com.google.android.gms.dynamic.C1332e;
import com.google.android.gms.internal.bv.C0380a;
import com.google.android.gms.internal.bw.C0915a;

@ey
public class bt extends C0915a implements C0380a {
    private final Object mH = new Object();
    private final String pB;
    private final Drawable pC;
    private final String pD;
    private final Drawable pE;
    private final String pF;
    private final double pG;
    private final String pH;
    private final String pI;
    private bv pJ;

    public bt(String str, Drawable drawable, String str2, Drawable drawable2, String str3, double d, String str4, String str5) {
        this.pB = str;
        this.pC = drawable;
        this.pD = str2;
        this.pE = drawable2;
        this.pF = str3;
        this.pG = d;
        this.pH = str4;
        this.pI = str5;
    }

    /* renamed from: a */
    public void mo3306a(bv bvVar) {
        synchronized (this.mH) {
            this.pJ = bvVar;
        }
    }

    public void aw() {
        synchronized (this.mH) {
            if (this.pJ == null) {
                gr.m1338T("Attempt to record impression before app install ad initialized.");
                return;
            }
            this.pJ.aw();
        }
    }

    public String bB() {
        return this.pB;
    }

    public C0272d bC() {
        return C1332e.m4013k(this.pC);
    }

    public C0272d bD() {
        return C1332e.m4013k(this.pE);
    }

    public String bE() {
        return this.pF;
    }

    public double bF() {
        return this.pG;
    }

    public String bG() {
        return this.pH;
    }

    public String bH() {
        return this.pI;
    }

    public String getBody() {
        return this.pD;
    }

    /* renamed from: j */
    public void mo3316j(int i) {
        synchronized (this.mH) {
            if (this.pJ == null) {
                gr.m1338T("Attempt to perform click before app install ad initialized.");
                return;
            }
            this.pJ.m1091b("2", i);
        }
    }
}
