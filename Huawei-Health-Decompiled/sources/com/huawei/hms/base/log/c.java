package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

/* JADX INFO: loaded from: classes5.dex */
public class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f4608a;

    @Override // com.huawei.hms.base.log.d
    public void a(Context context, String str) {
        d dVar = this.f4608a;
        if (dVar != null) {
            dVar.a(context, str);
        }
    }

    @Override // com.huawei.hms.base.log.d
    public void a(d dVar) {
        this.f4608a = dVar;
    }

    @Override // com.huawei.hms.base.log.d
    public void a(String str, int i, String str2, String str3) {
        Log.println(i, "HMSSDK_" + str2, str3);
        d dVar = this.f4608a;
        if (dVar != null) {
            dVar.a(str, i, str2, str3);
        }
    }
}
