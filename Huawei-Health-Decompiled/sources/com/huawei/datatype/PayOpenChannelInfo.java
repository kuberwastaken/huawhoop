package com.huawei.datatype;

import defpackage.kqt;

/* JADX INFO: loaded from: classes3.dex */
public class PayOpenChannelInfo {
    private String apdu = "";
    private int channelId;

    public String getApdu() {
        return (String) kqt.e(this.apdu);
    }

    public void setApdu(String str) {
        this.apdu = (String) kqt.e(str);
    }

    public int getChannelId() {
        return ((Integer) kqt.e(Integer.valueOf(this.channelId))).intValue();
    }

    public void setChannelId(int i) {
        this.channelId = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }
}
