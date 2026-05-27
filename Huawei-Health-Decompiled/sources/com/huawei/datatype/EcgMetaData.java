package com.huawei.datatype;

import defpackage.kqt;

/* JADX INFO: loaded from: classes3.dex */
public class EcgMetaData {
    private int averageHeartRate;
    private String dataSources;
    private String ecgAppVersion;
    private long ecgArrhyType;
    private int ecgDataLength;
    private String packageName;
    private long userSymptom;

    public long getEcgArrhyType() {
        return ((Long) kqt.e(Long.valueOf(this.ecgArrhyType))).longValue();
    }

    public void setEcgArrhyType(long j) {
        this.ecgArrhyType = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }

    public int getAverageHeartRate() {
        return ((Integer) kqt.e(Integer.valueOf(this.averageHeartRate))).intValue();
    }

    public void setAverageHeartRate(int i) {
        this.averageHeartRate = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public long getUserSymptom() {
        return ((Long) kqt.e(Long.valueOf(this.userSymptom))).longValue();
    }

    public void setUserSymptom(long j) {
        this.userSymptom = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }

    public int getEcgDataLength() {
        return ((Integer) kqt.e(Integer.valueOf(this.ecgDataLength))).intValue();
    }

    public void setEcgDataLength(int i) {
        this.ecgDataLength = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public String getEcgAppVersion() {
        return this.ecgAppVersion;
    }

    public void setEcgAppVersion(String str) {
        this.ecgAppVersion = str;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public String getDataSources() {
        return this.dataSources;
    }

    public void setDataSources(String str) {
        this.dataSources = str;
    }
}
