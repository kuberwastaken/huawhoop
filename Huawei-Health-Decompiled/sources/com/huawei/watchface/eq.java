package com.huawei.watchface;

import com.huawei.watchface.utils.analytice.data.BaseEvent;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes8.dex */
public class eq extends BaseEvent<eq> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11520a;
    private LinkedHashMap<String, String> h;

    public eq(String str, LinkedHashMap<String, String> linkedHashMap) {
        this.f11520a = str;
        this.h = linkedHashMap;
    }

    @Override // com.huawei.watchface.fa
    public String a() {
        return this.f11520a;
    }

    @Override // com.huawei.watchface.fa
    public LinkedHashMap<String, String> b() {
        return this.h;
    }
}
