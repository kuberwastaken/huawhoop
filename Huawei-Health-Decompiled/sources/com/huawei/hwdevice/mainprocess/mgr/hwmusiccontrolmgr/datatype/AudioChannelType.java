package com.huawei.hwdevice.mainprocess.mgr.hwmusiccontrolmgr.datatype;

/* JADX INFO: loaded from: classes5.dex */
public enum AudioChannelType {
    MONO(1, "MONO"),
    STEREO(2, "STEREO");

    private final int channelValue;
    private final String description;

    AudioChannelType(int i, String str) {
        this.channelValue = i;
        this.description = str;
    }

    public int getChannelValue() {
        return this.channelValue;
    }

    public String getDescription() {
        return this.description;
    }
}
