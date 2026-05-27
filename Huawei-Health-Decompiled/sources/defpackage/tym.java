package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class tym extends CloudCommonReponse {

    @SerializedName("pendingMessageList")
    private List<tys> e;

    public List<tys> c() {
        return this.e;
    }
}
