package com.google.android.gms.tagmanager;

import android.util.LruCache;
import com.google.android.gms.tagmanager.C0641l.C0640a;

class bb<K, V> implements C0639k<K, V> {
    private LruCache<K, V> arR;

    bb(int i, final C0640a<K, V> c0640a) {
        this.arR = new LruCache<K, V>(this, i) {
            final /* synthetic */ bb arT;

            protected int sizeOf(K key, V value) {
                return c0640a.sizeOf(key, value);
            }
        };
    }

    /* renamed from: e */
    public void mo2519e(K k, V v) {
        this.arR.put(k, v);
    }

    public V get(K key) {
        return this.arR.get(key);
    }
}
