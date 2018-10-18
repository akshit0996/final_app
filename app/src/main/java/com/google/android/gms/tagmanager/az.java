package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0361a;
import com.google.android.gms.internal.C0378b;
import com.google.android.gms.internal.C0386d.C1389a;
import com.google.android.gms.plus.PlusShare;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class az extends aj {
    private static final String ID = C0361a.JOINER.toString();
    private static final String arJ = C0378b.ITEM_SEPARATOR.toString();
    private static final String arK = C0378b.KEY_VALUE_SEPARATOR.toString();
    private static final String arL = C0378b.ESCAPE.toString();
    private static final String arp = C0378b.ARG0.toString();

    /* renamed from: com.google.android.gms.tagmanager.az$a */
    private enum C0613a {
        NONE,
        URL,
        BACKSLASH
    }

    public az() {
        super(ID, arp);
    }

    /* renamed from: a */
    private String m3691a(String str, C0613a c0613a, Set<Character> set) {
        switch (c0613a) {
            case URL:
                try {
                    return dm.dg(str);
                } catch (Throwable e) {
                    bh.m2118b("Joiner: unsupported encoding", e);
                    return str;
                }
            case BACKSLASH:
                String replace = str.replace("\\", "\\\\");
                String str2 = replace;
                for (Character ch : set) {
                    CharSequence ch2 = ch.toString();
                    str2 = str2.replace(ch2, "\\" + ch2);
                }
                return str2;
            default:
                return str;
        }
    }

    /* renamed from: a */
    private void m3692a(StringBuilder stringBuilder, String str, C0613a c0613a, Set<Character> set) {
        stringBuilder.append(m3691a(str, c0613a, set));
    }

    /* renamed from: a */
    private void m3693a(Set<Character> set, String str) {
        for (int i = 0; i < str.length(); i++) {
            set.add(Character.valueOf(str.charAt(i)));
        }
    }

    /* renamed from: B */
    public C1389a mo2513B(Map<String, C1389a> map) {
        C1389a c1389a = (C1389a) map.get(arp);
        if (c1389a == null) {
            return di.rb();
        }
        C0613a c0613a;
        Set set;
        C1389a c1389a2 = (C1389a) map.get(arJ);
        String j = c1389a2 != null ? di.m2191j(c1389a2) : "";
        c1389a2 = (C1389a) map.get(arK);
        String j2 = c1389a2 != null ? di.m2191j(c1389a2) : "=";
        C0613a c0613a2 = C0613a.NONE;
        c1389a2 = (C1389a) map.get(arL);
        if (c1389a2 != null) {
            String j3 = di.m2191j(c1389a2);
            if (PlusShare.KEY_CALL_TO_ACTION_URL.equals(j3)) {
                c0613a = C0613a.URL;
                set = null;
            } else if ("backslash".equals(j3)) {
                c0613a = C0613a.BACKSLASH;
                set = new HashSet();
                m3693a(set, j);
                m3693a(set, j2);
                set.remove(Character.valueOf('\\'));
            } else {
                bh.m2114T("Joiner: unsupported escape type: " + j3);
                return di.rb();
            }
        }
        set = null;
        c0613a = c0613a2;
        StringBuilder stringBuilder = new StringBuilder();
        switch (c1389a.type) {
            case 2:
                Object obj = 1;
                C1389a[] c1389aArr = c1389a.gw;
                int length = c1389aArr.length;
                int i = 0;
                while (i < length) {
                    C1389a c1389a3 = c1389aArr[i];
                    if (obj == null) {
                        stringBuilder.append(j);
                    }
                    m3692a(stringBuilder, di.m2191j(c1389a3), c0613a, set);
                    i++;
                    obj = null;
                }
                break;
            case 3:
                for (int i2 = 0; i2 < c1389a.gx.length; i2++) {
                    if (i2 > 0) {
                        stringBuilder.append(j);
                    }
                    String j4 = di.m2191j(c1389a.gx[i2]);
                    String j5 = di.m2191j(c1389a.gy[i2]);
                    m3692a(stringBuilder, j4, c0613a, set);
                    stringBuilder.append(j2);
                    m3692a(stringBuilder, j5, c0613a, set);
                }
                break;
            default:
                m3692a(stringBuilder, di.m2191j(c1389a), c0613a, set);
                break;
        }
        return di.m2202u(stringBuilder.toString());
    }

    public boolean pe() {
        return true;
    }
}
