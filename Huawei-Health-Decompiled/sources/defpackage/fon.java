package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;

/* JADX INFO: loaded from: classes10.dex */
public class fon {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(ParsedFieldTag.TASK_MODIFY_TIME)
    private long f13061a;

    @SerializedName("huid")
    private long b;

    @SerializedName("pathId")
    private String c;

    @SerializedName("feedbackDescription")
    private String d;

    @SerializedName("createTime")
    private long e;

    public String toString() {
        return "UserFeedbackInfo{pathId='" + this.c + "', huid=" + this.b + ", feedbackDescription='" + this.d + "', createTime=" + this.e + ", modifyTime=" + this.f13061a + '}';
    }
}
