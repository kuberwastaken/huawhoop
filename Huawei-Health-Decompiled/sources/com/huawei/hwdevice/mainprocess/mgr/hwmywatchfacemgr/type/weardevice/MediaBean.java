package com.huawei.hwdevice.mainprocess.mgr.hwmywatchfacemgr.type.weardevice;

/* JADX INFO: loaded from: classes11.dex */
public class MediaBean {
    private String displayName;
    private int duration;
    private String path;
    private long size;
    private long videoId;

    public long getVideoId() {
        return this.videoId;
    }

    public void setVideoId(long j) {
        this.videoId = j;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public String toString() {
        return "MediaBean{videoId=" + this.videoId + ", path='" + this.path + "', duration=" + this.duration + ", size=" + this.size + ", displayName='" + this.displayName + "'}";
    }
}
