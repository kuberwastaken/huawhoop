package com.amap.api.services.routepoisearch;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class RoutePOISearchResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<RoutePOIItem> f1575a;
    private RoutePOISearchQuery b;

    public RoutePOISearchResult(ArrayList<RoutePOIItem> arrayList, RoutePOISearchQuery routePOISearchQuery) {
        new ArrayList();
        this.f1575a = arrayList;
        this.b = routePOISearchQuery;
    }

    public List<RoutePOIItem> getRoutePois() {
        return this.f1575a;
    }

    public RoutePOISearchQuery getQuery() {
        return this.b;
    }
}
