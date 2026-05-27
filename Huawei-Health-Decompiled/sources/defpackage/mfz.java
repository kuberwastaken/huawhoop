package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwfoundationmodel.trackmodel.TimeSequence;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class mfz implements Serializable, TimeSequence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("mAnalogCadence")
    private int f15614a;

    @SerializedName("mTime")
    private long b;

    public mfz() {
    }

    public mfz(long j, int i) {
        this.b = j;
        this.f15614a = i;
    }

    public int e() {
        return this.f15614a;
    }

    public void e(int i) {
        this.f15614a = i;
    }

    public void d(long j) {
        this.b = j;
    }

    @Override // com.huawei.hwfoundationmodel.trackmodel.TimeSequence
    public long acquireTime() {
        return this.b;
    }

    public String toString() {
        return "mAnalogCadence=" + this.f15614a + ", mTime=" + this.b;
    }
}
