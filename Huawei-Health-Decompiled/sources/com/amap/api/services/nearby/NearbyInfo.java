package com.amap.api.services.nearby;

import com.amap.api.services.core.LatLonPoint;

/* JADX INFO: loaded from: classes9.dex */
public class NearbyInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1469a;
    private LatLonPoint b;
    private long c;
    private int d;
    private int e;

    public void setUserID(String str) {
        this.f1469a = str;
    }

    public String getUserID() {
        return this.f1469a;
    }

    public LatLonPoint getPoint() {
        return this.b;
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.b = latLonPoint;
    }

    public void setTimeStamp(long j) {
        this.c = j;
    }

    public long getTimeStamp() {
        return this.c;
    }

    public void setDistance(int i) {
        this.d = i;
    }

    public int getDistance() {
        return this.d;
    }

    public void setDrivingDistance(int i) {
        this.e = i;
    }

    public int getDrivingDistance() {
        return this.e;
    }
}
