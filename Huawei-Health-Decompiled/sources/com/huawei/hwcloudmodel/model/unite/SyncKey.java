package com.huawei.hwcloudmodel.model.unite;

/* JADX INFO: loaded from: classes9.dex */
public class SyncKey {
    private String category;
    private Integer dataType;
    private Long deviceCode;
    private Integer type;
    private Long version;

    public Integer getDataType() {
        return this.dataType;
    }

    public void setDataType(Integer num) {
        this.dataType = num;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer num) {
        this.type = num;
    }

    public Long getDeviceCode() {
        return this.deviceCode;
    }

    public void setDeviceCode(Long l) {
        this.deviceCode = l;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long l) {
        this.version = l;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("SyncKey{dataType='");
        stringBuffer.append(this.dataType).append("', type='");
        stringBuffer.append(this.type).append("', deviceCode='");
        stringBuffer.append(this.deviceCode).append("', version='");
        stringBuffer.append(this.version).append("', category='");
        stringBuffer.append(this.category).append("'}");
        return stringBuffer.toString();
    }
}
