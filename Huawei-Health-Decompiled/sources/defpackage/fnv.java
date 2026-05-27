package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.health.motiontrack.model.runningroute.HotPathCityInfo;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class fnv extends CloudCommonReponse {

    @SerializedName("cityInfos")
    private List<HotPathCityInfo> c = new ArrayList();

    public List<HotPathCityInfo> d() {
        return this.c;
    }
}
