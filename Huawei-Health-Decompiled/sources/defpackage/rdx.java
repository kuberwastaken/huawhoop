package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class rdx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(ParsedFieldTag.TASK_MODIFY_TIME)
    private long f17309a;

    @SerializedName("displayOrder")
    private int b;

    @SerializedName("name")
    private String d;

    @SerializedName("audioWorkoutList")
    private List<rdj> e;

    public String toString() {
        return "Topic{name='" + this.d + "', displayOrder=" + this.b + ", modifyTime=" + this.f17309a + ", audioWorkoutList=" + this.e + '}';
    }
}
