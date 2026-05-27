package defpackage;

import com.huawei.haf.common.base.BaseNotification;

/* JADX INFO: loaded from: classes6.dex */
final class mbo extends BaseNotification {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile mbo f15600a;

    private mbo() {
    }

    static mbo e() {
        if (f15600a == null) {
            synchronized (mbo.class) {
                if (f15600a == null) {
                    mbo mboVar = new mbo();
                    mboVar.b("device_connect_id", e("IDS_hw_app_name", "IDS_app_name_health"), 3);
                    f15600a = mboVar;
                }
            }
        }
        return f15600a;
    }
}
