package com.huawei.watchface;

/* JADX INFO: loaded from: classes8.dex */
public enum ac {
    ORDERED("1"),
    NOT_ORDERED("0");

    private String mValue;

    ac(String str) {
        this.mValue = str;
    }

    public String getValue() {
        return this.mValue;
    }
}
