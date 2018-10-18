package com.google.android.gms.tagmanager;

import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataLayer {
    public static final String EVENT_KEY = "event";
    public static final Object OBJECT_NOT_PRESENT = new Object();
    static final String[] aqQ = "gtm.lifetime".toString().split("\\.");
    private static final Pattern aqR = Pattern.compile("(\\d+)\\s*([smhd]?)");
    private final ConcurrentHashMap<C0601b, Integer> aqS;
    private final Map<String, Object> aqT;
    private final ReentrantLock aqU;
    private final LinkedList<Map<String, Object>> aqV;
    private final C0603c aqW;
    private final CountDownLatch aqX;

    /* renamed from: com.google.android.gms.tagmanager.DataLayer$a */
    static final class C0600a {
        public final String KP;
        public final Object wF;

        C0600a(String str, Object obj) {
            this.KP = str;
            this.wF = obj;
        }

        public boolean equals(Object o) {
            if (!(o instanceof C0600a)) {
                return false;
            }
            C0600a c0600a = (C0600a) o;
            return this.KP.equals(c0600a.KP) && this.wF.equals(c0600a.wF);
        }

        public int hashCode() {
            return Arrays.hashCode(new Integer[]{Integer.valueOf(this.KP.hashCode()), Integer.valueOf(this.wF.hashCode())});
        }

        public String toString() {
            return "Key: " + this.KP + " value: " + this.wF.toString();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.DataLayer$b */
    interface C0601b {
        /* renamed from: C */
        void mo2510C(Map<String, Object> map);
    }

    /* renamed from: com.google.android.gms.tagmanager.DataLayer$c */
    interface C0603c {

        /* renamed from: com.google.android.gms.tagmanager.DataLayer$c$a */
        public interface C0602a {
            /* renamed from: h */
            void mo2509h(List<C0600a> list);
        }

        /* renamed from: a */
        void mo2506a(C0602a c0602a);

        /* renamed from: a */
        void mo2507a(List<C0600a> list, long j);

        void cz(String str);
    }

    /* renamed from: com.google.android.gms.tagmanager.DataLayer$1 */
    class C12071 implements C0603c {
        C12071() {
        }

        /* renamed from: a */
        public void mo2506a(C0602a c0602a) {
            c0602a.mo2509h(new ArrayList());
        }

        /* renamed from: a */
        public void mo2507a(List<C0600a> list, long j) {
        }

        public void cz(String str) {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.DataLayer$2 */
    class C12082 implements C0602a {
        final /* synthetic */ DataLayer aqY;

        C12082(DataLayer dataLayer) {
            this.aqY = dataLayer;
        }

        /* renamed from: h */
        public void mo2509h(List<C0600a> list) {
            for (C0600a c0600a : list) {
                this.aqY.m2069E(this.aqY.m2082c(c0600a.KP, c0600a.wF));
            }
            this.aqY.aqX.countDown();
        }
    }

    DataLayer() {
        this(new C12071());
    }

    DataLayer(C0603c persistentStore) {
        this.aqW = persistentStore;
        this.aqS = new ConcurrentHashMap();
        this.aqT = new HashMap();
        this.aqU = new ReentrantLock();
        this.aqV = new LinkedList();
        this.aqX = new CountDownLatch(1);
        pv();
    }

    /* renamed from: E */
    private void m2069E(Map<String, Object> map) {
        this.aqU.lock();
        try {
            this.aqV.offer(map);
            if (this.aqU.getHoldCount() == 1) {
                pw();
            }
            m2070F(map);
        } finally {
            this.aqU.unlock();
        }
    }

    /* renamed from: F */
    private void m2070F(Map<String, Object> map) {
        Long G = m2071G(map);
        if (G != null) {
            List I = m2073I(map);
            I.remove("gtm.lifetime");
            this.aqW.mo2507a(I, G.longValue());
        }
    }

    /* renamed from: G */
    private Long m2071G(Map<String, Object> map) {
        Object H = m2072H(map);
        return H == null ? null : cy(H.toString());
    }

    /* renamed from: H */
    private Object m2072H(Map<String, Object> map) {
        String[] strArr = aqQ;
        int length = strArr.length;
        int i = 0;
        Object obj = map;
        while (i < length) {
            Object obj2 = strArr[i];
            if (!(obj instanceof Map)) {
                return null;
            }
            i++;
            obj = ((Map) obj).get(obj2);
        }
        return obj;
    }

    /* renamed from: I */
    private List<C0600a> m2073I(Map<String, Object> map) {
        Object arrayList = new ArrayList();
        m2078a(map, "", arrayList);
        return arrayList;
    }

    /* renamed from: J */
    private void m2074J(Map<String, Object> map) {
        synchronized (this.aqT) {
            for (String str : map.keySet()) {
                m2080a(m2082c(str, map.get(str)), this.aqT);
            }
        }
        m2075K(map);
    }

    /* renamed from: K */
    private void m2075K(Map<String, Object> map) {
        for (C0601b C : this.aqS.keySet()) {
            C.mo2510C(map);
        }
    }

    /* renamed from: a */
    private void m2078a(Map<String, Object> map, String str, Collection<C0600a> collection) {
        for (Entry entry : map.entrySet()) {
            String str2 = str + (str.length() == 0 ? "" : ".") + ((String) entry.getKey());
            if (entry.getValue() instanceof Map) {
                m2078a((Map) entry.getValue(), str2, collection);
            } else if (!str2.equals("gtm.lifetime")) {
                collection.add(new C0600a(str2, entry.getValue()));
            }
        }
    }

    static Long cy(String str) {
        Matcher matcher = aqR.matcher(str);
        if (matcher.matches()) {
            long parseLong;
            try {
                parseLong = Long.parseLong(matcher.group(1));
            } catch (NumberFormatException e) {
                bh.m2117W("illegal number in _lifetime value: " + str);
                parseLong = 0;
            }
            if (parseLong <= 0) {
                bh.m2115U("non-positive _lifetime: " + str);
                return null;
            }
            String group = matcher.group(2);
            if (group.length() == 0) {
                return Long.valueOf(parseLong);
            }
            switch (group.charAt(0)) {
                case 'd':
                    return Long.valueOf((((parseLong * 1000) * 60) * 60) * 24);
                case LocationRequest.PRIORITY_LOW_POWER /*104*/:
                    return Long.valueOf(((parseLong * 1000) * 60) * 60);
                case 'm':
                    return Long.valueOf((parseLong * 1000) * 60);
                case 's':
                    return Long.valueOf(parseLong * 1000);
                default:
                    bh.m2117W("unknown units in _lifetime: " + str);
                    return null;
            }
        }
        bh.m2115U("unknown _lifetime: " + str);
        return null;
    }

    public static List<Object> listOf(Object... objects) {
        List<Object> arrayList = new ArrayList();
        for (Object add : objects) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public static Map<String, Object> mapOf(Object... objects) {
        if (objects.length % 2 != 0) {
            throw new IllegalArgumentException("expected even number of key-value pairs");
        }
        Map<String, Object> hashMap = new HashMap();
        int i = 0;
        while (i < objects.length) {
            if (objects[i] instanceof String) {
                hashMap.put((String) objects[i], objects[i + 1]);
                i += 2;
            } else {
                throw new IllegalArgumentException("key is not a string: " + objects[i]);
            }
        }
        return hashMap;
    }

    private void pv() {
        this.aqW.mo2506a(new C12082(this));
    }

    private void pw() {
        int i = 0;
        while (true) {
            Map map = (Map) this.aqV.poll();
            if (map != null) {
                m2074J(map);
                int i2 = i + 1;
                if (i2 > 500) {
                    this.aqV.clear();
                    throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
                }
                i = i2;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    void m2079a(C0601b c0601b) {
        this.aqS.put(c0601b, Integer.valueOf(0));
    }

    /* renamed from: a */
    void m2080a(Map<String, Object> map, Map<String, Object> map2) {
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof List) {
                if (!(map2.get(str) instanceof List)) {
                    map2.put(str, new ArrayList());
                }
                m2081b((List) obj, (List) map2.get(str));
            } else if (obj instanceof Map) {
                if (!(map2.get(str) instanceof Map)) {
                    map2.put(str, new HashMap());
                }
                m2080a((Map) obj, (Map) map2.get(str));
            } else {
                map2.put(str, obj);
            }
        }
    }

    /* renamed from: b */
    void m2081b(List<Object> list, List<Object> list2) {
        while (list2.size() < list.size()) {
            list2.add(null);
        }
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if (obj instanceof List) {
                if (!(list2.get(i) instanceof List)) {
                    list2.set(i, new ArrayList());
                }
                m2081b((List) obj, (List) list2.get(i));
            } else if (obj instanceof Map) {
                if (!(list2.get(i) instanceof Map)) {
                    list2.set(i, new HashMap());
                }
                m2080a((Map) obj, (Map) list2.get(i));
            } else if (obj != OBJECT_NOT_PRESENT) {
                list2.set(i, obj);
            }
        }
    }

    /* renamed from: c */
    Map<String, Object> m2082c(String str, Object obj) {
        Map hashMap = new HashMap();
        String[] split = str.toString().split("\\.");
        int i = 0;
        Map map = hashMap;
        while (i < split.length - 1) {
            HashMap hashMap2 = new HashMap();
            map.put(split[i], hashMap2);
            i++;
            Object obj2 = hashMap2;
        }
        map.put(split[split.length - 1], obj);
        return hashMap;
    }

    void cx(String str) {
        push(str, null);
        this.aqW.cz(str);
    }

    public Object get(String key) {
        synchronized (this.aqT) {
            Map map = this.aqT;
            String[] split = key.split("\\.");
            int length = split.length;
            Object obj = map;
            int i = 0;
            while (i < length) {
                Object obj2 = split[i];
                if (obj instanceof Map) {
                    obj2 = ((Map) obj).get(obj2);
                    if (obj2 == null) {
                        return null;
                    }
                    i++;
                    obj = obj2;
                } else {
                    return null;
                }
            }
            return obj;
        }
    }

    public void push(String key, Object value) {
        push(m2082c(key, value));
    }

    public void push(Map<String, Object> update) {
        try {
            this.aqX.await();
        } catch (InterruptedException e) {
            bh.m2117W("DataLayer.push: unexpected InterruptedException");
        }
        m2069E(update);
    }

    public void pushEvent(String eventName, Map<String, Object> update) {
        Map hashMap = new HashMap(update);
        hashMap.put(EVENT_KEY, eventName);
        push(hashMap);
    }

    public String toString() {
        String stringBuilder;
        synchronized (this.aqT) {
            StringBuilder stringBuilder2 = new StringBuilder();
            for (Entry entry : this.aqT.entrySet()) {
                stringBuilder2.append(String.format("{\n\tKey: %s\n\tValue: %s\n}\n", new Object[]{entry.getKey(), entry.getValue()}));
            }
            stringBuilder = stringBuilder2.toString();
        }
        return stringBuilder;
    }
}
