package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class tyi extends CloudCommonReponse {

    @SerializedName("memberPostIds")
    private List<tyq> d;

    public List<tyq> b() {
        return this.d;
    }
}
