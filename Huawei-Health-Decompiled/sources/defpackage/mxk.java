package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;

/* JADX INFO: loaded from: classes6.dex */
public class mxk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("gainTime")
    private long f15915a;

    @SerializedName(ParsedFieldTag.LIGHT_DESC)
    private String b;

    @SerializedName("deepLinkUrl")
    private String c;

    @SerializedName(ParsedFieldTag.MEDAL_ID)
    private String d;

    @SerializedName("action")
    private int e;

    @SerializedName("session")
    private String f;

    @SerializedName("support3D")
    private int g;

    @SerializedName("medalName")
    private String h;

    @SerializedName("message")
    private String i;

    @SerializedName("state")
    private int j;

    @SerializedName(HwPayConstant.KEY_USER_NAME)
    private String l;

    @SerializedName("supportDeeplinkUrl")
    private int o;

    public void g(String str) {
        this.f = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public void d(long j) {
        this.f15915a = j;
    }

    public void d(String str) {
        this.d = str;
    }

    public void c(String str) {
        this.h = str;
    }

    public void e(String str) {
        this.i = str;
    }

    public void b(int i) {
        this.o = i;
    }

    public void a(String str) {
        this.c = str;
    }

    public void d(int i) {
        this.g = i;
    }

    public void c(int i) {
        this.j = i;
    }

    public void e(int i) {
        this.e = i;
    }

    public void h(String str) {
        this.l = str;
    }
}
