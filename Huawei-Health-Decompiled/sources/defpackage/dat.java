package defpackage;

import com.huawei.haf.application.BaseApplication;
import health.compact.a.GRSManager;

/* JADX INFO: loaded from: classes4.dex */
public class dat {
    public static String c() {
        return a() + "/dataStat/goalAchieve/querySummary";
    }

    public static String d() {
        return a() + "/dataStat/goalAchieve/queryEncourage";
    }

    private static String a() {
        return GRSManager.b(BaseApplication.a()).getUrl("healthCloudUrl");
    }
}
