package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class dtr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("unitValue")
    private int f12419a;

    @SerializedName("unit")
    private String e;

    public String a() {
        return this.e;
    }

    public int c() {
        return this.f12419a;
    }

    public String toString() {
        return "ExtensionUnit{mUnit=" + this.e + ", mUnitValue=" + this.f12419a + '}';
    }
}
