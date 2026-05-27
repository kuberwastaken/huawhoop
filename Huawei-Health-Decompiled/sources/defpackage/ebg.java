package defpackage;

import com.huawei.health.device.open.data.model.HealthData;

/* JADX INFO: loaded from: classes4.dex */
public class ebg extends HealthData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f12526a;
    private long b;
    private long d;

    public float a() {
        return this.f12526a;
    }

    public void c(float f) {
        this.f12526a = f;
    }

    @Override // com.huawei.health.device.open.data.model.HealthData
    public long getStartTime() {
        return this.d;
    }

    @Override // com.huawei.health.device.open.data.model.HealthData
    public void setStartTime(long j) {
        this.d = j;
    }

    @Override // com.huawei.health.device.open.data.model.HealthData
    public long getEndTime() {
        return this.b;
    }

    @Override // com.huawei.health.device.open.data.model.HealthData
    public void setEndTime(long j) {
        this.b = j;
    }

    @Override // com.huawei.health.device.open.data.model.HealthData
    public String toString() {
        return "BodyTemperature [mStartTime=" + this.d + ", mEndTime=" + this.b + "]";
    }
}
