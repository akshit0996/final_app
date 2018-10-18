package com.google.android.gms.internal;

import android.content.Context;
import android.view.MotionEvent;
import com.google.android.gms.internal.C1440u.C0509b;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@ey
/* renamed from: com.google.android.gms.internal.x */
class C1080x implements C0434g, Runnable {
    private C0509b lB;
    private final List<Object[]> mp = new Vector();
    private final AtomicReference<C0434g> mq = new AtomicReference();
    CountDownLatch mr = new CountDownLatch(1);

    public C1080x(C0509b c0509b) {
        this.lB = c0509b;
        if (gq.dB()) {
            gh.m1283a(this);
        } else {
            run();
        }
    }

    private void aB() {
        if (!this.mp.isEmpty()) {
            for (Object[] objArr : this.mp) {
                if (objArr.length == 1) {
                    ((C0434g) this.mq.get()).mo1801a((MotionEvent) objArr[0]);
                } else if (objArr.length == 3) {
                    ((C0434g) this.mq.get()).mo1800a(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                }
            }
        }
    }

    /* renamed from: i */
    private Context m3550i(Context context) {
        if (!aC()) {
            return context;
        }
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? applicationContext : context;
    }

    /* renamed from: a */
    public String mo1798a(Context context) {
        if (aA()) {
            C0434g c0434g = (C0434g) this.mq.get();
            if (c0434g != null) {
                aB();
                return c0434g.mo1798a(m3550i(context));
            }
        }
        return "";
    }

    /* renamed from: a */
    public String mo1799a(Context context, String str) {
        if (aA()) {
            C0434g c0434g = (C0434g) this.mq.get();
            if (c0434g != null) {
                aB();
                return c0434g.mo1799a(m3550i(context), str);
            }
        }
        return "";
    }

    /* renamed from: a */
    public void mo1800a(int i, int i2, int i3) {
        C0434g c0434g = (C0434g) this.mq.get();
        if (c0434g != null) {
            aB();
            c0434g.mo1800a(i, i2, i3);
            return;
        }
        this.mp.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    /* renamed from: a */
    public void mo1801a(MotionEvent motionEvent) {
        C0434g c0434g = (C0434g) this.mq.get();
        if (c0434g != null) {
            aB();
            c0434g.mo1801a(motionEvent);
            return;
        }
        this.mp.add(new Object[]{motionEvent});
    }

    /* renamed from: a */
    protected void m3555a(C0434g c0434g) {
        this.mq.set(c0434g);
    }

    protected boolean aA() {
        try {
            this.mr.await();
            return true;
        } catch (Throwable e) {
            gr.m1345d("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    protected boolean aC() {
        return ga.bN().getBoolean("gads:spam_app_context:enabled", false);
    }

    public void run() {
        try {
            m3555a(C1516j.m4931a(this.lB.lO.wS, m3550i(this.lB.lM)));
        } finally {
            this.mr.countDown();
            this.lB = null;
        }
    }
}
