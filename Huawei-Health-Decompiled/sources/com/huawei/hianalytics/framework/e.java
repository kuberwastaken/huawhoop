package com.huawei.hianalytics.framework;

import com.huawei.hianalytics.core.storage.IStorageHandler;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IStorageHandler f4001a;
    public final Map<String, Long> b = new ConcurrentHashMap();
    public final Map<String, Long> c = new ConcurrentHashMap();
    public final Map<String, Integer> d = new ConcurrentHashMap();
    public final Map<String, Integer> e = new ConcurrentHashMap();

    public void a(String str) {
        Integer num = this.d.get(str);
        int iIntValue = (num != null ? num.intValue() : 0) + 1;
        this.d.put(str, Integer.valueOf(iIntValue));
        this.c.put(str, Long.valueOf((iIntValue <= 0 || iIntValue > 4) ? 1800000L : ((long) iIntValue) * 300000));
    }

    public void b(String str) {
        Integer num = this.d.get(str);
        if (num == null || num.intValue() == 0) {
            return;
        }
        this.c.put(str, 30000L);
        this.d.put(str, 0);
    }
}
