package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class epf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("selectRulekey")
    protected String f12711a;

    @SerializedName("configName")
    protected String b;

    @SerializedName("fileData")
    protected List<epe> c;

    @SerializedName("selectRulevalue")
    protected String d;

    @SerializedName("filterCondition")
    protected List<eph> e;

    public epf(String str) {
        this.b = str;
    }

    public String e() {
        return this.b;
    }

    public List<epe> c() {
        List<epe> list = this.c;
        return list == null ? new ArrayList() : list;
    }

    public void a(List<epe> list) {
        this.c = list;
    }

    public List<eph> a() {
        List<eph> list = this.e;
        return list == null ? new ArrayList() : list;
    }

    public void b(List<eph> list) {
        this.e = list;
    }

    public String d() {
        return this.f12711a;
    }

    public String b() {
        return this.d;
    }
}
