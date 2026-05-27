package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class luq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15488a;
    private List<lul> b = new ArrayList(16);
    private long c;
    private int d;
    private String e;
    private int f;
    private int g;
    private String h;

    public String a() {
        return this.f15488a;
    }

    public void d(String str) {
        this.f15488a = str;
    }

    public void d(long j) {
        this.c = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }

    public void c(int i) {
        this.d = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int c() {
        return ((Integer) kqt.e(Integer.valueOf(this.f))).intValue();
    }

    public void d(int i) {
        this.f = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public void a(String str) {
        this.e = (String) kqt.e(str);
    }

    public List<lul> d() {
        return (List) kqt.e(this.b);
    }

    public int b() {
        return this.g;
    }

    public void e(int i) {
        this.g = i;
    }

    public String e() {
        return this.h;
    }

    public void e(String str) {
        this.h = str;
    }
}
