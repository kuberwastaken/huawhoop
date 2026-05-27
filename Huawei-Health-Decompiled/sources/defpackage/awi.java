package defpackage;

import android.graphics.Color;
import java.util.Locale;

/* JADX INFO: loaded from: classes10.dex */
public class awi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f365a;
    private final float[] b;
    private int c;

    public awi(int i, int i2) {
        float[] fArr = new float[3];
        this.b = fArr;
        this.f365a = i;
        Color.colorToHSV(i, fArr);
        this.c = i2;
    }

    public awi(float f, float f2, float f3, int i) {
        float[] fArr = {f, f2, f3};
        this.b = fArr;
        this.f365a = Color.HSVToColor(fArr);
        this.c = i;
    }

    public int a() {
        return this.f365a;
    }

    public int e() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }

    public float d() {
        return this.b[0];
    }

    public float b() {
        return this.b[1];
    }

    public float c() {
        return this.b[2];
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "{rgb=#%06X, hsv=[%.2f, %.2f, %.2f], population=%d}", Integer.valueOf(16777215 & this.f365a), Float.valueOf(this.b[0]), Float.valueOf(this.b[1]), Float.valueOf(this.b[2]), Integer.valueOf(this.c));
    }
}
