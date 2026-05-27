package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class foc extends CloudCommonReponse {

    @SerializedName("totalSize")
    private int c;

    @SerializedName("userFeedbackInfos")
    private List<fon> d;

    @Override // com.huawei.hwcloudmodel.model.CloudCommonReponse
    public String toString() {
        return "GetFeedbackInfosRsp{userFeedbackInfos=" + this.d + ", totalSize=" + this.c + '}';
    }
}
