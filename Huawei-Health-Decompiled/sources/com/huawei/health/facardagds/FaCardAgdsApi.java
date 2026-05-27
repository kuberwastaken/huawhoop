package com.huawei.health.facardagds;

import android.content.Intent;

/* JADX INFO: loaded from: classes4.dex */
public interface FaCardAgdsApi {
    public static final int CONNECTION_FAILED = 1001;
    public static final int CONNECTION_FAILED_REQUEST_CODE = 101;
    public static final int CONNECTION_SUSPENDED = 1000;
    public static final String DEFAULT = "default";
    public static final String DIET_FA_CARD = "dietfacard";
    public static final String FA_CARD = "facard";
    public static final String FA_CARD_PACKAGE_NAME = "com.huawei.ohos.healthservice";
    public static final int GET_LOAD_RESULT_CODE_FAIL = -1;
    public static final int LOAD_RESULT_CODE_FAIL_SERVER_OFF_SHELVE = 3;
    public static final int OPEN_FA_DETAIL_REQUEST_FAIL = 1002;
    public static final int PROTOCOL_AND_VERSION_UPDATE_REQUEST_CODE = 100;
    public static final String SLEEP_FA_CARD = "sleepfacard";
    public static final String SPORT_FA_CARD = "sportfacard";
    public static final String STEP_FA_CARD_PACKAGE_NAME = "com.huawei.ohos.health";
    public static final int STEP_FA_CARD_SERVICE_UNINSTALLED = 5;

    public interface OpenAgdsResultCallback {
        void onResponse(int i);
    }

    void addFACardToDesktop(int i, String str, OpenAgdsResultCallback openAgdsResultCallback);

    void addToDeskTopBi(Intent intent, int i);

    void close();

    int faQuickServicesBiEvent(int i, int i2);

    int faQuickServicesBiEvent(int i, int i2, int i3);

    int faQuickServicesBiEvent(int i, int i2, int i3, String str);

    int getLoadResultCode(Intent intent);

    int getResultcodeAgreeProtocol();

    int getResultcodeNotAgreeProtocol();

    void open(int i, String str, OpenAgdsResultCallback openAgdsResultCallback);

    /* JADX INFO: loaded from: classes9.dex */
    public enum DimensionType {
        MINI("1x2", 1),
        MEDIUM("2x2", 2),
        LARGE("2x4", 3),
        HUGE("4x4", 4);

        public String desc;
        public int type;

        DimensionType(String str, int i) {
            this.desc = str;
            this.type = i;
        }

        public static int getType(String str) {
            for (DimensionType dimensionType : values()) {
                if (dimensionType.desc.equals(str)) {
                    return dimensionType.type;
                }
            }
            return -1;
        }
    }
}
