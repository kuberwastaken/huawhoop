package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class iru {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14233a;
    private List<Integer> b;
    private List<irt> e;

    public iru() {
        this.b = new ArrayList();
        this.e = new ArrayList();
    }

    public iru(int i, List<Integer> list, List<irt> list2) {
        this.b = new ArrayList();
        new ArrayList();
        this.f14233a = i;
        this.b = list;
        this.e = list2;
    }

    public int d() {
        return this.f14233a;
    }

    public void a(int i) {
        this.f14233a = i;
    }

    public List<Integer> b() {
        return this.b;
    }

    public void e(List<Integer> list) {
        this.b = list;
    }

    public List<irt> a() {
        return this.e;
    }

    public void a(List<irt> list) {
        this.e = list;
    }
}
