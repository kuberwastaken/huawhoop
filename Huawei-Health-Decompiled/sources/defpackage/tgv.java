package defpackage;

import health.compact.a.util.LogUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class tgv {
    private long d;
    private ArrayList<b> e;

    public long e() {
        return this.d;
    }

    public void d(long j) {
        this.d = j;
    }

    public ArrayList<b> b() {
        return this.e;
    }

    public void a(List<b> list) {
        if (list == null) {
            LogUtil.d("BloodSugarHistoryData", "BloodSugarHistoryData setOneDayList oneDayList is null");
        } else {
            this.e = new ArrayList<>(list);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f17976a = true;
        private int b;
        private boolean c;
        private String d;
        private int e;
        private String f;
        private double g;
        private long h;
        private double i;
        private int j;
        private long m;
        private long n;

        public long f() {
            return this.h;
        }

        public void d(long j) {
            this.h = j;
        }

        public long l() {
            return this.m;
        }

        public void a(long j) {
            this.m = j;
        }

        public int b() {
            return this.j;
        }

        public void e(int i) {
            this.j = i;
        }

        public double j() {
            return this.i;
        }

        public void e(double d) {
            this.i = d;
        }

        public int c() {
            return this.e;
        }

        public void d(int i) {
            this.e = i;
        }

        public boolean o() {
            return this.f17976a;
        }

        public void a(boolean z) {
            this.f17976a = z;
        }

        public String d() {
            return this.d;
        }

        public void c(String str) {
            this.d = str;
        }

        public String h() {
            return this.f;
        }

        public void b(String str) {
            this.f = str;
        }

        public int a() {
            return this.b;
        }

        public void c(int i) {
            this.b = i;
        }

        public long i() {
            return this.n;
        }

        public void e(long j) {
            this.n = j;
        }

        public double g() {
            return this.g;
        }

        public boolean e() {
            return this.c;
        }

        public void e(boolean z) {
            this.c = z;
        }
    }
}
