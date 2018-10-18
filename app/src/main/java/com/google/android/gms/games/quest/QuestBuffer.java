package com.google.android.gms.games.quest;

import com.google.android.gms.common.data.C1307g;
import com.google.android.gms.common.data.DataHolder;

public final class QuestBuffer extends C1307g<Quest> {
    public QuestBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* renamed from: f */
    protected /* synthetic */ Object mo3686f(int i, int i2) {
        return m4916n(i, i2);
    }

    protected String ha() {
        return "external_quest_id";
    }

    /* renamed from: n */
    protected Quest m4916n(int i, int i2) {
        return new QuestRef(this.JG, i, i2);
    }
}
