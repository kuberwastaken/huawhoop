package com.huawei.networkclient.cache;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public interface ICacheStrategy {
    int getCacheStrategy();

    Long getDiskTimeOut();

    TimeUnit getDiskTimeUnit();

    String getKey();

    boolean needEncrypt();
}
