package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0378b;
import com.google.android.gms.internal.C0386d.C1389a;
import com.google.android.gms.tagmanager.cr.C0623a;
import com.google.android.gms.tagmanager.cr.C0625c;
import com.google.android.gms.tagmanager.cr.C0626d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ba {
    public static C0625c cI(String str) throws JSONException {
        C1389a n = m2109n(new JSONObject(str));
        C0626d qo = C0625c.qo();
        for (int i = 0; i < n.gx.length; i++) {
            qo.m2141a(C0623a.qk().m2139b(C0378b.INSTANCE_NAME.toString(), n.gx[i]).m2139b(C0378b.FUNCTION.toString(), di.cZ(C1231m.ph())).m2139b(C1231m.pi(), n.gy[i]).qn());
        }
        return qo.qr();
    }

    /* renamed from: n */
    private static C1389a m2109n(Object obj) throws JSONException {
        return di.m2202u(m2110o(obj));
    }

    /* renamed from: o */
    static Object m2110o(Object obj) throws JSONException {
        if (obj instanceof JSONArray) {
            throw new RuntimeException("JSONArrays are not supported");
        } else if (JSONObject.NULL.equals(obj)) {
            throw new RuntimeException("JSON nulls are not supported");
        } else if (!(obj instanceof JSONObject)) {
            return obj;
        } else {
            JSONObject jSONObject = (JSONObject) obj;
            Map hashMap = new HashMap();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, m2110o(jSONObject.get(str)));
            }
            return hashMap;
        }
    }
}
