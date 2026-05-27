package com.huawei.multisimsdk.multidevicemanager.common;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AuthParam {
    private int slotId = -1;
    private String imsi = "";
    private String ciphertext = "";
    private String ciphertextSign = "";

    public abstract int getAuthType();

    public String getIdentifyCode() {
        return null;
    }

    public String getPhoneNumber() {
        return null;
    }

    public int getSlotId() {
        return this.slotId;
    }

    public void setSlotId(int i) {
        this.slotId = i;
    }

    public String getImsi() {
        return this.imsi;
    }

    public void setImsi(String str) {
        this.imsi = str;
    }

    public void setCiphertext(String str) {
        this.ciphertext = str;
    }

    public String getCiphertext() {
        return this.ciphertext;
    }

    public void setCiphertextSign(String str) {
        this.ciphertextSign = str;
    }

    public String getCiphertextSign() {
        return this.ciphertextSign;
    }
}
