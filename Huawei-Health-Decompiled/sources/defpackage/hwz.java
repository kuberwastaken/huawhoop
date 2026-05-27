package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.health.vip.datatypes.MemberTypeInfo;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class hwz extends CloudCommonReponse {

    @SerializedName("memberTypeInfoList")
    private List<MemberTypeInfo> d;

    public List<MemberTypeInfo> c() {
        return this.d;
    }

    @Override // com.huawei.hwcloudmodel.model.CloudCommonReponse
    public String toString() {
        StringBuilder sb = new StringBuilder(16);
        sb.append("memberTypeInfoList=");
        sb.append(this.d);
        return sb.toString();
    }
}
