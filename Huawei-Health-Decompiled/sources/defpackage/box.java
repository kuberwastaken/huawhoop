package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;
import health.compact.a.Utils;

/* JADX INFO: loaded from: classes3.dex */
public class box implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("timeZone")
    private String f438a = kql.q(System.currentTimeMillis());

    @SerializedName("iVersion")
    private String e;

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return null;
    }

    public box() {
        this.e = Utils.n() ? "2" : "3";
    }
}
