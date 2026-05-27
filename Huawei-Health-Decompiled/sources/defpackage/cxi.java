package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes3.dex */
public class cxi extends aqt implements Comparable<cxi> {

    @SerializedName("planId")
    private int e;

    public cxi(int i, int i2, int i3, int i4) {
        super(i, i2, i3, null);
        this.e = i4;
    }

    public int i() {
        return this.e;
    }

    public void c(int i) {
        this.e = i;
    }

    @Override // defpackage.aqt
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return (obj instanceof cxi) && ((cxi) obj).e() == e();
    }

    @Override // defpackage.aqt
    public int hashCode() {
        return e();
    }

    public String toString() {
        return "BloodPressureAlarmInfo:mPlanId=" + this.e + ",alarmId=" + e() + ",hour=" + b() + ",minute=" + c() + ",daysOfWeek=" + a() + ",enabled=" + g();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public int compareTo(cxi cxiVar) {
        if (cxiVar == null) {
            return 0;
        }
        int iB = b();
        int iB2 = cxiVar.b();
        if (iB == iB2) {
            return c() - cxiVar.c();
        }
        if ((iB >= 2 && iB2 > 2) || (iB < 2 && iB2 < 2)) {
            return iB - iB2;
        }
        if (iB < 2) {
            return 1;
        }
        return iB2 < 2 ? -1 : 0;
    }
}
