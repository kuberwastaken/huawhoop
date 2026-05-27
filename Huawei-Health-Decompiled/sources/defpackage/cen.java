package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class cen {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<String> f613a;
    private int d;
    private List<Integer> e;

    public int d() {
        return this.d;
    }

    public void d(int i) {
        this.d = i;
    }

    public List<Integer> a() {
        return this.e;
    }

    public void b(List<Integer> list) {
        this.e = list;
    }

    public List<String> e() {
        return this.f613a;
    }

    public void c(List<String> list) {
        this.f613a = list;
    }

    public String toString() {
        return "McuCommand{mServiceId=" + this.d + ", mCommandIds=" + this.e + ", mDestPkgNames=" + this.f613a + '}';
    }
}
