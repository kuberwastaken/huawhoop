package defpackage;

import com.huawei.health.trackprocess.model.GpsPoint;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class hrd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f13939a;
    private List<Integer> b;
    private String c;
    private int d;
    private double e;
    private hrb f;
    private double g;
    private String h;
    private List<GpsPoint> i;
    private GpsPoint j;

    public String e() {
        return this.c;
    }

    public String f() {
        return this.h;
    }

    public hrb h() {
        return this.f;
    }

    public List<GpsPoint> j() {
        return this.i;
    }

    public double g() {
        return this.g;
    }

    public GpsPoint i() {
        return this.j;
    }

    public List<Integer> c() {
        return this.b;
    }

    public double a() {
        return this.e;
    }

    public int d() {
        return this.d;
    }

    public String b() {
        return this.f13939a;
    }

    public String toString() {
        return "MotionPathInfo{geoHash='" + this.c + "', pathId='" + this.h + "', pathRange=" + this.f + ", pathPoints=" + this.i + ", totalDistance=" + this.g + ", pathLocation=" + this.j + ", heat=" + this.b + ", confidence=" + this.e + ", flag=" + this.d + ", executionTime='" + this.f13939a + "'}";
    }
}
