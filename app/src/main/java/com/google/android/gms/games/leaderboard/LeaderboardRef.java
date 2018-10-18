package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.C0174d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;

public final class LeaderboardRef extends C0174d implements Leaderboard {
    private final int Ya;
    private final Game adq;

    LeaderboardRef(DataHolder holder, int dataRow, int numChildren) {
        super(holder, dataRow);
        this.Ya = numChildren;
        this.adq = new GameRef(holder, dataRow);
    }

    public boolean equals(Object obj) {
        return LeaderboardEntity.m4238a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return mG();
    }

    public String getDisplayName() {
        return getString("name");
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        m172a("name", dataOut);
    }

    public Game getGame() {
        return this.adq;
    }

    public Uri getIconImageUri() {
        return aR("board_icon_image_uri");
    }

    public String getIconImageUrl() {
        return getString("board_icon_image_url");
    }

    public String getLeaderboardId() {
        return getString("external_leaderboard_id");
    }

    public int getScoreOrder() {
        return getInteger("score_order");
    }

    public ArrayList<LeaderboardVariant> getVariants() {
        ArrayList<LeaderboardVariant> arrayList = new ArrayList(this.Ya);
        for (int i = 0; i < this.Ya; i++) {
            arrayList.add(new LeaderboardVariantRef(this.JG, this.KZ + i));
        }
        return arrayList;
    }

    public int hashCode() {
        return LeaderboardEntity.m4237a(this);
    }

    public Leaderboard mG() {
        return new LeaderboardEntity(this);
    }

    public String toString() {
        return LeaderboardEntity.m4239b(this);
    }
}
