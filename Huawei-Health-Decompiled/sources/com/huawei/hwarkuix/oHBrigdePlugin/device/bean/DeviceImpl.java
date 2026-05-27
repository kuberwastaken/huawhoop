package com.huawei.hwarkuix.oHBrigdePlugin.device.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.health.ecologydevice.networkclient.HealthEngineRequestManager;
import com.huawei.operation.ble.BleConstants;
import com.huawei.operation.h5pro.jsmodules.device.DevicePairUtils;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;

/* JADX INFO: loaded from: classes10.dex */
public class DeviceImpl {

    @SerializedName("appLayerProtocol")
    private int appLayerProtocol;

    @SerializedName("btMac")
    private String btMac;

    @SerializedName("btType")
    private int btType;

    @SerializedName("btVersion")
    private int btVersion;

    @SerializedName("certModel")
    private String certModel;

    @SerializedName(BleConstants.KEY_CONNECTSTATE)
    private int connectState;

    @SerializedName("deviceBtModel")
    private String deviceBtModel;

    @SerializedName(DevicePairUtils.DEVICE_FACTORY_RESET)
    private int deviceFactoryReset;

    @SerializedName("deviceId")
    private String deviceId;

    @SerializedName("deviceIdToServerType")
    private int deviceIdToServerType;

    @SerializedName("deviceModel")
    private String deviceModel;

    @SerializedName(HealthEngineRequestManager.PARAMS_DEVICE_SN)
    private String deviceSn;

    @SerializedName("deviceSoftVersion")
    private String deviceSoftVersion;

    @SerializedName("deviceSubModelId")
    private String deviceSubModelId;

    @SerializedName("deviceType")
    private int deviceType;

    @SerializedName("deviceVersion")
    private String deviceVersion;

    @SerializedName(FaqConstants.FAQ_EMUIVERSION)
    private String emuiVersion;

    @SerializedName("interfaceName")
    private String interfaceName;

    @SerializedName("lastConnectedTime")
    private long lastConnectedTime;

    @SerializedName("linkLayerProtocol")
    private int linkLayerProtocol;

    @SerializedName("name")
    private String name;

    @SerializedName("powerSaveMode")
    private int powerSaveMode;

    @SerializedName("powerSaveModel")
    private int powerSaveModel;

    @SerializedName("prodId")
    private String prodId;

    @SerializedName("range")
    private int range;

    @SerializedName(DevicePairUtils.DEVICE_SMART_METER_VERSION)
    private int smartMeterVersion;

    @SerializedName(DevicePairUtils.DEVICE_SPORT_VERSION)
    private int sportVersion;

    @SerializedName("supportVersion")
    private int supportVersion;

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public int getBtType() {
        return this.btType;
    }

    public void setBtType(int i) {
        this.btType = i;
    }

    public int getRange() {
        return this.range;
    }

    public void setRange(int i) {
        this.range = i;
    }

    public String getInterfaceName() {
        return this.interfaceName;
    }

    public void setInterfaceName(String str) {
        this.interfaceName = str;
    }

    public int getAppLayerProtocol() {
        return this.appLayerProtocol;
    }

    public void setAppLayerProtocol(int i) {
        this.appLayerProtocol = i;
    }

    public int getConnectState() {
        return this.connectState;
    }

    public void setConnectState(int i) {
        this.connectState = i;
    }

    public long getLastConnectedTime() {
        return this.lastConnectedTime;
    }

    public void setLastConnectedTime(long j) {
        this.lastConnectedTime = j;
    }

    public int getLinkLayerProtocol() {
        return this.linkLayerProtocol;
    }

    public void setLinkLayerProtocol(int i) {
        this.linkLayerProtocol = i;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public void setDeviceModel(String str) {
        this.deviceModel = str;
    }

    public String getDeviceSoftVersion() {
        return this.deviceSoftVersion;
    }

    public void setDeviceSoftVersion(String str) {
        this.deviceSoftVersion = str;
    }

    public String getCertModel() {
        return this.certModel;
    }

    public void setCertModel(String str) {
        this.certModel = str;
    }

    public int getSportVersion() {
        return this.sportVersion;
    }

    public void setSportVersion(int i) {
        this.sportVersion = i;
    }

    public String getDeviceSn() {
        return this.deviceSn;
    }

    public void setDeviceSn(String str) {
        this.deviceSn = str;
    }

    public int getPowerSaveMode() {
        return this.powerSaveMode;
    }

    public void setPowerSaveMode(int i) {
        this.powerSaveMode = i;
    }

    public int getBtVersion() {
        return this.btVersion;
    }

    public void setBtVersion(int i) {
        this.btVersion = i;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(int i) {
        this.deviceType = i;
    }

    public String getDeviceVersion() {
        return this.deviceVersion;
    }

    public void setDeviceVersion(String str) {
        this.deviceVersion = str;
    }

    public String getBtMac() {
        return this.btMac;
    }

    public void setBtMac(String str) {
        this.btMac = str;
    }

    public int getPowerSaveModel() {
        return this.powerSaveModel;
    }

    public void setPowerSaveModel(int i) {
        this.powerSaveModel = i;
    }

    public String getProdId() {
        return this.prodId;
    }

    public void setProdId(String str) {
        this.prodId = str;
    }

    public String getDeviceBtModel() {
        return this.deviceBtModel;
    }

    public void setDeviceBtModel(String str) {
        this.deviceBtModel = str;
    }

    public int getSupportVersion() {
        return this.supportVersion;
    }

    public void setSupportVersion(int i) {
        this.supportVersion = i;
    }

    public int getDeviceIdToServerType() {
        return this.deviceIdToServerType;
    }

    public void setDeviceIdToServerType(int i) {
        this.deviceIdToServerType = i;
    }

    public String getEmuiVersion() {
        return this.emuiVersion;
    }

    public void setEmuiVersion(String str) {
        this.emuiVersion = str;
    }

    public int getSmartMeterVersion() {
        return this.smartMeterVersion;
    }

    public void setSmartMeterVersion(int i) {
        this.smartMeterVersion = i;
    }

    public String getDeviceSubModelId() {
        return this.deviceSubModelId;
    }

    public void setDeviceSubModelId(String str) {
        this.deviceSubModelId = str;
    }

    public int getDeviceFactoryReset() {
        return this.deviceFactoryReset;
    }

    public void setDeviceFactoryReset(int i) {
        this.deviceFactoryReset = i;
    }
}
