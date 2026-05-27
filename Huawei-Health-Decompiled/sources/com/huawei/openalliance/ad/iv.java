package com.huawei.openalliance.ad;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class iv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, String> f7338a = new HashMap();

    public void a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.f7338a.put(b(str), str2);
    }

    public String a(String str) {
        if (str != null) {
            return this.f7338a.get(b(str));
        }
        return null;
    }

    public Iterable<? extends String> a() {
        return this.f7338a.keySet();
    }

    private String b(String str) {
        return str.toLowerCase(Locale.ENGLISH);
    }
}
