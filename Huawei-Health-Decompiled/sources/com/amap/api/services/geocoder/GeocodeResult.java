package com.amap.api.services.geocoder;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class GeocodeResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private GeocodeQuery f1459a;
    private List<GeocodeAddress> b;

    public GeocodeResult(GeocodeQuery geocodeQuery, List<GeocodeAddress> list) {
        new ArrayList();
        this.f1459a = geocodeQuery;
        this.b = list;
    }

    public GeocodeQuery getGeocodeQuery() {
        return this.f1459a;
    }

    public void setGeocodeQuery(GeocodeQuery geocodeQuery) {
        this.f1459a = geocodeQuery;
    }

    public List<GeocodeAddress> getGeocodeAddressList() {
        return this.b;
    }

    public void setGeocodeAddressList(List<GeocodeAddress> list) {
        this.b = list;
    }
}
