package com.huawei.hwdevice.phoneprocess.mgr.exercise.datatype;

import defpackage.kqt;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class TrackSwolfData implements Serializable {
    private static final long serialVersionUID = 1765216509700286047L;
    private int mSwolf;
    private long mTime;

    public TrackSwolfData() {
    }

    public TrackSwolfData(long j, int i) {
        this.mTime = ((Long) kqt.e(Long.valueOf(j))).longValue();
        this.mSwolf = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public long getTime() {
        return ((Long) kqt.e(Long.valueOf(this.mTime))).longValue();
    }

    public void setTime(long j) {
        this.mTime = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }

    public int getSwolf() {
        return ((Integer) kqt.e(Integer.valueOf(this.mSwolf))).intValue();
    }

    public void setSwolf(int i) {
        this.mSwolf = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public String toString() {
        return "TrackSwolfData{mTime=" + this.mTime + ", mSwolf=" + this.mSwolf + '}';
    }
}
