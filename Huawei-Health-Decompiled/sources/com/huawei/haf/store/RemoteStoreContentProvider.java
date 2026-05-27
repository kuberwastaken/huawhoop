package com.huawei.haf.store;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.haf.common.base.BaseContentProvider;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class RemoteStoreContentProvider extends BaseContentProvider {
    static final String CLEAR = "CLEAR";
    private final OnSharedPreferenceChangeListenerImpl mListener = new OnSharedPreferenceChangeListenerImpl();
    private volatile ExtendSharedPreferences mSharedPreferences;

    protected abstract String getName();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    @Override // com.huawei.haf.common.base.BaseContentProvider, android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.Bundle call(java.lang.String r2, java.lang.String r3, android.os.Bundle r4) {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.haf.store.RemoteStoreContentProvider.call(java.lang.String, java.lang.String, android.os.Bundle):android.os.Bundle");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.os.Bundle callExtends(java.lang.String r4, java.lang.String r5, android.os.Bundle r6) {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.haf.store.RemoteStoreContentProvider.callExtends(java.lang.String, java.lang.String, android.os.Bundle):android.os.Bundle");
    }

    private void initContentProvider() {
        if (this.mSharedPreferences != null) {
            return;
        }
        synchronized (this.mListener) {
            if (this.mSharedPreferences == null) {
                this.mSharedPreferences = new LocalSharedPreferences(getName(), 0);
            }
        }
    }

    private Bundle commit(String str, String str2, Bundle bundle) {
        SharedPreferences.Editor editorEdit = this.mSharedPreferences.edit();
        if (CLEAR.equals(str2)) {
            editorEdit.clear();
        }
        if (bundle != null) {
            AbstrctSharedPreferences.updateValues(editorEdit, bundle);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean(str, editorEdit.commit());
        return bundle2;
    }

    private void apply(String str, Bundle bundle) {
        SharedPreferences.Editor editorEdit = this.mSharedPreferences.edit();
        if (CLEAR.equals(str)) {
            editorEdit.clear();
        }
        if (bundle != null) {
            AbstrctSharedPreferences.updateValues(editorEdit, bundle);
        }
        editorEdit.apply();
    }

    private Bundle fillRealAll() {
        Map<String, ?> all = this.mSharedPreferences.getAll();
        Bundle bundle = new Bundle(all.size());
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                bundle.putString(key, (String) value);
            } else if (value instanceof Set) {
                Set set = (Set) value;
                bundle.putStringArray(key, (String[]) set.toArray(new String[set.size()]));
            } else if (value instanceof Integer) {
                bundle.putInt(key, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                bundle.putLong(key, ((Long) value).longValue());
            } else if (value instanceof Float) {
                bundle.putFloat(key, ((Float) value).floatValue());
            } else if (value instanceof Boolean) {
                bundle.putBoolean(key, ((Boolean) value).booleanValue());
            }
        }
        return bundle;
    }

    private Bundle fillRealString(String str) {
        String string;
        if (this.mSharedPreferences.contains(str)) {
            try {
                string = this.mSharedPreferences.getString(str, null);
            } catch (ClassCastException unused) {
                string = null;
            }
        } else {
            string = null;
        }
        if (string == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString(str, string);
        return bundle;
    }

    private Bundle fillRealStringSet(String str) {
        Set<String> stringSet;
        if (this.mSharedPreferences.contains(str)) {
            try {
                stringSet = this.mSharedPreferences.getStringSet(str, null);
            } catch (ClassCastException unused) {
                stringSet = null;
            }
        } else {
            stringSet = null;
        }
        if (stringSet == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArray(str, (String[]) stringSet.toArray(new String[stringSet.size()]));
        return bundle;
    }

    private Bundle fillRealInt(String str) {
        Integer numValueOf;
        if (this.mSharedPreferences.contains(str)) {
            try {
                numValueOf = Integer.valueOf(this.mSharedPreferences.getInt(str, 0));
            } catch (ClassCastException unused) {
                numValueOf = null;
            }
        } else {
            numValueOf = null;
        }
        if (numValueOf == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(str, numValueOf.intValue());
        return bundle;
    }

    private Bundle fillRealLong(String str) {
        Long lValueOf;
        if (this.mSharedPreferences.contains(str)) {
            try {
                lValueOf = Long.valueOf(this.mSharedPreferences.getLong(str, 0L));
            } catch (ClassCastException unused) {
                lValueOf = null;
            }
        } else {
            lValueOf = null;
        }
        if (lValueOf == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putLong(str, lValueOf.longValue());
        return bundle;
    }

    private Bundle fillRealFloat(String str) {
        Float fValueOf;
        if (this.mSharedPreferences.contains(str)) {
            try {
                fValueOf = Float.valueOf(this.mSharedPreferences.getFloat(str, 0.0f));
            } catch (ClassCastException unused) {
                fValueOf = null;
            }
        } else {
            fValueOf = null;
        }
        if (fValueOf == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putFloat(str, fValueOf.floatValue());
        return bundle;
    }

    private Bundle fillRealBoolean(String str) {
        Boolean boolValueOf;
        if (this.mSharedPreferences.contains(str)) {
            try {
                boolValueOf = Boolean.valueOf(this.mSharedPreferences.getBoolean(str, false));
            } catch (ClassCastException unused) {
                boolValueOf = null;
            }
        } else {
            boolValueOf = null;
        }
        if (boolValueOf == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(str, boolValueOf.booleanValue());
        return bundle;
    }

    private Bundle fillRealContains(String str) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(str, this.mSharedPreferences.contains(str));
        return bundle;
    }

    private Bundle fillRealContainsSet(String str, String str2) {
        Set<String> stringSet = TextUtils.isEmpty(str2) ? null : this.mSharedPreferences.getStringSet(str, null);
        Bundle bundle = new Bundle();
        bundle.putBoolean(str, stringSet != null && stringSet.contains(str2));
        return bundle;
    }

    class OnSharedPreferenceChangeListenerImpl implements SharedPreferences.OnSharedPreferenceChangeListener {
        private int e;

        private OnSharedPreferenceChangeListenerImpl() {
        }

        void d(boolean z) {
            synchronized (this) {
                if (z) {
                    int i = this.e + 1;
                    this.e = i;
                    if (i == 1) {
                        RemoteStoreContentProvider.this.mSharedPreferences.registerOnSharedPreferenceChangeListener(this);
                    }
                    return;
                }
                int i2 = this.e;
                if (i2 == 1) {
                    this.e = 0;
                    RemoteStoreContentProvider.this.mSharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
                } else if (i2 > 1) {
                    this.e = i2 - 1;
                }
            }
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            RemoteStoreContentProvider.this.getContext().getContentResolver().notifyChange(SharedStoreManager.BD_(RemoteStoreContentProvider.this.getName(), str), null);
        }
    }
}
