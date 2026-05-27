package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class txz extends CloudCommonReponse {

    @SerializedName("dataList")
    private List<tyb> e;

    public List<tyb> b() {
        return this.e;
    }
}
