package com.huawei.hwdevice.mainprocess.mgr.hwmywatchfacemgr.pluginvideo.videoedit.info;

import health.compact.a.LogUtil;

/* JADX INFO: loaded from: classes6.dex */
public abstract class MediaFileInfo implements Cloneable {
    private static final int STATUS_ADD = 2;
    private static final int STATUS_DELETE = 1;
    private static final int STATUS_MODIFY = 3;
    private static final int STATUS_NONE = 0;
    private static final String TAG = "MediaFileInfo";
    public static final int TYPE_IMAGE = 1;
    public static final int TYPE_NULL = 0;
    public static final int TYPE_VIDEO = 2;
    private final String mFilePath;
    private int mHeight;
    private final int mMediaType;
    private int mRotation;
    private int mStatusFlag = 0;
    private int mWidth;

    MediaFileInfo(String str, int i) {
        this.mFilePath = str;
        this.mMediaType = i;
    }

    public void setDelete() {
        this.mStatusFlag = 1;
    }

    public boolean isDelete() {
        return this.mStatusFlag == 1;
    }

    public void setAdd() {
        this.mStatusFlag = 2;
    }

    public boolean isAdd() {
        return this.mStatusFlag == 2;
    }

    public void setModify() {
        this.mStatusFlag = 2;
    }

    public boolean isModify() {
        return this.mStatusFlag == 3;
    }

    public int getMediaType() {
        return this.mMediaType;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    void setWidth(int i) {
        this.mWidth = i;
    }

    public int getWidth() {
        return this.mWidth;
    }

    void setHeight(int i) {
        this.mHeight = i;
    }

    public int getHeight() {
        return this.mHeight;
    }

    void setRotation(int i) {
        this.mRotation = i;
    }

    public int getRotation() {
        return this.mRotation;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MediaFileInfo)) {
            return false;
        }
        MediaFileInfo mediaFileInfo = (MediaFileInfo) obj;
        return mediaFileInfo.mMediaType == this.mMediaType && mediaFileInfo.mFilePath.equalsIgnoreCase(this.mFilePath) && mediaFileInfo.mStatusFlag == this.mStatusFlag;
    }

    public int hashCode() {
        int iHashCode = super.hashCode();
        String str = this.mFilePath;
        if (str != null) {
            iHashCode = (iHashCode * 31) + str.hashCode();
        }
        return (iHashCode * 31) + this.mMediaType;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            LogUtil.a(TAG, "clone failed.");
            return null;
        }
    }
}
