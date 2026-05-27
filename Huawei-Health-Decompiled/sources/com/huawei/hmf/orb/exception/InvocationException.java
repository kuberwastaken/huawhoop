package com.huawei.hmf.orb.exception;

/* JADX INFO: loaded from: classes10.dex */
public class InvocationException extends RuntimeException {
    public InvocationException(String str) {
        super(str);
    }

    public InvocationException(Exception exc) {
        super("by " + exc.toString());
    }
}
