package com.huawei.watchface;

import com.huawei.watchface.utils.analytice.data.BaseEvent;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes8.dex */
public class et extends BaseEvent<et> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinkedHashMap<String, String> f11523a;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;

    @Override // com.huawei.watchface.fa
    public LinkedHashMap<String, String> b() {
        return j();
    }

    private LinkedHashMap<String, String> j() {
        if (this.f11523a == null) {
            this.f11523a = new LinkedHashMap<>();
        }
        this.f11523a.put("startts", String.valueOf(m()));
        this.f11523a.put("endts", String.valueOf(n()));
        this.f11523a.put("totalTime", String.valueOf(o()));
        this.f11523a.put("errorCode", p());
        this.f11523a.put(BaseEvent.KEY_DESCINFO, d());
        this.f11523a.put("protocal", e());
        this.f11523a.put("url", f());
        this.f11523a.put("pagePosition", h());
        this.f11523a.put("pageName", i());
        return this.f11523a;
    }

    @Override // com.huawei.watchface.utils.analytice.data.BaseEvent
    public void b_() {
        super.b_();
    }

    public String d() {
        return this.h;
    }

    public void a(String str) {
        this.h = str;
    }

    public String e() {
        return this.i;
    }

    public void b(String str) {
        this.i = str;
    }

    public String f() {
        return this.j;
    }

    public void c(String str) {
        this.j = str;
    }

    public String g() {
        return this.k;
    }

    public void d(String str) {
        this.k = str;
    }

    public String h() {
        return this.l;
    }

    public String i() {
        return this.m;
    }

    public void a(int i, String str) {
        a(str);
        d(String.valueOf(i));
    }

    @Override // com.huawei.watchface.fa
    public String a() {
        return "WATCHFACE_LOAD_H5";
    }
}
