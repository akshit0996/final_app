package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0386d.C1389a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class di {
    private static final Object auc = null;
    private static Long aud = new Long(0);
    private static Double aue = new Double(0.0d);
    private static dh auf = dh.m2189z(0);
    private static String aug = new String("");
    private static Boolean auh = new Boolean(false);
    private static List<Object> aui = new ArrayList(0);
    private static Map<Object, Object> auj = new HashMap();
    private static C1389a auk = m2202u(aug);

    public static C1389a cZ(String str) {
        C1389a c1389a = new C1389a();
        c1389a.type = 5;
        c1389a.gA = str;
        return c1389a;
    }

    private static dh da(String str) {
        try {
            return dh.cY(str);
        } catch (NumberFormatException e) {
            bh.m2114T("Failed to convert '" + str + "' to a number.");
            return auf;
        }
    }

    private static Long db(String str) {
        dh da = da(str);
        return da == auf ? aud : Long.valueOf(da.longValue());
    }

    private static Double dc(String str) {
        dh da = da(str);
        return da == auf ? aue : Double.valueOf(da.doubleValue());
    }

    private static Boolean dd(String str) {
        return "true".equalsIgnoreCase(str) ? Boolean.TRUE : "false".equalsIgnoreCase(str) ? Boolean.FALSE : auh;
    }

    private static double getDouble(Object o) {
        if (o instanceof Number) {
            return ((Number) o).doubleValue();
        }
        bh.m2114T("getDouble received non-Number");
        return 0.0d;
    }

    /* renamed from: j */
    public static String m2191j(C1389a c1389a) {
        return m2197p(m2196o(c1389a));
    }

    /* renamed from: k */
    public static dh m2192k(C1389a c1389a) {
        return m2198q(m2196o(c1389a));
    }

    /* renamed from: l */
    public static Long m2193l(C1389a c1389a) {
        return m2199r(m2196o(c1389a));
    }

    /* renamed from: m */
    public static Double m2194m(C1389a c1389a) {
        return m2200s(m2196o(c1389a));
    }

    /* renamed from: n */
    public static Boolean m2195n(C1389a c1389a) {
        return m2201t(m2196o(c1389a));
    }

    /* renamed from: o */
    public static Object m2196o(C1389a c1389a) {
        int i = 0;
        if (c1389a == null) {
            return auc;
        }
        C1389a[] c1389aArr;
        int length;
        switch (c1389a.type) {
            case 1:
                return c1389a.gv;
            case 2:
                ArrayList arrayList = new ArrayList(c1389a.gw.length);
                c1389aArr = c1389a.gw;
                length = c1389aArr.length;
                while (i < length) {
                    Object o = m2196o(c1389aArr[i]);
                    if (o == auc) {
                        return auc;
                    }
                    arrayList.add(o);
                    i++;
                }
                return arrayList;
            case 3:
                if (c1389a.gx.length != c1389a.gy.length) {
                    bh.m2114T("Converting an invalid value to object: " + c1389a.toString());
                    return auc;
                }
                Map hashMap = new HashMap(c1389a.gy.length);
                while (i < c1389a.gx.length) {
                    Object o2 = m2196o(c1389a.gx[i]);
                    Object o3 = m2196o(c1389a.gy[i]);
                    if (o2 == auc || o3 == auc) {
                        return auc;
                    }
                    hashMap.put(o2, o3);
                    i++;
                }
                return hashMap;
            case 4:
                bh.m2114T("Trying to convert a macro reference to object");
                return auc;
            case 5:
                bh.m2114T("Trying to convert a function id to object");
                return auc;
            case 6:
                return Long.valueOf(c1389a.gB);
            case 7:
                StringBuffer stringBuffer = new StringBuffer();
                c1389aArr = c1389a.gD;
                length = c1389aArr.length;
                while (i < length) {
                    String j = m2191j(c1389aArr[i]);
                    if (j == aug) {
                        return auc;
                    }
                    stringBuffer.append(j);
                    i++;
                }
                return stringBuffer.toString();
            case 8:
                return Boolean.valueOf(c1389a.gC);
            default:
                bh.m2114T("Failed to convert a value of type: " + c1389a.type);
                return auc;
        }
    }

    /* renamed from: p */
    public static String m2197p(Object obj) {
        return obj == null ? aug : obj.toString();
    }

    /* renamed from: q */
    public static dh m2198q(Object obj) {
        return obj instanceof dh ? (dh) obj : m2204w(obj) ? dh.m2189z(m2205x(obj)) : m2203v(obj) ? dh.m2188a(Double.valueOf(getDouble(obj))) : da(m2197p(obj));
    }

    public static Object qV() {
        return auc;
    }

    public static Long qW() {
        return aud;
    }

    public static Double qX() {
        return aue;
    }

    public static Boolean qY() {
        return auh;
    }

    public static dh qZ() {
        return auf;
    }

    /* renamed from: r */
    public static Long m2199r(Object obj) {
        return m2204w(obj) ? Long.valueOf(m2205x(obj)) : db(m2197p(obj));
    }

    public static String ra() {
        return aug;
    }

    public static C1389a rb() {
        return auk;
    }

    /* renamed from: s */
    public static Double m2200s(Object obj) {
        return m2203v(obj) ? Double.valueOf(getDouble(obj)) : dc(m2197p(obj));
    }

    /* renamed from: t */
    public static Boolean m2201t(Object obj) {
        return obj instanceof Boolean ? (Boolean) obj : dd(m2197p(obj));
    }

    /* renamed from: u */
    public static C1389a m2202u(Object obj) {
        boolean z = false;
        C1389a c1389a = new C1389a();
        if (obj instanceof C1389a) {
            return (C1389a) obj;
        }
        if (obj instanceof String) {
            c1389a.type = 1;
            c1389a.gv = (String) obj;
        } else if (obj instanceof List) {
            c1389a.type = 2;
            List<Object> list = (List) obj;
            r5 = new ArrayList(list.size());
            r1 = false;
            for (Object u : list) {
                C1389a u2 = m2202u(u);
                if (u2 == auk) {
                    return auk;
                }
                r0 = r1 || u2.gF;
                r5.add(u2);
                r1 = r0;
            }
            c1389a.gw = (C1389a[]) r5.toArray(new C1389a[0]);
            z = r1;
        } else if (obj instanceof Map) {
            c1389a.type = 3;
            Set<Entry> entrySet = ((Map) obj).entrySet();
            r5 = new ArrayList(entrySet.size());
            List arrayList = new ArrayList(entrySet.size());
            r1 = false;
            for (Entry entry : entrySet) {
                C1389a u3 = m2202u(entry.getKey());
                C1389a u4 = m2202u(entry.getValue());
                if (u3 == auk || u4 == auk) {
                    return auk;
                }
                r0 = r1 || u3.gF || u4.gF;
                r5.add(u3);
                arrayList.add(u4);
                r1 = r0;
            }
            c1389a.gx = (C1389a[]) r5.toArray(new C1389a[0]);
            c1389a.gy = (C1389a[]) arrayList.toArray(new C1389a[0]);
            z = r1;
        } else if (m2203v(obj)) {
            c1389a.type = 1;
            c1389a.gv = obj.toString();
        } else if (m2204w(obj)) {
            c1389a.type = 6;
            c1389a.gB = m2205x(obj);
        } else if (obj instanceof Boolean) {
            c1389a.type = 8;
            c1389a.gC = ((Boolean) obj).booleanValue();
        } else {
            bh.m2114T("Converting to Value from unknown object type: " + (obj == null ? "null" : obj.getClass().toString()));
            return auk;
        }
        c1389a.gF = z;
        return c1389a;
    }

    /* renamed from: v */
    private static boolean m2203v(Object obj) {
        return (obj instanceof Double) || (obj instanceof Float) || ((obj instanceof dh) && ((dh) obj).qQ());
    }

    /* renamed from: w */
    private static boolean m2204w(Object obj) {
        return (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || ((obj instanceof dh) && ((dh) obj).qR());
    }

    /* renamed from: x */
    private static long m2205x(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        bh.m2114T("getInt64 received non-Number");
        return 0;
    }
}
