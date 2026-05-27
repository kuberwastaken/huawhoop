package com.huawei.common;

/* JADX INFO: loaded from: classes10.dex */
public class GuardianAccount {
    private String guardianUserAccount;
    private String guardianUserID;

    public String fetchGuardianUserID() {
        return this.guardianUserID;
    }

    public void configGuardianUserID(String str) {
        this.guardianUserID = str;
    }

    public String fetchGuardianUserAccount() {
        return this.guardianUserAccount;
    }

    public void configGuardianUserAccount(String str) {
        this.guardianUserAccount = str;
    }

    public String toString() {
        return "GuardianAccount:[guardianUserID = " + this.guardianUserID + "guardianUserAccount = " + this.guardianUserAccount + "]";
    }
}
