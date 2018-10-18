package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class jv {

    /* renamed from: com.google.android.gms.internal.jv$a */
    public static final class C0483a {
        private final List<String> Nr;
        private final Object Ns;

        private C0483a(Object obj) {
            this.Ns = jx.m1582i(obj);
            this.Nr = new ArrayList();
        }

        /* renamed from: a */
        public C0483a m1570a(String str, Object obj) {
            this.Nr.add(((String) jx.m1582i(str)) + "=" + String.valueOf(obj));
            return this;
        }

        public String toString() {
            StringBuilder append = new StringBuilder(100).append(this.Ns.getClass().getSimpleName()).append('{');
            int size = this.Nr.size();
            for (int i = 0; i < size; i++) {
                append.append((String) this.Nr.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            return append.append('}').toString();
        }
    }

    public static boolean equal(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    /* renamed from: h */
    public static C0483a m1571h(Object obj) {
        return new C0483a(obj);
    }

    public static int hashCode(Object... objects) {
        return Arrays.hashCode(objects);
    }
}
