package defpackage;

import android.content.Intent;
import android.text.TextUtils;
import com.huawei.appgallery.coreservice.api.ConnectConfig;

/* JADX INFO: loaded from: classes3.dex */
public class azb {
    private static String a(ConnectConfig connectConfig) {
        return (connectConfig == null || TextUtils.isEmpty(connectConfig.getConnectServiceAction())) ? "com.huawei.appmarket.service.intent.ACTION_CORE_SERVICE" : connectConfig.getConnectServiceAction();
    }

    public static Intent hU_(String str, ConnectConfig connectConfig) {
        Intent intent = new Intent(a(connectConfig));
        intent.setPackage(str);
        return intent;
    }
}
