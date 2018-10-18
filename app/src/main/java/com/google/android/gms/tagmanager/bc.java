package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0361a;
import com.google.android.gms.internal.C0386d.C1389a;
import java.util.Locale;
import java.util.Map;

class bc extends aj {
    private static final String ID = C0361a.LANGUAGE.toString();

    public bc() {
        super(ID, new String[0]);
    }

    /* renamed from: B */
    public C1389a mo2513B(Map<String, C1389a> map) {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return di.rb();
        }
        String language = locale.getLanguage();
        return language == null ? di.rb() : di.m2202u(language.toLowerCase());
    }

    public boolean pe() {
        return false;
    }
}
