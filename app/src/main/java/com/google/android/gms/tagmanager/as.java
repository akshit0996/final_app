package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

class as extends Thread implements ar {
    private static as ary;
    private final LinkedBlockingQueue<Runnable> arx = new LinkedBlockingQueue();
    private volatile at arz;
    private volatile boolean mClosed = false;
    private final Context mContext;
    private volatile boolean zK = false;

    private as(Context context) {
        super("GAThread");
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        start();
    }

    /* renamed from: Z */
    static as m3679Z(Context context) {
        if (ary == null) {
            ary = new as(context);
        }
        return ary;
    }

    /* renamed from: g */
    private String m3683g(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    /* renamed from: b */
    public void mo2515b(Runnable runnable) {
        this.arx.add(runnable);
    }

    /* renamed from: b */
    void m3685b(String str, long j) {
        final as asVar = this;
        final long j2 = j;
        final String str2 = str;
        mo2515b(new Runnable(this) {
            final /* synthetic */ as arC;

            public void run() {
                if (this.arC.arz == null) {
                    cy qN = cy.qN();
                    qN.m3743a(this.arC.mContext, asVar);
                    this.arC.arz = qN.qO();
                }
                this.arC.arz.mo2554f(j2, str2);
            }
        });
    }

    public void cE(String str) {
        m3685b(str, System.currentTimeMillis());
    }

    public void run() {
        while (!this.mClosed) {
            try {
                Runnable runnable = (Runnable) this.arx.take();
                if (!this.zK) {
                    runnable.run();
                }
            } catch (InterruptedException e) {
                bh.m2115U(e.toString());
            } catch (Throwable th) {
                bh.m2114T("Error on Google TagManager Thread: " + m3683g(th));
                bh.m2114T("Google TagManager is shutting down.");
                this.zK = true;
            }
        }
    }
}
