package com.huawei.wearengine.sensor;

/* JADX INFO: loaded from: classes11.dex */
public enum SupportFrequency {
    HIGH(1),
    MID(2);

    private int value;

    SupportFrequency(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
