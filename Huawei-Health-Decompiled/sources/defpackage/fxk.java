package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class fxk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("createdTime")
    private long f13333a;

    @SerializedName(ParsedFieldTag.RECORD_DAY)
    private long b;

    @SerializedName("endTime")
    private long c;

    @SerializedName("objectiveResults")
    private List<fwz> d;

    @SerializedName("completionStatus")
    private int e;

    @SerializedName("scheduleId")
    private String f;

    @SerializedName("timeZone")
    private String g;

    @SerializedName("startTime")
    private long h;

    @SerializedName("updatedTime")
    private long i;

    @SerializedName("taskId")
    private String j;

    public String c() {
        return this.f;
    }

    public int b() {
        return this.e;
    }
}
