package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class uge extends CloudCommonReponse {

    @SerializedName("totalCount")
    private int b;

    @SerializedName("userLabelConfig")
    private List<ugi> d;

    public List<ugi> c() {
        return this.d;
    }
}
