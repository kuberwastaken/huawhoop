package com.huawei.watchface;

import com.huawei.watchface.utils.analytice.data.BaseEvent;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes8.dex */
public class er extends BaseEvent<er> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinkedHashMap<String, String> f11521a;

    public er(LinkedHashMap<String, String> linkedHashMap) {
        this.f11521a = linkedHashMap;
    }

    @Override // com.huawei.watchface.fa
    public LinkedHashMap<String, String> b() {
        return this.f11521a;
    }

    public static void a(LinkedHashMap<String, String> linkedHashMap) {
        new er(linkedHashMap).b_();
    }

    @Override // com.huawei.watchface.fa
    public String a() {
        return "WATCHFACE_CRASH";
    }
}
