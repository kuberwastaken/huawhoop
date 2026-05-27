package defpackage;

import android.animation.TimeInterpolator;
import android.os.SystemClock;
import android.util.Pair;
import android.view.View;
import com.huawei.uikit.hwcommon.anim.HwCubicBezierInterpolator;

/* JADX INFO: loaded from: classes8.dex */
public class vns {
    private static boolean b = false;
    private static boolean d = false;
    private static long e;

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f18679a;
        private float b;
        private float c;
        private float d;
        private boolean e = true;
        private float h;

        public float a() {
            return this.f18679a;
        }

        public float b() {
            return this.h;
        }

        public float d() {
            return this.b;
        }

        public float e() {
            return this.c;
        }

        public void e(boolean z) {
            this.e = z;
        }

        public boolean g() {
            return this.e;
        }

        public void a(float f) {
            this.b = f;
        }

        public void b(float f) {
            this.c = f;
        }

        public float c() {
            return this.d;
        }

        public void d(float f) {
            this.h = f;
        }

        public void e(float f) {
            this.f18679a = f;
        }

        public void c(float f) {
            this.d = f;
        }
    }

    public static TimeInterpolator e() {
        return new HwCubicBezierInterpolator(0.37f, 0.16f, 0.57f, 0.88f);
    }

    public static Pair<Float, Float> eAB_(TimeInterpolator timeInterpolator, float f, int i, float f2, float f3) {
        return new Pair<>(Float.valueOf(f2 + ((0.225f - (Math.min(i, 10) * 0.0125f)) * Math.abs(f) * f2)), Float.valueOf((((1.0f - timeInterpolator.getInterpolation(f)) * 0.19999999f) + 0.8f) * f3));
    }

    public static TimeInterpolator eAC_() {
        return new HwCubicBezierInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    }

    public static TimeInterpolator eAD_() {
        return new HwCubicBezierInterpolator(1.0f, 0.0f, 1.0f, 1.0f);
    }

    public static TimeInterpolator eAE_() {
        return new HwCubicBezierInterpolator(0.1f, 0.2f, 0.48f, 1.0f);
    }

    public static TimeInterpolator eAF_() {
        return new HwCubicBezierInterpolator(0.7f, 0.12f, 0.78f, 0.27f);
    }

    public static TimeInterpolator eAG_() {
        return new HwCubicBezierInterpolator(0.37f, 0.16f, 0.0f, 1.03f);
    }

    public static TimeInterpolator eAH_() {
        return new HwCubicBezierInterpolator(0.2f, 0.05f, 0.45f, 1.13f);
    }

    public static TimeInterpolator eAI_() {
        return new HwCubicBezierInterpolator(0.65f, -0.04f, 0.57f, 2.0f);
    }

    public static TimeInterpolator g() {
        return new HwCubicBezierInterpolator(0.97f, 0.0f, 0.96f, 0.51f);
    }

    public static boolean l() {
        return d;
    }

    public static boolean m() {
        return b;
    }

    public static boolean d(c cVar, float f, boolean z, boolean z2, boolean z3) {
        float fC = f - cVar.c();
        if (Math.abs(fC) < cVar.e()) {
            return false;
        }
        return ((fC > 0.0f ? 1 : (fC == 0.0f ? 0 : -1)) > 0 && z3 && !z) || ((fC > 0.0f ? 1 : (fC == 0.0f ? 0 : -1)) < 0 && z2 && !z) || ((fC > 0.0f ? 1 : (fC == 0.0f ? 0 : -1)) < 0 && z3 && z) || ((fC > 0.0f ? 1 : (fC == 0.0f ? 0 : -1)) > 0 && z2 && z);
    }

    public static int c(int i, float f) {
        return (int) (f * (((0.225f - (Math.min(i, 10) * 0.0125f)) * 2.0f) + 1.0f));
    }

    public static float a(float f, float f2) {
        float f3 = f + (f2 * 0.05f);
        if (Float.compare(f3, 1.0f) >= 0) {
            return 0.95f;
        }
        return f3;
    }

    public static float eAy_(TimeInterpolator timeInterpolator, TimeInterpolator timeInterpolator2) {
        float f = 0.0f;
        if (timeInterpolator != null && timeInterpolator2 != null) {
            float f2 = 0.0f;
            for (int i = 0; i < 100; i += 5) {
                float f3 = i / 100.0f;
                float fAbs = Math.abs(timeInterpolator.getInterpolation(f3) - timeInterpolator2.getInterpolation(f3));
                if (fAbs > f2) {
                    f = f3;
                    f2 = fAbs;
                }
            }
        }
        return f;
    }

    public static TimeInterpolator eAz_() {
        return new HwCubicBezierInterpolator(0.2f, 0.0f, 1.0f, 1.0f);
    }

    public static boolean e(c cVar, float f, boolean z, boolean z2, boolean z3) {
        float fC = f - cVar.c();
        return (!z && z3 && (fC > 0.0f ? 1 : (fC == 0.0f ? 0 : -1)) > 0) || (z && z3 && (fC > 0.0f ? 1 : (fC == 0.0f ? 0 : -1)) < 0) || (!z && z2 && (fC > 0.0f ? 1 : (fC == 0.0f ? 0 : -1)) < 0) || (z && z2 && (fC > 0.0f ? 1 : (fC == 0.0f ? 0 : -1)) > 0);
    }

    public static boolean a(vnu vnuVar, boolean z, float f, float f2) {
        float fQ = vnuVar.q();
        float fP = vnuVar.p();
        float fS = vnuVar.s();
        float fR = vnuVar.r();
        return z ? f >= fS && f < fQ && f2 >= fP && f2 < fR : f >= fQ && f < fS && f2 >= fP && f2 < fR;
    }

    public static int c(vnu vnuVar, float f, float f2, float f3, float f4) {
        float[] fArrH = vnuVar.h();
        if (fArrH == null) {
            return -1;
        }
        int length = fArrH.length;
        for (int i = 0; i < length; i++) {
            float fSqrt = (float) Math.sqrt(Math.pow(fArrH[i] - f3, 2.0d) + Math.pow(vnuVar.i() - f4, 2.0d));
            if ((vnuVar.a() == i && Float.compare(fSqrt, f) <= 0) || Float.compare(fSqrt, f2) <= 0) {
                return i;
            }
        }
        return -1;
    }

    public static void e(boolean z) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j = e;
        if (j == 0) {
            e = jUptimeMillis;
            return;
        }
        if (!z) {
            b = false;
            d = false;
            return;
        }
        long j2 = jUptimeMillis - j;
        if (j2 < 200) {
            d = true;
        } else {
            d = false;
        }
        if (j2 < 100) {
            b = true;
        } else {
            b = false;
        }
        e = jUptimeMillis;
    }

    public static Pair<Integer, Integer> eAA_(int i, int i2, int i3, int i4) {
        int size = View.MeasureSpec.getSize(i);
        if (View.MeasureSpec.getMode(i) != Integer.MIN_VALUE) {
            i3 = size;
        }
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            i4 = Math.min(size2, i4);
        } else if (mode == 1073741824) {
            i4 = size2;
        }
        return new Pair<>(Integer.valueOf(i3), Integer.valueOf(i4));
    }
}
