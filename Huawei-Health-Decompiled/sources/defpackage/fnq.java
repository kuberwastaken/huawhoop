package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;

/* JADX INFO: loaded from: classes4.dex */
public class fnq extends CloudCommonReponse {

    @SerializedName("interpretation")
    private String e;

    public String a() {
        return this.e;
    }

    @Override // com.huawei.hwcloudmodel.model.CloudCommonReponse
    public String toString() {
        return "GetAISportsAnalysisInfoRsp{" + super.toString() + this.e + "'}";
    }
}
