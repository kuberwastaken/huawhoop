package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class ptg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(FaqConstants.FAQ_MODELTYPE)
    private String f16868a;

    @SerializedName("startVersion")
    private String b;

    @SerializedName("endVersion")
    private String c;

    @SerializedName("modelId")
    private String d;

    @SerializedName("featureId")
    private String e;

    @SerializedName("versionMap")
    private List<pth> j;

    public String b() {
        return this.e;
    }

    public String a() {
        return this.b;
    }

    public String e() {
        return this.c;
    }

    public List<pth> d() {
        return this.j;
    }
}
