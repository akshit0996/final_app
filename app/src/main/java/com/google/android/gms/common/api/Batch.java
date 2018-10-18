package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.BaseImplementation.AbstractPendingResult;
import com.google.android.gms.common.api.BaseImplementation.CallbackHandler;
import com.google.android.gms.common.api.PendingResult.C0156a;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends AbstractPendingResult<BatchResult> {
    private boolean JA;
    private boolean JB;
    private final PendingResult<?>[] JC;
    private int Jz;
    private final Object mH;

    public static final class Builder {
        private List<PendingResult<?>> JE = new ArrayList();
        private Looper JF;

        public Builder(GoogleApiClient googleApiClient) {
            this.JF = googleApiClient.getLooper();
        }

        public <R extends Result> BatchResultToken<R> add(PendingResult<R> pendingResult) {
            BatchResultToken<R> batchResultToken = new BatchResultToken(this.JE.size());
            this.JE.add(pendingResult);
            return batchResultToken;
        }

        public Batch build() {
            return new Batch(this.JE, this.JF);
        }
    }

    /* renamed from: com.google.android.gms.common.api.Batch$1 */
    class C07991 implements C0156a {
        final /* synthetic */ Batch JD;

        C07991(Batch batch) {
            this.JD = batch;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: m */
        public void mo913m(com.google.android.gms.common.api.Status r6) {
            /*
            r5 = this;
            r0 = r5.JD;
            r1 = r0.mH;
            monitor-enter(r1);
            r0 = r5.JD;	 Catch:{ all -> 0x0039 }
            r0 = r0.isCanceled();	 Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0011;
        L_0x000f:
            monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        L_0x0010:
            return;
        L_0x0011:
            r0 = r6.isCanceled();	 Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x003c;
        L_0x0017:
            r0 = r5.JD;	 Catch:{ all -> 0x0039 }
            r2 = 1;
            r0.JB = r2;	 Catch:{ all -> 0x0039 }
        L_0x001d:
            r0 = r5.JD;	 Catch:{ all -> 0x0039 }
            r0.Jz = r0.Jz - 1;	 Catch:{ all -> 0x0039 }
            r0 = r5.JD;	 Catch:{ all -> 0x0039 }
            r0 = r0.Jz;	 Catch:{ all -> 0x0039 }
            if (r0 != 0) goto L_0x0037;
        L_0x002a:
            r0 = r5.JD;	 Catch:{ all -> 0x0039 }
            r0 = r0.JB;	 Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0049;
        L_0x0032:
            r0 = r5.JD;	 Catch:{ all -> 0x0039 }
            super.cancel();	 Catch:{ all -> 0x0039 }
        L_0x0037:
            monitor-exit(r1);	 Catch:{ all -> 0x0039 }
            goto L_0x0010;
        L_0x0039:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0039 }
            throw r0;
        L_0x003c:
            r0 = r6.isSuccess();	 Catch:{ all -> 0x0039 }
            if (r0 != 0) goto L_0x001d;
        L_0x0042:
            r0 = r5.JD;	 Catch:{ all -> 0x0039 }
            r2 = 1;
            r0.JA = r2;	 Catch:{ all -> 0x0039 }
            goto L_0x001d;
        L_0x0049:
            r0 = r5.JD;	 Catch:{ all -> 0x0039 }
            r0 = r0.JA;	 Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0069;
        L_0x0051:
            r0 = new com.google.android.gms.common.api.Status;	 Catch:{ all -> 0x0039 }
            r2 = 13;
            r0.<init>(r2);	 Catch:{ all -> 0x0039 }
        L_0x0058:
            r2 = r5.JD;	 Catch:{ all -> 0x0039 }
            r3 = new com.google.android.gms.common.api.BatchResult;	 Catch:{ all -> 0x0039 }
            r4 = r5.JD;	 Catch:{ all -> 0x0039 }
            r4 = r4.JC;	 Catch:{ all -> 0x0039 }
            r3.<init>(r0, r4);	 Catch:{ all -> 0x0039 }
            r2.m2447b(r3);	 Catch:{ all -> 0x0039 }
            goto L_0x0037;
        L_0x0069:
            r0 = com.google.android.gms.common.api.Status.Kw;	 Catch:{ all -> 0x0039 }
            goto L_0x0058;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.Batch.1.m(com.google.android.gms.common.api.Status):void");
        }
    }

    private Batch(List<PendingResult<?>> pendingResultList, Looper looper) {
        super(new CallbackHandler(looper));
        this.mH = new Object();
        this.Jz = pendingResultList.size();
        this.JC = new PendingResult[this.Jz];
        for (int i = 0; i < pendingResultList.size(); i++) {
            PendingResult pendingResult = (PendingResult) pendingResultList.get(i);
            this.JC[i] = pendingResult;
            pendingResult.mo905a(new C07991(this));
        }
    }

    /* renamed from: c */
    public /* synthetic */ Result mo2958c(Status status) {
        return createFailedResult(status);
    }

    public void cancel() {
        super.cancel();
        for (PendingResult cancel : this.JC) {
            cancel.cancel();
        }
    }

    public BatchResult createFailedResult(Status status) {
        return new BatchResult(status, this.JC);
    }
}
