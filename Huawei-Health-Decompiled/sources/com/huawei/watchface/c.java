package com.huawei.watchface;

import com.huawei.watchface.flavor.FlavorConfig;
import java.util.HashMap;

/* JADX INFO: loaded from: classes8.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashMap<String, String> f11445a;

    static {
        HashMap<String, String> map = new HashMap<>();
        f11445a = map;
        map.put("watchFace", FlavorConfig.SERVICE_WATCH_FACE);
        map.put("watchFaceH5", FlavorConfig.SERVICE_WATCH_FACE);
        map.put("hianalyticsV3", FlavorConfig.SERVICE_WATCH_FACE);
        map.put("campaign", FlavorConfig.SERVICE_WATCH_FACE);
        map.put("privacyV2", FlavorConfig.SERVICE_WATCH_FACE);
    }

    public static String a(String str) {
        return f11445a.get(str);
    }
}
