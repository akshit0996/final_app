package com.google.android.gms.analytics;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/* renamed from: com.google.android.gms.analytics.k */
class C0785k implements C0125q {
    private static final Object xO = new Object();
    private static C0785k yD;
    private final Context mContext;
    private String yE;
    private boolean yF = false;
    private final Object yG = new Object();

    protected C0785k(Context context) {
        this.mContext = context;
        ep();
    }

    private boolean ae(String str) {
        try {
            ae.m44V("Storing clientId.");
            FileOutputStream openFileOutput = this.mContext.openFileOutput("gaClientId", 0);
            openFileOutput.write(str.getBytes());
            openFileOutput.close();
            return true;
        } catch (FileNotFoundException e) {
            ae.m42T("Error creating clientId file.");
            return false;
        } catch (IOException e2) {
            ae.m42T("Error writing to clientId file.");
            return false;
        }
    }

    public static C0785k el() {
        C0785k c0785k;
        synchronized (xO) {
            c0785k = yD;
        }
        return c0785k;
    }

    private String en() {
        if (!this.yF) {
            synchronized (this.yG) {
                if (!this.yF) {
                    ae.m44V("Waiting for clientId to load");
                    do {
                        try {
                            this.yG.wait();
                        } catch (InterruptedException e) {
                            ae.m42T("Exception while waiting for clientId: " + e);
                        }
                    } while (!this.yF);
                }
            }
        }
        ae.m44V("Loaded clientId");
        return this.yE;
    }

    private void ep() {
        new Thread(this, "client_id_fetcher") {
            final /* synthetic */ C0785k yH;

            public void run() {
                synchronized (this.yH.yG) {
                    this.yH.yE = this.yH.eq();
                    this.yH.yF = true;
                    this.yH.yG.notifyAll();
                }
            }
        }.start();
    }

    /* renamed from: y */
    public static void m2393y(Context context) {
        synchronized (xO) {
            if (yD == null) {
                yD = new C0785k(context);
            }
        }
    }

    public boolean ac(String str) {
        return "&cid".equals(str);
    }

    String em() {
        String str;
        synchronized (this.yG) {
            this.yE = eo();
            str = this.yE;
        }
        return str;
    }

    protected String eo() {
        String toLowerCase = UUID.randomUUID().toString().toLowerCase();
        try {
            return !ae(toLowerCase) ? "0" : toLowerCase;
        } catch (Exception e) {
            return null;
        }
    }

    String eq() {
        String str = null;
        try {
            FileInputStream openFileInput = this.mContext.openFileInput("gaClientId");
            byte[] bArr = new byte[128];
            int read = openFileInput.read(bArr, 0, 128);
            if (openFileInput.available() > 0) {
                ae.m42T("clientId file seems corrupted, deleting it.");
                openFileInput.close();
                this.mContext.deleteFile("gaClientId");
            } else if (read <= 0) {
                ae.m42T("clientId file seems empty, deleting it.");
                openFileInput.close();
                this.mContext.deleteFile("gaClientId");
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                    ae.m44V("Loaded client id from disk.");
                    str = str2;
                } catch (FileNotFoundException e) {
                    str = str2;
                } catch (IOException e2) {
                    str = str2;
                    ae.m42T("Error reading clientId file, deleting it.");
                    this.mContext.deleteFile("gaClientId");
                }
            }
        } catch (FileNotFoundException e3) {
        } catch (IOException e4) {
            ae.m42T("Error reading clientId file, deleting it.");
            this.mContext.deleteFile("gaClientId");
        }
        return str == null ? eo() : str;
    }

    public String getValue(String field) {
        return "&cid".equals(field) ? en() : null;
    }
}
