package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0386d.C1389a;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class aj {
    private final Set<String> art;
    private final String aru;

    public aj(String str, String... strArr) {
        this.aru = str;
        this.art = new HashSet(strArr.length);
        for (Object add : strArr) {
            this.art.add(add);
        }
    }

    /* renamed from: B */
    public abstract C1389a mo2513B(Map<String, C1389a> map);

    /* renamed from: a */
    boolean m2100a(Set<String> set) {
        return set.containsAll(this.art);
    }

    public String pI() {
        return this.aru;
    }

    public Set<String> pJ() {
        return this.art;
    }

    public abstract boolean pe();
}
