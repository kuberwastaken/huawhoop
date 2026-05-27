package com.huawei.uikit.hwadvancednumberpicker.utils;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes8.dex */
public class HwCommonHandler extends Handler {
    private WeakReference<MessageHandler> d;

    public interface MessageHandler {
        void handleMessage(Message message);
    }

    public HwCommonHandler(MessageHandler messageHandler) {
        this.d = new WeakReference<>(messageHandler);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        MessageHandler messageHandler = this.d.get();
        if (messageHandler != null) {
            messageHandler.handleMessage(message);
        }
    }
}
