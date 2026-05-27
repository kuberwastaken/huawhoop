package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.operation.utils.CloudParamKeys;

/* JADX INFO: loaded from: classes11.dex */
public class rdt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("laterVersionFlagDisabled")
    private boolean f17307a;

    @SerializedName(CloudParamKeys.CLIENT_TYPE)
    private int c;

    @SerializedName("clientVersions")
    private String e;

    public String toString() {
        return "ClientVersionInfo{clientType=" + this.c + ", clientVersions='" + this.e + "', LaterVersionFlagDisabled='" + this.f17307a + "'}";
    }
}
