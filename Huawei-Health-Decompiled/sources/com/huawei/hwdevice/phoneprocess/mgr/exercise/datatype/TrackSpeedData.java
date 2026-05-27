package com.huawei.hwdevice.phoneprocess.mgr.exercise.datatype;

import defpackage.kqt;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class TrackSpeedData implements Serializable {
    private static final long serialVersionUID = -6754616340266058150L;
    private int mRealTimeSpeed;
    private long mTime;

    public TrackSpeedData() {
    }

    public TrackSpeedData(long j, int i) {
        this.mTime = ((Long) kqt.e(Long.valueOf(j))).longValue();
        this.mRealTimeSpeed = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public long getTime() {
        return ((Long) kqt.e(Long.valueOf(this.mTime))).longValue();
    }

    public void setTime(long j) {
        this.mTime = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }

    public int getRealTimeSpeed() {
        return ((Integer) kqt.e(Integer.valueOf(this.mRealTimeSpeed))).intValue();
    }

    public void setRealTimeSpeed(int i) {
        this.mRealTimeSpeed = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(16);
        sb.append("TrackPullFreqData{mTime=");
        sb.append(this.mTime);
        sb.append("mRealTimeSpeed=");
        sb.append(this.mRealTimeSpeed);
        return sb.toString();
    }
}
