package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.C1307g;
import com.google.android.gms.common.data.DataHolder;

public final class ExtendedGameBuffer extends C1307g<ExtendedGame> {
    public ExtendedGameBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* renamed from: f */
    protected /* synthetic */ Object mo3686f(int i, int i2) {
        return m4882i(i, i2);
    }

    protected String ha() {
        return "external_game_id";
    }

    /* renamed from: i */
    protected ExtendedGame m4882i(int i, int i2) {
        return new ExtendedGameRef(this.JG, i, i2);
    }
}
