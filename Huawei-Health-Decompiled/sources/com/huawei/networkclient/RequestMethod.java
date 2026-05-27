package com.huawei.networkclient;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface RequestMethod {
    public static final int CONNECT = 6;
    public static final int DELETE = 4;
    public static final int GET = 1;
    public static final int HEAD = 5;
    public static final int OPTIONS = 7;
    public static final int POST = 2;
    public static final int PUT = 3;
    public static final int TRACE = 8;
}
