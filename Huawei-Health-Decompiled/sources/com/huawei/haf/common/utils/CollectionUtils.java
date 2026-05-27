package com.huawei.haf.common.utils;

import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class CollectionUtils {
    private CollectionUtils() {
    }

    public static boolean b(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    public static boolean c(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean e(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean e(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean e(Collection<?> collection, int i) {
        return e(collection) || i < 0 || i >= collection.size();
    }
}
