package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest.Gender;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Deprecated
public final class MediationAdRequest {
    /* renamed from: d */
    private final Date f3d;
    /* renamed from: e */
    private final Gender f4e;
    /* renamed from: f */
    private final Set<String> f5f;
    /* renamed from: g */
    private final boolean f6g;
    /* renamed from: h */
    private final Location f7h;

    public MediationAdRequest(Date birthday, Gender gender, Set<String> keywords, boolean isTesting, Location location) {
        this.f3d = birthday;
        this.f4e = gender;
        this.f5f = keywords;
        this.f6g = isTesting;
        this.f7h = location;
    }

    public Integer getAgeInYears() {
        if (this.f3d == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTime(this.f3d);
        Integer valueOf = Integer.valueOf(instance2.get(1) - instance.get(1));
        return (instance2.get(2) < instance.get(2) || (instance2.get(2) == instance.get(2) && instance2.get(5) < instance.get(5))) ? Integer.valueOf(valueOf.intValue() - 1) : valueOf;
    }

    public Date getBirthday() {
        return this.f3d;
    }

    public Gender getGender() {
        return this.f4e;
    }

    public Set<String> getKeywords() {
        return this.f5f;
    }

    public Location getLocation() {
        return this.f7h;
    }

    public boolean isTesting() {
        return this.f6g;
    }
}
