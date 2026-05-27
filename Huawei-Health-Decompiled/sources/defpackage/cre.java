package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class cre extends CloudCommonReponse {

    @SerializedName("toDoContentList")
    private List<hqp> b;

    public List<hqp> a() {
        return this.b;
    }
}
