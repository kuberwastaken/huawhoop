package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.huawei.health.R;
import com.huawei.health.sport.model.WorkoutRecord;
import com.huawei.hihealth.data.model.RelativeSportData;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwlogsmodel.LogUtil;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes8.dex */
public class uau {
    private boolean c;
    private Object d;
    private int e;

    public uau(int i, Object obj) {
        this.e = i;
        this.d = obj;
    }

    public int p() {
        return this.e;
    }

    public int y() {
        Object obj = this.d;
        if (obj instanceof uaw) {
            return ((uaw) obj).ad();
        }
        return 199;
    }

    public int u() {
        Object obj = this.d;
        if (obj instanceof uaw) {
            return ((uaw) obj).ac();
        }
        return 199;
    }

    public Drawable ehk_(Context context) {
        Object obj = this.d;
        if (obj == null || context == null) {
            LogUtil.j("SportHistorySingleData", "mSportHistoryData is null");
            return BaseApplication.getContext().getDrawable(R.drawable.ic_health_list_outdoor_running);
        }
        if (this.e == 0) {
            return ((uaw) obj).ehj_(context);
        }
        return context.getDrawable(R.drawable.ic_health_list_fitness_new);
    }

    public int e(Context context) {
        Object obj = this.d;
        if (!(obj instanceof uaw)) {
            LogUtil.j("SportHistorySingleData", "mSportHistoryData is not SingleTrackData");
            return 0;
        }
        String strP = ((uaw) obj).p();
        if (TextUtils.isEmpty(strP)) {
            return 0;
        }
        int iC = iuj.e(context).c(strP);
        LogUtil.j("SportHistorySingleData", "getSport3rdIcon packageName = ", strP);
        return iC;
    }

    public int j() {
        Object obj = this.d;
        if (obj == null) {
            LogUtil.j("SportHistorySingleData", "mSportHistoryData is null");
            return 0;
        }
        int i = this.e;
        if (i == 0 && (obj instanceof uaw)) {
            return ((uaw) obj).o();
        }
        if (i == 1 && (obj instanceof WorkoutRecord) && ((WorkoutRecord) obj).isFitnessRecordFromDevice()) {
            return R.drawable._2131430793_res_0x7f0b0d89;
        }
        if (this.e == 1) {
            Object obj2 = this.d;
            if ((obj2 instanceof WorkoutRecord) && ((WorkoutRecord) obj2).acquireWearType() == 3) {
                return R.drawable._2131430896_res_0x7f0b0df0;
            }
        }
        return 0;
    }

    public float d() {
        Object obj = this.d;
        if (obj == null) {
            LogUtil.j("SportHistorySingleData", "mSportHistoryData is null");
            return 0.0f;
        }
        if (this.e == 0) {
            return ((uaw) obj).a();
        }
        return ((WorkoutRecord) obj).acquireActualCalorie();
    }

    public String o() {
        Object obj = this.d;
        if (obj == null) {
            LogUtil.j("SportHistorySingleData", "mSportHistoryData is null");
            return "";
        }
        return ((uaw) obj).f();
    }

    public long i() {
        Object obj = this.d;
        if (obj == null || !(obj instanceof uaw)) {
            return 0L;
        }
        return ((uaw) obj).c();
    }

    public long m() {
        Object obj = this.d;
        if (obj == null) {
            LogUtil.j("SportHistorySingleData", "mSportHistoryData is null");
            return 0L;
        }
        if (this.e == 0) {
            return ((uaw) obj).i();
        }
        return ((WorkoutRecord) obj).getDuration();
    }

    public float e() {
        Object obj = this.d;
        if (obj == null) {
            LogUtil.j("SportHistorySingleData", "mSportHistoryData is null");
            return 0.0f;
        }
        if (this.e == 0) {
            return ((uaw) obj).e();
        }
        return 0.0f;
    }

    public int x() {
        Object obj = this.d;
        if (obj == null) {
            LogUtil.j("SportHistorySingleData", "mSportHistoryData is null");
            return 0;
        }
        if (this.e == 0) {
            return ((uaw) obj).l();
        }
        return 10001;
    }

    public RelativeSportData n() {
        Object obj = this.d;
        if (obj == null) {
            LogUtil.j("SportHistorySingleData", "mSportHistoryData is null");
            return null;
        }
        if (this.e == 0) {
            return ((uaw) obj).h();
        }
        return null;
    }

    public List<RelativeSportData> h() {
        Object obj = this.d;
        if (obj == null) {
            LogUtil.j("SportHistorySingleData", "mSportHistoryData is null");
            return null;
        }
        if (this.e == 0) {
            return ((uaw) obj).r();
        }
        return null;
    }

    public int b() {
        Object obj = this.d;
        if (obj == null) {
            LogUtil.j("SportHistorySingleData", "mSportHistoryData is null");
            return 0;
        }
        if (this.e == 0) {
            return ((uaw) obj).d();
        }
        return 3;
    }

    public int w() {
        Object obj = this.d;
        if (obj == null) {
            LogUtil.j("SportHistorySingleData", "mSportHistoryData is null");
            return 0;
        }
        if (this.e == 0 && (obj instanceof uaw)) {
            return ((uaw) obj).m();
        }
        return 0;
    }

    public long v() {
        Object obj = this.d;
        if (obj == null) {
            LogUtil.j("SportHistorySingleData", "mSportHistoryData is null");
            return 0L;
        }
        if (this.e == 0) {
            return ((uaw) obj).k();
        }
        return ((WorkoutRecord) obj).startTime();
    }

