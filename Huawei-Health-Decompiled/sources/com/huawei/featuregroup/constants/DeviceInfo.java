package com.huawei.featuregroup.constants;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes3.dex */
public class DeviceInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("deviceType")
    private int f2011a;

    @SerializedName("deviceName")
    private String d;

    @SerializedName("deviceId")
    private String e;

    public DeviceInfo(int i, String str, String str2) {
        this.f2011a = i;
        this.d = str;
        this.e = str2;
    }

    public enum DeviceType {
        PHONE(0),
        WEAR(1);

        private final int value;

        DeviceType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }
}
