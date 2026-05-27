package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class kfx extends CloudCommonReponse {

    @SerializedName("versions")
    private Map<Integer, Long> d;

    public Map<Integer, Long> b() {
        return this.d;
    }

    @Override // com.huawei.hwcloudmodel.model.CloudCommonReponse
    public String toString() {
        StringBuilder sb = new StringBuilder(16);
        sb.append("versions=");
        sb.append(this.d);
        return sb.toString();
    }
}
