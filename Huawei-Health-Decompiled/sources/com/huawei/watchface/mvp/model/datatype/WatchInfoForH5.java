package com.huawei.watchface.mvp.model.datatype;

import com.huawei.nfc.PluginPayAdapter;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class WatchInfoForH5 {
    public static Map<String, String> createGalileoMap() {
        HashMap map = new HashMap();
        map.put("device_model", "Galileo-L10E");
        map.put("device_name", "HUAWEI WATCH3");
        map.put(PluginPayAdapter.KEY_DEVICE_INFO_SOFT_VERSION, "11.0.10.016");
        map.put("device_Identify", "00:00:00:00:00:00");
        map.put("deviceIdCutStr", "00:00:00:00:00");
        map.put("watch_screen", "466*466");
        map.put("watch_version", "1.1");
        map.put("watch_max_version", "1.1");
        return map;
    }
}
