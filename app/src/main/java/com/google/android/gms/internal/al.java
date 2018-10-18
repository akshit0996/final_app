package com.google.android.gms.internal;

import android.support.v4.widget.ExploreByTouchHelper;
import java.util.LinkedList;
import java.util.List;

@ey
public class al {
    private final Object mH = new Object();
    private List<ak> nA = new LinkedList();
    private int nz;

    /* renamed from: a */
    public boolean m1011a(ak akVar) {
        boolean z;
        synchronized (this.mH) {
            if (this.nA.contains(akVar)) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public ak aZ() {
        ak akVar = null;
        synchronized (this.mH) {
            if (this.nA.size() == 0) {
                gr.m1337S("Queue empty");
                return null;
            } else if (this.nA.size() >= 2) {
                int i = ExploreByTouchHelper.INVALID_ID;
                for (ak akVar2 : this.nA) {
                    ak akVar3;
                    int i2;
                    int score = akVar2.getScore();
                    if (score > i) {
                        int i3 = score;
                        akVar3 = akVar2;
                        i2 = i3;
                    } else {
                        i2 = i;
                        akVar3 = akVar;
                    }
                    i = i2;
                    akVar = akVar3;
                }
                this.nA.remove(akVar);
                return akVar;
            } else {
                akVar2 = (ak) this.nA.get(0);
                akVar2.aU();
                return akVar2;
            }
        }
    }

    /* renamed from: b */
    public boolean m1012b(ak akVar) {
        boolean z;
        synchronized (this.mH) {
            for (ak akVar2 : this.nA) {
                if (akVar != akVar2 && akVar2.aT().equals(akVar.aT())) {
                    this.nA.remove(akVar);
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return z;
    }

    /* renamed from: c */
    public void m1013c(ak akVar) {
        synchronized (this.mH) {
            if (this.nA.size() >= 10) {
                gr.m1337S("Queue is full, current size = " + this.nA.size());
                this.nA.remove(0);
            }
            int i = this.nz;
            this.nz = i + 1;
            akVar.m1008c(i);
            this.nA.add(akVar);
        }
    }
}
