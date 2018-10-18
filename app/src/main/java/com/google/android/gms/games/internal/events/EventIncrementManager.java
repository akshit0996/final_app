package com.google.android.gms.games.internal.events;

import java.util.concurrent.atomic.AtomicReference;

public abstract class EventIncrementManager {
    private final AtomicReference<EventIncrementCache> acq = new AtomicReference();

    public void flush() {
        EventIncrementCache eventIncrementCache = (EventIncrementCache) this.acq.get();
        if (eventIncrementCache != null) {
            eventIncrementCache.flush();
        }
    }

    protected abstract EventIncrementCache lF();

    /* renamed from: o */
    public void m947o(String str, int i) {
        EventIncrementCache eventIncrementCache = (EventIncrementCache) this.acq.get();
        if (eventIncrementCache == null) {
            eventIncrementCache = lF();
            if (!this.acq.compareAndSet(null, eventIncrementCache)) {
                eventIncrementCache = (EventIncrementCache) this.acq.get();
            }
        }
        eventIncrementCache.m946y(str, i);
    }
}
