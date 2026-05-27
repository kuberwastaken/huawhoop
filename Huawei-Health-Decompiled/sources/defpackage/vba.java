package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;

/* JADX INFO: loaded from: classes8.dex */
public class vba extends CloudCommonReponse {

    @SerializedName("totalCount")
    private int e;

    public int e() {
        return this.e;
    }

    @Override // com.huawei.hwcloudmodel.model.CloudCommonReponse
    public String toString() {
        return "GetUserGrpListRsp{totalCount=" + this.e + '}';
    }
}
