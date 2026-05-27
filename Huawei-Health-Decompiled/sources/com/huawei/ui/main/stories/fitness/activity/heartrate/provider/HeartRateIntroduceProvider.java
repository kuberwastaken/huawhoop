package com.huawei.ui.main.stories.fitness.activity.heartrate.provider;

import android.content.Context;
import com.huawei.health.knit.data.MinorProvider;
import com.huawei.ui.main.R$string;
import defpackage.ssy;
import health.compact.a.util.LogUtil;
import java.util.HashMap;

/* JADX INFO: loaded from: classes11.dex */
public class HeartRateIntroduceProvider extends MinorProvider<ssy> {
    @Override // com.huawei.health.knit.data.BaseKnitDataProvider, com.huawei.health.knit.data.KnitDataProvider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void parseParams(Context context, HashMap<String, Object> map, ssy ssyVar) {
        String string;
        if (ssyVar != null) {
            int iB = ssyVar.b();
            if (iB == 1) {
                string = context.getResources().getString(R$string.IDS_resting_heart_rate_details_string_new, 60, 100, 60);
            } else if (iB == 2) {
                string = context.getResources().getString(R$string.IDS_resting_heart_rate_high_string, 50, 100, 10);
            } else if (iB == 3) {
                string = context.getResources().getString(R$string.IDS_resting_heart_rate_low_string, 50, 100, 10);
            } else {
                LogUtil.a("HeartRateIntroduceProvider", "no heart rate reminder");
                string = "";
            }
            map.put("REPORT_TEXT", string);
        }
    }

    @Override // com.huawei.health.knit.data.BaseKnitDataProvider
    public String getLogTag() {
        return "HeartRateIntroduceProvider";
    }
}
