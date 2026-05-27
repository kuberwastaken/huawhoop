package defpackage;

import com.huawei.wear.oversea.overseamanger.QueryReviewResultCallback;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes11.dex */
public class vyf {
    private ScheduledFuture<?> b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18839a = 0;
    private boolean d = false;

    public vyf(final QueryReviewResultCallback queryReviewResultCallback) {
        vwc.c("QueryReviewResultScheduleTask", "QueryReviewResultScheduleTask");
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.b = scheduledExecutorServiceNewSingleThreadScheduledExecutor.scheduleAtFixedRate(new Runnable() { // from class: vyi
            @Override // java.lang.Runnable
            public final void run() {
                this.c.d(queryReviewResultCallback, countDownLatch);
            }
        }, 2000L, 2000L, TimeUnit.MILLISECONDS);
        try {
            boolean zAwait = countDownLatch.await(62000L, TimeUnit.MILLISECONDS);
            if (!zAwait) {
                c(queryReviewResultCallback, "1", this.b);
            }
            vwc.e("QueryReviewResultScheduleTask", "awaitResult=" + zAwait, true);
        } catch (InterruptedException unused) {
            vwc.c("QueryReviewResultScheduleTask", "InterruptedException");
        }
    }

    /* synthetic */ void d(QueryReviewResultCallback queryReviewResultCallback, CountDownLatch countDownLatch) {
        this.f18839a++;
        vwc.c("QueryReviewResultScheduleTask", "retryTimes:" + this.f18839a);
        if (queryReviewResultCallback.checkReviewResult()) {
            c(queryReviewResultCallback, "2", this.b);
        } else {
            if (this.f18839a >= 30) {
                vwc.c("QueryReviewResultScheduleTask", "max times");
                countDownLatch.countDown();
                c(queryReviewResultCallback, "1", this.b);
                return;
            }
            vwc.c("QueryReviewResultScheduleTask", "checkReviewResult again");
        }
    }

    private void c(QueryReviewResultCallback queryReviewResultCallback, String str, ScheduledFuture<?> scheduledFuture) {
        synchronized (this) {
            if (!this.d) {
                this.d = true;
                scheduledFuture.cancel(true);
                queryReviewResultCallback.onQueryReviewResultCallback(str);
            }
        }
    }
}
