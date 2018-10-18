package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.internal.C0381c.C1387j;
import com.google.android.gms.tagmanager.bg.C0615a;
import com.google.android.gms.tagmanager.ce.C0617a;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

class co implements Runnable {
    private volatile String aqI;
    private final String aqm;
    private final bn asA;
    private final String asB;
    private bg<C1387j> asC;
    private volatile C0645r asD;
    private volatile String asE;
    private final Context mContext;

    co(Context context, String str, bn bnVar, C0645r c0645r) {
        this.mContext = context;
        this.asA = bnVar;
        this.aqm = str;
        this.asD = c0645r;
        this.asB = "/r?id=" + str;
        this.aqI = this.asB;
        this.asE = null;
    }

    public co(Context context, String str, C0645r c0645r) {
        this(context, str, new bn(), c0645r);
    }

    private boolean qd() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        bh.m2116V("...no network connectivity");
        return false;
    }

    private void qe() {
        if (qd()) {
            bh.m2116V("Start loading resource from network ...");
            String qf = qf();
            bm pO = this.asA.pO();
            try {
                InputStream cF = pO.cF(qf);
                try {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    cr.m2154b(cF, byteArrayOutputStream);
                    C1387j b = C1387j.m4326b(byteArrayOutputStream.toByteArray());
                    bh.m2116V("Successfully loaded supplemented resource: " + b);
                    if (b.gs == null && b.gr.length == 0) {
                        bh.m2116V("No change for container: " + this.aqm);
                    }
                    this.asC.mo2571l(b);
                    bh.m2116V("Load resource from network finished.");
                } catch (Throwable e) {
                    bh.m2119d("Error when parsing downloaded resources from url: " + qf + " " + e.getMessage(), e);
                    this.asC.mo2570a(C0615a.SERVER_ERROR);
                    pO.close();
                }
            } catch (FileNotFoundException e2) {
                bh.m2117W("No data is retrieved from the given url: " + qf + ". Make sure container_id: " + this.aqm + " is correct.");
                this.asC.mo2570a(C0615a.SERVER_ERROR);
            } catch (Throwable e3) {
                bh.m2119d("Error when loading resources from url: " + qf + " " + e3.getMessage(), e3);
                this.asC.mo2570a(C0615a.IO_ERROR);
            } finally {
                pO.close();
            }
        } else {
            this.asC.mo2570a(C0615a.NOT_AVAILABLE);
        }
    }

    /* renamed from: a */
    void m2136a(bg<C1387j> bgVar) {
        this.asC = bgVar;
    }

    void cL(String str) {
        bh.m2113S("Setting previous container version: " + str);
        this.asE = str;
    }

    void cw(String str) {
        if (str == null) {
            this.aqI = this.asB;
            return;
        }
        bh.m2113S("Setting CTFE URL path: " + str);
        this.aqI = str;
    }

    String qf() {
        String str = this.asD.pu() + this.aqI + "&v=a65833898";
        if (!(this.asE == null || this.asE.trim().equals(""))) {
            str = str + "&pv=" + this.asE;
        }
        return ce.qa().qb().equals(C0617a.CONTAINER_DEBUG) ? str + "&gtm_debug=x" : str;
    }

    public void run() {
        if (this.asC == null) {
            throw new IllegalStateException("callback must be set before execute");
        }
        this.asC.ps();
        qe();
    }
}
