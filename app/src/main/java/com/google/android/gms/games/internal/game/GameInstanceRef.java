package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.C0174d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.PlatformType;
import com.google.android.gms.internal.jv;

public final class GameInstanceRef extends C0174d implements GameInstance {
    GameInstanceRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public String getApplicationId() {
        return getString("external_game_id");
    }

    public String getDisplayName() {
        return getString("instance_display_name");
    }

    public String getPackageName() {
        return getString("package_name");
    }

    public int jC() {
        return getInteger("platform_type");
    }

    public boolean ml() {
        return getInteger("real_time_support") > 0;
    }

    public boolean mm() {
        return getInteger("turn_based_support") > 0;
    }

    public boolean mn() {
        return getInteger("piracy_check") > 0;
    }

    public boolean mo() {
        return getInteger("installed") > 0;
    }

    public String toString() {
        return jv.m1571h(this).m1570a("ApplicationId", getApplicationId()).m1570a("DisplayName", getDisplayName()).m1570a("SupportsRealTime", Boolean.valueOf(ml())).m1570a("SupportsTurnBased", Boolean.valueOf(mm())).m1570a("PlatformType", PlatformType.dZ(jC())).m1570a("PackageName", getPackageName()).m1570a("PiracyCheckEnabled", Boolean.valueOf(mn())).m1570a("Installed", Boolean.valueOf(mo())).toString();
    }
}
