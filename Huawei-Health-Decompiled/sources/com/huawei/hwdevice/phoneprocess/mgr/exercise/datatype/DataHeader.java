package com.huawei.hwdevice.phoneprocess.mgr.exercise.datatype;

import defpackage.kqt;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class DataHeader {
    private int bitmap;
    private List<String> capacityBitMaps;
    private int dataLength;
    private int dataNumber;
    private int frameId;
    private int sportId;
    private long time;
    private int timeInterval;
    private List<WorkoutDataInfo> workoutDataInfoLists;

    public int getSportId() {
        return ((Integer) kqt.e(Integer.valueOf(this.sportId))).intValue();
    }

    public void setSportId(int i) {
        this.sportId = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int getFrameId() {
        return ((Integer) kqt.e(Integer.valueOf(this.frameId))).intValue();
    }

    public void setFrameId(int i) {
        this.frameId = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public long getTime() {
        return ((Long) kqt.e(Long.valueOf(this.time))).longValue();
    }

    public void setTime(long j) {
        this.time = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }

    public int getTimeInterval() {
        return ((Integer) kqt.e(Integer.valueOf(this.timeInterval))).intValue();
    }

    public void setTimeInterval(int i) {
        this.timeInterval = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public List<WorkoutDataInfo> getWorkoutDataInfoList() {
        return (List) kqt.e(this.workoutDataInfoLists);
    }

    public void setWorkoutDataInfoList(List<WorkoutDataInfo> list) {
        this.workoutDataInfoLists = (List) kqt.e(list);
    }

    public List<String> getBitMap() {
        return (List) kqt.e(this.capacityBitMaps);
    }

    public void setBitMap(List<String> list) {
        this.capacityBitMaps = (List) kqt.e(list);
    }

    public int getDataLength() {
        return this.dataLength;
    }

    public void setDataLength(int i) {
        this.dataLength = i;
    }

    public int getDataNumber() {
        return this.dataNumber;
    }

    public void setDataNumber(int i) {
        this.dataNumber = i;
    }

    public int getBitmap() {
        return this.bitmap;
    }

    public void setBitmap(int i) {
        this.bitmap = i;
    }
}
