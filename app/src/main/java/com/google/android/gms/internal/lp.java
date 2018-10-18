package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.C1505d;
import java.util.Date;

public class lp {
    public static final C1564a RQ = new C1564a("created", 4100000);
    public static final C1565b RR = new C1565b("lastOpenedTime", 4300000);
    public static final C1567d RS = new C1567d("modified", 4100000);
    public static final C1566c RT = new C1566c("modifiedByMe", 4100000);
    public static final C1568e RU = new C1568e("sharedWithMe", 4100000);

    /* renamed from: com.google.android.gms.internal.lp$a */
    public static class C1564a extends C1505d implements SortableMetadataField<Date> {
        public C1564a(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.lp$b */
    public static class C1565b extends C1505d implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public C1565b(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.lp$c */
    public static class C1566c extends C1505d implements SortableMetadataField<Date> {
        public C1566c(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.lp$d */
    public static class C1567d extends C1505d implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public C1567d(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.lp$e */
    public static class C1568e extends C1505d implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public C1568e(String str, int i) {
            super(str, i);
        }
    }
}
