package com.huawei.hwcommonmodel.fitnessdatatype;

import defpackage.kqt;

/* JADX INFO: loaded from: classes5.dex */
public class DataTotalMotion {
    private int calorie;
    private int distance;
    private int height;
    private int motion_type;
    private int pushes;
    private int sleep_time;
    private int step;

    public int getMotion_type() {
        return ((Integer) kqt.e(Integer.valueOf(this.motion_type))).intValue();
    }

    public void setMotion_type(int i) {
        this.motion_type = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getStep() {
        return ((Integer) kqt.e(Integer.valueOf(this.step))).intValue();
    }

    public void setStep(int i) {
        this.step = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getCalorie() {
        return ((Integer) kqt.e(Integer.valueOf(this.calorie))).intValue();
    }

    public void setCalorie(int i) {
        this.calorie = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getDistance() {
        return ((Integer) kqt.e(Integer.valueOf(this.distance))).intValue();
    }

    public void setDistance(int i) {
        this.distance = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getHeight() {
        return ((Integer) kqt.e(Integer.valueOf(this.height))).intValue();
    }

    public void setHeight(int i) {
        this.height = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public void setSleep_time(int i) {
        this.sleep_time = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getPushes() {
        return ((Integer) kqt.e(Integer.valueOf(this.pushes))).intValue();
    }

    public void setPushes(int i) {
        this.pushes = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }
}
