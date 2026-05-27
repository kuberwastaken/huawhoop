package defpackage;

import android.content.ContentValues;

/* JADX INFO: loaded from: classes5.dex */
public class jso {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14439a;
    private int b;
    private int c;
    private int d;
    private long e;
    private long f;

    public int d() {
        return this.b;
    }

    public void d(int i) {
        this.b = i;
    }

    public long c() {
        return this.e;
    }

    public void c(long j) {
        this.e = j;
    }

    public long g() {
        return this.f;
    }

    public void e(long j) {
        this.f = j;
    }

    public int a() {
        return this.d;
    }

    public void b(int i) {
        this.d = i;
    }

    public int b() {
        return this.f14439a;
    }

    public void c(int i) {
        this.f14439a = i;
    }

    public int e() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }

    public String toString() {
        return "SyncAnchorTable{syncType=" + this.b + ", cloudCode=" + this.e + ", user=" + this.f14439a + ", syncDataCategory=" + this.c + ", syncTypeVersion=" + this.f + ", syncTime=" + this.d + '}';
    }

    public static ContentValues bDd_(jso jsoVar) {
        if (jsoVar == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("main_user_id", Integer.valueOf(jsoVar.b()));
        contentValues.put("cloud_code", Long.valueOf(jsoVar.c()));
        contentValues.put("sync_data_type", Integer.valueOf(jsoVar.d()));
        contentValues.put("sync_type_version", Long.valueOf(jsoVar.g()));
        contentValues.put("sync_type_time", Integer.valueOf(jsoVar.a()));
        contentValues.put("modify_time", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("sync_data_category", Integer.valueOf(jsoVar.e()));
        return contentValues;
    }
}
