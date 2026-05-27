package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class tqw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("eatTime")
    private long f18118a;

    @SerializedName("whichMeal")
    private int b;

    @SerializedName("hasFood")
    private boolean c;

    @SerializedName("sugRange")
    private int[] d;

    @SerializedName("kiloCalorie")
    private float e;

    public tqw(int i, long j, float f, int[] iArr) {
        this.b = i;
        this.f18118a = j;
        this.e = f;
        this.d = iArr;
    }

    public void c(boolean z) {
        this.c = z;
    }
}
