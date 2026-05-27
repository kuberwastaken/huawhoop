package com.huawei.pluginmessagecenter.service;

import com.huawei.pluginmessagecenter.provider.data.MessageChangeEvent;

/* JADX INFO: loaded from: classes7.dex */
public interface MessageObserver {
    public static final int RET_OK = 0;
    public static final int RET_UNKNOWN_ERROR = -1;

    void onChange(int i, MessageChangeEvent messageChangeEvent);
}
