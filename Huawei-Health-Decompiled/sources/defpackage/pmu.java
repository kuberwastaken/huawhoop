package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class pmu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("vWhiteCountryCode")
    private List<String> f16782a;

    @SerializedName("vReleaseSupportDevice")
    private List<String> b;

    @SerializedName("vSupportHuid")
    private List<Integer> c;

    @SerializedName("vBlockHuid")
    private List<String> d;

    @SerializedName("vVersionName")
    private String e;

    public String d() {
        return this.e;
    }

    public List<Integer> e() {
        return this.c;
    }

    public List<String> b() {
        return this.d;
    }

    public List<String> a() {
        return this.f16782a;
    }

    public List<String> c() {
        return this.b;
    }

    public String toString() {
        return "VersionInnerConfigBean{mVersionName=" + this.e + ", mSupportHuid=" + this.c + ", mBlockHuid=" + this.d + ", mWhiteCountryCode=" + this.f16782a + ", mReleaseSupportDevice=" + this.b + '}';
    }
}
