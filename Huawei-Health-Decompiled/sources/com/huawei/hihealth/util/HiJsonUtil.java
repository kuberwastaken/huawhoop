package com.huawei.hihealth.util;

import android.os.Build;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.json.JsonSanitizer;
import health.compact.a.util.LogUtil;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class HiJsonUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static GsonBuilder f4311a;
    private static GsonBuilder d;

    private HiJsonUtil() {
    }

    public static <T> T b(String str, Class<T> cls) {
        try {
            return (T) b().fromJson(d(str), (Class) cls);
        } catch (JsonSyntaxException e) {
            LogUtil.d("HiJsonUtil", "JsonSyntaxException:", e.getMessage());
            return (T) b().fromJson(d("{}"), (Class) cls);
        }
    }

    public static <T> T a(String str, Type type) {
        try {
            return (T) b().fromJson(d(str), type);
        } catch (JsonSyntaxException unused) {
            LogUtil.d("HiJsonUtil", "JsonSyntaxException");
            return (T) b().fromJson(d("{}"), type);
        }
    }

    public static <T> T c(String str, Class<T> cls) {
        return (T) e().fromJson(d(str), (Class) cls);
    }

    public static String d(Object obj) {
        return b().toJson(obj);
    }

    public static String d(Object obj, Type type) {
        return b().toJson(obj, type);
    }

    private static String d(String str) {
        return TextUtils.isEmpty(str) ? "" : new StringBuffer(JsonSanitizer.sanitize(str)).toString();
    }

    private static Gson b() {
        GsonBuilder gsonBuilderA = d;
        if (gsonBuilderA == null) {
            gsonBuilderA = a(false);
            d = gsonBuilderA;
        }
        return gsonBuilderA.create();
    }

    private static Gson e() {
        GsonBuilder gsonBuilderA = f4311a;
        if (gsonBuilderA == null) {
            gsonBuilderA = a(true);
            f4311a = gsonBuilderA;
        }
        return gsonBuilderA.create();
    }

    private static GsonBuilder a(boolean z) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        if (z) {
            gsonBuilder.enableComplexMapKeySerialization();
        }
        if (Build.VERSION.SDK_INT > 28) {
            gsonBuilder.registerTypeAdapterFactory(new ContentValuesTypeAdapterFactory());
        }
        return gsonBuilder;
    }
}
