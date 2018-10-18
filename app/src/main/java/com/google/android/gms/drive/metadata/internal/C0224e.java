package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.ln;
import com.google.android.gms.internal.lp;
import com.google.android.gms.internal.lr;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.drive.metadata.internal.e */
public final class C0224e {
    private static Map<String, MetadataField<?>> Rh = new HashMap();

    static {
        C0224e.m405b(ln.Rj);
        C0224e.m405b(ln.RJ);
        C0224e.m405b(ln.RA);
        C0224e.m405b(ln.RH);
        C0224e.m405b(ln.RK);
        C0224e.m405b(ln.Ru);
        C0224e.m405b(ln.Rv);
        C0224e.m405b(ln.Rs);
        C0224e.m405b(ln.Rx);
        C0224e.m405b(ln.RF);
        C0224e.m405b(ln.Rk);
        C0224e.m405b(ln.RC);
        C0224e.m405b(ln.Rm);
        C0224e.m405b(ln.Rt);
        C0224e.m405b(ln.Rn);
        C0224e.m405b(ln.Ro);
        C0224e.m405b(ln.Rp);
        C0224e.m405b(ln.Rz);
        C0224e.m405b(ln.Rw);
        C0224e.m405b(ln.RB);
        C0224e.m405b(ln.RD);
        C0224e.m405b(ln.RE);
        C0224e.m405b(ln.RG);
        C0224e.m405b(ln.RL);
        C0224e.m405b(ln.RM);
        C0224e.m405b(ln.Rr);
        C0224e.m405b(ln.Rq);
        C0224e.m405b(ln.RI);
        C0224e.m405b(ln.Ry);
        C0224e.m405b(ln.Rl);
        C0224e.m405b(ln.RN);
        C0224e.m405b(ln.RO);
        C0224e.m405b(ln.RP);
        C0224e.m405b(lp.RQ);
        C0224e.m405b(lp.RS);
        C0224e.m405b(lp.RT);
        C0224e.m405b(lp.RU);
        C0224e.m405b(lp.RR);
        C0224e.m405b(lr.RW);
        C0224e.m405b(lr.RX);
    }

    /* renamed from: b */
    private static void m405b(MetadataField<?> metadataField) {
        if (Rh.containsKey(metadataField.getName())) {
            throw new IllegalArgumentException("Duplicate field name registered: " + metadataField.getName());
        }
        Rh.put(metadataField.getName(), metadataField);
    }

    public static MetadataField<?> bm(String str) {
        return (MetadataField) Rh.get(str);
    }

    public static Collection<MetadataField<?>> iY() {
        return Collections.unmodifiableCollection(Rh.values());
    }
}
