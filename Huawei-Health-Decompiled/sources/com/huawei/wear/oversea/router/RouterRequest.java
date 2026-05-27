package com.huawei.wear.oversea.router;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class RouterRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Object> f11735a;
    private Map<String, String> b;
    private Context e;
    private String c = null;
    private String i = null;
    private String d = null;

    public RouterRequest(Context context) {
        this.f11735a = null;
        this.b = null;
        this.e = context;
        this.f11735a = new HashMap();
        this.b = new HashMap();
    }

    public Context a() {
        return this.e;
    }

    public String e() {
        return this.d;
    }

    public RouterRequest e(String str) {
        this.d = str;
        return this;
    }

    public Map<String, Object> c() {
        return this.f11735a;
    }

    public String d() {
        return this.c + "_" + this.i;
    }

    public RouterRequest c(String str) {
        this.c = str;
        return this;
    }

    public RouterRequest a(String str) {
        this.i = str;
        return this;
    }

    public String b() {
        return d() + ":" + e();
    }
}
