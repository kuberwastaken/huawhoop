package defpackage;

/* JADX INFO: loaded from: classes7.dex */
public class pfx extends pgn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected float f16679a;
    protected int b;
    protected int d;
    protected float e;

    public pfx(float f, float f2) {
        this.d = 0;
        this.b = 0;
        this.e = f;
        this.f16679a = f2;
    }

    public pfx(float f) {
        this.f16679a = 0.0f;
        this.d = 0;
        this.b = 0;
        this.e = f;
    }

    public pfx(float f, int i, int i2) {
        this.f16679a = 0.0f;
        this.e = f;
        this.d = i;
        this.b = i2;
    }

    public pfx(float f, float f2, int i, int i2) {
        this.e = f;
        this.f16679a = f2;
        this.d = i;
        this.b = i2;
    }

    public float b() {
        return this.e;
    }

    public void c(float f) {
        this.e = f;
    }

    public float d() {
        return this.f16679a;
    }

    public int j() {
        return this.d;
    }

    public int g() {
        return this.b;
    }
}
