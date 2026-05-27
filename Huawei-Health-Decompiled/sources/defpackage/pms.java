package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class pms {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("configName")
    private String f16780a;

    @SerializedName("isOpenArkuix")
    private int b;

    @SerializedName("supportHuid")
    private List<Integer> c;

    @SerializedName("releaseSupportDevice")
    private List<String> d;

    @SerializedName("blockHuid")
    private List<String> e;

    @SerializedName("supportVersions")
    private List<pmu> f;

    @SerializedName("whiteCountryCode")
    private List<String> i;

    public List<pmu> e() {
        return this.f;
    }

    public List<Integer> d() {
        return this.c;
    }

    public List<String> b() {
        return this.e;
    }

    public List<String> j() {
        return this.i;
    }

    public List<String> a() {
        return this.d;
    }

    public int c() {
        return this.b;
    }

    public String toString() {
        return "ArkuixPageConfigBean{mConfigName=" + this.f16780a + ", mSupportVersions=" + this.f + ", mSupportHuid=" + this.c + ", mBlockHuid=" + this.e + ", mWhiteCountryCode=" + this.i + ", mReleaseSupportDevice=" + this.d + ", mOpenArkuix=" + this.b + '}';
    }
}
