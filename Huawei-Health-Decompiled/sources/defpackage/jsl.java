package defpackage;

import android.content.ContentValues;

/* JADX INFO: loaded from: classes9.dex */
public class jsl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14436a;
    private long b;
    private int c;
    private long d;
    private String e;
    private String f;
    private String i;

    public int c() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }

    public String e() {
        return this.i;
    }

    public void d(String str) {
        this.i = str;
    }

    public String a() {
        return this.e;
    }

    public void b(String str) {
        this.e = str;
    }

    public long d() {
        return this.d;
    }

    public String j() {
        return this.f;
    }

    public void c(String str) {
        this.f = str;
    }

    public long b() {
        return this.b;
    }

    public String toString() {
        return "PermissionTable{id=" + this.f14436a + '}';
    }

    public static ContentValues bDc_(jsl jslVar) {
        if (jslVar == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("cloud_id", Integer.valueOf(jslVar.c()));
        contentValues.put("scope_name", jslVar.e());
        contentValues.put("permission", jslVar.a());
        contentValues.put("uri", jslVar.j());
        contentValues.put("create_time", Long.valueOf(jslVar.b() <= 0 ? System.currentTimeMillis() : jslVar.b()));
        contentValues.put("modified_time", Long.valueOf(jslVar.d() <= 0 ? System.currentTimeMillis() : jslVar.d()));
        return contentValues;
    }
}
