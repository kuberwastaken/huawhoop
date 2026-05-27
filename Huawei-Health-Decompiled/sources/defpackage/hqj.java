package defpackage;

import com.huawei.health.threeCircle.remind.model.ThreeCircleRemindData;
import com.huawei.hwbasemgr.ResponseCallback;
import com.huawei.hwlogsmodel.LogUtil;
import health.compact.a.LogAnonymous;
import health.compact.a.hwlogsmodel.ReleaseLogUtil;

/* JADX INFO: loaded from: classes5.dex */
public class hqj implements ResponseCallback<ThreeCircleRemindData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ResponseCallback<ThreeCircleRemindData> f13927a;
    private boolean b;
    private hqf d;
    private String e;

    public hqj(hqf hqfVar, String str, boolean z, ResponseCallback<ThreeCircleRemindData> responseCallback) {
        this.d = hqfVar;
        this.e = str;
        this.b = z;
        this.f13927a = responseCallback;
    }

    public hqj(hqf hqfVar, String str, ResponseCallback<ThreeCircleRemindData> responseCallback) {
        this.d = hqfVar;
        this.e = str;
        this.b = false;
        this.f13927a = responseCallback;
    }

    public boolean e() {
        return this.b;
    }

    @Override // com.huawei.hwbasemgr.ResponseCallback
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResponse(int i, ThreeCircleRemindData threeCircleRemindData) {
        LogUtil.b("RemindDataCallback", "onResponse:", Integer.valueOf(i), "remindType:", this.e);
        if (threeCircleRemindData == null) {
            LogUtil.j("RemindDataCallback", "onResponse data == null");
            return;
        }
        if (this.d == null || this.f13927a == null) {
            LogUtil.a("RemindDataCallback", "onResponse: mRemindDataQueue == null or mResponseCallback == null");
            return;
        }
        ReleaseLogUtil.d("R_RemindDataCallback", "remindType:", this.e, " data:", threeCircleRemindData.getRemindText(), " ", threeCircleRemindData.getRemindType(), " isFromDevice:", Boolean.valueOf(this.b));
        if (this.b) {
            this.f13927a.onResponse(0, threeCircleRemindData);
            return;
        }
        this.e = threeCircleRemindData.getRemindType();
        this.d.a(threeCircleRemindData);
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            ReleaseLogUtil.c("R_RemindDataCallback", "sleep error.", LogAnonymous.b(e));
        }
        e(threeCircleRemindData);
    }

    private void e(ThreeCircleRemindData threeCircleRemindData) {
        ThreeCircleRemindData threeCircleRemindDataD = this.d.d();
        if (threeCircleRemindDataD == null) {
            ReleaseLogUtil.c("R_RemindDataCallback", "remindData == null.");
            this.f13927a.onResponse(-1, null);
            return;
        }
        String str = this.e;
        if (str == null || str.equals(threeCircleRemindDataD.getRemindType())) {
            this.f13927a.onResponse(0, threeCircleRemindDataD);
            this.d.c();
        } else {
            ReleaseLogUtil.a("R_RemindDataCallback", "priority too low, has other remind.no need response.", Integer.valueOf(threeCircleRemindData.getPriority()), threeCircleRemindData.getRemindType());
        }
    }
}
