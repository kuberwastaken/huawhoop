package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class mow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<Integer> f15769a;
    private int c;
    private int d;
    private int e;

    public mow(int i, List<Integer> list, int i2) {
        this.c = i;
        this.f15769a = list;
        this.e = i2;
    }

    public int d() {
        return this.c;
    }

    public List<Integer> a() {
        return this.f15769a;
    }

    public int e() {
        return this.e;
    }

    public int b() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }

    public String toString() {
        return "ActivitySimpleListRequestBean{mJoinStatus=" + this.c + ", mFinishFlag=" + this.e + '}';
    }
}
