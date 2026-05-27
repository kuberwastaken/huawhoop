package defpackage;

import android.content.ContentValues;

/* JADX INFO: loaded from: classes3.dex */
public class aqm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f268a;
    private String b;
    private String c;
    private String[] d;
    private String[] e;
    private ContentValues g;

    public void e(String[] strArr) {
        this.d = strArr;
    }

    public void a(String str) {
        this.c = str;
    }

    public String i() {
        return this.b;
    }

    public String[] d() {
        return this.e;
    }

    public ContentValues ex_() {
        return this.g;
    }

    public String a() {
        return this.f268a;
    }

    public String[] b() {
        return this.d;
    }

    public String e() {
        return this.c;
    }

    public aqm(String str, String str2, String[] strArr, String str3, String[] strArr2, ContentValues contentValues) {
        this.f268a = str;
        this.c = str2;
        this.d = strArr;
        this.b = str3;
        this.e = strArr2;
        this.g = contentValues;
    }

    public aqm() {
    }
}
