package com.huawei.hianalytics.core.log;

/* JADX INFO: loaded from: classes5.dex */
public interface LogAdapter {
    void init(int i, String str);

    boolean isLoggable(int i);

    void println(int i, String str, String str2);
}
