package defpackage;

/* JADX INFO: loaded from: classes7.dex */
public class olh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f16428a;
    private int b;
    private boolean c;
    private float d;
    private float e;
    private float f;
    private boolean g;
    private long h;
    private float i;
    private float j;
    private boolean l;
    private float m;
    private boolean n;
    private int o;
    private float s;
    private float t;
    private float[] q = new float[20];
    private float[] r = new float[20];
    private float[] p = new float[20];
    private int[] k = new int[20];

    private int c(int i) {
        int i2 = 0;
        int i3 = 32768;
        int i4 = 15;
        while (true) {
            int i5 = ((i2 << 1) + i3) << i4;
            if (i >= i5) {
                i2 += i3;
                i -= i5;
            }
            i3 >>= 1;
            if (i3 <= 0) {
                return i2;
            }
            i4--;
        }
    }

    protected void c(int i, float[] fArr, float[] fArr2, float[] fArr3, int[] iArr, int i2, boolean z, long j) {
        this.h = j;
        this.b = i2;
        this.o = i;
        for (int i3 = 0; i3 < i; i3++) {
            this.r[i3] = fArr2[i3];
            this.q[i3] = fArr[i3];
            this.k[i3] = iArr[i3];
            this.p[i3] = fArr3[i3];
        }
        this.n = z;
        boolean z2 = i >= 2;
        this.l = z2;
        if (z2) {
            float f = fArr[0];
            float f2 = fArr[1];
            this.s = (f + f2) * 0.5f;
            this.t = (fArr2[0] + fArr2[1]) * 0.5f;
            this.m = (fArr3[0] + fArr3[1]) * 0.5f;
            this.i = Math.abs(f2 - f);
            this.f = Math.abs(fArr2[1] - fArr2[0]);
        } else {
            this.s = fArr[0];
            this.t = fArr2[0];
            this.m = fArr3[0];
            this.f = 0.0f;
            this.i = 0.0f;
        }
        this.c = false;
        this.f16428a = false;
        this.g = false;
    }

    public void d(olh olhVar) {
        this.o = olhVar.o;
        for (int i = 0; i < this.o; i++) {
            this.r[i] = olhVar.r[i];
            this.q[i] = olhVar.q[i];
            this.k[i] = olhVar.k[i];
            this.p[i] = olhVar.p[i];
        }
        this.i = olhVar.i;
        this.f = olhVar.f;
        this.s = olhVar.s;
        this.t = olhVar.t;
        this.m = olhVar.m;
        this.e = olhVar.e;
        this.j = olhVar.j;
        this.l = olhVar.l;
        this.d = olhVar.d;
        this.n = olhVar.n;
        this.b = olhVar.b;
        this.f16428a = olhVar.f16428a;
        this.g = olhVar.g;
        this.c = olhVar.c;
        this.h = olhVar.h;
    }

    public boolean k() {
        return this.l;
    }

    public float g() {
        if (this.l) {
            return this.i;
        }
        return 0.0f;
    }

    public float e() {
        if (this.l) {
            return this.f;
        }
        return 0.0f;
    }

    public float b() {
        float f;
        if (!this.g) {
            this.g = true;
            if (this.l) {
                float f2 = this.i;
                float f3 = this.f;
                f = (f2 * f2) + (f3 * f3);
            } else {
                f = 0.0f;
            }
            this.j = f;
        }
        return this.j;
    }

    public float c() {
        if (!this.f16428a) {
            if (!this.l) {
                this.e = 0.0f;
            } else {
                float fC = b() != 0.0f ? c((int) (r0 * 256.0f)) / 16.0f : 0.0f;
                this.e = fC;
                float f = this.f;
                if (fC < f) {
                    this.e = f;
                }
                float f2 = this.e;
                float f3 = this.i;
                if (f2 < f3) {
                    this.e = f3;
                }
            }
            this.f16428a = true;
        }
        return this.e;
    }

    public float a() {
        if (!this.c) {
            if (!this.l) {
                this.d = 0.0f;
            } else {
                this.c = true;
                float[] fArr = this.r;
                double d = fArr[1] - fArr[0];
                float[] fArr2 = this.q;
                this.d = (float) Math.atan2(d, fArr2[1] - fArr2[0]);
            }
        }
        return this.d;
    }

    public int f() {
        return this.o;
    }

    public boolean j() {
        return this.n;
    }

    public float h() {
        return this.s;
    }

    public float i() {
        return this.t;
    }

    public long d() {
        return this.h;
    }
}
