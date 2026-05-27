package com.huawei.agconnect.common.aaid;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class PushPreferences {
    private static final String b = "";
    private static final String c = "move_to_de_records";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected SharedPreferences f1733a;

    public boolean f(String str) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences sharedPreferences = this.f1733a;
        if (sharedPreferences == null || !sharedPreferences.contains(str) || (editorEdit = this.f1733a.edit()) == null) {
            return false;
        }
        return editorEdit.remove(str).commit();
    }

    public String e(String str) {
        SharedPreferences sharedPreferences = this.f1733a;
        return sharedPreferences != null ? sharedPreferences.getString(str, "") : "";
    }

    public long d(String str) {
        SharedPreferences sharedPreferences = this.f1733a;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(str, 0L);
        }
        return 0L;
    }

    public ContentValues c() {
        Map<String, ?> all;
        Float fValueOf;
        SharedPreferences sharedPreferences = this.f1733a;
        if (sharedPreferences == null || (all = sharedPreferences.getAll()) == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                contentValues.put(key, String.valueOf(value));
            } else if ((value instanceof Integer) || (value instanceof Short) || (value instanceof Byte)) {
                contentValues.put(key, (Integer) value);
            } else if (value instanceof Long) {
                contentValues.put(key, (Long) value);
            } else {
                if (value instanceof Float) {
                    fValueOf = (Float) value;
                } else if (value instanceof Double) {
                    fValueOf = Float.valueOf((float) ((Double) value).doubleValue());
                } else if (value instanceof Boolean) {
                    contentValues.put(key, (Boolean) value);
                }
                contentValues.put(key, fValueOf);
            }
        }
        return contentValues;
    }

    public int c(String str) {
        SharedPreferences sharedPreferences = this.f1733a;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(str, 0);
        }
        return 0;
    }

    public boolean b(String str) {
        SharedPreferences sharedPreferences = this.f1733a;
        return sharedPreferences != null && sharedPreferences.getBoolean(str, false);
    }

    public Map<String, ?> b() {
        SharedPreferences sharedPreferences = this.f1733a;
        return sharedPreferences != null ? sharedPreferences.getAll() : new HashMap();
    }

    public boolean a(String[] strArr) {
        if (this.f1733a == null) {
            return false;
        }
        for (String str : strArr) {
            if (this.f1733a.contains(str)) {
                this.f1733a.edit().remove(str);
            }
        }
        this.f1733a.edit().commit();
        return true;
    }

    public boolean a(String str, String str2) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences sharedPreferences = this.f1733a;
        if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null) {
            return false;
        }
        return editorEdit.putString(str, str2).commit();
    }

    public boolean a(String str, Object obj) {
        float fDoubleValue;
        int iByteValue;
        SharedPreferences.Editor editorEdit = this.f1733a.edit();
        if (obj instanceof String) {
            editorEdit.putString(str, String.valueOf(obj));
        } else {
            if (obj instanceof Integer) {
                iByteValue = ((Integer) obj).intValue();
            } else if (obj instanceof Short) {
                iByteValue = ((Short) obj).shortValue();
            } else if (obj instanceof Byte) {
                iByteValue = ((Byte) obj).byteValue();
            } else if (obj instanceof Long) {
                editorEdit.putLong(str, ((Long) obj).longValue());
            } else {
                if (obj instanceof Float) {
                    fDoubleValue = ((Float) obj).floatValue();
                } else if (obj instanceof Double) {
                    fDoubleValue = (float) ((Double) obj).doubleValue();
                } else if (obj instanceof Boolean) {
                    editorEdit.putBoolean(str, ((Boolean) obj).booleanValue());
                }
                editorEdit.putFloat(str, fDoubleValue);
            }
            editorEdit.putInt(str, iByteValue);
        }
        return editorEdit.commit();
    }

    public boolean a(String str) {
        SharedPreferences sharedPreferences = this.f1733a;
        return sharedPreferences != null && sharedPreferences.contains(str);
    }

    public boolean a(ContentValues contentValues) {
        if (this.f1733a == null || contentValues == null) {
            return false;
        }
        boolean z = true;
        for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
            if (!a(entry.getKey(), entry.getValue())) {
                z = false;
            }
        }
        return z;
    }

    public boolean a() {
        SharedPreferences sharedPreferences = this.f1733a;
        if (sharedPreferences != null) {
            return sharedPreferences.edit().clear().commit();
        }
        return false;
    }

    public void a(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            a(entry.getKey(), entry.getValue());
        }
    }

    public void a(String str, boolean z) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences sharedPreferences = this.f1733a;
        if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null) {
            return;
        }
        editorEdit.putBoolean(str, z).commit();
    }

    public void a(String str, Long l) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences sharedPreferences = this.f1733a;
        if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null) {
            return;
        }
        editorEdit.putLong(str, l.longValue()).commit();
    }

    public void a(String str, Integer num) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences sharedPreferences = this.f1733a;
        if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null) {
            return;
        }
        editorEdit.putInt(str, num.intValue()).commit();
    }

    public PushPreferences(Context context, String str) {
        if (context == null) {
            throw new NullPointerException("context is null!");
        }
        Context contextCreateDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
        SharedPreferences sharedPreferences = contextCreateDeviceProtectedStorageContext.getSharedPreferences(c, 0);
        if (sharedPreferences.getBoolean(str, false)) {
            context = contextCreateDeviceProtectedStorageContext;
        } else if (contextCreateDeviceProtectedStorageContext.moveSharedPreferencesFrom(context, str)) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean(str, true);
            editorEdit.apply();
            context = contextCreateDeviceProtectedStorageContext;
        }
        this.f1733a = context.getSharedPreferences(str, 0);
    }
}
