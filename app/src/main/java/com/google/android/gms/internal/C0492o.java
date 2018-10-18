package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.o */
public class C0492o {
    private final SecureRandom kZ;
    private final C0487m ky;

    /* renamed from: com.google.android.gms.internal.o$a */
    public class C0491a extends Exception {
        final /* synthetic */ C0492o la;

        public C0491a(C0492o c0492o) {
            this.la = c0492o;
        }

        public C0491a(C0492o c0492o, Throwable th) {
            this.la = c0492o;
            super(th);
        }
    }

    public C0492o(C0487m c0487m, SecureRandom secureRandom) {
        this.ky = c0487m;
        this.kZ = secureRandom;
    }

    /* renamed from: c */
    static void m1749c(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 68);
        }
    }

    /* renamed from: b */
    public byte[] m1750b(String str) throws C0491a {
        try {
            byte[] a = this.ky.mo1764a(str, false);
            if (a.length != 32) {
                throw new C0491a(this);
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(a, 4, 16).get(bArr);
            C0492o.m1749c(bArr);
            return bArr;
        } catch (Throwable e) {
            throw new C0491a(this, e);
        }
    }

    /* renamed from: c */
    public byte[] m1751c(byte[] bArr, String str) throws C0491a {
        if (bArr.length != 16) {
            throw new C0491a(this);
        }
        try {
            byte[] a = this.ky.mo1764a(str, false);
            if (a.length <= 16) {
                throw new C0491a(this);
            }
            ByteBuffer allocate = ByteBuffer.allocate(a.length);
            allocate.put(a);
            allocate.flip();
            byte[] bArr2 = new byte[16];
            a = new byte[(a.length - 16)];
            allocate.get(bArr2);
            allocate.get(a);
            Key secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, new IvParameterSpec(bArr2));
            return instance.doFinal(a);
        } catch (Throwable e) {
            throw new C0491a(this, e);
        } catch (Throwable e2) {
            throw new C0491a(this, e2);
        } catch (Throwable e22) {
            throw new C0491a(this, e22);
        } catch (Throwable e222) {
            throw new C0491a(this, e222);
        } catch (Throwable e2222) {
            throw new C0491a(this, e2222);
        } catch (Throwable e22222) {
            throw new C0491a(this, e22222);
        } catch (Throwable e222222) {
            throw new C0491a(this, e222222);
        }
    }
}
