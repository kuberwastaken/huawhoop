package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.health.vip.datatypes.TransferBenefitInfo;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class hxa extends CloudCommonReponse {

    @SerializedName("transferBenefitList")
    private List<TransferBenefitInfo> c;

    public List<TransferBenefitInfo> a() {
        return this.c;
    }

    @Override // com.huawei.hwcloudmodel.model.CloudCommonReponse
    public String toString() {
        return "TransferBenefitsRsp{transferBenefitList=" + this.c + '}';
    }
}
