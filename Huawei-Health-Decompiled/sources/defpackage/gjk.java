package defpackage;

import android.graphics.PointF;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes4.dex */
public class gjk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f13492a;
    private float b;
    private int c;
    private float d;
    private float e;
    private String f;
    private PointF g;
    private String h;
    private float i;
    private float j;
    private String n;

    public gjk(float f, String str) {
        this(f, "", str);
    }

    private gjk(float f, String str, String str2) {
        this(0.0f, f, str, str2, -7829368);
    }

    private gjk(float f, float f2, String str, String str2, int i) {
        PointF pointF = new PointF();
        this.g = pointF;
        this.i = f2;
        this.d = f;
        float f3 = f2 - f;
        this.f13492a = f3;
        this.e = f3;
        this.n = str2;
        pointF.y = f;
        this.f = str;
        this.c = i;
        this.h = new DecimalFormat("##").format(this.e);
    }

    public PointF azP_() {
        return new PointF(f(), this.g.y - this.e);
    }

    public void d(float f) {
        this.j = f;
    }

    public float d() {
        return this.e;
    }

    public void b(float f) {
        this.e = f;
    }

    public PointF azQ_() {
        return this.g;
    }

    private float f() {
        PointF pointF = this.g;
        if (pointF != null) {
            float f = pointF.x + (this.j / 2.0f);
            this.b = f;
            return f;
        }
        return this.j / 2.0f;
    }

    public int a() {
        return this.c;
    }

    public float c() {
        return this.d;
    }

    public String b() {
        return this.h;
    }

    public void b(String str) {
        this.h = str;
    }

    public String toString() {
        return "height: " + this.e;
    }
}
