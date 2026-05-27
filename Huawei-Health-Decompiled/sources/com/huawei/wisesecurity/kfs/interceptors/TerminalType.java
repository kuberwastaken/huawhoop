package com.huawei.wisesecurity.kfs.interceptors;

/* JADX INFO: loaded from: classes11.dex */
public enum TerminalType {
    ANDROID("1"),
    WINDOWS("2"),
    IOS("3");

    private String value;

    TerminalType(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
