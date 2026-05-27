package com.huawei.hwbtsdk.btdatatype.datatype;

import com.huawei.health.devicemgr.business.entity.DeviceInfo;
import defpackage.chw;

/* JADX INFO: loaded from: classes5.dex */
public class OperationDeviceInfo extends DeviceInfo {
    private long mEndConnectTime;
    private int mErrorCode;
    private String mErrorMeathod;
    private long mStartConnectTime;

    public long getStartConnectTime() {
        return ((Long) chw.d(Long.valueOf(this.mStartConnectTime))).longValue();
    }

    public void setStartConnectTime(long j) {
        this.mStartConnectTime = ((Long) chw.d(Long.valueOf(j))).longValue();
    }

    public long getEndConnectTime() {
        return ((Long) chw.d(Long.valueOf(this.mEndConnectTime))).longValue();
    }

    public void setEndConnectTime(long j) {
        this.mEndConnectTime = ((Long) chw.d(Long.valueOf(j))).longValue();
    }

    public int getErrorCode() {
        return ((Integer) chw.d(Integer.valueOf(this.mErrorCode))).intValue();
    }

    public void setErrorCode(int i) {
        this.mErrorCode = ((Integer) chw.d(Integer.valueOf(i))).intValue();
    }

    public String getErrorMeathod() {
        return (String) chw.d(this.mErrorMeathod);
    }

    public void setErrorMeathod(String str) {
        this.mErrorMeathod = (String) chw.d(str);
    }
}
