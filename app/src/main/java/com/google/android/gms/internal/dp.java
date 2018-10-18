package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.dx.C0937a;
import com.google.android.gms.internal.gv.C0447a;

@ey
public class dp extends C0937a {
    private static final int rL = Color.argb(0, 0, 0, 0);
    private gu mo;
    private final Activity nB;
    private dr rM;
    private dt rN;
    private C0405c rO;
    private du rP;
    private boolean rQ;
    private boolean rR = false;
    private FrameLayout rS;
    private CustomViewCallback rT;
    private boolean rU = false;
    private boolean rV = false;
    private boolean rW = false;
    private RelativeLayout rX;

    @ey
    /* renamed from: com.google.android.gms.internal.dp$a */
    private static final class C0403a extends Exception {
        public C0403a(String str) {
            super(str);
        }
    }

    @ey
    /* renamed from: com.google.android.gms.internal.dp$b */
    private static final class C0404b extends RelativeLayout {
        private final gl lJ;

        public C0404b(Context context, String str) {
            super(context);
            this.lJ = new gl(context, str);
        }

        public boolean onInterceptTouchEvent(MotionEvent event) {
            this.lJ.m1320c(event);
            return false;
        }
    }

    @ey
    /* renamed from: com.google.android.gms.internal.dp$c */
    private static final class C0405c {
        public final int index;
        public final LayoutParams rZ;
        public final ViewGroup sa;

        public C0405c(gu guVar) throws C0403a {
            this.rZ = guVar.getLayoutParams();
            ViewParent parent = guVar.getParent();
            if (parent instanceof ViewGroup) {
                this.sa = (ViewGroup) parent;
                this.index = this.sa.indexOfChild(guVar);
                this.sa.removeView(guVar);
                guVar.m1359z(true);
                return;
            }
            throw new C0403a("Could not get the parent of the WebView for an overlay.");
        }
    }

    /* renamed from: com.google.android.gms.internal.dp$1 */
    class C09351 implements C0447a {
        final /* synthetic */ dp rY;

        C09351(dp dpVar) {
            this.rY = dpVar;
        }

        /* renamed from: a */
        public void mo1661a(gu guVar) {
            guVar.ci();
        }
    }

    public dp(Activity activity) {
        this.nB = activity;
    }

