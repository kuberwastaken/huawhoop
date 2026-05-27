package com.huawei.appgallery.coreservice;

import android.content.Context;
import android.content.SharedPreferences;
import defpackage.bab;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f1903a;

    public void b(String str, String str2) {
        try {
            SharedPreferences.Editor editorEdit = this.f1903a.edit();
            editorEdit.putString(str, str2);
            editorEdit.commit();
        } catch (Exception e) {
            bab.e("BaseSharedPreference", "putString error!!key:" + str, e);
        }
    }

    public String a(String str, String str2) {
        try {
            return this.f1903a.getString(str, str2);
        } catch (Exception unused) {
            this.f1903a.edit().remove(str).commit();
            return str2;
        }
    }

    public i(Context context, String str) {
        this.f1903a = context.getSharedPreferences(str, 0);
    }
}
