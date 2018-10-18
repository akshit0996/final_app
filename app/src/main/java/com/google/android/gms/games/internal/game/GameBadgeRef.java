package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.C0174d;
import com.google.android.gms.common.data.DataHolder;

public final class GameBadgeRef extends C0174d implements GameBadge {
    GameBadgeRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return GameBadgeEntity.m4888a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return mk();
    }

    public String getDescription() {
        return getString("badge_description");
    }

    public Uri getIconImageUri() {
        return aR("badge_icon_image_uri");
    }

    public String getTitle() {
        return getString("badge_title");
    }

    public int getType() {
        return getInteger("badge_type");
    }

    public int hashCode() {
        return GameBadgeEntity.m4887a(this);
    }

    public GameBadge mk() {
        return new GameBadgeEntity(this);
    }

    public String toString() {
        return GameBadgeEntity.m4889b((GameBadge) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((GameBadgeEntity) mk()).writeToParcel(dest, flags);
    }
}
