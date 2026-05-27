package com.huawei.operation.beans;

/* JADX INFO: loaded from: classes11.dex */
public class MatterNotifyConfigBean {
    private boolean enable = true;
    private double speedThreshold;
    private double threshold;
    private int type;

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public double getThreshold() {
        return this.threshold;
    }

    public void setThreshold(double d) {
        this.threshold = d;
    }

    public double getSpeedThreshold() {
        return this.speedThreshold;
    }

    public void setSpeedThreshold(double d) {
        this.speedThreshold = d;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MatterNotifyConfigBean) && this.type == ((MatterNotifyConfigBean) obj).getType();
    }

    public int hashCode() {
        return this.type;
    }
}
