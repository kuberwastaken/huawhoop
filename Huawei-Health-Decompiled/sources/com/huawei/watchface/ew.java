package com.huawei.watchface;

import com.huawei.watchface.utils.analytice.data.BaseEvent;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes8.dex */
public class ew extends BaseEvent<ew> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinkedHashMap<String, String> f11526a;
    private String h;

    @Override // com.huawei.watchface.fa
    public LinkedHashMap<String, String> b() {
        return e();
    }

    private LinkedHashMap<String, String> e() {
        if (this.f11526a == null) {
            this.f11526a = new LinkedHashMap<>();
        }
        this.f11526a.put("startts", String.valueOf(m()));
        this.f11526a.put("endts", String.valueOf(n()));
        this.f11526a.put("totalTime", String.valueOf(o()));
        this.f11526a.put("url", ap.b(d()));
        return this.f11526a;
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

    @Override // com.huawei.watchface.fa
    public String a() {
        return "WATCHFACE_PAGE_START";
    }
}
