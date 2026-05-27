package defpackage;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class bsx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f487a;
    private int b;
    private int c;
    private int d;
    private String e;
    private int f;
    private Map<Integer, List<bst>> i;

    public int d() {
        return this.d;
    }

    public void c(int i) {
        this.d = i;
    }

    public int c() {
        return this.b;
    }

    public void b(int i) {
        this.b = i;
    }

    public int i() {
        return this.f;
    }

    public void d(int i) {
        this.f = i;
    }

    public int e() {
        return this.c;
    }

    public void e(int i) {
        this.c = i;
    }

    public Map<Integer, List<bst>> f() {
        return this.i;
    }

    public void a(Map<Integer, List<bst>> map) {
        this.i = map;
    }

    public int a() {
        return this.f487a;
    }

    public void a(int i) {
        this.f487a = i;
    }

    public String b() {
        return this.e;
    }

    public void a(String str) {
        this.e = str;
    }

    public String toString() {
        return "WeeklyReportBean{mStartDate=" + this.d + ", mEndDate=" + this.b + ", mWeekNumber=" + this.f + ", mCloverNumber=" + this.c + ", mWeeklyData=" + this.i + ", mCompleteNumber=" + this.f487a + ", mDateSegment='" + this.e + "'}";
    }
}
