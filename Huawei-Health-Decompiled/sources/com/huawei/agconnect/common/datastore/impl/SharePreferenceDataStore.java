package com.huawei.agconnect.common.datastore.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcelable;
import com.huawei.agconnect.common.api.Logger;
import com.huawei.agconnect.common.datastore.IDataStore;

/* JADX INFO: loaded from: classes10.dex */
public class SharePreferenceDataStore<T> implements IDataStore<T> {
    private static final String c = "SharePreferenceDataStore";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SharedPreferences f1745a;
    final Class<T> b;

    @Override // com.huawei.agconnect.common.datastore.IDataStore
    public boolean contains(String str) {
        return this.f1745a.contains(str);
    }

    void b(String str, Object obj, Class<?> cls) {
        String strB;
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorPutString;
        if (Integer.class.equals(cls)) {
            editorPutString = this.f1745a.edit().putInt(str, ((Integer) obj).intValue());
        } else if (Long.class.equals(cls)) {
            editorPutString = this.f1745a.edit().putLong(str, ((Long) obj).longValue());
        } else if (Float.class.equals(cls)) {
            editorPutString = this.f1745a.edit().putFloat(str, ((Float) obj).floatValue());
        } else if (Boolean.class.equals(cls)) {
            editorPutString = this.f1745a.edit().putBoolean(str, ((Boolean) obj).booleanValue());
        } else {
            if (String.class.equals(cls)) {
                editorEdit = this.f1745a.edit();
                strB = (String) obj;
            } else if (!Parcelable.class.isAssignableFrom(cls)) {
                Logger.w(c, "write not support object type");
                return;
            } else {
                strB = ParcelableSerializer.b((Parcelable) obj);
                editorEdit = this.f1745a.edit();
            }
            editorPutString = editorEdit.putString(str, strB);
        }
        editorPutString.apply();
    }

    @Override // com.huawei.agconnect.common.datastore.IDataStore
    public void b(String str) {
        this.f1745a.edit().remove(str).apply();
    }

    @Override // com.huawei.agconnect.common.datastore.IDataStore
    public T b(String str, T t) {
        return (T) a(str, t, this.b);
    }

    @Override // com.huawei.agconnect.common.datastore.IDataStore
    public void a(String str, T t) {
        b(str, t, this.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    Object a(String str, T t, Class<?> cls) {
        if (Integer.class.equals(cls)) {
            return Integer.valueOf(this.f1745a.getInt(str, ((Integer) t).intValue()));
        }
        if (Long.class.equals(cls)) {
            return Long.valueOf(this.f1745a.getLong(str, ((Long) t).longValue()));
        }
        if (Float.class.equals(cls)) {
            return Float.valueOf(this.f1745a.getFloat(str, ((Float) t).floatValue()));
        }
        if (Boolean.class.equals(cls)) {
            return Boolean.valueOf(this.f1745a.getBoolean(str, ((Boolean) t).booleanValue()));
        }
        if (String.class.equals(cls)) {
            return this.f1745a.getString(str, (String) t);
        }
        if (Parcelable.class.isAssignableFrom(cls)) {
            return ParcelableSerializer.a(this.f1745a.getString(str, null), cls);
        }
        Logger.w(c, "read not support object type");
        return t;
    }

    @Override // com.huawei.agconnect.common.datastore.IDataStore
    public T a(String str) {
        return b(str, null);
    }

    public SharePreferenceDataStore(Context context, String str, Class<T> cls) {
        this.f1745a = context.getSharedPreferences(str, 0);
        this.b = cls;
    }
}
