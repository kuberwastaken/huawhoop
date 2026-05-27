package defpackage;

import com.huawei.pluginfitnessadvice.RoadBook;
import health.compact.a.util.LogUtil;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class gtb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static RoadBook[] f13610a;
    private int c;
    private float d = 1.0f;
    private float e;

    public static void a(List<RoadBook> list) {
        if (list == null) {
            return;
        }
        int iC = c(list) + 1;
        LogUtil.a("Suggestion_CourseEquipmentSpeedSmoothHelper", "setRoadBooks:", Integer.valueOf(list.size()), " arrayNum:", Integer.valueOf(iC));
        f13610a = new RoadBook[iC];
        for (RoadBook roadBook : list) {
            if (roadBook != null && roadBook.getDuration() >= 0) {
                f13610a[roadBook.getDuration()] = roadBook;
            }
        }
    }

    public static RoadBook[] d() {
        return f13610a;
    }

    public static void a() {
        f13610a = null;
    }

    private static int c(List<RoadBook> list) {
        int duration = 0;
        if (mgx.d(list)) {
            return 0;
        }
        for (RoadBook roadBook : list) {
            if (roadBook.getDuration() > duration) {
                duration = roadBook.getDuration();
            }
        }
        return duration;
    }

    public float a(int i, int i2) {
        c(i);
        b(i2);
        return c(this.d);
    }

    private void c(int i) {
        RoadBook roadBookA = a(i);
        if (roadBookA != null) {
            this.c = roadBookA.getSpeed();
        }
        if (this.e == 0.0f) {
            this.e = this.c;
        }
        int i2 = this.c;
        if (i2 != 0) {
            this.e = (this.e * 0.9f) + (i2 * 0.1f);
        } else {
            this.e = 0.0f;
        }
        LogUtil.a("Suggestion_CourseEquipmentSpeedSmoothHelper", "currentSecond:", Integer.valueOf(i), " currentRoadBook speed:", Integer.valueOf(this.c));
    }

    private void b(int i) {
        float f = this.e;
        if (f == 0.0f) {
            this.d = 1.0f;
            LogUtil.a("Suggestion_CourseEquipmentSpeedSmoothHelper", "mSmoothSpeed:", Float.valueOf(f), " currentSpeed:", Integer.valueOf(i), " mPlaySpeedLevel:", Float.valueOf(this.d));
        } else {
            float f2 = i / f;
            this.d = (this.d * 0.7f) + (0.3f * f2);
            LogUtil.a("Suggestion_CourseEquipmentSpeedSmoothHelper", "mSmoothSpeed:", Float.valueOf(f), " currentSpeed:", Integer.valueOf(i), " tempPlaySpeedLevel:", Float.valueOf(f2), " mPlaySpeedLevel:", Float.valueOf(this.d));
        }
    }

    private RoadBook a(int i) {
        RoadBook roadBook = null;
        if (f13610a.length <= i) {
            return null;
        }
        while (i >= 0) {
            roadBook = f13610a[i];
            if (roadBook != null) {
                break;
            }
            i--;
        }
        return roadBook;
    }

    private float c(float f) {
        if (f < 0.2f) {
            return 0.0f;
        }
        if (f <= 0.5f) {
            return 0.5f;
        }
        if (f <= 2.0f) {
            return Math.round(f * 10.0f) / 10.0f;
        }
        return 2.0f;
    }
}
