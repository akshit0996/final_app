package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.common.internal.safeparcel.a */
public class C0185a {

    /* renamed from: com.google.android.gms.common.internal.safeparcel.a$a */
    public static class C0184a extends RuntimeException {
        public C0184a(String str, Parcel parcel) {
            super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }

    /* renamed from: A */
    public static String[] m202A(Parcel parcel, int i) {
        int a = C0185a.m209a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(a + dataPosition);
        return createStringArray;
    }

    /* renamed from: B */
    public static ArrayList<Integer> m203B(Parcel parcel, int i) {
        int a = C0185a.m209a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(dataPosition + a);
        return arrayList;
    }

    /* renamed from: C */
    public static ArrayList<String> m204C(Parcel parcel, int i) {
        int a = C0185a.m209a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(a + dataPosition);
        return createStringArrayList;
    }

    /* renamed from: D */
    public static Parcel m205D(Parcel parcel, int i) {
        int a = C0185a.m209a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, a);
        parcel.setDataPosition(a + dataPosition);
        return obtain;
    }

    /* renamed from: E */
    public static Parcel[] m206E(Parcel parcel, int i) {
        int a = C0185a.m209a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        Parcel[] parcelArr = new Parcel[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                parcelArr[i2] = obtain;
                parcel.setDataPosition(readInt2 + dataPosition2);
            } else {
                parcelArr[i2] = null;
            }
        }
        parcel.setDataPosition(dataPosition + a);
        return parcelArr;
    }

    /* renamed from: F */
    public static int m207F(Parcel parcel) {
        return parcel.readInt();
    }

    /* renamed from: G */
    public static int m208G(Parcel parcel) {
        int F = C0185a.m207F(parcel);
        int a = C0185a.m209a(parcel, F);
        int dataPosition = parcel.dataPosition();
        if (C0185a.aH(F) != 20293) {
            throw new C0184a("Expected object header. Got 0x" + Integer.toHexString(F), parcel);
        }
        F = dataPosition + a;
        if (F >= dataPosition && F <= parcel.dataSize()) {
            return F;
        }
        throw new C0184a("Size read is invalid start=" + dataPosition + " end=" + F, parcel);
    }

    /* renamed from: a */
    public static int m209a(Parcel parcel, int i) {
        return (i & SupportMenu.CATEGORY_MASK) != SupportMenu.CATEGORY_MASK ? (i >> 16) & 65535 : parcel.readInt();
    }

    /* renamed from: a */
    public static <T extends Parcelable> T m210a(Parcel parcel, int i, Creator<T> creator) {
        int a = C0185a.m209a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(a + dataPosition);
        return parcelable;
    }

    /* renamed from: a */
    private static void m211a(Parcel parcel, int i, int i2) {
        int a = C0185a.m209a(parcel, i);
        if (a != i2) {
            throw new C0184a("Expected size " + i2 + " got " + a + " (0x" + Integer.toHexString(a) + ")", parcel);
        }
    }

    /* renamed from: a */
    private static void m212a(Parcel parcel, int i, int i2, int i3) {
        if (i2 != i3) {
            throw new C0184a("Expected size " + i3 + " got " + i2 + " (0x" + Integer.toHexString(i2) + ")", parcel);
        }
    }

    /* renamed from: a */
    public static void m213a(Parcel parcel, int i, List list, ClassLoader classLoader) {
        int a = C0185a.m209a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a != 0) {
            parcel.readList(list, classLoader);
            parcel.setDataPosition(a + dataPosition);
        }
    }

    public static int aH(int i) {
        return 65535 & i;
    }

    /* renamed from: b */
    public static void m214b(Parcel parcel, int i) {
        parcel.setDataPosition(C0185a.m209a(parcel, i) + parcel.dataPosition());
    }

    /* renamed from: b */
    public static <T> T[] m215b(Parcel parcel, int i, Creator<T> creator) {
        int a = C0185a.m209a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        T[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArray;
    }

    /* renamed from: c */
    public static <T> ArrayList<T> m216c(Parcel parcel, int i, Creator<T> creator) {
        int a = C0185a.m209a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArrayList;
    }

    /* renamed from: c */
    public static boolean m217c(Parcel parcel, int i) {
        C0185a.m211a(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    /* renamed from: d */
    public static Boolean m218d(Parcel parcel, int i) {
        int a = C0185a.m209a(parcel, i);
        if (a == 0) {
            return null;
        }
        C0185a.m212a(parcel, i, a, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    /* renamed from: e */
    public static byte m219e(Parcel parcel, int i) {
        C0185a.m211a(parcel, i, 4);
        return (byte) parcel.readInt();
    }

    /* renamed from: f */
    public static short m220f(Parcel parcel, int i) {
        C0185a.m211a(parcel, i, 4);
        return (short) parcel.readInt();
    }

    /* renamed from: g */
    public static int m221g(Parcel parcel, int i) {
        C0185a.m211a(parcel, i, 4);
        return parcel.readInt();
    }

    /* renamed from: h */
    public static Integer m222h(Parcel parcel, int i) {
        int a = C0185a.m209a(parcel, i);
        if (a == 0) {
            return null;
        }
        C0185a.m212a(parcel, i, a, 4);
        return Integer.valueOf(parcel.readInt());
    }

    /* renamed from: i */
    public static long m223i(Parcel parcel, int i) {
        C0185a.m211a(parcel, i, 8);
        return parcel.readLong();
    }

    /* renamed from: j */
    public static Long m224j(Parcel parcel, int i) {
        int a = C0185a.m209a(parcel, i);
        if (a == 0) {
            return null;
        }
        C0185a.m212a(parcel, i, a, 8);
        return Long.valueOf(parcel.readLong());
    }

    /* renamed from: k */
    public static BigInteger m225k(Parcel parcel, int i) {
        int a = C0185a.m209a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(a + dataPosition);
        return new BigInteger(createByteArray);
    }

    /* renamed from: l */
    public static float m226l(Parcel parcel, int i) {
        C0185a.m211a(parcel, i, 4);
        return parcel.readFloat();
    }

    /* renamed from: m */
    public static double m227m(Parcel parcel, int i) {
        C0185a.m211a(parcel, i, 8);
        return parcel.readDouble();
    }

    /* renamed from: n */
    public static BigDecimal m228n(Parcel parcel, int i) {
        int a = C0185a.m209a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(a + dataPosition);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    /* renamed from: o */
    public static String m229o(Parcel parcel, int i) {
        int a = C0185a.m209a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(a + dataPosition);
        return readString;
    }

    /* renamed from: p */
    public static IBinder m230p(Parcel parcel, int i) {
        int a = C0185a.m209a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(a + dataPosition);
        return readStrongBinder;
    }

    /* renamed from: q */
    public static Bundle m231q(Parcel parcel, int i) {
        int a = C0185a.m209a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(a + dataPosition);
        return readBundle;
    }

    /* renamed from: r */
    public static byte[] m232r(Parcel parcel, int i) {
        int a = C0185a.m209a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(a + dataPosition);
        return createByteArray;
    }

    /* renamed from: s */
    public static byte[][] m233s(Parcel parcel, int i) {
        int a = C0185a.m209a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return (byte[][]) null;
        }
        int readInt = parcel.readInt();
        byte[][] bArr = new byte[readInt][];
        for (int i2 = 0; i2 < readInt; i2++) {
            bArr[i2] = parcel.createByteArray();
        }
        parcel.setDataPosition(dataPosition + a);
        return bArr;
    }

    /* renamed from: t */
    public static boolean[] m234t(Parcel parcel, int i) {
        int a = C0185a.m209a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(a + dataPosition);
        return createBooleanArray;
    }

    /* renamed from: u */
    public static int[] m235u(Parcel parcel, int i) {
        int a = C0185a.m209a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(a + dataPosition);
        return createIntArray;
    }

    /* renamed from: v */
    public static long[] m236v(Parcel parcel, int i) {
        int a = C0185a.m209a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(a + dataPosition);
        return createLongArray;
    }

    /* renamed from: w */
    public static BigInteger[] m237w(Parcel parcel, int i) {
        int a = C0185a.m209a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            bigIntegerArr[i2] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + a);
        return bigIntegerArr;
    }

    /* renamed from: x */
    public static float[] m238x(Parcel parcel, int i) {
        int a = C0185a.m209a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(a + dataPosition);
        return createFloatArray;
    }

    /* renamed from: y */
    public static double[] m239y(Parcel parcel, int i) {
        int a = C0185a.m209a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        double[] createDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(a + dataPosition);
        return createDoubleArray;
    }

    /* renamed from: z */
    public static BigDecimal[] m240z(Parcel parcel, int i) {
        int a = C0185a.m209a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            byte[] createByteArray = parcel.createByteArray();
            bigDecimalArr[i2] = new BigDecimal(new BigInteger(createByteArray), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + a);
        return bigDecimalArr;
    }
}