    public long k() {
        Object obj = this.d;
        if (obj == null) {
            LogUtil.j("SportHistorySingleData", "mSportHistoryData is null");
            return 0L;
        }
        if (this.e == 0) {
            return ((uaw) obj).j();
        }
        return ((WorkoutRecord) obj).acquireExerciseTime();
    }

    public String aa() {
        Object obj = this.d;
        if (obj != null) {
            return this.e == 0 ? "" : ((WorkoutRecord) obj).acquireWorkoutName();
        }
        LogUtil.j("SportHistorySingleData", "mSportHistoryData is null");
        return "";
    }

    public int q() {
        Object obj = this.d;
        if (obj == null) {
            LogUtil.j("SportHistorySingleData", "mSportHistoryData is null");
            return 0;
        }
        if (this.e == 0) {
            return 0;
        }
        return ((WorkoutRecord) obj).acquireId();
    }

    public String ad() {
        Object obj = this.d;
        return obj instanceof WorkoutRecord ? ((WorkoutRecord) obj).acquireWorkoutId() : "";
    }

    public int c() {
        Object obj = this.d;
        if (obj == null) {
            LogUtil.j("SportHistorySingleData", "mSportHistoryData is null");
            return 0;
        }
        if (this.e == 0) {
            return ((uaw) obj).b();
        }
        return 0;
    }

    public float a() {
        Object obj = this.d;
        if (obj == null) {
            LogUtil.j("SportHistorySingleData", "mSportHistoryData is null");
            return 0.0f;
        }
        if (this.e == 0) {
            return ((uaw) obj).n();
        }
        return ((WorkoutRecord) obj).acquireActualCalorie();
    }

    public int g() {
        Object obj = this.d;
        if (obj == null) {
            LogUtil.j("SportHistorySingleData", "mSportHistoryData is null");
            return 0;
        }
        if (this.e == 0 && (obj instanceof uaw)) {
            return ((uaw) obj).g();
        }
        return 0;
    }

    public boolean l() {
        if (this.e != 0) {
            return false;
        }
        Object obj = this.d;
        if (obj instanceof uaw) {
            return ((uaw) obj).y();
        }
        return false;
    }

    public int ah() {
        Object obj = this.d;
        if (obj instanceof uaw) {
            return ((uaw) obj).aa();
        }
        LogUtil.j("SportHistorySingleData", "mSportHistoryData is null,getSportDataSource");
        return 0;
    }

    public String ag() {
        Object obj = this.d;
        if (obj instanceof uaw) {
            return ((uaw) obj).x();
        }
        LogUtil.j("SportHistorySingleData", "mSportHistoryData is null,getRunCourseId");
        return "";
    }

    public String ai() {
        Object obj = this.d;
        if (obj instanceof uaw) {
            return ((uaw) obj).u();
        }
        LogUtil.j("SportHistorySingleData", "mSportHistoryData is null,getRunCourseName");
        return "";
    }

    public boolean af() {
        return this.c;
    }

    public void c(boolean z) {
        this.c = z;
    }

    public int f() {
        Object obj = this.d;
        if (obj instanceof uaw) {
            return ((uaw) obj).s();
        }
        LogUtil.j("SportHistorySingleData", "mSportHistoryData is null,acquireDeviceType");
        return 0;
    }

    public int r() {
        Object obj = this.d;
        if (obj instanceof uaw) {
            return ((uaw) obj).l();
        }
        LogUtil.j("SportHistorySingleData", "mSportHistoryData is null,acquireSportType");
        return 258;
    }

    public int b(Context context) {
        Object obj = this.d;
        if (obj == null) {
            LogUtil.j("SportHistorySingleData", "mSportHistoryData is null");
            return 0;
        }
        if (this.e == 0) {
            return ((uaw) obj).b(context);
        }
        return context.getColor(R.color._2131296940_res_0x7f0902ac);
    }

    public int ac() {
        Object obj = this.d;
        if (obj == null) {
            LogUtil.j("SportHistorySingleData", "mSportHistoryData is null");
            return 0;
        }
        if (this.e == 0) {
            return ((uaw) obj).q();
        }
        return 0;
    }

    public String s() {
        Object obj = this.d;
        return obj instanceof uaw ? ((uaw) obj).w() : "";
    }

    public String z() {
        Object obj = this.d;
        if (obj != null) {
            return this.e == 0 ? ((uaw) obj).t() : "";
        }
        LogUtil.j("SportHistorySingleData", "mSportHistoryData is null");
        return "";
    }

    public int t() {
        if (this.e != 1) {
            return 0;
        }
        Object obj = this.d;
        if (obj instanceof WorkoutRecord) {
            return ((WorkoutRecord) obj).getRecordModeType();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof uau)) {
            return false;
        }
        uau uauVar = (uau) obj;
        return this.e == uauVar.e && this.c == uauVar.c && v() == uauVar.v() && k() == uauVar.k() && x() == uauVar.x() && ac() == uauVar.ac();
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.e), this.d, Boolean.valueOf(this.c));
    }

    public int ab() {
        Object obj = this.d;
        if (!(obj instanceof uaw)) {
            LogUtil.j("SportHistorySingleData", "mSportHistoryData is not instanceof SingleTrackData");
            return -1;
        }
        if (this.e == 0) {
            return ((uaw) obj).v();
        }
        return -1;
    }
}
