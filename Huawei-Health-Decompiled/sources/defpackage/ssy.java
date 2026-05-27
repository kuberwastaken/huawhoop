package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class ssy {
    private long b;
    private List<thc> d;
    private String g = "--";
    private String f = "--";
    private String j = "--";
    private String i = "--";
    private int e = -1;
    private long h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f17824a = 0;
    private List<thc> c = new ArrayList();

    public void b(long j) {
        this.b = j;
    }

    public long a() {
        return this.b;
    }

    public String e() {
        return this.g;
    }

    public void a(String str) {
        this.g = str;
    }

    public String d() {
        return this.f;
    }

    public void d(String str) {
        this.f = str;
    }

    public String c() {
        return this.j;
    }

    public void c(String str) {
        this.j = str;
    }

    public String h() {
        return this.i;
    }

    public void e(String str) {
        this.i = str;
    }

    public int b() {
        return this.e;
    }

    public void e(int i) {
        this.e = i;
    }

    public String toString() {
        return "HeartRate [mHeartRate=" + this.d + "]";
    }
}
