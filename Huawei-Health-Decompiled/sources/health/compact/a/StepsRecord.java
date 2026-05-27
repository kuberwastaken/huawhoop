package health.compact.a;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class StepsRecord {
    public int j = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13778a = -1;
    public int b = -1;
    public int e = -1;
    public int h = -1;
    public int c = -1;
    public int i = -1;
    public int d = -1;
    public int g = -1;

    public boolean d(StepsRecord stepsRecord) {
        return stepsRecord != null && this.j == stepsRecord.j && this.f13778a == stepsRecord.f13778a && this.b == stepsRecord.b && this.e == stepsRecord.e;
    }

    public void b() {
        this.j = -1;
        this.c = -1;
        this.f13778a = -1;
        this.b = -1;
        this.e = -1;
        this.h = -1;
        this.i = -1;
        this.d = -1;
        this.g = -1;
    }

    public boolean a() {
        int i = this.j;
        if (i < 0 || this.f13778a < 0 || this.b < 0 || this.e < 0 || this.h < 0) {
            com.huawei.hwlogsmodel.LogUtil.j("steps_StepsRecord", "error data: ", toString());
            return false;
        }
        if (i <= 1000000) {
            return true;
        }
        com.huawei.hwlogsmodel.LogUtil.j("steps_StepsRecord", " the day step is to large,the step :", LogAnonymous.d(i));
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StepsRecord stepsRecord = (StepsRecord) obj;
        return this.j == stepsRecord.j && this.f13778a == stepsRecord.f13778a && this.b == stepsRecord.b && this.e == stepsRecord.e && this.i == stepsRecord.i && this.d == stepsRecord.d && this.g == stepsRecord.g && this.h == stepsRecord.h;
    }

    public int hashCode() {
        int i = this.j;
        int i2 = this.f13778a;
        int i3 = this.b;
        int i4 = this.e;
        int i5 = this.h;
        return (((((((((((((i * 31) + i2) * 31) + i3) * 31) + i4) * 31) + i5) * 31) + this.i) * 31) + this.d) * 31) + this.g;
    }

    public void e(StepsRecord stepsRecord) {
        if (stepsRecord != null) {
            this.j = stepsRecord.j;
            this.c = stepsRecord.c;
            this.f13778a = stepsRecord.f13778a;
            this.b = stepsRecord.b;
            this.e = stepsRecord.e;
            this.h = stepsRecord.h;
            this.i = stepsRecord.i;
            this.d = stepsRecord.d;
            this.g = stepsRecord.g;
        }
    }

    public Bundle acY_() {
        Bundle bundle = new Bundle();
        bundle.putInt("step", this.j);
        bundle.putInt("devicestep", this.c);
        bundle.putInt("distance", this.b);
        bundle.putInt("carior", this.f13778a);
        bundle.putInt("floor", this.e);
        bundle.putInt("target", this.h);
        bundle.putInt("stepTarget", this.h);
        bundle.putInt("intensityTime", this.i);
        bundle.putInt("activeCount", this.d);
        bundle.putInt("wheelChair", this.g);
        return bundle;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(16);
        sb.append("step ");
        sb.append(this.j);
        sb.append(" devicestep ");
        sb.append(this.c);
        sb.append(" calorie ");
        sb.append(this.f13778a);
        sb.append(" floor ");
        sb.append(this.e);
        sb.append(" distance ");
        sb.append(this.b);
        sb.append(" target ");
        sb.append(this.h);
        sb.append(" intensity ");
        sb.append(this.i);
        sb.append(" activeCount ");
        sb.append(this.d);
        sb.append(" wheelChair ");
        sb.append(this.g);
        return sb.toString();
    }
}
