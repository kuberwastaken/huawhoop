package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ewq extends CloudCommonReponse {

    @SerializedName("labelRules")
    private List<ewp> e;

    public List<ewp> b() {
        return this.e;
    }

    @Override // com.huawei.hwcloudmodel.model.CloudCommonReponse
    public String toString() {
        return "QueryLabelRuleRsp{labelRules=" + this.e + "}";
    }
}
