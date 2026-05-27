package com.huawei.hms.kit.awareness.b.a;

import android.util.ArrayMap;
import com.huawei.health.suggestion.model.FitRunPlayAudio;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5010a = "com.huawei.hms.kit.awareness.cfgStatus";
    public static final String b = "urls";
    public static final String c = "appId";
    public static final String d = "packageName";
    public static final String e = "sdkVersion";
    public static final String f = "uid";
    public static final String g = "apiKey";
    public static final String h = "region";
    private static final ArrayMap<String, String> i;

    public static String b(String str) {
        String str2 = i.get(str);
        return str2 == null ? "" : str2;
    }

    public static boolean a(String str) {
        return !com.huawei.hms.kit.awareness.barrier.internal.f.c.a(str) && i.containsKey(str);
    }

    private a() {
    }

    static {
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        i = arrayMap;
        arrayMap.put("CN", "cn");
        arrayMap.put("DE", FitRunPlayAudio.OPPORTUNITY_E);
        arrayMap.put("RU", "ru");
        arrayMap.put("SG", "a");
    }
}
