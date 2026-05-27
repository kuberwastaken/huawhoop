package com.huawei.hwdevice.mainprocess.mgr.hwmywatchfacemgr.type.weardevice;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class WatchFaceVideoInfo {
    private int dataIndex;
    private int maxVideoNum;
    private int positionIndex;
    private int styleIndex;
    private int wristSwitch;
    private int videoType = 1;
    private ArrayList<VideoStruct> videoList = new ArrayList<>(20);
    private ArrayList<WatchFaceVideoCustom> dataList = new ArrayList<>(20);

    public int getWristSwitch() {
        return this.wristSwitch;
    }

    public void setWristSwitch(int i) {
        this.wristSwitch = i;
    }

    public ArrayList<WatchFaceVideoCustom> getDataList() {
        return this.dataList;
    }

    public void setDataList(ArrayList<WatchFaceVideoCustom> arrayList) {
        this.dataList = arrayList;
    }

    public int getMaxVideoNum() {
        return this.maxVideoNum;
    }

    public void setMaxVideoNum(int i) {
        this.maxVideoNum = i;
    }

    public int getVideoType() {
        return this.videoType;
    }

    public void setVideoType(int i) {
        this.videoType = i;
    }

    public ArrayList<VideoStruct> getVideoList() {
        return this.videoList;
    }

    public void setVideoList(ArrayList<VideoStruct> arrayList) {
        this.videoList = arrayList;
    }

    public int getPositionIndex() {
        return this.positionIndex;
    }

    public void setPositionIndex(int i) {
        this.positionIndex = i;
    }

    public int getStyleIndex() {
        return this.styleIndex;
    }

    public void setStyleIndex(int i) {
        this.styleIndex = i;
    }

    public int getDataIndex() {
        return this.dataIndex;
    }

    public void setDataIndex(int i) {
        this.dataIndex = i;
    }

    public static class WatchFaceVideoCustom {
        private int containerIndex;
        private int optionIndex;

        public int getContainerIndex() {
            return this.containerIndex;
        }

        public void setContainerIndex(int i) {
            this.containerIndex = i;
        }

        public int getOptionIndex() {
            return this.optionIndex;
        }

        public void setOptionIndex(int i) {
            this.optionIndex = i;
        }

        public String toString() {
            return "WatchFaceVideoCustom{containerIndex=" + this.containerIndex + ", optionIndex=" + this.optionIndex + '}';
        }
    }

    public String toString() {
        return "WatchFaceVideoInfo{maxVideoNum=" + this.maxVideoNum + ", videoType=" + this.videoType + ", videoList=" + this.videoList + ", positionIndex=" + this.positionIndex + ", styleIndex=" + this.styleIndex + ", dataIndex=" + this.dataIndex + ", wristSwitch=" + this.wristSwitch + ", dataList=" + this.dataList + '}';
    }
}
