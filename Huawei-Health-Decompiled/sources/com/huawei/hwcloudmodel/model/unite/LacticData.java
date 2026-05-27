package com.huawei.hwcloudmodel.model.unite;

import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class LacticData {
    private int appType;
    private long dataId;
    private long deviceCode;
    private long endTime;
    private int healthDataSource;
    private int mergedFlag;
    private String recordId;
    private List<LacticDataSamplePoint> samplePoints;
    private long startTime;
    private String timeZone;
    private int type;
    private long version;

    public long getDataId() {
        return this.dataId;
    }

    public void setDataId(long j) {
        this.dataId = j;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public long getDeviceCode() {
        return this.deviceCode;
    }

    public void setDeviceCode(long j) {
        this.deviceCode = j;
    }

    public List<LacticDataSamplePoint> getSamplePoints() {
        return this.samplePoints;
    }

    public void setSamplePoints(List<LacticDataSamplePoint> list) {
        this.samplePoints = list;
    }

    public String getRecordId() {
        return this.recordId;
    }

    public void setRecordId(String str) {
        this.recordId = str;
    }

    public long getVersion() {
        return this.version;
    }

    public void setVersion(long j) {
        this.version = j;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(String str) {
        this.timeZone = str;
    }

    public int getAppType() {
        return this.appType;
    }

    public void setAppType(int i) {
        this.appType = i;
    }

    public int getMergedFlag() {
        return this.mergedFlag;
    }

    public void setMergedFlag(int i) {
        this.mergedFlag = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getHealthDataSource() {
        return this.healthDataSource;
    }

    public void setHealthDataSource(int i) {
        this.healthDataSource = i;
    }

    public String toString() {
        return "LacticData{dataId=" + this.dataId + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", deviceCode=" + this.deviceCode + ", samplePoints=" + this.samplePoints.toString() + ", recordId=" + this.recordId + ", version=" + this.version + ", timeZone=" + this.timeZone + ", appType=" + this.appType + ", mergedFlag=" + this.mergedFlag + ", type=" + this.type + ", healthDataSource='" + this.healthDataSource + "'}";
    }
}
