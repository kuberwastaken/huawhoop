package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class ozm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("mean")
    private String f16575a;

    @SerializedName("abnormalDays")
    private int b;

    @SerializedName("meanDia")
    private int c;

    @SerializedName("meanSys")
    private int d;

    @SerializedName("goalMetCount")
    private int e;

    @SerializedName("textID")
    private int h;

    public int g() {
        return this.h;
    }

    public int d() {
        return this.e;
    }

    public String c() {
        return this.f16575a;
    }

    public int e() {
        return this.d;
    }

    public int a() {
        return this.c;
    }

    public int b() {
        return this.b;
    }

    public String toString() {
        return "Data{mTextId=" + this.h + ", mGoalMetCount=" + this.e + ", mMean=" + this.f16575a + ", mAbnormalDays=" + this.b + '}';
    }
}
