package com.huawei.ui.main.stories.fitness.activity.pressuremeasure.cloud.callback;

import android.os.Handler;

/* JADX INFO: loaded from: classes7.dex */
public abstract class UiCallback<T> {
    public boolean isCanceled() {
        return false;
    }

    public abstract void onFailure(int i, String str);

    public void onProgress(long j, long j2) {
    }

    public abstract void onSuccess(T t);

    public void onSuccess(Handler handler, final T t) {
        if (handler != null) {
            handler.post(new Runnable() { // from class: srf
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.m1188lambda$onSuccess$0$comhuaweiuimainstoriesfitnessactivitypressuremeasurecloudcallbackUiCallback(t);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: lambda$onSuccess$0$com-huawei-ui-main-stories-fitness-activity-pressuremeasure-cloud-callback-UiCallback, reason: not valid java name */
    public /* synthetic */ void m1188lambda$onSuccess$0$comhuaweiuimainstoriesfitnessactivitypressuremeasurecloudcallbackUiCallback(Object obj) {
        if (obj != 0) {
            onSuccess(obj);
        }
    }
}
