package com.huawei.hwcloudmodel.model.unite;

import com.huawei.operation.utils.Constants;
import java.util.Objects;

/* JADX INFO: loaded from: classes11.dex */
public class LacticStatistics {
    private long dataId;
    private int dataSource;
    private long deviceCode;
    private long generateTime;
    private int recordDay;
    private LacticStatisticsBasic statistics;
    private String timeZone;
    private long version;

    public long getDataId() {
        return this.dataId;
    }

    public void setDataId(long j) {
        this.dataId = j;
    }

    public int getRecordDay() {
        return this.recordDay;
    }

    public void setRecordDay(int i) {
        this.recordDay = i;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(String str) {
        this.timeZone = str;
    }

    public int getDataSource() {
        return this.dataSource;
    }

    public void setDataSource(int i) {
        this.dataSource = i;
    }

    public long getDeviceCode() {
        return this.deviceCode;
    }

    public void setDeviceCode(long j) {
        this.deviceCode = j;
    }

    public long getVersion() {
        return this.version;
    }

    public void setVersion(long j) {
        this.version = j;
    }

    public long getGenerateTime() {
        return this.generateTime;
    }

    public void setGenerateTime(long j) {
        this.generateTime = j;
    }

    public LacticStatisticsBasic getStatistics() {
        return this.statistics;
    }

    public void setStatistics(LacticStatisticsBasic lacticStatisticsBasic) {
        this.statistics = lacticStatisticsBasic;
    }

    public String toString() {
        return "LacticStatistics{dataId=" + this.dataId + ", recordDay=" + this.recordDay + ", timeZone=" + this.timeZone + ", dataSource=" + this.dataSource + ", deviceCode=" + this.deviceCode + ", version=" + this.version + ", generateTime=" + this.generateTime + ", statistics=" + Objects.toString(this.statistics, Constants.NULL) + '}';
    }
}
