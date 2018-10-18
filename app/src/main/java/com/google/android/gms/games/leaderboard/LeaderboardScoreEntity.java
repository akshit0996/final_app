package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.le;

public final class LeaderboardScoreEntity implements LeaderboardScore {
    private final PlayerEntity adA;
    private final String adB;
    private final String adC;
    private final String adD;
    private final long ads;
    private final String adt;
    private final String adu;
    private final long adv;
    private final long adw;
    private final String adx;
    private final Uri ady;
    private final Uri adz;

    public LeaderboardScoreEntity(LeaderboardScore score) {
        this.ads = score.getRank();
        this.adt = (String) jx.m1582i(score.getDisplayRank());
        this.adu = (String) jx.m1582i(score.getDisplayScore());
        this.adv = score.getRawScore();
        this.adw = score.getTimestampMillis();
        this.adx = score.getScoreHolderDisplayName();
        this.ady = score.getScoreHolderIconImageUri();
        this.adz = score.getScoreHolderHiResImageUri();
        Player scoreHolder = score.getScoreHolder();
        this.adA = scoreHolder == null ? null : (PlayerEntity) scoreHolder.freeze();
        this.adB = score.getScoreTag();
        this.adC = score.getScoreHolderIconImageUrl();
        this.adD = score.getScoreHolderHiResImageUrl();
    }

    /* renamed from: a */
    static int m4240a(LeaderboardScore leaderboardScore) {
        return jv.hashCode(Long.valueOf(leaderboardScore.getRank()), leaderboardScore.getDisplayRank(), Long.valueOf(leaderboardScore.getRawScore()), leaderboardScore.getDisplayScore(), Long.valueOf(leaderboardScore.getTimestampMillis()), leaderboardScore.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolder());
    }

    /* renamed from: a */
    static boolean m4241a(LeaderboardScore leaderboardScore, Object obj) {
        if (!(obj instanceof LeaderboardScore)) {
            return false;
        }
        if (leaderboardScore == obj) {
            return true;
        }
        LeaderboardScore leaderboardScore2 = (LeaderboardScore) obj;
        return jv.equal(Long.valueOf(leaderboardScore2.getRank()), Long.valueOf(leaderboardScore.getRank())) && jv.equal(leaderboardScore2.getDisplayRank(), leaderboardScore.getDisplayRank()) && jv.equal(Long.valueOf(leaderboardScore2.getRawScore()), Long.valueOf(leaderboardScore.getRawScore())) && jv.equal(leaderboardScore2.getDisplayScore(), leaderboardScore.getDisplayScore()) && jv.equal(Long.valueOf(leaderboardScore2.getTimestampMillis()), Long.valueOf(leaderboardScore.getTimestampMillis())) && jv.equal(leaderboardScore2.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderDisplayName()) && jv.equal(leaderboardScore2.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderIconImageUri()) && jv.equal(leaderboardScore2.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolderHiResImageUri()) && jv.equal(leaderboardScore2.getScoreHolder(), leaderboardScore.getScoreHolder()) && jv.equal(leaderboardScore2.getScoreTag(), leaderboardScore.getScoreTag());
    }

    /* renamed from: b */
    static String m4242b(LeaderboardScore leaderboardScore) {
        return jv.m1571h(leaderboardScore).m1570a("Rank", Long.valueOf(leaderboardScore.getRank())).m1570a("DisplayRank", leaderboardScore.getDisplayRank()).m1570a("Score", Long.valueOf(leaderboardScore.getRawScore())).m1570a("DisplayScore", leaderboardScore.getDisplayScore()).m1570a("Timestamp", Long.valueOf(leaderboardScore.getTimestampMillis())).m1570a("DisplayName", leaderboardScore.getScoreHolderDisplayName()).m1570a("IconImageUri", leaderboardScore.getScoreHolderIconImageUri()).m1570a("IconImageUrl", leaderboardScore.getScoreHolderIconImageUrl()).m1570a("HiResImageUri", leaderboardScore.getScoreHolderHiResImageUri()).m1570a("HiResImageUrl", leaderboardScore.getScoreHolderHiResImageUrl()).m1570a("Player", leaderboardScore.getScoreHolder() == null ? null : leaderboardScore.getScoreHolder()).m1570a("ScoreTag", leaderboardScore.getScoreTag()).toString();
    }

    public boolean equals(Object obj) {
        return m4241a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return mJ();
    }

    public String getDisplayRank() {
        return this.adt;
    }

    public void getDisplayRank(CharArrayBuffer dataOut) {
        le.m1637b(this.adt, dataOut);
    }

    public String getDisplayScore() {
        return this.adu;
    }

    public void getDisplayScore(CharArrayBuffer dataOut) {
        le.m1637b(this.adu, dataOut);
    }

    public long getRank() {
        return this.ads;
    }

    public long getRawScore() {
        return this.adv;
    }

    public Player getScoreHolder() {
        return this.adA;
    }

    public String getScoreHolderDisplayName() {
        return this.adA == null ? this.adx : this.adA.getDisplayName();
    }

    public void getScoreHolderDisplayName(CharArrayBuffer dataOut) {
        if (this.adA == null) {
            le.m1637b(this.adx, dataOut);
        } else {
            this.adA.getDisplayName(dataOut);
        }
    }

    public Uri getScoreHolderHiResImageUri() {
        return this.adA == null ? this.adz : this.adA.getHiResImageUri();
    }

    public String getScoreHolderHiResImageUrl() {
        return this.adA == null ? this.adD : this.adA.getHiResImageUrl();
    }

    public Uri getScoreHolderIconImageUri() {
        return this.adA == null ? this.ady : this.adA.getIconImageUri();
    }

    public String getScoreHolderIconImageUrl() {
        return this.adA == null ? this.adC : this.adA.getIconImageUrl();
    }

    public String getScoreTag() {
        return this.adB;
    }

    public long getTimestampMillis() {
        return this.adw;
    }

    public int hashCode() {
        return m4240a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public LeaderboardScore mJ() {
        return this;
    }

    public String toString() {
        return m4242b(this);
    }
}
