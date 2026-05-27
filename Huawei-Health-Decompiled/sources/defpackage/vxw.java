package defpackage;

import com.huawei.android.airsharing.api.PlayInfo;
import com.huawei.health.BuildConfig;

/* JADX INFO: loaded from: classes8.dex */
public class vxw {
    public static String d() {
        return vys.a().d("WALLET_MERCHANT_ID", BuildConfig.WALLET_MERCHANT_ID);
    }

    public static String c() {
        return vys.a().d(PlayInfo.KEY_APP_NAME, "hiwallet");
    }

    public static String e() {
        return vys.a().d("SERVICENAME_CFG_WALLETSERVICES", "hiwalletServices");
    }
}
