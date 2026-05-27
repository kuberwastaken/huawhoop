package com.huawei.dynamicanimation;

import android.os.SystemClock;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes3.dex */
public class SpringModelBase extends PhysicalModelBase {
    public static final float c = new BigDecimal("1").divide(new BigDecimal("1000")).floatValue();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Solution f2007a;
    private float b;
    private float d;
    private float e;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(float f, float f2, float f3) {
        return f < f2 - f3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(float f, float f2, float f3) {
        return f > f2 - f3;
    }

    private boolean d(float f, float f2, float f3) {
        return f > f2 - f3 && f < f2 + f3;
    }

    public SpringModelBase(float f, float f2, float f3) {
        this.b = 1.0f;
        this.d = 800.0f;
        this.e = 15.0f;
        super.setValueThreshold(f3);
        this.b = 1.0f;
        this.d = Math.min(Math.max(1.0f, f), 999.0f);
        this.e = Math.min(Math.max(1.0f, f2), 99.0f);
        this.f2007a = null;
        this.mStartPosition = 0.0f;
        this.mEndPosition = 0.0f;
        this.mStartVelocity = 0.0f;
        this.mStartTime = 0L;
    }

    abstract class Solution {
        private float[] mPositionDist = new float[17];
        protected float mPosition = 0.0f;
        protected float mVelocity = 0.0f;
        protected float mAcceleration = 0.0f;
        protected float mDuration = 0.0f;

        private float getIterate(float f, float f2) {
            if (f <= 999.0f) {
                return f2;
            }
            return -1.0f;
        }

        protected abstract void doEstimateDuration();

        protected abstract float estimateDuration();

        protected abstract float getAcceleration(float f);

        protected abstract float getFirstExtremumX();

        protected abstract float getMaxAbsX();

        protected abstract float getPosition(float f);

        protected abstract float getVelocity(float f);

        protected Solution() {
        }

        protected void estimateDuration(float f, float f2) {
            int i = 0;
            if (f2 >= 0.0f && !Float.isInfinite(f2) && !Float.isNaN(f2)) {
                float position = getPosition(f2);
                int i2 = 0;
                while (SpringModelBase.this.b(Math.abs(position), SpringModelBase.this.mValueThreshold, 0.0f)) {
                    i2++;
                    if (i2 > 999.0f) {
                        break;
                    }
                    f2 = (f2 + f) / 2.0f;
                    position = getPosition(f2);
                }
                if (i2 > 999.0f) {
                    this.mDuration = f2;
                    return;
                }
                f = f2;
            }
            float position2 = getPosition(f);
            float velocity = getVelocity(f);
            while (SpringModelBase.this.c(Math.abs(position2), SpringModelBase.this.mValueThreshold, 0.0f)) {
                i++;
                if (i > 999.0f) {
                    break;
                }
                f -= position2 / velocity;
                if (f < 0.0f || Float.isNaN(f) || Float.isInfinite(f)) {
                    this.mDuration = 0.0f;
                    return;
                } else {
                    position2 = getPosition(f);
                    velocity = getVelocity(f);
                }
            }
            if (i > 999.0f) {
                this.mDuration = -1.0f;
            } else {
                this.mDuration = f;
            }
        }

        private float getStartTimeForX(float f, float f2, float f3) {
            float f4 = (f3 - f2) / 16.0f;
            boolean z = getVelocity(new BigDecimal((double) (f3 + f2)).divide(new BigDecimal("2")).floatValue()) > 0.0f;
            for (int i = 1; i < 17; i++) {
                float[] fArr = this.mPositionDist;
                float f5 = fArr[i];
                int i2 = i - 1;
                float f6 = fArr[i2];
                float f7 = f5 - f6;
                if (z && f5 >= f) {
                    return f7 == 0.0f ? f2 + (i2 * f4) : f2 + ((i2 + ((f - f6) / f7)) * f4);
                }
                if (!z && f5 <= f) {
                    return f7 == 0.0f ? f2 + (i2 * f4) : f2 + ((i - ((f5 - f) / f7)) * f4);
                }
            }
            return f3;
        }

        protected float doIterate(float f, float f2) {
            float f3 = (f2 - f) / 16.0f;
            float f4 = SpringModelBase.this.mValueThreshold;
            for (int i = 0; i < 17; i++) {
                this.mPositionDist[i] = getPosition((i * f3) + f);
            }
            boolean z = true;
            int i2 = 1;
            while (true) {
                if (i2 >= 17) {
                    z = false;
                    break;
                }
                int i3 = i2 - 1;
                if ((this.mPositionDist[i3] - SpringModelBase.this.mValueThreshold) * (this.mPositionDist[i2] - SpringModelBase.this.mValueThreshold) < 0.0f) {
                    f4 = SpringModelBase.this.mValueThreshold;
                    break;
                }
                if ((this.mPositionDist[i3] + SpringModelBase.this.mValueThreshold) * (this.mPositionDist[i2] + SpringModelBase.this.mValueThreshold) < 0.0f) {
                    f4 = -SpringModelBase.this.mValueThreshold;
                    break;
                }
                i2++;
            }
            if (!z) {
                return f;
            }
            float startTimeForX = getStartTimeForX(f4, f, f2);
            while (Math.abs(getPosition(startTimeForX)) < SpringModelBase.this.mValueThreshold && f2 - startTimeForX >= 0.0625f) {
                float f5 = (startTimeForX - f) / 16.0f;
                for (int i4 = 0; i4 < 17; i4++) {
                    this.mPositionDist[i4] = getPosition((i4 * f5) + f);
                }
                float f6 = startTimeForX;
                startTimeForX = getStartTimeForX(f4, f, startTimeForX);
                f2 = f6;
            }
            float position = getPosition(startTimeForX);
            float velocity = getVelocity(startTimeForX);
            float f7 = 0.0f;
            while (SpringModelBase.this.c(Math.abs(position), SpringModelBase.this.mValueThreshold, 0.0f)) {
                float f8 = 1.0f + f7;
                if (f7 >= 999.0f || velocity == 0.0f) {
                    f7 = f8;
                    break;
                }
                startTimeForX -= position / velocity;
                position = getPosition(startTimeForX);
                velocity = getVelocity(startTimeForX);
                f7 = f8;
            }
            return getIterate(f7, startTimeForX);
        }
    }

    class d extends Solution {
        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        protected void doEstimateDuration() {
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        protected float estimateDuration() {
            return 0.0f;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        protected float getFirstExtremumX() {
            return 0.0f;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        protected float getMaxAbsX() {
            return 0.0f;
        }

        private d() {
            super();
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float getPosition(float f) {
            return this.mPosition;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float getVelocity(float f) {
            return this.mVelocity;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float getAcceleration(float f) {
            return this.mAcceleration;
        }
    }

    class b extends Solution {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f2009a;
        float d;
        float e;

        b(float f, float f2, float f3) {
            super();
            this.d = f;
            this.e = f2;
            this.f2009a = f3;
            doEstimateDuration();
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float getPosition(float f) {
            this.mPosition = (float) (((double) (this.d + (this.e * f))) * Math.pow(2.718281828459045d, this.f2009a * f));
            return this.mPosition;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float getVelocity(float f) {
            float fPow = (float) Math.pow(2.718281828459045d, this.f2009a * f);
            float f2 = this.f2009a;
            float f3 = this.d;
            float f4 = this.e;
            this.mVelocity = (f2 * (f3 + (f * f4)) * fPow) + (f4 * fPow);
            return this.mVelocity;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float getAcceleration(float f) {
            float fPow = (float) Math.pow(2.718281828459045d, this.f2009a * f);
            float f2 = this.f2009a;
            float f3 = this.d;
            float f4 = this.e;
            this.mAcceleration = (f2 * f2 * (f3 + (f * f4)) * fPow) + (f4 * 2.0f * f2 * fPow);
            return this.mAcceleration;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        protected final void doEstimateDuration() {
            float f = this.e;
            if (f != 0.0f) {
                float f2 = this.f2009a;
                if (f2 == 0.0f) {
                    return;
                }
                estimateDuration(0.0f, (-(((2.0f * f) / f2) + this.d)) / f);
            }
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        protected float estimateDuration() {
            return this.mDuration;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        protected float getMaxAbsX() {
            return Math.abs(getFirstExtremumX());
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        protected float getFirstExtremumX() {
            float f = this.e;
            float f2 = 0.0f;
            if (f != 0.0f) {
                float f3 = this.f2009a;
                if (f3 != 0.0f) {
                    float f4 = (-((f / f3) + this.d)) / f;
                    if (f4 >= 0.0f && !Float.isInfinite(f4)) {
                        f2 = f4;
                    }
                    return getPosition(f2);
                }
            }
            return 0.0f;
        }
    }

    class c extends Solution {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f2010a;
        float c;
        float d;
        float e;

        c(float f, float f2, float f3, float f4) {
            super();
            this.e = f;
            this.d = f2;
            this.f2010a = f3;
            this.c = f4;
            doEstimateDuration();
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float getPosition(float f) {
            this.mPosition = (this.e * ((float) Math.pow(2.718281828459045d, this.f2010a * f))) + (this.d * ((float) Math.pow(2.718281828459045d, this.c * f)));
            return this.mPosition;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float getVelocity(float f) {
            float f2 = this.e;
            float f3 = this.f2010a;
            this.mVelocity = (f2 * f3 * ((float) Math.pow(2.718281828459045d, f3 * f))) + (this.d * this.c * ((float) Math.pow(2.718281828459045d, r6 * f)));
            return this.mVelocity;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float getAcceleration(float f) {
            float f2 = this.e;
            float f3 = this.f2010a;
            float fPow = (float) Math.pow(2.718281828459045d, f3 * f);
            float f4 = this.d;
            float f5 = this.c;
            this.mAcceleration = (f2 * f3 * f3 * fPow) + (f4 * f5 * f5 * ((float) Math.pow(2.718281828459045d, f * f5)));
            return this.mAcceleration;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        protected final void doEstimateDuration() {
            if (Math.abs(this.f2010a - this.c) < 1.0E-6f) {
                return;
            }
            float f = this.e;
            float f2 = this.f2010a;
            float fLog = (float) Math.log(Math.abs(f * f2 * f2));
            float f3 = -this.d;
            float f4 = this.c;
            estimateDuration(0.0f, (fLog - ((float) Math.log(Math.abs((f3 * f4) * f4)))) / (this.c - this.f2010a));
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        protected float estimateDuration() {
            return this.mDuration;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        protected float getMaxAbsX() {
            return Math.abs(getFirstExtremumX());
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        protected float getFirstExtremumX() {
            float f = 0.0f;
            if (Math.abs(this.f2010a - this.c) < 1.0E-6f) {
                return 0.0f;
            }
            float fLog = (((float) Math.log(Math.abs(this.e * this.f2010a))) - ((float) Math.log(Math.abs((-this.d) * this.c)))) / (this.c - this.f2010a);
            if (fLog >= 0.0f && !Float.isInfinite(fLog)) {
                f = fLog;
            }
            return getPosition(f);
        }
    }

    class a extends Solution {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f2008a;
        float c;
        float d;
        float e;

        a(float f, float f2, float f3, float f4) {
            super();
            this.d = f;
            this.c = f2;
            this.e = f3;
            this.f2008a = f4;
            doEstimateDuration();
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float getPosition(float f) {
            this.mPosition = ((float) Math.pow(2.718281828459045d, this.f2008a * f)) * ((this.d * ((float) Math.cos(this.e * f))) + (this.c * ((float) Math.sin(this.e * f))));
            return this.mPosition;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float getVelocity(float f) {
            float fPow = (float) Math.pow(2.718281828459045d, this.f2008a * f);
            float fCos = (float) Math.cos(this.e * f);
            float fSin = (float) Math.sin(this.e * f);
            float f2 = this.c;
            float f3 = this.e;
            float f4 = this.d;
            this.mVelocity = ((((f2 * f3) * fCos) - ((f3 * f4) * fSin)) * fPow) + (this.f2008a * fPow * ((f2 * fSin) + (f4 * fCos)));
            return this.mVelocity;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float getAcceleration(float f) {
            float fPow = (float) Math.pow(2.718281828459045d, this.f2008a * f);
            float fCos = (float) Math.cos(this.e * f);
            float fSin = (float) Math.sin(this.e * f);
            float f2 = this.f2008a;
            float f3 = this.c;
            float f4 = this.e;
            float f5 = this.d;
            float f6 = f5 * f4;
            float f7 = f2 * fPow * (((f3 * f4) * fCos) - (f6 * fSin));
            this.mAcceleration = ((((((-f3) * f4) * f4) * fSin) - ((f6 * f4) * fCos)) * fPow) + f7 + (f2 * f2 * fPow * ((f3 * fSin) + (f5 * fCos))) + f7;
            return this.mAcceleration;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        protected final void doEstimateDuration() {
            float fSqrt = (float) Math.sqrt((SpringModelBase.this.e * SpringModelBase.this.e) / ((SpringModelBase.this.b * 4.0f) * SpringModelBase.this.d));
            float fSqrt2 = ((float) Math.sqrt(1.0f - (fSqrt * fSqrt))) * ((float) Math.sqrt(SpringModelBase.this.d / SpringModelBase.this.b));
            float fAtan = (float) Math.atan(this.c / this.d);
            if (Float.isNaN(fAtan)) {
                this.mDuration = 0.0f;
                return;
            }
            float fAcos = ((((float) Math.acos(0.0d)) + fAtan) % 3.1415927f) / this.e;
            float velocity = getVelocity(fAcos);
            float fAcos2 = (((((float) Math.acos(0.0d)) + ((float) Math.atan(fSqrt2 / (fSqrt * r1)))) + fAtan) % 3.1415927f) / fSqrt2;
            float f = (6.2831855f / fSqrt2) / 2.0f;
            int i = 0;
            float f2 = 0.0f;
            while (true) {
                if (!SpringModelBase.this.c(Math.abs(velocity), SpringModelBase.this.mVelocityThreshold, 0.0f)) {
                    break;
                }
                int i2 = i + 1;
                if (i >= 999.0f) {
                    i = i2;
                    break;
                }
                fAcos += f;
                velocity = getVelocity(fAcos);
                f2 += f;
                fAcos2 += f;
                i = i2;
            }
            float fDoIterate = -1.0f;
            if (i >= 999.0f) {
                this.mDuration = -1.0f;
                return;
            }
            if ((f2 <= fAcos2 && fAcos2 < fAcos) || Math.abs(f2 - fAcos) < 1.0E-6f) {
                fDoIterate = doIterate(fAcos2, f + fAcos2);
            } else if (f2 < fAcos && fAcos < fAcos2) {
                fDoIterate = doIterate(Math.max(0.0f, fAcos2 - f), fAcos2);
            }
            this.mDuration = fDoIterate;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        protected float estimateDuration() {
            return this.mDuration;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        protected float getMaxAbsX() {
            float fSqrt = (float) Math.sqrt((SpringModelBase.this.e * SpringModelBase.this.e) / ((SpringModelBase.this.b * 4.0f) * SpringModelBase.this.d));
            float fSqrt2 = (float) (((double) ((float) Math.sqrt(SpringModelBase.this.d / SpringModelBase.this.b))) * Math.sqrt(1.0f - (fSqrt * fSqrt)));
            float fAcos = (float) (((Math.acos(0.0d) + ((double) ((float) Math.atan(fSqrt2 / (fSqrt * r1))))) + ((double) ((float) Math.atan(this.c / this.d)))) % 3.141592653589793d);
            float fAbs = Math.abs(getPosition(fAcos / fSqrt2));
            int i = 0;
            do {
                float f = (float) (((double) fAcos) + ((((double) i) * 3.141592653589793d) / ((double) fSqrt2)));
                float fAbs2 = Math.abs(getPosition(f));
                if (fAbs < fAbs2) {
                    fAbs = fAbs2;
                }
                if (f >= estimateDuration()) {
                    break;
                }
                i++;
            } while (i < 999.0f);
            if (i >= 999.0f) {
                return -1.0f;
            }
            return fAbs;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        protected float getFirstExtremumX() {
            if (SpringModelBase.this.e == 0.0f || SpringModelBase.this.b == 0.0f || SpringModelBase.this.d == 0.0f || this.d == 0.0f) {
                return 0.0f;
            }
            float fSqrt = (float) Math.sqrt((SpringModelBase.this.e * SpringModelBase.this.e) / ((SpringModelBase.this.b * 4.0f) * SpringModelBase.this.d));
            float fSqrt2 = (float) (((double) ((float) Math.sqrt(SpringModelBase.this.d / SpringModelBase.this.b))) * Math.sqrt(1.0f - (fSqrt * fSqrt)));
            float fAtan = (float) Math.atan(this.c / this.d);
            float fAtan2 = (float) Math.atan(fSqrt2 / (fSqrt * r2));
            if (fSqrt2 == 0.0f) {
                return 0.0f;
            }
            return getPosition((float) ((((Math.acos(0.0d) + ((double) fAtan2)) + ((double) fAtan)) % 3.141592653589793d) / ((double) fSqrt2)));
        }
    }

    private boolean e(float f, float f2) {
        return d(f, 0.0f, f2);
    }

    public Solution a(float f, float f2) {
        float f3 = this.e;
        float f4 = this.b;
        float f5 = f3 * f3;
        float f6 = 4.0f * f4 * this.d;
        int iCompare = Float.compare(f5, f6);
        if (iCompare == 0) {
            float f7 = (-f3) / (f4 * 2.0f);
            return new b(f, f2 - (f7 * f), f7);
        }
        if (iCompare > 0) {
            double d2 = -f3;
            double d3 = f5 - f6;
            double d4 = f4 * 2.0f;
            float fSqrt = (float) ((d2 - Math.sqrt(d3)) / d4);
            float fSqrt2 = (float) ((d2 + Math.sqrt(d3)) / d4);
            float f8 = (f2 - (fSqrt * f)) / (fSqrt2 - fSqrt);
            return new c(f - f8, f8, fSqrt, fSqrt2);
        }
        float f9 = f4 * 2.0f;
        float fSqrt3 = (float) (Math.sqrt(f6 - f5) / ((double) f9));
        float f10 = (-f3) / f9;
        return new a(f, (f2 - (f10 * f)) / fSqrt3, fSqrt3, f10);
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getPosition(float f) {
        if (f < 0.0f) {
            f = (float) ((SystemClock.elapsedRealtime() - this.mStartTime) / 1000.0d);
        }
        if (this.f2007a != null) {
            return this.mEndPosition + this.f2007a.getPosition(f);
        }
        return 0.0f;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getPosition() {
        return getPosition(-1.0f);
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getVelocity(float f) {
        if (f < 0.0f) {
            f = (float) ((SystemClock.elapsedRealtime() - this.mStartTime) / 1000.0d);
        }
        Solution solution = this.f2007a;
        if (solution != null) {
            return solution.getVelocity(f);
        }
        return 0.0f;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getVelocity() {
        return getVelocity(-1.0f);
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getAcceleration(float f) {
        if (f < 0.0f) {
            f = (float) ((SystemClock.elapsedRealtime() - this.mStartTime) / 1000.0d);
        }
        Solution solution = this.f2007a;
        if (solution != null) {
            return solution.getAcceleration(f);
        }
        return 0.0f;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getAcceleration() {
        return getAcceleration(-1.0f);
    }

    public SpringModelBase b(float f, float f2, long j) {
        float fMin = Math.min(99999.0f, Math.max(-99999.0f, f));
        float fMin2 = Math.min(99999.0f, Math.max(-99999.0f, f2));
        if (j <= 0) {
            j = SystemClock.elapsedRealtime();
        }
        if (fMin == this.mEndPosition && e(fMin2, this.mValueThreshold)) {
            return this;
        }
        float f3 = this.mEndPosition;
        if (this.f2007a != null) {
            if (e(fMin2, this.mValueThreshold)) {
                fMin2 = this.f2007a.getVelocity((j - this.mStartTime) / 1000.0f);
            }
            float position = this.f2007a.getPosition((j - this.mStartTime) / 1000.0f);
            if (e(fMin2, this.mValueThreshold)) {
                fMin2 = 0.0f;
            }
            if (e(position, this.mValueThreshold)) {
                position = 0.0f;
            }
            f3 = position + this.mEndPosition;
            if (e(f3 - fMin, this.mValueThreshold) && e(fMin2, this.mValueThreshold)) {
                return this;
            }
        }
        this.mEndPosition = fMin;
        this.mStartPosition = f3;
        this.mStartVelocity = fMin2;
        this.f2007a = a(f3 - this.mEndPosition, fMin2);
        this.mStartTime = j;
        return this;
    }

    public SpringModelBase b(float f, float f2) {
        if (f == this.mEndPosition && e(f2, this.mValueThreshold)) {
            return this;
        }
        this.mStartTime = SystemClock.elapsedRealtime();
        this.mStartPosition = 0.0f;
        this.mEndPosition = f;
        this.mStartVelocity = f2;
        this.f2007a = a(this.mStartPosition - this.mEndPosition, f2);
        return this;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public boolean isAtEquilibrium(float f) {
        if (f < 0.0f) {
            f = SystemClock.elapsedRealtime() - (getStartTime() / 1000.0f);
        }
        return d(getPosition(f), this.mEndPosition, this.mValueThreshold) && e(getVelocity(f), this.mValueThreshold);
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public boolean isAtEquilibrium() {
        return isAtEquilibrium(-1.0f);
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public boolean isAtEquilibrium(float f, float f2) {
        return Math.abs(f2) < this.mVelocityThreshold && Math.abs(f - this.mEndPosition) < this.mValueThreshold;
    }

    public SpringModelBase a(float f) {
        float fMin = Math.min(0.0f, Math.max(0.0f, f));
        this.mStartTime = SystemClock.elapsedRealtime();
        this.mStartPosition = 0.0f;
        this.mEndPosition = fMin;
        this.mStartVelocity = 0.0f;
        this.f2007a = new d();
        return this;
    }

    public SpringModelBase d(float f, float f2, float f3, float f4) {
        super.setValueThreshold(f4);
        this.b = Math.min(Math.max(1.0f, f), 1.0f);
        this.d = Math.min(Math.max(1.0f, f2), 999.0f);
        this.e = Math.min(Math.max(1.0f, f3), 99.0f);
        this.mStartPosition = getPosition(-1.0f);
        this.mStartVelocity = getVelocity(-1.0f);
        this.f2007a = a(this.mStartPosition - this.mEndPosition, this.mStartVelocity);
        this.mStartTime = SystemClock.elapsedRealtime();
        return this;
    }

    public SpringModelBase c(float f) {
        return d(this.b, f, this.e, this.mValueThreshold);
    }

    public SpringModelBase d(float f) {
        return d(this.b, this.d, f, this.mValueThreshold);
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public SpringModelBase setValueThreshold(float f) {
        return d(this.b, this.d, this.e, f);
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getEstimatedDuration() {
        float fEstimateDuration = this.f2007a.estimateDuration();
        if (Float.compare(fEstimateDuration, -1.0f) == 0) {
            return 500.0f;
        }
        return fEstimateDuration * 1000.0f;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getMaxAbsX() {
        Solution solution = this.f2007a;
        if (solution != null) {
            return solution.getMaxAbsX();
        }
        return 0.0f;
    }

    public float d() {
        Solution solution = this.f2007a;
        if (solution != null) {
            return solution.getFirstExtremumX();
        }
        return 0.0f;
    }
}
