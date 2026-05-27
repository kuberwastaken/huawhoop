package defpackage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;

/* JADX INFO: loaded from: classes8.dex */
public class uzc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(SocialConstants.PARAM_APP_DESC)
    @Expose
    private String f18526a;

    @SerializedName("has_device_no_data_desc")
    @Expose
    private String b;

    @SerializedName("has_device_no_data_img")
    @Expose
    private String c;

    @SerializedName("id")
    @Expose
    private String d;

    @SerializedName("bg_img")
    @Expose
    private String e;

    @SerializedName("res_package")
    @Expose
    private String f;

    @SerializedName("name")
    @Expose
    private String g;

    public String e() {
        return this.g;
    }

    public String c() {
        return this.f18526a;
    }

    public String d() {
        return this.e;
    }

    public String b() {
        return this.c;
    }

    public String a() {
        return this.b;
    }
}
