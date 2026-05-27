package com.huawei.hms.hwid;

import java.util.Collection;

/* JADX INFO: loaded from: classes5.dex */
public class ap {
    public static Boolean a(Collection collection) {
        if (collection == null || collection.size() == 0) {
            return true;
        }
        return false;
    }

    public static Boolean b(Collection collection) {
        return Boolean.valueOf(!a(collection).booleanValue());
    }
}
