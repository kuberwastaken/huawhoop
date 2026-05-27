package com.amap.api.services.nearby;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class NearbySearchResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<NearbyInfo> f1474a = new ArrayList();
    private int b = 0;

    public List<NearbyInfo> getNearbyInfoList() {
        return this.f1474a;
    }

    public int getTotalNum() {
        return this.b;
    }

    public void setNearbyInfoList(List<NearbyInfo> list) {
        this.f1474a = list;
        this.b = list.size();
    }
}
