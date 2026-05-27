package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class typ extends CloudCommonReponse {

    @SerializedName("memberList")
    private List<tyn> d;

    public List<tyn> c() {
        return this.d;
    }
}
