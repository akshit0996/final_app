package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.internal.view.SupportMenu;
import java.util.List;

/* renamed from: com.google.android.gms.common.internal.safeparcel.b */
public class C0186b {
    /* renamed from: F */
    private static int m241F(Parcel parcel, int i) {
        parcel.writeInt(SupportMenu.CATEGORY_MASK | i);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    /* renamed from: G */
    private static void m242G(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        int i2 = dataPosition - i;
        parcel.setDataPosition(i - 4);
        parcel.writeInt(i2);
        parcel.setDataPosition(dataPosition);
    }

    /* renamed from: H */
    public static int m243H(Parcel parcel) {
        return C0186b.m241F(parcel, 20293);
    }

    /* renamed from: H */
    public static void m244H(Parcel parcel, int i) {
        C0186b.m242G(parcel, i);
    }

    /* renamed from: a */
    public static void m245a(Parcel parcel, int i, byte b) {
        C0186b.m266b(parcel, i, 4);
        parcel.writeInt(b);
    }

    /* renamed from: a */
    public static void m246a(Parcel parcel, int i, double d) {
        C0186b.m266b(parcel, i, 8);
        parcel.writeDouble(d);
    }

    /* renamed from: a */
    public static void m247a(Parcel parcel, int i, float f) {
        C0186b.m266b(parcel, i, 4);
        parcel.writeFloat(f);
    }

    /* renamed from: a */
    public static void m248a(Parcel parcel, int i, long j) {
        C0186b.m266b(parcel, i, 8);
        parcel.writeLong(j);
    }

    /* renamed from: a */
    public static void m249a(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int F = C0186b.m241F(parcel, i);
            parcel.writeBundle(bundle);
            C0186b.m242G(parcel, F);
        } else if (z) {
            C0186b.m266b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m250a(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int F = C0186b.m241F(parcel, i);
            parcel.writeStrongBinder(iBinder);
            C0186b.m242G(parcel, F);
        } else if (z) {
            C0186b.m266b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m251a(Parcel parcel, int i, Parcel parcel2, boolean z) {
        if (parcel2 != null) {
            int F = C0186b.m241F(parcel, i);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            C0186b.m242G(parcel, F);
        } else if (z) {
            C0186b.m266b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m252a(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int F = C0186b.m241F(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            C0186b.m242G(parcel, F);
        } else if (z) {
            C0186b.m266b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m253a(Parcel parcel, int i, Boolean bool, boolean z) {
        int i2 = 0;
        if (bool != null) {
            C0186b.m266b(parcel, i, 4);
            if (bool.booleanValue()) {
                i2 = 1;
            }
            parcel.writeInt(i2);
        } else if (z) {
            C0186b.m266b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m254a(Parcel parcel, int i, Integer num, boolean z) {
        if (num != null) {
            C0186b.m266b(parcel, i, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            C0186b.m266b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m255a(Parcel parcel, int i, Long l, boolean z) {
        if (l != null) {
            C0186b.m266b(parcel, i, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            C0186b.m266b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m256a(Parcel parcel, int i, String str, boolean z) {
        if (str != null) {
            int F = C0186b.m241F(parcel, i);
            parcel.writeString(str);
            C0186b.m242G(parcel, F);
        } else if (z) {
            C0186b.m266b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m257a(Parcel parcel, int i, List<Integer> list, boolean z) {
        if (list != null) {
            int F = C0186b.m241F(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(((Integer) list.get(i2)).intValue());
            }
            C0186b.m242G(parcel, F);
        } else if (z) {
            C0186b.m266b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m258a(Parcel parcel, int i, short s) {
        C0186b.m266b(parcel, i, 4);
        parcel.writeInt(s);
    }

    /* renamed from: a */
    public static void m259a(Parcel parcel, int i, boolean z) {
        C0186b.m266b(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    /* renamed from: a */
    public static void m260a(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr != null) {
            int F = C0186b.m241F(parcel, i);
            parcel.writeByteArray(bArr);
            C0186b.m242G(parcel, F);
        } else if (z) {
            C0186b.m266b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m261a(Parcel parcel, int i, int[] iArr, boolean z) {
        if (iArr != null) {
            int F = C0186b.m241F(parcel, i);
            parcel.writeIntArray(iArr);
            C0186b.m242G(parcel, F);
        } else if (z) {
            C0186b.m266b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static <T extends Parcelable> void m262a(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr != null) {
            int F = C0186b.m241F(parcel, i);
            parcel.writeInt(r3);
            for (Parcelable parcelable : tArr) {
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    C0186b.m265a(parcel, parcelable, i2);
                }
            }
            C0186b.m242G(parcel, F);
        } else if (z) {
            C0186b.m266b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m263a(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr != null) {
            int F = C0186b.m241F(parcel, i);
            parcel.writeStringArray(strArr);
            C0186b.m242G(parcel, F);
        } else if (z) {
            C0186b.m266b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m264a(Parcel parcel, int i, byte[][] bArr, boolean z) {
        int i2 = 0;
        if (bArr != null) {
            int F = C0186b.m241F(parcel, i);
            int length = bArr.length;
            parcel.writeInt(length);
            while (i2 < length) {
                parcel.writeByteArray(bArr[i2]);
                i2++;
            }
            C0186b.m242G(parcel, F);
        } else if (z) {
            C0186b.m266b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    private static <T extends Parcelable> void m265a(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    /* renamed from: b */
    private static void m266b(Parcel parcel, int i, int i2) {
        if (i2 >= 65535) {
            parcel.writeInt(SupportMenu.CATEGORY_MASK | i);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt((i2 << 16) | i);
    }

    /* renamed from: b */
    public static void m267b(Parcel parcel, int i, List<String> list, boolean z) {
        if (list != null) {
            int F = C0186b.m241F(parcel, i);
            parcel.writeStringList(list);
            C0186b.m242G(parcel, F);
        } else if (z) {
            C0186b.m266b(parcel, i, 0);
        }
    }

    /* renamed from: c */
    public static void m268c(Parcel parcel, int i, int i2) {
        C0186b.m266b(parcel, i, 4);
        parcel.writeInt(i2);
    }

    /* renamed from: c */
    public static <T extends Parcelable> void m269c(Parcel parcel, int i, List<T> list, boolean z) {
        if (list != null) {
            int F = C0186b.m241F(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    C0186b.m265a(parcel, parcelable, 0);
                }
            }
            C0186b.m242G(parcel, F);
        } else if (z) {
            C0186b.m266b(parcel, i, 0);
        }
    }

    /* renamed from: d */
    public static void m270d(Parcel parcel, int i, List list, boolean z) {
        if (list != null) {
            int F = C0186b.m241F(parcel, i);
            parcel.writeList(list);
            C0186b.m242G(parcel, F);
        } else if (z) {
            C0186b.m266b(parcel, i, 0);
        }
    }
}
