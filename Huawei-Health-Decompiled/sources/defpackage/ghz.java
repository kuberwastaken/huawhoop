package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.updatesdk.service.otaupdate.UpdateKey;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ghz extends ghx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("name")
    private String f13465a;

    @SerializedName("templateTypeList")
    private List<String> b;

    @SerializedName("status")
    private int c;

    @SerializedName(UpdateKey.MARKET_DLD_STATUS)
    private int d;

    @SerializedName("index")
    private int e = -1;

    @SerializedName("thumbnailSize")
    private int g;

    @SerializedName("thumbnailPath")
    private String h;

    @SerializedName("thumbnail")
    private String i;

    public String c() {
        return this.f13465a;
    }

    public String a() {
        return this.i;
    }

    public int h() {
        return this.g;
    }

    public String i() {
        return this.h;
    }

    public void e(String str) {
        this.h = str;
    }

    public int b() {
        return this.d;
    }

    public void c(int i) {
        this.d = i;
    }

    public int e() {
        return this.e;
    }

    public void a(int i) {
        this.e = i;
    }

    public List<String> d() {
        return this.b;
    }
}
