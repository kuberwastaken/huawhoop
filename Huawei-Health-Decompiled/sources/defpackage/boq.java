package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class boq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("enabled")
    private boolean f431a;

    @SerializedName("daysOfWeek")
    private int b;

    @SerializedName("reminderPlans")
    private List<bor> c;

    @SerializedName("alarmId")
    private int d;

    public boq(int i, int i2, boolean z, List<bor> list) {
        this.d = i;
        this.b = i2;
        this.f431a = z;
        this.c = list;
    }

    public boolean a() {
        return this.f431a;
    }

    public void d(boolean z) {
        this.f431a = z;
    }

    public List<bor> e() {
        return this.c;
    }

    public void c(List<bor> list) {
        this.c = list;
    }

    public String toString() {
        return "ReminderBean{mAlarmId=" + this.d + ", mDaysOfWeek=" + this.b + ", mIsEnabled=" + this.f431a + ", mReminderPlanList=" + this.c + '}';
    }
}
