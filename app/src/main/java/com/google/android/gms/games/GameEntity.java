package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.ji;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.le;

public final class GameEntity extends GamesDowngradeableSafeParcel implements Game {
    public static final Creator<GameEntity> CREATOR = new GameEntityCreatorCompat();
    private final int CK;
    private final String Fo;
    private final String OS;
    private final String UO;
    private final String WA;
    private final String WB;
    private final String WC;
    private final Uri WD;
    private final Uri WE;
    private final Uri WF;
    private final boolean WG;
    private final boolean WH;
    private final String WI;
    private final int WJ;
    private final int WK;
    private final int WL;
    private final boolean WM;
    private final boolean WN;
    private final String WO;
    private final String WP;
    private final String WQ;
    private final boolean WR;
    private final boolean WS;
    private final boolean WT;
    private final String WU;

    static final class GameEntityCreatorCompat extends GameEntityCreator {
        GameEntityCreatorCompat() {
        }

        public GameEntity cl(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.m4233c(ji.ht()) || ji.aW(GameEntity.class.getCanonicalName())) {
                return super.cl(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            Uri parse = readString7 == null ? null : Uri.parse(readString7);
            readString7 = parcel.readString();
            Uri parse2 = readString7 == null ? null : Uri.parse(readString7);
            readString7 = parcel.readString();
            return new GameEntity(5, readString, readString2, readString3, readString4, readString5, readString6, parse, parse2, readString7 == null ? null : Uri.parse(readString7), parcel.readInt() > 0, parcel.readInt() > 0, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), false, false, null, null, null, false, false, false, null);
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return cl(x0);
        }
    }

    GameEntity(int versionCode, String applicationId, String displayName, String primaryCategory, String secondaryCategory, String description, String developerName, Uri iconImageUri, Uri hiResImageUri, Uri featuredImageUri, boolean playEnabledGame, boolean instanceInstalled, String instancePackageName, int gameplayAclStatus, int achievementTotalCount, int leaderboardCount, boolean realTimeEnabled, boolean turnBasedEnabled, String iconImageUrl, String hiResImageUrl, String featuredImageUrl, boolean muted, boolean identitySharingConfirmed, boolean snapshotsEnabled, String themeColor) {
        this.CK = versionCode;
        this.Fo = applicationId;
        this.OS = displayName;
        this.WA = primaryCategory;
        this.WB = secondaryCategory;
        this.UO = description;
        this.WC = developerName;
        this.WD = iconImageUri;
        this.WO = iconImageUrl;
        this.WE = hiResImageUri;
        this.WP = hiResImageUrl;
        this.WF = featuredImageUri;
        this.WQ = featuredImageUrl;
        this.WG = playEnabledGame;
        this.WH = instanceInstalled;
        this.WI = instancePackageName;
        this.WJ = gameplayAclStatus;
        this.WK = achievementTotalCount;
        this.WL = leaderboardCount;
        this.WM = realTimeEnabled;
        this.WN = turnBasedEnabled;
        this.WR = muted;
        this.WS = identitySharingConfirmed;
        this.WT = snapshotsEnabled;
        this.WU = themeColor;
    }

    public GameEntity(Game game) {
        this.CK = 5;
        this.Fo = game.getApplicationId();
        this.WA = game.getPrimaryCategory();
        this.WB = game.getSecondaryCategory();
        this.UO = game.getDescription();
        this.WC = game.getDeveloperName();
        this.OS = game.getDisplayName();
        this.WD = game.getIconImageUri();
        this.WO = game.getIconImageUrl();
        this.WE = game.getHiResImageUri();
        this.WP = game.getHiResImageUrl();
        this.WF = game.getFeaturedImageUri();
        this.WQ = game.getFeaturedImageUrl();
        this.WG = game.ky();
        this.WH = game.kA();
        this.WI = game.kB();
        this.WJ = game.kC();
        this.WK = game.getAchievementTotalCount();
        this.WL = game.getLeaderboardCount();
        this.WM = game.isRealTimeMultiplayerEnabled();
        this.WN = game.isTurnBasedMultiplayerEnabled();
        this.WR = game.isMuted();
        this.WS = game.kz();
        this.WT = game.areSnapshotsEnabled();
        this.WU = game.getThemeColor();
    }

