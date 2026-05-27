package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;

/* JADX INFO: loaded from: classes.dex */
public class tqx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("activityCalGoal")
    private int f18119a;

    @SerializedName(ParsedFieldTag.GOAL)
    private float b;

    @SerializedName("caloricDeficitGoal")
    private int c;

    @SerializedName("canTake")
    private float d;

    @SerializedName("consumption")
    private float e;

    @SerializedName("restingCalories")
    private float f;

    @SerializedName("updateTime")
    private long g;

    @SerializedName("inTake")
    private float h;

    @SerializedName("weekGoalDiff")
    private double i;

    @SerializedName("restingCaloriesBurned")
    private int j;

    public tqx(float f, float f2, float f3, float f4) {
        this.h = f;
        this.e = f2;
        this.b = f3;
        this.f = f4;
        this.d = Math.max(f3 - f, 0.0f);
    }

    public void b(float f) {
        float f2 = this.h + f;
        this.h = f2;
        float f3 = this.b - f2;
        this.d = f3;
        this.d = Math.max(0.0f, f3);
    }

    public void d(float f) {
        this.h = f;
        float f2 = this.b - f;
        this.d = f2;
        this.d = Math.max(0.0f, f2);
    }

    public float f() {
        return this.h;
    }

    public float d() {
        return this.d;
    }

    public float e() {
        return this.e;
    }

    public float b() {
        return this.b;
    }

    public float g() {
        return this.f;
    }

    public double h() {
        return this.i;
    }

    public void e(double d) {
        this.i = d;
    }

    public void a(float f) {
        this.e = f;
        float f2 = this.b - this.h;
        this.d = f2;
        this.d = Math.max(0.0f, f2);
    }

    public void c(float f) {
        this.b = f;
        float f2 = f - this.h;
        this.d = f2;
        this.d = Math.max(0.0f, f2);
    }

    public void e(float f) {
        this.f = f;
    }

    public int j() {
        return this.j;
    }

    public void a(int i) {
        this.j = i;
    }

    public int a() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
    }

    public int c() {
        return this.f18119a;
    }

    public void e(int i) {
        this.f18119a = i;
    }

    public long i() {
        return this.g;
    }

    public void a(long j) {
        this.g = j;
    }

    public String toString() {
        return "DietCalorieOverview{mInTake=" + this.h + ", mCanTake=" + this.d + ", mConsumption=" + this.e + ", mGoal=" + this.b + ", mRestingCalories=" + this.f + ", mRestingCaloriesBurned=" + this.j + ", mWeekGoalDiff=" + this.i + ", mCaloricDeficitGoal=" + this.c + ", mActivityCalGoal=" + this.f18119a + ", mUpdateTime=" + this.g + '}';
    }
}
