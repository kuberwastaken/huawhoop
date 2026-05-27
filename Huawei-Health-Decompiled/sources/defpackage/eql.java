package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class eql {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("dataType")
    private String f12736a;

    @SerializedName("dataDetails")
    private List<String> b;

    @SerializedName("taskId")
    private String d;

    public String toString() {
        return "CustomTaskDetail{mTaskId=" + this.d + ", mDataType=" + this.f12736a + ", mDataDetailList=" + this.b + "}";
    }
}
