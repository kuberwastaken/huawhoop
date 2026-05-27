package com.huawei.maps.offlinedata.handler.dto.device;

import com.huawei.maps.offlinedata.utils.g;
import java.io.File;

/* JADX INFO: loaded from: classes6.dex */
public class TransmitRequest {
    private static final String TAG = "TransmitRequest";
    private Integer downloadType = 0;
    private String fileDecompressDir;
    private String fileName;
    private Integer mapSize;
    private Integer mapType;
    private Long requestId;
    private Integer syncType;

    public long getRequestId() {
        return this.requestId.longValue();
    }

    public void setRequestId(long j) {
        this.requestId = Long.valueOf(j);
    }

    public int getMapSize() {
        return this.mapSize.intValue();
    }

    public void setMapSize(int i) {
        this.mapSize = Integer.valueOf(i);
    }

    public int getMapType() {
        return this.mapType.intValue();
    }

    public void setMapType(int i) {
        this.mapType = Integer.valueOf(i);
    }

    public int getSyncType() {
        return this.syncType.intValue();
    }

    public void setSyncType(int i) {
        this.syncType = Integer.valueOf(i);
    }

    public String getFileDecompressDir() {
        return this.fileDecompressDir;
    }

    public void setFileDecompressDir(String str) {
        this.fileDecompressDir = str;
    }

    public Integer getDownloadType() {
        return this.downloadType;
    }

    public void setDownloadType(Integer num) {
        this.downloadType = num;
    }

    public boolean getFileNameInFileDecompressDir() {
        File[] fileArrListFiles = new File(this.fileDecompressDir).listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length != 1) {
            g.d(TAG, "getFileNameInFileDecompressDir: files number is error");
            return false;
        }
        if (fileArrListFiles[0].isFile()) {
            this.fileName = fileArrListFiles[0].getName();
            return true;
        }
        g.d(TAG, "not file type.");
        return false;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public String toString() {
        return "TransmitRequest{requestId=" + this.requestId + ", mapSize=" + this.mapSize + ", mapType=" + this.mapType + ", syncType=" + this.syncType + '}';
    }
}
