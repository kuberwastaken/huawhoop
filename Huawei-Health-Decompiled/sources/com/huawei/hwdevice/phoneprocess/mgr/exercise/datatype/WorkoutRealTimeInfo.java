package com.huawei.hwdevice.phoneprocess.mgr.exercise.datatype;

import defpackage.kqt;

/* JADX INFO: loaded from: classes6.dex */
public class WorkoutRealTimeInfo {
    private long calorieInfo;
    private long climeInfo;
    private long distanceInfo;
    private int heartRateInfo;
    private float speedInfo;
    private int sportType;
    private long timeInfo;

    public int getSportType() {
        return ((Integer) kqt.e(Integer.valueOf(this.sportType))).intValue();
    }

    public void setSportType(int i) {
        this.sportType = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public float getSpeedInfo() {
        return ((Float) kqt.e(Float.valueOf(this.speedInfo))).floatValue();
    }

    public void setSpeedInfo(float f) {
        this.speedInfo = ((Float) kqt.e(Float.valueOf(f))).floatValue();
    }

    public int getHeartRateInfo() {
        return ((Integer) kqt.e(Integer.valueOf(this.heartRateInfo))).intValue();
    }

    public void setHeartRateInfo(int i) {
        this.heartRateInfo = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public long getTimeInfo() {
        return ((Long) kqt.e(Long.valueOf(this.timeInfo))).longValue();
    }

    public void setTimeInfo(int i) {
        this.timeInfo = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public long getCalorieInfo() {
        return ((Long) kqt.e(Long.valueOf(this.calorieInfo))).longValue();
    }

    public void setCalorieInfo(long j) {
        this.calorieInfo = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }

    public long getDistanceInfo() {
        return ((Long) kqt.e(Long.valueOf(this.distanceInfo))).longValue();
    }

    public void setDistanceInfo(long j) {
        this.distanceInfo = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }

    public long getClimeInfo() {
        return ((Long) kqt.e(Long.valueOf(this.climeInfo))).longValue();
    }

    public void setClimeInfo(long j) {
        this.climeInfo = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }
}
