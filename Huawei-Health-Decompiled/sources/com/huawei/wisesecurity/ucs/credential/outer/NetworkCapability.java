package com.huawei.wisesecurity.ucs.credential.outer;

import defpackage.wzb;
import java.io.IOException;

/* JADX INFO: loaded from: classes8.dex */
public interface NetworkCapability {
    NetworkResponse get(NetworkRequest networkRequest) throws IOException;

    void initConfig(int i, int i2) throws wzb;

    NetworkResponse post(NetworkRequest networkRequest) throws IOException;
}
