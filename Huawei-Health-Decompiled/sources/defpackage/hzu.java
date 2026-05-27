package defpackage;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public class hzu implements Serializable {
    private static final long serialVersionUID = 2867379742733736124L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("gear")
    private int f14012a;

    @SerializedName("maxRatio")
    private float b;

    @SerializedName("minRatio")
    private float d;

    @SerializedName("maxWeek")
    private int e;

    public int a() {
        return this.f14012a;
    }

    public void e(int i) {
        this.f14012a = i;
    }

    public void c(float f) {
        this.d = f;
    }

    public void e(float f) {
        this.b = f;
    }

    public void c(int i) {
        this.e = i;
    }

    public String toString() {
        return "FatLossRatio{mGear=" + this.f14012a + ", mMinRatio=" + this.d + ", mMaxRatio=" + this.b + ", mMaxWeek=" + this.e + '}';
    }
}
