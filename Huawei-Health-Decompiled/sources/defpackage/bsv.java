package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.haf.common.utils.CollectionUtils;
import health.compact.a.ReleaseLogUtil;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class bsv {

    @SerializedName("alarmInfoList")
    private List<aqt> b;

    @SerializedName("enabled")
    private boolean c;

    public bsv(boolean z, List<aqt> list) {
        c(z);
        d(list);
    }

    public boolean d() {
        return this.c;
    }

    public void c(boolean z) {
        this.c = z;
        if (CollectionUtils.e(this.b)) {
            ReleaseLogUtil.b("R_HL_HealthModeReminderBean", "setEnabled mAlarmInfoList ", this.b);
            return;
        }
        for (aqt aqtVar : this.b) {
            if (aqtVar != null) {
                aqtVar.a(z);
            }
        }
    }

    public List<aqt> e() {
        return this.b;
    }

    public void d(List<aqt> list) {
        this.b = list;
    }

    public String toString() {
        if (CollectionUtils.e(this.b)) {
            ReleaseLogUtil.b("R_HL_HealthModeReminderBean", "toString mAlarmInfoList ", this.b);
            return "HealthModeReminderBean{mIsEnabled=" + this.c + ", mAlarmInfoList=" + this.b + '}';
        }
        StringBuilder sb = new StringBuilder("HealthModeReminderBean{mIsEnabled=" + this.c);
        for (aqt aqtVar : this.b) {
            if (aqtVar != null) {
                int iB = aqtVar.b();
                int iC = aqtVar.c();
                int iA = aqtVar.a();
                boolean zG = aqtVar.g();
                sb.append(", {hour=");
                sb.append(iB);
                sb.append(", minute=");
                sb.append(iC);
                sb.append(", daysOfWeek=");
                sb.append(iA);
                sb.append(", isEnabled=");
                sb.append(zG);
                sb.append("}");
            }
        }
        return ((Object) sb) + "}";
    }
}
