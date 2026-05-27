package defpackage;

/* JADX INFO: loaded from: classes7.dex */
public class pgi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f16685a;
    private float b;
    private int c;
    private float d;
    private float e;

    public pgi(float f, float f2, float f3, float f4) {
        this.c = 0;
        this.b = f;
        this.e = f2;
        this.d = f3;
        this.f16685a = f4;
    }

    public pgi(float f, float f2, float f3, float f4, int i) {
        this(f, f2, f3, f4);
        this.c = i;
    }

    public float a() {
        return this.b;
    }

    public float d() {
        return this.e;
    }

    public float e() {
        return this.d;
    }

    public float b() {
        return this.f16685a;
    }

    public int c() {
        return this.c;
    }
}
