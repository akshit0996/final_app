package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0361a;
import com.google.android.gms.internal.C0378b;
import com.google.android.gms.internal.C0386d.C1389a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

class ao extends aj {
    private static final String ID = C0361a.HASH.toString();
    private static final String arp = C0378b.ARG0.toString();
    private static final String arr = C0378b.INPUT_FORMAT.toString();
    private static final String arv = C0378b.ALGORITHM.toString();

    public ao() {
        super(ID, arp);
    }

    /* renamed from: d */
    private byte[] m3677d(String str, byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance(str);
        instance.update(bArr);
        return instance.digest();
    }

    /* renamed from: B */
    public C1389a mo2513B(Map<String, C1389a> map) {
        C1389a c1389a = (C1389a) map.get(arp);
        if (c1389a == null || c1389a == di.rb()) {
            return di.rb();
        }
        byte[] bytes;
        String j = di.m2191j(c1389a);
        c1389a = (C1389a) map.get(arv);
        String j2 = c1389a == null ? "MD5" : di.m2191j(c1389a);
        c1389a = (C1389a) map.get(arr);
        String j3 = c1389a == null ? "text" : di.m2191j(c1389a);
        if ("text".equals(j3)) {
            bytes = j.getBytes();
        } else if ("base16".equals(j3)) {
            bytes = C0638j.co(j);
        } else {
            bh.m2114T("Hash: unknown input format: " + j3);
            return di.rb();
        }
        try {
            return di.m2202u(C0638j.m2210d(m3677d(j2, bytes)));
        } catch (NoSuchAlgorithmException e) {
            bh.m2114T("Hash: unknown algorithm: " + j2);
            return di.rb();
        }
    }

    public boolean pe() {
        return true;
    }
}
