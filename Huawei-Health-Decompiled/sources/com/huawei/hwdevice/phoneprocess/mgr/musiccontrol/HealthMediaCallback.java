package com.huawei.hwdevice.phoneprocess.mgr.musiccontrol;

import android.media.session.MediaController;

/* JADX INFO: loaded from: classes6.dex */
public abstract class HealthMediaCallback extends MediaController.Callback {
    private String mPackageName;

    public HealthMediaCallback(String str) {
        this.mPackageName = str;
    }

    public String getPackageName() {
        return this.mPackageName;
    }
}
