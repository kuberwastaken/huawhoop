package com.huawei.hwdevice.phoneprocess.mgr.exercise.datatype;

import defpackage.kqt;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class TrackPullFreqData implements Serializable {
    private static final long serialVersionUID = 3173921036839865638L;
    private int mPullFreq;
    private long mTime;

    public TrackPullFreqData() {
    }

    public TrackPullFreqData(long j, int i) {
        this.mTime = ((Long) kqt.e(Long.valueOf(j))).longValue();
        this.mPullFreq = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public long getTime() {
        return ((Long) kqt.e(Long.valueOf(this.mTime))).longValue();
    }

    public void setTime(long j) {
        this.mTime = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }

    public int getPullFreq() {
        return ((Integer) kqt.e(Integer.valueOf(this.mPullFreq))).intValue();
    }

    public void setPullFreq(int i) {
        this.mPullFreq = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public String toString() {
        return "TrackPullFreqData{mTime=" + this.mTime + ", mPullFreq=" + this.mPullFreq + '}';
    }
}
