package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import com.google.android.gms.internal.C0381c.C1383f;
import com.google.android.gms.internal.pu.C1431a;
import com.google.android.gms.internal.qv;
import com.google.android.gms.internal.qw;
import com.google.android.gms.tagmanager.C1473o.C1238f;
import com.google.android.gms.tagmanager.bg.C0615a;
import com.google.android.gms.tagmanager.ce.C0617a;
import com.google.android.gms.tagmanager.cr.C0625c;
import com.google.android.gms.tagmanager.cr.C0629g;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

class cq implements C1238f {
    private final String aqm;
    private bg<C1431a> asC;
    private final ExecutorService asJ = Executors.newSingleThreadExecutor();
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.cq$1 */
    class C06201 implements Runnable {
        final /* synthetic */ cq asK;

        C06201(cq cqVar) {
            this.asK = cqVar;
        }

        public void run() {
            this.asK.qi();
        }
    }

    cq(Context context, String str) {
        this.mContext = context;
        this.aqm = str;
    }

    /* renamed from: a */
    private C0625c m4662a(ByteArrayOutputStream byteArrayOutputStream) {
        C0625c c0625c = null;
        try {
            c0625c = ba.cI(byteArrayOutputStream.toString("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            bh.m2113S("Failed to convert binary resource to string for JSON parsing; the file format is not UTF-8 format.");
        } catch (JSONException e2) {
            bh.m2117W("Failed to extract the container from the resource file. Resource is a UTF-8 encoded string but doesn't contain a JSON container");
        }
        return c0625c;
    }

    /* renamed from: d */
    private void m4663d(C1431a c1431a) throws IllegalArgumentException {
        if (c1431a.gs == null && c1431a.auC == null) {
            throw new IllegalArgumentException("Resource and SupplementedResource are NULL.");
        }
    }

    /* renamed from: k */
    private C0625c m4664k(byte[] bArr) {
        try {
            C0625c b = cr.m2153b(C1383f.m4303a(bArr));
            if (b == null) {
                return b;
            }
            bh.m2116V("The container was successfully loaded from the resource (using binary file)");
            return b;
        } catch (qv e) {
            bh.m2114T("The resource file is corrupted. The container cannot be extracted from the binary file");
            return null;
        } catch (C0629g e2) {
            bh.m2117W("The resource file is invalid. The container from the binary file is invalid");
            return null;
        }
    }

    /* renamed from: a */
    public void mo3610a(bg<C1431a> bgVar) {
        this.asC = bgVar;
    }

    /* renamed from: b */
    public void mo3611b(final C1431a c1431a) {
        this.asJ.execute(new Runnable(this) {
            final /* synthetic */ cq asK;

            public void run() {
                this.asK.m4667c(c1431a);
            }
        });
    }

    /* renamed from: c */
    boolean m4667c(C1431a c1431a) {
        boolean z = false;
        File qj = qj();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(qj);
            try {
                fileOutputStream.write(qw.m1906f(c1431a));
                z = true;
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    bh.m2117W("error closing stream for writing resource to disk");
                }
            } catch (IOException e2) {
                bh.m2117W("Error writing resource to disk. Removing resource from disk.");
                qj.delete();
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    bh.m2117W("error closing stream for writing resource to disk");
                }
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                    bh.m2117W("error closing stream for writing resource to disk");
                }
                throw th;
            }
        } catch (FileNotFoundException e5) {
            bh.m2114T("Error opening resource file for writing");
        }
        return z;
    }

    public C0625c fH(int i) {
        try {
            InputStream openRawResource = this.mContext.getResources().openRawResource(i);
            bh.m2116V("Attempting to load a container from the resource ID " + i + " (" + this.mContext.getResources().getResourceName(i) + ")");
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                cr.m2154b(openRawResource, byteArrayOutputStream);
                C0625c a = m4662a(byteArrayOutputStream);
                if (a == null) {
                    return m4664k(byteArrayOutputStream.toByteArray());
                }
                bh.m2116V("The container was successfully loaded from the resource (using JSON file format)");
                return a;
            } catch (IOException e) {
                bh.m2117W("Error reading the default container with resource ID " + i + " (" + this.mContext.getResources().getResourceName(i) + ")");
                return null;
            }
        } catch (NotFoundException e2) {
            bh.m2117W("Failed to load the container. No default container resource found with the resource ID " + i);
            return null;
        }
    }

    public void pt() {
        this.asJ.execute(new C06201(this));
    }

    void qi() {
        if (this.asC == null) {
            throw new IllegalStateException("Callback must be set before execute");
        }
        this.asC.ps();
        bh.m2116V("Attempting to load resource from disk");
        if ((ce.qa().qb() == C0617a.CONTAINER || ce.qa().qb() == C0617a.CONTAINER_DEBUG) && this.aqm.equals(ce.qa().getContainerId())) {
            this.asC.mo2570a(C0615a.NOT_AVAILABLE);
            return;
        }
        try {
            InputStream fileInputStream = new FileInputStream(qj());
            try {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                cr.m2154b(fileInputStream, byteArrayOutputStream);
                C1431a l = C1431a.m4540l(byteArrayOutputStream.toByteArray());
                m4663d(l);
                this.asC.mo2571l(l);
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    bh.m2117W("Error closing stream for reading resource from disk");
                }
            } catch (IOException e2) {
                this.asC.mo2570a(C0615a.IO_ERROR);
                bh.m2117W("Failed to read the resource from disk");
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                    bh.m2117W("Error closing stream for reading resource from disk");
                }
            } catch (IllegalArgumentException e4) {
                this.asC.mo2570a(C0615a.IO_ERROR);
                bh.m2117W("Failed to read the resource from disk. The resource is inconsistent");
                try {
                    fileInputStream.close();
                } catch (IOException e5) {
                    bh.m2117W("Error closing stream for reading resource from disk");
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (IOException e6) {
                    bh.m2117W("Error closing stream for reading resource from disk");
                }
                throw th;
            }
            bh.m2116V("The Disk resource was successfully read.");
        } catch (FileNotFoundException e7) {
            bh.m2113S("Failed to find the resource in the disk");
            this.asC.mo2570a(C0615a.NOT_AVAILABLE);
        }
    }

    File qj() {
        return new File(this.mContext.getDir("google_tagmanager", 0), "resource_" + this.aqm);
    }

    public synchronized void release() {
        this.asJ.shutdown();
    }
}
