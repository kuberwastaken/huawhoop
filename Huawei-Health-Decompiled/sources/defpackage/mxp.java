package defpackage;

import com.huawei.multisimservice.model.MultiSimDeviceInfo;
import com.huawei.multisimservice.model.SimInfo;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class mxp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15918a;
    private List<SimInfo> b;
    private int c;
    private MultiSimDeviceInfo d;

    public mxp(int i, int i2) {
        this.d = null;
        this.b = null;
        this.c = i;
        this.f15918a = i2;
    }

    public mxp(int i, MultiSimDeviceInfo multiSimDeviceInfo) {
        this.f15918a = 2;
        this.b = null;
        this.c = i;
        this.d = multiSimDeviceInfo;
        if (multiSimDeviceInfo == null) {
            mza.c("AttachedDeviceMgrCommonResult", "multiSimDeviceInfo is null");
            this.f15918a = -6;
        } else {
            this.f15918a = multiSimDeviceInfo.getResultCode();
        }
    }

    public mxp(int i, int i2, List<SimInfo> list) {
        this.d = null;
        this.c = i;
        this.f15918a = i2;
        this.b = list;
    }
}
