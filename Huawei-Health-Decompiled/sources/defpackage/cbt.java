package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.operation.utils.CloudParamKeys;

/* JADX INFO: loaded from: classes10.dex */
public class cbt {

    @SerializedName("state")
    private String b;

    @SerializedName("deviceCloudState")
    private String c;

    @SerializedName(CloudParamKeys.INFO)
    private cbs d;

    public void d(String str) {
        this.c = str;
    }

    public void a(String str) {
        this.b = str;
    }

    public cbs b() {
        return this.d;
    }

    public void c(cbs cbsVar) {
        this.d = cbsVar;
    }
}
