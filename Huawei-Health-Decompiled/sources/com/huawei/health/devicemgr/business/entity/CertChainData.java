package com.huawei.health.devicemgr.business.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class CertChainData {

    @SerializedName("certChain")
    private String certChain;

    @SerializedName("certChainList")
    private List<String> certChainList;

    @SerializedName("certChainType")
    private int certChainType;

    public CertChainData() {
        this.certChainType = 2;
    }

    public CertChainData(String str, List<String> list, int i) {
        this.certChain = str;
        this.certChainList = list;
        this.certChainType = i;
    }

    public String getCertChain() {
        return this.certChain;
    }

    public void setCertChain(String str) {
        this.certChain = str;
    }

    public List<String> getCertChainList() {
        return this.certChainList;
    }

    public void setCertChainList(List<String> list) {
        this.certChainList = list;
    }

    public int getCertChainType() {
        return this.certChainType;
    }

    public void setCertChainType(int i) {
        this.certChainType = i;
    }

    public String toString() {
        return "CertChainData{certChain=" + this.certChain + "certChainList=" + this.certChainList + ", certChainType=" + this.certChainType + '}';
    }
}
