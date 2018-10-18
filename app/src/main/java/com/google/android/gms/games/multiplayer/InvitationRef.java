package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.data.C0174d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;

public final class InvitationRef extends C0174d implements Invitation {
    private final ArrayList<Participant> adV;
    private final ParticipantRef adY;
    private final Game adq;

    InvitationRef(DataHolder holder, int dataRow, int numChildren) {
        super(holder, dataRow);
        this.adq = new GameRef(holder, dataRow);
        this.adV = new ArrayList(numChildren);
        String string = getString("external_inviter_id");
        Object obj = null;
        for (int i = 0; i < numChildren; i++) {
            ParticipantRef participantRef = new ParticipantRef(this.JG, this.KZ + i);
            if (participantRef.getParticipantId().equals(string)) {
                obj = participantRef;
            }
            this.adV.add(participantRef);
        }
        this.adY = (ParticipantRef) jx.m1578b(obj, (Object) "Must have a valid inviter!");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return InvitationEntity.m4896a(this, obj);
    }

    public Invitation freeze() {
        return new InvitationEntity(this);
    }

    public int getAvailableAutoMatchSlots() {
        return !getBoolean("has_automatch_criteria") ? 0 : getInteger("automatch_max_players");
    }

    public long getCreationTimestamp() {
        return Math.max(getLong("creation_timestamp"), getLong("last_modified_timestamp"));
    }

    public Game getGame() {
        return this.adq;
    }

    public String getInvitationId() {
        return getString("external_invitation_id");
    }

    public int getInvitationType() {
        return getInteger("type");
    }

    public Participant getInviter() {
        return this.adY;
    }

    public ArrayList<Participant> getParticipants() {
        return this.adV;
    }

    public int getVariant() {
        return getInteger("variant");
    }

    public int hashCode() {
        return InvitationEntity.m4895a(this);
    }

    public String toString() {
        return InvitationEntity.m4897b((Invitation) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((InvitationEntity) freeze()).writeToParcel(dest, flags);
    }
}
