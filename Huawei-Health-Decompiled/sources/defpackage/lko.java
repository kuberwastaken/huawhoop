package defpackage;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes6.dex */
public class lko {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15260a;
    private String b;
    private String c;
    private String d;

    public String e() {
        return this.b;
    }

    public void e(String str) {
        this.b = str;
    }

    public String b() {
        return this.f15260a;
    }

    public void d(String str) {
        this.f15260a = str;
    }

    public String c() {
        return this.c;
    }

    public void a(String str) {
        this.c = str;
    }

    public String a() {
        return this.d;
    }

    public void c(String str) {
        this.d = str;
    }

    public boolean d() {
        return TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.f15260a) || TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.d);
    }

    public String toString() {
        return "EphemerisUrlSonyEntity{ver='" + this.b + "', downloadUrl='" + this.f15260a + "', signature='" + this.c + "', fileId='" + this.d + "'}";
    }
}
