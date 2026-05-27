package com.huawei.hwdevice.mainprocess.mgr.hwmywatchfacemgr.pluginvideo.videoedit.presenter;

import health.compact.a.LogUtil;

/* JADX INFO: loaded from: classes6.dex */
public abstract class GlRenderThread2 extends Thread {
    private static final String TAG = "GlRenderThread2";

    protected abstract void doWork();

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            LogUtil.b(TAG, "thread start to work.");
            doWork();
        } finally {
            LogUtil.b(TAG, "thread work done");
        }
    }
}
