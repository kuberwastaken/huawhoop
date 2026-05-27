package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import com.huawei.operation.jsoperation.JsUtil;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class kgb extends CloudCommonReponse {

    @SerializedName(JsUtil.DATA_LIST)
    private List<kgd> b;

    @SerializedName("currentVersion")
    private long c;

    public List<kgd> a() {
        return this.b;
    }

    public long e() {
        return this.c;
    }
}
