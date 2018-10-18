package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.je;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.C0483a;
import com.google.android.gms.internal.le;

public final class AchievementEntity implements SafeParcelable, Achievement {
    public static final AchievementEntityCreator CREATOR = new AchievementEntityCreator();
    private final int CK;
    private final int Gt;
    private final String UO;
    private final Uri XA;
    private final String XB;
    private final int XC;
    private final String XD;
    private final PlayerEntity XE;
    private final int XF;
    private final String XG;
    private final long XH;
    private final long XI;
    private final String Xx;
    private final Uri Xy;
    private final String Xz;
    private final String mName;
    private final int mState;

    AchievementEntity(int versionCode, String achievementId, int type, String name, String description, Uri unlockedImageUri, String unlockedImageUrl, Uri revealedImageUri, String revealedImageUrl, int totalSteps, String formattedTotalSteps, PlayerEntity player, int state, int currentSteps, String formattedCurrentSteps, long lastUpdatedTimestamp, long xpValue) {
        this.CK = versionCode;
        this.Xx = achievementId;
        this.Gt = type;
        this.mName = name;
        this.UO = description;
        this.Xy = unlockedImageUri;
        this.Xz = unlockedImageUrl;
        this.XA = revealedImageUri;
        this.XB = revealedImageUrl;
        this.XC = totalSteps;
        this.XD = formattedTotalSteps;
        this.XE = player;
        this.mState = state;
        this.XF = currentSteps;
        this.XG = formattedCurrentSteps;
        this.XH = lastUpdatedTimestamp;
        this.XI = xpValue;
    }

    public AchievementEntity(Achievement achievement) {
        this.CK = 1;
        this.Xx = achievement.getAchievementId();
        this.Gt = achievement.getType();
        this.mName = achievement.getName();
        this.UO = achievement.getDescription();
        this.Xy = achievement.getUnlockedImageUri();
        this.Xz = achievement.getUnlockedImageUrl();
        this.XA = achievement.getRevealedImageUri();
        this.XB = achievement.getRevealedImageUrl();
        this.XE = (PlayerEntity) achievement.getPlayer().freeze();
        this.mState = achievement.getState();
        this.XH = achievement.getLastUpdatedTimestamp();
        this.XI = achievement.getXpValue();
        if (achievement.getType() == 1) {
            this.XC = achievement.getTotalSteps();
            this.XD = achievement.getFormattedTotalSteps();
            this.XF = achievement.getCurrentSteps();
            this.XG = achievement.getFormattedCurrentSteps();
        } else {
            this.XC = 0;
            this.XD = null;
            this.XF = 0;
            this.XG = null;
        }
        je.m1497f(this.Xx);
        je.m1497f(this.UO);
    }

    /* renamed from: a */
    static int m4021a(Achievement achievement) {
        int currentSteps;
        int totalSteps;
        if (achievement.getType() == 1) {
            currentSteps = achievement.getCurrentSteps();
            totalSteps = achievement.getTotalSteps();
        } else {
            totalSteps = 0;
            currentSteps = 0;
        }
        return jv.hashCode(achievement.getAchievementId(), achievement.getName(), Integer.valueOf(achievement.getType()), achievement.getDescription(), Long.valueOf(achievement.getXpValue()), Integer.valueOf(achievement.getState()), Long.valueOf(achievement.getLastUpdatedTimestamp()), achievement.getPlayer(), Integer.valueOf(currentSteps), Integer.valueOf(totalSteps));
    }

    /* renamed from: a */
    static boolean m4022a(Achievement achievement, Object obj) {
        if (!(obj instanceof Achievement)) {
            return false;
        }
        if (achievement == obj) {
            return true;
        }
        boolean equal;
        boolean equal2;
        Achievement achievement2 = (Achievement) obj;
        if (achievement.getType() == 1) {
            equal = jv.equal(Integer.valueOf(achievement2.getCurrentSteps()), Integer.valueOf(achievement.getCurrentSteps()));
            equal2 = jv.equal(Integer.valueOf(achievement2.getTotalSteps()), Integer.valueOf(achievement.getTotalSteps()));
        } else {
            equal2 = true;
            equal = true;
        }
        return jv.equal(achievement2.getAchievementId(), achievement.getAchievementId()) && jv.equal(achievement2.getName(), achievement.getName()) && jv.equal(Integer.valueOf(achievement2.getType()), Integer.valueOf(achievement.getType())) && jv.equal(achievement2.getDescription(), achievement.getDescription()) && jv.equal(Long.valueOf(achievement2.getXpValue()), Long.valueOf(achievement.getXpValue())) && jv.equal(Integer.valueOf(achievement2.getState()), Integer.valueOf(achievement.getState())) && jv.equal(Long.valueOf(achievement2.getLastUpdatedTimestamp()), Long.valueOf(achievement.getLastUpdatedTimestamp())) && jv.equal(achievement2.getPlayer(), achievement.getPlayer()) && equal && equal2;
    }

    /* renamed from: b */
    static String m4023b(Achievement achievement) {
        C0483a a = jv.m1571h(achievement).m1570a("Id", achievement.getAchievementId()).m1570a("Type", Integer.valueOf(achievement.getType())).m1570a("Name", achievement.getName()).m1570a("Description", achievement.getDescription()).m1570a("Player", achievement.getPlayer()).m1570a("State", Integer.valueOf(achievement.getState()));
        if (achievement.getType() == 1) {
            a.m1570a("CurrentSteps", Integer.valueOf(achievement.getCurrentSteps()));
            a.m1570a("TotalSteps", Integer.valueOf(achievement.getTotalSteps()));
        }
        return a.toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m4022a(this, obj);
    }

    public Achievement freeze() {
        return this;
    }

    public String getAchievementId() {
        return this.Xx;
    }

    public int getCurrentSteps() {
        return this.XF;
    }

    public String getDescription() {
        return this.UO;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        le.m1637b(this.UO, dataOut);
    }

    public String getFormattedCurrentSteps() {
        return this.XG;
    }

    public void getFormattedCurrentSteps(CharArrayBuffer dataOut) {
        le.m1637b(this.XG, dataOut);
    }

    public String getFormattedTotalSteps() {
        return this.XD;
    }

    public void getFormattedTotalSteps(CharArrayBuffer dataOut) {
        le.m1637b(this.XD, dataOut);
    }

    public long getLastUpdatedTimestamp() {
        return this.XH;
    }

    public String getName() {
        return this.mName;
    }

    public void getName(CharArrayBuffer dataOut) {
        le.m1637b(this.mName, dataOut);
    }

    public Player getPlayer() {
        return this.XE;
    }

    public Uri getRevealedImageUri() {
        return this.XA;
    }

    public String getRevealedImageUrl() {
        return this.XB;
    }

    public int getState() {
        return this.mState;
    }

    public int getTotalSteps() {
        return this.XC;
    }

    public int getType() {
        return this.Gt;
    }

    public Uri getUnlockedImageUri() {
        return this.Xy;
    }

    public String getUnlockedImageUrl() {
        return this.Xz;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public long getXpValue() {
        return this.XI;
    }

    public int hashCode() {
        return m4021a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m4023b(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        AchievementEntityCreator.m665a(this, dest, flags);
    }
}
