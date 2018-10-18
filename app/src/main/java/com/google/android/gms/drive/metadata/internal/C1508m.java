package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.UserMetadata;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/* renamed from: com.google.android.gms.drive.metadata.internal.m */
public class C1508m extends C1329j<UserMetadata> {
    public C1508m(String str, int i) {
        super(str, C1508m.bp(str), Collections.emptyList(), i);
    }

    private String bo(String str) {
        return C1508m.m4790q(getName(), str);
    }

    private static Collection<String> bp(String str) {
        return Arrays.asList(new String[]{C1508m.m4790q(str, "permissionId"), C1508m.m4790q(str, "displayName"), C1508m.m4790q(str, "picture"), C1508m.m4790q(str, "isAuthenticatedUser"), C1508m.m4790q(str, "emailAddress")});
    }

    /* renamed from: q */
    private static String m4790q(String str, String str2) {
        return "." + str2;
    }

    /* renamed from: b */
    protected boolean mo3684b(DataHolder dataHolder, int i, int i2) {
        return !dataHolder.m2499h(bo("permissionId"), i, i2);
    }

    /* renamed from: c */
    protected /* synthetic */ Object mo2983c(DataHolder dataHolder, int i, int i2) {
        return m4793j(dataHolder, i, i2);
    }

    /* renamed from: j */
    protected UserMetadata m4793j(DataHolder dataHolder, int i, int i2) {
        String c = dataHolder.m2493c(bo("permissionId"), i, i2);
        if (c == null) {
            return null;
        }
        String c2 = dataHolder.m2493c(bo("displayName"), i, i2);
        String c3 = dataHolder.m2493c(bo("picture"), i, i2);
        Boolean valueOf = Boolean.valueOf(dataHolder.m2494d(bo("isAuthenticatedUser"), i, i2));
        return new UserMetadata(c, c2, c3, valueOf.booleanValue(), dataHolder.m2493c(bo("emailAddress"), i, i2));
    }
}
