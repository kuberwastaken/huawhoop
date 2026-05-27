package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class gao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f13366a;
    private String b;
    private int c;
    private List<Integer> d;
    private double e;
    private List<gam> f;
    private gam g;
    private gan h;
    private double i;
    private String j;

    public String a() {
        return this.f13366a;
    }

    public void b(String str) {
        this.f13366a = str;
    }

    public void d(String str) {
        this.j = str;
    }

    public void b(gan ganVar) {
        this.h = ganVar;
    }

    public List<gam> d() {
        return this.f;
    }

    public void b(List<gam> list) {
        this.f = list;
    }

    public void e(double d) {
        this.i = d;
    }

    public void d(gam gamVar) {
        this.g = gamVar;
    }

    public void e(List<Integer> list) {
        this.d = list;
    }

    public double b() {
        return this.e;
    }

    public void b(double d) {
        this.e = d;
    }

    public int e() {
        return this.c;
    }

    public void d(int i) {
        this.c = i;
    }

    public void c(String str) {
        this.b = str;
    }

    public String toString() {
        return "MotionPathInfo{geoHash='" + this.f13366a + "', pathId='" + this.j + "', pathRange=" + this.h + ", pathPoints=" + this.f + ", totalDistance=" + this.i + ", pathLocation=" + this.g + ", heat=" + this.d + ", confidence=" + this.e + ", flag=" + this.c + ", executionTime='" + this.b + "'}";
    }
}
