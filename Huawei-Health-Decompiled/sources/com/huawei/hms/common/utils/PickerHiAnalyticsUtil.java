package com.huawei.hms.common.utils;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class PickerHiAnalyticsUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<Integer> f4662a;

    static {
        HashSet hashSet = new HashSet();
        f4662a = hashSet;
        hashSet.add(0);
    }

    public static int getHiAnalyticsStatus(int i) {
        return f4662a.contains(Integer.valueOf(i)) ? 0 : 1;
    }
}
