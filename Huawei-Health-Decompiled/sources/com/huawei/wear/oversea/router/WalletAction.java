package com.huawei.wear.oversea.router;

import android.content.Context;
import defpackage.vxm;
import defpackage.vxn;

/* JADX INFO: loaded from: classes8.dex */
public interface WalletAction {
    vxm invoke(Context context, vxn vxnVar);

    boolean isAsync(Context context, vxn vxnVar);
}
