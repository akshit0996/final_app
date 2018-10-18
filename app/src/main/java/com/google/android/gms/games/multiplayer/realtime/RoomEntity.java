package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.ji;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.le;
import java.util.ArrayList;

public final class RoomEntity extends GamesDowngradeableSafeParcel implements Room {
    public static final Creator<RoomEntity> CREATOR = new RoomEntityCreatorCompat();
    private final int CK;
    private final String UO;
    private final String YI;
    private final long adS;
    private final ArrayList<ParticipantEntity> adV;
    private final int adW;
    private final Bundle aem;
    private final String aep;
    private final int aeq;
    private final int aer;

    static final class RoomEntityCreatorCompat extends RoomEntityCreator {
        RoomEntityCreatorCompat() {
        }

        public RoomEntity cC(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.m4233c(ji.ht()) || ji.aW(RoomEntity.class.getCanonicalName())) {
                return super.cC(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            String readString3 = parcel.readString();
            int readInt2 = parcel.readInt();
            Bundle readBundle = parcel.readBundle();
            int readInt3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt3);
            for (int i = 0; i < readInt3; i++) {
                arrayList.add(ParticipantEntity.CREATOR.createFromParcel(parcel));
            }
            return new RoomEntity(2, readString, readString2, readLong, readInt, readString3, readInt2, readBundle, arrayList, -1);
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return cC(x0);
        }
    }

    RoomEntity(int versionCode, String roomId, String creatorId, long creationTimestamp, int roomStatus, String description, int variant, Bundle autoMatchCriteria, ArrayList<ParticipantEntity> participants, int autoMatchWaitEstimateSeconds) {
        this.CK = versionCode;
        this.YI = roomId;
        this.aep = creatorId;
        this.adS = creationTimestamp;
        this.aeq = roomStatus;
        this.UO = description;
        this.adW = variant;
        this.aem = autoMatchCriteria;
        this.adV = participants;
        this.aer = autoMatchWaitEstimateSeconds;
    }

    public RoomEntity(Room room) {
        this.CK = 2;
        this.YI = room.getRoomId();
        this.aep = room.getCreatorId();
        this.adS = room.getCreationTimestamp();
        this.aeq = room.getStatus();
        this.UO = room.getDescription();
        this.adW = room.getVariant();
        this.aem = room.getAutoMatchCriteria();
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        this.adV = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.adV.add((ParticipantEntity) ((Participant) participants.get(i)).freeze());
        }
        this.aer = room.getAutoMatchWaitEstimateSeconds();
    }

    /* renamed from: a */
    static int m4905a(Room room) {
        return jv.hashCode(room.getRoomId(), room.getCreatorId(), Long.valueOf(room.getCreationTimestamp()), Integer.valueOf(room.getStatus()), room.getDescription(), Integer.valueOf(room.getVariant()), room.getAutoMatchCriteria(), room.getParticipants(), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds()));
    }

    /* renamed from: a */
    static int m4906a(Room room, String str) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant.getStatus();
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in room " + room.getRoomId());
    }

    /* renamed from: a */
    static boolean m4907a(Room room, Object obj) {
        if (!(obj instanceof Room)) {
            return false;
        }
        if (room == obj) {
            return true;
        }
        Room room2 = (Room) obj;
        return jv.equal(room2.getRoomId(), room.getRoomId()) && jv.equal(room2.getCreatorId(), room.getCreatorId()) && jv.equal(Long.valueOf(room2.getCreationTimestamp()), Long.valueOf(room.getCreationTimestamp())) && jv.equal(Integer.valueOf(room2.getStatus()), Integer.valueOf(room.getStatus())) && jv.equal(room2.getDescription(), room.getDescription()) && jv.equal(Integer.valueOf(room2.getVariant()), Integer.valueOf(room.getVariant())) && jv.equal(room2.getAutoMatchCriteria(), room.getAutoMatchCriteria()) && jv.equal(room2.getParticipants(), room.getParticipants()) && jv.equal(Integer.valueOf(room2.getAutoMatchWaitEstimateSeconds()), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds()));
    }

    /* renamed from: b */
    static String m4908b(Room room) {
        return jv.m1571h(room).m1570a("RoomId", room.getRoomId()).m1570a("CreatorId", room.getCreatorId()).m1570a("CreationTimestamp", Long.valueOf(room.getCreationTimestamp())).m1570a("RoomStatus", Integer.valueOf(room.getStatus())).m1570a("Description", room.getDescription()).m1570a("Variant", Integer.valueOf(room.getVariant())).m1570a("AutoMatchCriteria", room.getAutoMatchCriteria()).m1570a("Participants", room.getParticipants()).m1570a("AutoMatchWaitEstimateSeconds", Integer.valueOf(room.getAutoMatchWaitEstimateSeconds())).toString();
    }

    /* renamed from: b */
    static String m4909b(Room room, String str) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            Player player = participant.getPlayer();
            if (player != null && player.getPlayerId().equals(str)) {
                return participant.getParticipantId();
            }
        }
        return null;
    }

    /* renamed from: c */
    static Participant m4911c(Room room, String str) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant;
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in match " + room.getRoomId());
    }

    /* renamed from: c */
    static ArrayList<String> m4912c(Room room) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        ArrayList<String> arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(((Participant) participants.get(i)).getParticipantId());
        }
        return arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m4907a((Room) this, obj);
    }

    public Room freeze() {
        return this;
    }

    public Bundle getAutoMatchCriteria() {
        return this.aem;
    }

    public int getAutoMatchWaitEstimateSeconds() {
        return this.aer;
    }

    public long getCreationTimestamp() {
        return this.adS;
    }

    public String getCreatorId() {
        return this.aep;
    }

    public String getDescription() {
        return this.UO;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        le.m1637b(this.UO, dataOut);
    }

    public Participant getParticipant(String participantId) {
        return m4911c(this, participantId);
    }

    public String getParticipantId(String playerId) {
        return m4909b(this, playerId);
    }

    public ArrayList<String> getParticipantIds() {
        return m4912c(this);
    }

    public int getParticipantStatus(String participantId) {
        return m4906a((Room) this, participantId);
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList(this.adV);
    }

    public String getRoomId() {
        return this.YI;
    }

    public int getStatus() {
        return this.aeq;
    }

    public int getVariant() {
        return this.adW;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return m4905a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m4908b((Room) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        if (hu()) {
            dest.writeString(this.YI);
            dest.writeString(this.aep);
            dest.writeLong(this.adS);
            dest.writeInt(this.aeq);
            dest.writeString(this.UO);
            dest.writeInt(this.adW);
            dest.writeBundle(this.aem);
            int size = this.adV.size();
            dest.writeInt(size);
            for (int i = 0; i < size; i++) {
                ((ParticipantEntity) this.adV.get(i)).writeToParcel(dest, flags);
            }
            return;
        }
        RoomEntityCreator.m959a(this, dest, flags);
    }
}
