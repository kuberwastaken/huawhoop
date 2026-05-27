package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class eqm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("id")
    private String f12737a;

    @SerializedName("type")
    private String b;

    public eqm(String str, String str2) {
        this.b = str;
        this.f12737a = str2;
    }

    public String toString() {
        return "GetUserSampleConfig{mType=" + this.b + ", mId=" + this.f12737a + "}";
    }
}
