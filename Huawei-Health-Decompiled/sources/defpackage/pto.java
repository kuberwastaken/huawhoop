package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class pto extends ptn {
    private static final long serialVersionUID = -374428058867356358L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<ptv> f16873a = new ArrayList(8);
    private int c;

    public void a(int i) {
        this.c = i;
    }

    public List<ptv> b() {
        return this.f16873a;
    }

    public void e(ptv ptvVar) {
        this.f16873a.add(ptvVar);
    }

    public String toString() {
        return "Content{partCount=" + this.c + ", parts=" + this.f16873a + '}';
    }
}
