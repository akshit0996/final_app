package com.google.android.gms.internal;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.C1392i.C0458a;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.google.android.gms.internal.j */
public class C1516j extends C1392i {
    private static AdvertisingIdClient kO;
    private static CountDownLatch kP = new CountDownLatch(1);
    private static boolean kQ;

    /* renamed from: com.google.android.gms.internal.j$1 */
    static class C04711 extends AsyncTask<Void, Void, Void> {
        C04711() {
        }

        /* renamed from: a */
        protected Void m1489a(Void... voidArr) {
            try {
                C1516j.kO.start();
            } catch (GooglePlayServicesNotAvailableException e) {
                C1516j.kQ = true;
                C1516j.kO = null;
            } catch (IOException e2) {
                C1516j.kO = null;
            } catch (GooglePlayServicesRepairableException e3) {
                C1516j.kO = null;
            }
            C1516j.kP.countDown();
            return null;
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m1489a((Void[]) objArr);
        }
    }

    /* renamed from: com.google.android.gms.internal.j$a */
    class C0472a {
        private String kR;
        private boolean kS;
        final /* synthetic */ C1516j kT;

        public C0472a(C1516j c1516j, String str, boolean z) {
            this.kT = c1516j;
            this.kR = str;
            this.kS = z;
        }

        public String getId() {
            return this.kR;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.kS;
        }
    }

    protected C1516j(Context context, C0487m c0487m, C0489n c0489n) {
        super(context, c0487m, c0489n);
    }

    /* renamed from: a */
    public static C1516j m4931a(String str, Context context) {
        C0487m c0940e = new C0940e();
        C1392i.m4390a(str, context, c0940e);
        synchronized (C1516j.class) {
            if (kO == null) {
                kO = new AdvertisingIdClient(context);
                new C04711().execute(new Void[0]);
            }
        }
        return new C1516j(context, c0940e, new C1062p(239));
    }

    /* renamed from: b */
    protected void mo3327b(Context context) {
        super.mo3327b(context);
        try {
            if (kQ) {
                m3220a(24, C1392i.m4393d(context));
                return;
            }
            C0472a z = m4934z();
            m3219a(28, z.isLimitAdTrackingEnabled() ? 1 : 0);
            String id = z.getId();
            if (id != null) {
                m3219a(26, 5);
                m3220a(24, id);
            }
        } catch (IOException e) {
        } catch (C0458a e2) {
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: z */
    com.google.android.gms.internal.C1516j.C0472a m4934z() throws java.io.IOException {
        /*
        r8 = this;
        r7 = 16;
        r0 = 0;
        r1 = com.google.android.gms.internal.C1516j.class;
        monitor-enter(r1);
        r2 = kP;	 Catch:{ InterruptedException -> 0x001b }
        r3 = 2;
        r5 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ InterruptedException -> 0x001b }
        r2 = r2.await(r3, r5);	 Catch:{ InterruptedException -> 0x001b }
        if (r2 != 0) goto L_0x0028;
    L_0x0012:
        r0 = new com.google.android.gms.internal.j$a;	 Catch:{ InterruptedException -> 0x001b }
        r2 = 0;
        r3 = 0;
        r0.<init>(r8, r2, r3);	 Catch:{ InterruptedException -> 0x001b }
        monitor-exit(r1);	 Catch:{ all -> 0x0025 }
    L_0x001a:
        return r0;
    L_0x001b:
        r0 = move-exception;
        r0 = new com.google.android.gms.internal.j$a;	 Catch:{ all -> 0x0025 }
        r2 = 0;
        r3 = 0;
        r0.<init>(r8, r2, r3);	 Catch:{ all -> 0x0025 }
        monitor-exit(r1);	 Catch:{ all -> 0x0025 }
        goto L_0x001a;
    L_0x0025:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0025 }
        throw r0;
    L_0x0028:
        r2 = kO;	 Catch:{ all -> 0x0025 }
        if (r2 != 0) goto L_0x0035;
    L_0x002c:
        r0 = new com.google.android.gms.internal.j$a;	 Catch:{ all -> 0x0025 }
        r2 = 0;
        r3 = 0;
        r0.<init>(r8, r2, r3);	 Catch:{ all -> 0x0025 }
        monitor-exit(r1);	 Catch:{ all -> 0x0025 }
        goto L_0x001a;
    L_0x0035:
        r2 = kO;	 Catch:{ all -> 0x0025 }
        r3 = r2.getInfo();	 Catch:{ all -> 0x0025 }
        monitor-exit(r1);	 Catch:{ all -> 0x0025 }
        r2 = r3.getId();
        if (r2 == 0) goto L_0x0094;
    L_0x0042:
        r1 = "^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        r1 = r2.matches(r1);
        if (r1 == 0) goto L_0x0094;
    L_0x004a:
        r4 = new byte[r7];
        r1 = r0;
    L_0x004d:
        r5 = r2.length();
        if (r0 >= r5) goto L_0x0082;
    L_0x0053:
        r5 = 8;
        if (r0 == r5) goto L_0x0063;
    L_0x0057:
        r5 = 13;
        if (r0 == r5) goto L_0x0063;
    L_0x005b:
        r5 = 18;
        if (r0 == r5) goto L_0x0063;
    L_0x005f:
        r5 = 23;
        if (r0 != r5) goto L_0x0065;
    L_0x0063:
        r0 = r0 + 1;
    L_0x0065:
        r5 = r2.charAt(r0);
        r5 = java.lang.Character.digit(r5, r7);
        r5 = r5 << 4;
        r6 = r0 + 1;
        r6 = r2.charAt(r6);
        r6 = java.lang.Character.digit(r6, r7);
        r5 = r5 + r6;
        r5 = (byte) r5;
        r4[r1] = r5;
        r1 = r1 + 1;
        r0 = r0 + 2;
        goto L_0x004d;
    L_0x0082:
        r0 = r8.ky;
        r1 = 1;
        r0 = r0.mo1763a(r4, r1);
    L_0x0089:
        r1 = new com.google.android.gms.internal.j$a;
        r2 = r3.isLimitAdTrackingEnabled();
        r1.<init>(r8, r0, r2);
        r0 = r1;
        goto L_0x001a;
    L_0x0094:
        r0 = r2;
        goto L_0x0089;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.j.z():com.google.android.gms.internal.j$a");
    }
}
