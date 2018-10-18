package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0361a;
import com.google.android.gms.internal.C0378b;
import com.google.android.gms.internal.C0386d.C1389a;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.tagmanager.s */
class C1240s extends aj {
    private static final String ID = C0361a.FUNCTION_CALL.toString();
    private static final String aqO = C0378b.FUNCTION_CALL_NAME.toString();
    private static final String aqf = C0378b.ADDITIONAL_PARAMS.toString();
    private final C0646a aqP;

    /* renamed from: com.google.android.gms.tagmanager.s$a */
    public interface C0646a {
        /* renamed from: b */
        Object mo2505b(String str, Map<String, Object> map);
    }

    public C1240s(C0646a c0646a) {
        super(ID, aqO);
        this.aqP = c0646a;
    }

    /* renamed from: B */
    public C1389a mo2513B(Map<String, C1389a> map) {
        String j = di.m2191j((C1389a) map.get(aqO));
        Map hashMap = new HashMap();
        C1389a c1389a = (C1389a) map.get(aqf);
        if (c1389a != null) {
            Object o = di.m2196o(c1389a);
            if (o instanceof Map) {
                for (Entry entry : ((Map) o).entrySet()) {
                    hashMap.put(entry.getKey().toString(), entry.getValue());
                }
            } else {
                bh.m2117W("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return di.rb();
            }
        }
        try {
            return di.m2202u(this.aqP.mo2505b(j, hashMap));
        } catch (Exception e) {
            bh.m2117W("Custom macro/tag " + j + " threw exception " + e.getMessage());
            return di.rb();
        }
    }

    public boolean pe() {
        return false;
    }
}
