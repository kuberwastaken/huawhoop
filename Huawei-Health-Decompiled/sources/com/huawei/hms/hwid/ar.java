package com.huawei.hms.hwid;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class ar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<Integer> f4830a;

    static {
        HashSet hashSet = new HashSet();
        f4830a = hashSet;
        hashSet.add(0);
    }

    public static int a(int i) {
        return f4830a.contains(Integer.valueOf(i)) ? 0 : 1;
    }
}
