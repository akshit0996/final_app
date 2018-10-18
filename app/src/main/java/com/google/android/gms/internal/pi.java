package com.google.android.gms.internal;

import android.os.Parcel;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.internal.kr.C1017a;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.Person.AgeRange;
import com.google.android.gms.plus.model.people.Person.Cover;
import com.google.android.gms.plus.model.people.Person.Cover.CoverInfo;
import com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto;
import com.google.android.gms.plus.model.people.Person.Image;
import com.google.android.gms.plus.model.people.Person.Name;
import com.google.android.gms.plus.model.people.Person.Organizations;
import com.google.android.gms.plus.model.people.Person.PlacesLived;
import com.google.android.gms.plus.model.people.Person.Urls;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class pi extends ks implements Person {
    public static final pj CREATOR = new pj();
    private static final HashMap<String, C1017a<?, ?>> aom = new HashMap();
    String CE;
    final int CK;
    String FR;
    String OS;
    final Set<Integer> aon;
    int apA;
    String apB;
    List<C1430h> apC;
    boolean apD;
    String apl;
    C1422a apm;
    String apn;
    String apo;
    int app;
    C1425b apq;
    String apr;
    C1426c aps;
    boolean apt;
    C1427d apu;
    String apv;
    int apw;
    List<C1428f> apx;
    List<C1429g> apy;
    int apz;
    int ow;
    String vf;

    /* renamed from: com.google.android.gms.internal.pi$e */
    public static class C0496e {
        public static int ck(String str) {
            if (str.equals("person")) {
                return 0;
            }
            if (str.equals("page")) {
                return 1;
            }
            throw new IllegalArgumentException("Unknown objectType string: " + str);
        }
    }

    /* renamed from: com.google.android.gms.internal.pi$a */
    public static final class C1422a extends ks implements AgeRange {
        public static final pk CREATOR = new pk();
        private static final HashMap<String, C1017a<?, ?>> aom = new HashMap();
        final int CK;
        final Set<Integer> aon;
        int apE;
        int apF;

        static {
            aom.put("max", C1017a.m3381i("max", 2));
            aom.put("min", C1017a.m3381i("min", 3));
        }

        public C1422a() {
            this.CK = 1;
            this.aon = new HashSet();
        }

        C1422a(Set<Integer> set, int i, int i2, int i3) {
            this.aon = set;
            this.CK = i;
            this.apE = i2;
            this.apF = i3;
        }

        /* renamed from: a */
        protected boolean mo3354a(C1017a c1017a) {
            return this.aon.contains(Integer.valueOf(c1017a.hR()));
        }

        /* renamed from: b */
        protected Object mo3355b(C1017a c1017a) {
            switch (c1017a.hR()) {
                case 2:
                    return Integer.valueOf(this.apE);
                case 3:
                    return Integer.valueOf(this.apF);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c1017a.hR());
            }
        }

        public int describeContents() {
            pk pkVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1422a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1422a c1422a = (C1422a) obj;
            for (C1017a c1017a : aom.values()) {
                if (mo3354a(c1017a)) {
                    if (!c1422a.mo3354a(c1017a)) {
                        return false;
                    }
                    if (!mo3355b(c1017a).equals(c1422a.mo3355b(c1017a))) {
                        return false;
                    }
                } else if (c1422a.mo3354a(c1017a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return oM();
        }

        public int getMax() {
            return this.apE;
        }

        public int getMin() {
            return this.apF;
        }

        public HashMap<String, C1017a<?, ?>> hK() {
            return aom;
        }

        public boolean hasMax() {
            return this.aon.contains(Integer.valueOf(2));
        }

        public boolean hasMin() {
            return this.aon.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            for (C1017a c1017a : aom.values()) {
                int hashCode;
                if (mo3354a(c1017a)) {
                    hashCode = mo3355b(c1017a).hashCode() + (i + c1017a.hR());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public C1422a oM() {
            return this;
        }

        public void writeToParcel(Parcel out, int flags) {
            pk pkVar = CREATOR;
            pk.m1773a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.pi$b */
    public static final class C1425b extends ks implements Cover {
        public static final pl CREATOR = new pl();
        private static final HashMap<String, C1017a<?, ?>> aom = new HashMap();
        final int CK;
        final Set<Integer> aon;
        C1423a apG;
        C1424b apH;
        int apI;

        /* renamed from: com.google.android.gms.internal.pi$b$a */
        public static final class C1423a extends ks implements CoverInfo {
            public static final pm CREATOR = new pm();
            private static final HashMap<String, C1017a<?, ?>> aom = new HashMap();
            final int CK;
            final Set<Integer> aon;
            int apJ;
            int apK;

            static {
                aom.put("leftImageOffset", C1017a.m3381i("leftImageOffset", 2));
                aom.put("topImageOffset", C1017a.m3381i("topImageOffset", 3));
            }

            public C1423a() {
                this.CK = 1;
                this.aon = new HashSet();
            }

            C1423a(Set<Integer> set, int i, int i2, int i3) {
                this.aon = set;
                this.CK = i;
                this.apJ = i2;
                this.apK = i3;
            }

            /* renamed from: a */
            protected boolean mo3354a(C1017a c1017a) {
                return this.aon.contains(Integer.valueOf(c1017a.hR()));
            }

            /* renamed from: b */
            protected Object mo3355b(C1017a c1017a) {
                switch (c1017a.hR()) {
                    case 2:
                        return Integer.valueOf(this.apJ);
                    case 3:
                        return Integer.valueOf(this.apK);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + c1017a.hR());
                }
            }

            public int describeContents() {
                pm pmVar = CREATOR;
                return 0;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof C1423a)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                C1423a c1423a = (C1423a) obj;
                for (C1017a c1017a : aom.values()) {
                    if (mo3354a(c1017a)) {
                        if (!c1423a.mo3354a(c1017a)) {
                            return false;
                        }
                        if (!mo3355b(c1017a).equals(c1423a.mo3355b(c1017a))) {
                            return false;
                        }
                    } else if (c1423a.mo3354a(c1017a)) {
                        return false;
                    }
                }
                return true;
            }

            public /* synthetic */ Object freeze() {
                return oO();
            }

            public int getLeftImageOffset() {
                return this.apJ;
            }

            public int getTopImageOffset() {
                return this.apK;
            }

            public HashMap<String, C1017a<?, ?>> hK() {
                return aom;
            }

            public boolean hasLeftImageOffset() {
                return this.aon.contains(Integer.valueOf(2));
            }

            public boolean hasTopImageOffset() {
                return this.aon.contains(Integer.valueOf(3));
            }

            public int hashCode() {
                int i = 0;
                for (C1017a c1017a : aom.values()) {
                    int hashCode;
                    if (mo3354a(c1017a)) {
                        hashCode = mo3355b(c1017a).hashCode() + (i + c1017a.hR());
                    } else {
                        hashCode = i;
                    }
                    i = hashCode;
                }
                return i;
            }

            public boolean isDataValid() {
                return true;
            }

            public C1423a oO() {
                return this;
            }

            public void writeToParcel(Parcel out, int flags) {
                pm pmVar = CREATOR;
                pm.m1775a(this, out, flags);
            }
        }

        /* renamed from: com.google.android.gms.internal.pi$b$b */
        public static final class C1424b extends ks implements CoverPhoto {
            public static final pn CREATOR = new pn();
            private static final HashMap<String, C1017a<?, ?>> aom = new HashMap();
            final int CK;
            final Set<Integer> aon;
            int li;
            int lj;
            String vf;

            static {
                aom.put("height", C1017a.m3381i("height", 2));
                aom.put(PlusShare.KEY_CALL_TO_ACTION_URL, C1017a.m3384l(PlusShare.KEY_CALL_TO_ACTION_URL, 3));
                aom.put("width", C1017a.m3381i("width", 4));
            }

            public C1424b() {
                this.CK = 1;
                this.aon = new HashSet();
            }

            C1424b(Set<Integer> set, int i, int i2, String str, int i3) {
                this.aon = set;
                this.CK = i;
                this.lj = i2;
                this.vf = str;
                this.li = i3;
            }

            /* renamed from: a */
            protected boolean mo3354a(C1017a c1017a) {
                return this.aon.contains(Integer.valueOf(c1017a.hR()));
            }

            /* renamed from: b */
            protected Object mo3355b(C1017a c1017a) {
                switch (c1017a.hR()) {
                    case 2:
                        return Integer.valueOf(this.lj);
                    case 3:
                        return this.vf;
                    case 4:
                        return Integer.valueOf(this.li);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + c1017a.hR());
                }
            }

            public int describeContents() {
                pn pnVar = CREATOR;
                return 0;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof C1424b)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                C1424b c1424b = (C1424b) obj;
                for (C1017a c1017a : aom.values()) {
                    if (mo3354a(c1017a)) {
                        if (!c1424b.mo3354a(c1017a)) {
                            return false;
                        }
                        if (!mo3355b(c1017a).equals(c1424b.mo3355b(c1017a))) {
                            return false;
                        }
                    } else if (c1424b.mo3354a(c1017a)) {
                        return false;
                    }
                }
                return true;
            }

            public /* synthetic */ Object freeze() {
                return oP();
            }

            public int getHeight() {
                return this.lj;
            }

            public String getUrl() {
                return this.vf;
            }

            public int getWidth() {
                return this.li;
            }

            public HashMap<String, C1017a<?, ?>> hK() {
                return aom;
            }

            public boolean hasHeight() {
                return this.aon.contains(Integer.valueOf(2));
            }

            public boolean hasUrl() {
                return this.aon.contains(Integer.valueOf(3));
            }

            public boolean hasWidth() {
                return this.aon.contains(Integer.valueOf(4));
            }

            public int hashCode() {
                int i = 0;
                for (C1017a c1017a : aom.values()) {
                    int hashCode;
                    if (mo3354a(c1017a)) {
                        hashCode = mo3355b(c1017a).hashCode() + (i + c1017a.hR());
                    } else {
                        hashCode = i;
                    }
                    i = hashCode;
                }
                return i;
            }

            public boolean isDataValid() {
                return true;
            }

            public C1424b oP() {
                return this;
            }

            public void writeToParcel(Parcel out, int flags) {
                pn pnVar = CREATOR;
                pn.m1776a(this, out, flags);
            }
        }

        static {
            aom.put("coverInfo", C1017a.m3378a("coverInfo", 2, C1423a.class));
            aom.put("coverPhoto", C1017a.m3378a("coverPhoto", 3, C1424b.class));
            aom.put("layout", C1017a.m3377a("layout", 4, new ko().m3376h("banner", 0), false));
        }

        public C1425b() {
            this.CK = 1;
            this.aon = new HashSet();
        }

        C1425b(Set<Integer> set, int i, C1423a c1423a, C1424b c1424b, int i2) {
            this.aon = set;
            this.CK = i;
            this.apG = c1423a;
            this.apH = c1424b;
            this.apI = i2;
        }

        /* renamed from: a */
        protected boolean mo3354a(C1017a c1017a) {
            return this.aon.contains(Integer.valueOf(c1017a.hR()));
        }

        /* renamed from: b */
        protected Object mo3355b(C1017a c1017a) {
            switch (c1017a.hR()) {
                case 2:
                    return this.apG;
                case 3:
                    return this.apH;
                case 4:
                    return Integer.valueOf(this.apI);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c1017a.hR());
            }
        }

        public int describeContents() {
            pl plVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1425b)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1425b c1425b = (C1425b) obj;
            for (C1017a c1017a : aom.values()) {
                if (mo3354a(c1017a)) {
                    if (!c1425b.mo3354a(c1017a)) {
                        return false;
                    }
                    if (!mo3355b(c1017a).equals(c1425b.mo3355b(c1017a))) {
                        return false;
                    }
                } else if (c1425b.mo3354a(c1017a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return oN();
        }

        public CoverInfo getCoverInfo() {
            return this.apG;
        }

        public CoverPhoto getCoverPhoto() {
            return this.apH;
        }

        public int getLayout() {
            return this.apI;
        }

        public HashMap<String, C1017a<?, ?>> hK() {
            return aom;
        }

        public boolean hasCoverInfo() {
            return this.aon.contains(Integer.valueOf(2));
        }

        public boolean hasCoverPhoto() {
            return this.aon.contains(Integer.valueOf(3));
        }

        public boolean hasLayout() {
            return this.aon.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            for (C1017a c1017a : aom.values()) {
                int hashCode;
                if (mo3354a(c1017a)) {
                    hashCode = mo3355b(c1017a).hashCode() + (i + c1017a.hR());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public C1425b oN() {
            return this;
        }

        public void writeToParcel(Parcel out, int flags) {
            pl plVar = CREATOR;
            pl.m1774a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.pi$c */
    public static final class C1426c extends ks implements Image {
        public static final po CREATOR = new po();
        private static final HashMap<String, C1017a<?, ?>> aom = new HashMap();
        final int CK;
        final Set<Integer> aon;
        String vf;

        static {
            aom.put(PlusShare.KEY_CALL_TO_ACTION_URL, C1017a.m3384l(PlusShare.KEY_CALL_TO_ACTION_URL, 2));
        }

        public C1426c() {
            this.CK = 1;
            this.aon = new HashSet();
        }

        public C1426c(String str) {
            this.aon = new HashSet();
            this.CK = 1;
            this.vf = str;
            this.aon.add(Integer.valueOf(2));
        }

        C1426c(Set<Integer> set, int i, String str) {
            this.aon = set;
            this.CK = i;
            this.vf = str;
        }

        /* renamed from: a */
        protected boolean mo3354a(C1017a c1017a) {
            return this.aon.contains(Integer.valueOf(c1017a.hR()));
        }

        /* renamed from: b */
        protected Object mo3355b(C1017a c1017a) {
            switch (c1017a.hR()) {
                case 2:
                    return this.vf;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c1017a.hR());
            }
        }

        public int describeContents() {
            po poVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1426c)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1426c c1426c = (C1426c) obj;
            for (C1017a c1017a : aom.values()) {
                if (mo3354a(c1017a)) {
                    if (!c1426c.mo3354a(c1017a)) {
                        return false;
                    }
                    if (!mo3355b(c1017a).equals(c1426c.mo3355b(c1017a))) {
                        return false;
                    }
                } else if (c1426c.mo3354a(c1017a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return oQ();
        }

        public String getUrl() {
            return this.vf;
        }

        public HashMap<String, C1017a<?, ?>> hK() {
            return aom;
        }

        public boolean hasUrl() {
            return this.aon.contains(Integer.valueOf(2));
        }

        public int hashCode() {
            int i = 0;
            for (C1017a c1017a : aom.values()) {
                int hashCode;
                if (mo3354a(c1017a)) {
                    hashCode = mo3355b(c1017a).hashCode() + (i + c1017a.hR());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public C1426c oQ() {
            return this;
        }

        public void writeToParcel(Parcel out, int flags) {
            po poVar = CREATOR;
            po.m1777a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.pi$d */
    public static final class C1427d extends ks implements Name {
        public static final pp CREATOR = new pp();
        private static final HashMap<String, C1017a<?, ?>> aom = new HashMap();
        final int CK;
        String aoL;
        String aoO;
        final Set<Integer> aon;
        String apL;
        String apM;
        String apN;
        String apO;

        static {
            aom.put("familyName", C1017a.m3384l("familyName", 2));
            aom.put("formatted", C1017a.m3384l("formatted", 3));
            aom.put("givenName", C1017a.m3384l("givenName", 4));
            aom.put("honorificPrefix", C1017a.m3384l("honorificPrefix", 5));
            aom.put("honorificSuffix", C1017a.m3384l("honorificSuffix", 6));
            aom.put("middleName", C1017a.m3384l("middleName", 7));
        }

        public C1427d() {
            this.CK = 1;
            this.aon = new HashSet();
        }

        C1427d(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, String str6) {
            this.aon = set;
            this.CK = i;
            this.aoL = str;
            this.apL = str2;
            this.aoO = str3;
            this.apM = str4;
            this.apN = str5;
            this.apO = str6;
        }

        /* renamed from: a */
        protected boolean mo3354a(C1017a c1017a) {
            return this.aon.contains(Integer.valueOf(c1017a.hR()));
        }

        /* renamed from: b */
        protected Object mo3355b(C1017a c1017a) {
            switch (c1017a.hR()) {
                case 2:
                    return this.aoL;
                case 3:
                    return this.apL;
                case 4:
                    return this.aoO;
                case 5:
                    return this.apM;
                case 6:
                    return this.apN;
                case 7:
                    return this.apO;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c1017a.hR());
            }
        }

        public int describeContents() {
            pp ppVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1427d)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1427d c1427d = (C1427d) obj;
            for (C1017a c1017a : aom.values()) {
                if (mo3354a(c1017a)) {
                    if (!c1427d.mo3354a(c1017a)) {
                        return false;
                    }
                    if (!mo3355b(c1017a).equals(c1427d.mo3355b(c1017a))) {
                        return false;
                    }
                } else if (c1427d.mo3354a(c1017a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return oR();
        }

        public String getFamilyName() {
            return this.aoL;
        }

        public String getFormatted() {
            return this.apL;
        }

        public String getGivenName() {
            return this.aoO;
        }

        public String getHonorificPrefix() {
            return this.apM;
        }

        public String getHonorificSuffix() {
            return this.apN;
        }

        public String getMiddleName() {
            return this.apO;
        }

        public HashMap<String, C1017a<?, ?>> hK() {
            return aom;
        }

        public boolean hasFamilyName() {
            return this.aon.contains(Integer.valueOf(2));
        }

        public boolean hasFormatted() {
            return this.aon.contains(Integer.valueOf(3));
        }

        public boolean hasGivenName() {
            return this.aon.contains(Integer.valueOf(4));
        }

        public boolean hasHonorificPrefix() {
            return this.aon.contains(Integer.valueOf(5));
        }

        public boolean hasHonorificSuffix() {
            return this.aon.contains(Integer.valueOf(6));
        }

        public boolean hasMiddleName() {
            return this.aon.contains(Integer.valueOf(7));
        }

        public int hashCode() {
            int i = 0;
            for (C1017a c1017a : aom.values()) {
                int hashCode;
                if (mo3354a(c1017a)) {
                    hashCode = mo3355b(c1017a).hashCode() + (i + c1017a.hR());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public C1427d oR() {
            return this;
        }

        public void writeToParcel(Parcel out, int flags) {
            pp ppVar = CREATOR;
            pp.m1778a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.pi$f */
    public static final class C1428f extends ks implements Organizations {
        public static final pq CREATOR = new pq();
        private static final HashMap<String, C1017a<?, ?>> aom = new HashMap();
        final int CK;
        int Gt;
        String OH;
        String UO;
        String aoK;
        final Set<Integer> aon;
        String apP;
        String apQ;
        boolean apR;
        String apa;
        String mName;

        static {
            aom.put("department", C1017a.m3384l("department", 2));
            aom.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, C1017a.m3384l(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 3));
            aom.put("endDate", C1017a.m3384l("endDate", 4));
            aom.put("location", C1017a.m3384l("location", 5));
            aom.put("name", C1017a.m3384l("name", 6));
            aom.put("primary", C1017a.m3383k("primary", 7));
            aom.put("startDate", C1017a.m3384l("startDate", 8));
            aom.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, C1017a.m3384l(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 9));
            aom.put("type", C1017a.m3377a("type", 10, new ko().m3376h("work", 0).m3376h("school", 1), false));
        }

        public C1428f() {
            this.CK = 1;
            this.aon = new HashSet();
        }

        C1428f(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, int i2) {
            this.aon = set;
            this.CK = i;
            this.apP = str;
            this.UO = str2;
            this.aoK = str3;
            this.apQ = str4;
            this.mName = str5;
            this.apR = z;
            this.apa = str6;
            this.OH = str7;
            this.Gt = i2;
        }

        /* renamed from: a */
        protected boolean mo3354a(C1017a c1017a) {
            return this.aon.contains(Integer.valueOf(c1017a.hR()));
        }

        /* renamed from: b */
        protected Object mo3355b(C1017a c1017a) {
            switch (c1017a.hR()) {
                case 2:
                    return this.apP;
                case 3:
                    return this.UO;
                case 4:
                    return this.aoK;
                case 5:
                    return this.apQ;
                case 6:
                    return this.mName;
                case 7:
                    return Boolean.valueOf(this.apR);
                case 8:
                    return this.apa;
                case 9:
                    return this.OH;
                case 10:
                    return Integer.valueOf(this.Gt);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c1017a.hR());
            }
        }

        public int describeContents() {
            pq pqVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1428f)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1428f c1428f = (C1428f) obj;
            for (C1017a c1017a : aom.values()) {
                if (mo3354a(c1017a)) {
                    if (!c1428f.mo3354a(c1017a)) {
                        return false;
                    }
                    if (!mo3355b(c1017a).equals(c1428f.mo3355b(c1017a))) {
                        return false;
                    }
                } else if (c1428f.mo3354a(c1017a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return oS();
        }

        public String getDepartment() {
            return this.apP;
        }

        public String getDescription() {
            return this.UO;
        }

        public String getEndDate() {
            return this.aoK;
        }

        public String getLocation() {
            return this.apQ;
        }

        public String getName() {
            return this.mName;
        }

        public String getStartDate() {
            return this.apa;
        }

        public String getTitle() {
            return this.OH;
        }

        public int getType() {
            return this.Gt;
        }

        public HashMap<String, C1017a<?, ?>> hK() {
            return aom;
        }

        public boolean hasDepartment() {
            return this.aon.contains(Integer.valueOf(2));
        }

        public boolean hasDescription() {
            return this.aon.contains(Integer.valueOf(3));
        }

        public boolean hasEndDate() {
            return this.aon.contains(Integer.valueOf(4));
        }

        public boolean hasLocation() {
            return this.aon.contains(Integer.valueOf(5));
        }

        public boolean hasName() {
            return this.aon.contains(Integer.valueOf(6));
        }

        public boolean hasPrimary() {
            return this.aon.contains(Integer.valueOf(7));
        }

        public boolean hasStartDate() {
            return this.aon.contains(Integer.valueOf(8));
        }

        public boolean hasTitle() {
            return this.aon.contains(Integer.valueOf(9));
        }

        public boolean hasType() {
            return this.aon.contains(Integer.valueOf(10));
        }

        public int hashCode() {
            int i = 0;
            for (C1017a c1017a : aom.values()) {
                int hashCode;
                if (mo3354a(c1017a)) {
                    hashCode = mo3355b(c1017a).hashCode() + (i + c1017a.hR());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.apR;
        }

        public C1428f oS() {
            return this;
        }

        public void writeToParcel(Parcel out, int flags) {
            pq pqVar = CREATOR;
            pq.m1779a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.pi$g */
    public static final class C1429g extends ks implements PlacesLived {
        public static final pr CREATOR = new pr();
        private static final HashMap<String, C1017a<?, ?>> aom = new HashMap();
        final int CK;
        final Set<Integer> aon;
        boolean apR;
        String mValue;

        static {
            aom.put("primary", C1017a.m3383k("primary", 2));
            aom.put("value", C1017a.m3384l("value", 3));
        }

        public C1429g() {
            this.CK = 1;
            this.aon = new HashSet();
        }

        C1429g(Set<Integer> set, int i, boolean z, String str) {
            this.aon = set;
            this.CK = i;
            this.apR = z;
            this.mValue = str;
        }

        /* renamed from: a */
        protected boolean mo3354a(C1017a c1017a) {
            return this.aon.contains(Integer.valueOf(c1017a.hR()));
        }

        /* renamed from: b */
        protected Object mo3355b(C1017a c1017a) {
            switch (c1017a.hR()) {
                case 2:
                    return Boolean.valueOf(this.apR);
                case 3:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c1017a.hR());
            }
        }

        public int describeContents() {
            pr prVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1429g)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1429g c1429g = (C1429g) obj;
            for (C1017a c1017a : aom.values()) {
                if (mo3354a(c1017a)) {
                    if (!c1429g.mo3354a(c1017a)) {
                        return false;
                    }
                    if (!mo3355b(c1017a).equals(c1429g.mo3355b(c1017a))) {
                        return false;
                    }
                } else if (c1429g.mo3354a(c1017a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return oT();
        }

        public String getValue() {
            return this.mValue;
        }

        public HashMap<String, C1017a<?, ?>> hK() {
            return aom;
        }

        public boolean hasPrimary() {
            return this.aon.contains(Integer.valueOf(2));
        }

        public boolean hasValue() {
            return this.aon.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            for (C1017a c1017a : aom.values()) {
                int hashCode;
                if (mo3354a(c1017a)) {
                    hashCode = mo3355b(c1017a).hashCode() + (i + c1017a.hR());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.apR;
        }

        public C1429g oT() {
            return this;
        }

        public void writeToParcel(Parcel out, int flags) {
            pr prVar = CREATOR;
            pr.m1780a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.pi$h */
    public static final class C1430h extends ks implements Urls {
        public static final ps CREATOR = new ps();
        private static final HashMap<String, C1017a<?, ?>> aom = new HashMap();
        final int CK;
        int Gt;
        String XL;
        final Set<Integer> aon;
        private final int apS;
        String mValue;

        static {
            aom.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, C1017a.m3384l(PlusShare.KEY_CALL_TO_ACTION_LABEL, 5));
            aom.put("type", C1017a.m3377a("type", 6, new ko().m3376h("home", 0).m3376h("work", 1).m3376h("blog", 2).m3376h(Scopes.PROFILE, 3).m3376h(FitnessActivities.OTHER, 4).m3376h("otherProfile", 5).m3376h("contributor", 6).m3376h("website", 7), false));
            aom.put("value", C1017a.m3384l("value", 4));
        }

        public C1430h() {
            this.apS = 4;
            this.CK = 1;
            this.aon = new HashSet();
        }

        C1430h(Set<Integer> set, int i, String str, int i2, String str2, int i3) {
            this.apS = 4;
            this.aon = set;
            this.CK = i;
            this.XL = str;
            this.Gt = i2;
            this.mValue = str2;
        }

        /* renamed from: a */
        protected boolean mo3354a(C1017a c1017a) {
            return this.aon.contains(Integer.valueOf(c1017a.hR()));
        }

        /* renamed from: b */
        protected Object mo3355b(C1017a c1017a) {
            switch (c1017a.hR()) {
                case 4:
                    return this.mValue;
                case 5:
                    return this.XL;
                case 6:
                    return Integer.valueOf(this.Gt);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c1017a.hR());
            }
        }

        public int describeContents() {
            ps psVar = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1430h)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1430h c1430h = (C1430h) obj;
            for (C1017a c1017a : aom.values()) {
                if (mo3354a(c1017a)) {
                    if (!c1430h.mo3354a(c1017a)) {
                        return false;
                    }
                    if (!mo3355b(c1017a).equals(c1430h.mo3355b(c1017a))) {
                        return false;
                    }
                } else if (c1430h.mo3354a(c1017a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return oV();
        }

        public String getLabel() {
            return this.XL;
        }

        public int getType() {
            return this.Gt;
        }

        public String getValue() {
            return this.mValue;
        }

        public HashMap<String, C1017a<?, ?>> hK() {
            return aom;
        }

        public boolean hasLabel() {
            return this.aon.contains(Integer.valueOf(5));
        }

        public boolean hasType() {
            return this.aon.contains(Integer.valueOf(6));
        }

        public boolean hasValue() {
            return this.aon.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            for (C1017a c1017a : aom.values()) {
                int hashCode;
                if (mo3354a(c1017a)) {
                    hashCode = mo3355b(c1017a).hashCode() + (i + c1017a.hR());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        @Deprecated
        public int oU() {
            return 4;
        }

        public C1430h oV() {
            return this;
        }

        public void writeToParcel(Parcel out, int flags) {
            ps psVar = CREATOR;
            ps.m1781a(this, out, flags);
        }
    }

    static {
        aom.put("aboutMe", C1017a.m3384l("aboutMe", 2));
        aom.put("ageRange", C1017a.m3378a("ageRange", 3, C1422a.class));
        aom.put("birthday", C1017a.m3384l("birthday", 4));
        aom.put("braggingRights", C1017a.m3384l("braggingRights", 5));
        aom.put("circledByCount", C1017a.m3381i("circledByCount", 6));
        aom.put("cover", C1017a.m3378a("cover", 7, C1425b.class));
        aom.put("currentLocation", C1017a.m3384l("currentLocation", 8));
        aom.put("displayName", C1017a.m3384l("displayName", 9));
        aom.put("gender", C1017a.m3377a("gender", 12, new ko().m3376h("male", 0).m3376h("female", 1).m3376h(FitnessActivities.OTHER, 2), false));
        aom.put("id", C1017a.m3384l("id", 14));
        aom.put("image", C1017a.m3378a("image", 15, C1426c.class));
        aom.put("isPlusUser", C1017a.m3383k("isPlusUser", 16));
        aom.put("language", C1017a.m3384l("language", 18));
        aom.put("name", C1017a.m3378a("name", 19, C1427d.class));
        aom.put("nickname", C1017a.m3384l("nickname", 20));
        aom.put("objectType", C1017a.m3377a("objectType", 21, new ko().m3376h("person", 0).m3376h("page", 1), false));
        aom.put("organizations", C1017a.m3379b("organizations", 22, C1428f.class));
        aom.put("placesLived", C1017a.m3379b("placesLived", 23, C1429g.class));
        aom.put("plusOneCount", C1017a.m3381i("plusOneCount", 24));
        aom.put("relationshipStatus", C1017a.m3377a("relationshipStatus", 25, new ko().m3376h("single", 0).m3376h("in_a_relationship", 1).m3376h("engaged", 2).m3376h("married", 3).m3376h("its_complicated", 4).m3376h("open_relationship", 5).m3376h("widowed", 6).m3376h("in_domestic_partnership", 7).m3376h("in_civil_union", 8), false));
        aom.put("tagline", C1017a.m3384l("tagline", 26));
        aom.put(PlusShare.KEY_CALL_TO_ACTION_URL, C1017a.m3384l(PlusShare.KEY_CALL_TO_ACTION_URL, 27));
        aom.put("urls", C1017a.m3379b("urls", 28, C1430h.class));
        aom.put("verified", C1017a.m3383k("verified", 29));
    }

    public pi() {
        this.CK = 1;
        this.aon = new HashSet();
    }

    public pi(String str, String str2, C1426c c1426c, int i, String str3) {
        this.CK = 1;
        this.aon = new HashSet();
        this.OS = str;
        this.aon.add(Integer.valueOf(9));
        this.CE = str2;
        this.aon.add(Integer.valueOf(14));
        this.aps = c1426c;
        this.aon.add(Integer.valueOf(15));
        this.apw = i;
        this.aon.add(Integer.valueOf(21));
        this.vf = str3;
        this.aon.add(Integer.valueOf(27));
    }

    pi(Set<Integer> set, int i, String str, C1422a c1422a, String str2, String str3, int i2, C1425b c1425b, String str4, String str5, int i3, String str6, C1426c c1426c, boolean z, String str7, C1427d c1427d, String str8, int i4, List<C1428f> list, List<C1429g> list2, int i5, int i6, String str9, String str10, List<C1430h> list3, boolean z2) {
        this.aon = set;
        this.CK = i;
        this.apl = str;
        this.apm = c1422a;
        this.apn = str2;
        this.apo = str3;
        this.app = i2;
        this.apq = c1425b;
        this.apr = str4;
        this.OS = str5;
        this.ow = i3;
        this.CE = str6;
        this.aps = c1426c;
        this.apt = z;
        this.FR = str7;
        this.apu = c1427d;
        this.apv = str8;
        this.apw = i4;
        this.apx = list;
        this.apy = list2;
        this.apz = i5;
        this.apA = i6;
        this.apB = str9;
        this.vf = str10;
        this.apC = list3;
        this.apD = z2;
    }

    /* renamed from: i */
    public static pi m4537i(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        pi dz = CREATOR.dz(obtain);
        obtain.recycle();
        return dz;
    }

    /* renamed from: a */
    protected boolean mo3354a(C1017a c1017a) {
        return this.aon.contains(Integer.valueOf(c1017a.hR()));
    }

    /* renamed from: b */
    protected Object mo3355b(C1017a c1017a) {
        switch (c1017a.hR()) {
            case 2:
                return this.apl;
            case 3:
                return this.apm;
            case 4:
                return this.apn;
            case 5:
                return this.apo;
            case 6:
                return Integer.valueOf(this.app);
            case 7:
                return this.apq;
            case 8:
                return this.apr;
            case 9:
                return this.OS;
            case 12:
                return Integer.valueOf(this.ow);
            case 14:
                return this.CE;
            case 15:
                return this.aps;
            case 16:
                return Boolean.valueOf(this.apt);
            case 18:
                return this.FR;
            case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                return this.apu;
            case 20:
                return this.apv;
            case 21:
                return Integer.valueOf(this.apw);
            case 22:
                return this.apx;
            case 23:
                return this.apy;
            case 24:
                return Integer.valueOf(this.apz);
            case 25:
                return Integer.valueOf(this.apA);
            case 26:
                return this.apB;
            case 27:
                return this.vf;
            case 28:
                return this.apC;
            case 29:
                return Boolean.valueOf(this.apD);
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + c1017a.hR());
        }
    }

    public int describeContents() {
        pj pjVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof pi)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        pi piVar = (pi) obj;
        for (C1017a c1017a : aom.values()) {
            if (mo3354a(c1017a)) {
                if (!piVar.mo3354a(c1017a)) {
                    return false;
                }
                if (!mo3355b(c1017a).equals(piVar.mo3355b(c1017a))) {
                    return false;
                }
            } else if (piVar.mo3354a(c1017a)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return oL();
    }

    public String getAboutMe() {
        return this.apl;
    }

    public AgeRange getAgeRange() {
        return this.apm;
    }

    public String getBirthday() {
        return this.apn;
    }

    public String getBraggingRights() {
        return this.apo;
    }

    public int getCircledByCount() {
        return this.app;
    }

    public Cover getCover() {
        return this.apq;
    }

    public String getCurrentLocation() {
        return this.apr;
    }

    public String getDisplayName() {
        return this.OS;
    }

    public int getGender() {
        return this.ow;
    }

    public String getId() {
        return this.CE;
    }

    public Image getImage() {
        return this.aps;
    }

    public String getLanguage() {
        return this.FR;
    }

    public Name getName() {
        return this.apu;
    }

    public String getNickname() {
        return this.apv;
    }

    public int getObjectType() {
        return this.apw;
    }

    public List<Organizations> getOrganizations() {
        return (ArrayList) this.apx;
    }

    public List<PlacesLived> getPlacesLived() {
        return (ArrayList) this.apy;
    }

    public int getPlusOneCount() {
        return this.apz;
    }

    public int getRelationshipStatus() {
        return this.apA;
    }

    public String getTagline() {
        return this.apB;
    }

    public String getUrl() {
        return this.vf;
    }

    public List<Urls> getUrls() {
        return (ArrayList) this.apC;
    }

    public HashMap<String, C1017a<?, ?>> hK() {
        return aom;
    }

    public boolean hasAboutMe() {
        return this.aon.contains(Integer.valueOf(2));
    }

    public boolean hasAgeRange() {
        return this.aon.contains(Integer.valueOf(3));
    }

    public boolean hasBirthday() {
        return this.aon.contains(Integer.valueOf(4));
    }

    public boolean hasBraggingRights() {
        return this.aon.contains(Integer.valueOf(5));
    }

    public boolean hasCircledByCount() {
        return this.aon.contains(Integer.valueOf(6));
    }

    public boolean hasCover() {
        return this.aon.contains(Integer.valueOf(7));
    }

    public boolean hasCurrentLocation() {
        return this.aon.contains(Integer.valueOf(8));
    }

    public boolean hasDisplayName() {
        return this.aon.contains(Integer.valueOf(9));
    }

    public boolean hasGender() {
        return this.aon.contains(Integer.valueOf(12));
    }

    public boolean hasId() {
        return this.aon.contains(Integer.valueOf(14));
    }

    public boolean hasImage() {
        return this.aon.contains(Integer.valueOf(15));
    }

    public boolean hasIsPlusUser() {
        return this.aon.contains(Integer.valueOf(16));
    }

    public boolean hasLanguage() {
        return this.aon.contains(Integer.valueOf(18));
    }

    public boolean hasName() {
        return this.aon.contains(Integer.valueOf(19));
    }

    public boolean hasNickname() {
        return this.aon.contains(Integer.valueOf(20));
    }

    public boolean hasObjectType() {
        return this.aon.contains(Integer.valueOf(21));
    }

    public boolean hasOrganizations() {
        return this.aon.contains(Integer.valueOf(22));
    }

    public boolean hasPlacesLived() {
        return this.aon.contains(Integer.valueOf(23));
    }

    public boolean hasPlusOneCount() {
        return this.aon.contains(Integer.valueOf(24));
    }

    public boolean hasRelationshipStatus() {
        return this.aon.contains(Integer.valueOf(25));
    }

    public boolean hasTagline() {
        return this.aon.contains(Integer.valueOf(26));
    }

    public boolean hasUrl() {
        return this.aon.contains(Integer.valueOf(27));
    }

    public boolean hasUrls() {
        return this.aon.contains(Integer.valueOf(28));
    }

    public boolean hasVerified() {
        return this.aon.contains(Integer.valueOf(29));
    }

    public int hashCode() {
        int i = 0;
        for (C1017a c1017a : aom.values()) {
            int hashCode;
            if (mo3354a(c1017a)) {
                hashCode = mo3355b(c1017a).hashCode() + (i + c1017a.hR());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isPlusUser() {
        return this.apt;
    }

    public boolean isVerified() {
        return this.apD;
    }

    public pi oL() {
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        pj pjVar = CREATOR;
        pj.m1772a(this, out, flags);
    }
}
