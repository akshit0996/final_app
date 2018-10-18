package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.le;

public final class EventEntity implements SafeParcelable, Event {
    public static final EventEntityCreator CREATOR = new EventEntityCreator();
    private final int CK;
    private final String UO;
    private final Uri WD;
    private final String WO;
    private final PlayerEntity XE;
    private final String Ye;
    private final long Yf;
    private final String Yg;
    private final boolean Yh;
    private final String mName;

    EventEntity(int versionCode, String eventId, String name, String description, Uri iconImageUri, String iconImageUrl, Player player, long value, String formattedValue, boolean isVisible) {
        this.CK = versionCode;
        this.Ye = eventId;
        this.mName = name;
        this.UO = description;
        this.WD = iconImageUri;
        this.WO = iconImageUrl;
        this.XE = new PlayerEntity(player);
        this.Yf = value;
        this.Yg = formattedValue;
        this.Yh = isVisible;
    }

    public EventEntity(Event event) {
        this.CK = 1;
        this.Ye = event.getEventId();
        this.mName = event.getName();
        this.UO = event.getDescription();
        this.WD = event.getIconImageUri();
        this.WO = event.getIconImageUrl();
        this.XE = (PlayerEntity) event.getPlayer().freeze();
        this.Yf = event.getValue();
        this.Yg = event.getFormattedValue();
        this.Yh = event.isVisible();
    }

    /* renamed from: a */
    static int m4042a(Event event) {
        return jv.hashCode(event.getEventId(), event.getName(), event.getDescription(), event.getIconImageUri(), event.getIconImageUrl(), event.getPlayer(), Long.valueOf(event.getValue()), event.getFormattedValue(), Boolean.valueOf(event.isVisible()));
    }

    /* renamed from: a */
    static boolean m4043a(Event event, Object obj) {
        if (!(obj instanceof Event)) {
            return false;
        }
        if (event == obj) {
            return true;
        }
        Event event2 = (Event) obj;
        return jv.equal(event2.getEventId(), event.getEventId()) && jv.equal(event2.getName(), event.getName()) && jv.equal(event2.getDescription(), event.getDescription()) && jv.equal(event2.getIconImageUri(), event.getIconImageUri()) && jv.equal(event2.getIconImageUrl(), event.getIconImageUrl()) && jv.equal(event2.getPlayer(), event.getPlayer()) && jv.equal(Long.valueOf(event2.getValue()), Long.valueOf(event.getValue())) && jv.equal(event2.getFormattedValue(), event.getFormattedValue()) && jv.equal(Boolean.valueOf(event2.isVisible()), Boolean.valueOf(event.isVisible()));
    }

    /* renamed from: b */
    static String m4044b(Event event) {
        return jv.m1571h(event).m1570a("Id", event.getEventId()).m1570a("Name", event.getName()).m1570a("Description", event.getDescription()).m1570a("IconImageUri", event.getIconImageUri()).m1570a("IconImageUrl", event.getIconImageUrl()).m1570a("Player", event.getPlayer()).m1570a("Value", Long.valueOf(event.getValue())).m1570a("FormattedValue", event.getFormattedValue()).m1570a("isVisible", Boolean.valueOf(event.isVisible())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m4043a(this, obj);
    }

    public Event freeze() {
        return this;
    }

    public String getDescription() {
        return this.UO;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        le.m1637b(this.UO, dataOut);
    }

    public String getEventId() {
        return this.Ye;
    }

    public String getFormattedValue() {
        return this.Yg;
    }

    public void getFormattedValue(CharArrayBuffer dataOut) {
        le.m1637b(this.Yg, dataOut);
    }

    public Uri getIconImageUri() {
        return this.WD;
    }

    public String getIconImageUrl() {
        return this.WO;
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

    public long getValue() {
        return this.Yf;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return m4042a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isVisible() {
        return this.Yh;
    }

    public String toString() {
        return m4044b(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        EventEntityCreator.m678a(this, out, flags);
    }
}
