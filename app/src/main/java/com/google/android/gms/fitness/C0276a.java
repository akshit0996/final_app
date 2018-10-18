package com.google.android.gms.fitness;

import com.google.android.gms.common.Scopes;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.gms.fitness.a */
public final class C0276a {
    public static String bt(String str) {
        return str.equals(Scopes.FITNESS_ACTIVITY_READ) ? Scopes.FITNESS_ACTIVITY_READ_WRITE : str.equals(Scopes.FITNESS_LOCATION_READ) ? Scopes.FITNESS_LOCATION_READ_WRITE : str.equals(Scopes.FITNESS_BODY_READ) ? Scopes.FITNESS_BODY_READ_WRITE : str;
    }

    /* renamed from: e */
    public static String[] m517e(List<String> list) {
        Set hashSet = new HashSet(list.size());
        for (String str : list) {
            String bt = C0276a.bt(str);
            if (bt.equals(str) || !list.contains(bt)) {
                hashSet.add(str);
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }
}
