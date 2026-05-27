package com.huawei.health.weight.bean;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class WeightTargetDifferences {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("maintainTargetWeightRange")
    private int f3615a;

    @SerializedName("targetDifferences")
    private double c;

    @SerializedName("targetFinishDate")
    private long d;

    @SerializedName("targetBeginDate")
    private long e;

    /* JADX INFO: loaded from: classes5.dex */
    public enum WeightTargetType {
        WEIGHT_GAIN,
        WEIGHT_LOSS,
        WEIGHT_KEE
    }

    public WeightTargetDifferences(double d, long j, long j2, int i) {
        a(d);
        this.e = j;
        this.d = j2;
        this.f3615a = i;
    }

    public void d(double d) {
        a(d);
    }

    private void a(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            return;
        }
        this.c = d;
    }

    public double a() {
        return this.c;
    }

    public long c() {
        return this.d;
    }

    public long d() {
        return this.e;
    }

    public int b() {
        return this.f3615a;
    }

    public String toString() {
        return "WeightTargetDifferences{mTargetDifferences=" + this.c + ", mTargetBeginDate=" + this.e + ", mTargetFinishDate=" + this.d + ", mMaintainTargetWeightRange=" + this.f3615a + "}";
    }

    public WeightTargetType e() {
        double d = this.c;
        if (d == 0.0d) {
            return WeightTargetType.WEIGHT_KEE;
        }
        if (d < 0.0d) {
            return WeightTargetType.WEIGHT_GAIN;
        }
        return WeightTargetType.WEIGHT_LOSS;
    }
}
