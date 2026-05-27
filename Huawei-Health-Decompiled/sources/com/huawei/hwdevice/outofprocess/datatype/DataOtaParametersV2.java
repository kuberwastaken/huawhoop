package com.huawei.hwdevice.outofprocess.datatype;

import com.google.gson.annotations.SerializedName;
import defpackage.kqt;

/* JADX INFO: loaded from: classes6.dex */
public class DataOtaParametersV2 {
    private int appWaitTimeout;
    private int deviceRestartTimeout;
    private int otaUnitSize;

    @SerializedName("ackEnable")
    private boolean isAckEnable = false;
    private long otaInterval = 0;

    @SerializedName("offsetEnable")
    private boolean mOffsetEnable = false;

    public long getOtaInterval() {
        return ((Long) kqt.e(Long.valueOf(this.otaInterval))).longValue();
    }

    public void setOtaInterval(long j) {
        this.otaInterval = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }

    public void setAckEnable(long j) {
        if (j == 1) {
            this.isAckEnable = ((Boolean) kqt.e(true)).booleanValue();
        }
    }

    public boolean getAckEnable() {
        return ((Boolean) kqt.e(Boolean.valueOf(this.isAckEnable))).booleanValue();
    }

    public int getDeviceRestartTimeout() {
        return ((Integer) kqt.e(Integer.valueOf(this.deviceRestartTimeout))).intValue();
    }

    public void setDeviceRestartTimeout(int i) {
        this.deviceRestartTimeout = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getAppWaitTimeout() {
        return ((Integer) kqt.e(Integer.valueOf(this.appWaitTimeout))).intValue();
    }

    public void setAppWaitTimeout(int i) {
        this.appWaitTimeout = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getOtaUnitSize() {
        return ((Integer) kqt.e(Integer.valueOf(this.otaUnitSize))).intValue();
    }

    public void setOtaUnitSize(int i) {
        this.otaUnitSize = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public boolean getOffsetEnable() {
        return ((Boolean) kqt.e(Boolean.valueOf(this.mOffsetEnable))).booleanValue();
    }

    public void setOffsetEnable(boolean z) {
        this.mOffsetEnable = ((Boolean) kqt.e(Boolean.valueOf(z))).booleanValue();
    }
}
