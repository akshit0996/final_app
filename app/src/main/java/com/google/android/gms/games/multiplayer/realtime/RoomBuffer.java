package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.C1307g;
import com.google.android.gms.common.data.DataHolder;

public final class RoomBuffer extends C1307g<Room> {
    public RoomBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* renamed from: f */
    protected /* synthetic */ Object mo3686f(int i, int i2) {
        return m4904l(i, i2);
    }

    protected String ha() {
        return "external_match_id";
    }

    /* renamed from: l */
    protected Room m4904l(int i, int i2) {
        return new RoomRef(this.JG, i, i2);
    }
}
