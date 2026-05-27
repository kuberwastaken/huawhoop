package com.huawei.ads.fund.util;

import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ListUtil {
    public static <T> boolean isEmpty(T[] tArr) {
        return tArr == null || tArr.length == 0;
    }

    public static boolean isEmpty(int[] iArr) {
        return iArr == null || iArr.length == 0;
    }

    public static <T> boolean isEmpty(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }
}
