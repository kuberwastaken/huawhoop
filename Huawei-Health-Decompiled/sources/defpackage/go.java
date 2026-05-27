package defpackage;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class go {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PointF f13564a;
    private boolean c;
    private final List<fp> d;

    public go(PointF pointF, boolean z, List<fp> list) {
        this.f13564a = pointF;
        this.c = z;
        this.d = new ArrayList(list);
    }

    public go() {
        this.d = new ArrayList();
    }

    public void a(float f, float f2) {
        if (this.f13564a == null) {
            this.f13564a = new PointF();
        }
        this.f13564a.set(f, f2);
    }

    public PointF ak_() {
        return this.f13564a;
    }

    public void c(boolean z) {
        this.c = z;
    }

    public boolean d() {
        return this.c;
    }

    public List<fp> c() {
        return this.d;
    }

    public void e(go goVar, go goVar2, float f) {
        if (this.f13564a == null) {
            this.f13564a = new PointF();
        }
        this.c = goVar.d() || goVar2.d();
        if (goVar.c().size() != goVar2.c().size()) {
            iy.c("Curves must have the same number of control points. Shape 1: " + goVar.c().size() + "\tShape 2: " + goVar2.c().size());
        }
        int iMin = Math.min(goVar.c().size(), goVar2.c().size());
        if (this.d.size() < iMin) {
            for (int size = this.d.size(); size < iMin; size++) {
                this.d.add(new fp());
            }
        } else if (this.d.size() > iMin) {
            for (int size2 = this.d.size() - 1; size2 >= iMin; size2--) {
                List<fp> list = this.d;
                list.remove(list.size() - 1);
            }
        }
        PointF pointFAk_ = goVar.ak_();
        PointF pointFAk_2 = goVar2.ak_();
        a(jb.a(pointFAk_.x, pointFAk_2.x, f), jb.a(pointFAk_.y, pointFAk_2.y, f));
        for (int size3 = this.d.size() - 1; size3 >= 0; size3--) {
            fp fpVar = goVar.c().get(size3);
            fp fpVar2 = goVar2.c().get(size3);
            PointF pointFAd_ = fpVar.ad_();
            PointF pointFAe_ = fpVar.ae_();
            PointF pointFAf_ = fpVar.af_();
            PointF pointFAd_2 = fpVar2.ad_();
            PointF pointFAe_2 = fpVar2.ae_();
            PointF pointFAf_2 = fpVar2.af_();
            this.d.get(size3).a(jb.a(pointFAd_.x, pointFAd_2.x, f), jb.a(pointFAd_.y, pointFAd_2.y, f));
            this.d.get(size3).d(jb.a(pointFAe_.x, pointFAe_2.x, f), jb.a(pointFAe_.y, pointFAe_2.y, f));
            this.d.get(size3).e(jb.a(pointFAf_.x, pointFAf_2.x, f), jb.a(pointFAf_.y, pointFAf_2.y, f));
        }
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.d.size() + "closed=" + this.c + '}';
    }
}
