package defpackage;

import com.huawei.animation.physical2.util.FollowHandRate;

/* JADX INFO: loaded from: classes10.dex */
public class avy implements FollowHandRate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f363a = 0.75f;
    private float c;
    private float d;

    public avy(float f, float f2) {
        this.d = f;
        this.c = f2;
    }

    @Override // com.huawei.animation.physical2.util.FollowHandRate
    public float getRate(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("input can not less than zero!!");
        }
        float f2 = this.d;
        if (f2 == 0.0f) {
            return 0.0f;
        }
        float f3 = f / f2;
        if (Float.compare(f3, 1.0f) > 0) {
            f3 = 1.0f;
        }
        return (float) Math.exp(-(((double) this.c) * ((double) (f3 * this.f363a))));
    }

    public avy b(float f) {
        this.c = f;
        return this;
    }
}
