package com.huawei.animation.physical2;

/* JADX INFO: loaded from: classes10.dex */
public class Spring {
    private float c = 0.0f;
    private float f = 0.0f;
    private float e = 1.0f;
    private float j = 0.001f;
    private float h = 228.0f;
    private float b = 30.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f1883a = 1.0f;
    private float i = 0.001f;
    private CalcSpring d = new e();
    private float g = this.j * 62.5f;

    interface CalcSpring {
        float getValue(float f);

        float getVelocity(float f);
    }

    public boolean c(float f, float f2) {
        return ((double) Math.abs(f2)) < ((double) this.g) && ((double) Math.abs(f - this.e)) < ((double) this.j);
    }

    public Spring c() {
        this.d = d();
        return this;
    }

    public float c(long j) {
        return this.d.getValue(j / 1000.0f) + this.e;
    }

    public float a(long j) {
        return this.d.getVelocity(j / 1000.0f);
    }

    private CalcSpring d() {
        float f = this.f1883a;
        if (f == 0.0f) {
            return this.d;
        }
        float f2 = this.c - this.e;
        float f3 = this.b;
        float f4 = (f3 * f3) - ((4.0f * f) * this.h);
        if (f4 == 0.0f) {
            float f5 = (-f3) / (f * 2.0f);
            return new a(f2, this.f - (f5 * f2), f5);
        }
        if (f4 > 0.0f) {
            double d2 = -f3;
            double d3 = f4;
            float fSqrt = (float) ((d2 - Math.sqrt(d3)) / ((double) (this.f1883a * 2.0f)));
            float fSqrt2 = (float) ((((double) (-this.b)) + Math.sqrt(d3)) / ((double) (this.f1883a * 2.0f)));
            float f6 = fSqrt2 - fSqrt;
            if (Math.abs(f6) < 1.0E-6f) {
                return this.d;
            }
            float f7 = (this.f - (fSqrt * f2)) / f6;
            return new d(f2 - f7, f7, fSqrt, fSqrt2);
        }
        double dSqrt = Math.sqrt(-f4);
        float f8 = this.f1883a * 2.0f;
        float f9 = (float) (dSqrt / ((double) f8));
        float f10 = (-this.b) / f8;
        return new b(f2, (this.f - (f10 * f2)) / f9, f9, f10);
    }

    public Spring e(float f) {
        this.c = f;
        return this;
    }

    public Spring a(float f) {
        this.f = f;
        return this;
    }

    public float b() {
        return this.e;
    }

    public Spring c(float f) {
        this.e = f;
        return this;
    }

    public Spring h(float f) {
        this.j = f;
        this.g = f * 62.5f;
        return this;
    }

    public Spring d(float f) {
        this.h = f;
        return this;
    }

    public Spring b(float f) {
        this.b = f;
        return this;
    }

    static class a implements CalcSpring {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f1884a;
        float b;
        float d;

        a(float f, float f2, float f3) {
            this.d = f;
            this.b = f2;
            this.f1884a = f3;
        }

        @Override // com.huawei.animation.physical2.Spring.CalcSpring
        public float getValue(float f) {
            return (float) (((double) (this.d + (this.b * f))) * Math.pow(2.718281828459045d, this.f1884a * f));
        }

        @Override // com.huawei.animation.physical2.Spring.CalcSpring
        public float getVelocity(float f) {
            float fPow = (float) Math.pow(2.718281828459045d, this.f1884a * f);
            float f2 = this.f1884a;
            float f3 = this.d;
            float f4 = this.b;
            return (f2 * (f3 + (f * f4)) * fPow) + (f4 * fPow);
        }
    }

    static class d implements CalcSpring {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f1885a;
        float b;
        float d;
        float e;

        d(float f, float f2, float f3, float f4) {
            this.b = f;
            this.e = f2;
            this.f1885a = f3;
            this.d = f4;
        }

        @Override // com.huawei.animation.physical2.Spring.CalcSpring
        public float getValue(float f) {
            return (this.b * ((float) Math.pow(2.718281828459045d, this.f1885a * f))) + (this.e * ((float) Math.pow(2.718281828459045d, this.d * f)));
        }

        @Override // com.huawei.animation.physical2.Spring.CalcSpring
        public float getVelocity(float f) {
            float f2 = this.b;
            float f3 = this.f1885a;
            return (f2 * f3 * ((float) Math.pow(2.718281828459045d, f3 * f))) + (this.e * this.d * ((float) Math.pow(2.718281828459045d, f * r6)));
        }
    }

    static class b implements CalcSpring {
        float b;
        float c;
        float d;
        float e;

        b(float f, float f2, float f3, float f4) {
            this.b = f;
            this.d = f2;
            this.e = f3;
            this.c = f4;
        }

        @Override // com.huawei.animation.physical2.Spring.CalcSpring
        public float getValue(float f) {
            return ((float) Math.pow(2.718281828459045d, this.c * f)) * ((this.b * ((float) Math.cos(this.e * f))) + (this.d * ((float) Math.sin(this.e * f))));
        }

        @Override // com.huawei.animation.physical2.Spring.CalcSpring
        public float getVelocity(float f) {
            float fPow = (float) Math.pow(2.718281828459045d, this.c * f);
            float fCos = (float) Math.cos(this.e * f);
            float fSin = (float) Math.sin(this.e * f);
            float f2 = this.d;
            float f3 = this.e;
            float f4 = this.b;
            return ((((f2 * f3) * fCos) - ((f3 * f4) * fSin)) * fPow) + (this.c * fPow * ((f2 * fSin) + (f4 * fCos)));
        }
    }

    static class e implements CalcSpring {
        @Override // com.huawei.animation.physical2.Spring.CalcSpring
        public float getValue(float f) {
            return 0.0f;
        }

        @Override // com.huawei.animation.physical2.Spring.CalcSpring
        public float getVelocity(float f) {
            return 0.0f;
        }

        e() {
        }
    }

    public String toString() {
        return "Spring{startValue=" + this.c + ", startVelocity=" + this.f + ", endValue=" + this.e + ", valueAccuracy=" + this.j + ", stiffness=" + this.h + ", damping=" + this.b + ", mass=" + this.f1883a + ", timeEstimateSpan=" + this.i + ", calcSpring=" + this.d + ", velocityAccuracy=" + this.g + '}';
    }
}
