package defpackage;

/* JADX INFO: loaded from: classes7.dex */
public class pes {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16661a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int g;

    public pes(int i, int i2) {
        this.g = i;
        this.d = i2;
    }

    public peq a() {
        return new peq(this);
    }

    public pes d(int i, int i2, int i3, int i4) {
        this.b = i;
        this.c = i2;
        this.e = i3;
        this.f16661a = i4;
        return this;
    }

    public int i() {
        return this.g;
    }

    public int b() {
        return this.d;
    }

    public int c() {
        return this.b;
    }

    public int j() {
        return this.c;
    }

    public int e() {
        return this.e;
    }

    public int d() {
        return this.f16661a;
    }
}
