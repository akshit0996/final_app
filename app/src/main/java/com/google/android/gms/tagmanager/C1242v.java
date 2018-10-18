package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.internal.ld;
import com.google.android.gms.internal.lf;
import com.google.android.gms.tagmanager.DataLayer.C0600a;
import com.google.android.gms.tagmanager.DataLayer.C0603c;
import com.google.android.gms.tagmanager.DataLayer.C0603c.C0602a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* renamed from: com.google.android.gms.tagmanager.v */
class C1242v implements C0603c {
    private static final String ara = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", "value", "expires"});
    private final Executor arb;
    private C0651a arc;
    private int ard;
    private final Context mContext;
    private ld wb;

    /* renamed from: com.google.android.gms.tagmanager.v$a */
    class C0651a extends SQLiteOpenHelper {
        final /* synthetic */ C1242v arg;

        C0651a(C1242v c1242v, Context context, String str) {
            this.arg = c1242v;
            super(context, str, null, 1);
        }

        /* renamed from: a */
        private void m2215a(SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
            Set hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                if (!hashSet.remove("key") || !hashSet.remove("value") || !hashSet.remove("ID") || !hashSet.remove("expires")) {
                    throw new SQLiteException("Database column missing");
                } else if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
            } finally {
                rawQuery.close();
            }
        }

