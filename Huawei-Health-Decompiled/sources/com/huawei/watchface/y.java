package com.huawei.watchface;

/* JADX INFO: loaded from: classes8.dex */
public enum y {
    CHARGED(1),
    NOT_CHARGED(0);

    private int mValue;

    y(int i) {
        this.mValue = i;
    }

    public int getValue() {
        return this.mValue;
    }
}
