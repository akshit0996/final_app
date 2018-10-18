package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.C1307g;
import com.google.android.gms.common.data.DataHolder;

public final class InvitationBuffer extends C1307g<Invitation> {
    public InvitationBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* renamed from: f */
    protected /* synthetic */ Object mo3686f(int i, int i2) {
        return m4894k(i, i2);
    }

    protected String ha() {
        return "external_invitation_id";
    }

    /* renamed from: k */
    protected Invitation m4894k(int i, int i2) {
        return new InvitationRef(this.JG, i, i2);
    }
}
