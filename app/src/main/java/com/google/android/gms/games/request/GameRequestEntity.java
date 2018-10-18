package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GameRequestEntity implements SafeParcelable, GameRequest {
    public static final GameRequestEntityCreator CREATOR = new GameRequestEntityCreator();
    private final int CK;
    private final int FP;
    private final int Gt;
    private final String Zt;
    private final GameEntity acs;
    private final long adS;
    private final byte[] aeA;
    private final PlayerEntity aeU;
    private final ArrayList<PlayerEntity> aeV;
    private final long aeW;
    private final Bundle aeX;

    GameRequestEntity(int versionCode, GameEntity game, PlayerEntity sender, byte[] data, String requestId, ArrayList<PlayerEntity> recipients, int type, long creationTimestamp, long expirationTimestamp, Bundle recipientStatuses, int status) {
        this.CK = versionCode;
        this.acs = game;
        this.aeU = sender;
        this.aeA = data;
        this.Zt = requestId;
        this.aeV = recipients;
        this.Gt = type;
        this.adS = creationTimestamp;
        this.aeW = expirationTimestamp;
        this.aeX = recipientStatuses;
        this.FP = status;
    }

    public GameRequestEntity(GameRequest request) {
        this.CK = 2;
        this.acs = new GameEntity(request.getGame());
        this.aeU = new PlayerEntity(request.getSender());
        this.Zt = request.getRequestId();
        this.Gt = request.getType();
        this.adS = request.getCreationTimestamp();
        this.aeW = request.getExpirationTimestamp();
        this.FP = request.getStatus();
        Object data = request.getData();
        if (data == null) {
            this.aeA = null;
        } else {
            this.aeA = new byte[data.length];
            System.arraycopy(data, 0, this.aeA, 0, data.length);
        }
        List recipients = request.getRecipients();
        int size = recipients.size();
        this.aeV = new ArrayList(size);
        this.aeX = new Bundle();
        for (int i = 0; i < size; i++) {
            Player player = (Player) ((Player) recipients.get(i)).freeze();
            String playerId = player.getPlayerId();
            this.aeV.add((PlayerEntity) player);
            this.aeX.putInt(playerId, request.getRecipientStatus(playerId));
        }
    }

    /* renamed from: a */
    static int m4259a(GameRequest gameRequest) {
        return jv.hashCode(gameRequest.getGame(), gameRequest.getRecipients(), gameRequest.getRequestId(), gameRequest.getSender(), m4261b(gameRequest), Integer.valueOf(gameRequest.getType()), Long.valueOf(gameRequest.getCreationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    /* renamed from: a */
    static boolean m4260a(GameRequest gameRequest, Object obj) {
        if (!(obj instanceof GameRequest)) {
            return false;
        }
        if (gameRequest == obj) {
            return true;
        }
        GameRequest gameRequest2 = (GameRequest) obj;
        return jv.equal(gameRequest2.getGame(), gameRequest.getGame()) && jv.equal(gameRequest2.getRecipients(), gameRequest.getRecipients()) && jv.equal(gameRequest2.getRequestId(), gameRequest.getRequestId()) && jv.equal(gameRequest2.getSender(), gameRequest.getSender()) && Arrays.equals(m4261b(gameRequest2), m4261b(gameRequest)) && jv.equal(Integer.valueOf(gameRequest2.getType()), Integer.valueOf(gameRequest.getType())) && jv.equal(Long.valueOf(gameRequest2.getCreationTimestamp()), Long.valueOf(gameRequest.getCreationTimestamp())) && jv.equal(Long.valueOf(gameRequest2.getExpirationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    /* renamed from: b */
    private static int[] m4261b(GameRequest gameRequest) {
        List recipients = gameRequest.getRecipients();
        int size = recipients.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = gameRequest.getRecipientStatus(((Player) recipients.get(i)).getPlayerId());
        }
        return iArr;
    }

    /* renamed from: c */
    static String m4262c(GameRequest gameRequest) {
        return jv.m1571h(gameRequest).m1570a("Game", gameRequest.getGame()).m1570a("Sender", gameRequest.getSender()).m1570a("Recipients", gameRequest.getRecipients()).m1570a("Data", gameRequest.getData()).m1570a("RequestId", gameRequest.getRequestId()).m1570a("Type", Integer.valueOf(gameRequest.getType())).m1570a("CreationTimestamp", Long.valueOf(gameRequest.getCreationTimestamp())).m1570a("ExpirationTimestamp", Long.valueOf(gameRequest.getExpirationTimestamp())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m4260a(this, obj);
    }

    public GameRequest freeze() {
        return this;
    }

    public long getCreationTimestamp() {
        return this.adS;
    }

    public byte[] getData() {
        return this.aeA;
    }

    public long getExpirationTimestamp() {
        return this.aeW;
    }

    public Game getGame() {
        return this.acs;
    }

    public int getRecipientStatus(String playerId) {
        return this.aeX.getInt(playerId, 0);
    }

    public List<Player> getRecipients() {
        return new ArrayList(this.aeV);
    }

    public String getRequestId() {
        return this.Zt;
    }

    public Player getSender() {
        return this.aeU;
    }

    public int getStatus() {
        return this.FP;
    }

    public int getType() {
        return this.Gt;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return m4259a(this);
    }

    public boolean isConsumed(String playerId) {
        return getRecipientStatus(playerId) == 1;
    }

    public boolean isDataValid() {
        return true;
    }

    public Bundle mS() {
        return this.aeX;
    }

    public String toString() {
        return m4262c(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        GameRequestEntityCreator.m964a(this, dest, flags);
    }
}
