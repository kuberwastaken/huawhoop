package com.huawei.hms.mlsdk.asr.engine;

import android.os.Bundle;

/* JADX INFO: loaded from: classes5.dex */
public class AsrError {
    static final int CONNECTING_LIMIT = 3017;
    static final int FINISH_MULTIPLES = 3018;
    static final int INVALID_DATA_FORMAT = 3019;
    static final int INVOKE_SERVICE_FAILED = 3005;
    static final int SERVICE_CLOSE = 3016;
    public static final int SERVICE_FREE_USED_UP = 4007;
    public static final int SERVICE_OUTSTANDING = 4005;
    public static final int SERVICE_OUT_CREDIT = 3022;
    public static final int SERVICE_UNSUBSCRIBED = 4006;
    static final int SUBCODE_ABNORMAL_INTERUPTED = 1003;
    static final int SUBCODE_ILLEGAL_PARAMETER = 3002;
    static final int SUBCODE_INFFICIENT_PERMISSION = 1004;
    public static final int SUBCODE_INVALID = 4000;
    static final int SUBCODE_INVALID_TOKEN = 3001;
    static final int SUBCODE_MAX_DURATION_EXCEED = 3015;
    static final int SUBCODE_NOT_HUAWEIPHONE_EMUI = 3016;
    static final int SUBCODE_RECORDER_FAILED = 1001;
    static final int SUBCODE_VAD_FAILED = 1002;
    static final String SUB_ERROR_CODE_KEY = "subErrorCode";
    static final int SYSTEM_INNER_ERROR = 3000;
    static final int THIRD_SERVICE_ERROR = 3003;
    static final int WEBSOCKET_NOT_AUTH = 3013;
    static final int WEBSOCKET_NOT_START = 3014;
    private int errorCode;
    private Object ext;
    private String message;

    public AsrError(int i, String str, Object obj) {
        this.errorCode = i;
        this.message = str;
        this.ext = obj;
    }

    public static AsrError create(int i, String str, Object obj) {
        return new AsrError(i, str, obj);
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getMessage() {
        return this.message;
    }

    public Integer getSubErrorCode() {
        Object obj = this.ext;
        if (obj == null || !(obj instanceof Bundle)) {
            return null;
        }
        return Integer.valueOf(((Bundle) obj).getInt(SUB_ERROR_CODE_KEY));
    }

    public String toString() {
        if (getSubErrorCode() == null) {
            StringBuilder sbA = com.huawei.hms.mlsdk.asr.o.a.a("[");
            sbA.append(this.errorCode);
            sbA.append("]");
            sbA.append(this.message);
            return sbA.toString();
        }
        StringBuilder sbA2 = com.huawei.hms.mlsdk.asr.o.a.a("[");
        sbA2.append(this.errorCode);
        sbA2.append(getSubErrorCode());
        sbA2.append("]");
        sbA2.append(this.message);
        return sbA2.toString();
    }

    public static AsrError create(a aVar) {
        throw null;
    }
}
