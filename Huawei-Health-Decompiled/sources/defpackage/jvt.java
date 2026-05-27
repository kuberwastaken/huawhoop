package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.haf.application.BaseApplication;
import com.huawei.networkclient.IRequest;
import health.compact.a.GRSManager;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class jvt implements IRequest {

    @SerializedName("halfYearItems")
    private List<String> b;

    @SerializedName("monthItems")
    private List<String> c;

    public void a(List<String> list) {
        this.c = list;
    }

    public void c(List<String> list) {
        this.b = list;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return GRSManager.b(BaseApplication.a()).getUrl("healthCloudUrl") + "/dataStat/healthTrends/getHealthTrend";
    }
}
