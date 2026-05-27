package com.huawei.unitedevice.hwcommonfilemgr.bean;

/* JADX INFO: loaded from: classes11.dex */
public enum Priority {
    DEFAULT(0),
    LOW(1),
    MIDDLE(2),
    HIGH(3);

    private int mValue;

    Priority(int i) {
        this.mValue = i;
    }

    public int getValue() {
        return this.mValue;
    }
}
