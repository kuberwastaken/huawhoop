package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class pbg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("encourageType")
    private int f16609a;

    @SerializedName("achieveDays")
    private int b;

    @SerializedName("needAchieveDays")
    private int c;

    @SerializedName("encourageDate")
    private int d;

    @SerializedName("currentDayAchievable")
    private int e;

    public int e() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.f16609a;
    }

    public boolean b() {
        return this.e == 1;
    }
}
