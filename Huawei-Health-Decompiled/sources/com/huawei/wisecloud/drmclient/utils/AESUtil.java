package com.huawei.wisecloud.drmclient.utils;

import com.huawei.wisecloud.drmclient.log.HwDrmLog;

/* JADX INFO: loaded from: classes8.dex */
public class AESUtil {
    private static final String AES_ALGORITHM_NAME = "AES";
    private static final String AES_CBC = "AES/CBC/PKCS5Padding";
    private static final String AES_ECB = "AES/ECB/PKCS5Padding";
    private static final String AES_GCM = "AES/GCM/NoPadding";
    private static final int AES_GCM_DEFAULT_TAG_LENGTH = 128;
    private static final String AES_OFB = "AES/OFB/PKCS5Padding";
    private static final String AES_OFB_NO_PADDING = "AES/OFB/NoPadding";
    private static final String TAG = "AESUtil";

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] decrypt(byte[] r8, byte[] r9, byte[] r10, java.lang.String r11) throws com.huawei.wisecloud.drmclient.exception.HwDrmException {
        /*
            Method dump skipped, instruction units count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.wisecloud.drmclient.utils.AESUtil.decrypt(byte[], byte[], byte[], java.lang.String):byte[]");
    }

    private static String logErrorMsg(String str) {
        HwDrmLog.e(TAG, str);
        return str;
    }
}
