package defpackage;

import android.os.Bundle;

/* JADX INFO: loaded from: classes6.dex */
public class mbd {
    private boolean i = false;
    private boolean k = false;
    private boolean b = false;
    private boolean j = false;
    private boolean c = false;
    private boolean g = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f15585a = false;
    private boolean e = false;
    private boolean f = false;
    private boolean h = false;
    private boolean d = false;
    private boolean n = false;
    private boolean o = false;

    public boolean m() {
        return this.n;
    }

    public void e(boolean z) {
        this.n = ((Boolean) kqt.e(Boolean.valueOf(z))).booleanValue();
    }

    public boolean d() {
        return this.d;
    }

    public void c(boolean z) {
        this.d = ((Boolean) kqt.e(Boolean.valueOf(z))).booleanValue();
    }

    public boolean f() {
        return this.h;
    }

    public boolean j() {
        return this.g;
    }

    public boolean b() {
        return this.e;
    }

    public boolean h() {
        return this.f;
    }

    public boolean l() {
        return ((Boolean) kqt.e(Boolean.valueOf(this.i))).booleanValue();
    }

    public boolean k() {
        return ((Boolean) kqt.e(Boolean.valueOf(this.k))).booleanValue();
    }

    public boolean i() {
        return this.b;
    }

    public boolean g() {
        return ((Boolean) kqt.e(Boolean.valueOf(this.j))).booleanValue();
    }

    public boolean c() {
        return ((Boolean) kqt.e(Boolean.valueOf(this.f15585a))).booleanValue();
    }

    public boolean a() {
        return ((Boolean) kqt.e(Boolean.valueOf(this.c))).booleanValue();
    }

    public boolean e() {
        return this.o;
    }

    public void a(boolean z) {
        this.o = z;
    }

    public void bVx_(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.i = ((Boolean) kqt.e(Boolean.valueOf(bundle.getBoolean("weather_support", false)))).booleanValue();
        this.k = ((Boolean) kqt.e(Boolean.valueOf(bundle.getBoolean("wind_support", false)))).booleanValue();
        this.b = ((Boolean) kqt.e(Boolean.valueOf(bundle.getBoolean("pm2_5_support", false)))).booleanValue();
        this.j = ((Boolean) kqt.e((Boolean) kqt.e(Boolean.valueOf(bundle.getBoolean("temperature_support", false))))).booleanValue();
        this.f15585a = ((Boolean) kqt.e(Boolean.valueOf(bundle.getBoolean("location_name_support", false)))).booleanValue();
        this.c = ((Boolean) kqt.e(Boolean.valueOf(bundle.getBoolean("temperature_current_support", false)))).booleanValue();
        this.g = ((Boolean) kqt.e(Boolean.valueOf(bundle.getBoolean("unit_support", false)))).booleanValue();
        this.e = ((Boolean) kqt.e(Boolean.valueOf(bundle.getBoolean("aqi_support", false)))).booleanValue();
        this.f = ((Boolean) kqt.e(Boolean.valueOf(bundle.getBoolean("time_support", false)))).booleanValue();
        this.h = ((Boolean) kqt.e(Boolean.valueOf(bundle.getBoolean("source_support", false)))).booleanValue();
        this.d = ((Boolean) kqt.e(Boolean.valueOf(bundle.getBoolean("cn_weather_icon_support", false)))).booleanValue();
        this.n = ((Boolean) kqt.e(Boolean.valueOf(bundle.getBoolean("weather_icon_expand_support", false)))).booleanValue();
    }
}
