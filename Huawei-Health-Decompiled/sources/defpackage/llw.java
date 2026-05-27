package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class llw {
    private int b;
    private int j;
    private boolean i = false;
    private int g = 0;
    private String c = "";
    private int l = -1;
    private int n = -1;
    private long f = -1;
    private int m = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15301a = -1;
    private int e = -1;
    private int o = 0;
    private List<byte[]> d = Collections.synchronizedList(new ArrayList(16));
    private List<Integer> h = new ArrayList(16);

    public boolean l() {
        return this.i;
    }

    public void d(boolean z) {
        this.i = z;
    }

    public int h() {
        return this.g;
    }

    public void b(int i) {
        this.g = i;
    }

    public String a() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public void i(int i) {
        this.n = i;
    }

    public int o() {
        return this.n;
    }

    public void d(long j) {
        this.f = j;
    }

    public long g() {
        return this.f;
    }

    public void h(int i) {
        this.m = i;
    }

    public int m() {
        return this.m;
    }

    public void d(int i) {
        this.f15301a = i;
    }

    public int c() {
        return this.f15301a;
    }

    public void f(int i) {
        this.l = i;
    }

    public int i() {
        return this.l;
    }

    public void c(int i) {
        this.e = i;
    }

    public int e() {
        return this.e;
    }

    public void a(int i) {
        this.j = i;
    }

    public int j() {
        return this.j;
    }

    public void e(int i) {
        this.b = i;
    }

    public int b() {
        return this.b;
    }

    public void g(int i) {
        this.o = i;
    }

    public int k() {
        return this.o;
    }

    public List<byte[]> d() {
        return this.d;
    }

    public List<Integer> f() {
        return this.h;
    }
}
