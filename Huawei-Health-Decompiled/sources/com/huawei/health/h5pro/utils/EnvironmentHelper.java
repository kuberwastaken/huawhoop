package com.huawei.health.h5pro.utils;

import android.text.TextUtils;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class EnvironmentHelper {
    public static volatile EnvironmentHelper e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2497a = null;
    public ConcurrentHashMap<String, String> f = null;
    public BuildType c = BuildType.RELEASE;
    public boolean j = false;
    public boolean i = false;
    public String g = "";
    public String b = "";
    public String h = "";
    public String d = "";

    public enum BuildType {
        RELEASE,
        BETA,
        TEST,
        DEBUG,
        GREEN
    }

    public void useHmsLite(boolean z, String str) {
        this.j = z;
        this.g = str;
    }

    public void setUserFlag(String str) {
        this.h = str;
    }

    public void setSpecificBaseUrl(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            setBaseUrl(entry.getKey(), entry.getValue());
        }
    }

    public void setMobileAppEngine(boolean z) {
        this.i = z;
    }

    public void setBuildType(BuildType buildType) {
        if (buildType == null) {
            buildType = BuildType.RELEASE;
        }
        this.c = buildType;
    }

    public void setBaseUrl(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            LogUtil.w("H5PRO_EnvironmentHelper", "setBaseUrl: name or specificBaseUrl is empty");
            return;
        }
        if (this.f == null) {
            this.f = new ConcurrentHashMap<>(1);
        }
        this.f.put(str, str2);
    }

    public void setBaseUrl(String str) {
        this.f2497a = str;
    }

    public void setAccountJsLoginUrl(String str) {
        this.b = str;
    }

    public void setAccountGrsAppName(String str) {
        if (TextUtils.equals(this.d, str)) {
            return;
        }
        this.d = str;
    }

    public boolean isUseHmsLite() {
        return this.j;
    }

    public boolean isMobileAppEngine() {
        return this.i;
    }

    public String getUserFlag() {
        return this.h;
    }

    public String getUrl(String str) {
        if (this.f != null && !TextUtils.isEmpty(str) && this.f.containsKey(str)) {
            String str2 = this.f.get(str);
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
            LogUtil.w("H5PRO_EnvironmentHelper", "getUrl: specificBaseUrl is empty -> " + str);
        }
        return getUrl();
    }

    public String getUrl() {
        String str = this.f2497a;
        return str != null ? str : "";
    }

    public Map<String, String> getSpecificBaseUrl() {
        ConcurrentHashMap<String, String> concurrentHashMap = this.f;
        if (concurrentHashMap == null) {
            return null;
        }
        return Collections.unmodifiableMap(concurrentHashMap);
    }

    public String getHostAt() {
        return this.g;
    }

    public BuildType getBuildType() {
        BuildType buildType = this.c;
        return buildType == null ? BuildType.RELEASE : buildType;
    }

    public String getAccountJsLoginUrl() {
        return this.b;
    }

    public String getAccountGrsAppName() {
        return this.d;
    }

    public static EnvironmentHelper getInstance() {
        if (e == null) {
            synchronized (EnvironmentHelper.class) {
                if (e == null) {
                    e = new EnvironmentHelper();
                }
            }
        }
        return e;
    }
}
