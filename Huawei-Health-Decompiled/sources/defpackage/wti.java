package defpackage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes9.dex */
public class wti {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f18926a;
    private SQLiteDatabase b;
    private String[] c;

    public wti(Context context, String str, String[] strArr) {
        this.f18926a = str;
        this.c = (String[]) strArr.clone();
        this.b = wtm.c(context).getWritableDatabase();
    }

    public long fDe_(ContentValues contentValues) {
        return this.b.insert(this.f18926a, null, contentValues);
    }

    public int a(String str, String[] strArr) {
        return this.b.delete(this.f18926a, str, strArr);
    }

    public int fDg_(ContentValues contentValues, String str, String[] strArr) {
        return this.b.update(this.f18926a, contentValues, str, strArr);
    }

    public Cursor fDf_(String str, String[] strArr, String str2, String str3, String str4) {
        return this.b.query(this.f18926a, this.c, str, strArr, str2, str3, str4);
    }
}
