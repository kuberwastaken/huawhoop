package com.huawei.health.h5pro.jsbridge.system.shareplus;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.huawei.health.knit.ui.KnitFragment;
import com.huawei.openalliance.ad.db.bean.ContentResource;
import com.huawei.operation.utils.Constants;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class SharePlusParam {

    @SerializedName(KnitFragment.KEY_EXTRA)
    public Map<String, Object> c;

    @SerializedName("shareBiMap")
    public Map<String, Object> j;

    @SerializedName("type")
    public String n = "";

    @SerializedName("text")
    public String l = "";

    @SerializedName("base64")
    public String b = "";

    @SerializedName("uri")
    public String m = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(ContentResource.FILE_NAME)
    public String f2470a = "";

    @SerializedName(Constants.BI_MODULE_ID)
    public String i = "";

    @SerializedName("filePath")
    public String e = "";

    @SerializedName("mineType")
    public String f = "";

    @SerializedName("mimeType")
    public String g = "";

    @SerializedName("distList")
    public List<String> d = null;

    @SerializedName("isReport")
    public boolean h = false;

    public void setUri(String str) {
        this.m = str;
    }

    public void setType(String str) {
        this.n = str;
    }

    public void setText(String str) {
        this.l = str;
    }

    public void setShareBiMap(Map<String, Object> map) {
        this.j = map;
    }

    public void setModuleId(String str) {
        this.i = str;
    }

    public void setMineType(String str) {
        this.f = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.g = str;
    }

    public void setMimeType(String str) {
        this.g = str;
    }

    public void setIsReport(boolean z) {
        this.h = z;
    }

    public void setFilePath(String str) {
        this.e = str;
    }

    public void setFileName(String str) {
        this.f2470a = str;
    }

    public void setExtra(Map<String, Object> map) {
        this.c = map;
    }

    public void setDistList(List<String> list) {
        this.d = list;
    }

    public void setBase64(String str) {
        this.b = str;
    }

    public boolean isReport() {
        return this.h;
    }

    public String getUri() {
        return this.m;
    }

    public String getType() {
        return this.n;
    }

    public String getText() {
        return this.l;
    }

    public Map<String, Object> getShareBiMap() {
        return this.j;
    }

    public String getModuleId() {
        return this.i;
    }

    public String getMimeType() {
        return TextUtils.isEmpty(this.g) ? this.f : this.g;
    }

    public String getFilePath() {
        return this.e;
    }

    public String getFileName() {
        return this.f2470a;
    }

    public Map<String, Object> getExtra() {
        return this.c;
    }

    public List<String> getDistList() {
        return this.d;
    }

    public String getBase64() {
        return this.b;
    }
}
