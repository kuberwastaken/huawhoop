package defpackage;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class hzy implements Serializable {
    private static final long serialVersionUID = 468976053049501463L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("onePointFull")
    private hzs f14016a;

    @SerializedName("activityCalGoal")
    private int b;

    @SerializedName("fatLossRatio")
    private hzu c;

    @SerializedName("caloricDeficitGoal")
    private int d;

    @SerializedName("weightInit")
    private float e;

    @SerializedName("weightManagerType")
    private int f;

    @SerializedName("proportionMeal")
    private hzq i;

    public int h() {
        return this.f;
    }

    public void c(int i) {
        this.f = i;
    }

    public float b() {
        return this.e;
    }

    public void c(float f) {
        this.e = f;
    }

    public int c() {
        return this.d;
    }

    public void b(int i) {
        this.d = i;
    }

    public int a() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public void c(hzq hzqVar) {
        this.i = hzqVar;
    }

    public hzu d() {
        return this.c;
    }

    public void a(hzu hzuVar) {
        this.c = hzuVar;
    }

    public hzs e() {
        return this.f14016a;
    }

    public void a(hzs hzsVar) {
        this.f14016a = hzsVar;
    }

    public String toString() {
        return "WeightManager{mWeightManagerType=" + this.f + ", mInitWeight=" + this.e + ", mCaloricDeficitGoal=" + this.d + ", mActivityCalGoal=" + this.b + ", mProportionMeal=" + this.i + ", mFatLossRatio=" + this.c + ", mOnePointFull=" + this.f14016a + '}';
    }
}
