package com.huawei.health.marketing.datatype.overlay;

/* JADX INFO: loaded from: classes4.dex */
public class SpEffectFile {
    private String fileUrl;
    private int resolution;
    private String type;

    public String getType() {
        return this.type;
    }

    public int getResolution() {
        return this.resolution;
    }

    public String getFileUrl() {
        return this.fileUrl;
    }

    public String toString() {
        return "SpEffectFile{type='" + this.type + "', resolution=" + this.resolution + ", fileUrl='" + this.fileUrl + "'}";
    }
}
