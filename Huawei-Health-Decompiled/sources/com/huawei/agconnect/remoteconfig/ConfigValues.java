package com.huawei.agconnect.remoteconfig;

/* JADX INFO: loaded from: classes3.dex */
public interface ConfigValues {
    boolean containKey(String str);

    Boolean getValueAsBoolean(String str);

    byte[] getValueAsByteArray(String str);

    Double getValueAsDouble(String str);

    Long getValueAsLong(String str);

    String getValueAsString(String str);
}
