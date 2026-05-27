package defpackage;

import com.huawei.ads.adsrec.IUtilCallback;
import com.huawei.openalliance.ad.constant.ConfigMapKeys;

/* JADX INFO: loaded from: classes3.dex */
public class apy {
    public static boolean b() {
        IUtilCallback iUtilCallbackD = aoy.d();
        return iUtilCallbackD != null && "1".equals(iUtilCallbackD.getConfig(ConfigMapKeys.BACK_FLOW_SWITCH));
    }
}
