package com.huawei.hianalytics;

import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.framework.config.EvtHeaderAttributeCollector;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class c implements EvtHeaderAttributeCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f3980a;

    @Override // com.huawei.hianalytics.framework.config.EvtHeaderAttributeCollector
    public JSONObject doCollector(JSONObject jSONObject, int i) {
        if (this.f3980a == null) {
            return null;
        }
        if (jSONObject != null) {
            try {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    this.f3980a.put(next, jSONObject.getString(next));
                }
            } catch (Exception unused) {
                HiLog.e("HAHC", "json exception");
            }
        }
        this.f3980a.put("hmac", "");
        return this.f3980a;
    }

    public c(JSONObject jSONObject) {
        this.f3980a = jSONObject;
    }
}
