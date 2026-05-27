package com.huawei.hms.common.utils;

import java.util.Collection;

/* JADX INFO: loaded from: classes5.dex */
public class PickerCollectionUtil {
    public static Boolean isNotEmpty(Collection collection) {
        return Boolean.valueOf((collection == null || collection.size() == 0) ? false : true);
    }
}
