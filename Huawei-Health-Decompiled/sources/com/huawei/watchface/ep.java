package com.huawei.watchface;

import com.huawei.watchface.utils.analytice.data.BaseEvent;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes8.dex */
public class ep extends BaseEvent<ep> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinkedHashMap<String, String> f11519a;

    public ep(LinkedHashMap<String, String> linkedHashMap) {
        this.f11519a = linkedHashMap;
    }

    @Override // com.huawei.watchface.fa
    public LinkedHashMap<String, String> b() {
        return this.f11519a;
    }

    public static void a(LinkedHashMap<String, String> linkedHashMap) {
        new ep(linkedHashMap).b_();
    }

    @Override // com.huawei.watchface.fa
    public String a() {
        return "WATCHFACE_ANR";
    }
}
