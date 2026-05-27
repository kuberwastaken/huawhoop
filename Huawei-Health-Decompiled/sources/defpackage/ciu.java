package defpackage;

import android.util.Log;
import com.huawei.dynamicanimation.PhysicalModelBase;

/* JADX INFO: loaded from: classes3.dex */
public class ciu extends PhysicalModelBase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f660a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private boolean i;

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getAcceleration() {
        return 0.0f;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getAcceleration(float f) {
        return 0.0f;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public boolean isAtEquilibrium(float f) {
        return false;
    }

    public ciu(float f, float f2) {
        this(f, f2, 0.75f);
    }

    public ciu(float f, float f2, float f3) {
        this.f660a = 0.0f;
        this.i = true;
        super.setValueThreshold(f3);
        a(f);
        d(f2);
    }

    private void a() {
        if (this.i) {
            b();
            float fLog = ((float) (Math.log(this.mVelocityThreshold / this.e) / ((double) this.c))) * 1000.0f;
            this.d = fLog;
            float fMax = Math.max(fLog, 0.0f);
            this.d = fMax;
            this.b = getPosition(fMax / 1000.0f);
            this.i = false;
            Log.i("FlingModelBase", "reset: estimateTime=" + this.d + ",estimateValue=" + this.b);
        }
    }

    public void b() {
        if (cjh.b(this.e)) {
            throw new UnsupportedOperationException("InitVelocity should be set and can not be 0!!");
        }
        if (cjh.b(this.c)) {
            throw new UnsupportedOperationException("Friction should be set and can not be 0!!");
        }
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getPosition(float f) {
        this.f660a = f;
        return this.f * ((float) (((double) (this.e / this.c)) * (Math.exp(r2 * f) - 1.0d)));
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getPosition() {
        return getPosition(this.f660a);
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getVelocity(float f) {
        return this.f * ((float) (((double) this.e) * Math.exp(this.c * f)));
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getVelocity() {
        return getVelocity(this.f660a);
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public boolean isAtEquilibrium() {
        return this.e < this.mVelocityThreshold;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public boolean isAtEquilibrium(float f, float f2) {
        return Math.abs(f - getEndPosition()) < this.mValueThreshold && Math.abs(f2) < this.mVelocityThreshold;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getEstimatedDuration() {
        a();
        return this.d;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getEndPosition() {
        a();
        return this.b;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public final PhysicalModelBase setValueThreshold(float f) {
        super.setValueThreshold(f);
        this.i = true;
        return this;
    }

    public final <T extends PhysicalModelBase> T a(float f) {
        this.e = Math.abs(f);
        this.f = Math.signum(f);
        this.i = true;
        return this;
    }

    public final <T extends PhysicalModelBase> T d(float f) {
        this.c = f * (-4.2f);
        this.i = true;
        return this;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getMaxAbsX() {
        a();
        return this.b;
    }
}
