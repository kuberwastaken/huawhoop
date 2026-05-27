package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class itw {
    private List<irt> c;
    private int e = 0;
    private int d = 0;
    private int b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f14289a = 0.0f;

    public List<irt> a() {
        return this.c;
    }

    public itw d(List<irt> list) {
        this.c = list;
        return this;
    }

    public int d() {
        return this.e;
    }

    public itw b(int i) {
        this.e = i;
        return this;
    }

    public int c() {
        return this.d;
    }

    public itw c(int i) {
        this.d = i;
        return this;
    }

    public int b() {
        return this.b;
    }

    public itw e(int i) {
        this.b = i;
        return this;
    }

    public float e() {
        return this.f14289a;
    }

    public itw b(float f) {
        this.f14289a = f;
        return this;
    }
}
