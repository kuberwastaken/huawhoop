package com.huawei.hwdevice.mainprocess.mgr.hwmywatchfacemgr.pluginvideo.videoedit.listener;

/* JADX INFO: loaded from: classes6.dex */
public interface CropListener {
    void onCurrentPointerMoving(int i, boolean z);

    void onLeftCropping(int i, boolean z, boolean z2);

    void onRightCropping(int i, boolean z);

    void onSeekEnd(boolean z);

    void onSeekStart();

    void updateCropTimeText(String str);

    void updateProgress();

    void updateTimeText();
}
