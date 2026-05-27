package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class gng {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("unit")
    private String f13549a;

    @SerializedName("unitValue")
    private int e;

    public String c() {
        return this.f13549a;
    }

    public int e() {
        return this.e;
    }

    public String toString() {
        return "FoodExtensionUnits{mUnit=" + this.f13549a + ", mUnitValue=" + this.e + "}";
    }
}
