package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.ck.C0382b;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

@ey
public class ga implements C0382b {
    private static final ga vX = new ga();
    public static final String vY = vX.vZ;
    private Context mContext;
    private final Object mH = new Object();
    private am nE = null;
    private al nF = null;
    private ex nG = null;
    private gs qJ;
    private boolean uV = true;
    private boolean uW = true;
    public final String vZ = gi.dx();
    private final gb wa = new gb(this.vZ);
    private ld wb;
    private BigInteger wc = BigInteger.ONE;
    private final HashSet<fz> wd = new HashSet();
    private final HashMap<String, gd> we = new HashMap();
    private boolean wf = false;
    private boolean wg = false;
    private an wh = null;
    private LinkedList<Thread> wi = new LinkedList();
    private boolean wj = false;
    private Bundle wk = bn.by();
    private String wl;

    private ga() {
    }

    /* renamed from: a */
    public static Bundle m3190a(Context context, gc gcVar, String str) {
        return vX.m3200b(context, gcVar, str);
    }

    /* renamed from: a */
    public static void m3191a(Context context, gs gsVar) {
        vX.m3201b(context, gsVar);
    }

    /* renamed from: a */
    public static void m3192a(Context context, boolean z) {
        vX.m3202b(context, z);
    }

    /* renamed from: b */
    public static void m3193b(HashSet<fz> hashSet) {
        vX.m3203c(hashSet);
    }

    public static Bundle bN() {
        return vX.dp();
    }

    /* renamed from: c */
    public static String m3194c(int i, String str) {
        return vX.m3204d(i, str);
    }

    public static ga dc() {
        return vX;
    }

    public static String df() {
        return vX.dg();
    }

    public static gb dh() {
        return vX.di();
    }

    public static boolean dj() {
        return vX.dk();
    }

    public static boolean dl() {
        return vX.dm();
    }

    public static String dn() {
        return vX.m3205do();
    }

    /* renamed from: e */
    public static void m3195e(Throwable th) {
        vX.m3206f(th);
    }

    /* renamed from: a */
    public void mo1797a(Bundle bundle) {
        synchronized (this.mH) {
            this.wj = true;
            this.wk = bundle;
            while (!this.wi.isEmpty()) {
                ex.m1180a(this.mContext, (Thread) this.wi.remove(0), this.qJ);
            }
        }
    }

    /* renamed from: a */
    public void m3197a(fz fzVar) {
        synchronized (this.mH) {
            this.wd.add(fzVar);
        }
    }

    /* renamed from: a */
    public void m3198a(String str, gd gdVar) {
        synchronized (this.mH) {
            this.we.put(str, gdVar);
        }
    }

    /* renamed from: a */
    public void m3199a(Thread thread) {
        synchronized (this.mH) {
            if (this.wj) {
                ex.m1180a(this.mContext, thread, this.qJ);
            } else {
                this.wi.add(thread);
            }
        }
    }

    /* renamed from: b */
    public Bundle m3200b(Context context, gc gcVar, String str) {
        Bundle bundle;
        synchronized (this.mH) {
            bundle = new Bundle();
            bundle.putBundle("app", this.wa.m1273b(context, str));
            Bundle bundle2 = new Bundle();
            for (String str2 : this.we.keySet()) {
                bundle2.putBundle(str2, ((gd) this.we.get(str2)).toBundle());
            }
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.wd.iterator();
            while (it.hasNext()) {
                arrayList.add(((fz) it.next()).toBundle());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            gcVar.mo3588a(this.wd);
            this.wd.clear();
        }
        return bundle;
    }

    /* renamed from: b */
    public void m3201b(Context context, gs gsVar) {
        synchronized (this.mH) {
            if (!this.wg) {
                this.mContext = context.getApplicationContext();
                this.qJ = gsVar;
                this.uV = gg.m1282o(context);
                iy.m1485H(context);
                ck.m1100a(context, this);
                m3199a(Thread.currentThread());
                this.wl = gi.m1304c(context, gsVar.wS);
                this.wb = new lf();
                this.wg = true;
            }
        }
    }

    /* renamed from: b */
    public void m3202b(Context context, boolean z) {
        synchronized (this.mH) {
            if (z != this.uV) {
                this.uV = z;
                gg.m1280a(context, z);
            }
        }
    }

    /* renamed from: c */
    public void m3203c(HashSet<fz> hashSet) {
        synchronized (this.mH) {
            this.wd.addAll(hashSet);
        }
    }

    /* renamed from: d */
    public String m3204d(int i, String str) {
        Resources resources = this.qJ.wV ? this.mContext.getResources() : GooglePlayServicesUtil.getRemoteResource(this.mContext);
        return resources == null ? str : resources.getString(i);
    }

    public ld dd() {
        ld ldVar;
        synchronized (this.mH) {
            ldVar = this.wb;
        }
        return ldVar;
    }

    public boolean de() {
        boolean z;
        synchronized (this.mH) {
            z = this.uW;
        }
        return z;
    }

    public String dg() {
        String bigInteger;
        synchronized (this.mH) {
            bigInteger = this.wc.toString();
            this.wc = this.wc.add(BigInteger.ONE);
        }
        return bigInteger;
    }

    public gb di() {
        gb gbVar;
        synchronized (this.mH) {
            gbVar = this.wa;
        }
        return gbVar;
    }

    public boolean dk() {
        boolean z;
        synchronized (this.mH) {
            z = this.wf;
            this.wf = true;
        }
        return z;
    }

    public boolean dm() {
        boolean z;
        synchronized (this.mH) {
            z = this.uV;
        }
        return z;
    }

    /* renamed from: do */
    public String m3205do() {
        String str;
        synchronized (this.mH) {
            str = this.wl;
        }
        return str;
    }

    public Bundle dp() {
        Bundle bundle;
        synchronized (this.mH) {
            bundle = this.wk;
        }
        return bundle;
    }

    /* renamed from: f */
    public void m3206f(Throwable th) {
        if (this.wg) {
            new ex(this.mContext, this.qJ, null, null).m1186b(th);
        }
    }

    /* renamed from: l */
    public an m3207l(Context context) {
        an anVar = null;
        if (bN().getBoolean(bn.pp.getKey(), false) && ll.ij() && !de()) {
            synchronized (this.mH) {
                if (this.nE == null) {
                    if (context instanceof Activity) {
                        this.nE = new am((Application) context.getApplicationContext(), (Activity) context);
                    }
                }
                if (this.nF == null) {
                    this.nF = new al();
                }
                if (this.wh == null) {
                    this.wh = new an(this.nE, this.nF, this.wk, new ex(this.mContext, this.qJ, null, null));
                }
                this.wh.ba();
                anVar = this.wh;
            }
        }
        return anVar;
    }

    /* renamed from: x */
    public void m3208x(boolean z) {
        synchronized (this.mH) {
            this.uW = z;
        }
    }
}
