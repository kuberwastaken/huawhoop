package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class evx {
    private boolean b = true;
    private int c = 3;
    private int h = 100;
    private float j = 1.5f;
    private float g = 3.0f;
    private float[] d = {12.0f, 12.0f, 33.3f};
    private float i = 0.3f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f12801a = 2.8f;
    private boolean e = true;
    private int o = 3;
    private int f = 20000;

    public void a(boolean z) {
        this.b = z;
    }

    public void c(boolean z) {
        this.e = z;
    }

    public void d(float f) {
        this.j = f;
    }

    public void c(float f) {
        this.i = f;
    }

    public void a(int i) {
        this.h = i;
    }

    public void a(float f) {
        this.g = f;
    }

    public void d(float[] fArr) {
        if (fArr != null) {
            this.d = (float[]) fArr.clone();
        }
    }

    public void e(float f) {
        this.f12801a = f;
    }

    public boolean g() {
        return this.b;
    }

    public boolean i() {
        return this.e;
    }

    public int f() {
        return this.o;
    }

    public int j() {
        return this.f;
    }

    public float h() {
        return this.j;
    }

    public float e() {
        return this.i;
    }

    public int a() {
        return this.h;
    }

    public float b() {
        return this.g;
    }

    public int d() {
        return this.c;
    }

    public float c(int i) {
        if (i < 0) {
            return 0.0f;
        }
        float[] fArr = this.d;
        if (i >= fArr.length) {
            return 0.0f;
        }
        return fArr[i];
    }

    public float c() {
        return this.f12801a;
    }
}
