package com.google.android.gms.internal;

import com.google.android.gms.internal.qm.C1435a;
import com.google.android.gms.internal.qm.C1435a.C1434a;
import com.google.android.gms.internal.qm.C1435a.C1434a.C1433a;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class ql {

    /* renamed from: com.google.android.gms.internal.ql$a */
    public static class C0499a {
        public final qm ayo;
        public final List<Asset> ayp;

        public C0499a(qm qmVar, List<Asset> list) {
            this.ayo = qmVar;
            this.ayp = list;
        }
    }

    /* renamed from: a */
    private static int m1822a(String str, C1434a[] c1434aArr) {
        int i = 14;
        for (C1434a c1434a : c1434aArr) {
            if (i == 14) {
                if (c1434a.type == 9 || c1434a.type == 2 || c1434a.type == 6) {
                    i = c1434a.type;
                } else if (c1434a.type != 14) {
                    throw new IllegalArgumentException("Unexpected TypedValue type: " + c1434a.type + " for key " + str);
                }
            } else if (c1434a.type != i) {
                throw new IllegalArgumentException("The ArrayList elements should all be the same type, but ArrayList with key " + str + " contains items of type " + i + " and " + c1434a.type);
            }
        }
        return i;
    }

    /* renamed from: a */
    static int m1823a(List<Asset> list, Asset asset) {
        list.add(asset);
        return list.size() - 1;
    }

    /* renamed from: a */
    public static C0499a m1824a(DataMap dataMap) {
        qm qmVar = new qm();
        List arrayList = new ArrayList();
        qmVar.ayq = m1829a(dataMap, arrayList);
        return new C0499a(qmVar, arrayList);
    }

    /* renamed from: a */
    private static C1434a m1825a(List<Asset> list, Object obj) {
        C1434a c1434a = new C1434a();
        if (obj == null) {
            c1434a.type = 14;
            return c1434a;
        }
        c1434a.ayu = new C1433a();
        if (obj instanceof String) {
            c1434a.type = 2;
            c1434a.ayu.ayw = (String) obj;
        } else if (obj instanceof Integer) {
            c1434a.type = 6;
            c1434a.ayu.ayA = ((Integer) obj).intValue();
        } else if (obj instanceof Long) {
            c1434a.type = 5;
            c1434a.ayu.ayz = ((Long) obj).longValue();
        } else if (obj instanceof Double) {
            c1434a.type = 3;
            c1434a.ayu.ayx = ((Double) obj).doubleValue();
        } else if (obj instanceof Float) {
            c1434a.type = 4;
            c1434a.ayu.ayy = ((Float) obj).floatValue();
        } else if (obj instanceof Boolean) {
            c1434a.type = 8;
            c1434a.ayu.ayC = ((Boolean) obj).booleanValue();
        } else if (obj instanceof Byte) {
            c1434a.type = 7;
            c1434a.ayu.ayB = ((Byte) obj).byteValue();
        } else if (obj instanceof byte[]) {
            c1434a.type = 1;
            c1434a.ayu.ayv = (byte[]) obj;
        } else if (obj instanceof String[]) {
            c1434a.type = 11;
            c1434a.ayu.ayF = (String[]) obj;
        } else if (obj instanceof long[]) {
            c1434a.type = 12;
            c1434a.ayu.ayG = (long[]) obj;
        } else if (obj instanceof float[]) {
            c1434a.type = 15;
            c1434a.ayu.ayH = (float[]) obj;
        } else if (obj instanceof Asset) {
            c1434a.type = 13;
            c1434a.ayu.ayI = (long) m1823a((List) list, (Asset) obj);
        } else if (obj instanceof DataMap) {
            c1434a.type = 9;
            DataMap dataMap = (DataMap) obj;
            Set<String> keySet = dataMap.keySet();
            C1435a[] c1435aArr = new C1435a[keySet.size()];
            r1 = 0;
            for (String str : keySet) {
                c1435aArr[r1] = new C1435a();
                c1435aArr[r1].name = str;
                c1435aArr[r1].ays = m1825a((List) list, dataMap.get(str));
                r1++;
            }
            c1434a.ayu.ayD = c1435aArr;
        } else if (obj instanceof ArrayList) {
            c1434a.type = 10;
            ArrayList arrayList = (ArrayList) obj;
            C1434a[] c1434aArr = new C1434a[arrayList.size()];
            Object obj2 = null;
            int size = arrayList.size();
            int i = 0;
            int i2 = 14;
            while (i < size) {
                Object obj3 = arrayList.get(i);
                C1434a a = m1825a((List) list, obj3);
                if (a.type == 14 || a.type == 2 || a.type == 6 || a.type == 9) {
                    if (i2 == 14 && a.type != 14) {
                        r1 = a.type;
                    } else if (a.type != i2) {
                        throw new IllegalArgumentException("ArrayList elements must all be of the sameclass, but this one contains a " + obj2.getClass() + " and a " + obj3.getClass());
                    } else {
                        obj3 = obj2;
                        r1 = i2;
                    }
                    c1434aArr[i] = a;
                    i++;
                    i2 = r1;
                    obj2 = obj3;
                } else {
                    throw new IllegalArgumentException("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a " + obj3.getClass());
                }
            }
            c1434a.ayu.ayE = c1434aArr;
        } else {
            throw new RuntimeException("newFieldValueFromValue: unexpected value " + obj.getClass().getSimpleName());
        }
        return c1434a;
    }

    /* renamed from: a */
    public static DataMap m1826a(C0499a c0499a) {
        DataMap dataMap = new DataMap();
        for (C1435a c1435a : c0499a.ayo.ayq) {
            m1828a(c0499a.ayp, dataMap, c1435a.name, c1435a.ays);
        }
        return dataMap;
    }

    /* renamed from: a */
    private static ArrayList m1827a(List<Asset> list, C1433a c1433a, int i) {
        ArrayList arrayList = new ArrayList(c1433a.ayE.length);
        for (C1434a c1434a : c1433a.ayE) {
            if (c1434a.type == 14) {
                arrayList.add(null);
            } else if (i == 9) {
                DataMap dataMap = new DataMap();
                for (C1435a c1435a : c1434a.ayu.ayD) {
                    m1828a(list, dataMap, c1435a.name, c1435a.ays);
                }
                arrayList.add(dataMap);
            } else if (i == 2) {
                arrayList.add(c1434a.ayu.ayw);
            } else if (i == 6) {
                arrayList.add(Integer.valueOf(c1434a.ayu.ayA));
            } else {
                throw new IllegalArgumentException("Unexpected typeOfArrayList: " + i);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m1828a(List<Asset> list, DataMap dataMap, String str, C1434a c1434a) {
        int i = c1434a.type;
        if (i == 14) {
            dataMap.putString(str, null);
            return;
        }
        C1433a c1433a = c1434a.ayu;
        if (i == 1) {
            dataMap.putByteArray(str, c1433a.ayv);
        } else if (i == 11) {
            dataMap.putStringArray(str, c1433a.ayF);
        } else if (i == 12) {
            dataMap.putLongArray(str, c1433a.ayG);
        } else if (i == 15) {
            dataMap.putFloatArray(str, c1433a.ayH);
        } else if (i == 2) {
            dataMap.putString(str, c1433a.ayw);
        } else if (i == 3) {
            dataMap.putDouble(str, c1433a.ayx);
        } else if (i == 4) {
            dataMap.putFloat(str, c1433a.ayy);
        } else if (i == 5) {
            dataMap.putLong(str, c1433a.ayz);
        } else if (i == 6) {
            dataMap.putInt(str, c1433a.ayA);
        } else if (i == 7) {
            dataMap.putByte(str, (byte) c1433a.ayB);
        } else if (i == 8) {
            dataMap.putBoolean(str, c1433a.ayC);
        } else if (i == 13) {
            if (list == null) {
                throw new RuntimeException("populateBundle: unexpected type for: " + str);
            }
            dataMap.putAsset(str, (Asset) list.get((int) c1433a.ayI));
        } else if (i == 9) {
            DataMap dataMap2 = new DataMap();
            for (C1435a c1435a : c1433a.ayD) {
                m1828a(list, dataMap2, c1435a.name, c1435a.ays);
            }
            dataMap.putDataMap(str, dataMap2);
        } else if (i == 10) {
            i = m1822a(str, c1433a.ayE);
            ArrayList a = m1827a(list, c1433a, i);
            if (i == 14) {
                dataMap.putStringArrayList(str, a);
            } else if (i == 9) {
                dataMap.putDataMapArrayList(str, a);
            } else if (i == 2) {
                dataMap.putStringArrayList(str, a);
            } else if (i == 6) {
                dataMap.putIntegerArrayList(str, a);
            } else {
                throw new IllegalStateException("Unexpected typeOfArrayList: " + i);
            }
        } else {
            throw new RuntimeException("populateBundle: unexpected type " + i);
        }
    }

    /* renamed from: a */
    private static C1435a[] m1829a(DataMap dataMap, List<Asset> list) {
        Set<String> keySet = dataMap.keySet();
        C1435a[] c1435aArr = new C1435a[keySet.size()];
        int i = 0;
        for (String str : keySet) {
            Object obj = dataMap.get(str);
            c1435aArr[i] = new C1435a();
            c1435aArr[i].name = str;
            c1435aArr[i].ays = m1825a((List) list, obj);
            i++;
        }
        return c1435aArr;
    }
}
