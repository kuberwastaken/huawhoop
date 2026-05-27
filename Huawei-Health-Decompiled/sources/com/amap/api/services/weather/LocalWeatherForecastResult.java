package com.amap.api.services.weather;

/* JADX INFO: loaded from: classes3.dex */
public class LocalWeatherForecastResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeatherSearchQuery f1584a;
    private LocalWeatherForecast b;

    public static LocalWeatherForecastResult createPagedResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherForecast localWeatherForecast) {
        return new LocalWeatherForecastResult(weatherSearchQuery, localWeatherForecast);
    }

    private LocalWeatherForecastResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherForecast localWeatherForecast) {
        this.f1584a = weatherSearchQuery;
        this.b = localWeatherForecast;
    }

    public WeatherSearchQuery getWeatherForecastQuery() {
        return this.f1584a;
    }

    public LocalWeatherForecast getForecastResult() {
        return this.b;
    }
}
