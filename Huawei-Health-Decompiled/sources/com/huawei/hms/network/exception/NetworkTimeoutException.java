package com.huawei.hms.network.exception;

/* JADX INFO: loaded from: classes10.dex */
public abstract class NetworkTimeoutException extends NetworkException {
    public NetworkTimeoutException(String str, Throwable th) {
        super(str, th);
    }

    public NetworkTimeoutException(String str) {
        super(str);
    }
}
