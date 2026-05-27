package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class knj extends CloudCommonReponse {

    @SerializedName("userLabels")
    private List<knl> d;

    public List<knl> c() {
        return this.d;
    }
}
