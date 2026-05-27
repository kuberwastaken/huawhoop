package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes9.dex */
public class fhr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("appIconPath")
    private String f12957a;

    @SerializedName("appName")
    private String b;

    @SerializedName("packageName")
    private String c;

    @SerializedName("deviceTypes")
    private Set<Integer> d;

    @SerializedName("authTime")
    private String e;

    @SerializedName("url2Desc")
    private Map<String, String> i;

    public Map<String, String> g() {
        return this.i;
    }

    public String a() {
        return this.e;
    }

    public String c() {
        return this.b;
    }

    public Set<Integer> d() {
        return this.d;
    }

    public String b() {
        return this.f12957a;
    }

    public String e() {
        return this.c;
    }
}
