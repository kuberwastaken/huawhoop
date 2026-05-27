package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwfoundationmodel.trackmodel.TimeSequence;
import com.huawei.hwfoundationmodel.trackmodel.ValueSequence;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class mfx implements Serializable, TimeSequence, ValueSequence {
    private static final long serialVersionUID = -9166703442296514462L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("mAnalogPower")
    private int f15612a;

    @SerializedName("mTime")
    private long b;

    public mfx() {
    }

    public mfx(long j, int i) {
        this.b = j;
        this.f15612a = i;
    }

    public int e() {
        return this.f15612a;
    }

    public void e(int i) {
        this.f15612a = i;
    }

    public void c(long j) {
        this.b = j;
    }

    @Override // com.huawei.hwfoundationmodel.trackmodel.TimeSequence
    public long acquireTime() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof mfx) && ((mfx) obj).b == this.b;
    }

    @Override // com.huawei.hwfoundationmodel.trackmodel.ValueSequence
    public int acquireValue() {
        return this.f15612a;
    }
}
