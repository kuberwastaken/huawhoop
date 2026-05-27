package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.health.motiontrack.model.runningroute.HotPathCityInfo;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import com.huawei.operation.utils.Constants;

/* JADX INFO: loaded from: classes4.dex */
public class fnz extends CloudCommonReponse {

    @SerializedName("countryId")
    private String b;

    @SerializedName("cityInfo")
    private HotPathCityInfo d;

    public HotPathCityInfo c() {
        return this.d;
    }

    public HotPathCityInfo a() {
        return this.d;
    }

    public String b() {
        return this.b;
    }

    @Override // com.huawei.hwcloudmodel.model.CloudCommonReponse
    public String toString() {
        StringBuilder sb = new StringBuilder("GetCityInfoWithGpsRsp{cityInfo=");
        HotPathCityInfo hotPathCityInfo = this.d;
        sb.append(hotPathCityInfo == null ? Constants.NULL : hotPathCityInfo.toString());
        sb.append('}');
        return sb.toString();
    }
}
