package com.huawei.hwdevice.mainprocess.mgr.hwmywatchfacemgr.type.h5pro;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class InstalledWatchFace {

    @SerializedName("iconPicture")
    private String iconPicture;

    @SerializedName("isCurrent")
    private boolean isCurrent;

    @SerializedName("isOnTrial")
    private boolean isOnTrial;

    @SerializedName("isPreset")
    private boolean isPreset;

    @SerializedName("isSupportDelete")
    private boolean isSupportDelete;

    @SerializedName("jumpUrl")
    private String jumpUrl;

    @SerializedName("latestVersion")
    private String latestVersion;

    @SerializedName("status")
    private int status;

    @SerializedName("watchFaceId")
    private String watchFaceId;

    @SerializedName("watchFaceName")
    private String watchFaceName;

    @SerializedName("watchFaceType")
    private int watchFaceType;

    @SerializedName("watchFaceVersion")
    private String watchFaceVersion;

    public boolean isPreset() {
        return this.isPreset;
    }

    public void setPreset(boolean z) {
        this.isPreset = z;
    }

    public boolean isOnTrial() {
        return this.isOnTrial;
    }

    public void setOnTrial(boolean z) {
        this.isOnTrial = z;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public void setJumpUrl(String str) {
        this.jumpUrl = str;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public String getWatchFaceId() {
        return this.watchFaceId;
    }

    public void setWatchFaceId(String str) {
        this.watchFaceId = str;
    }

    public String getWatchFaceVersion() {
        return this.watchFaceVersion;
    }

    public void setWatchFaceVersion(String str) {
        this.watchFaceVersion = str;
    }

    public String getWatchFaceName() {
        return this.watchFaceName;
    }

    public void setWatchFaceName(String str) {
        this.watchFaceName = str;
    }

    public boolean isCurrent() {
        return this.isCurrent;
    }

    public void setCurrent(boolean z) {
        this.isCurrent = z;
    }

    public String getIconPicture() {
        return this.iconPicture;
    }

    public void setIconPicture(String str) {
        this.iconPicture = str;
    }

    public boolean isSupportDelete() {
        return this.isSupportDelete;
    }

    public void setSupportDelete(boolean z) {
        this.isSupportDelete = z;
    }

    public String getLatestVersion() {
        return this.latestVersion;
    }

    public void setLatestVersion(String str) {
        this.latestVersion = str;
    }

    public int getWatchFaceType() {
        return this.watchFaceType;
    }

    public void setWatchFaceType(int i) {
        this.watchFaceType = i;
    }
}
