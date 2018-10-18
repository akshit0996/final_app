package com.google.android.gms.games.request;

import com.google.android.gms.common.data.C1307g;
import com.google.android.gms.common.data.DataHolder;

public final class GameRequestBuffer extends C1307g<GameRequest> {
    public GameRequestBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* renamed from: f */
    protected /* synthetic */ Object mo3686f(int i, int i2) {
        return m4918o(i, i2);
    }

    protected String ha() {
        return "external_request_id";
    }

    /* renamed from: o */
    protected GameRequest m4918o(int i, int i2) {
        return new GameRequestRef(this.JG, i, i2);
    }
}
