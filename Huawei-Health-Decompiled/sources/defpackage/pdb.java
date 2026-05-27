package defpackage;

import android.view.View;
import android.view.ViewGroup;
import com.huawei.haf.bundle.extension.ComponentInfo;
import com.huawei.operation.utils.Constants;
import health.compact.a.LogUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class pdb {
    private static List<String> d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f16630a;
    private boolean c;

    static {
        ArrayList arrayList = new ArrayList(10);
        d = arrayList;
        arrayList.add("com.huawei.health.MainActivity");
        d.add(ComponentInfo.PluginHealthModel_A_1);
        d.add("com.huawei.ui.main.stories.fitness.activity.bloodoxygen.KnitBloodOxygenDetailActivity");
        d.add("com.huawei.ui.main.stories.health.activity.healthdata.KnitBloodPressureActivity");
        d.add("com.huawei.ui.main.stories.template.health.module.HealthDataDetailActivity");
        d.add("com.huawei.ui.main.stories.health.activity.healthdata.KnitTemperatureActivity");
        d.add("com.huawei.ui.main.stories.fitness.activity.heartrate.HeartRateDetailActivity");
        d.add("com.huawei.ui.main.stories.health.activity.healthdata.KnitPressureActivity");
        d.add("com.huawei.health.h5pro.core.H5ProWebViewActivity");
        d.add(Constants.KNIT_SLEEP_DETAIL_ACTIVITY);
        d.add("com.huawei.ui.main.stories.fitness.activity.active.KnitActiveRecordActivity");
        d.add(Constants.SPORT_HISTORY);
        d.add("com.huawei.ui.main.stories.fitness.activity.coresleep.SeriesCourseListActivity");
        d.add("com.huawei.health.suggestion.ui.fitness.activity.SportAllCourseActivity");
    }

    static class e {
        private static final pdb d = new pdb();
    }

    private pdb() {
    }

    public static pdb c() {
        return e.d;
    }

    public void cGW_(View view) {
        this.f16630a = view;
    }

    public View cGV_() {
        return this.f16630a;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public boolean b(String str) {
        return this.c && d.contains(str);
    }

    public void e() {
        View view = this.f16630a;
        if (view != null && (view.getParent() instanceof ViewGroup)) {
            LogUtil.a("MiniPlayerProvider", "remove minibar from old parent view");
            ((ViewGroup) this.f16630a.getParent()).removeView(this.f16630a);
        }
    }
}
