package com.huawei.datatype;

import defpackage.kqt;

/* JADX INFO: loaded from: classes3.dex */
public class PayApduInfo {
    private String mApdu;
    private int mChannelId;
    private int mReqId;

    public int getReqid() {
        return ((Integer) kqt.e(Integer.valueOf(this.mReqId))).intValue();
    }

    public void setReqid(int i) {
        this.mReqId = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public String getApdu() {
        return (String) kqt.e(this.mApdu);
    }

    public void setApdu(String str) {
        this.mApdu = (String) kqt.e(str);
    }

    public int getChannelId() {
        return ((Integer) kqt.e(Integer.valueOf(this.mChannelId))).intValue();
    }

    public void setChannelId(int i) {
        this.mChannelId = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }
}
