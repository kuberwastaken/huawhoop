package com.huawei.datatype;

import defpackage.kqt;

/* JADX INFO: loaded from: classes3.dex */
public class GpsStruct {
    private int mGpsSpeed = -1;
    private long mGpsDistance = -1;
    private int mGpsAltitude = -1;
    private long mGpsTotalDistance = -1;
    private double mGpsMarsLongitude = -1.0d;
    private double mGpsMarsLatitude = -1.0d;
    private double mGpsLongitude = -1.0d;
    private double mGpsLatitude = -1.0d;
    private double mGpsDirection = -1.0d;
    private double mGpsPrecision = -1.0d;
    private int mGpsQuality = -1;
    private long mGpsStartTime = -1;
    private long mGpsEndTime = -1;

    public int getGpsSpeed() {
        return ((Integer) kqt.e(Integer.valueOf(this.mGpsSpeed))).intValue();
    }

    public void setGpsSpeed(int i) {
        this.mGpsSpeed = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public long getGpsDistance() {
        return ((Long) kqt.e(Long.valueOf(this.mGpsDistance))).longValue();
    }

    public void setGpsDistance(long j) {
        this.mGpsDistance = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }

    public int getGpsAltitude() {
        return ((Integer) kqt.e(Integer.valueOf(this.mGpsAltitude))).intValue();
    }

    public void setGpsAltitude(int i) {
        this.mGpsAltitude = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public long getGpsTotalDistance() {
        return ((Long) kqt.e(Long.valueOf(this.mGpsTotalDistance))).longValue();
    }

    public void setGpsTotalDistance(long j) {
        this.mGpsTotalDistance = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }

    public void setGpsStartTime(long j) {
        this.mGpsStartTime = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }

    public long getGpsStartTime() {
        return ((Long) kqt.e(Long.valueOf(this.mGpsStartTime))).longValue();
    }

    public void setGpsEndTime(long j) {
        this.mGpsEndTime = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }

    public long getGpsEndTime() {
        return ((Long) kqt.e(Long.valueOf(this.mGpsEndTime))).longValue();
    }

    public double getGpsMarsLongitude() {
        return ((Double) kqt.e(Double.valueOf(this.mGpsMarsLongitude))).doubleValue();
    }

    public void setGpsMarsLongitude(double d) {
        this.mGpsMarsLongitude = ((Double) kqt.e(Double.valueOf(d))).doubleValue();
    }

    public double getGpsMarsLatitude() {
        return ((Double) kqt.e(Double.valueOf(this.mGpsMarsLatitude))).doubleValue();
    }

    public void setGpsMarsLatitude(double d) {
        this.mGpsMarsLatitude = ((Double) kqt.e(Double.valueOf(d))).doubleValue();
    }

    public double getGpsLongitude() {
        return ((Double) kqt.e(Double.valueOf(this.mGpsLongitude))).doubleValue();
    }

    public void setGpsLongitude(double d) {
        this.mGpsLongitude = ((Double) kqt.e(Double.valueOf(d))).doubleValue();
    }

    public double getGpsLatitude() {
        return ((Double) kqt.e(Double.valueOf(this.mGpsLatitude))).doubleValue();
    }

    public void setGpsLatitude(double d) {
        this.mGpsLatitude = ((Double) kqt.e(Double.valueOf(d))).doubleValue();
    }

    public double getGpsDirection() {
        return ((Double) kqt.e(Double.valueOf(this.mGpsDirection))).doubleValue();
    }

    public void setGpsDirection(double d) {
        this.mGpsDirection = ((Double) kqt.e(Double.valueOf(d))).doubleValue();
    }

    public double getGpsPrecision() {
        return ((Double) kqt.e(Double.valueOf(this.mGpsPrecision))).doubleValue();
    }

    public void setGpsPrecision(double d) {
        this.mGpsPrecision = ((Double) kqt.e(Double.valueOf(d))).doubleValue();
    }

    public int getGpsQuality() {
        return ((Integer) kqt.e(Integer.valueOf(this.mGpsQuality))).intValue();
    }

    public void setGpsQuality(int i) {
        this.mGpsQuality = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }
}
