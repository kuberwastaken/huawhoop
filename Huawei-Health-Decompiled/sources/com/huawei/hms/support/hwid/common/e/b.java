package com.huawei.hms.support.hwid.common.e;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<Integer> f6188a;

    static {
        HashSet hashSet = new HashSet();
        f6188a = hashSet;
        hashSet.add(0);
    }

    public static int a(int i) {
        return f6188a.contains(Integer.valueOf(i)) ? 0 : 1;
    }
}
