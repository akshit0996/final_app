package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.internal.ae.C1265a;

public class bb extends C1265a {
    private final IntentFilter[] axD;
    private DataListener ayl;
    private MessageListener aym;
    private NodeListener ayn;

    private bb(DataListener dataListener, MessageListener messageListener, NodeListener nodeListener, IntentFilter[] intentFilterArr) {
        this.ayl = dataListener;
        this.aym = messageListener;
        this.ayn = nodeListener;
        this.axD = intentFilterArr;
    }

    /* renamed from: a */
    public static bb m4742a(NodeListener nodeListener) {
        return new bb(null, null, nodeListener, null);
    }

    /* renamed from: b */
    public static bb m4743b(DataListener dataListener, IntentFilter[] intentFilterArr) {
        return new bb(dataListener, null, null, intentFilterArr);
    }

    /* renamed from: b */
    public static bb m4744b(MessageListener messageListener, IntentFilter[] intentFilterArr) {
        return new bb(null, messageListener, null, intentFilterArr);
    }

    /* renamed from: a */
    public void mo2610a(ai aiVar) {
        if (this.aym != null) {
            this.aym.onMessageReceived(aiVar);
        }
    }

    /* renamed from: a */
    public void mo2611a(al alVar) {
        if (this.ayn != null) {
            this.ayn.onPeerConnected(alVar);
        }
    }

    public void aa(DataHolder dataHolder) {
        if (this.ayl != null) {
            try {
                this.ayl.onDataChanged(new DataEventBuffer(dataHolder));
            } finally {
                dataHolder.close();
            }
        } else {
            dataHolder.close();
        }
    }

    /* renamed from: b */
    public void mo2613b(al alVar) {
        if (this.ayn != null) {
            this.ayn.onPeerDisconnected(alVar);
        }
    }

    public void clear() {
        this.ayl = null;
        this.aym = null;
        this.ayn = null;
    }

    public IntentFilter[] rs() {
        return this.axD;
    }
}
