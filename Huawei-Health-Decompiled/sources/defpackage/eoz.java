package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class eoz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("androidMinVersion")
    protected String f12705a;

    @SerializedName("ohMinVersion")
    protected String b;

    @SerializedName("iosMinVersion")
    protected String e;

    public String a() {
        return this.f12705a;
    }

    public String toString() {
        return "{androidMinVersion: " + this.f12705a + ", iosMinVersion: " + this.e + ", ohMinVersion: " + this.b + "}";
    }
}
