package com.amap.api.services.weather;

import com.amap.api.col.p0003sl.fu;

/* JADX INFO: loaded from: classes9.dex */
public class WeatherSearchQuery implements Cloneable {
    public static final int WEATHER_TYPE_FORECAST = 2;
    public static final int WEATHER_TYPE_LIVE = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1588a;
    private int b;

    public WeatherSearchQuery(String str, int i) {
        this.f1588a = str;
        this.b = i;
    }

    public WeatherSearchQuery() {
        this.b = 1;
    }

    public String getCity() {
        return this.f1588a;
    }

    public int getType() {
        return this.b;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public WeatherSearchQuery m340clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            fu.a(e, "WeatherSearchQuery", "clone");
        }
        return new WeatherSearchQuery(this.f1588a, this.b);
    }
}
