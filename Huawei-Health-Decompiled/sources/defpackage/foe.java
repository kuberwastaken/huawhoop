package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;

/* JADX INFO: loaded from: classes4.dex */
public class foe extends CloudCommonReponse {

    @SerializedName("history")
    private fom e;

    public fom d() {
        return this.e;
    }

    @Override // com.huawei.hwcloudmodel.model.CloudCommonReponse
    public String toString() {
        return "GetHotPathParticipateInfoRsp{" + super.toString() + ", HotPathParticipateHistory='" + this.e + "'}";
    }
}
