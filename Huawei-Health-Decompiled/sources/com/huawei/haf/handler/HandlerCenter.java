package com.huawei.haf.handler;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.text.TextUtils;
import health.compact.a.LogUtil;
import health.compact.a.ReflectionUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class HandlerCenter implements Executor {
    private static volatile HandlerCenter d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, AutoTaskHandler> f2152a = new HashMap();
    private final String b;
    private final long c;
    private final int e;

    public static final class OnlyTaskHandlerCallback implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            return false;
        }
    }

    private HandlerCenter(String str, int i, long j) {
        this.b = str;
        this.e = i;
        this.c = d(j);
    }

    public static HandlerCenter a() {
        if (d == null) {
            synchronized (HandlerCenter.class) {
                if (d == null) {
                    d = e("haf_hc_", 0, 60000L);
                }
            }
        }
        return d;
    }

    public static HandlerCenter b(String str) {
        return new HandlerCenter(str, 10, 60000L);
    }

    public static HandlerCenter e(String str, int i, long j) {
        return new HandlerCenter(str, i, j);
    }

    public static ExtendHandler d(String str) {
        return zZ_(null, null, str);
    }

    public static ExtendHandler zY_(Handler.Callback callback, String str) {
        return zZ_(null, callback, str);
    }

    public static ExtendHandler zZ_(HandlerCenter handlerCenter, Handler.Callback callback, String str) {
        return new ExtendHandlerWithCenter(e(handlerCenter), zX_(callback), a(str));
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        Ab_(runnable, null, 0L, a((String) null));
    }

    public void e(String str, boolean z) {
        if ("default".equals(str) && d == this) {
            LogUtil.b("HAF_HandlerCenter", "Can't actively quit this default handler");
        } else {
            a(str, z);
        }
    }

    public void b(Runnable runnable) {
        Ab_(runnable, null, 0L, a((String) null));
    }

    public void b(Runnable runnable, long j) {
        Ab_(runnable, null, j, a((String) null));
    }

    public void e(Runnable runnable, String str) {
        Ab_(runnable, null, 0L, a(str));
    }

    void Ab_(Runnable runnable, Handler.Callback callback, long j, String str) {
        if (runnable == null) {
            return;
        }
        synchronized (this.f2152a) {
            AutoTaskHandler autoTaskHandlerE = this.f2152a.get(str);
            if (autoTaskHandlerE == null) {
                autoTaskHandlerE = e(str);
            }
            if (!autoTaskHandlerE.Aj_(runnable, j, callback)) {
                a(str, true);
                Ab_(runnable, callback, j, str);
            }
        }
    }

    void Af_(Message message, Handler.Callback callback, long j, String str) {
        if (message.getCallback() == null && (callback instanceof OnlyTaskHandlerCallback)) {
            throw new UnsupportedOperationException("The Handler.Callback used does not support processing Message.what messages");
        }
        synchronized (this.f2152a) {
            AutoTaskHandler autoTaskHandlerE = this.f2152a.get(str);
            if (autoTaskHandlerE == null) {
                autoTaskHandlerE = e(str);
            }
            if (!autoTaskHandlerE.Ai_(message, j, callback)) {
                a(str, true);
                Af_(message, callback, j, str);
            }
        }
    }

    boolean Aa_(int i, Handler.Callback callback, String str) {
        AutoTaskHandler autoTaskHandlerC = c(str);
        if (autoTaskHandlerC != null) {
            return autoTaskHandlerC.hasMessages(i, callback);
        }
        return false;
    }

    void Ae_(Runnable runnable, Handler.Callback callback, String str) {
        AutoTaskHandler autoTaskHandlerC = c(str);
        if (autoTaskHandlerC != null) {
            autoTaskHandlerC.removeCallbacks(runnable, callback);
        }
    }

    void Ad_(int i, Handler.Callback callback, String str) {
        AutoTaskHandler autoTaskHandlerC = c(str);
        if (autoTaskHandlerC != null) {
            autoTaskHandlerC.removeMessages(i, callback);
        }
    }

    void Ac_(Handler.Callback callback, String str) {
        AutoTaskHandler autoTaskHandlerC = c(str);
        if (autoTaskHandlerC != null) {
            autoTaskHandlerC.removeCallbacksAndMessages(callback);
        }
    }

    static Handler.Callback zX_(Handler.Callback callback) {
        return callback == null ? new OnlyTaskHandlerCallback() : callback;
    }

    private static HandlerCenter e(HandlerCenter handlerCenter) {
        return handlerCenter == null ? a() : handlerCenter;
    }

    private static String a(String str) {
        return TextUtils.isEmpty(str) ? "default" : str;
    }

    private AutoTaskHandler e(String str) {
        HandlerThread handlerThread = new HandlerThread(c(str, this.b), this.e);
        handlerThread.start();
        AutoTaskHandler autoTaskHandler = new AutoTaskHandler(this, handlerThread.getLooper(), str);
        this.f2152a.put(str, autoTaskHandler);
        LogUtil.a("HAF_HandlerCenter", "add ", autoTaskHandler, ", size=", Integer.valueOf(this.f2152a.size()));
        return autoTaskHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z) {
        synchronized (this.f2152a) {
            AutoTaskHandler autoTaskHandlerH = h(str);
            if (autoTaskHandlerH != null) {
                autoTaskHandlerH.d(z);
            }
        }
    }

    private AutoTaskHandler h(String str) {
        AutoTaskHandler autoTaskHandlerRemove = this.f2152a.remove(str);
        if (autoTaskHandlerRemove != null) {
            LogUtil.a("HAF_HandlerCenter", "remove ", autoTaskHandlerRemove, ", size=", Integer.valueOf(this.f2152a.size()));
        }
        return autoTaskHandlerRemove;
    }

    private AutoTaskHandler c(String str) {
        AutoTaskHandler autoTaskHandler;
        synchronized (this.f2152a) {
            autoTaskHandler = this.f2152a.get(str);
        }
        return autoTaskHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c() {
        int size;
        synchronized (this.f2152a) {
            size = this.f2152a.size();
        }
        return size;
    }

    private static String c(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return str2 + str;
    }

    private static long d(long j) {
        if (j == 0) {
            return 0L;
        }
        return Math.min(Math.max(j, 10000L), 300000L);
    }

    static class AutoTaskHandler extends TaskHandler {
        private static Field c = ReflectionUtils.d((Class<?>) MessageQueue.class, "mMessages");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final HandlerCenter f2153a;
        private volatile boolean b;
        private final String e;

        AutoTaskHandler(HandlerCenter handlerCenter, Looper looper, String str) {
            super(looper);
            this.f2153a = handlerCenter;
            this.e = str;
        }

        boolean Aj_(Runnable runnable, long j, Handler.Callback callback) {
            if (this.b) {
                return false;
            }
            return Ai_(Message.obtain(this, runnable), j, callback);
        }

        boolean Ai_(Message message, long j, Handler.Callback callback) {
            if (this.b || !Ao_(message, j, callback)) {
                return false;
            }
            c();
            return true;
        }

        void d(boolean z) {
            this.b = true;
            if (z) {
                getLooper().quitSafely();
            } else {
                getLooper().quit();
            }
        }

        @Override // com.huawei.haf.handler.TaskHandler
        protected void An_(Message message) {
            if (this.b || !Ag_(message)) {
                return;
            }
            if (e()) {
                c();
                return;
            }
            if (a()) {
                synchronized (this.f2153a.f2152a) {
                    if (!e()) {
                        this.f2153a.a(this.e, true);
                        return;
                    }
                }
            }
            c();
            LogUtil.a("HAF_HandlerCenter", "idle ", this, ", cur size=", Integer.valueOf(this.f2153a.c()));
        }

        @Override // android.os.Handler
        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("TaskHandler{handlerKey=");
            sb.append(this.e);
            if (!TextUtils.isEmpty(this.f2153a.b)) {
                sb.append(", prefix=");
                sb.append(this.f2153a.b);
            }
            sb.append(", idleTime=");
            sb.append(this.f2153a.c);
            sb.append(", HC=");
            sb.append(System.identityHashCode(this.f2153a));
            sb.append(", TH=");
            sb.append(d());
            sb.append("}");
            return sb.toString();
        }

        private boolean a() {
            return (this.f2153a.c == 0 || c == null) ? false : true;
        }

        private boolean Ag_(Message message) {
            return message.what == 100 && message.obj == this;
        }

        private void c() {
            removeMessages(100, this);
            Message messageObtain = Message.obtain(this, 100);
            messageObtain.obj = this;
            sendMessageDelayed(messageObtain, a() ? this.f2153a.c : 600000L);
        }

        private boolean e() {
            Field field = c;
            if (field == null) {
                return true;
            }
            try {
                Object obj = field.get(getLooper().getQueue());
                if (!(obj instanceof Message)) {
                    return false;
                }
                Message message = (Message) obj;
                if (message.getTarget() != this) {
                    LogUtil.b("HAF_HandlerCenter", "exist other handler message in the queue. handler=", message.getTarget());
                }
                return true;
            } catch (IllegalAccessException e) {
                LogUtil.b("HAF_HandlerCenter", "isExistMessages invoke error, ex=", LogUtil.c(e));
                c = null;
                return true;
            }
        }
    }
}
