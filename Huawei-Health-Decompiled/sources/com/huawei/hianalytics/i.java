package com.huawei.hianalytics;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static i f4017a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Map<String, e1> f40a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public l f41a = new l();

    public static i a() {
        if (f4017a == null) {
            synchronized (i.class) {
                if (f4017a == null) {
                    f4017a = new i();
                }
            }
        }
        return f4017a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public l m820a() {
        if (this.f41a == null) {
            this.f41a = new l();
        }
        return this.f41a;
    }

    public e1 a(String str) {
        return f40a.get(str);
    }
}
