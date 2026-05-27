package com.huawei.multisimsdk.multidevicemanager.util;

/* JADX INFO: loaded from: classes6.dex */
public interface ResponseHandler {
    default void onCallback(int i, String str) {
    }

    void onCallback(String str);
}
