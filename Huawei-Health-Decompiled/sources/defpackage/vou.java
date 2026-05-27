package defpackage;

import android.view.animation.AnimationUtils;
import com.huawei.dynamicanimation.SpringModelBase;

/* JADX INFO: loaded from: classes8.dex */
public class vou extends SpringModelBase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f18702a;
    private float b;
    private float d;
    private long e;

    public vou(float f, float f2, float f3, float f4, float f5) {
        super(f, f2, 0.001f);
        this.f18702a = f3;
        this.d = f3;
        this.b = f5;
        setValueThreshold(1.0f);
        a(0.0f);
        b(f4 - this.f18702a, f5, -1L);
        this.e = AnimationUtils.currentAnimationTimeMillis();
    }

    public boolean a() {
        float fCurrentAnimationTimeMillis = (AnimationUtils.currentAnimationTimeMillis() - this.e) / 1000.0f;
        this.b = getVelocity(fCurrentAnimationTimeMillis);
        float position = getPosition(fCurrentAnimationTimeMillis);
        float f = this.f18702a;
        float f2 = position + f;
        this.d = f2;
        if (!isAtEquilibrium(f2 - f, this.b)) {
            return false;
        }
        this.d = getEndPosition() + this.f18702a;
        this.b = 0.0f;
        return true;
    }

    public float e() {
        return this.d;
    }

    public void c(long j) {
        this.e -= j;
    }
}
