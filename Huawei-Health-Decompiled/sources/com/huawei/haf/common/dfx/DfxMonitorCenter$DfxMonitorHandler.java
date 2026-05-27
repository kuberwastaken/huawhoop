package com.huawei.haf.common.dfx;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public class DfxMonitorCenter$DfxMonitorHandler extends Handler {
    private static final DfxMonitorCenter$DfxMonitorHandler c = new DfxMonitorCenter$DfxMonitorHandler();

    DfxMonitorCenter$DfxMonitorHandler() {
        super(DfxMonitorCenter$DfxMonitorThread.yO_());
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 100) {
            if (message.obj instanceof DfxMonitorTask) {
                ((DfxMonitorTask) message.obj).onMonitor();
                return;
            }
            return;
        }
        super.handleMessage(message);
    }

    public static Handler yN_() {
        return c;
    }
}
