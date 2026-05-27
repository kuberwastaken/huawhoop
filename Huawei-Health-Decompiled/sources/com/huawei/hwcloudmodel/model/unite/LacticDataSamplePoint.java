package com.huawei.hwcloudmodel.model.unite;

/* JADX INFO: loaded from: classes5.dex */
public class LacticDataSamplePoint {
    private long endTime;
    private String key;
    private long startTime;
    private String unit;
    private String value;

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

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String str) {
        this.unit = str;
    }

    public String toString() {
        return "LacticDataSamplePoint{startTime=" + this.startTime + ", endTime=" + this.endTime + ", key=" + this.key + ", value=" + this.value + ", unit='" + this.unit + "'}";
    }
}
