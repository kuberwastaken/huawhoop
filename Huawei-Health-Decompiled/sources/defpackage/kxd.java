package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;

/* JADX INFO: loaded from: classes5.dex */
public class kxd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("downloadProgress")
    private int f14976a;

    @SerializedName("installStatus")
    private int b;

    @SerializedName("errorCode")
    private int c;

    @SerializedName("appName")
    private String d;

    @SerializedName("batteryLevel")
    private int e;

    @SerializedName("pkgMode")
    private int f;

    @SerializedName("type")
    private int g;

    @SerializedName("preInstalled")
    private int h;

    @SerializedName(ParsedFieldTag.TASK_MODIFY_TIME)
    private long i;

    @SerializedName("packageName")
    private String j;

    @SerializedName("versionCode")
    private int l;

    @SerializedName("version")
    private String o;

    public String d() {
        return this.j;
    }
}
