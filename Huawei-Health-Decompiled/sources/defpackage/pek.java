package defpackage;

import android.graphics.RectF;
import com.huawei.hwcommonmodel.fitnessdatatype.HeartRateThresholdConfig;

/* JADX INFO: loaded from: classes7.dex */
public class pek {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16656a;
    private int b;
    private float[] e;
    private int f = 40;
    private int h = HeartRateThresholdConfig.HEART_RATE_LIMIT;
    private int c = 0;
    private int d = 0;
    private int i = 0;

    public pek(int i, int i2) {
        this.b = i2;
        this.e = new float[i2];
        this.f16656a = i;
    }

    public void a(int i, int i2) {
        this.f = i;
        this.h = i2;
    }

    public void c(float f) {
        float[] fArr = this.e;
        int i = this.d;
        fArr[i] = f;
        int i2 = i + 1;
        this.d = i2;
        int i3 = this.b;
        int i4 = i2 % i3;
        this.d = i4;
        int i5 = this.c;
        int i6 = i4 < i5 ? (i4 + i3) - i5 : i4 - i5;
        int i7 = this.f16656a;
        if (i6 > i7) {
            int i8 = i5 + 1;
            this.c = i8;
            int i9 = i8 % i3;
            this.c = i9;
            if (((i4 + i3) - this.i) % i3 > i7) {
                this.i = i9;
            }
        }
    }

    public float[] c() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = this.d;
        int i6 = this.i;
        if (i5 == i6) {
            i = 0;
        } else {
            if (i5 < i6) {
                i5 += this.b;
            }
            i = (i5 - i6) - 1;
        }
        float[] fArr = new float[i * 4];
        int i7 = 0;
        while (true) {
            int i8 = this.d;
            if (i6 == i8 || (i4 = (i2 = i6 + 1) % (i3 = this.b)) == i8) {
                break;
            }
            fArr[i7] = i6;
            float[] fArr2 = this.e;
            fArr[i7 + 1] = fArr2[i6];
            fArr[i7 + 2] = i2;
            if (i2 == i3) {
                fArr[i7 + 3] = fArr2[0];
            } else {
                fArr[i7 + 3] = fArr2[i2];
            }
            i7 += 4;
            i6 = i4;
        }
        return fArr;
    }

    public RectF[] cKw_() {
        int i = this.d;
        int i2 = this.c;
        if (i == i2) {
            return new RectF[0];
        }
        if (i > i2) {
            return new RectF[]{new RectF(this.c, this.h, this.d - 1, this.f)};
        }
        if (i == 0) {
            return new RectF[]{new RectF(this.c, this.h, this.b - 1, this.f)};
        }
        if (i == 1) {
            return new RectF[]{new RectF(this.c, this.h, this.b, this.f)};
        }
        return new RectF[]{new RectF(this.c, this.h, this.b, this.f), new RectF(0.0f, this.h, this.d - 1, this.f)};
    }

    public void e() {
        int i = this.d;
        if (i == this.c) {
            this.i = i;
        } else {
            this.i = ((i + r1) - 1) % this.b;
        }
    }
}
