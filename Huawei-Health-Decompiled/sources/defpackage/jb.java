package defpackage;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class jb {
    private static final PointF d = new PointF();

    public static float a(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int a(int i, int i2, float f) {
        return (int) (i + (f * (i2 - i)));
    }

    public static boolean e(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    public static PointF aF_(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void aG_(go goVar, Path path) {
        path.reset();
        PointF pointFAk_ = goVar.ak_();
        path.moveTo(pointFAk_.x, pointFAk_.y);
        d.set(pointFAk_.x, pointFAk_.y);
        for (int i = 0; i < goVar.c().size(); i++) {
            fp fpVar = goVar.c().get(i);
            PointF pointFAd_ = fpVar.ad_();
            PointF pointFAe_ = fpVar.ae_();
            PointF pointFAf_ = fpVar.af_();
            PointF pointF = d;
            if (pointFAd_.equals(pointF) && pointFAe_.equals(pointFAf_)) {
                path.lineTo(pointFAf_.x, pointFAf_.y);
            } else {
                path.cubicTo(pointFAd_.x, pointFAd_.y, pointFAe_.x, pointFAe_.y, pointFAf_.x, pointFAf_.y);
            }
            pointF.set(pointFAf_.x, pointFAf_.y);
        }
        if (goVar.d()) {
            path.close();
        }
    }

    static int a(float f, float f2) {
        return c((int) f, (int) f2);
    }

    private static int c(int i, int i2) {
        return i - (i2 * d(i, i2));
    }

    private static int d(int i, int i2) {
        int i3 = i / i2;
        return ((i ^ i2) < 0 && i % i2 != 0) ? i3 - 1 : i3;
    }

    public static int c(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static float c(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static void d(fs fsVar, int i, List<fs> list, fs fsVar2, KeyPathElementContent keyPathElementContent) {
        if (fsVar.b(keyPathElementContent.getName(), i)) {
            list.add(fsVar2.b(keyPathElementContent.getName()).d(keyPathElementContent));
        }
    }
}
