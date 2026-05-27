package defpackage;

import com.huawei.wearengine.core.common.OnFinishedCallback;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes11.dex */
public class wrl implements OnFinishedCallback {
    private final CountDownLatch d;

    public wrl(int i) {
        this.d = new CountDownLatch(i);
    }

    public boolean c(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.d.await(j, timeUnit);
    }

    @Override // com.huawei.wearengine.core.common.OnFinishedCallback
    public void onFinish() {
        this.d.countDown();
    }
}
