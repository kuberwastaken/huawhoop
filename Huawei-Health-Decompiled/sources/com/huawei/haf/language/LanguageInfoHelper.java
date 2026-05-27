package com.huawei.haf.language;

import android.text.TextUtils;
import androidx.media3.datasource.cache.CacheDataSink;
import com.huawei.haf.application.BaseApplication;
import com.huawei.haf.common.os.FileUtils;
import health.compact.a.LogUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class LanguageInfoHelper {
    private static final Set<String> d = new HashSet();

    private LanguageInfoHelper() {
    }

    static void c(Map<String, String> map, Set<String> set) {
        if (a(map, set)) {
            LogUtil.a("HAF_LanguageInfo", "initLanguageInfo size=", Integer.valueOf(map.size()), ", preset=", Integer.valueOf(set.size()), ", second=", Integer.valueOf(d.size()));
            if (!map.isEmpty() && !set.isEmpty()) {
                return;
            }
        }
        map.clear();
        set.clear();
        d.clear();
        LogUtil.d("HAF_LanguageInfo", "initLanguageInfo fail, the default language configuration will be used. please check.");
        d(map, set);
    }

    static boolean b(String str) {
        return d.contains(str);
    }

    private static JSONObject e() throws JSONException, IOException {
        InputStream inputStreamOpen = BaseApplication.a().getAssets().open("language_plugins/dynamic_language_config.json");
        if (inputStreamOpen == null) {
            throw new IOException("not language info in assets.");
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject(FileUtils.a(inputStreamOpen, CacheDataSink.DEFAULT_FRAGMENT_SIZE));
            LogUtil.a("HAF_LanguageInfo", "read language info from assets, times=", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
            return jSONObject;
        } finally {
            FileUtils.a(inputStreamOpen);
        }
    }

    private static boolean a(Map<String, String> map, Set<String> set) {
        try {
            JSONArray jSONArray = e().getJSONArray("all_lang");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString("name");
                String string2 = jSONObject.getString("uuid");
                String strOptString = jSONObject.optString("flag");
                if (!"unused".equals(strOptString)) {
                    map.put(string, string2);
                    if (!TextUtils.isEmpty(strOptString)) {
                        if ("preset".equals(strOptString)) {
                            set.add(string2);
                        } else if ("second".equals(strOptString)) {
                            d.add(string2);
                        }
                    }
                }
            }
            return true;
        } catch (IOException | JSONException e) {
            LogUtil.b("HAF_LanguageInfo", "parseLanguageInfo ex=", LogUtil.c(e));
            return false;
        }
    }

    private static void d(Map<String, String> map, Set<String> set) {
        map.put("en", "e7edf7db-00a5-4e3a-9cff-032a854e29ef");
        set.add("e7edf7db-00a5-4e3a-9cff-032a854e29ef");
    }
}
