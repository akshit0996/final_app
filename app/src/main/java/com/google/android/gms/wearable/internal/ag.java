package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.internal.af.C1267a;
import com.google.android.gms.wearable.internal.az.C1538a;
import com.google.android.gms.wearable.internal.az.C1539h;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

abstract class ag<T> {
    private final HashMap<T, bb> agU = new HashMap();

    /* renamed from: com.google.android.gms.wearable.internal.ag$b */
    static final class C1268b extends ag<DataListener> {
        C1268b() {
        }

        /* renamed from: a */
        bb m3896a(DataListener dataListener, IntentFilter[] intentFilterArr) {
            return bb.m4743b(dataListener, intentFilterArr);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ag$c */
    static final class C1269c extends ag<MessageListener> {
        C1269c() {
        }

        /* renamed from: a */
        bb m3898a(MessageListener messageListener, IntentFilter[] intentFilterArr) {
            return bb.m4744b(messageListener, intentFilterArr);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ag$d */
    static final class C1270d extends ag<NodeListener> {
        C1270d() {
        }

        /* renamed from: a */
        bb m3900a(NodeListener nodeListener, IntentFilter[] intentFilterArr) {
            return bb.m4742a(nodeListener);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ag$a */
    private static class C1590a<T> extends C1538a<Status> {
        private WeakReference<Map<T, bb>> axP;
        private WeakReference<T> axQ;

        C1590a(Map<T, bb> map, T t, C0155b<Status> c0155b) {
            super(c0155b);
            this.axP = new WeakReference(map);
            this.axQ = new WeakReference(t);
        }

        /* renamed from: a */
        public void mo2598a(Status status) {
            Map map = (Map) this.axP.get();
            Object obj = this.axQ.get();
            if (!(status.getStatus().isSuccess() || map == null || obj == null)) {
                synchronized (map) {
                    bb bbVar = (bb) map.remove(obj);
                    if (bbVar != null) {
                        bbVar.clear();
                    }
                }
            }
            m4977A(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ag$e */
    private static class C1591e<T> extends C1538a<Status> {
        private WeakReference<Map<T, bb>> axP;
        private WeakReference<T> axQ;

        C1591e(Map<T, bb> map, T t, C0155b<Status> c0155b) {
            super(c0155b);
            this.axP = new WeakReference(map);
            this.axQ = new WeakReference(t);
        }

        /* renamed from: a */
        public void mo2598a(Status status) {
            Map map = (Map) this.axP.get();
            Object obj = this.axQ.get();
            if (!(status.getStatus().getStatusCode() != 4002 || map == null || obj == null)) {
                synchronized (map) {
                    bb bbVar = (bb) map.remove(obj);
                    if (bbVar != null) {
                        bbVar.clear();
                    }
                }
            }
            m4977A(status);
        }
    }

    ag() {
    }

    /* renamed from: a */
    abstract bb mo2638a(T t, IntentFilter[] intentFilterArr);

    /* renamed from: a */
    public void m2317a(ba baVar, C0155b<Status> c0155b, T t) throws RemoteException {
        synchronized (this.agU) {
            bb bbVar = (bb) this.agU.remove(t);
            if (bbVar == null) {
                c0155b.mo908b(new Status(4002));
                return;
            }
            bbVar.clear();
            ((af) baVar.hw()).mo2619a(new C1591e(this.agU, t, c0155b), new ar(bbVar));
        }
    }

    /* renamed from: a */
    public void m2318a(ba baVar, C0155b<Status> c0155b, T t, IntentFilter[] intentFilterArr) throws RemoteException {
        bb a = mo2638a(t, intentFilterArr);
        synchronized (this.agU) {
            if (this.agU.get(t) != null) {
                c0155b.mo908b(new Status(4001));
                return;
            }
            this.agU.put(t, a);
            try {
                ((af) baVar.hw()).mo2620a(new C1590a(this.agU, t, c0155b), new C1271b(a));
            } catch (RemoteException e) {
                this.agU.remove(t);
                throw e;
            }
        }
    }

    /* renamed from: b */
    public void m2319b(ba baVar) {
        synchronized (this.agU) {
            ad c1539h = new C1539h();
            for (Entry entry : this.agU.entrySet()) {
                bb bbVar = (bb) entry.getValue();
                if (bbVar != null) {
                    bbVar.clear();
                    if (baVar.isConnected()) {
                        try {
                            ((af) baVar.hw()).mo2619a(c1539h, new ar(bbVar));
                            if (Log.isLoggable("WearableClient", 2)) {
                                Log.d("WearableClient", "disconnect: removed: " + entry.getKey() + "/" + bbVar);
                            }
                        } catch (RemoteException e) {
                            Log.w("WearableClient", "disconnect: Didn't remove: " + entry.getKey() + "/" + bbVar);
                        }
                    } else {
                        continue;
                    }
                }
            }
            this.agU.clear();
        }
    }

    public void ca(IBinder iBinder) {
        synchronized (this.agU) {
            af bZ = C1267a.bZ(iBinder);
            ad c1539h = new C1539h();
            for (Entry entry : this.agU.entrySet()) {
                bb bbVar = (bb) entry.getValue();
                try {
                    bZ.mo2620a(c1539h, new C1271b(bbVar));
                    if (Log.isLoggable("WearableClient", 2)) {
                        Log.d("WearableClient", "onPostInitHandler: added: " + entry.getKey() + "/" + bbVar);
                    }
                } catch (RemoteException e) {
                    Log.d("WearableClient", "onPostInitHandler: Didn't add: " + entry.getKey() + "/" + bbVar);
                }
            }
        }
    }
}
