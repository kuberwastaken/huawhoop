package ohos.stage.ability.adapter;

import android.content.res.Configuration;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class StageConfiguration {
    private static final String COLOR_MODE_DARK = "dark";
    private static final String COLOR_MODE_KEY = "ohos.system.colorMode";
    private static final String COLOR_MODE_LIGHT = "light";
    private static final String DENSITY_KEY = "ohos.application.densitydpi";
    private static final String DEVICE_TYPE = "const.build.characteristics";
    private static final String DEVICE_TYPE_PHONE = "Phone";
    private static final String DEVICE_TYPE_TABLET = "Tablet";
    private static final String EMPTY_VALUE = "";
    private static final String LANGUAGE_MODE_KEY = "ohos.system.language";
    private static final String LOG_TAG = "StageConfiguration";
    private static final String ORI_MODE_KEY = "ohos.application.direction";
    private static final String ORI_MODE_LANDSCAPE = "horizontal";
    private static final String ORI_MODE_PORTRAIT = "vertical";
    private static final String SYSTEM_FONT_SIZE_SCALE = "system.font.size.scale";

    public static JSONObject convertConfiguration(Configuration configuration, double d) {
        JSONObject jSONObject = new JSONObject();
        try {
            int i = configuration.uiMode & 48;
            if (i == 16) {
                jSONObject.put(COLOR_MODE_KEY, COLOR_MODE_LIGHT);
            } else if (i == 32) {
                jSONObject.put(COLOR_MODE_KEY, COLOR_MODE_DARK);
            } else {
                jSONObject.put(COLOR_MODE_KEY, "");
            }
            int i2 = configuration.orientation;
            if (i2 == 1) {
                jSONObject.put(ORI_MODE_KEY, ORI_MODE_PORTRAIT);
            } else if (i2 == 2) {
                jSONObject.put(ORI_MODE_KEY, ORI_MODE_LANDSCAPE);
            } else {
                jSONObject.put(ORI_MODE_KEY, "");
            }
            jSONObject.put(DENSITY_KEY, String.valueOf(configuration.densityDpi));
            jSONObject.put(LANGUAGE_MODE_KEY, configuration.locale);
            int i3 = configuration.smallestScreenWidthDp;
            if (i3 == 0) {
                if (d <= 6.9d && d >= 0.0d) {
                    jSONObject.put(DEVICE_TYPE, "Phone");
                } else if (d > 6.9d) {
                    jSONObject.put(DEVICE_TYPE, DEVICE_TYPE_TABLET);
                }
            } else if (i3 >= 600) {
                jSONObject.put(DEVICE_TYPE, DEVICE_TYPE_TABLET);
            } else {
                jSONObject.put(DEVICE_TYPE, "Phone");
            }
            Log.i(LOG_TAG, "convertConfiguration json:" + jSONObject.toString());
            return jSONObject;
        } catch (JSONException unused) {
            Log.e(LOG_TAG, "convertConfiguration parse Configuration failed");
            return jSONObject;
        }
    }
}
