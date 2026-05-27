package com.huawei.networkclient.cache;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface CacheEnum {
    public static final int DISK_NETWORK_KEEP_FRESH = 7;
    public static final int DISK_NETWORK_LESS_NETWORK = 3;
    public static final int NETWORK_FIRST = 4;
    public static final int ONLY_DISK = 2;
    public static final int ONLY_NETWORK = 1;
}
