package com.google.android.gms.analytics;

import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.google.android.gms.analytics.f */
interface C0116f {
    void dQ();

    void dW();

    LinkedBlockingQueue<Runnable> dX();

    void dY();

    void dispatch();

    Thread getThread();

    /* renamed from: u */
    void mo872u(Map<String, String> map);
}
