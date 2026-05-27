package com.huawei.hwdevice.mainprocess.mgr.hwmywatchfacemgr.type.weardevice;

/* JADX INFO: loaded from: classes6.dex */
public class VideoStruct {
    private String timeColor;
    private int timeFontIndex;
    private int timePositionIndex;
    private int timeSizeIndex;
    private int timeStyleIndex;
    private int videoAttribute;
    private int videoIndex;
    private String videoName;
    private String videoPreviewName;
    private int videoStatus;

    public VideoStruct() {
    }

    public VideoStruct(int i, String str, String str2, int i2, int i3) {
        this.videoIndex = i;
        this.videoName = str;
        this.videoPreviewName = str2;
        this.videoAttribute = i2;
        this.videoStatus = i3;
    }

    public int getTimePositionIndex() {
        return this.timePositionIndex;
    }

    public void setTimePositionIndex(int i) {
        this.timePositionIndex = i;
    }

    public int getTimeStyleIndex() {
        return this.timeStyleIndex;
    }

    public void setTimeStyleIndex(int i) {
        this.timeStyleIndex = i;
    }

    public int getTimeFontIndex() {
        return this.timeFontIndex;
    }

    public void setTimeFontIndex(int i) {
        this.timeFontIndex = i;
    }

    public int getTimeSizeIndex() {
        return this.timeSizeIndex;
    }

    public void setTimeSizeIndex(int i) {
        this.timeSizeIndex = i;
    }

    public String getTimeColor() {
        return this.timeColor;
    }

    public void setTimeColor(String str) {
        this.timeColor = str;
    }

    public int getVideoIndex() {
        return this.videoIndex;
    }

    public void setVideoIndex(int i) {
        this.videoIndex = i;
    }

    public String getVideoName() {
        return this.videoName;
    }

    public void setVideoName(String str) {
        this.videoName = str;
    }

    public int getVideoAttribute() {
        return this.videoAttribute;
    }

    public void setVideoAttribute(int i) {
        this.videoAttribute = i;
    }

    public String getVideoPreviewName() {
        return this.videoPreviewName;
    }

    public void setVideoPreviewName(String str) {
        this.videoPreviewName = str;
    }

    public int getVideoStatus() {
        return this.videoStatus;
    }

    public void setVideoStatus(int i) {
        this.videoStatus = i;
    }

    public String toString() {
        return "VideoStruct{videoIndex=" + this.videoIndex + ", videoName='" + this.videoName + "', videoPreviewName='" + this.videoPreviewName + "', videoAttribute=" + this.videoAttribute + ", videoStatus=" + this.videoStatus + ", timeStyleIndex=" + this.timeStyleIndex + ", timeFontIndex=" + this.timeFontIndex + ", timeSizeIndex=" + this.timeSizeIndex + ", timeColor='" + this.timeColor + "', timePositionIndex=" + this.timePositionIndex + '}';
    }
}