    /* renamed from: a */
    static int m4801a(Game game) {
        return jv.hashCode(game.getApplicationId(), game.getDisplayName(), game.getPrimaryCategory(), game.getSecondaryCategory(), game.getDescription(), game.getDeveloperName(), game.getIconImageUri(), game.getHiResImageUri(), game.getFeaturedImageUri(), Boolean.valueOf(game.ky()), Boolean.valueOf(game.kA()), game.kB(), Integer.valueOf(game.kC()), Integer.valueOf(game.getAchievementTotalCount()), Integer.valueOf(game.getLeaderboardCount()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(game.isMuted()), Boolean.valueOf(game.kz()), Boolean.valueOf(game.areSnapshotsEnabled()), game.getThemeColor());
    }

    /* renamed from: a */
    static boolean m4802a(Game game, Object obj) {
        if (!(obj instanceof Game)) {
            return false;
        }
        if (game == obj) {
            return true;
        }
        Game game2 = (Game) obj;
        if (jv.equal(game2.getApplicationId(), game.getApplicationId()) && jv.equal(game2.getDisplayName(), game.getDisplayName()) && jv.equal(game2.getPrimaryCategory(), game.getPrimaryCategory()) && jv.equal(game2.getSecondaryCategory(), game.getSecondaryCategory()) && jv.equal(game2.getDescription(), game.getDescription()) && jv.equal(game2.getDeveloperName(), game.getDeveloperName()) && jv.equal(game2.getIconImageUri(), game.getIconImageUri()) && jv.equal(game2.getHiResImageUri(), game.getHiResImageUri()) && jv.equal(game2.getFeaturedImageUri(), game.getFeaturedImageUri()) && jv.equal(Boolean.valueOf(game2.ky()), Boolean.valueOf(game.ky())) && jv.equal(Boolean.valueOf(game2.kA()), Boolean.valueOf(game.kA())) && jv.equal(game2.kB(), game.kB()) && jv.equal(Integer.valueOf(game2.kC()), Integer.valueOf(game.kC())) && jv.equal(Integer.valueOf(game2.getAchievementTotalCount()), Integer.valueOf(game.getAchievementTotalCount())) && jv.equal(Integer.valueOf(game2.getLeaderboardCount()), Integer.valueOf(game.getLeaderboardCount())) && jv.equal(Boolean.valueOf(game2.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled()))) {
            Boolean valueOf = Boolean.valueOf(game2.isTurnBasedMultiplayerEnabled());
            boolean z = game.isTurnBasedMultiplayerEnabled() && jv.equal(Boolean.valueOf(game2.isMuted()), Boolean.valueOf(game.isMuted())) && jv.equal(Boolean.valueOf(game2.kz()), Boolean.valueOf(game.kz()));
            if (jv.equal(valueOf, Boolean.valueOf(z)) && jv.equal(Boolean.valueOf(game2.areSnapshotsEnabled()), Boolean.valueOf(game.areSnapshotsEnabled())) && jv.equal(game2.getThemeColor(), game.getThemeColor())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    static String m4803b(Game game) {
        return jv.m1571h(game).m1570a("ApplicationId", game.getApplicationId()).m1570a("DisplayName", game.getDisplayName()).m1570a("PrimaryCategory", game.getPrimaryCategory()).m1570a("SecondaryCategory", game.getSecondaryCategory()).m1570a("Description", game.getDescription()).m1570a("DeveloperName", game.getDeveloperName()).m1570a("IconImageUri", game.getIconImageUri()).m1570a("IconImageUrl", game.getIconImageUrl()).m1570a("HiResImageUri", game.getHiResImageUri()).m1570a("HiResImageUrl", game.getHiResImageUrl()).m1570a("FeaturedImageUri", game.getFeaturedImageUri()).m1570a("FeaturedImageUrl", game.getFeaturedImageUrl()).m1570a("PlayEnabledGame", Boolean.valueOf(game.ky())).m1570a("InstanceInstalled", Boolean.valueOf(game.kA())).m1570a("InstancePackageName", game.kB()).m1570a("AchievementTotalCount", Integer.valueOf(game.getAchievementTotalCount())).m1570a("LeaderboardCount", Integer.valueOf(game.getLeaderboardCount())).m1570a("RealTimeMultiplayerEnabled", Boolean.valueOf(game.isRealTimeMultiplayerEnabled())).m1570a("TurnBasedMultiplayerEnabled", Boolean.valueOf(game.isTurnBasedMultiplayerEnabled())).m1570a("AreSnapshotsEnabled", Boolean.valueOf(game.areSnapshotsEnabled())).m1570a("ThemeColor", game.getThemeColor()).toString();
    }

    public boolean areSnapshotsEnabled() {
        return this.WT;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m4802a(this, obj);
    }

    public Game freeze() {
        return this;
    }

    public int getAchievementTotalCount() {
        return this.WK;
    }

    public String getApplicationId() {
        return this.Fo;
    }

    public String getDescription() {
        return this.UO;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        le.m1637b(this.UO, dataOut);
    }

    public String getDeveloperName() {
        return this.WC;
    }

    public void getDeveloperName(CharArrayBuffer dataOut) {
        le.m1637b(this.WC, dataOut);
    }

    public String getDisplayName() {
        return this.OS;
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        le.m1637b(this.OS, dataOut);
    }

    public Uri getFeaturedImageUri() {
        return this.WF;
    }

    public String getFeaturedImageUrl() {
        return this.WQ;
    }

    public Uri getHiResImageUri() {
        return this.WE;
    }

    public String getHiResImageUrl() {
        return this.WP;
    }

    public Uri getIconImageUri() {
        return this.WD;
    }

    public String getIconImageUrl() {
        return this.WO;
    }

    public int getLeaderboardCount() {
        return this.WL;
    }

    public String getPrimaryCategory() {
        return this.WA;
    }

    public String getSecondaryCategory() {
        return this.WB;
    }

    public String getThemeColor() {
        return this.WU;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return m4801a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isMuted() {
        return this.WR;
    }

    public boolean isRealTimeMultiplayerEnabled() {
        return this.WM;
    }

    public boolean isTurnBasedMultiplayerEnabled() {
        return this.WN;
    }

    public boolean kA() {
        return this.WH;
    }

    public String kB() {
        return this.WI;
    }

    public int kC() {
        return this.WJ;
    }

    public boolean ky() {
        return this.WG;
    }

    public boolean kz() {
        return this.WS;
    }

    public String toString() {
        return m4803b((Game) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        int i = 1;
        String str = null;
        if (hu()) {
            dest.writeString(this.Fo);
            dest.writeString(this.OS);
            dest.writeString(this.WA);
            dest.writeString(this.WB);
            dest.writeString(this.UO);
            dest.writeString(this.WC);
            dest.writeString(this.WD == null ? null : this.WD.toString());
            dest.writeString(this.WE == null ? null : this.WE.toString());
            if (this.WF != null) {
                str = this.WF.toString();
            }
            dest.writeString(str);
            dest.writeInt(this.WG ? 1 : 0);
            if (!this.WH) {
                i = 0;
            }
            dest.writeInt(i);
            dest.writeString(this.WI);
            dest.writeInt(this.WJ);
            dest.writeInt(this.WK);
            dest.writeInt(this.WL);
            return;
        }
        GameEntityCreator.m658a(this, dest, flags);
    }
}
