package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.haf.common.utils.CollectionUtils;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class vbh extends CloudCommonReponse {

    @SerializedName("notifications")
    private List<vbe> b;

    @SerializedName("hasMore")
    private int c;

    public int a() {
        if (CollectionUtils.e(this.b)) {
            return 0;
        }
        return this.b.size();
    }
}
