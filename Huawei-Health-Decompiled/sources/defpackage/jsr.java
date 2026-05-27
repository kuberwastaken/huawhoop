package defpackage;

import android.content.ContentValues;
import com.huawei.openalliance.ad.constant.JsbMapKeyNames;

/* JADX INFO: loaded from: classes9.dex */
public class jsr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14442a;
    private int b;
    private long c;
    private int d;
    private String e;
    private int h;
    private long i;

    public int a() {
        return this.h;
    }

    public void c(int i) {
        this.h = i;
    }

    public int c() {
        return this.b;
    }

    public void d(int i) {
        this.b = i;
    }

    public String e() {
        return this.e;
    }

    public void c(String str) {
        this.e = str;
    }

    public long d() {
        return this.c;
    }

    public void d(long j) {
        this.c = j;
    }

    public int b() {
        return this.f14442a;
    }

    public String toString() {
        return "SyncCacheTable{id=" + this.d + ", dataType=" + this.b + ", data='" + this.e + "', dataTime='" + this.c + ", isDone=" + this.f14442a + ", modifiedTime=" + this.i + '}';
    }

    public static ContentValues bDe_(jsr jsrVar) {
        if (jsrVar == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(JsbMapKeyNames.H5_USER_ID, Integer.valueOf(jsrVar.a()));
        contentValues.put("dataType", Integer.valueOf(jsrVar.c()));
        contentValues.put("data", jsrVar.e());
        contentValues.put("dataTime", Long.valueOf(jsrVar.d()));
        contentValues.put("isDone", Integer.valueOf(jsrVar.b()));
        contentValues.put("modifiedTime", Long.valueOf(System.currentTimeMillis()));
        return contentValues;
    }
}
