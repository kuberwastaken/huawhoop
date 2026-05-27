package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes5.dex */
public class hzt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("subCategory")
    private int f14011a;

    @SerializedName("fatInfo")
    private hzx b;

    @SerializedName("category")
    private int c;

    @SerializedName("startDay")
    private int d;

    @SerializedName("lastCaloriesGapWeight")
    private double e;

    @SerializedName("weightManagerType")
    private int g;

    @SerializedName("updateTime")
    private long h;

    public hzx d() {
        return this.b;
    }

    public long a() {
        return this.h;
    }

    public String toString() {
        return "GoalDetail{mCategory=" + this.c + ", mSubCategory=" + this.f14011a + ", mLastCaloriesGapWeight=" + this.e + ", mWeightManagerType=" + this.g + ", mStartDay=" + this.d + ", mSimpleFatInfo=" + this.b + ", mUpdateTime=" + this.h + '}';
    }
}
