package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class tro {

    @SerializedName("initialWeight")
    private float e = 0.0f;

    @SerializedName("targetWeight")
    private float b = 0.0f;

    @SerializedName("fulfilledTime")
    private long d = 0;

    public void d(float f) {
        this.e = f;
    }

    public void e(float f) {
        this.b = f;
    }

    public String toString() {
        return "WeightControlSetting{mInitialWeight=" + this.e + ", mTargetWeight=" + this.b + ", mFulfilledTime=" + this.d + '}';
    }
}
