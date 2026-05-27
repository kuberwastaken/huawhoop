package defpackage;

import android.graphics.Bitmap;
import android.util.Pair;

/* JADX INFO: loaded from: classes5.dex */
public class iue {
    private String c;
    private boolean f;
    private boolean h;
    private boolean i;
    private int k;
    private Bitmap g = null;
    private irt j = null;
    private Pair<Float, Float> e = new Pair<>(Float.valueOf(0.5f), Float.valueOf(1.0f));
    private float b = 90.0f;
    private float d = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f14295a = 0.0f;
    private double o = 1.0d;
    private boolean l = true;

    public iue() {
        this.f = false;
        this.k = 10;
        this.h = false;
        this.f = false;
        this.k = 10;
        this.h = false;
    }

    public Pair<Float, Float> bnH_() {
        return this.e;
    }

    public iue e(float f, float f2) {
        this.e = new Pair<>(Float.valueOf(f), Float.valueOf(f2));
        return this;
    }

    public iue bnJ_(Pair<Float, Float> pair) {
        if (pair == null) {
            return this;
        }
        this.e = new Pair<>((Float) pair.first, (Float) pair.second);
        return this;
    }

    public boolean j() {
        return this.f;
    }

    public Bitmap bnI_() {
        return this.g;
    }

    public iue bnK_(Bitmap bitmap) {
        this.g = bitmap;
        return this;
    }

    public irt a() {
        return this.j;
    }

    public iue a(irt irtVar) {
        this.j = irtVar;
        return this;
    }

    public int c() {
        return this.k;
    }

    public iue d(int i) {
        this.k = i;
        return this;
    }

    public boolean h() {
        return this.h;
    }

    public iue d(boolean z) {
        this.h = z;
        return this;
    }

    public iue b(boolean z) {
        this.i = z;
        return this;
    }

    public void a(String str) {
        this.c = str;
    }

    public String b() {
        return this.c;
    }

    public void b(double d) {
        this.o = d;
    }

    public boolean i() {
        return this.l;
    }

    public iue a(boolean z) {
        this.l = z;
        return this;
    }
}
