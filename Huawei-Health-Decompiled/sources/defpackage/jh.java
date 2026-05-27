package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class jh {
    private float b;
    private float d;

    public jh(float f, float f2) {
        this.b = f;
        this.d = f2;
    }

    public jh() {
        this(1.0f, 1.0f);
    }

    public float a() {
        return this.b;
    }

    public float d() {
        return this.d;
    }

    public void e(float f, float f2) {
        this.b = f;
        this.d = f2;
    }

    public boolean c(float f, float f2) {
        return this.b == f && this.d == f2;
    }

    public String toString() {
        return a() + "x" + d();
    }
}
