package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import com.google.android.gms.internal.ah.C0367a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public final class af implements OnGlobalLayoutListener, OnScrollChangedListener {
    private final Object mH;
    private final WeakReference<fy> mK;
    private WeakReference<ViewTreeObserver> mL;
    private final WeakReference<View> mM;
    private final ad mN;
    private final Context mO;
    private final ah mP;
    private boolean mQ;
    private final WindowManager mR;
    private final PowerManager mS;
    private final KeyguardManager mT;
    private ag mU;
    private boolean mV;
    private final BlockingQueue<Runnable> mW;
    private long mX;
    private boolean mY;
    private boolean mZ;
    private boolean my;
    private BroadcastReceiver na;
    private final HashSet<ac> nb;

    /* renamed from: com.google.android.gms.internal.af$3 */
    class C03653 implements Runnable {
        final /* synthetic */ af nd;

        C03653(af afVar) {
            this.nd = afVar;
        }

        public void run() {
            this.nd.m995g(false);
        }
    }

    /* renamed from: com.google.android.gms.internal.af$4 */
    class C03664 extends BroadcastReceiver {
        final /* synthetic */ af nd;

        C03664(af afVar) {
            this.nd = afVar;
        }

        public void onReceive(Context context, Intent intent) {
            this.nd.m995g(false);
        }
    }

    /* renamed from: com.google.android.gms.internal.af$5 */
    class C08985 implements cd {
        final /* synthetic */ af nd;

        C08985(af afVar) {
            this.nd = afVar;
        }

        /* renamed from: a */
        public void mo1660a(gu guVar, Map<String, String> map) {
            if (this.nd.m989a((Map) map)) {
                this.nd.m984a((View) guVar, (Map) map);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.af$6 */
    class C08996 implements cd {
        final /* synthetic */ af nd;

        C08996(af afVar) {
            this.nd = afVar;
        }

        /* renamed from: a */
        public void mo1660a(gu guVar, Map<String, String> map) {
            if (this.nd.m989a((Map) map)) {
                gr.m1337S("Received request to untrack: " + this.nd.mN.aH());
                this.nd.destroy();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.af$7 */
    class C09007 implements cd {
        final /* synthetic */ af nd;

        C09007(af afVar) {
            this.nd = afVar;
        }

        /* renamed from: a */
        public void mo1660a(gu guVar, Map<String, String> map) {
            if (this.nd.m989a((Map) map) && map.containsKey("isVisible")) {
                boolean z = "1".equals(map.get("isVisible")) || "true".equals(map.get("isVisible"));
                this.nd.m993f(Boolean.valueOf(z).booleanValue());
            }
        }
    }

    public af(Context context, ay ayVar, fy fyVar, View view, gs gsVar) {
        this(ayVar, fyVar, gsVar, view, new aj(context, gsVar));
    }

    public af(ay ayVar, fy fyVar, gs gsVar, final View view, ah ahVar) {
        this.mH = new Object();
        this.my = false;
        this.mV = false;
        this.mW = new ArrayBlockingQueue(2);
        this.mX = Long.MIN_VALUE;
        this.nb = new HashSet();
        this.mK = new WeakReference(fyVar);
        this.mM = new WeakReference(view);
        this.mL = new WeakReference(null);
        this.mY = true;
        this.mN = new ad(UUID.randomUUID().toString(), gsVar, ayVar.op, fyVar.vD);
        this.mP = ahVar;
        this.mR = (WindowManager) view.getContext().getSystemService("window");
        this.mS = (PowerManager) view.getContext().getApplicationContext().getSystemService("power");
        this.mT = (KeyguardManager) view.getContext().getSystemService("keyguard");
        this.mO = view.getContext().getApplicationContext();
        m987a(ahVar);
        this.mP.mo1662a(new C0367a(this) {
            final /* synthetic */ af nd;

            public void aR() {
                this.nd.mQ = true;
                this.nd.m991d(view);
                this.nd.aI();
            }
        });
        m990b(this.mP);
        try {
            final JSONObject e = m992e(view);
            this.mW.add(new Runnable(this) {
                final /* synthetic */ af nd;

                public void run() {
                    this.nd.m988a(e);
                }
            });
        } catch (Throwable th) {
        }
        this.mW.add(new C03653(this));
        gr.m1337S("Tracking ad unit: " + this.mN.aH());
    }

    /* renamed from: a */
    protected int m983a(int i, DisplayMetrics displayMetrics) {
        return (int) (((float) i) / displayMetrics.density);
    }

    /* renamed from: a */
    protected void m984a(View view, Map<String, String> map) {
        m995g(false);
    }

    /* renamed from: a */
    public void m985a(ac acVar) {
        this.nb.add(acVar);
    }

    /* renamed from: a */
    public void m986a(ag agVar) {
        synchronized (this.mH) {
            this.mU = agVar;
        }
    }

    /* renamed from: a */
    protected void m987a(ah ahVar) {
        ahVar.mo1667f("https://googleads.g.doubleclick.net/mads/static/sdk/native/sdk-core-v40.html");
    }

    /* renamed from: a */
    protected void m988a(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONArray.put(jSONObject);
            jSONObject2.put("units", jSONArray);
            this.mP.mo1665a("AFMA_updateActiveView", jSONObject2);
        } catch (Throwable th) {
            gr.m1343b("Skipping active view message.", th);
        }
    }

    /* renamed from: a */
    protected boolean m989a(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = (String) map.get("hashCode");
        boolean z = !TextUtils.isEmpty(str) && str.equals(this.mN.aH());
        return z;
    }

    protected void aI() {
        synchronized (this.mH) {
            if (this.na != null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            this.na = new C03664(this);
            this.mO.registerReceiver(this.na, intentFilter);
        }
    }

    protected void aJ() {
        synchronized (this.mH) {
            if (this.na != null) {
                this.mO.unregisterReceiver(this.na);
                this.na = null;
            }
        }
    }

    public void aK() {
        synchronized (this.mH) {
            if (this.mY) {
                this.mZ = true;
                try {
                    m988a(aQ());
                } catch (Throwable e) {
                    gr.m1343b("JSON Failure while processing active view data.", e);
                }
                gr.m1337S("Untracking ad unit: " + this.mN.aH());
            }
        }
    }

    protected void aL() {
        if (this.mU != null) {
            this.mU.mo1658a(this);
        }
    }

    public boolean aM() {
        boolean z;
        synchronized (this.mH) {
            z = this.mY;
        }
        return z;
    }

    protected void aN() {
        View view = (View) this.mM.get();
        if (view != null) {
            ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.mL.get();
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2 != viewTreeObserver) {
                this.mL = new WeakReference(viewTreeObserver2);
                viewTreeObserver2.addOnScrollChangedListener(this);
                viewTreeObserver2.addOnGlobalLayoutListener(this);
            }
        }
    }

    protected void aO() {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.mL.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this);
            viewTreeObserver.removeGlobalOnLayoutListener(this);
        }
    }

    protected JSONObject aP() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("afmaVersion", this.mN.aF()).put("activeViewJSON", this.mN.aG()).put("timestamp", ga.dc().dd().elapsedRealtime()).put("adFormat", this.mN.aE()).put("hashCode", this.mN.aH());
        return jSONObject;
    }

    protected JSONObject aQ() throws JSONException {
        JSONObject aP = aP();
        aP.put("doneReasonCode", "u");
        return aP;
    }

    /* renamed from: b */
    protected void m990b(ah ahVar) {
        ahVar.mo1664a("/updateActiveView", new C08985(this));
        ahVar.mo1664a("/untrackActiveViewUnit", new C08996(this));
        ahVar.mo1664a("/visibilityChanged", new C09007(this));
        ahVar.mo1664a("/viewabilityChanged", cc.pQ);
    }

    /* renamed from: d */
    protected void m991d(View view) {
        Object arrayList = new ArrayList();
        this.mW.drainTo(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    protected void destroy() {
        synchronized (this.mH) {
            aO();
            aJ();
            this.mY = false;
            try {
                this.mP.destroy();
            } catch (Throwable th) {
            }
            aL();
        }
    }

    /* renamed from: e */
    protected JSONObject m992e(View view) throws JSONException {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr);
        view.getLocationInWindow(iArr2);
        JSONObject aP = aP();
        DisplayMetrics displayMetrics = view.getContext().getResources().getDisplayMetrics();
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        Rect rect2 = new Rect();
        rect2.right = this.mR.getDefaultDisplay().getWidth();
        rect2.bottom = this.mR.getDefaultDisplay().getHeight();
        Rect rect3 = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect3, null);
        Rect rect4 = new Rect();
        boolean localVisibleRect = view.getLocalVisibleRect(rect4);
        Rect rect5 = new Rect();
        view.getHitRect(rect5);
        aP.put("viewBox", new JSONObject().put("top", m983a(rect2.top, displayMetrics)).put("bottom", m983a(rect2.bottom, displayMetrics)).put("left", m983a(rect2.left, displayMetrics)).put("right", m983a(rect2.right, displayMetrics))).put("adBox", new JSONObject().put("top", m983a(rect.top, displayMetrics)).put("bottom", m983a(rect.bottom, displayMetrics)).put("left", m983a(rect.left, displayMetrics)).put("right", m983a(rect.right, displayMetrics))).put("globalVisibleBox", new JSONObject().put("top", m983a(rect3.top, displayMetrics)).put("bottom", m983a(rect3.bottom, displayMetrics)).put("left", m983a(rect3.left, displayMetrics)).put("right", m983a(rect3.right, displayMetrics))).put("globalVisibleBoxVisible", globalVisibleRect).put("localVisibleBox", new JSONObject().put("top", m983a(rect4.top, displayMetrics)).put("bottom", m983a(rect4.bottom, displayMetrics)).put("left", m983a(rect4.left, displayMetrics)).put("right", m983a(rect4.right, displayMetrics))).put("localVisibleBoxVisible", localVisibleRect).put("hitBox", new JSONObject().put("top", m983a(rect5.top, displayMetrics)).put("bottom", m983a(rect5.bottom, displayMetrics)).put("left", m983a(rect5.left, displayMetrics)).put("right", m983a(rect5.right, displayMetrics))).put("windowVisibility", view.getWindowVisibility()).put("screenDensity", (double) displayMetrics.density).put("isVisible", m994f(view)).put("isStopped", this.mV).put("isPaused", this.my);
        if (ll.im()) {
            aP.put("isAttachedToWindow", view.isAttachedToWindow());
        }
        return aP;
    }

    /* renamed from: f */
    protected void m993f(boolean z) {
        Iterator it = this.nb.iterator();
        while (it.hasNext()) {
            ((ac) it.next()).mo1657a(this, z);
        }
    }

    /* renamed from: f */
    protected boolean m994f(View view) {
        return view.getVisibility() == 0 && view.isShown() && this.mS.isScreenOn() && !this.mT.inKeyguardRestrictedInputMode();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: g */
    protected void m995g(boolean r8) {
        /*
        r7 = this;
        r2 = r7.mH;
        monitor-enter(r2);
        r0 = r7.mQ;	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x000b;
    L_0x0007:
        r0 = r7.mY;	 Catch:{ all -> 0x0026 }
        if (r0 != 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r2);	 Catch:{ all -> 0x0026 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = com.google.android.gms.internal.ga.dc();	 Catch:{ all -> 0x0026 }
        r0 = r0.dd();	 Catch:{ all -> 0x0026 }
        r0 = r0.elapsedRealtime();	 Catch:{ all -> 0x0026 }
        if (r8 == 0) goto L_0x0029;
    L_0x001b:
        r3 = r7.mX;	 Catch:{ all -> 0x0026 }
        r5 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r3 = r3 + r5;
        r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
        if (r3 <= 0) goto L_0x0029;
    L_0x0024:
        monitor-exit(r2);	 Catch:{ all -> 0x0026 }
        goto L_0x000c;
    L_0x0026:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0026 }
        throw r0;
    L_0x0029:
        r7.mX = r0;	 Catch:{ all -> 0x0026 }
        r0 = r7.mK;	 Catch:{ all -> 0x0026 }
        r0 = r0.get();	 Catch:{ all -> 0x0026 }
        r0 = (com.google.android.gms.internal.fy) r0;	 Catch:{ all -> 0x0026 }
        r1 = r7.mM;	 Catch:{ all -> 0x0026 }
        r1 = r1.get();	 Catch:{ all -> 0x0026 }
        r1 = (android.view.View) r1;	 Catch:{ all -> 0x0026 }
        if (r1 == 0) goto L_0x003f;
    L_0x003d:
        if (r0 != 0) goto L_0x0047;
    L_0x003f:
        r0 = 1;
    L_0x0040:
        if (r0 == 0) goto L_0x0049;
    L_0x0042:
        r7.aK();	 Catch:{ all -> 0x0026 }
        monitor-exit(r2);	 Catch:{ all -> 0x0026 }
        goto L_0x000c;
    L_0x0047:
        r0 = 0;
        goto L_0x0040;
    L_0x0049:
        r0 = r7.m992e(r1);	 Catch:{ JSONException -> 0x0058 }
        r7.m988a(r0);	 Catch:{ JSONException -> 0x0058 }
    L_0x0050:
        r7.aN();	 Catch:{ all -> 0x0026 }
        r7.aL();	 Catch:{ all -> 0x0026 }
        monitor-exit(r2);	 Catch:{ all -> 0x0026 }
        goto L_0x000c;
    L_0x0058:
        r0 = move-exception;
        r1 = "Active view update failed.";
        com.google.android.gms.internal.gr.m1342a(r1, r0);	 Catch:{ all -> 0x0026 }
        goto L_0x0050;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.af.g(boolean):void");
    }

    public void onGlobalLayout() {
        m995g(false);
    }

    public void onScrollChanged() {
        m995g(true);
    }

    public void pause() {
        synchronized (this.mH) {
            this.my = true;
            m995g(false);
            this.mP.pause();
        }
    }

    public void resume() {
        synchronized (this.mH) {
            this.mP.resume();
            this.my = false;
            m995g(false);
        }
    }

    public void stop() {
        synchronized (this.mH) {
            this.mV = true;
            m995g(false);
            this.mP.pause();
        }
    }
}
