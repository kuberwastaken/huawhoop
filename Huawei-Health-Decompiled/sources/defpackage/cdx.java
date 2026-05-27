package defpackage;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.huawei.devicesdk.connect.physical.ConsumerHandler;
import health.compact.a.LogUtil;

/* JADX INFO: loaded from: classes3.dex */
public class cdx {
    private static final Object d = new Object();
    private HandlerThread b;
    private e c;

    public cdx(ConsumerHandler<Message> consumerHandler) {
        HandlerThread handlerThread = new HandlerThread("SafePhysicalConnectHandler");
        this.b = handlerThread;
        if (consumerHandler != null) {
            handlerThread.start();
            this.c = new e(this.b.getLooper(), consumerHandler);
        }
    }

    public final void a(Object obj) {
        synchronized (d) {
            if (d()) {
                this.c.removeCallbacksAndMessages(obj);
            }
        }
    }

    public final Message tu_(int i) {
        synchronized (d) {
            if (d()) {
                return this.c.obtainMessage(i);
            }
            return new Message();
        }
    }

    public final boolean tv_(Message message) {
        synchronized (d) {
            if (!d()) {
                return false;
            }
            return this.c.sendMessage(message);
        }
    }

    public final void e(int i) {
        synchronized (d) {
            if (d()) {
                this.c.removeMessages(i);
            }
        }
    }

    public final boolean a(int i, long j) {
        synchronized (d) {
            if (!d()) {
                return false;
            }
            return this.c.sendEmptyMessageDelayed(i, j);
        }
    }

    public final boolean c(int i) {
        synchronized (d) {
            if (!d()) {
                return false;
            }
            return this.c.sendEmptyMessage(i);
        }
    }

    public final boolean tw_(Message message, long j) {
        synchronized (d) {
            if (!d()) {
                return false;
            }
            return this.c.sendMessageDelayed(message, j);
        }
    }

    public final boolean a(Runnable runnable) {
        synchronized (d) {
            if (!d()) {
                return false;
            }
            return this.c.post(runnable);
        }
    }

    static class e extends Handler {
        private ConsumerHandler<Message> c;

        e(Looper looper, ConsumerHandler<Message> consumerHandler) {
            super(looper);
            this.c = consumerHandler;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ConsumerHandler<Message> consumerHandler = this.c;
            if (consumerHandler != null) {
                consumerHandler.accept(message);
            }
        }

        void e() {
            this.c = null;
        }
    }

    public void b() {
        LogUtil.a("SafePhysicalConnectHandler", "stop physical connect handler.");
        synchronized (d) {
            if (d()) {
                this.c.e();
                this.c = null;
            }
        }
        this.b.quitSafely();
    }

    public boolean d() {
        boolean z;
        synchronized (d) {
            z = this.c != null;
        }
        return z;
    }
}
