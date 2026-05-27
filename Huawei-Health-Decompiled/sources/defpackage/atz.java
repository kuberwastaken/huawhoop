package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class atz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<auh> f322a;
    private long b;
    private long c;
    private int d = -1;
    private long e;
    private String g;
    private String j;

    public String a() {
        return this.j;
    }

    public long b() {
        return this.c;
    }

    public void b(long j) {
        this.b = j;
    }

    public long c() {
        return this.c - this.b;
    }

    public void c(int i) {
        this.d = i;
    }

    public void c(long j) {
        this.c = j;
    }

    public void c(String str) {
        this.g = str;
    }

    public List<auh> d() {
        return this.f322a;
    }

    public void d(List<auh> list) {
        this.f322a = list;
    }

    public long e() {
        return this.b;
    }

    public void e(long j, long j2) {
        this.b = j;
        this.c = j2;
        this.e = j2 - j;
    }

    public void e(String str) {
        this.j = str;
    }

    public String j() {
        return this.g;
    }
}
