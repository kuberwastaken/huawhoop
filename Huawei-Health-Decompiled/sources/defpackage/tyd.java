package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class tyd extends CloudCommonReponse {

    @SerializedName("followRelations")
    private List<tyg> b;

    public List<tyg> a() {
        return this.b;
    }
}
