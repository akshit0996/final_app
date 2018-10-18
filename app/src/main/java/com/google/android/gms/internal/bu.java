package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.dynamic.C0272d;
import com.google.android.gms.dynamic.C1332e;
import com.google.android.gms.internal.bv.C0380a;
import com.google.android.gms.internal.bx.C0916a;

@ey
public class bu extends C0916a implements C0380a {
    private final Object mH = new Object();
    private final String pB;
    private final Drawable pC;
    private final String pD;
    private final String pF;
    private bv pJ;
    private final Drawable pK;
    private final String pL;

    public bu(String str, Drawable drawable, String str2, Drawable drawable2, String str3, String str4) {
        this.pB = str;
        this.pC = drawable;
        this.pD = str2;
        this.pK = drawable2;
        this.pF = str3;
        this.pL = str4;
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
                gr.m1338T("Attempt to record impression before content ad initialized.");
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

    public String bE() {
        return this.pF;
    }

    public C0272d bI() {
        return C1332e.m4013k(this.pK);
    }

    public String bJ() {
        return this.pL;
    }

    public String getBody() {
        return this.pD;
    }

    /* renamed from: j */
    public void mo3324j(int i) {
        synchronized (this.mH) {
            if (this.pJ == null) {
                gr.m1338T("Attempt to perform click before content ad initialized.");
                return;
            }
            this.pJ.m1091b("1", i);
        }
    }
}
