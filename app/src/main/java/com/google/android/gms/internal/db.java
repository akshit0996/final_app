package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

@ey
public final class db implements MediationAdRequest {
    /* renamed from: d */
    private final Date f95d;
    /* renamed from: f */
    private final Set<String> f96f;
    /* renamed from: g */
    private final boolean f97g;
    /* renamed from: h */
    private final Location f98h;
    private final int ow;
    private final int qU;

    public db(Date date, int i, Set<String> set, Location location, boolean z, int i2) {
        this.f95d = date;
        this.ow = i;
        this.f96f = set;
        this.f98h = location;
        this.f97g = z;
        this.qU = i2;
    }

    public Date getBirthday() {
        return this.f95d;
    }

    public int getGender() {
        return this.ow;
    }

    public Set<String> getKeywords() {
        return this.f96f;
    }

    public Location getLocation() {
        return this.f98h;
    }

    public boolean isTesting() {
        return this.f97g;
    }

    public int taggedForChildDirectedTreatment() {
        return this.qU;
    }
}
