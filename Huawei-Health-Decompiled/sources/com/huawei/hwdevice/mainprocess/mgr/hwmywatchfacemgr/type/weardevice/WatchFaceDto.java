package com.huawei.hwdevice.mainprocess.mgr.hwmywatchfacemgr.type.weardevice;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class WatchFaceDto {

    @SerializedName("isAlbums")
    private boolean isAlbums;

    @SerializedName("isCurrent")
    private boolean isCurrent;

    @SerializedName("isKaleidoscope")
    private boolean isKaleidoscope;

    @SerializedName("isOnTrial")
    private boolean isOnTrial;

    @SerializedName("isPreset")
    private boolean isPreset;

    @SerializedName("isSupportDelete")
    private boolean isSupportDelete;

    @SerializedName("isVideo")
    private boolean isVideo;

    @SerializedName("watchFaceId")
    private String watchFaceId;

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

    public boolean isCurrent() {
        return this.isCurrent;
    }

    public void setCurrent(boolean z) {
        this.isCurrent = z;
    }

    public boolean isSupportDelete() {
        return this.isSupportDelete;
    }

    public void setSupportDelete(boolean z) {
        this.isSupportDelete = z;
    }

    public boolean isVideo() {
        return this.isVideo;
    }

    public void setVideo(boolean z) {
        this.isVideo = z;
    }

    public boolean isAlbums() {
        return this.isAlbums;
    }

    public void setAlbums(boolean z) {
        this.isAlbums = z;
    }

    public boolean isKaleidoscope() {
        return this.isKaleidoscope;
    }

    public void setKaleidoscope(boolean z) {
        this.isKaleidoscope = z;
    }

    public int getWatchFaceType() {
        return this.watchFaceType;
    }

    public void setWatchFaceType(int i) {
        this.watchFaceType = i;
    }
}
