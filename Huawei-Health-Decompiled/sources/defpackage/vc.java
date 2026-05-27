package defpackage;

import android.os.Handler;
import android.os.Looper;
import com.braintreepayments.api.Scheduler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes9.dex */
class vc implements Scheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f18567a;
    private final ExecutorService d;

    vc() {
        this(new Handler(Looper.getMainLooper()), Executors.newCachedThreadPool());
    }

    vc(Handler handler, ExecutorService executorService) {
        this.f18567a = handler;
        this.d = executorService;
    }

    @Override // com.braintreepayments.api.Scheduler
    public void runOnBackground(Runnable runnable) {
        this.d.submit(runnable);
    }

    @Override // com.braintreepayments.api.Scheduler
    public void runOnMain(Runnable runnable) {
        this.f18567a.post(runnable);
    }
}
