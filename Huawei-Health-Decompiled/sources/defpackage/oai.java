package defpackage;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.huawei.haf.common.exception.ExceptionUtils;
import com.huawei.hwlogsmodel.LogUtil;
import health.compact.a.CommonUtil;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class oai {
    public static <T> T d(String str, Class<T> cls) {
        if (str == null || str.isEmpty()) {
            str = "{}";
        }
        try {
            return (T) new Gson().fromJson(CommonUtil.ac(str), (Class) cls);
        } catch (JsonSyntaxException unused) {
            LogUtil.a("JsonUtil", "JsonSyntaxException");
            return (T) new Gson().fromJson(CommonUtil.ac("{}"), (Class) cls);
        }
    }

    public static <T> T b(String str, Type type) {
        if (str == null || str.isEmpty()) {
            str = "{}";
        }
        try {
            return (T) new Gson().fromJson(CommonUtil.ac(str), type);
        } catch (JsonSyntaxException unused) {
            LogUtil.a("JsonUtil", "JsonSyntaxException");
            return (T) new Gson().fromJson(CommonUtil.ac("{}"), type);
        }
    }

    public static <T> List<T> a(String str, Class<T[]> cls) {
        if (str == null || str.trim().isEmpty()) {
            str = "[]";
        }
        try {
            Object[] objArr = (Object[]) new Gson().fromJson(CommonUtil.ac(str), (Class) cls);
            return objArr == null ? Collections.emptyList() : Arrays.asList(objArr);
        } catch (JsonParseException e) {
            LogUtil.a("JsonUtil", "getListFromJson exception: ", ExceptionUtils.a(e));
            return Collections.emptyList();
        }
    }

    public static String b(Object obj) {
        return new Gson().toJson(obj);
    }

    public static String d(Object obj, Type type) {
        return new Gson().toJson(obj, type);
    }

    public static Map<String, String> d(String str) {
        if (str == null || str.isEmpty()) {
            str = "{}";
        }
        try {
            return (Map) new Gson().fromJson(CommonUtil.ac(str), new TypeToken<Map<String, String>>() { // from class: com.huawei.pluginfitnessadvice.utils.JsonUtil$1
            }.getType());
        } catch (JsonSyntaxException unused) {
            LogUtil.a("JsonUtil", "JsonSyntaxException");
            return Collections.emptyMap();
        }
    }
}
