package com.huawei.hwdevice.mainprocess.mgr.hwmywatchfacemgr.pluginvideo.mmedit;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes6.dex */
public class ThumbnailInfo {
    private Bitmap bitmap;
    private long timestamp;

    public ThumbnailInfo(Bitmap bitmap, long j) {
        this.bitmap = bitmap;
        this.timestamp = j;
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public void clear() {
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            bitmap.recycle();
            this.bitmap = null;
        }
    }
}
