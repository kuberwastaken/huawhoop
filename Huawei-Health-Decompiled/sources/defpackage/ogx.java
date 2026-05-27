package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import com.huawei.operation.ble.BleConstants;

/* JADX INFO: loaded from: classes7.dex */
public class ogx extends CloudCommonReponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("continueDay")
    private int f16366a;

    @SerializedName(BleConstants.SPORT_TYPE)
    private int b;

    public int b() {
        return this.f16366a;
    }

    public int e() {
        return this.b;
    }

    @Override // com.huawei.hwcloudmodel.model.CloudCommonReponse
    public String toString() {
        return "GetContinuesSportDayRsp{continueDay=" + this.f16366a + ", sportType=" + this.b + "} " + super.toString();
    }
}
