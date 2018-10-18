package com.google.android.gms.games.multiplayer.turnbased;

import com.google.android.gms.common.data.C1307g;
import com.google.android.gms.common.data.DataHolder;

public final class TurnBasedMatchBuffer extends C1307g<TurnBasedMatch> {
    public TurnBasedMatchBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* renamed from: f */
    protected /* synthetic */ Object mo3686f(int i, int i2) {
        return m4914m(i, i2);
    }

    protected String ha() {
        return "external_match_id";
    }

    /* renamed from: m */
    protected TurnBasedMatch m4914m(int i, int i2) {
        return new TurnBasedMatchRef(this.JG, i, i2);
    }
}
