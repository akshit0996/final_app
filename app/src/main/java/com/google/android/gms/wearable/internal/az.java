package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.google.android.gms.wearable.internal.C1273f.C1482b;
import com.google.android.gms.wearable.internal.C1273f.C1483c;
import com.google.android.gms.wearable.internal.C1273f.C1484d;
import com.google.android.gms.wearable.internal.ah.C1479b;
import com.google.android.gms.wearable.internal.ak.C1480b;
import com.google.android.gms.wearable.internal.ak.C1481c;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.FutureTask;

final class az {

    /* renamed from: com.google.android.gms.wearable.internal.az$a */
    static abstract class C1538a<T> extends C1478a {
        private C0155b<T> DA;

        public C1538a(C0155b<T> c0155b) {
            this.DA = c0155b;
        }

        /* renamed from: A */
        public void m4977A(T t) {
            C0155b c0155b = this.DA;
            if (c0155b != null) {
                c0155b.mo908b(t);
                this.DA = null;
            }
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.az$h */
    static final class C1539h extends C1478a {
        C1539h() {
        }

        /* renamed from: a */
        public void mo2598a(Status status) {
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.az$b */
    static final class C1599b extends C1538a<DeleteDataItemsResult> {
        public C1599b(C0155b<DeleteDataItemsResult> c0155b) {
            super(c0155b);
        }

        /* renamed from: a */
        public void mo2603a(C1274p c1274p) {
            m4977A(new C1483c(av.gN(c1274p.statusCode), c1274p.axI));
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.az$c */
    static final class C1600c extends C1538a<GetConnectedNodesResult> {
        public C1600c(C0155b<GetConnectedNodesResult> c0155b) {
            super(c0155b);
        }

        /* renamed from: a */
        public void mo2606a(C1277v c1277v) {
            List arrayList = new ArrayList();
            arrayList.addAll(c1277v.axL);
            m4977A(new C1480b(av.gN(c1277v.statusCode), arrayList));
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.az$d */
    static final class C1601d extends C1538a<DataItemResult> {
        public C1601d(C0155b<DataItemResult> c0155b) {
            super(c0155b);
        }

        /* renamed from: a */
        public void mo2607a(C1278x c1278x) {
            m4977A(new C1482b(av.gN(c1278x.statusCode), c1278x.axM));
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.az$e */
    static final class C1602e extends C1538a<DataItemBuffer> {
        public C1602e(C0155b<DataItemBuffer> c0155b) {
            super(c0155b);
        }

        public void ab(DataHolder dataHolder) {
            m4977A(new DataItemBuffer(dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.az$f */
    static final class C1603f extends C1538a<GetFdForAssetResult> {
        public C1603f(C0155b<GetFdForAssetResult> c0155b) {
            super(c0155b);
        }

        /* renamed from: a */
        public void mo2608a(C1279z c1279z) {
            m4977A(new C1484d(av.gN(c1279z.statusCode), c1279z.axN));
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.az$g */
    static final class C1604g extends C1538a<GetLocalNodeResult> {
        public C1604g(C0155b<GetLocalNodeResult> c0155b) {
            super(c0155b);
        }

        /* renamed from: a */
        public void mo2599a(ab abVar) {
            m4977A(new C1481c(av.gN(abVar.statusCode), abVar.axO));
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.az$i */
    static final class C1605i extends C1538a<DataItemResult> {
        private final List<FutureTask<Boolean>> ayf;

        C1605i(C0155b<DataItemResult> c0155b, List<FutureTask<Boolean>> list) {
            super(c0155b);
            this.ayf = list;
        }

        /* renamed from: a */
        public void mo2600a(ap apVar) {
            m4977A(new C1482b(av.gN(apVar.statusCode), apVar.axM));
            if (apVar.statusCode != 0) {
                for (FutureTask cancel : this.ayf) {
                    cancel.cancel(true);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.az$j */
    static final class C1606j extends C1538a<SendMessageResult> {
        public C1606j(C0155b<SendMessageResult> c0155b) {
            super(c0155b);
        }

        /* renamed from: a */
        public void mo2601a(at atVar) {
            m4977A(new C1479b(av.gN(atVar.statusCode), atVar.ayd));
        }
    }
}