        /* renamed from: a */
        private boolean m2216a(String str, SQLiteDatabase sQLiteDatabase) {
            Cursor cursor;
            Throwable th;
            Cursor cursor2 = null;
            try {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                Cursor query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean moveToFirst = query.moveToFirst();
                    if (query == null) {
                        return moveToFirst;
                    }
                    query.close();
                    return moveToFirst;
                } catch (SQLiteException e) {
                    cursor = query;
                    try {
                        bh.m2117W("Error querying for table " + str);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        cursor2 = cursor;
                        th = th2;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor2 = query;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                cursor = null;
                bh.m2117W("Error querying for table " + str);
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } catch (Throwable th4) {
                th = th4;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        }

        public SQLiteDatabase getWritableDatabase() {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                this.arg.mContext.getDatabasePath("google_tagmanager.db").delete();
            }
            return sQLiteDatabase == null ? super.getWritableDatabase() : sQLiteDatabase;
        }

        public void onCreate(SQLiteDatabase db) {
            ak.ag(db.getPath());
        }

        public void onOpen(SQLiteDatabase db) {
            if (VERSION.SDK_INT < 15) {
                Cursor rawQuery = db.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            if (m2216a("datalayer", db)) {
                m2215a(db);
            } else {
                db.execSQL(C1242v.ara);
            }
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.v$b */
    private static class C0652b {
        final String KP;
        final byte[] arj;

        C0652b(String str, byte[] bArr) {
            this.KP = str;
            this.arj = bArr;
        }

        public String toString() {
            return "KeyAndSerialized: key = " + this.KP + " serialized hash = " + Arrays.hashCode(this.arj);
        }
    }

    public C1242v(Context context) {
        this(context, lf.m3403if(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
    }

    C1242v(Context context, ld ldVar, String str, int i, Executor executor) {
        this.mContext = context;
        this.wb = ldVar;
        this.ard = i;
        this.arb = executor;
        this.arc = new C0651a(this, this.mContext, str);
    }

    private SQLiteDatabase al(String str) {
        try {
            return this.arc.getWritableDatabase();
        } catch (SQLiteException e) {
            bh.m2117W(str);
            return null;
        }
    }

    /* renamed from: b */
    private synchronized void m3780b(List<C0652b> list, long j) {
        try {
            long currentTimeMillis = this.wb.currentTimeMillis();
            m3787x(currentTimeMillis);
            fI(list.size());
            m3781c(list, currentTimeMillis + j);
            pC();
        } catch (Throwable th) {
            pC();
        }
    }

    /* renamed from: c */
    private void m3781c(List<C0652b> list, long j) {
        SQLiteDatabase al = al("Error opening database for writeEntryToDatabase.");
        if (al != null) {
            for (C0652b c0652b : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("expires", Long.valueOf(j));
                contentValues.put("key", c0652b.KP);
                contentValues.put("value", c0652b.arj);
                al.insert("datalayer", null, contentValues);
            }
        }
    }

    private void cA(String str) {
        SQLiteDatabase al = al("Error opening database for clearKeysWithPrefix.");
        if (al != null) {
            try {
                bh.m2116V("Cleared " + al.delete("datalayer", "key = ? OR key LIKE ?", new String[]{str, str + ".%"}) + " items");
            } catch (SQLiteException e) {
                bh.m2117W("Error deleting entries with key prefix: " + str + " (" + e + ").");
            } finally {
                pC();
            }
        }
    }

    private void fI(int i) {
        int pB = (pB() - this.ard) + i;
        if (pB > 0) {
            List fJ = fJ(pB);
            bh.m2115U("DataLayer store full, deleting " + fJ.size() + " entries to make room.");
            m3782h((String[]) fJ.toArray(new String[0]));
        }
    }

    private List<String> fJ(int i) {
        SQLiteException e;
        Throwable th;
        List<String> arrayList = new ArrayList();
        if (i <= 0) {
            bh.m2117W("Invalid maxEntries specified. Skipping.");
            return arrayList;
        }
        SQLiteDatabase al = al("Error opening database for peekEntryIds.");
        if (al == null) {
            return arrayList;
        }
        Cursor query;
        try {
            query = al.query("datalayer", new String[]{"ID"}, null, null, null, null, String.format("%s ASC", new Object[]{"ID"}), Integer.toString(i));
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(String.valueOf(query.getLong(0)));
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    bh.m2117W("Error in peekEntries fetching entryIds: " + e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            bh.m2117W("Error in peekEntries fetching entryIds: " + e.getMessage());
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return arrayList;
    }

    /* renamed from: h */
    private void m3782h(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            SQLiteDatabase al = al("Error opening database for deleteEntries.");
            if (al != null) {
                try {
                    al.delete("datalayer", String.format("%s in (%s)", new Object[]{"ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                } catch (SQLiteException e) {
                    bh.m2117W("Error deleting entries " + Arrays.toString(strArr));
                }
            }
        }
    }

    /* renamed from: i */
    private List<C0600a> m3783i(List<C0652b> list) {
        List<C0600a> arrayList = new ArrayList();
        for (C0652b c0652b : list) {
            arrayList.add(new C0600a(c0652b.KP, m3784j(c0652b.arj)));
        }
        return arrayList;
    }

    /* renamed from: j */
    private Object m3784j(byte[] bArr) {
        ObjectInputStream objectInputStream;
        Object readObject;
        Throwable th;
        ObjectInputStream objectInputStream2 = null;
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                readObject = objectInputStream.readObject();
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e) {
                    }
                }
                byteArrayInputStream.close();
            } catch (IOException e2) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (ClassNotFoundException e4) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e5) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (Throwable th2) {
                th = th2;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e6) {
                        throw th;
                    }
                }
                byteArrayInputStream.close();
                throw th;
            }
        } catch (IOException e7) {
            objectInputStream = objectInputStream2;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (ClassNotFoundException e8) {
            objectInputStream = objectInputStream2;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectInputStream = objectInputStream2;
            th = th4;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            throw th;
        }
        return readObject;
    }

    /* renamed from: j */
    private List<C0652b> m3785j(List<C0600a> list) {
        List<C0652b> arrayList = new ArrayList();
        for (C0600a c0600a : list) {
            arrayList.add(new C0652b(c0600a.KP, m3786m(c0600a.wF)));
        }
        return arrayList;
    }

    /* renamed from: m */
    private byte[] m3786m(Object obj) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        byte[] bArr = null;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                bArr = byteArrayOutputStream.toByteArray();
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e) {
                    }
                }
                byteArrayOutputStream.close();
            } catch (IOException e2) {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayOutputStream.close();
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e4) {
                        throw th;
                    }
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e5) {
            objectOutputStream = bArr;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            return bArr;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectOutputStream = bArr;
            th = th4;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            throw th;
        }
        return bArr;
    }

    private List<C0652b> pA() {
        SQLiteDatabase al = al("Error opening database for loadSerialized.");
        List<C0652b> arrayList = new ArrayList();
        if (al == null) {
            return arrayList;
        }
        Cursor query = al.query("datalayer", new String[]{"key", "value"}, null, null, null, null, "ID", null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new C0652b(query.getString(0), query.getBlob(1)));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    private int pB() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase al = al("Error opening database for getNumStoredEntries.");
        if (al != null) {
            try {
                cursor = al.rawQuery("SELECT COUNT(*) from datalayer", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                bh.m2117W("Error getting numStoredEntries");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return i;
    }

    private void pC() {
        try {
            this.arc.close();
        } catch (SQLiteException e) {
        }
    }

    private List<C0600a> pz() {
        try {
            m3787x(this.wb.currentTimeMillis());
            List<C0600a> i = m3783i(pA());
            return i;
        } finally {
            pC();
        }
    }

    /* renamed from: x */
    private void m3787x(long j) {
        SQLiteDatabase al = al("Error opening database for deleteOlderThan.");
        if (al != null) {
            try {
                bh.m2116V("Deleted " + al.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)}) + " expired items");
            } catch (SQLiteException e) {
                bh.m2117W("Error deleting old entries.");
            }
        }
    }

    /* renamed from: a */
    public void mo2506a(final C0602a c0602a) {
        this.arb.execute(new Runnable(this) {
            final /* synthetic */ C1242v arg;

            public void run() {
                c0602a.mo2509h(this.arg.pz());
            }
        });
    }

    /* renamed from: a */
    public void mo2507a(List<C0600a> list, final long j) {
        final List j2 = m3785j((List) list);
        this.arb.execute(new Runnable(this) {
            final /* synthetic */ C1242v arg;

            public void run() {
                this.arg.m3780b(j2, j);
            }
        });
    }

    public void cz(final String str) {
        this.arb.execute(new Runnable(this) {
            final /* synthetic */ C1242v arg;

            public void run() {
                this.arg.cA(str);
            }
        });
    }
}
