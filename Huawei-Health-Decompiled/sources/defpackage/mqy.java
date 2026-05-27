package defpackage;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class mqy implements Serializable {
    private static final long serialVersionUID = 1;
    private String aa;
    private String ab;
    private String ac;
    private String b;
    private int c;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String m;
    private String n;
    private String p;
    private String q;
    private String r;
    private String u;
    private String v;
    private String x;
    private String y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f15824a = 0;
    private String t = "";
    private long s = 0;
    private int w = -1;
    private int o = -1;
    private int d = -1;
    private int l = 0;
    private String k = "";
    private String e = "";

    public void h(String str) {
        this.n = str;
    }

    public String b() {
        return this.v;
    }

    public void g(String str) {
        this.v = str;
    }

    public void a(String str) {
        this.h = str;
    }

    public void i(String str) {
        this.x = str;
    }

    public void e(String str) {
        this.b = str;
    }

    public long e() {
        return this.f15824a;
    }

    public void d(long j) {
        this.f15824a = j;
    }

    public String h() {
        return this.aa;
    }

    public void k(String str) {
        this.aa = str;
    }

    public String f() {
        return this.y;
    }

    public void o(String str) {
        this.y = str;
    }

    public String j() {
        return this.ab;
    }

    public void n(String str) {
        this.ab = str;
    }

    public void j(String str) {
        this.m = str;
    }

    public void c(String str) {
        this.j = str;
    }

    public void b(int i) {
        this.o = i;
    }

    public void e(int i) {
        this.d = i;
    }

    public int d() {
        return this.l;
    }

    public void d(int i) {
        this.l = i;
    }

    public String a() {
        return this.k;
    }

    public void d(String str) {
        this.k = str;
    }

    public void b(String str) {
        this.e = str;
    }

    public String i() {
        return this.ac;
    }

    public void m(String str) {
        this.ac = str;
    }

    public String c() {
        return this.r;
    }

    public void f(String str) {
        this.r = str;
    }

    public String toString() {
        return "AppNewVersionInfo{NAME='" + this.n + "', VERSION='" + this.v + "', VERSION_ID='" + this.ab + "', DESCRIPTION='" + this.h + "', URL='" + this.x + "', CREATETIME='" + this.b + "', componentID=" + this.c + "', FILESIZE='" + this.f + "', PACKAGENAME='" + this.q + "', FILENAME='" + this.i + "', BYTESIZE='" + this.f15824a + "', VERSION_CODE='" + this.y + "', VERSION_NAME='" + this.aa + "', MD5='" + this.m + "', NEWMD5='" + this.t + "', NEWBYTESIZE=" + this.s + "', DPATH='" + this.j + "', SPATH='" + this.p + "', STATUS='" + this.w + "', DOWNLOADURL='" + this.g + "', STORAGEPATH='" + this.u + ", VERSION_TYPE=" + this.ac + ", OS_VERSION=" + this.r + "'}";
    }
}
