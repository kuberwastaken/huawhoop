package defpackage;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes4.dex */
public class eia {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12604a;
    private boolean b;
    private int c;
    private int d;
    private String e;
    private String f;
    private String j;

    public int e() {
        return this.f12604a;
    }

    public void c(int i) {
        this.f12604a = i;
    }

    public String a() {
        return TextUtils.isEmpty(this.j) ? "" : this.j;
    }

    public void b(String str) {
        this.j = str;
    }

    public int c() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
    }

    public int b() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }

    public String i() {
        return this.f;
    }

    public void e(String str) {
        this.f = str;
    }

    public String d() {
        return this.e;
    }

    public void c(String str) {
        this.e = str;
    }

    public boolean j() {
        return this.b;
    }

    public void a(boolean z) {
        this.b = z;
    }
}
