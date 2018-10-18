package com.google.android.gms.dynamic;

import android.os.IBinder;
import com.google.android.gms.dynamic.C0272d.C0871a;
import java.lang.reflect.Field;

/* renamed from: com.google.android.gms.dynamic.e */
public final class C1332e<T> extends C0871a {
    private final T TH;

    private C1332e(T t) {
        this.TH = t;
    }

    /* renamed from: f */
    public static <T> T m4012f(C0272d c0272d) {
        if (c0272d instanceof C1332e) {
            return ((C1332e) c0272d).TH;
        }
        IBinder asBinder = c0272d.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        if (declaredFields.length == 1) {
            Field field = declaredFields[0];
            if (field.isAccessible()) {
                throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
            }
            field.setAccessible(true);
            try {
                return field.get(asBinder);
            } catch (Throwable e) {
                throw new IllegalArgumentException("Binder object is null.", e);
            } catch (Throwable e2) {
                throw new IllegalArgumentException("remoteBinder is the wrong class.", e2);
            } catch (Throwable e22) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e22);
            }
        }
        throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
    }

    /* renamed from: k */
    public static <T> C0272d m4013k(T t) {
        return new C1332e(t);
    }
}
