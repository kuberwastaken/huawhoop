package defpackage;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes7.dex */
public class pwu implements Interpolator {
    private final PointF b;
    private final PointF c;
    private int d = 0;

    private double e(double d, double d2, double d3, double d4, double d5) {
        double d6 = 1.0d - d;
        double d7 = d * d;
        double d8 = d6 * d6;
        return (d8 * d6 * d2) + (d8 * 3.0d * d * d3) + (d6 * 3.0d * d7 * d4) + (d7 * d * d5);
    }

    public pwu(float f, float f2, float f3, float f4) {
        PointF pointF = new PointF();
        this.b = pointF;
        PointF pointF2 = new PointF();
        this.c = pointF2;
        pointF.x = f;
        pointF.y = f2;
        pointF2.x = f3;
        pointF2.y = f4;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        int i = this.d;
        float f2 = f;
        while (true) {
            if (i >= 4096) {
                break;
            }
            f2 = (i * 1.0f) / 4096.0f;
            if (e(f2, 0.0d, this.b.x, this.c.x, 1.0d) >= f) {
                this.d = i;
                break;
            }
            i++;
        }
        double dE = e(f2, 0.0d, this.b.y, this.c.y, 1.0d);
        if (dE > 0.999d) {
            this.d = 0;
            dE = 1.0d;
        }
        return (float) dE;
    }
}
