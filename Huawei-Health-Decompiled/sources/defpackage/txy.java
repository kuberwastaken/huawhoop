package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.openalliance.ad.constant.JsbMapKeyNames;
import com.huawei.operation.ble.BleConstants;

/* JADX INFO: loaded from: classes8.dex */
public class txy {

    @SerializedName("devId")
    private String b;

    @SerializedName(JsbMapKeyNames.H5_USER_ID)
    private Long d;

    @SerializedName(BleConstants.DEV_INFO)
    private tya e;

    public tya e() {
        return this.e;
    }

    public String toString() {
        return "CommonDevice{devId=" + this.b + ", devInfo=" + this.e + ", userId=" + this.d + '}';
    }
}
