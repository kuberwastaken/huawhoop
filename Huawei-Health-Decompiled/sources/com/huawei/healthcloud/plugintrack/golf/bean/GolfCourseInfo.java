package com.huawei.healthcloud.plugintrack.golf.bean;

import com.huawei.healthcloud.plugintrack.golf.Utils;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes5.dex */
public class GolfCourseInfo implements GolfBeanToBytes, Serializable {
    public static final int DATA_LENGTH = 92;
    private static final int MAX_GOLF_COURT_NAME_LENGTH = 80;
    private int mCourseId;
    private String mCourseName;
    private int mDistance;
    private int mVersion;

    public String getCourseName() {
        return this.mCourseName;
    }

    public void setCourseName(String str) {
        this.mCourseName = str;
    }

    public int getCourseId() {
        return this.mCourseId;
    }

    public void setCourseId(int i) {
        this.mCourseId = i;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public void setVersion(int i) {
        this.mVersion = i;
    }

    public int getDistance() {
        return this.mDistance;
    }

    public void setDistance(int i) {
        this.mDistance = i;
    }

    public String toString() {
        return "GolfCourseInfo{courseName='" + this.mCourseName + "', courseId=" + this.mCourseId + ", version=" + this.mVersion + ", distance=" + this.mDistance + '}';
    }

    @Override // com.huawei.healthcloud.plugintrack.golf.bean.GolfBeanToBytes
    public byte[] toBytes() {
        byte[] bArr = new byte[92];
        byte[] bytes = this.mCourseName.getBytes(StandardCharsets.UTF_8);
        System.arraycopy(bytes, 0, bArr, 0, Math.min(bytes.length, 80));
        byte[] bArrInt2Bytes = Utils.int2Bytes(this.mCourseId);
        System.arraycopy(bArrInt2Bytes, 0, bArr, 80, bArrInt2Bytes.length);
        byte[] bArrInt2Bytes2 = Utils.int2Bytes(this.mVersion);
        System.arraycopy(bArrInt2Bytes2, 0, bArr, bArrInt2Bytes.length + 80, bArrInt2Bytes2.length);
        byte[] bArrInt2Bytes3 = Utils.int2Bytes(this.mDistance);
        System.arraycopy(bArrInt2Bytes3, 0, bArr, bArrInt2Bytes.length + 80 + bArrInt2Bytes2.length, bArrInt2Bytes3.length);
        return bArr;
    }
}
