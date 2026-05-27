package defpackage;

import com.huawei.hwdevice.phoneprocess.mgr.exercise.HwExerciseConstants;
import health.compact.a.util.LogUtil;

/* JADX INFO: loaded from: classes5.dex */
public class hoh {
    private boolean d;
    private int f;
    private boolean g;
    private int h;
    private int i;
    private float j;
    private int l = 4;
    private int[] m;
    private int n;
    private float o;
    private static final int[] e = {40, -1};
    private static final int[] b = {10, 90, 180, 360, HwExerciseConstants.NINE_MINUTES_PACE, 720, 600};
    private static final int[] c = {10, 90, 180, 360, HwExerciseConstants.NINE_MINUTES_PACE, 720, 600};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f13906a = {10, 90, 180, 360, HwExerciseConstants.NINE_MINUTES_PACE, 720, 600};

    public hoh(float f, float f2, int[] iArr) {
        d(f, f2, iArr);
    }

    public static final int[] c() {
        return (int[]) e.clone();
    }

    public static final int[] b() {
        return (int[]) b.clone();
    }

    public static final int[] d() {
        return (int[]) c.clone();
    }

    public static final int[] a() {
        return (int[]) f13906a.clone();
    }

    private void d(float f, float f2, int[] iArr) {
        this.j = f;
        this.o = f2;
        this.m = iArr;
        this.l = 4;
        this.n = 0;
        this.i = 0;
        this.f = 0;
        if (iArr.length > 0) {
            this.h = iArr[0];
        }
    }

    public void c(float f) {
        int iB = b(f);
        LogUtil.b("Suggestion_StatusUtil", "onUpdate mLowerLimit:", Float.valueOf(this.j));
        LogUtil.b("Suggestion_StatusUtil", "onUpdate mUpperLimit:", Float.valueOf(this.o));
        LogUtil.b("Suggestion_StatusUtil", "onUpdate mTime:", Integer.valueOf(this.h));
        LogUtil.b("Suggestion_StatusUtil", "onUpdate mTimeIndex:", Integer.valueOf(this.f));
        int i = this.l;
        if (i == iB && iB != 4 && iB != 3) {
            int i2 = this.n + 1;
            this.n = i2;
            if (i2 >= 30) {
                this.d = true;
            }
        } else if (i == iB && iB == 3) {
            int i3 = this.i + 1;
            this.i = i3;
            if (i3 >= 30 && this.d) {
                this.g = true;
                this.d = false;
            }
        } else {
            d(this.j, this.o, this.m);
            if (iB == 2 || iB == 1) {
                this.n++;
            }
            if (iB == 3) {
                this.i++;
            }
        }
        LogUtil.a("Suggestion_StatusUtil", "onUpdate current value:", Float.valueOf(f), " mTypeCount:", Integer.valueOf(this.n), " mNormalTypeCount:", Integer.valueOf(this.i), " old type:", Integer.valueOf(this.l), " new type:", Integer.valueOf(iB));
        this.l = iB;
    }

    private int b(float f) {
        float f2 = this.o;
        if (f > f2) {
            return 2;
        }
        float f3 = this.j;
        if (f < f3) {
            return 1;
        }
        return (f3 > f || f > f2) ? 4 : 3;
    }

    public int e() {
        if (this.l == 3) {
            return g();
        }
        return h();
    }

    private int h() {
        int i = this.n;
        int i2 = this.h;
        if (i != i2 || i2 == -1) {
            return 4;
        }
        int i3 = this.f + 1;
        this.f = i3;
        if (i3 >= this.m.length) {
            this.f = r1.length - 1;
        }
        LogUtil.a("Suggestion_StatusUtil", "getStatus mLowerLimit: ", Float.valueOf(this.j), "mUpperLimit: ", Float.valueOf(this.o), " status:", Integer.valueOf(this.l));
        this.h = this.m[this.f];
        return this.l;
    }

    private int g() {
        if (this.i == 180) {
            LogUtil.a("Suggestion_StatusUtil", "getStatus normal: ", Float.valueOf(this.j), "mUpperLimit: ", Float.valueOf(this.o), " status:", Integer.valueOf(this.l));
            return this.l;
        }
        if (!this.g) {
            return 4;
        }
        LogUtil.a("Suggestion_StatusUtil", "recover normal.status:", Integer.valueOf(this.l));
        this.g = false;
        return this.l;
    }
}
