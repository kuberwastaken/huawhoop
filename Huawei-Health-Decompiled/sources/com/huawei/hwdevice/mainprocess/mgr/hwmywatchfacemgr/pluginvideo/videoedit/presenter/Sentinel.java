package com.huawei.hwdevice.mainprocess.mgr.hwmywatchfacemgr.pluginvideo.videoedit.presenter;

import com.huawei.watchface.videoedit.presenter.ModelVisitor;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public abstract class Sentinel {
    protected int flag;

    public abstract List<ModelVisitor> getModelVisitor();

    public Sentinel(int i) {
        this.flag = i;
    }

    public int getFlag() {
        return this.flag;
    }
}
