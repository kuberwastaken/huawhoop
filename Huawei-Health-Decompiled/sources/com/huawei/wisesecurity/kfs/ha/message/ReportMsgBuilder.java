package com.huawei.wisesecurity.kfs.ha.message;

import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes8.dex */
public interface ReportMsgBuilder {
    LinkedHashMap<String, String> build();

    String getEventId();
}
