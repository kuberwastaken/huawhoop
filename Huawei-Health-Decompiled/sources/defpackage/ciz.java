package defpackage;

import android.util.Log;
import com.huawei.dynamicanimation.util.FollowHandRate;

/* JADX INFO: loaded from: classes3.dex */
public class ciz implements FollowHandRate {
    private float c;
    private float d;
    private float e;

    public ciz(float f, float f2) {
        this.d = 0.75f;
        this.c = f;
        this.e = f2;
    }

    public ciz(float f) {
        this(f, 1.848f);
    }

    @Override // com.huawei.dynamicanimation.util.FollowHandRate
    public float getRate(float f) {
        if (Float.compare(f, 0.0f) < 0) {
            throw new IllegalArgumentException("input can not less than zero!!");
        }
        float f2 = this.c;
        if (f2 == 0.0f) {
            return 0.0f;
        }
        float f3 = f / f2;
        if (Float.compare(f3, 1.0f) > 0) {
            f3 = 1.0f;
        }
        float f4 = f3 * this.d;
        float fExp = (float) Math.exp(-(this.e * f4));
        Log.d("DynamicCurveRate", "getRate: x=" + f4 + ",rate=" + fExp + ",input=" + f);
        return fExp;
    }
}
