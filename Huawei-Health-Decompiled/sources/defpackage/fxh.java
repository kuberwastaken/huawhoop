package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class fxh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("totalExerciseDuration")
    private double f13331a;

    @SerializedName("totalRunningDistance")
    private double b;

    @SerializedName("totalCourseNum")
    private int c;

    @SerializedName("completedCourseNum")
    private int e;

    public int a() {
        return this.e;
    }

    public int b() {
        return this.c;
    }

    public double c() {
        return this.b;
    }

    public double d() {
        return this.f13331a;
    }

    public String toString() {
        return "PlanProgressInfo{mCompletedCourseNum=" + this.e + ", mTotalCourseNum=" + this.c + ", mTotalRunningDistance=" + this.b + ", mTotalExerciseDuration=" + this.f13331a + '}';
    }
}
