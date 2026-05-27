package com.huawei.agconnect.credential.internal;

import com.huawei.agconnect.https.annotation.Result;

/* JADX INFO: loaded from: classes3.dex */
public class ConnectRet {

    @Result("code")
    private int code;

    @Result("msg")
    private String msg;

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getCode() {
        return this.code;
    }
}
