package com.huawei.hwdevice.mainprocess.mgr.hwmywatchfacemgr.pluginvideo.videoedit.edit;

import com.huawei.watchface.videoedit.param.CanvasConfig;

/* JADX INFO: loaded from: classes6.dex */
public enum FrameRatioEnum {
    DEFAULT(0, "default", 0, 0),
    FULL(1, CanvasConfig.FULL_CONFIG, 0, 0),
    _1_1(2, "1:1", 1080, 1080),
    _16_9(3, "16:9", 1920, 1080),
    _9_16(4, "9:16", 1080, 1920),
    _21_9(5, "21:9", 2520, 1080),
    _9_21(6, "9:21", 1080, 2520);

    public static final int DEFAULT_HEIGHT = 1920;
    public static final int DEFAULT_WIDTH = 1080;
    private int mHeight;
    private int mIndex;
    private String mRatioStr;
    private int mWidth;

    FrameRatioEnum(int i, String str, int i2, int i3) {
        this.mIndex = i;
        this.mRatioStr = str;
        this.mWidth = i2;
        this.mHeight = i3;
    }

    public String getRatioStr() {
        return this.mRatioStr;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }
}
