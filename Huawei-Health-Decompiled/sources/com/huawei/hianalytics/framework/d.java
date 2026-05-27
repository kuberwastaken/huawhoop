package com.huawei.hianalytics.framework;

import com.huawei.hianalytics.framework.config.ICollectorConfig;
import com.huawei.hianalytics.framework.config.IMandatoryParameters;
import com.huawei.hianalytics.framework.policy.IStoragePolicy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public class d {
    public static final d e = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IMandatoryParameters f3998a;
    public final Map<String, ICollectorConfig> b = new ConcurrentHashMap();
    public final Map<String, e> c = new ConcurrentHashMap();
    public final Map<String, IStoragePolicy> d = new ConcurrentHashMap();

    public IMandatoryParameters b() {
        return this.f3998a;
    }

    public ICollectorConfig a(String str) {
        return this.b.get(str);
    }

    public static d a() {
        return e;
    }
}
