package com.huawei.hwdevice.phoneprocess.mgr.exercise.datatype;

import defpackage.kqt;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class TrackAltitudeData implements Serializable {
    private static final long serialVersionUID = 8239372811980674006L;
    private double altitude;
    private long time;

    public TrackAltitudeData() {
    }

    public TrackAltitudeData(long j, double d) {
        this.time = j;
        this.altitude = d;
    }

    public long getTime() {
        return ((Long) kqt.e(Long.valueOf(this.time))).longValue();
    }

    public void setTime(long j) {
        this.time = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }

    public double getAltitude() {
        return ((Double) kqt.e(Double.valueOf(this.altitude))).doubleValue();
    }

    public void setAltitude(double d) {
        this.altitude = ((Double) kqt.e(Double.valueOf(d))).doubleValue();
    }

    public String toString() {
        return "TrackAltitudeData [time=" + this.time + ", altitude=" + this.altitude + "]";
    }
}
