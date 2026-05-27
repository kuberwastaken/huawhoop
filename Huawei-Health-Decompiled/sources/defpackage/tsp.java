package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class tsp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("targetWeight")
    private double f18137a;

    @SerializedName("fatBurnChoice")
    private int b;

    @SerializedName("targetSettingChanged")
    private int e;

    public void e(double d) {
        this.f18137a = d;
    }

    public void e(int i) {
        this.e = i;
    }

    public void b(int i) {
        this.b = i;
    }

    public String toString() {
        return "Goal{targetWeight=" + this.f18137a + ", targetSettingChanged=" + this.e + ", fatBurnChoice=" + this.b + '}';
    }
}
