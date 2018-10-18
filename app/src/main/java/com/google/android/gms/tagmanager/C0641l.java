package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;

/* renamed from: com.google.android.gms.tagmanager.l */
class C0641l<K, V> {
    final C0640a<K, V> aqk = new C12301(this);

    /* renamed from: com.google.android.gms.tagmanager.l$a */
    public interface C0640a<K, V> {
        int sizeOf(K k, V v);
    }

    /* renamed from: com.google.android.gms.tagmanager.l$1 */
    class C12301 implements C0640a<K, V> {
        final /* synthetic */ C0641l aql;

        C12301(C0641l c0641l) {
            this.aql = c0641l;
        }

        public int sizeOf(K k, V v) {
            return 1;
        }
    }

    /* renamed from: a */
    public C0639k<K, V> m2212a(int i, C0640a<K, V> c0640a) {
        if (i > 0) {
            return pg() < 12 ? new da(i, c0640a) : new bb(i, c0640a);
        } else {
            throw new IllegalArgumentException("maxSize <= 0");
        }
    }

    int pg() {
        return VERSION.SDK_INT;
    }
}
