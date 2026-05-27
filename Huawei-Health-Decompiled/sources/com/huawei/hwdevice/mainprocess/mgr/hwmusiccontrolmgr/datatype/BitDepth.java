package com.huawei.hwdevice.mainprocess.mgr.hwmusiccontrolmgr.datatype;

/* JADX INFO: loaded from: classes5.dex */
public enum BitDepth {
    BIT_8(8, "8-bit audio"),
    BIT_16(16, "16-bit audio"),
    BIT_24(24, "24-bit audio"),
    BIT_32(32, "32-bit audio"),
    BIT_64(64, "64-bit audio");

    private final int bitValue;
    private final String description;

    BitDepth(int i, String str) {
        this.bitValue = i;
        this.description = str;
    }

    public int getBitValue() {
        return this.bitValue;
    }

    public String getDescription() {
        return this.description;
    }
}
