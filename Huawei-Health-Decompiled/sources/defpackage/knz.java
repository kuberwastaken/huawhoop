package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import com.huawei.operation.utils.Constants;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class knz extends CloudCommonReponse {

    @SerializedName("errorMessage")
    private String c;

    @SerializedName(Constants.VMALL_SIGN_INFO)
    private List<knv> d;

    @SerializedName("errorCode")
    private int e;

    public int a() {
        return this.e;
    }

    public List<knv> c() {
        return this.d;
    }

    @Override // com.huawei.hwcloudmodel.model.CloudCommonReponse
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HonorPrivacyRsp{errorCode=");
        stringBuffer.append(this.e);
        stringBuffer.append(", errorMessage=").append(this.c);
        stringBuffer.append(", signInfos=").append(this.d);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
