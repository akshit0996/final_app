package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

@ey
public final class ae implements ag {
    private final Object mH = new Object();
    private final WeakHashMap<fy, af> mI = new WeakHashMap();
    private final ArrayList<af> mJ = new ArrayList();

    /* renamed from: a */
    public af m3027a(Context context, ay ayVar, fy fyVar, View view, gs gsVar) {
        af afVar;
        synchronized (this.mH) {
            if (m3030c(fyVar)) {
                afVar = (af) this.mI.get(fyVar);
            } else {
                afVar = new af(context, ayVar, fyVar, view, gsVar);
                afVar.m986a((ag) this);
                this.mI.put(fyVar, afVar);
                this.mJ.add(afVar);
            }
        }
        return afVar;
    }

    /* renamed from: a */
    public af m3028a(ay ayVar, fy fyVar) {
        return m3027a(fyVar.se.getContext(), ayVar, fyVar, fyVar.se, fyVar.se.dG());
    }

    /* renamed from: a */
    public void mo1658a(af afVar) {
        synchronized (this.mH) {
            if (!afVar.aM()) {
                this.mJ.remove(afVar);
            }
        }
    }

    /* renamed from: c */
    public boolean m3030c(fy fyVar) {
        boolean z;
        synchronized (this.mH) {
            af afVar = (af) this.mI.get(fyVar);
            z = afVar != null && afVar.aM();
        }
        return z;
    }

    /* renamed from: d */
    public void m3031d(fy fyVar) {
        synchronized (this.mH) {
            af afVar = (af) this.mI.get(fyVar);
            if (afVar != null) {
                afVar.aK();
            }
        }
    }

    public void pause() {
        synchronized (this.mH) {
            Iterator it = this.mJ.iterator();
            while (it.hasNext()) {
                ((af) it.next()).pause();
            }
        }
    }

    public void resume() {
        synchronized (this.mH) {
            Iterator it = this.mJ.iterator();
            while (it.hasNext()) {
                ((af) it.next()).resume();
            }
        }
    }

    public void stop() {
        synchronized (this.mH) {
            Iterator it = this.mJ.iterator();
            while (it.hasNext()) {
                ((af) it.next()).stop();
            }
        }
    }
}
