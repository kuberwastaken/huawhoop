package defpackage;

import android.content.ContentValues;

/* JADX INFO: loaded from: classes9.dex */
public class jsm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f14437a;
    private long b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private jsl h;

    public int e() {
        return this.c;
    }

    public void d(int i) {
        this.c = i;
    }

    public int f() {
        return this.f;
    }

    public void e(int i) {
        this.f = i;
    }

    public int c() {
        return this.g;
    }

    public void a(int i) {
        this.g = i;
    }

    public jsl b() {
        return this.h;
    }

    public void b(jsl jslVar) {
        this.h = jslVar;
    }

    public int a() {
        return this.e;
    }

    public void c(int i) {
        this.e = i;
    }

    public void e(long j) {
        this.b = j;
    }

    public long d() {
        return this.f14437a;
    }

    public void d(long j) {
        this.f14437a = j;
    }

    public String toString() {
        return "AuthorizationTable{id=" + this.d + '}';
    }

    public static ContentValues bCZ_(jsm jsmVar) {
        if (jsmVar == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", Integer.valueOf(jsmVar.e()));
        contentValues.put("user_id", Integer.valueOf(jsmVar.f()));
        contentValues.put("permission_id", Integer.valueOf(jsmVar.c()));
        contentValues.put("granted", Integer.valueOf(jsmVar.a()));
        contentValues.put("modified_time", Long.valueOf(jsmVar.d()));
        return contentValues;
    }
}
