package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class qr<M extends qq<M>, T> {
    protected final Class<T> ayX;
    protected final boolean ayY;
    public final int tag;
    protected final int type;

    private qr(int i, Class<T> cls, int i2, boolean z) {
        this.type = i;
        this.ayX = cls;
        this.tag = i2;
        this.ayY = z;
    }

    /* renamed from: a */
    public static <M extends qq<M>, T extends qw> qr<M, T> m1884a(int i, Class<T> cls, int i2) {
        return new qr(i, cls, i2, false);
    }

    /* renamed from: n */
    private T m1885n(List<qy> list) {
        int i;
        int i2 = 0;
        List arrayList = new ArrayList();
        for (i = 0; i < list.size(); i++) {
            qy qyVar = (qy) list.get(i);
            if (qyVar.azi.length != 0) {
                m1890a(qyVar, arrayList);
            }
        }
        i = arrayList.size();
        if (i == 0) {
            return null;
        }
        T cast = this.ayX.cast(Array.newInstance(this.ayX.getComponentType(), i));
        while (i2 < i) {
            Array.set(cast, i2, arrayList.get(i2));
            i2++;
        }
        return cast;
    }

    /* renamed from: o */
    private T m1886o(List<qy> list) {
        if (list.isEmpty()) {
            return null;
        }
        return this.ayX.cast(m1895x(qo.m1833p(((qy) list.get(list.size() - 1)).azi)));
    }

    /* renamed from: B */
    int m1887B(Object obj) {
        return this.ayY ? m1888C(obj) : m1889D(obj);
    }

    /* renamed from: C */
    protected int m1888C(Object obj) {
        int i = 0;
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += m1889D(Array.get(obj, i2));
            }
        }
        return i;
    }

    /* renamed from: D */
    protected int m1889D(Object obj) {
        int hl = qz.hl(this.tag);
        switch (this.type) {
            case 10:
                return qp.m1843b(hl, (qw) obj);
            case 11:
                return qp.m1847c(hl, (qw) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.type);
        }
    }

    /* renamed from: a */
    protected void m1890a(qy qyVar, List<Object> list) {
        list.add(m1895x(qo.m1833p(qyVar.azi)));
    }

    /* renamed from: a */
    void m1891a(Object obj, qp qpVar) throws IOException {
        if (this.ayY) {
            m1893c(obj, qpVar);
        } else {
            m1892b(obj, qpVar);
        }
    }

    /* renamed from: b */
    protected void m1892b(Object obj, qp qpVar) {
        try {
            qpVar.hd(this.tag);
            switch (this.type) {
                case 10:
                    qw qwVar = (qw) obj;
                    int hl = qz.hl(this.tag);
                    qpVar.m1873b(qwVar);
                    qpVar.m1883x(hl, 4);
                    return;
                case 11:
                    qpVar.m1875c((qw) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    /* renamed from: c */
    protected void m1893c(Object obj, qp qpVar) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                m1892b(obj2, qpVar);
            }
        }
    }

    /* renamed from: m */
    final T m1894m(List<qy> list) {
        return list == null ? null : this.ayY ? m1885n(list) : m1886o(list);
    }

    /* renamed from: x */
    protected Object m1895x(qo qoVar) {
        Class componentType = this.ayY ? this.ayX.getComponentType() : this.ayX;
        try {
            qw qwVar;
            switch (this.type) {
                case 10:
                    qwVar = (qw) componentType.newInstance();
                    qoVar.m1835a(qwVar, qz.hl(this.tag));
                    return qwVar;
                case 11:
                    qwVar = (qw) componentType.newInstance();
                    qoVar.m1834a(qwVar);
                    return qwVar;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (Throwable e) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e);
        } catch (Throwable e2) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e2);
        } catch (Throwable e22) {
            throw new IllegalArgumentException("Error reading extension field", e22);
        }
    }
}
