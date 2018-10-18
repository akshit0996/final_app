package com.google.android.gms.internal;

import com.google.android.gms.internal.ra.C1438c;
import java.util.ArrayList;

public class os {
    private final ArrayList<C0495a> amZ;
    private int ana;

    /* renamed from: com.google.android.gms.internal.os$a */
    public static class C0495a {
        public final ov anb;
        public final or anc;
        public final C1438c and;

        private C0495a(ov ovVar, or orVar) {
            this.anb = (ov) jx.m1582i(ovVar);
            this.anc = (or) jx.m1582i(orVar);
            this.and = null;
        }
    }

    public os() {
        this(100);
    }

    public os(int i) {
        this.amZ = new ArrayList();
        this.ana = i;
    }

    private void oq() {
        while (getSize() > getCapacity()) {
            this.amZ.remove(0);
        }
    }

    /* renamed from: a */
    public void m1767a(ov ovVar, or orVar) {
        this.amZ.add(new C0495a(ovVar, orVar));
        oq();
    }

    public void clear() {
        this.amZ.clear();
    }

    public int getCapacity() {
        return this.ana;
    }

    public int getSize() {
        return this.amZ.size();
    }

    public boolean isEmpty() {
        return this.amZ.isEmpty();
    }

    public ArrayList<C0495a> op() {
        return this.amZ;
    }
}
