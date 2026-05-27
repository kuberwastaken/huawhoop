package com.unicom.online.account.kernel;

import com.huawei.operation.utils.Constants;

/* JADX INFO: loaded from: classes8.dex */
public final class an {
    public static Boolean b(String str) {
        return (str == null || str.length() == 0 || str.trim().length() == 0 || Constants.NULL.equals(str) || str.equals("")) ? Boolean.FALSE : Boolean.TRUE;
    }

    public static Boolean a(String str) {
        return (str == null || str.length() == 0 || str.trim().length() == 0 || Constants.NULL.equals(str)) ? Boolean.TRUE : Boolean.FALSE;
    }
}
