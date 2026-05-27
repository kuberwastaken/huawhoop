package com.huawei.operation.h5pro.ble.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.openalliance.ad.db.bean.ContentResource;

/* JADX INFO: loaded from: classes11.dex */
public class JsDownloadBean {

    @SerializedName(ContentResource.FILE_NAME)
    private String fileName;

    @SerializedName("url")
    private String url;

    public String getUrl() {
        return this.url;
    }

    public String getFileName() {
        return this.fileName;
    }
}
