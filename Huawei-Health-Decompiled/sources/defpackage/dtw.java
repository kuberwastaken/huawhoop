package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class dtw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("standardIntakeLower")
    private int f12422a;

    @SerializedName("standardIntakeUpper")
    private int d;

    public int e() {
        return this.f12422a;
    }

    public int a() {
        return this.d;
    }

    public String toString() {
        return "NutritionAnalysisItem{mStandardIntakeLower=" + this.f12422a + ", mStandardIntakeUpper=" + this.d + '}';
    }
}
