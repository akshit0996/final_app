package com.google.android.gms.internal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.internal.hd.C0456a;
import com.google.android.gms.internal.hp.C0457a;
import com.google.android.gms.internal.mv.C1412b;
import com.google.android.gms.internal.mv.C1413c;
import com.google.android.gms.internal.mv.C1414d;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.List;

public class hy {
    /* renamed from: a */
    private static hh m1422a(String str, C1413c c1413c) {
        return new hh(qw.m1906f(c1413c), new C0457a(str).m1404G(true).au(str).at("blob").fG());
    }

    /* renamed from: a */
    public static hr m1423a(Action action, String str, long j, String str2, int i) {
        Bundle bundle = new Bundle();
        bundle.putAll(action.fI());
        Bundle bundle2 = bundle.getBundle("object");
        Uri parse = bundle2.containsKey("id") ? Uri.parse(bundle2.getString("id")) : null;
        String string = bundle2.getString("name");
        String string2 = bundle2.getString("type");
        Intent a = hz.m3247a(str2, Uri.parse(bundle2.getString(PlusShare.KEY_CALL_TO_ACTION_URL)));
        C0456a a2 = hr.m3229a(a, string, parse, string2, null);
        a2.m1384a(m1422a(".private:action", m1424d(action.fI())));
        a2.m1384a(aw(str));
        return new hr(hr.m3230a(str2, a), j, i, null, a2.fD());
    }

    private static hh aw(String str) {
        return new hh(str, new C0457a(".private:actionId").m1404G(true).au(".private:actionId").at("blob").fG());
    }

    /* renamed from: d */
    static C1413c m1424d(Bundle bundle) {
        C1413c c1413c = new C1413c();
        List arrayList = new ArrayList();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            C1412b c1412b = new C1412b();
            c1412b.name = str;
            c1412b.afz = new C1414d();
            if (obj instanceof String) {
                c1412b.afz.NJ = (String) obj;
            } else if (obj instanceof Bundle) {
                c1412b.afz.afE = m1424d((Bundle) obj);
            } else {
                Log.e("AppDataSearchClient", "Unsupported value: " + obj);
            }
            arrayList.add(c1412b);
        }
        if (bundle.containsKey("type")) {
            c1413c.type = bundle.getString("type");
        }
        c1413c.afA = (C1412b[]) arrayList.toArray(new C1412b[arrayList.size()]);
        return c1413c;
    }
}
