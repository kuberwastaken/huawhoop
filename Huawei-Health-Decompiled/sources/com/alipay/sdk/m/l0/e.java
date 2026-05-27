package com.alipay.sdk.m.l0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.agconnect.common.aaid.AaidUtils;
import defpackage.mv;
import defpackage.mw;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes9.dex */
public final class e extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("openIdNotifyFlag", 0);
        mw.e("shouldUpdateId, notifyFlag : ".concat(String.valueOf(intExtra)));
        if (intExtra == 1) {
            if (!TextUtils.equals(intent.getStringExtra("openIdPackage"), context.getPackageName())) {
                return;
            }
        } else if (intExtra == 2) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("openIdPackageList");
            if (stringArrayListExtra == null || !stringArrayListExtra.contains(context.getPackageName())) {
                return;
            }
        } else if (intExtra != 0) {
            return;
        }
        String stringExtra = intent.getStringExtra("openIdType");
        mw mwVarD = mw.d();
        mv mvVar = "oaid".equals(stringExtra) ? mwVarD.d : "vaid".equals(stringExtra) ? mwVarD.j : AaidUtils.f1731a.equals(stringExtra) ? mwVarD.f15905a : "udid".equals(stringExtra) ? mwVarD.b : null;
        if (mvVar == null) {
            return;
        }
        mvVar.b();
    }
}
