package com.huawei.wearengine.device;

/* JADX INFO: loaded from: classes11.dex */
public enum ConnectType {
    CONNECT_TYPE_GENERAL(0),
    CONNECT_TYPE_SIMPLE(1),
    CONNECT_TYPE_TRANSPARENT(2);

    private int mType;

    ConnectType(int i) {
        this.mType = i;
    }

    public int value() {
        return this.mType;
    }
}
