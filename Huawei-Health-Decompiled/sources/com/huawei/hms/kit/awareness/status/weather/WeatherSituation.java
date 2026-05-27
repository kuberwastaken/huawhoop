package com.huawei.hms.kit.awareness.status.weather;

/* JADX INFO: loaded from: classes10.dex */
public class WeatherSituation {
    private final City city;
    private final Situation situation;

    public Situation getSituation() {
        return this.situation;
    }

    public City getCity() {
        return this.city;
    }

    public WeatherSituation(City city, Situation situation) {
        this.city = city;
        this.situation = situation;
    }
}
