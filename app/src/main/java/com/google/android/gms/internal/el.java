package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Base64;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.X509EncodedKeySpec;

@ey
public class el {
    /* renamed from: F */
    public static PublicKey m1174F(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            gr.m1338T("Invalid key specification.");
            throw new IllegalArgumentException(e2);
        }
    }

    /* renamed from: a */
    public static boolean m1175a(PublicKey publicKey, String str, String str2) {
        try {
            Signature instance = Signature.getInstance("SHA1withRSA");
            instance.initVerify(publicKey);
            instance.update(str.getBytes());
            if (instance.verify(Base64.decode(str2, 0))) {
                return true;
            }
            gr.m1338T("Signature verification failed.");
            return false;
        } catch (NoSuchAlgorithmException e) {
            gr.m1338T("NoSuchAlgorithmException.");
            return false;
        } catch (InvalidKeyException e2) {
            gr.m1338T("Invalid key specification.");
            return false;
        } catch (SignatureException e3) {
            gr.m1338T("Signature exception.");
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m1176b(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            return m1175a(m1174F(str), str2, str3);
        }
        gr.m1338T("Purchase verification failed: missing data.");
        return false;
    }
}
