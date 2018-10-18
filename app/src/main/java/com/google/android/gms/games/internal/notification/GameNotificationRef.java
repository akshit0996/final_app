package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.C0174d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.jv;
import com.google.android.gms.plus.PlusShare;

public final class GameNotificationRef extends C0174d implements GameNotification {
    GameNotificationRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public long getId() {
        return getLong("_id");
    }

    public String getText() {
        return getString("text");
    }

    public String getTitle() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
    }

    public int getType() {
        return getInteger("type");
    }

    public String mr() {
        return getString("notification_id");
    }

    public String ms() {
        return getString("ticker");
    }

    public String mt() {
        return getString("coalesced_text");
    }

    public boolean mu() {
        return getInteger("acknowledged") > 0;
    }

    public boolean mv() {
        return getInteger("alert_level") == 0;
    }

    public String toString() {
        return jv.m1571h(this).m1570a("Id", Long.valueOf(getId())).m1570a("NotificationId", mr()).m1570a("Type", Integer.valueOf(getType())).m1570a("Title", getTitle()).m1570a("Ticker", ms()).m1570a("Text", getText()).m1570a("CoalescedText", mt()).m1570a("isAcknowledged", Boolean.valueOf(mu())).m1570a("isSilent", Boolean.valueOf(mv())).toString();
    }
}
