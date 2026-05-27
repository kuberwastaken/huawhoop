package com.huawei.trade.datatype;

import android.os.Parcel;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DeviceBenefitInfo extends BaseDeviceBenefitInfo {
    private List<DeviceBenefitInfoDetail> benefitInfos;
    private String deviceBenefitId;
    private int disconnectStopDelay;
    private int duration;
    private int durationUnit;
    private int switchActivateDelay;

    protected DeviceBenefitInfo(Parcel parcel) {
        super(parcel);
    }

    public String getDeviceBenefitId() {
        return this.deviceBenefitId;
    }

    public void setDeviceBenefitId(String str) {
        this.deviceBenefitId = str;
    }

    public int getSwitchActivateDelay() {
        return this.switchActivateDelay;
    }

    public void setSwitchActivateDelay(int i) {
        this.switchActivateDelay = i;
    }

    public int getDisconnectStopDelay() {
        return this.disconnectStopDelay;
    }

    public void setDisconnectStopDelay(int i) {
        this.disconnectStopDelay = i;
    }

    public List<DeviceBenefitInfoDetail> getBenefitInfos() {
        return this.benefitInfos;
    }

    public void setBenefitInfos(List<DeviceBenefitInfoDetail> list) {
        this.benefitInfos = list;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public int getDurationUnit() {
        return this.durationUnit;
    }

    public void setDurationUnit(int i) {
        this.durationUnit = i;
    }

    public String toString() {
        return "DeviceBenefitInfo{deviceBenefitId='" + this.deviceBenefitId + "', switchActivateDelay=" + this.switchActivateDelay + ", disconnectStopDelay=" + this.disconnectStopDelay + ", benefitInfos=" + this.benefitInfos + ", duration=" + this.duration + ", durationUnit=" + this.durationUnit + '}';
    }
}
