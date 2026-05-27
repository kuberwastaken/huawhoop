package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class mxi extends mxm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("action")
    private int f15913a;

    @SerializedName("country")
    private String b;

    @SerializedName("capabilities")
    private List<Integer> c;

    @SerializedName("language")
    private String d;

    @SerializedName("deviceId")
    private String e;

    @SerializedName("timestamp")
    private long h;

    @SerializedName(ParsedFieldTag.MEDAL_ID)
    private String i;

    public int c() {
        return this.f15913a;
    }

    public long i() {
        return this.h;
    }

    public List<Integer> j() {
        return this.c;
    }

    public String f() {
        return this.i;
    }
}
