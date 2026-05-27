package com.huawei.hms.network.exception;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class NetworkException extends IOException {
    public NetworkException(String str, Throwable th) {
        super(str, th);
    }

    public NetworkException(String str) {
        super(str);
    }
}
