package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TimeSpan;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.C0483a;
import com.google.android.gms.internal.jx;
import java.util.HashMap;

public final class ScoreSubmissionData {
    private static final String[] adl = new String[]{"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"};
    private int Iv;
    private String Xh;
    private HashMap<Integer, Result> adR = new HashMap();
    private String adn;

    public static final class Result {
        public final String formattedScore;
        public final boolean newBest;
        public final long rawScore;
        public final String scoreTag;

        public Result(long rawScore, String formattedScore, String scoreTag, boolean newBest) {
            this.rawScore = rawScore;
            this.formattedScore = formattedScore;
            this.scoreTag = scoreTag;
            this.newBest = newBest;
        }

        public String toString() {
            return jv.m1571h(this).m1570a("RawScore", Long.valueOf(this.rawScore)).m1570a("FormattedScore", this.formattedScore).m1570a("ScoreTag", this.scoreTag).m1570a("NewBest", Boolean.valueOf(this.newBest)).toString();
        }
    }

    public ScoreSubmissionData(DataHolder dataHolder) {
        this.Iv = dataHolder.getStatusCode();
        int count = dataHolder.getCount();
        jx.m1575L(count == 3);
        for (int i = 0; i < count; i++) {
            int au = dataHolder.au(i);
            if (i == 0) {
                this.adn = dataHolder.m2493c("leaderboardId", i, au);
                this.Xh = dataHolder.m2493c("playerId", i, au);
            }
            if (dataHolder.m2494d("hasResult", i, au)) {
                m955a(new Result(dataHolder.m2490a("rawScore", i, au), dataHolder.m2493c("formattedScore", i, au), dataHolder.m2493c("scoreTag", i, au), dataHolder.m2494d("newBest", i, au)), dataHolder.m2492b("timeSpan", i, au));
            }
        }
    }

    /* renamed from: a */
    private void m955a(Result result, int i) {
        this.adR.put(Integer.valueOf(i), result);
    }

    public String getLeaderboardId() {
        return this.adn;
    }

    public String getPlayerId() {
        return this.Xh;
    }

    public Result getScoreResult(int timeSpan) {
        return (Result) this.adR.get(Integer.valueOf(timeSpan));
    }

    public String toString() {
        C0483a a = jv.m1571h(this).m1570a("PlayerId", this.Xh).m1570a("StatusCode", Integer.valueOf(this.Iv));
        for (int i = 0; i < 3; i++) {
            Result result = (Result) this.adR.get(Integer.valueOf(i));
            a.m1570a("TimesSpan", TimeSpan.dZ(i));
            a.m1570a("Result", result == null ? "null" : result.toString());
        }
        return a.toString();
    }
}
