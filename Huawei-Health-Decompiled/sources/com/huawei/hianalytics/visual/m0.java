package com.huawei.hianalytics.visual;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes5.dex */
public class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, ExecutorService> f4080a = new HashMap();

    public static ExecutorService a() {
        ExecutorService executorServiceNewSingleThreadExecutor;
        Map<String, ExecutorService> map = f4080a;
        if (map.containsKey("HA-VISUAL")) {
            return map.get("HA-VISUAL");
        }
        synchronized (map) {
            if (map.containsKey("HA-VISUAL")) {
                executorServiceNewSingleThreadExecutor = map.get("HA-VISUAL");
            } else {
                executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new l0("HA-VISUAL"));
                map.put("HA-VISUAL", executorServiceNewSingleThreadExecutor);
            }
        }
        return executorServiceNewSingleThreadExecutor;
    }
}
