package defpackage;

import com.huawei.dynamicanimation.DynamicAnimation;
import com.huawei.dynamicanimation.SpringModelBase;

/* JADX INFO: loaded from: classes3.dex */
public class cja extends SpringModelBase {
    private final DynamicAnimation.b b;
    private float d;

    public cja(float f, float f2) {
        super(f, f2, c);
        this.d = 0.0f;
        this.b = new DynamicAnimation.b();
    }

    public cja c() {
        this.d = 0.0f;
        this.b.e = 0.0f;
        this.b.f2005a = 0.0f;
        return this;
    }

    public DynamicAnimation.b d(long j) {
        float f = this.d + j;
        this.d = f;
        float f2 = f / 1000.0f;
        this.b.e = getPosition(f2);
        this.b.f2005a = getVelocity(f2);
        return this.b;
    }
}
