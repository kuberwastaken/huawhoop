package com.huawei.agconnect.apms;

import java.util.EventObject;

/* JADX INFO: loaded from: classes3.dex */
public class rqp extends EventObject {
    public long abc;
    public Exception bcd;

    public rqp(Object obj, long j, Exception exc) {
        super(obj);
        this.abc = j;
        this.bcd = exc;
    }
}
