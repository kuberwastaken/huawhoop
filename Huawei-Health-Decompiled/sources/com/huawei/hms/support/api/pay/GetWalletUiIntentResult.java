package com.huawei.hms.support.api.pay;

import android.app.PendingIntent;
import com.huawei.hms.support.api.client.Result;

/* JADX INFO: loaded from: classes10.dex */
public class GetWalletUiIntentResult extends Result {
    private PendingIntent pendingIntent;

    public void setPendingIntent(PendingIntent pendingIntent) {
        this.pendingIntent = pendingIntent;
    }

    public PendingIntent getPindingIntent() {
        return this.pendingIntent;
    }
}
