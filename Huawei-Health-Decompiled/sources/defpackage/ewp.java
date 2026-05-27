package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;

/* JADX INFO: loaded from: classes4.dex */
public class ewp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("labelName")
    private String f12808a;

    @SerializedName("labelCategory")
    private int b;

    @SerializedName("labelDisplayName")
    private String c;

    @SerializedName("description")
    private String d;

    @SerializedName("createTime")
    private long e;

    @SerializedName(ParsedFieldTag.TASK_MODIFY_TIME)
    private long g;

    @SerializedName("labelThreshold")
    private ewo i;

    @SerializedName("serviceId")
    private int j;

    public String d() {
        return this.f12808a;
    }

    public ewo b() {
        return this.i;
    }
}
