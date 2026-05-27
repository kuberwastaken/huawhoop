package com.huawei.datatype;

import defpackage.kqt;

/* JADX INFO: loaded from: classes3.dex */
public class FitnessUserInfo {
    private static final int DEFAULT_HEIGHT = 170;
    private static final int DEFAULT_WEIGHT = 60;
    private int mHeight = 170;
    private int mWeight = 60;
    private long mTime = 0;

    public int getHeight() {
        return ((Integer) kqt.e(Integer.valueOf(this.mHeight))).intValue();
    }

    public void setHeight(int i) {
        this.mHeight = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getWeight() {
        return ((Integer) kqt.e(Integer.valueOf(this.mWeight))).intValue();
    }

    public void setWeight(int i) {
        this.mWeight = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public long getTime() {
        return ((Long) kqt.e(Long.valueOf(this.mTime))).longValue();
    }

    public void setTime(long j) {
        this.mTime = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }
}
