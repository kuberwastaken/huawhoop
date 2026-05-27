package com.huawei.appgallery.coreservice.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;

/* JADX INFO: loaded from: classes3.dex */
public interface IConnectionResult {
    String getErrorMessage();

    PendingIntent getResolution();

    int getStatusCode();

    boolean hasResolution();

    void startResolutionForResult(Activity activity, int i) throws IntentSender.SendIntentException;
}
