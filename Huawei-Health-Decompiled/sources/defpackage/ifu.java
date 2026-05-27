package defpackage;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class ifu implements Serializable {
    private static final long serialVersionUID = -4674592258281735115L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14094a;
    private long b;
    private float c;
    private long d;
    private float e;

    public float b() {
        long minutes = TimeUnit.MILLISECONDS.toMinutes(this.b - this.d);
        if (minutes == 0) {
            return 0.0f;
        }
        return this.c / minutes;
    }

    public long c() {
        return this.d;
    }

    public void a(long j) {
        this.d = j;
    }

    public long e() {
        return this.b;
    }

    public void e(long j) {
        this.b = j;
    }

    public float d() {
        return this.c;
    }

    public void b(float f) {
        this.c = f;
    }

    public float a() {
        return this.e;
    }

    public void d(float f) {
        this.e = f;
    }

    public int g() {
        return this.f14094a;
    }

    public void a(int i) {
        this.f14094a = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(16);
        sb.append(this.d);
        sb.append("#");
        sb.append(this.b);
        sb.append("#");
        sb.append(this.c);
        sb.append("#");
        sb.append(this.e);
        sb.append("#");
        sb.append(this.f14094a);
        return sb.toString();
    }
}
