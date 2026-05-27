package defpackage;

import com.huawei.health.baseapi.pluginlocation.RxnEphemerisApi;
import com.huawei.health.pluginlocation.logger.Logger;

/* JADX INFO: loaded from: classes10.dex */
public class gas implements RxnEphemerisApi {
    @Override // com.huawei.health.baseapi.pluginlocation.RxnEphemerisApi
    public void pluginRxnGenerateEphemeris() {
    }

    @Override // com.huawei.health.baseapi.pluginlocation.RxnEphemerisApi
    public void pluginRxnNativeInit() {
    }

    public gas(Logger logger) {
        gbo.d(logger);
    }
}
