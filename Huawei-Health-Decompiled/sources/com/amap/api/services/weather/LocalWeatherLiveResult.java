package com.amap.api.services.weather;

/* JADX INFO: loaded from: classes3.dex */
public class LocalWeatherLiveResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeatherSearchQuery f1586a;
    private LocalWeatherLive b;

    public static LocalWeatherLiveResult createPagedResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherLive localWeatherLive) {
        return new LocalWeatherLiveResult(weatherSearchQuery, localWeatherLive);
    }

    private LocalWeatherLiveResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherLive localWeatherLive) {
        this.f1586a = weatherSearchQuery;
        this.b = localWeatherLive;
    }

    public WeatherSearchQuery getWeatherLiveQuery() {
        return this.f1586a;
    }

    public LocalWeatherLive getLiveResult() {
        return this.b;
    }
}
