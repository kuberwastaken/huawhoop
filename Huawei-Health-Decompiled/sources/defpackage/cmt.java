package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.featuregroup.constants.DeviceInfo;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import com.huawei.openalliance.ad.constant.JsbMapKeyNames;
import com.huawei.operation.ble.BleConstants;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class cmt extends CloudCommonReponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("aveSpace")
    private int f688a;

    @SerializedName(JsbMapKeyNames.H5_LOC_LON)
    private double b;

    @SerializedName("status")
    private int c;

    @SerializedName("onlineDevices")
    private List<DeviceInfo> d;

    @SerializedName(JsbMapKeyNames.H5_LOC_LAT)
    private double e;

    @SerializedName(BleConstants.TOTAL_DISTANCE)
    private int f;

    @SerializedName("totalTime")
    private int i;

    @SerializedName("syncDevice")
    private DeviceInfo j;
}
