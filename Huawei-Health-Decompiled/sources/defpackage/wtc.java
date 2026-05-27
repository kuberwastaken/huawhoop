package defpackage;

import com.huawei.wearengine.p2p.SendCallback;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes11.dex */
public class wtc extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SendCallback f18924a;
    private final Object b;
    private String c;
    private boolean d;

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        synchronized (this.b) {
            wrm.d("TimeoutTask", "sendUuid:" + this.c + ", TimeoutTask is complete.");
            if (b()) {
                wrm.d("TimeoutTask", "sendUuid:" + this.c + ", TimeoutTask is cancelled.");
                return;
            }
            cancel();
            SendCallback sendCallback = this.f18924a;
            if (sendCallback != null) {
                sendCallback.onSendResult(206);
            }
        }
    }

    @Override // java.util.TimerTask
    public boolean cancel() {
        this.d = true;
        return super.cancel();
    }

    boolean b() {
        return this.d;
    }

    public final Object c() {
        return this.b;
    }
}
