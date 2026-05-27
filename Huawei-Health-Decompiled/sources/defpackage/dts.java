package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class dts {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("coefficient")
    private int f12420a = 1;

    @SerializedName("fat")
    private int b;

    @SerializedName("carbohydratesSugRange")
    private int[] c;

    @SerializedName("fatSugRange")
    private int[] d;

    @SerializedName("carbohydrates")
    private int e;

    @SerializedName("proteinSugRange")
    private int[] f;

    @SerializedName("protein")
    private int j;

    public dts(int i, int i2, int i3) {
        this.e = i;
        this.j = i2;
        this.b = i3;
    }

    public void a(int[] iArr) {
        this.c = iArr;
    }

    public void e(int[] iArr) {
        this.f = iArr;
    }

    public void c(int[] iArr) {
        this.d = iArr;
    }

    public String toString() {
        return "DeviceSyncDietAnalysis{mCoefficient=" + this.f12420a + ", mCarbohydrates=" + this.e + ", mProtein=" + this.j + ", mFat=" + this.b + ", mCarbohydratesSugRange=" + Arrays.toString(this.c) + ", mProteinSugRange=" + Arrays.toString(this.f) + ", mFatSugRange=" + Arrays.toString(this.d) + '}';
    }
}
