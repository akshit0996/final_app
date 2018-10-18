package com.google.android.gms.internal;

import com.google.android.gms.common.data.C0810a;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.C1324b;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.C1326b;
import com.google.android.gms.drive.metadata.internal.C1328g;
import com.google.android.gms.drive.metadata.internal.C1329j;
import com.google.android.gms.drive.metadata.internal.C1330l;
import com.google.android.gms.drive.metadata.internal.C1506i;
import com.google.android.gms.drive.metadata.internal.C1507k;
import com.google.android.gms.drive.metadata.internal.C1508m;
import com.google.android.gms.plus.PlusShare;
import java.util.Collections;

public class ln {
    public static final C1520c RA = new C1520c("mimeType", 4100000);
    public static final MetadataField<String> RB = new C1330l("originalFilename", 4300000);
    public static final C1324b<String> RC = new C1507k("ownerNames", 4300000);
    public static final C1508m RD = new C1508m("lastModifyingUser", 6000000);
    public static final C1508m RE = new C1508m("sharingUser", 6000000);
    public static final C1563d RF = new C1563d("parents", 4100000);
    public static final C1521e RG = new C1521e("quotaBytesUsed", 4300000);
    public static final C1522f RH = new C1522f("starred", 4100000);
    public static final MetadataField<C0810a> RI = new C1329j<C0810a>("thumbnail", Collections.emptySet(), Collections.emptySet(), 4400000) {
        /* renamed from: c */
        protected /* synthetic */ Object mo2983c(DataHolder dataHolder, int i, int i2) {
            return m4936k(dataHolder, i, i2);
        }

        /* renamed from: k */
        protected C0810a m4936k(DataHolder dataHolder, int i, int i2) {
            throw new IllegalStateException("Thumbnail field is write only");
        }
    };
    public static final C1523g RJ = new C1523g(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 4100000);
    public static final C1524h RK = new C1524h("trashed", 4100000);
    public static final MetadataField<String> RL = new C1330l("webContentLink", 4300000);
    public static final MetadataField<String> RM = new C1330l("webViewLink", 4300000);
    public static final MetadataField<String> RN = new C1330l("uniqueIdentifier", 5000000);
    public static final C1326b RO = new C1326b("writersCanShare", 6000000);
    public static final MetadataField<String> RP = new C1330l("role", 6000000);
    public static final MetadataField<DriveId> Rj = lq.RV;
    public static final MetadataField<String> Rk = new C1330l("alternateLink", 4300000);
    public static final C1562a Rl = new C1562a(5000000);
    public static final MetadataField<String> Rm = new C1330l(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 4300000);
    public static final MetadataField<String> Rn = new C1330l("embedLink", 4300000);
    public static final MetadataField<String> Ro = new C1330l("fileExtension", 4300000);
    public static final MetadataField<Long> Rp = new C1328g("fileSize", 4300000);
    public static final MetadataField<Boolean> Rq = new C1326b("hasThumbnail", 4300000);
    public static final MetadataField<String> Rr = new C1330l("indexableText", 4300000);
    public static final MetadataField<Boolean> Rs = new C1326b("isAppData", 4300000);
    public static final MetadataField<Boolean> Rt = new C1326b("isCopyable", 4300000);
    public static final MetadataField<Boolean> Ru = new C1326b("isEditable", 4100000);
    public static final C1519b Rv = new C1519b("isPinned", 4100000);
    public static final MetadataField<Boolean> Rw = new C1326b("isRestricted", 4300000);
    public static final MetadataField<Boolean> Rx = new C1326b("isShared", 4300000);
    public static final MetadataField<Boolean> Ry = new C1326b("isTrashable", 4400000);
    public static final MetadataField<Boolean> Rz = new C1326b("isViewed", 4300000);

    /* renamed from: com.google.android.gms.internal.ln$b */
    public static class C1519b extends C1326b implements SearchableMetadataField<Boolean> {
        public C1519b(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.ln$c */
    public static class C1520c extends C1330l implements SearchableMetadataField<String> {
        public C1520c(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.ln$e */
    public static class C1521e extends C1328g implements SortableMetadataField<Long> {
        public C1521e(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.ln$f */
    public static class C1522f extends C1326b implements SearchableMetadataField<Boolean> {
        public C1522f(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.ln$g */
    public static class C1523g extends C1330l implements SearchableMetadataField<String>, SortableMetadataField<String> {
        public C1523g(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.ln$h */
    public static class C1524h extends C1326b implements SearchableMetadataField<Boolean> {
        public C1524h(String str, int i) {
            super(str, i);
        }

        /* renamed from: c */
        protected /* synthetic */ Object mo2983c(DataHolder dataHolder, int i, int i2) {
            return mo3692e(dataHolder, i, i2);
        }

        /* renamed from: e */
        protected Boolean mo3692e(DataHolder dataHolder, int i, int i2) {
            return Boolean.valueOf(dataHolder.m2492b(getName(), i, i2) != 0);
        }
    }

    /* renamed from: com.google.android.gms.internal.ln$a */
    public static class C1562a extends lo implements SearchableMetadataField<AppVisibleCustomProperties> {
        public C1562a(int i) {
            super(i);
        }
    }

    /* renamed from: com.google.android.gms.internal.ln$d */
    public static class C1563d extends C1506i<DriveId> implements SearchableCollectionMetadataField<DriveId> {
        public C1563d(String str, int i) {
            super(str, i);
        }
    }
}
