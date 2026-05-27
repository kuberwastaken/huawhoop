package defpackage;

import com.huawei.devicesdk.connect.retry.ExecuteActionInterface;
import com.huawei.devicesdk.connect.retry.RetryCallbackInterface;
import health.compact.a.LogUtil;

/* JADX INFO: loaded from: classes3.dex */
public class cdw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f600a;
    private int b = 0;

    public cdw(int i) {
        this.f600a = Math.max(i, 0);
    }

    public void e(ExecuteActionInterface executeActionInterface, RetryCallbackInterface retryCallbackInterface, boolean z) {
        if (executeActionInterface == null || retryCallbackInterface == null) {
            LogUtil.d("ActionRetryExecutor", "action or retryCallback is null");
        } else if (z) {
            a(executeActionInterface, retryCallbackInterface);
        } else {
            d(executeActionInterface, retryCallbackInterface);
        }
    }

    private void a(ExecuteActionInterface executeActionInterface, RetryCallbackInterface retryCallbackInterface) {
        String actionName = executeActionInterface.getActionName();
        if (this.b <= this.f600a) {
            b(executeActionInterface, retryCallbackInterface, actionName);
            return;
        }
        LogUtil.d("ActionRetryExecutor", "action  ", actionName, " execute failed.");
        d();
        retryCallbackInterface.doFailureAction();
    }

    private void d(ExecuteActionInterface executeActionInterface, RetryCallbackInterface retryCallbackInterface) {
        String actionName = executeActionInterface.getActionName();
        while (this.b <= this.f600a) {
            if (b(executeActionInterface, retryCallbackInterface, actionName)) {
                return;
            }
        }
        LogUtil.d("ActionRetryExecutor", "action  ", actionName, " execute failed.");
        d();
        retryCallbackInterface.doFailureAction();
    }

    private boolean b(ExecuteActionInterface executeActionInterface, RetryCallbackInterface retryCallbackInterface, String str) {
        if (executeActionInterface.execute()) {
            d();
            LogUtil.a("ActionRetryExecutor", "action ", str, " execute success.");
            retryCallbackInterface.doSuccessAction();
            return true;
        }
        LogUtil.b("ActionRetryExecutor", "action ", str, " execute failed. start to retry. currentRetry:", Integer.valueOf(this.b));
        retryCallbackInterface.doRetryAction(this.b);
        this.b++;
        return false;
    }

    public void d() {
        this.b = 0;
    }
}
