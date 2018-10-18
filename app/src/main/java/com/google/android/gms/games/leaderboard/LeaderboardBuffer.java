package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.C1307g;
import com.google.android.gms.common.data.DataHolder;

public final class LeaderboardBuffer extends C1307g<Leaderboard> {
    public LeaderboardBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* renamed from: f */
    protected /* synthetic */ Object mo3686f(int i, int i2) {
        return m4892j(i, i2);
    }

    protected String ha() {
        return "external_leaderboard_id";
    }

    /* renamed from: j */
    protected Leaderboard m4892j(int i, int i2) {
        return new LeaderboardRef(this.JG, i, i2);
    }
}
