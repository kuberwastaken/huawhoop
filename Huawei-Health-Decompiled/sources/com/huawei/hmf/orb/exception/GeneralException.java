package com.huawei.hmf.orb.exception;

/* JADX INFO: loaded from: classes10.dex */
public class GeneralException extends Exception {
    public int code;

    public GeneralException(int i) {
        this.code = i;
    }

    public GeneralException(int i, Throwable th) {
        super(th);
        this.code = i;
    }
}
