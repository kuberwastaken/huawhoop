package defpackage;

import com.huawei.health.facardagds.FaCardAgdsApi;
import health.compact.a.Services;

/* JADX INFO: loaded from: classes4.dex */
public class eir {
    public static FaCardAgdsApi d() {
        return (FaCardAgdsApi) Services.e("HWSmartInteractMgr", FaCardAgdsApi.class);
    }
}
