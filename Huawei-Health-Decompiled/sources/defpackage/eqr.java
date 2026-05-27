package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class eqr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("userTimes")
    private int f12741a;

    @SerializedName("userWeekTimes")
    private int b;

    @SerializedName("people")
    private int c;

    @SerializedName("rank")
    private int d;

    @SerializedName("id")
    private int e;

    @SerializedName("weekRank")
    private int f;

    @SerializedName("weekNo")
    private int g;

    public int a() {
        return this.e;
    }

    public int c() {
        return this.d;
    }

    public int e() {
        return this.c;
    }

    public int d() {
        return this.g;
    }

    public int b() {
        return this.f;
    }

    public String toString() {
        return "Stats{mId=" + this.e + ", mRank=" + this.d + ", mPeople=" + this.c + ", mWeekNo=" + this.g + ", mWeekRank=" + this.f + ", mUserTimes=" + this.f12741a + ", mUserWeekTimes=" + this.b + "}";
    }
}
