package defpackage;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class olp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("cpuAllowList")
    private List<String> f16434a;

    @SerializedName("brandMode")
    private String b;

    @SerializedName("mtkBrandAllowList")
    private List<String> c;

    @SerializedName("mtkCpuAllowList")
    private List<String> d;

    @SerializedName("brandAllowList")
    private List<String> e;

    @SerializedName("shieldingStatus")
    private String g;

    @SerializedName("deviceModel")
    private List<String> j;

    public List<String> d() {
        return this.d;
    }

    public List<String> c() {
        return this.f16434a;
    }

    public List<String> e() {
        return this.e;
    }

    public List<String> b() {
        return this.c;
    }

    public String a() {
        return this.b;
    }

    public String h() {
        return this.g;
    }

    public List<String> g() {
        return this.j;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
