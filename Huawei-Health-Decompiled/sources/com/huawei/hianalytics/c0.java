package com.huawei.hianalytics;

import android.app.usage.UsageEvents;
import android.text.TextUtils;
import com.huawei.hianalytics.core.log.HiLog;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3981a = "";

    public Map<String, q> a(UsageEvents usageEvents) {
        HashMap map = new HashMap();
        while (usageEvents.hasNextEvent()) {
            UsageEvents.Event event = new UsageEvents.Event();
            if (usageEvents.getNextEvent(event)) {
                String packageName = event.getPackageName();
                q qVar = (q) map.get(packageName);
                if (qVar == null) {
                    qVar = new q();
                    qVar.f67a = packageName;
                    map.put(packageName, qVar);
                }
                if (event.getEventType() == 1) {
                    if (!TextUtils.equals(packageName, this.f3981a)) {
                        qVar.f4037a++;
                    }
                    this.f3981a = packageName;
                }
                int eventType = event.getEventType();
                if (eventType == 1) {
                    if (qVar.f66a == 0) {
                        qVar.f66a = event.getTimeStamp();
                        qVar.b = event.getTimeStamp();
                    }
                    qVar.d = eventType;
                    qVar.e = event.getTimeStamp();
                } else if (eventType == 2) {
                    qVar.b = event.getTimeStamp();
                }
                if (qVar.d == 1 && eventType == 2) {
                    long timeStamp = event.getTimeStamp() - qVar.e;
                    if (timeStamp > 0) {
                        qVar.c += timeStamp;
                    }
                }
            } else {
                HiLog.d("UM", "get next event failed");
            }
        }
        return map;
    }
}
