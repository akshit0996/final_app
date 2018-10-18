package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.i */
public abstract class C1392i extends C0973h {
    private static Method kA;
    private static Method kB;
    private static Method kC;
    private static Method kD;
    private static Method kE;
    private static Method kF;
    private static Method kG;
    private static Method kH;
    private static Method kI;
    private static String kJ;
    private static String kK;
    private static String kL;
    private static C0492o kM;
    static boolean kN = false;
    private static long startTime = 0;

    /* renamed from: com.google.android.gms.internal.i$a */
    static class C0458a extends Exception {
        public C0458a(Throwable th) {
            super(th);
        }
    }

    protected C1392i(Context context, C0487m c0487m, C0489n c0489n) {
        super(context, c0487m, c0489n);
    }

    /* renamed from: a */
    static String m4388a(Context context, C0487m c0487m) throws C0458a {
        if (kK != null) {
            return kK;
        }
        if (kD == null) {
            throw new C0458a();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) kD.invoke(null, new Object[]{context});
            if (byteBuffer == null) {
                throw new C0458a();
            }
            kK = c0487m.mo1763a(byteBuffer.array(), true);
            return kK;
        } catch (Throwable e) {
            throw new C0458a(e);
        } catch (Throwable e2) {
            throw new C0458a(e2);
        }
    }

    /* renamed from: a */
    static ArrayList<Long> m4389a(MotionEvent motionEvent, DisplayMetrics displayMetrics) throws C0458a {
        if (kE == null || motionEvent == null) {
            throw new C0458a();
        }
        try {
            return (ArrayList) kE.invoke(null, new Object[]{motionEvent, displayMetrics});
        } catch (Throwable e) {
            throw new C0458a(e);
        } catch (Throwable e2) {
            throw new C0458a(e2);
        }
    }

    /* renamed from: a */
    protected static synchronized void m4390a(String str, Context context, C0487m c0487m) {
        synchronized (C1392i.class) {
            if (!kN) {
                try {
                    kM = new C0492o(c0487m, null);
                    kJ = str;
                    C1392i.m4396g(context);
                    startTime = C1392i.m4398w().longValue();
                    kN = true;
                } catch (C0458a e) {
                } catch (UnsupportedOperationException e2) {
                }
            }
        }
    }

    /* renamed from: b */
    static String m4391b(Context context, C0487m c0487m) throws C0458a {
        if (kL != null) {
            return kL;
        }
        if (kG == null) {
            throw new C0458a();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) kG.invoke(null, new Object[]{context});
            if (byteBuffer == null) {
                throw new C0458a();
            }
            kL = c0487m.mo1763a(byteBuffer.array(), true);
            return kL;
        } catch (Throwable e) {
            throw new C0458a(e);
        } catch (Throwable e2) {
            throw new C0458a(e2);
        }
    }

    /* renamed from: b */
    private static String m4392b(byte[] bArr, String str) throws C0458a {
        try {
            return new String(kM.m1751c(bArr, str), "UTF-8");
        } catch (Throwable e) {
            throw new C0458a(e);
        } catch (Throwable e2) {
            throw new C0458a(e2);
        }
    }

    /* renamed from: d */
    static String m4393d(Context context) throws C0458a {
        if (kF == null) {
            throw new C0458a();
        }
        try {
            String str = (String) kF.invoke(null, new Object[]{context});
            if (str != null) {
                return str;
            }
            throw new C0458a();
        } catch (Throwable e) {
            throw new C0458a(e);
        } catch (Throwable e2) {
            throw new C0458a(e2);
        }
    }

    /* renamed from: e */
    static ArrayList<Long> m4394e(Context context) throws C0458a {
        if (kH == null) {
            throw new C0458a();
        }
        try {
            ArrayList<Long> arrayList = (ArrayList) kH.invoke(null, new Object[]{context});
            if (arrayList != null && arrayList.size() == 2) {
                return arrayList;
            }
            throw new C0458a();
        } catch (Throwable e) {
            throw new C0458a(e);
        } catch (Throwable e2) {
            throw new C0458a(e2);
        }
    }

    /* renamed from: f */
    static int[] m4395f(Context context) throws C0458a {
        if (kI == null) {
            throw new C0458a();
        }
        try {
            return (int[]) kI.invoke(null, new Object[]{context});
        } catch (Throwable e) {
            throw new C0458a(e);
        } catch (Throwable e2) {
            throw new C0458a(e2);
        }
    }

    /* renamed from: g */
    private static void m4396g(Context context) throws C0458a {
        File file;
        File createTempFile;
        try {
            byte[] b = kM.m1750b(C0497q.getKey());
            byte[] c = kM.m1751c(b, C0497q.m1784E());
            File cacheDir = context.getCacheDir();
            if (cacheDir == null) {
                cacheDir = context.getDir("dex", 0);
                if (cacheDir == null) {
                    throw new C0458a();
                }
            }
            file = cacheDir;
            createTempFile = File.createTempFile("ads", ".jar", file);
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(c, 0, c.length);
            fileOutputStream.close();
            DexClassLoader dexClassLoader = new DexClassLoader(createTempFile.getAbsolutePath(), file.getAbsolutePath(), null, context.getClassLoader());
            Class loadClass = dexClassLoader.loadClass(C1392i.m4392b(b, C0497q.m1787H()));
            Class loadClass2 = dexClassLoader.loadClass(C1392i.m4392b(b, C0497q.m1799T()));
            Class loadClass3 = dexClassLoader.loadClass(C1392i.m4392b(b, C0497q.m1793N()));
            Class loadClass4 = dexClassLoader.loadClass(C1392i.m4392b(b, C0497q.m1791L()));
            Class loadClass5 = dexClassLoader.loadClass(C1392i.m4392b(b, C0497q.m1801V()));
            Class loadClass6 = dexClassLoader.loadClass(C1392i.m4392b(b, C0497q.m1789J()));
            Class loadClass7 = dexClassLoader.loadClass(C1392i.m4392b(b, C0497q.m1797R()));
            Class loadClass8 = dexClassLoader.loadClass(C1392i.m4392b(b, C0497q.m1795P()));
            Class loadClass9 = dexClassLoader.loadClass(C1392i.m4392b(b, C0497q.m1785F()));
            kA = loadClass.getMethod(C1392i.m4392b(b, C0497q.m1788I()), new Class[0]);
            kB = loadClass2.getMethod(C1392i.m4392b(b, C0497q.m1800U()), new Class[0]);
            kC = loadClass3.getMethod(C1392i.m4392b(b, C0497q.m1794O()), new Class[0]);
            kD = loadClass4.getMethod(C1392i.m4392b(b, C0497q.m1792M()), new Class[]{Context.class});
            kE = loadClass5.getMethod(C1392i.m4392b(b, C0497q.m1802W()), new Class[]{MotionEvent.class, DisplayMetrics.class});
            kF = loadClass6.getMethod(C1392i.m4392b(b, C0497q.m1790K()), new Class[]{Context.class});
            kG = loadClass7.getMethod(C1392i.m4392b(b, C0497q.m1798S()), new Class[]{Context.class});
            kH = loadClass8.getMethod(C1392i.m4392b(b, C0497q.m1796Q()), new Class[]{Context.class});
            kI = loadClass9.getMethod(C1392i.m4392b(b, C0497q.m1786G()), new Class[]{Context.class});
            String name = createTempFile.getName();
            createTempFile.delete();
            new File(file, name.replace(".jar", ".dex")).delete();
        } catch (Throwable e) {
            throw new C0458a(e);
        } catch (Throwable e2) {
            throw new C0458a(e2);
        } catch (Throwable e22) {
            throw new C0458a(e22);
        } catch (Throwable e222) {
            throw new C0458a(e222);
        } catch (Throwable e2222) {
            throw new C0458a(e2222);
        } catch (Throwable e22222) {
            throw new C0458a(e22222);
        } catch (Throwable th) {
            String name2 = createTempFile.getName();
            createTempFile.delete();
            new File(file, name2.replace(".jar", ".dex")).delete();
        }
    }

    /* renamed from: v */
    static String m4397v() throws C0458a {
        if (kJ != null) {
            return kJ;
        }
        throw new C0458a();
    }

    /* renamed from: w */
    static Long m4398w() throws C0458a {
        if (kA == null) {
            throw new C0458a();
        }
        try {
            return (Long) kA.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new C0458a(e);
        } catch (Throwable e2) {
            throw new C0458a(e2);
        }
    }

    /* renamed from: x */
    static String m4399x() throws C0458a {
        if (kC == null) {
            throw new C0458a();
        }
        try {
            return (String) kC.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new C0458a(e);
        } catch (Throwable e2) {
            throw new C0458a(e2);
        }
    }

    /* renamed from: y */
    static Long m4400y() throws C0458a {
        if (kB == null) {
            throw new C0458a();
        }
        try {
            return (Long) kB.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new C0458a(e);
        } catch (Throwable e2) {
            throw new C0458a(e2);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    protected void mo3327b(android.content.Context r7) {
        /*
        r6 = this;
        r0 = 1;
        r1 = com.google.android.gms.internal.C1392i.m4399x();	 Catch:{ a -> 0x00a1, IOException -> 0x0090 }
        r6.m3220a(r0, r1);	 Catch:{ a -> 0x00a1, IOException -> 0x0090 }
    L_0x0008:
        r0 = 2;
        r1 = com.google.android.gms.internal.C1392i.m4397v();	 Catch:{ a -> 0x009e, IOException -> 0x0090 }
        r6.m3220a(r0, r1);	 Catch:{ a -> 0x009e, IOException -> 0x0090 }
    L_0x0010:
        r0 = com.google.android.gms.internal.C1392i.m4398w();	 Catch:{ a -> 0x009c, IOException -> 0x0090 }
        r0 = r0.longValue();	 Catch:{ a -> 0x009c, IOException -> 0x0090 }
        r2 = 25;
        r6.m3219a(r2, r0);	 Catch:{ a -> 0x009c, IOException -> 0x0090 }
        r2 = startTime;	 Catch:{ a -> 0x009c, IOException -> 0x0090 }
        r4 = 0;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x0034;
    L_0x0025:
        r2 = 17;
        r3 = startTime;	 Catch:{ a -> 0x009c, IOException -> 0x0090 }
        r0 = r0 - r3;
        r6.m3219a(r2, r0);	 Catch:{ a -> 0x009c, IOException -> 0x0090 }
        r0 = 23;
        r1 = startTime;	 Catch:{ a -> 0x009c, IOException -> 0x0090 }
        r6.m3219a(r0, r1);	 Catch:{ a -> 0x009c, IOException -> 0x0090 }
    L_0x0034:
        r1 = com.google.android.gms.internal.C1392i.m4394e(r7);	 Catch:{ a -> 0x009a, IOException -> 0x0090 }
        r2 = 31;
        r0 = 0;
        r0 = r1.get(r0);	 Catch:{ a -> 0x009a, IOException -> 0x0090 }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x009a, IOException -> 0x0090 }
        r3 = r0.longValue();	 Catch:{ a -> 0x009a, IOException -> 0x0090 }
        r6.m3219a(r2, r3);	 Catch:{ a -> 0x009a, IOException -> 0x0090 }
        r2 = 32;
        r0 = 1;
        r0 = r1.get(r0);	 Catch:{ a -> 0x009a, IOException -> 0x0090 }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x009a, IOException -> 0x0090 }
        r0 = r0.longValue();	 Catch:{ a -> 0x009a, IOException -> 0x0090 }
        r6.m3219a(r2, r0);	 Catch:{ a -> 0x009a, IOException -> 0x0090 }
    L_0x0058:
        r0 = 33;
        r1 = com.google.android.gms.internal.C1392i.m4400y();	 Catch:{ a -> 0x0098, IOException -> 0x0090 }
        r1 = r1.longValue();	 Catch:{ a -> 0x0098, IOException -> 0x0090 }
        r6.m3219a(r0, r1);	 Catch:{ a -> 0x0098, IOException -> 0x0090 }
    L_0x0065:
        r0 = 27;
        r1 = r6.ky;	 Catch:{ a -> 0x0096, IOException -> 0x0090 }
        r1 = com.google.android.gms.internal.C1392i.m4388a(r7, r1);	 Catch:{ a -> 0x0096, IOException -> 0x0090 }
        r6.m3220a(r0, r1);	 Catch:{ a -> 0x0096, IOException -> 0x0090 }
    L_0x0070:
        r0 = 29;
        r1 = r6.ky;	 Catch:{ a -> 0x0094, IOException -> 0x0090 }
        r1 = com.google.android.gms.internal.C1392i.m4391b(r7, r1);	 Catch:{ a -> 0x0094, IOException -> 0x0090 }
        r6.m3220a(r0, r1);	 Catch:{ a -> 0x0094, IOException -> 0x0090 }
    L_0x007b:
        r0 = com.google.android.gms.internal.C1392i.m4395f(r7);	 Catch:{ a -> 0x0092, IOException -> 0x0090 }
        r1 = 5;
        r2 = 0;
        r2 = r0[r2];	 Catch:{ a -> 0x0092, IOException -> 0x0090 }
        r2 = (long) r2;	 Catch:{ a -> 0x0092, IOException -> 0x0090 }
        r6.m3219a(r1, r2);	 Catch:{ a -> 0x0092, IOException -> 0x0090 }
        r1 = 6;
        r2 = 1;
        r0 = r0[r2];	 Catch:{ a -> 0x0092, IOException -> 0x0090 }
        r2 = (long) r0;	 Catch:{ a -> 0x0092, IOException -> 0x0090 }
        r6.m3219a(r1, r2);	 Catch:{ a -> 0x0092, IOException -> 0x0090 }
    L_0x008f:
        return;
    L_0x0090:
        r0 = move-exception;
        goto L_0x008f;
    L_0x0092:
        r0 = move-exception;
        goto L_0x008f;
    L_0x0094:
        r0 = move-exception;
        goto L_0x007b;
    L_0x0096:
        r0 = move-exception;
        goto L_0x0070;
    L_0x0098:
        r0 = move-exception;
        goto L_0x0065;
    L_0x009a:
        r0 = move-exception;
        goto L_0x0058;
    L_0x009c:
        r0 = move-exception;
        goto L_0x0034;
    L_0x009e:
        r0 = move-exception;
        goto L_0x0010;
    L_0x00a1:
        r0 = move-exception;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.b(android.content.Context):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    protected void mo3328c(android.content.Context r6) {
        /*
        r5 = this;
        r0 = 2;
        r1 = com.google.android.gms.internal.C1392i.m4397v();	 Catch:{ a -> 0x0065, IOException -> 0x005d }
        r5.m3220a(r0, r1);	 Catch:{ a -> 0x0065, IOException -> 0x005d }
    L_0x0008:
        r0 = 1;
        r1 = com.google.android.gms.internal.C1392i.m4399x();	 Catch:{ a -> 0x0063, IOException -> 0x005d }
        r5.m3220a(r0, r1);	 Catch:{ a -> 0x0063, IOException -> 0x005d }
    L_0x0010:
        r0 = 25;
        r1 = com.google.android.gms.internal.C1392i.m4398w();	 Catch:{ a -> 0x0061, IOException -> 0x005d }
        r1 = r1.longValue();	 Catch:{ a -> 0x0061, IOException -> 0x005d }
        r5.m3219a(r0, r1);	 Catch:{ a -> 0x0061, IOException -> 0x005d }
    L_0x001d:
        r0 = r5.kw;	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r1 = r5.kx;	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r1 = com.google.android.gms.internal.C1392i.m4389a(r0, r1);	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r2 = 14;
        r0 = 0;
        r0 = r1.get(r0);	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r3 = r0.longValue();	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r5.m3219a(r2, r3);	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r2 = 15;
        r0 = 1;
        r0 = r1.get(r0);	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r3 = r0.longValue();	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r5.m3219a(r2, r3);	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r0 = r1.size();	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r2 = 3;
        if (r0 < r2) goto L_0x005c;
    L_0x004c:
        r2 = 16;
        r0 = 2;
        r0 = r1.get(r0);	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r0 = r0.longValue();	 Catch:{ a -> 0x005f, IOException -> 0x005d }
        r5.m3219a(r2, r0);	 Catch:{ a -> 0x005f, IOException -> 0x005d }
    L_0x005c:
        return;
    L_0x005d:
        r0 = move-exception;
        goto L_0x005c;
    L_0x005f:
        r0 = move-exception;
        goto L_0x005c;
    L_0x0061:
        r0 = move-exception;
        goto L_0x001d;
    L_0x0063:
        r0 = move-exception;
        goto L_0x0010;
    L_0x0065:
        r0 = move-exception;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.c(android.content.Context):void");
    }
}
