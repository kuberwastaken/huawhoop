package com.huawei.pluginsocialshare.cloud.bean;

import com.huawei.health.socialshare.model.socialsharebean.ShareDataInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public interface DownloadCallback {
    void onFailure(int i, String str);

    void onSuccess(JSONObject jSONObject, ShareDataInfo shareDataInfo);
}
