package com.huawei.operation.beans;

import com.google.gson.annotations.SerializedName;
import com.huawei.watchface.mvp.model.webview.JsNetwork;

/* JADX INFO: loaded from: classes11.dex */
public class NetworkStatusObj {

    @SerializedName("isAirplaneMode")
    private boolean isAirplaneMode;

    @SerializedName("isRoaming")
    private boolean isRoaming;

    @SerializedName("networkCountryIso")
    private String networkCountryIso;

    @SerializedName("operator")
    private String operator;

    @SerializedName("type")
    private String type = NetworkType.UNCONNECTED.getType();

    public void setType(NetworkType networkType) {
        this.type = networkType.getType();
    }

    public void setOperator(String str) {
        this.operator = str;
    }

    public void setNetworkCountryIso(String str) {
        this.networkCountryIso = str;
    }

    public void setRoaming(boolean z) {
        this.isRoaming = z;
    }

    public void setAirplaneMode(boolean z) {
        this.isAirplaneMode = z;
    }

    public String getType() {
        return this.type;
    }

    public String getOperator() {
        return this.operator;
    }

    public String getNetworkCountryIso() {
        return this.networkCountryIso;
    }

    public boolean isRoaming() {
        return this.isRoaming;
    }

    public boolean isAirplaneMode() {
        return this.isAirplaneMode;
    }

    public enum NetworkType {
        UNCONNECTED("unConnected"),
        WIFI("wifi"),
        MOBILE(JsNetwork.NetworkType.MOBILE),
        VPN("vpn"),
        OTHER("other");

        private final String type;

        NetworkType(String str) {
            this.type = str;
        }

        public String getType() {
            return this.type;
        }
    }
}
