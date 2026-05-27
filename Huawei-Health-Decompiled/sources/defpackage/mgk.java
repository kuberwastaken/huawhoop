package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwfoundationmodel.trackmodel.TimeSequence;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class mgk implements Serializable, TimeSequence {
    private static final long serialVersionUID = -1986945515238572057L;

    @SerializedName("mTime")
    private long b;

    @SerializedName("mRealTimeSpeed")
    private float e;

    public mgk(long j, float f) {
        this.b = j;
        this.e = f;
    }

    public float a() {
        return this.e;
    }

    public float d() {
        return (this.e / 10.0f) * 3.6f;
    }

    public float c() {
        if (Math.abs(this.e) > 1.0E-5d) {
            return 10000.0f / this.e;
        }
        return 0.0f;
    }

    public String toString() {
        return this.b + ":" + this.e;
    }

    public mgn b() {
        return new mgn(this.b, Math.round(c()));
    }

    public mgm e() {
        return new mgm(this.b, d());
    }

    @Override // com.huawei.hwfoundationmodel.trackmodel.TimeSequence
    public long acquireTime() {
        return this.b;
    }
}
