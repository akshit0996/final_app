package com.google.android.gms.tagmanager;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.google.android.gms.internal.C0378b;
import com.google.android.gms.internal.C0381c.C1386i;
import com.google.android.gms.internal.C0386d.C1389a;
import com.google.android.gms.tagmanager.C0641l.C0640a;
import com.google.android.gms.tagmanager.C1240s.C0646a;
import com.google.android.gms.tagmanager.cr.C0623a;
import com.google.android.gms.tagmanager.cr.C0625c;
import com.google.android.gms.tagmanager.cr.C0627e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ct {
    private static final bz<C1389a> atb = new bz(di.rb(), true);
    private final DataLayer aqn;
    private final C0625c atc;
    private final ag atd;
    private final Map<String, aj> ate;
    private final Map<String, aj> atf;
    private final Map<String, aj> atg;
    private final C0639k<C0623a, bz<C1389a>> ath;
    private final C0639k<String, C0631b> ati;
    private final Set<C0627e> atj;
    private final Map<String, C0632c> atk;
    private volatile String atl;
    private int atm;

    /* renamed from: com.google.android.gms.tagmanager.ct$a */
    interface C0630a {
        /* renamed from: a */
        void mo2558a(C0627e c0627e, Set<C0623a> set, Set<C0623a> set2, cn cnVar);
    }

    /* renamed from: com.google.android.gms.tagmanager.ct$b */
    private static class C0631b {
        private C1389a asN;
        private bz<C1389a> ats;

        public C0631b(bz<C1389a> bzVar, C1389a c1389a) {
            this.ats = bzVar;
            this.asN = c1389a;
        }

        public int getSize() {
            return (this.asN == null ? 0 : this.asN.rY()) + ((C1389a) this.ats.getObject()).rY();
        }

        public bz<C1389a> qG() {
            return this.ats;
        }

        public C1389a qm() {
            return this.asN;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.ct$c */
    private static class C0632c {
        private final Set<C0627e> atj = new HashSet();
        private final Map<C0627e, List<C0623a>> att = new HashMap();
        private final Map<C0627e, List<C0623a>> atu = new HashMap();
        private final Map<C0627e, List<String>> atv = new HashMap();
        private final Map<C0627e, List<String>> atw = new HashMap();
        private C0623a atx;

        /* renamed from: a */
        public void m2159a(C0627e c0627e, C0623a c0623a) {
            List list = (List) this.att.get(c0627e);
            if (list == null) {
                list = new ArrayList();
                this.att.put(c0627e, list);
            }
            list.add(c0623a);
        }

        /* renamed from: a */
        public void m2160a(C0627e c0627e, String str) {
            List list = (List) this.atv.get(c0627e);
            if (list == null) {
                list = new ArrayList();
                this.atv.put(c0627e, list);
            }
            list.add(str);
        }

        /* renamed from: b */
        public void m2161b(C0627e c0627e) {
            this.atj.add(c0627e);
        }

        /* renamed from: b */
        public void m2162b(C0627e c0627e, C0623a c0623a) {
            List list = (List) this.atu.get(c0627e);
            if (list == null) {
                list = new ArrayList();
                this.atu.put(c0627e, list);
            }
            list.add(c0623a);
        }

        /* renamed from: b */
        public void m2163b(C0627e c0627e, String str) {
            List list = (List) this.atw.get(c0627e);
            if (list == null) {
                list = new ArrayList();
                this.atw.put(c0627e, list);
            }
            list.add(str);
        }

        /* renamed from: i */
        public void m2164i(C0623a c0623a) {
            this.atx = c0623a;
        }

        public Set<C0627e> qH() {
            return this.atj;
        }

        public Map<C0627e, List<C0623a>> qI() {
            return this.att;
        }

        public Map<C0627e, List<String>> qJ() {
            return this.atv;
        }

        public Map<C0627e, List<String>> qK() {
            return this.atw;
        }

        public Map<C0627e, List<C0623a>> qL() {
            return this.atu;
        }

        public C0623a qM() {
            return this.atx;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.ct$1 */
    class C12181 implements C0640a<C0623a, bz<C1389a>> {
        final /* synthetic */ ct atn;

        C12181(ct ctVar) {
            this.atn = ctVar;
        }

        /* renamed from: a */
        public int m3730a(C0623a c0623a, bz<C1389a> bzVar) {
            return ((C1389a) bzVar.getObject()).rY();
        }

        public /* synthetic */ int sizeOf(Object x0, Object x1) {
            return m3730a((C0623a) x0, (bz) x1);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.ct$2 */
    class C12192 implements C0640a<String, C0631b> {
        final /* synthetic */ ct atn;

        C12192(ct ctVar) {
            this.atn = ctVar;
        }

        /* renamed from: a */
        public int m3731a(String str, C0631b c0631b) {
            return str.length() + c0631b.getSize();
        }

        public /* synthetic */ int sizeOf(Object x0, Object x1) {
            return m3731a((String) x0, (C0631b) x1);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.ct$4 */
    class C12214 implements C0630a {
        final /* synthetic */ ct atn;

        C12214(ct ctVar) {
            this.atn = ctVar;
        }

        /* renamed from: a */
        public void mo2558a(C0627e c0627e, Set<C0623a> set, Set<C0623a> set2, cn cnVar) {
            set.addAll(c0627e.qv());
            set2.addAll(c0627e.qw());
            cnVar.pT().mo2535c(c0627e.qv(), c0627e.qA());
            cnVar.pU().mo2535c(c0627e.qw(), c0627e.qB());
        }
    }

    public ct(Context context, C0625c c0625c, DataLayer dataLayer, C0646a c0646a, C0646a c0646a2, ag agVar) {
        if (c0625c == null) {
            throw new NullPointerException("resource cannot be null");
        }
        this.atc = c0625c;
        this.atj = new HashSet(c0625c.qp());
        this.aqn = dataLayer;
        this.atd = agVar;
        this.ath = new C0641l().m2212a(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, new C12181(this));
        this.ati = new C0641l().m2212a(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, new C12192(this));
        this.ate = new HashMap();
        m2179b(new C1471i(context));
        m2179b(new C1240s(c0646a2));
        m2179b(new C1474w(dataLayer));
        m2179b(new dj(context, dataLayer));
        this.atf = new HashMap();
        m2180c(new C1536q());
        m2180c(new ad());
        m2180c(new ae());
        m2180c(new al());
        m2180c(new am());
        m2180c(new bd());
        m2180c(new be());
        m2180c(new ci());
        m2180c(new dc());
        this.atg = new HashMap();
        m2178a(new C1212b(context));
        m2178a(new C1214c(context));
        m2178a(new C1225e(context));
        m2178a(new C1226f(context));
        m2178a(new C1227g(context));
        m2178a(new C1228h(context));
        m2178a(new C1231m());
        m2178a(new C1239p(this.atc.getVersion()));
        m2178a(new C1240s(c0646a));
        m2178a(new C1241u(dataLayer));
        m2178a(new C1245z(context));
        m2178a(new aa());
        m2178a(new ac());
        m2178a(new ah(this));
        m2178a(new an());
        m2178a(new ao());
        m2178a(new ax(context));
        m2178a(new az());
        m2178a(new bc());
        m2178a(new bj());
        m2178a(new bl(context));
        m2178a(new ca());
        m2178a(new cc());
        m2178a(new cf());
        m2178a(new ch());
        m2178a(new cj(context));
        m2178a(new cu());
        m2178a(new cv());
        m2178a(new de());
        m2178a(new dk());
        this.atk = new HashMap();
        for (C0627e c0627e : this.atj) {
            if (agVar.pH()) {
                m2170a(c0627e.qx(), c0627e.qy(), "add macro");
                m2170a(c0627e.qC(), c0627e.qz(), "remove macro");
                m2170a(c0627e.qv(), c0627e.qA(), "add tag");
                m2170a(c0627e.qw(), c0627e.qB(), "remove tag");
            }
            int i = 0;
            while (i < c0627e.qx().size()) {
                C0623a c0623a = (C0623a) c0627e.qx().get(i);
                String str = "Unknown";
                if (agVar.pH() && i < c0627e.qy().size()) {
                    str = (String) c0627e.qy().get(i);
                }
                C0632c e = m2172e(this.atk, m2173h(c0623a));
                e.m2161b(c0627e);
                e.m2159a(c0627e, c0623a);
                e.m2160a(c0627e, str);
                i++;
            }
            i = 0;
            while (i < c0627e.qC().size()) {
                c0623a = (C0623a) c0627e.qC().get(i);
                str = "Unknown";
                if (agVar.pH() && i < c0627e.qz().size()) {
                    str = (String) c0627e.qz().get(i);
                }
                e = m2172e(this.atk, m2173h(c0623a));
                e.m2161b(c0627e);
                e.m2162b(c0627e, c0623a);
                e.m2163b(c0627e, str);
                i++;
            }
        }
        for (Entry entry : this.atc.qq().entrySet()) {
            for (C0623a c0623a2 : (List) entry.getValue()) {
                if (!di.m2195n((C1389a) c0623a2.ql().get(C0378b.NOT_DEFAULT_MACRO.toString())).booleanValue()) {
                    m2172e(this.atk, (String) entry.getKey()).m2164i(c0623a2);
                }
            }
        }
    }

    /* renamed from: a */
    private bz<C1389a> m2165a(C1389a c1389a, Set<String> set, dl dlVar) {
        if (!c1389a.gF) {
            return new bz(c1389a, true);
        }
        C1389a g;
        int i;
        bz a;
        switch (c1389a.type) {
            case 2:
                g = cr.m2155g(c1389a);
                g.gw = new C1389a[c1389a.gw.length];
                for (i = 0; i < c1389a.gw.length; i++) {
                    a = m2165a(c1389a.gw[i], (Set) set, dlVar.fK(i));
                    if (a == atb) {
                        return atb;
                    }
                    g.gw[i] = (C1389a) a.getObject();
                }
                return new bz(g, false);
            case 3:
                g = cr.m2155g(c1389a);
                if (c1389a.gx.length != c1389a.gy.length) {
                    bh.m2114T("Invalid serving value: " + c1389a.toString());
                    return atb;
                }
                g.gx = new C1389a[c1389a.gx.length];
                g.gy = new C1389a[c1389a.gx.length];
                for (i = 0; i < c1389a.gx.length; i++) {
                    a = m2165a(c1389a.gx[i], (Set) set, dlVar.fL(i));
                    bz a2 = m2165a(c1389a.gy[i], (Set) set, dlVar.fM(i));
                    if (a == atb || a2 == atb) {
                        return atb;
                    }
                    g.gx[i] = (C1389a) a.getObject();
                    g.gy[i] = (C1389a) a2.getObject();
                }
                return new bz(g, false);
            case 4:
                if (set.contains(c1389a.gz)) {
                    bh.m2114T("Macro cycle detected.  Current macro reference: " + c1389a.gz + "." + "  Previous macro references: " + set.toString() + ".");
                    return atb;
                }
                set.add(c1389a.gz);
                bz<C1389a> a3 = dm.m2208a(m2166a(c1389a.gz, (Set) set, dlVar.pW()), c1389a.gE);
                set.remove(c1389a.gz);
                return a3;
            case 7:
                g = cr.m2155g(c1389a);
                g.gD = new C1389a[c1389a.gD.length];
                for (i = 0; i < c1389a.gD.length; i++) {
                    a = m2165a(c1389a.gD[i], (Set) set, dlVar.fN(i));
                    if (a == atb) {
                        return atb;
                    }
                    g.gD[i] = (C1389a) a.getObject();
                }
                return new bz(g, false);
            default:
                bh.m2114T("Unknown type: " + c1389a.type);
                return atb;
        }
    }

    /* renamed from: a */
    private bz<C1389a> m2166a(String str, Set<String> set, bk bkVar) {
        this.atm++;
        C0631b c0631b = (C0631b) this.ati.get(str);
        if (c0631b == null || this.atd.pH()) {
            C0632c c0632c = (C0632c) this.atk.get(str);
            if (c0632c == null) {
                bh.m2114T(qF() + "Invalid macro: " + str);
                this.atm--;
                return atb;
            }
            C0623a qM;
            bz a = m2176a(str, c0632c.qH(), c0632c.qI(), c0632c.qJ(), c0632c.qL(), c0632c.qK(), set, bkVar.py());
            if (((Set) a.getObject()).isEmpty()) {
                qM = c0632c.qM();
            } else {
                if (((Set) a.getObject()).size() > 1) {
                    bh.m2117W(qF() + "Multiple macros active for macroName " + str);
                }
                qM = (C0623a) ((Set) a.getObject()).iterator().next();
            }
            if (qM == null) {
                this.atm--;
                return atb;
            }
            bz a2 = m2167a(this.atg, qM, (Set) set, bkVar.pN());
            boolean z = a.pX() && a2.pX();
            bz<C1389a> bzVar = a2 == atb ? atb : new bz(a2.getObject(), z);
            C1389a qm = qM.qm();
            if (bzVar.pX()) {
                this.ati.mo2519e(str, new C0631b(bzVar, qm));
            }
            m2169a(qm, (Set) set);
            this.atm--;
            return bzVar;
        }
        m2169a(c0631b.qm(), (Set) set);
        this.atm--;
        return c0631b.qG();
    }

    /* renamed from: a */
    private bz<C1389a> m2167a(Map<String, aj> map, C0623a c0623a, Set<String> set, ck ckVar) {
        boolean z = true;
        C1389a c1389a = (C1389a) c0623a.ql().get(C0378b.FUNCTION.toString());
        if (c1389a == null) {
            bh.m2114T("No function id in properties");
            return atb;
        }
        String str = c1389a.gA;
        aj ajVar = (aj) map.get(str);
        if (ajVar == null) {
            bh.m2114T(str + " has no backing implementation.");
            return atb;
        }
        bz<C1389a> bzVar = (bz) this.ath.get(c0623a);
        if (bzVar != null && !this.atd.pH()) {
            return bzVar;
        }
        Map hashMap = new HashMap();
        boolean z2 = true;
        for (Entry entry : c0623a.ql().entrySet()) {
            bz a = m2165a((C1389a) entry.getValue(), (Set) set, ckVar.cJ((String) entry.getKey()).mo2534e((C1389a) entry.getValue()));
            if (a == atb) {
                return atb;
            }
            boolean z3;
            if (a.pX()) {
                c0623a.m2138a((String) entry.getKey(), (C1389a) a.getObject());
                z3 = z2;
            } else {
                z3 = false;
            }
            hashMap.put(entry.getKey(), a.getObject());
            z2 = z3;
        }
        if (ajVar.m2100a(hashMap.keySet())) {
            if (!(z2 && ajVar.pe())) {
                z = false;
            }
            bzVar = new bz(ajVar.mo2513B(hashMap), z);
            if (z) {
                this.ath.mo2519e(c0623a, bzVar);
            }
            ckVar.mo2533d((C1389a) bzVar.getObject());
            return bzVar;
        }
        bh.m2114T("Incorrect keys for function " + str + " required " + ajVar.pJ() + " had " + hashMap.keySet());
        return atb;
    }

    /* renamed from: a */
    private bz<Set<C0623a>> m2168a(Set<C0627e> set, Set<String> set2, C0630a c0630a, cs csVar) {
        Set hashSet = new HashSet();
        Collection hashSet2 = new HashSet();
        boolean z = true;
        for (C0627e c0627e : set) {
            cn pV = csVar.pV();
            bz a = m2175a(c0627e, (Set) set2, pV);
            if (((Boolean) a.getObject()).booleanValue()) {
                c0630a.mo2558a(c0627e, hashSet, hashSet2, pV);
            }
            boolean z2 = z && a.pX();
            z = z2;
        }
        hashSet.removeAll(hashSet2);
        csVar.mo2543b(hashSet);
        return new bz(hashSet, z);
    }

    /* renamed from: a */
    private void m2169a(C1389a c1389a, Set<String> set) {
        if (c1389a != null) {
            bz a = m2165a(c1389a, (Set) set, new bx());
            if (a != atb) {
                Object o = di.m2196o((C1389a) a.getObject());
                if (o instanceof Map) {
                    this.aqn.push((Map) o);
                } else if (o instanceof List) {
                    for (Object o2 : (List) o2) {
                        if (o2 instanceof Map) {
                            this.aqn.push((Map) o2);
                        } else {
                            bh.m2117W("pushAfterEvaluate: value not a Map");
                        }
                    }
                } else {
                    bh.m2117W("pushAfterEvaluate: value not a Map or List");
                }
            }
        }
    }

    /* renamed from: a */
    private static void m2170a(List<C0623a> list, List<String> list2, String str) {
        if (list.size() != list2.size()) {
            bh.m2115U("Invalid resource: imbalance of rule names of functions for " + str + " operation. Using default rule name instead");
        }
    }

    /* renamed from: a */
    private static void m2171a(Map<String, aj> map, aj ajVar) {
        if (map.containsKey(ajVar.pI())) {
            throw new IllegalArgumentException("Duplicate function type name: " + ajVar.pI());
        }
        map.put(ajVar.pI(), ajVar);
    }

    /* renamed from: e */
    private static C0632c m2172e(Map<String, C0632c> map, String str) {
        C0632c c0632c = (C0632c) map.get(str);
        if (c0632c != null) {
            return c0632c;
        }
        c0632c = new C0632c();
        map.put(str, c0632c);
        return c0632c;
    }

    /* renamed from: h */
    private static String m2173h(C0623a c0623a) {
        return di.m2191j((C1389a) c0623a.ql().get(C0378b.INSTANCE_NAME.toString()));
    }

    private String qF() {
        if (this.atm <= 1) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString(this.atm));
        for (int i = 2; i < this.atm; i++) {
            stringBuilder.append(' ');
        }
        stringBuilder.append(": ");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    bz<Boolean> m2174a(C0623a c0623a, Set<String> set, ck ckVar) {
        bz a = m2167a(this.atf, c0623a, (Set) set, ckVar);
        Boolean n = di.m2195n((C1389a) a.getObject());
        ckVar.mo2533d(di.m2202u(n));
        return new bz(n, a.pX());
    }

    /* renamed from: a */
    bz<Boolean> m2175a(C0627e c0627e, Set<String> set, cn cnVar) {
        boolean z = true;
        for (C0623a a : c0627e.qu()) {
            bz a2 = m2174a(a, (Set) set, cnVar.pP());
            if (((Boolean) a2.getObject()).booleanValue()) {
                cnVar.mo2536f(di.m2202u(Boolean.valueOf(false)));
                return new bz(Boolean.valueOf(false), a2.pX());
            }
            boolean z2 = z && a2.pX();
            z = z2;
        }
        for (C0623a a3 : c0627e.qt()) {
            a2 = m2174a(a3, (Set) set, cnVar.pQ());
            if (((Boolean) a2.getObject()).booleanValue()) {
                z = z && a2.pX();
            } else {
                cnVar.mo2536f(di.m2202u(Boolean.valueOf(false)));
                return new bz(Boolean.valueOf(false), a2.pX());
            }
        }
        cnVar.mo2536f(di.m2202u(Boolean.valueOf(true)));
        return new bz(Boolean.valueOf(true), z);
    }

    /* renamed from: a */
    bz<Set<C0623a>> m2176a(String str, Set<C0627e> set, Map<C0627e, List<C0623a>> map, Map<C0627e, List<String>> map2, Map<C0627e, List<C0623a>> map3, Map<C0627e, List<String>> map4, Set<String> set2, cs csVar) {
        final Map<C0627e, List<C0623a>> map5 = map;
        final Map<C0627e, List<String>> map6 = map2;
        final Map<C0627e, List<C0623a>> map7 = map3;
        final Map<C0627e, List<String>> map8 = map4;
        return m2168a((Set) set, (Set) set2, new C0630a(this) {
            final /* synthetic */ ct atn;

            /* renamed from: a */
            public void mo2558a(C0627e c0627e, Set<C0623a> set, Set<C0623a> set2, cn cnVar) {
                List list = (List) map5.get(c0627e);
                List list2 = (List) map6.get(c0627e);
                if (list != null) {
                    set.addAll(list);
                    cnVar.pR().mo2535c(list, list2);
                }
                list = (List) map7.get(c0627e);
                list2 = (List) map8.get(c0627e);
                if (list != null) {
                    set2.addAll(list);
                    cnVar.pS().mo2535c(list, list2);
                }
            }
        }, csVar);
    }

    /* renamed from: a */
    bz<Set<C0623a>> m2177a(Set<C0627e> set, cs csVar) {
        return m2168a((Set) set, new HashSet(), new C12214(this), csVar);
    }

    /* renamed from: a */
    void m2178a(aj ajVar) {
        m2171a(this.atg, ajVar);
    }

    /* renamed from: b */
    void m2179b(aj ajVar) {
        m2171a(this.ate, ajVar);
    }

    /* renamed from: c */
    void m2180c(aj ajVar) {
        m2171a(this.atf, ajVar);
    }

    public bz<C1389a> cT(String str) {
        this.atm = 0;
        af cC = this.atd.cC(str);
        bz<C1389a> a = m2166a(str, new HashSet(), cC.pE());
        cC.pG();
        return a;
    }

    synchronized void cU(String str) {
        this.atl = str;
    }

    public synchronized void cr(String str) {
        cU(str);
        af cD = this.atd.cD(str);
        C0647t pF = cD.pF();
        for (C0623a a : (Set) m2177a(this.atj, pF.py()).getObject()) {
            m2167a(this.ate, a, new HashSet(), pF.px());
        }
        cD.pG();
        cU(null);
    }

    /* renamed from: l */
    public synchronized void m2181l(List<C1386i> list) {
        for (C1386i c1386i : list) {
            if (c1386i.name == null || !c1386i.name.startsWith("gaExperiment:")) {
                bh.m2116V("Ignored supplemental: " + c1386i);
            } else {
                ai.m2095a(this.aqn, c1386i);
            }
        }
    }

    synchronized String qE() {
        return this.atl;
    }
}
