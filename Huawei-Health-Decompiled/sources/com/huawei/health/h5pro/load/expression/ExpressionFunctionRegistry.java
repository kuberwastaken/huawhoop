package com.huawei.health.h5pro.load.expression;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ExpressionFunctionRegistry {
    public static final Map<String, Object> b;

    public static void register(String str, Object obj) {
        b.put(str, obj);
    }

    public static Object get(String str) {
        return b.get(str);
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        b = concurrentHashMap;
        concurrentHashMap.put("TimeFunctions", new TimeFunctions());
        concurrentHashMap.put("RouteFunctions", new RouteFunctions());
    }
}
