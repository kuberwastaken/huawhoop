package com.huawei.health.devicemgr.business.constant;

import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes4.dex */
public enum ResultCodeMessage {
    PARSE_ERROR_CODE,
    GET_TIME_ERROR_CODE,
    NO_SUCH_METHOD_ERROR_CODE,
    BINDER_IS_NULL_ERROR_CODE,
    PARSE_NUMBER_FORMAT_ERROR_CODE,
    REMOTE_ERR;

    private static final int START_VALUE = 100;
    private static Map<Integer, ResultCodeMessage> mMap = new TreeMap();
    private int value;

    static {
        ResultCodeMessage[] resultCodeMessageArrValues = values();
        for (int i = 0; i < resultCodeMessageArrValues.length; i++) {
            int i2 = i + 100;
            resultCodeMessageArrValues[i].value = i2;
            mMap.put(Integer.valueOf(i2), resultCodeMessageArrValues[i]);
        }
    }

    public static ResultCodeMessage fromInt(int i) {
        return mMap.get(Integer.valueOf(i));
    }

    public int value() {
        return this.value;
    }
}
