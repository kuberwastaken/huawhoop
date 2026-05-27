package com.huawei.hianalytics.visual.autocollect.instrument;

import android.content.Intent;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.visual.k0;

/* JADX INFO: loaded from: classes10.dex */
public class ActivityInstrumentation {
    public static void instrumentStartActivity(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            if (!intent.hasExtra("$sessionid") && !intent.hasExtra("$sessiontime")) {
                intent.putExtra("$sessionid", k0.b.f4074a.f4072a);
                intent.putExtra("$sessiontime", k0.b.f4074a.b);
            }
        } catch (Exception unused) {
            HiLog.e("ActivityInstrumentation", "instrumentStartActivity failed");
        }
    }
}
