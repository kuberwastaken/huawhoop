package com.huawei.health.h5pro.jsbridge.system.share;

import com.google.gson.annotations.SerializedName;
import com.huawei.health.knit.ui.KnitFragment;
import com.huawei.operation.utils.Constants;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class ShareObj {

    @SerializedName(KnitFragment.KEY_EXTRA)
    public Map<String, Object> f;

    @SerializedName("sharePlatform")
    public int[] g;

    @SerializedName(Constants.BI_MODULE_ID)
    public String h = "";

    @SerializedName("shareBiMap")
    public Map<String, Object> j;

    public void setSharePlatform(int[] iArr) {
        this.g = iArr;
    }

    public void setShareBiMap(Map<String, Object> map) {
        this.j = map;
    }

    public void setModuleId(String str) {
        this.h = str;
    }

    public void setExtra(Map<String, Object> map) {
        this.f = map;
    }

    public int[] getSharePlatform() {
        return this.g;
    }

    public Map<String, Object> getShareBiMap() {
        return this.j;
    }

    public String getModuleId() {
        return this.h;
    }

    public Map<String, Object> getExtra() {
        return this.f;
    }
}
