package com.huawei.hwcloudmodel.agreement;

import com.huawei.haf.bundle.AppBundleBuildConfig;

/* JADX INFO: loaded from: classes5.dex */
public class AgrConstant {
    public static final int BETA_USER_AGREEMENT_CODE = 10000050;
    public static final int HEALTH_AGREEMENT_CODE = 118;
    public static final int HEALTH_PRIVACY_CODE = 10009;
    public static final String KEY_ERROR_CODE = "errorCode";
    public static final int MSG_NETWORK_ERROR_TOAST = 10004;
    public static final int MSG_OBTAIN_TOKEN = 10002;
    public static final int VMALL_AGREEMENT_CODE = 134;
    public static final int VMALL_PRIVACY_CODE = 10023;

    private AgrConstant() {
    }

    public static String getClientVersionByHuaweiHealth() {
        return "huaweihealth " + AppBundleBuildConfig.n();
    }
}