    /* renamed from: a */
    private static RelativeLayout.LayoutParams m4357a(int i, int i2, int i3, int i4) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        return layoutParams;
    }

    /* renamed from: a */
    public static void m4358a(Context context, dr drVar) {
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", drVar.lO.wV);
        dr.m3110a(intent, drVar);
        if (!ll.in()) {
            intent.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(DriveFile.MODE_READ_ONLY);
        }
        context.startActivity(intent);
    }

    /* renamed from: X */
    public void mo1753X() {
        this.rQ = true;
    }

    /* renamed from: a */
    public void m4360a(View view, CustomViewCallback customViewCallback) {
        this.rS = new FrameLayout(this.nB);
        this.rS.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.rS.addView(view, -1, -1);
        this.nB.setContentView(this.rS);
        mo1753X();
        this.rT = customViewCallback;
        this.rR = true;
    }

    /* renamed from: b */
    public void m4361b(int i, int i2, int i3, int i4) {
        if (this.rN != null) {
            this.rN.setLayoutParams(m4357a(i, i2, i3, i4));
        }
    }

    /* renamed from: c */
    public void m4362c(int i, int i2, int i3, int i4) {
        if (this.rN == null) {
            this.rN = new dt(this.nB, this.mo);
            this.rX.addView(this.rN, 0, m4357a(i, i2, i3, i4));
            this.mo.dD().m1363A(false);
        }
    }

    public dt ce() {
        return this.rN;
    }

    public void cf() {
        if (this.rM != null && this.rR) {
            setRequestedOrientation(this.rM.orientation);
        }
        if (this.rS != null) {
            this.nB.setContentView(this.rX);
            mo1753X();
            this.rS.removeAllViews();
            this.rS = null;
        }
        if (this.rT != null) {
            this.rT.onCustomViewHidden();
            this.rT = null;
        }
        this.rR = false;
    }

    public void cg() {
        this.rX.removeView(this.rP);
        m4363p(true);
    }

    void ch() {
        if (this.nB.isFinishing() && !this.rV) {
            this.rV = true;
            if (this.nB.isFinishing()) {
                if (this.mo != null) {
                    cj();
                    this.rX.removeView(this.mo);
                    if (this.rO != null) {
                        this.mo.m1359z(false);
                        this.rO.sa.addView(this.mo, this.rO.index, this.rO.rZ);
                    }
                }
                if (this.rM != null && this.rM.sd != null) {
                    this.rM.sd.ag();
                }
            }
        }
    }

    void ci() {
        this.mo.ci();
    }

    void cj() {
        this.mo.cj();
    }

    public void close() {
        this.nB.finish();
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean z = false;
        if (savedInstanceState != null) {
            z = savedInstanceState.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        this.rU = z;
        try {
            this.rM = dr.m3111b(this.nB.getIntent());
            if (this.rM == null) {
                throw new C0403a("Could not get info for ad overlay.");
            }
            if (this.rM.sn != null) {
                this.rW = this.rM.sn.mi;
            } else {
                this.rW = false;
            }
            if (savedInstanceState == null) {
                if (this.rM.sd != null) {
                    this.rM.sd.ah();
                }
                if (!(this.rM.sk == 1 || this.rM.sc == null)) {
                    this.rM.sc.onAdClicked();
                }
            }
            switch (this.rM.sk) {
                case 1:
                    m4365r(false);
                    return;
                case 2:
                    this.rO = new C0405c(this.rM.se);
                    m4365r(false);
                    return;
                case 3:
                    m4365r(true);
                    return;
                case 4:
                    if (this.rU) {
                        this.nB.finish();
                        return;
                    } else if (!dm.m1136a(this.nB, this.rM.sb, this.rM.sj)) {
                        this.nB.finish();
                        return;
                    } else {
                        return;
                    }
                default:
                    throw new C0403a("Could not determine ad overlay type.");
            }
        } catch (C0403a e) {
            gr.m1341W(e.getMessage());
            this.nB.finish();
        }
    }

    public void onDestroy() {
        if (this.rN != null) {
            this.rN.destroy();
        }
        if (this.mo != null) {
            this.rX.removeView(this.mo);
        }
        ch();
    }

    public void onPause() {
        if (this.rN != null) {
            this.rN.pause();
        }
        cf();
        if (this.mo != null && (!this.nB.isFinishing() || this.rO == null)) {
            gi.m1298a(this.mo);
        }
        ch();
    }

    public void onRestart() {
    }

    public void onResume() {
        if (this.rM != null && this.rM.sk == 4) {
            if (this.rU) {
                this.nB.finish();
            } else {
                this.rU = true;
            }
        }
        if (this.mo != null) {
            gi.m1303b(this.mo);
        }
    }

    public void onSaveInstanceState(Bundle outBundle) {
        outBundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.rU);
    }

    public void onStart() {
    }

    public void onStop() {
        ch();
    }

    /* renamed from: p */
    public void m4363p(boolean z) {
        this.rP = new du(this.nB, z ? 50 : 32);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        this.rP.m1151q(this.rM.sh);
        this.rX.addView(this.rP, layoutParams);
    }

    /* renamed from: q */
    public void m4364q(boolean z) {
        if (this.rP != null) {
            this.rP.m1151q(z);
        }
    }

    /* renamed from: r */
    void m4365r(boolean z) throws C0403a {
        if (!this.rQ) {
            this.nB.requestWindowFeature(1);
        }
        Window window = this.nB.getWindow();
        if (!this.rW || this.rM.sn.ms) {
            window.setFlags(1024, 1024);
        }
        setRequestedOrientation(this.rM.orientation);
        if (VERSION.SDK_INT >= 11) {
            gr.m1337S("Enabling hardware acceleration on the AdActivity window.");
            gm.m1322a(window);
        }
        this.rX = new C0404b(this.nB, this.rM.sm);
        if (this.rW) {
            this.rX.setBackgroundColor(rL);
        } else {
            this.rX.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        this.nB.setContentView(this.rX);
        mo1753X();
        boolean dN = this.rM.se.dD().dN();
        if (z) {
            this.mo = gu.m1350a(this.nB, this.rM.se.ac(), true, dN, null, this.rM.lO);
            this.mo.dD().m1368a(null, null, this.rM.sf, this.rM.sj, true, this.rM.sl, this.rM.se.dD().dM());
            this.mo.dD().m1366a(new C09351(this));
            if (this.rM.rH != null) {
                this.mo.loadUrl(this.rM.rH);
            } else if (this.rM.si != null) {
                this.mo.loadDataWithBaseURL(this.rM.sg, this.rM.si, "text/html", "UTF-8", null);
            } else {
                throw new C0403a("No URL or HTML to display in ad overlay.");
            }
        }
        this.mo = this.rM.se;
        this.mo.setContext(this.nB);
        this.mo.m1354a(this);
        ViewParent parent = this.mo.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.mo);
        }
        if (this.rW) {
            this.mo.setBackgroundColor(rL);
        }
        this.rX.addView(this.mo, -1, -1);
        if (!z) {
            ci();
        }
        m4363p(dN);
        if (this.mo.dE()) {
            m4364q(true);
        }
    }

    public void setRequestedOrientation(int requestedOrientation) {
        this.nB.setRequestedOrientation(requestedOrientation);
    }
}
