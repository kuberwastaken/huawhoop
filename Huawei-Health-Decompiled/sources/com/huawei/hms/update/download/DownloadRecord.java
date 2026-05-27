package com.huawei.hms.update.download;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes10.dex */
class DownloadRecord {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6227a;
    private int b;
    private String c;
    private int d;

    private void a(Context context, String str) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.huawei.hms.update.DOWNLOAD_RECORD" + str, 0).edit();
        editorEdit.putString("mUri", this.f6227a);
        editorEdit.putInt("mSize", this.b);
        editorEdit.putString("mHash", this.c);
        editorEdit.putInt("mReceived", this.d);
        editorEdit.commit();
    }

    public int getSize() {
        return this.b;
    }

    public void init(String str, int i, String str2) {
        this.f6227a = str;
        this.b = i;
        this.c = str2;
        this.d = 0;
    }

    public boolean isValid(String str, int i, String str2) {
        String str3;
        String str4 = this.f6227a;
        return str4 != null && str4.equals(str) && this.b == i && (str3 = this.c) != null && str3.equals(str2) && this.d <= this.b;
    }

    public void load(Context context, String str) {
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.huawei.hms.update.DOWNLOAD_RECORD" + str, 0);
        this.f6227a = sharedPreferences.getString("mUri", "");
        this.b = sharedPreferences.getInt("mSize", 0);
        this.c = sharedPreferences.getString("mHash", "");
        this.d = sharedPreferences.getInt("mReceived", 0);
    }

    public void update(Context context, int i, String str) {
        this.d = i;
        a(context, str);
    }

    int a() {
        return this.d;
    }

    DownloadRecord() {
    }
}
