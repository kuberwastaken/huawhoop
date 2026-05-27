package com.amap.api.services.help;

import com.amap.api.services.core.LatLonPoint;

/* JADX INFO: loaded from: classes9.dex */
public class InputtipsQuery implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1467a;
    private String b;
    private boolean c = false;
    private String d = null;
    private LatLonPoint e;

    public InputtipsQuery(String str, String str2) {
        this.f1467a = str;
        this.b = str2;
    }

    public String getKeyword() {
        return this.f1467a;
    }

    public String getCity() {
        return this.b;
    }

    public void setType(String str) {
        this.d = str;
    }

    public String getType() {
        return this.d;
    }

    public void setCityLimit(boolean z) {
        this.c = z;
    }

    public boolean getCityLimit() {
        return this.c;
    }

    public void setLocation(LatLonPoint latLonPoint) {
        this.e = latLonPoint;
    }

    public LatLonPoint getLocation() {
        return this.e;
    }
}
