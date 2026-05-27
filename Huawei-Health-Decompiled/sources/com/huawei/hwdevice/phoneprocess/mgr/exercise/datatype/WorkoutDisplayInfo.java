package com.huawei.hwdevice.phoneprocess.mgr.exercise.datatype;

import defpackage.kqt;

/* JADX INFO: loaded from: classes6.dex */
public class WorkoutDisplayInfo {
    private boolean isFreeMotion = false;
    private int sportDataSource = 0;
    private int chiefSportDataType = 0;
    private boolean isTrackPoint = true;
    private int workoutType = 258;

    public void setFreeMotion(boolean z) {
        this.isFreeMotion = ((Boolean) kqt.e(Boolean.valueOf(z))).booleanValue();
    }

    public boolean getFreeMotion() {
        return ((Boolean) kqt.e(Boolean.valueOf(this.isFreeMotion))).booleanValue();
    }

    public void setSportDataSource(int i) {
        this.sportDataSource = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getSportDataSource() {
        return ((Integer) kqt.e(Integer.valueOf(this.sportDataSource))).intValue();
    }

    public void setChiefSportDataType(int i) {
        this.chiefSportDataType = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getChiefSportDataType() {
        return ((Integer) kqt.e(Integer.valueOf(this.chiefSportDataType))).intValue();
    }

    public void setHasTrackPoint(boolean z) {
        this.isTrackPoint = ((Boolean) kqt.e(Boolean.valueOf(z))).booleanValue();
    }

    public boolean isHasTrackPoint() {
        return ((Boolean) kqt.e(Boolean.valueOf(this.isTrackPoint))).booleanValue();
    }

    public void setWorkoutType(int i) {
        this.workoutType = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getWorkoutType() {
        return ((Integer) kqt.e(Integer.valueOf(this.workoutType))).intValue();
    }
}
