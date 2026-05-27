package com.unicom.online.account.kernel;

import java.util.HashMap;

/* JADX INFO: loaded from: classes8.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f11948a;
    public long b;
    public long c;
    public long d;

    public final String toString() {
        return "{url':" + this.f11948a + "', startTime:" + this.b + ", endTime:" + this.c + '}';
    }

    public final void b() {
        this.f11948a = "";
        this.b = 0L;
        this.c = 0L;
        this.d = 0L;
    }

    public final HashMap<String, Object> a() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("url", this.f11948a);
        StringBuilder sb = new StringBuilder();
        sb.append(this.b);
        map.put("startTime", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.c);
        map.put("endTime", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(this.d);
        map.put("forcedTime", sb3.toString());
        return map;
    }
}
