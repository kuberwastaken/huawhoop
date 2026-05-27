package com.huawei.haf.store;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public interface KeyValueStoreFactory {
    boolean close(String str, SharedPreferences sharedPreferences);

    SharedPreferences create(String str);
}
