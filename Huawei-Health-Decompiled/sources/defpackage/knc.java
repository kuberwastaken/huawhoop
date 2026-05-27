package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class knc extends CloudCommonReponse {

    @SerializedName("fileUploadList")
    private List<kmy> d;

    public List<kmy> b() {
        return this.d;
    }
}
