package com.google.android.gms.games.internal.events;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class EventIncrementCache {
    final Object ack = new Object();
    private Handler acl;
    private boolean acm;
    private HashMap<String, AtomicInteger> acn;
    private int aco;

    /* renamed from: com.google.android.gms.games.internal.events.EventIncrementCache$1 */
    class C03501 implements Runnable {
        final /* synthetic */ EventIncrementCache acp;

        C03501(EventIncrementCache eventIncrementCache) {
            this.acp = eventIncrementCache;
        }

        public void run() {
            this.acp.lX();
        }
    }

    public EventIncrementCache(Looper looper, int flushIntervalMillis) {
        this.acl = new Handler(looper);
        this.acn = new HashMap();
        this.aco = flushIntervalMillis;
    }

    private void lX() {
        synchronized (this.ack) {
            this.acm = false;
            flush();
        }
    }

    public void flush() {
        synchronized (this.ack) {
            for (Entry entry : this.acn.entrySet()) {
                mo1171r((String) entry.getKey(), ((AtomicInteger) entry.getValue()).get());
            }
            this.acn.clear();
        }
    }

    /* renamed from: r */
    protected abstract void mo1171r(String str, int i);

    /* renamed from: y */
    public void m946y(String str, int i) {
        synchronized (this.ack) {
            if (!this.acm) {
                this.acm = true;
                this.acl.postDelayed(new C03501(this), (long) this.aco);
            }
            AtomicInteger atomicInteger = (AtomicInteger) this.acn.get(str);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger();
                this.acn.put(str, atomicInteger);
            }
            atomicInteger.addAndGet(i);
        }
    }
}
