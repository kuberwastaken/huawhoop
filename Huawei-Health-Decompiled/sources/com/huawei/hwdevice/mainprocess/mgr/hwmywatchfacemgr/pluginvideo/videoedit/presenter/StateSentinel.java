package com.huawei.hwdevice.mainprocess.mgr.hwmywatchfacemgr.pluginvideo.videoedit.presenter;

import android.os.Handler;

/* JADX INFO: loaded from: classes6.dex */
public abstract class StateSentinel extends Sentinel {
    private Handler mMagic2Handler;

    public abstract void pause();

    public abstract void release();

    public abstract void resume();

    public abstract void seekTo(int i);

    public abstract void update(int i);

    public StateSentinel(int i, Handler handler) {
        super(i);
        this.mMagic2Handler = handler;
    }

    public void sendSeekCompleteToMagic() {
        Handler handler = this.mMagic2Handler;
        handler.sendMessage(handler.obtainMessage(0, this.flag, 0));
    }
}
