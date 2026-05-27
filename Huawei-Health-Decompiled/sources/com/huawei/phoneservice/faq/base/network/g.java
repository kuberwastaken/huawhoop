package com.huawei.phoneservice.faq.base.network;

import android.app.Activity;
import com.huawei.hms.framework.network.restclient.hwhttp.Submit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
class g {
    private static Map<String, List<Submit>> e = new HashMap();

    public static void cjr_(Activity activity) {
        String name = activity.getClass().getName();
        List<Submit> list = e.get(name);
        if (list != null) {
            for (Submit submit : list) {
                if (!submit.isCanceled()) {
                    submit.cancel();
                }
            }
            e.put(name, null);
        }
    }
}
