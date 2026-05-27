package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class eoy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("countryList")
    protected List<String> f12704a;

    @SerializedName("blockProductList")
    protected List<eox> b;

    @SerializedName("extInfo")
    protected Map c;

    @SerializedName("packageName")
    protected String d;

    @SerializedName("support")
    protected Integer e;

    @SerializedName("supportVersion")
    protected eoz j;

    public String a() {
        return this.d;
    }

    public Integer d() {
        return this.e;
    }

    public eoz e() {
        return this.j;
    }

    public Map c() {
        Map map = this.c;
        return map == null ? new HashMap() : map;
    }
}
