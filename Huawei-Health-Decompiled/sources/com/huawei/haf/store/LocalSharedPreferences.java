package com.huawei.haf.store;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.haf.application.BaseApplication;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class LocalSharedPreferences implements ExtendSharedPreferences {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f2192a;
    private final int c;
    private final Object d = new Object();

    LocalSharedPreferences(String str, int i) {
        this.c = i;
        this.f2192a = BaseApplication.a().getSharedPreferences(str, i);
    }

    void c(String str) {
        if (this.c == 4) {
            this.f2192a = BaseApplication.a().getSharedPreferences(str, this.c);
        }
    }

    @Override // com.huawei.haf.store.ExtendSharedPreferences
    public void addStringSet(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        synchronized (this.d) {
            Set<String> stringSet = getStringSet(str, null);
            if (stringSet == null || !stringSet.contains(str2)) {
                HashSet hashSet = stringSet != null ? new HashSet(stringSet) : new HashSet();
                hashSet.add(str2);
                edit().putStringSet(str, hashSet).apply();
            }
        }
    }

    @Override // com.huawei.haf.store.ExtendSharedPreferences
    public void removeStringSet(String str, String str2) {
        synchronized (this.d) {
            Set<String> stringSet = getStringSet(str, null);
            if (stringSet != null && stringSet.contains(str2)) {
                if (stringSet.size() == 1) {
                    edit().remove(str).apply();
                    return;
                }
                HashSet hashSet = new HashSet(stringSet);
                hashSet.remove(str2);
                edit().putStringSet(str, hashSet).apply();
            }
        }
    }

    @Override // com.huawei.haf.store.ExtendSharedPreferences
    public boolean containsStringSet(String str, String str2) {
        Set<String> stringSet = getStringSet(str, null);
        return stringSet != null && stringSet.contains(str2);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.f2192a.getAll();
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        return this.f2192a.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return this.f2192a.getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        return this.f2192a.getInt(str, i);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.f2192a.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return this.f2192a.getFloat(str, f);
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.f2192a.getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.f2192a.contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.f2192a.edit();
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f2192a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f2192a.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}
