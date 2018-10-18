package com.google.android.gms.fitness.data;

import android.os.RemoteException;
import com.google.android.gms.fitness.data.C0291k.C0875a;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.internal.jx;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.fitness.data.l */
public class C1334l extends C0875a {
    private final OnDataPointListener UF;

    /* renamed from: com.google.android.gms.fitness.data.l$a */
    public static class C0293a {
        private static final C0293a UG = new C0293a();
        private final Map<OnDataPointListener, C1334l> UH = new HashMap();

        private C0293a() {
        }

        public static C0293a jG() {
            return UG;
        }

        /* renamed from: a */
        public C1334l m548a(OnDataPointListener onDataPointListener) {
            C1334l c1334l;
            synchronized (this.UH) {
                c1334l = (C1334l) this.UH.get(onDataPointListener);
                if (c1334l == null) {
                    c1334l = new C1334l(onDataPointListener);
                    this.UH.put(onDataPointListener, c1334l);
                }
            }
            return c1334l;
        }

        /* renamed from: b */
        public C1334l m549b(OnDataPointListener onDataPointListener) {
            C1334l c1334l;
            synchronized (this.UH) {
                c1334l = (C1334l) this.UH.get(onDataPointListener);
            }
            return c1334l;
        }

        /* renamed from: c */
        public C1334l m550c(OnDataPointListener onDataPointListener) {
            C1334l c1334l;
            synchronized (this.UH) {
                c1334l = (C1334l) this.UH.remove(onDataPointListener);
                if (c1334l != null) {
                } else {
                    c1334l = new C1334l(onDataPointListener);
                }
            }
            return c1334l;
        }
    }

    private C1334l(OnDataPointListener onDataPointListener) {
        this.UF = (OnDataPointListener) jx.m1582i(onDataPointListener);
    }

    /* renamed from: c */
    public void mo1160c(DataPoint dataPoint) throws RemoteException {
        this.UF.onDataPoint(dataPoint);
    }
}
