package defpackage;

import android.os.SystemClock;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.huawei.hwlogsmodel.LogUtil;
import health.compact.a.CommonUtil;
import java.lang.reflect.Type;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class pkp {
    public static <T> T c(String str, Class<T> cls) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Gson gson = new Gson();
        T t = null;
        if (!a(str)) {
            return null;
        }
        try {
            t = (T) gson.fromJson(CommonUtil.ac(str), (Class) cls);
        } catch (JsonSyntaxException unused) {
            LogUtil.b("LogEngine_t_JsonUtil", "parse Json Exception");
        }
        LogUtil.e("LogEngine_t_JsonUtil", "fromJson(String json, Class<T> classOfT)   time= ", Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
        return t;
    }

    public static <T> T b(String str, Type type) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        T t = (T) new Gson().fromJson(CommonUtil.ac(str), type);
        LogUtil.e("LogEngine_t_JsonUtil", "fromJson(String json, Type typeOfT)   time= ", Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
        return t;
    }

    public static String a(Object obj) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        String json = new Gson().toJson(obj);
        LogUtil.e("LogEngine_t_JsonUtil", "toJson(Object object)   time= ", Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
        return json;
    }

    public static String c(Object obj, Type type) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeSpecialFloatingPointValues();
        String json = gsonBuilder.create().toJson(obj, type);
        LogUtil.e("LogEngine_t_JsonUtil", "toJson(Object fromJson, Type typeOfSrc)   time= ", Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
        return json;
    }

    public static String e(Object obj) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeSpecialFloatingPointValues();
        gsonBuilder.excludeFieldsWithoutExposeAnnotation();
        String json = gsonBuilder.create().toJson(obj);
        LogUtil.e("LogEngine_t_JsonUtil", "toJson(Object fromJson, Type typeOfSrc)   time= ", Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
        return json;
    }

    public static <T> T b(String str, Class<T> cls) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        T t = (T) new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().fromJson(CommonUtil.ac(str), (Class) cls);
        LogUtil.e("LogEngine_t_JsonUtil", "fromJsonEnableComplexMapKeySerialization(String json, Class<T> classOfT)   time= ", Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
        return t;
    }

    private static boolean a(String str) {
        try {
            try {
                new JSONObject(str);
                return true;
            } catch (JSONException unused) {
                new JSONArray(str);
                return true;
            }
        } catch (JSONException unused2) {
            return false;
        }
    }
}
