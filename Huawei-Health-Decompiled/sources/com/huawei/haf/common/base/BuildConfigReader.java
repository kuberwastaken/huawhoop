package com.huawei.haf.common.base;

import android.text.TextUtils;
import com.huawei.haf.common.utils.CommonConstant;
import health.compact.a.ReflectionUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class BuildConfigReader {
    private static final Object NULL_VALUE = new Object();
    private final Map<String, Object> mProperties = new ConcurrentHashMap();

    protected abstract Class getBuildConfigClass();

    public final String get(String str) {
        return get(str, "");
    }

    public final String get(String str, String str2) {
        Object value = getValue(str);
        return value instanceof String ? (String) value : str2;
    }

    public final boolean getBoolean(String str, boolean z) {
        Object value = getValue(str);
        return value instanceof Boolean ? ((Boolean) value).booleanValue() : z;
    }

    public final int getInt(String str, int i) {
        Object value = getValue(str);
        return value instanceof Integer ? ((Integer) value).intValue() : i;
    }

    public final long getLong(String str, long j) {
        Object value = getValue(str);
        return value instanceof Long ? ((Long) value).longValue() : j;
    }

    public final String[] getValues(String str) {
        Object value = getValue(str);
        return value instanceof String[] ? (String[]) value : CommonConstant.b;
    }

    protected final Object getValue(String str) {
        if (TextUtils.isEmpty(str)) {
            return NULL_VALUE;
        }
        Object objA = this.mProperties.get(str);
        if (objA == null) {
            objA = ReflectionUtils.a((Class<?>) getBuildConfigClass(), str);
            if (objA == null) {
                objA = NULL_VALUE;
            }
            this.mProperties.put(str, objA);
        }
        return objA;
    }
}
