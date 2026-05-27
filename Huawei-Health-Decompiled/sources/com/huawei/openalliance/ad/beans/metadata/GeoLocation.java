package com.huawei.openalliance.ad.beans.metadata;

/* JADX INFO: loaded from: classes6.dex */
public class GeoLocation {
    private Address address;
    private int clctSource;
    private Long clctTime;
    private Integer lastfix;
    private Double lat;
    private Double lon;

    public void b(Double d) {
        this.lat = d;
    }

    public void a(Long l) {
        this.clctTime = l;
    }

    public void a(Double d) {
        this.lon = d;
    }

    public void a(Address address) {
        this.address = address;
    }

    public void a(int i) {
        this.clctSource = i;
    }
}
