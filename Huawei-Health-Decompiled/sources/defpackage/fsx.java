package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes9.dex */
public class fsx implements IRequest {

    @SerializedName("actionId")
    private String d;

    public fsx(String str) {
        this.d = str;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.aa();
    }
}
