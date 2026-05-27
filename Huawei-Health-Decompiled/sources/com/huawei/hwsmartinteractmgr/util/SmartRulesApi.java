package com.huawei.hwsmartinteractmgr.util;

/* JADX INFO: loaded from: classes6.dex */
public interface SmartRulesApi {
    public static final String AI_INFORMATION_MODULE = "ai-information-001";
    public static final String INFORMATION_MORE_URL = "information_more_url";

    void deleteSmartMsgByType(int i);

    String getRuleData(int i, String str, String str2);

    boolean isRuleOpen(int i, String str);
}
