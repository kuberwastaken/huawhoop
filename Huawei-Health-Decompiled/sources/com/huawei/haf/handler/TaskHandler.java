package com.huawei.haf.handler;

import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
class TaskHandler extends Handler {
    private final String e;

    protected void An_(Message message) {
    }

    TaskHandler(Looper looper) {
        super(looper);
        this.e = String.valueOf(System.identityHashCode(this));
    }

    protected final boolean Ao_(Message message, long j, Handler.Callback callback) {
        Am_(message, callback);
        if (sendMessageDelayed(message, j)) {
            return true;
        }
        Al_(message);
        return false;
    }

    protected final String d() {
        return this.e;
    }

    @Override // android.os.Handler
    public final void dispatchMessage(Message message) {
        Handler.Callback callbackAl_ = Al_(message);
        if (callbackAl_ == null || !callbackAl_.handleMessage(message)) {
            super.dispatchMessage(message);
        }
        An_(message);
    }

    private void Am_(Message message, Handler.Callback callback) {
        if (message.obj == this) {
            return;
        }
        if (message.obj != null) {
            message.getData().putBinder(this.e, new MessageObjectWapper(message.obj));
        }
        message.obj = callback;
    }

    private Handler.Callback Al_(Message message) {
        if (message.obj == this) {
            return null;
        }
        Handler.Callback callback = message.obj instanceof Handler.Callback ? (Handler.Callback) message.obj : null;
        message.obj = null;
        Bundle bundlePeekData = message.peekData();
        if (bundlePeekData != null) {
            IBinder binder = bundlePeekData.getBinder(this.e);
            if (binder instanceof MessageObjectWapper) {
                message.obj = ((MessageObjectWapper) binder).d;
                bundlePeekData.remove(this.e);
            }
        }
        return callback;
    }

    static class MessageObjectWapper extends Binder {
        final Object d;

        MessageObjectWapper(Object obj) {
            this.d = obj;
        }
    }
}
