package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class hox {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("isClears")
    private Boolean f13910a;

    @SerializedName("isLoop")
    private Boolean b;

    @SerializedName("defaultClearIndex")
    private Integer c;

    @SerializedName("clearMap")
    private Map<String, String> d;

    @SerializedName("screenType")
    private int e;

    @SerializedName("url")
    private String f;

    @SerializedName("videoName")
    private String j;

    public Integer c() {
        return Integer.valueOf(this.e);
    }

    public String d() {
        return this.f;
    }

    public String b() {
        return this.j;
    }

    public Boolean h() {
        return this.b;
    }

    public Boolean f() {
        return this.f13910a;
    }

    public Map<String, String> a() {
        return this.d;
    }

    public Integer e() {
        return this.c;
    }
}
