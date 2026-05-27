package com.huawei.health.h5pro.webkit;

import android.text.TextUtils;
import com.huawei.health.h5pro.utils.LogUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class H5ProLoadingRecordManager {
    public static final H5ProLoadingRecordManager c = new H5ProLoadingRecordManager();
    public final Map<String, Long> d = Collections.synchronizedMap(new HashMap(1));
    public final Map<String, Long> b = Collections.synchronizedMap(new HashMap(1));

    public void removeLoadingRecord(String str) {
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                this.d.remove(str);
                this.b.remove(str);
            }
        }
    }

    public void recordStartTime(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                LogUtil.w("H5PRO_H5ProLoadRecordManager", "recordStartTime: packageName is empty");
            } else {
                if (!this.d.containsKey(str)) {
                    this.d.put(str, Long.valueOf(System.currentTimeMillis()));
                    return;
                }
                LogUtil.w("H5PRO_H5ProLoadRecordManager", "recordStartTime: containsKey -> " + str);
            }
        }
    }

    public void recordDownloadTime(String str, long j) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                LogUtil.w("H5PRO_H5ProLoadRecordManager", "recordDownloadTime: packageName is empty");
            } else if (this.d.containsKey(str)) {
                this.b.put(str, Long.valueOf(j));
            } else {
                this.b.remove(str);
                LogUtil.w("H5PRO_H5ProLoadRecordManager", "recordDownloadTime: loading start time not recorded");
            }
        }
    }

    public JSONObject getLoadingRecord(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                LogUtil.w("H5PRO_H5ProLoadRecordManager", "getLoadingRecord: packageName is empty");
                return null;
            }
            Long l = this.d.get(str);
            if (l != null) {
                long jLongValue = 0;
                try {
                    if (l.longValue() > 0) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("packageName", str);
                            jSONObject.put("totalTime", System.currentTimeMillis() - l.longValue());
                            Long l2 = this.b.get(str);
                            jSONObject.put("hasDownload", (l2 == null || l2.longValue() <= 0) ? 1 : 0);
                            if (l2 != null && l2.longValue() > 0) {
                                jLongValue = l2.longValue();
                            }
                            jSONObject.put("downloadTime", jLongValue);
                            return jSONObject;
                        } catch (JSONException e) {
                            LogUtil.w("H5PRO_H5ProLoadRecordManager", "getLoadingRecord: exception -> " + e.getMessage());
                            return null;
                        }
                    }
                } finally {
                    this.d.remove(str);
                    this.b.remove(str);
                }
            }
            LogUtil.w("H5PRO_H5ProLoadRecordManager", "getLoadingRecord: loading start time not recorded");
            return null;
        }
    }
}
