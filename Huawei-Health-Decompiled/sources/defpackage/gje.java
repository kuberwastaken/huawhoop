package defpackage;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class gje {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Double> f13487a;
    private float b;
    private float c;
    private float d;
    private String e;
    private int f;
    private String g;
    private float h;
    private int i;
    private int j;
    private float n;

    public gje(String str, int i, float f) {
        this(str, i, f, 1, 1);
    }

    public gje(String str, int i, float f, int i2, int i3) {
        this.f = -1;
        this.n = -1.0f;
        this.b = 0.0f;
        this.h = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        this.f13487a = new HashMap();
        this.j = i2;
        this.g = str;
        this.f = i;
        this.n = f;
        this.i = i3;
    }

    public void d(float f) {
        this.h = f;
    }

    public void e(float f) {
        this.c = f;
        if (k()) {
            this.b = (this.c - this.h) / this.n;
        } else {
            this.b = 0.0f;
        }
    }

    public void a(float f) {
        this.c = f;
        if (k()) {
            this.b = Math.round((this.c - this.h) / 1000.0f) / (TimeUnit.MILLISECONDS.toSeconds((long) this.n) * 1.0f);
        } else {
            this.b = 0.0f;
        }
    }

    public void b(float f, int i) {
        this.c = f;
        if (i == 4) {
            if (f >= this.n) {
                this.b = 1.0f;
                return;
            } else {
                this.b = 0.0f;
                return;
            }
        }
        if (f <= this.n && f > 0.0f) {
            this.b = 1.0f;
        } else {
            this.b = 0.0f;
        }
    }

    public void b(float f) {
        if (k()) {
            this.d = this.n - f;
        }
    }

    private boolean k() {
        float f = this.h;
        return f >= 0.0f && this.c >= f && this.n > 0.0f;
    }

    public float a() {
        return this.d;
    }

    public float b() {
        return this.b;
    }

    public int j() {
        return this.f;
    }

    public float h() {
        return this.n;
    }

    public float d() {
        return this.h;
    }

    public String i() {
        return this.g;
    }

    public int c() {
        return this.j;
    }

    public float f() {
        return this.c;
    }

    public int g() {
        return this.i;
    }

    public void a(String str) {
        this.e = str;
    }

    public String e() {
        return this.e;
    }

    public Map<String, Double> l() {
        return this.f13487a;
    }

    public void a(Map<String, Double> map) {
        this.f13487a.putAll(map);
    }
}
