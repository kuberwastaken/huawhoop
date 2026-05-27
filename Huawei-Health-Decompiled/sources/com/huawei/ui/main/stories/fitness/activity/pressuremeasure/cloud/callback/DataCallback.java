package com.huawei.ui.main.stories.fitness.activity.pressuremeasure.cloud.callback;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public abstract class DataCallback {
    public abstract void onFailure(int i, String str);

    public void onProgress(long j, long j2, boolean z) {
    }

    public abstract void onSuccess(JSONObject jSONObject);
}
