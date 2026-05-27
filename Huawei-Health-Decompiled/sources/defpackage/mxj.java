package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;

/* JADX INFO: loaded from: classes6.dex */
public class mxj extends mxm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("capabilities")
    private int f15914a;

    @SerializedName(ParsedFieldTag.MEDAL_ID)
    private String b;

    @SerializedName("resourceType")
    private int c;

    @SerializedName("action")
    private int e;

    public int c() {
        return this.f15914a;
    }

    public String g() {
        return this.b;
    }
}
