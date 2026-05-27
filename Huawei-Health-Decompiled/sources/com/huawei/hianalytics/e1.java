package com.huawei.hianalytics;

import com.huawei.hianalytics.core.log.HiLog;

/* JADX INFO: loaded from: classes5.dex */
public class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a1 f3992a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f32a;
    public a1 b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f33b;
    public String c;
    public String d;
    public String e;

    public a1 a(String str) {
        if ("oper".equals(str)) {
            return this.b;
        }
        if ("maint".equals(str)) {
            return this.f3992a;
        }
        HiLog.sw("HAID", "wrong type");
        return null;
    }
}
