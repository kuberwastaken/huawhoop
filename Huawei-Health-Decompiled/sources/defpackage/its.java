package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class its {
    private int g;
    private List<iru> e = new ArrayList();
    private List<irt> f = new ArrayList();
    private List<irt> c = new ArrayList();
    private List<irt> d = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<irt> f14288a = new ArrayList();
    private List<iry> b = new ArrayList();

    public int j() {
        return this.g;
    }

    public void d(int i) {
        this.g = i;
    }

    public List<iru> e() {
        return this.e;
    }

    public void a(List<iru> list) {
        if (list == null) {
            this.e = new ArrayList();
        } else {
            this.e = list;
        }
    }

    public List<irt> a() {
        return this.f;
    }

    public void e(List<irt> list) {
        if (list == null) {
            this.f = new ArrayList();
        } else {
            this.f = list;
        }
    }

    public List<irt> d() {
        return this.c;
    }

    public void b(List<irt> list) {
        if (list == null) {
            this.c = new ArrayList();
        } else {
            this.c = list;
        }
    }

    public List<irt> b() {
        return this.d;
    }

    public void d(List<irt> list) {
        if (this.d == null) {
            this.d = new ArrayList();
        } else {
            this.d = list;
        }
    }

    public List<iry> c() {
        return this.b;
    }

    public void c(List<iry> list) {
        this.b = list;
    }

    public String toString() {
        return "sportType:" + j() + " lineList size:" + e().size() + " markerDrawBefore size:" + a().size() + " markerDrawAfter size:" + d().size() + " markerNormal size:" + b() + " mHealthMarkerList size:" + c().size();
    }
}
