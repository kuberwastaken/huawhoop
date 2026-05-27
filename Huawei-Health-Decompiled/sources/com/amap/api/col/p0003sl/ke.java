package com.amap.api.col.p0003sl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class ke {
    private static Map<Class<? extends kd>, kd> d = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private kh f1173a;
    private SQLiteDatabase b;
    private kd c;

    public static kd a(Class<? extends kd> cls) throws IllegalAccessException, InstantiationException {
        kd kdVar;
        synchronized (ke.class) {
            if (d.get(cls) == null) {
                d.put(cls, cls.newInstance());
            }
            kdVar = d.get(cls);
        }
        return kdVar;
    }

    public ke(Context context, kd kdVar) {
        try {
            this.f1173a = new kh(context.getApplicationContext(), kdVar.b(), kdVar.c(), kdVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.c = kdVar;
    }

    public final <T> void a(String str, Class<T> cls) {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this.c) {
            String strA = a(b((Class) cls));
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            SQLiteDatabase sQLiteDatabaseB = b();
            this.b = sQLiteDatabaseB;
            if (sQLiteDatabaseB == null) {
                return;
            }
            try {
                sQLiteDatabaseB.delete(strA, str, null);
                sQLiteDatabase = this.b;
            } catch (Throwable th) {
                try {
                    js.a(th, "dbs", "dld");
                    sQLiteDatabase = this.b;
                    if (sQLiteDatabase != null) {
                    }
                } catch (Throwable th2) {
                    SQLiteDatabase sQLiteDatabase2 = this.b;
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                        this.b = null;
                    }
                    throw th2;
                }
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
                this.b = null;
            }
        }
    }

    private <T> void a(String str, Object obj) {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this.c) {
            if (obj == null) {
                return;
            }
            kf kfVarB = b((Class) obj.getClass());
            String strA = a(kfVarB);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            ContentValues contentValuesA = a(obj, kfVarB);
            SQLiteDatabase sQLiteDatabaseB = b();
            this.b = sQLiteDatabaseB;
            if (sQLiteDatabaseB == null) {
                return;
            }
            try {
                sQLiteDatabaseB.update(strA, contentValuesA, str, null);
                sQLiteDatabase = this.b;
            } catch (Throwable th) {
                try {
                    js.a(th, "dbs", "udd");
                    sQLiteDatabase = this.b;
                    if (sQLiteDatabase != null) {
                    }
                } catch (Throwable th2) {
                    SQLiteDatabase sQLiteDatabase2 = this.b;
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                        this.b = null;
                    }
                    throw th2;
                }
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
                this.b = null;
            }
        }
    }

    private <T> void b(String str, Object obj) {
        a(str, obj);
    }

    public final void a(Object obj, String str) {
        synchronized (this.c) {
            List listB = b(str, (Class) obj.getClass());
            if (listB == null || listB.size() == 0) {
                a(obj);
            } else {
                b(str, obj);
            }
        }
    }

    private <T> void a(T t) {
        b(t);
    }

    private <T> void b(T t) {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this.c) {
            SQLiteDatabase sQLiteDatabaseB = b();
            this.b = sQLiteDatabaseB;
            if (sQLiteDatabaseB == null) {
                return;
            }
            try {
                a(sQLiteDatabaseB, t);
                sQLiteDatabase = this.b;
            } catch (Throwable th) {
                try {
                    js.a(th, "dbs", "itd");
                    sQLiteDatabase = this.b;
                    if (sQLiteDatabase != null) {
                    }
                } catch (Throwable th2) {
                    SQLiteDatabase sQLiteDatabase2 = this.b;
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                        this.b = null;
                    }
                    throw th2;
                }
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
                this.b = null;
            }
        }
    }

    private static <T> void a(SQLiteDatabase sQLiteDatabase, T t) {
        kf kfVarB = b((Class) t.getClass());
        String strA = a(kfVarB);
        if (TextUtils.isEmpty(strA) || t == null || sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.insert(strA, null, a(t, kfVarB));
    }

    public final <T> void a(List<T> list) {
        synchronized (this.c) {
            if (list.size() == 0) {
                return;
            }
            SQLiteDatabase sQLiteDatabaseB = b();
            this.b = sQLiteDatabaseB;
            if (sQLiteDatabaseB == null) {
                return;
            }
            try {
                try {
                    sQLiteDatabaseB.beginTransaction();
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        a(this.b, it.next());
                    }
                    this.b.setTransactionSuccessful();
                    try {
                        if (this.b.inTransaction()) {
                            this.b.endTransaction();
                        }
                    } catch (Throwable th) {
                        js.a(th, "dbs", "ild");
                    }
                    this.b.close();
                } catch (Throwable th2) {
                    js.a(th2, "dbs", "ild");
                }
            } catch (Throwable th3) {
                try {
                    js.a(th3, "dbs", "ild");
                    try {
                        if (this.b.inTransaction()) {
                            this.b.endTransaction();
                        }
                    } catch (Throwable th4) {
                        js.a(th4, "dbs", "ild");
                    }
                    this.b.close();
                } finally {
                }
            }
            this.b = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:? A[Catch: all -> 0x00d7, DONT_GENERATE, FINALLY_INSNS, SYNTHETIC, TryCatch #5 {, blocks: (B:4:0x0003, B:6:0x0014, B:7:0x001a, B:9:0x001e, B:28:0x005e, B:27:0x0057, B:21:0x0045, B:61:0x00b1, B:60:0x00aa, B:38:0x0075, B:55:0x009b, B:75:0x00d4, B:74:0x00cd, B:68:0x00bb, B:76:0x00d5, B:50:0x008d, B:35:0x0070, B:18:0x0040, B:39:0x007c, B:41:0x0080, B:42:0x0083, B:56:0x00a2, B:58:0x00a6, B:22:0x004c, B:24:0x0050, B:65:0x00b6, B:52:0x0096, B:69:0x00c2, B:71:0x00c6), top: B:91:0x0003, inners: #0, #1, #2, #3, #4, #7, #8, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0050 A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #4 {all -> 0x0056, blocks: (B:22:0x004c, B:24:0x0050), top: B:89:0x004c, outer: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c6 A[Catch: all -> 0x00cc, DONT_GENERATE, FINALLY_INSNS, TRY_LEAVE, TryCatch #10 {all -> 0x00cc, blocks: (B:69:0x00c2, B:71:0x00c6), top: B:98:0x00c2, outer: #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private <T> java.util.List<T> c(java.lang.String r13, java.lang.Class<T> r14) {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.ke.c(java.lang.String, java.lang.Class):java.util.List");
    }

    public final <T> List<T> b(String str, Class<T> cls) {
        return c(str, cls);
    }

    private static <T> T a(Cursor cursor, Class<T> cls, kf kfVar) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        Field[] fieldArrA = a((Class<?>) cls, kfVar.b());
        Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        T tNewInstance = declaredConstructor.newInstance(new Object[0]);
        for (Field field : fieldArrA) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(kg.class);
            if (annotation != null) {
                kg kgVar = (kg) annotation;
                int iB = kgVar.b();
                int columnIndex = cursor.getColumnIndex(kgVar.a());
                switch (iB) {
                    case 1:
                        field.set(tNewInstance, Short.valueOf(cursor.getShort(columnIndex)));
                        break;
                    case 2:
                        field.set(tNewInstance, Integer.valueOf(cursor.getInt(columnIndex)));
                        break;
                    case 3:
                        field.set(tNewInstance, Float.valueOf(cursor.getFloat(columnIndex)));
                        break;
                    case 4:
                        field.set(tNewInstance, Double.valueOf(cursor.getDouble(columnIndex)));
                        break;
                    case 5:
                        field.set(tNewInstance, Long.valueOf(cursor.getLong(columnIndex)));
                        break;
                    case 6:
                        field.set(tNewInstance, cursor.getString(columnIndex));
                        break;
                    case 7:
                        field.set(tNewInstance, cursor.getBlob(columnIndex));
                        break;
                }
            }
        }
        return tNewInstance;
    }

    private static void a(Object obj, Field field, ContentValues contentValues) {
        Annotation annotation = field.getAnnotation(kg.class);
        if (annotation == null) {
        }
        kg kgVar = (kg) annotation;
        try {
            switch (kgVar.b()) {
                case 1:
                    contentValues.put(kgVar.a(), Short.valueOf(field.getShort(obj)));
                    break;
                case 2:
                    contentValues.put(kgVar.a(), Integer.valueOf(field.getInt(obj)));
                    break;
                case 3:
                    contentValues.put(kgVar.a(), Float.valueOf(field.getFloat(obj)));
                    break;
                case 4:
                    contentValues.put(kgVar.a(), Double.valueOf(field.getDouble(obj)));
                    break;
                case 5:
                    contentValues.put(kgVar.a(), Long.valueOf(field.getLong(obj)));
                    break;
                case 6:
                    contentValues.put(kgVar.a(), (String) field.get(obj));
                    break;
                case 7:
                    contentValues.put(kgVar.a(), (byte[]) field.get(obj));
                    break;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static ContentValues a(Object obj, kf kfVar) {
        ContentValues contentValues = new ContentValues();
        for (Field field : a(obj.getClass(), kfVar.b())) {
            field.setAccessible(true);
            a(obj, field, contentValues);
        }
        return contentValues;
    }

    private static Field[] a(Class<?> cls, boolean z) {
        if (cls == null) {
            return null;
        }
        if (z) {
            return cls.getSuperclass().getDeclaredFields();
        }
        return cls.getDeclaredFields();
    }

    private SQLiteDatabase a() {
        try {
            if (this.b == null) {
                this.b = this.f1173a.getReadableDatabase();
            }
        } catch (Throwable th) {
            js.a(th, "dbs", "grd");
        }
        return this.b;
    }

    private SQLiteDatabase b() {
        try {
            SQLiteDatabase sQLiteDatabase = this.b;
            if (sQLiteDatabase == null || sQLiteDatabase.isReadOnly()) {
                SQLiteDatabase sQLiteDatabase2 = this.b;
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.close();
                }
                this.b = this.f1173a.getWritableDatabase();
            }
        } catch (Throwable th) {
            js.a(th, "dbs", "gwd");
        }
        return this.b;
    }

    private static <T> String a(kf kfVar) {
        if (kfVar == null) {
            return null;
        }
        return kfVar.a();
    }

    private static <T> kf b(Class<T> cls) {
        Annotation annotation = cls.getAnnotation(kf.class);
        if (annotation != null) {
            return (kf) annotation;
        }
        return null;
    }
}
