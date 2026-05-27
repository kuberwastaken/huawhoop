package com.careforeyou.library.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes3.dex */
public class PrefsUtil {
    private SharedPreferences c;
    private SharedPreferences.Editor d;

    public PrefsUtil(Context context) {
        this.c = null;
        this.d = null;
        SharedPreferences sharedPreferences = context.getSharedPreferences("chipsea", 0);
        this.c = sharedPreferences;
        this.d = sharedPreferences.edit();
    }
}
