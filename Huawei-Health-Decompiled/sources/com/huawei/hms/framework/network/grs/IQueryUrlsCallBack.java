package com.huawei.hms.framework.network.grs;

import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public interface IQueryUrlsCallBack {
    void onCallBackFail(int i);

    void onCallBackSuccess(Map<String, String> map);
}
