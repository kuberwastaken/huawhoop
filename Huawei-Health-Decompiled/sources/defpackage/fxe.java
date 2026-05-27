package defpackage;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class fxe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private String f13329a;

    @SerializedName("metadata")
    private String b;

    @SerializedName("createdTime")
    private long c;

    @SerializedName("category")
    private int d;

    @SerializedName("executableFlag")
    private boolean e;

    @SerializedName("name")
    private String f;

    @SerializedName("taskId")
    private String g;

    @SerializedName("schedules")
    private List<fxm> h;

    @SerializedName("timeZone")
    private String i;

    @SerializedName("status")
    private int j;

    @SerializedName("updatedTime")
    private long n;

    @SerializedName("type")
    private int o;

    public String a() {
        return this.b;
    }

    public List<fxm> e() {
        return this.h;
    }
}
