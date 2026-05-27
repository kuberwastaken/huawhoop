package defpackage;

import com.huawei.hwcloudmodel.hwwear.hag.model.tide.HagTideDataBean;
import com.huawei.hwcloudmodel.model.push.AlertWeather;
import com.huawei.hwcloudmodel.model.push.WeatherForecastDay;
import com.huawei.hwcloudmodel.model.push.WeatherForecastGlow;
import com.huawei.hwcloudmodel.model.push.WeatherForecastHour;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class koq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<AlertWeather> f14799a;
    private int b;
    private int c;
    private int d;
    private int e;
    private String f;
    private Map<String, Object> g;
    private HagTideDataBean h;
    private String i;
    private int j;
    private int k;
    private int l;
    private int m;
    private String n;
    private int o;
    private int p;
    private long q;
    private int r;
    private int s;
    private List<WeatherForecastDay> t;
    private List<WeatherForecastHour> u;
    private int v;
    private int w;
    private List<WeatherForecastGlow> x;
    private int y;

    public int c() {
        return this.d;
    }

    public void l(int i) {
        this.d = i;
    }

    public HagTideDataBean b() {
        return this.h;
    }

    public void b(HagTideDataBean hagTideDataBean) {
        this.h = hagTideDataBean;
    }

    public Map<String, Object> e() {
        return this.g;
    }

    public void e(Map<String, Object> map) {
        this.g = map;
    }

    public int d() {
        return this.b;
    }

    public void j(int i) {
        this.b = i;
    }

    public int g() {
        return this.p;
    }

    public void n(int i) {
        this.p = i;
    }

    public String h() {
        return this.n;
    }

    public List<WeatherForecastDay> i() {
        return this.t;
    }

    public void c(List<WeatherForecastDay> list) {
        this.t = list;
    }

    public List<WeatherForecastHour> m() {
        return this.u;
    }

    public void d(List<WeatherForecastHour> list) {
        this.u = list;
    }

    public List<WeatherForecastGlow> o() {
        return this.x;
    }

    public void b(List<WeatherForecastGlow> list) {
        this.x = list;
    }

    public int w() {
        return this.s;
    }

    public int n() {
        return this.e;
    }

    public void e(int i) {
        this.e = i;
    }

    public int r() {
        return this.k;
    }

    public void d(int i) {
        this.k = i;
    }

    public long x() {
        return this.q;
    }

    public void d(long j) {
        this.q = j;
    }

    public String t() {
        return this.f;
    }

    public int l() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
    }

    public int s() {
        return this.o;
    }

    public void i(int i) {
        this.o = i;
    }

    public int p() {
        return this.m;
    }

    public void a(int i) {
        this.m = i;
    }

    public int q() {
        return this.j;
    }

    public void c(int i) {
        this.j = i;
    }

    public int y() {
        return this.r;
    }

    public void g(int i) {
        this.r = i;
    }

    public int v() {
        return this.y;
    }

    public void f(int i) {
        this.y = i;
    }

    public void h(int i) {
        this.w = i;
    }

    public int u() {
        return this.w;
    }

    public void e(String str) {
        this.f = str;
    }

    public String j() {
        return this.i;
    }

    public void d(String str) {
        this.i = str;
    }

    public int k() {
        return this.v;
    }

    public void k(int i) {
        this.v = i;
    }

    public int f() {
        return this.l;
    }

    public void o(int i) {
        this.l = i;
    }

    public List<AlertWeather> a() {
        return this.f14799a;
    }

    public void a(List<AlertWeather> list) {
        this.f14799a = list;
    }

    public String toString() {
        return "DataWeather{weather=" + this.r + ", pm25=" + this.o + ", lowestTemperature=" + this.m + ", highestTemperature=" + this.j + ", currentTemperature=" + this.c + ", locationName='" + this.f + "', temperatureUnit=" + this.s + ", aqi=" + this.e + ", observationTime=" + this.k + ", updateTime=" + this.q + ", windDirection=" + this.y + ", windSpeed=" + this.w + ", source='" + this.n + "', weatherForecastDays=" + this.t + ", weatherForecastHours=" + this.u + ", weatherForecastGlows=" + this.x + ", cnWeatherId=" + this.b + ", uVIndex=" + this.p + ", hagTideDataBean=" + this.h + ", hagReportBiMap=" + this.g + ", errorType=" + this.d + ", humidity='" + this.i + "', windSpeedValue=" + this.v + ", somatosensoryTemperature=" + this.l + ", alertWeathers=" + this.f14799a + '}';
    }
}
