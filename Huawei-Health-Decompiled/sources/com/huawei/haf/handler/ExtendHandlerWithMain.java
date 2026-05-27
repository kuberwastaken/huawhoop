package com.huawei.haf.handler;

import android.os.Handler;
import android.os.Message;
import com.huawei.haf.handler.HandlerCenter;

/* JADX INFO: loaded from: classes.dex */
final class ExtendHandlerWithMain implements ExtendHandler {
    private final TaskHandler b;
    private final Handler.Callback c;

    @Override // com.huawei.haf.handler.ExtendHandler
    public void quit(boolean z) {
    }

    @Override // com.huawei.haf.handler.ExtendHandler
    public void postTask(Runnable runnable) {
        TaskHandler taskHandler = this.b;
        taskHandler.Ao_(Message.obtain(taskHandler, runnable), 0L, this.c);
    }

    @Override // com.huawei.haf.handler.ExtendHandler
    public void postTask(Runnable runnable, long j) {
        TaskHandler taskHandler = this.b;
        taskHandler.Ao_(Message.obtain(taskHandler, runnable), j, this.c);
    }

    @Override // com.huawei.haf.handler.ExtendHandler
    public void sendEmptyMessage(int i) {
        zW_(Message.obtain(this.b, i), this.c, 0L);
    }

    @Override // com.huawei.haf.handler.ExtendHandler
    public void sendEmptyMessage(int i, long j) {
        zW_(Message.obtain(this.b, i), this.c, j);
    }

    @Override // com.huawei.haf.handler.ExtendHandler
    public void sendMessage(Message message) {
        zW_(message, this.c, 0L);
    }

    @Override // com.huawei.haf.handler.ExtendHandler
    public void sendMessage(Message message, long j) {
        zW_(message, this.c, j);
    }

    @Override // com.huawei.haf.handler.ExtendHandler
    public boolean hasMessages(int i) {
        return this.b.hasMessages(i, this.c);
    }

    @Override // com.huawei.haf.handler.ExtendHandler
    public void removeTasks(Runnable runnable) {
        this.b.removeCallbacks(runnable, this.c);
    }

    @Override // com.huawei.haf.handler.ExtendHandler
    public void removeMessages(int i) {
        this.b.removeMessages(i, this.c);
    }

    @Override // com.huawei.haf.handler.ExtendHandler
    public void removeTasksAndMessages() {
        this.b.removeCallbacksAndMessages(this.c);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        TaskHandler taskHandler = this.b;
        taskHandler.Ao_(Message.obtain(taskHandler, runnable), 0L, this.c);
    }

    private void zW_(Message message, Handler.Callback callback, long j) {
        if (message.getCallback() == null && (callback instanceof HandlerCenter.OnlyTaskHandlerCallback)) {
            throw new UnsupportedOperationException("The Handler.Callback used does not support processing Message.what messages");
        }
        this.b.Ao_(message, j, this.c);
    }
}
