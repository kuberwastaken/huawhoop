package com.huawei.networkclient;

import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public interface ParamsFactory {
    Map<String, Object> getBody(Object obj);

    Map<String, String> getHeaders();
}
