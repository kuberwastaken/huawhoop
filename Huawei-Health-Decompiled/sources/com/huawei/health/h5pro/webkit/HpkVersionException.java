package com.huawei.health.h5pro.webkit;

import com.huawei.operation.utils.Constants;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public final class HpkVersionException extends RuntimeException {
    public static final long serialVersionUID = -7980777896702070496L;

    /* JADX WARN: Illegal instructions before constructor call */
    public HpkVersionException(String str) {
        Locale locale = Locale.ENGLISH;
        Object[] objArr = new Object[1];
        objArr[0] = str == null ? Constants.NULL : str;
        super(String.format(locale, "Invalid version number %s.", objArr));
    }
}
