package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class tye extends CloudCommonReponse {

    @SerializedName("authRelations")
    private List<tyg> b;

    public List<tyg> d() {
        return this.b;
    }
}
