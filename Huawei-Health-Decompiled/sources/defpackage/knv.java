package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.operation.utils.Constants;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class knv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(Constants.VMALL_ARG_TYPE)
    private Integer f14775a;

    @SerializedName("fromVersion")
    private String b;

    @SerializedName("branchId")
    private int c;

    @SerializedName("country")
    private String d;

    @SerializedName("contentTag")
    private String e;

    @SerializedName("latestVersion")
    private long f;

    @SerializedName("isAgree")
    private boolean g;

    @SerializedName("needSign")
    private boolean h;

    @SerializedName("language")
    private String i;

    @SerializedName("greyKeyWordList")
    private List<String> j;

    @SerializedName("signTime")
    private long k;

    @SerializedName("version")
    private long m;

    @SerializedName("newestVersion")
    private long n;

    public Integer a() {
        return this.f14775a;
    }

    public long e() {
        return this.m;
    }

    public long b() {
        return this.n;
    }

    public boolean c() {
        return this.h;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HonorPrivacy{agrType=");
        stringBuffer.append(this.f14775a);
        stringBuffer.append(", country=").append(this.d);
        stringBuffer.append(", branchId=").append(this.c);
        stringBuffer.append(", fromVersion=").append(this.b);
        stringBuffer.append(", greyKeyWordList=").append(this.j);
        stringBuffer.append(", language=").append(this.i);
        stringBuffer.append(", isAgree=").append(this.g);
        stringBuffer.append(", contentTag=").append(this.e);
        stringBuffer.append(", version=").append(this.m);
        stringBuffer.append(", signTime=").append(this.k);
        stringBuffer.append(", latestVersion=").append(this.f);
        stringBuffer.append(", newestVersion=").append(this.n);
        stringBuffer.append(", needSign=").append(this.h);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
