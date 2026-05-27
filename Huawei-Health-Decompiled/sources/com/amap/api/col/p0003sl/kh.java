package com.amap.api.col.p0003sl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes3.dex */
public final class kh extends SQLiteOpenHelper {
    private static boolean b = true;
    private static boolean c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private kd f1174a;

    public kh(Context context, String str, int i, kd kdVar) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        this.f1174a = kdVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.f1174a.a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.f1174a.a(sQLiteDatabase, i);
    }
}
