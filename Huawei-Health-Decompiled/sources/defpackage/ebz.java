package defpackage;

import com.google.common.primitives.UnsignedBytes;
import com.huawei.health.device.open.data.model.HealthData;
import com.huawei.health.ecologydevice.open.data.model.IHeartRateAndBloodPressure;
import java.util.Calendar;

/* JADX INFO: loaded from: classes4.dex */
public class ebz extends HealthData implements IHeartRateAndBloodPressure {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f12530a;
    private short b;
    private short c;
    private long d;
    private short e;

    public static int d(byte b) {
        return b & UnsignedBytes.MAX_VALUE;
    }

    @Override // com.huawei.health.ecologydevice.open.data.model.IHeartRateAndBloodPressure
    public short getSystolic() {
        return this.e;
    }

    @Override // com.huawei.health.ecologydevice.open.data.model.IHeartRateAndBloodPressure
    public void setSystolic(short s) {
        this.e = s;
    }

    @Override // com.huawei.health.ecologydevice.open.data.model.IHeartRateAndBloodPressure
    public short getDiastolic() {
        return this.b;
    }

    @Override // com.huawei.health.ecologydevice.open.data.model.IHeartRateAndBloodPressure
    public void setDiastolic(short s) {
        this.b = s;
    }

    @Override // com.huawei.health.device.open.data.model.HealthData
    public long getStartTime() {
        return this.f12530a;
    }

    @Override // com.huawei.health.device.open.data.model.HealthData
    public void setStartTime(long j) {
        this.f12530a = j;
    }

    @Override // com.huawei.health.device.open.data.model.HealthData
    public long getEndTime() {
        return this.d;
    }

    @Override // com.huawei.health.device.open.data.model.HealthData
    public void setEndTime(long j) {
        this.d = j;
    }

    @Override // com.huawei.health.ecologydevice.open.data.model.IHeartRateAndBloodPressure
    public short getHeartRate() {
        return this.c;
    }

    @Override // com.huawei.health.ecologydevice.open.data.model.IHeartRateAndBloodPressure
    public void setHeartRate(short s) {
        this.c = s;
    }

    public void a(byte[] bArr) {
        setSystolic((short) d(bArr[3]));
        setDiastolic((short) d(bArr[4]));
        setStartTime(Calendar.getInstance().getTimeInMillis());
        setHeartRate((short) d(bArr[2]));
    }
}
