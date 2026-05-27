package com.huawei.hms.support.hwid.common;

import android.content.Context;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f6182a;
    private Map<String, List<String>> b = new HashMap();
    private Context c;

    private a() {
    }

    public static a a() {
        a aVar;
        synchronized (a.class) {
            if (f6182a == null) {
                f6182a = new a();
            }
            aVar = f6182a;
        }
        return aVar;
    }

    public void a(Context context) {
        this.c = context;
    }

    public Context b() {
        return this.c;
    }

    public List<String> c() {
        return this.b.get("packageNamesNotUseApk");
    }

    public void a(List<String> list) {
        this.b.put("packageNamesNotUseApk", list);
    }
}
