package com.huawei.wisecloud.drmclient.utils;

import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.wisecloud.drmclient.exception.HwDrmException;
import com.huawei.wisecloud.drmclient.log.HwDrmLog;

/* JADX INFO: loaded from: classes8.dex */
public class JwtUtil {
    private static final int JWT_ENTRY_NUM = 3;
    private static final String JWT_SEP = "\\.";
    private static final String LOG_TAG = "JwtUtil";
    public static final String SHARE_KEY_AAD = "00";

    public static String[] handleJwtString(String str) throws HwDrmException {
        String[] strArrSplit = str.split(JWT_SEP);
        if (strArrSplit.length != 3) {
            String str2 = "JWT format error: spilted length " + strArrSplit.length;
            HwDrmLog.e(LOG_TAG, str2);
            throw new HwDrmException(str2);
        }
        return (String[]) strArrSplit.clone();
    }

    public static byte[] generateSecureRandom(int i) {
        try {
            byte[] bArr = new byte[i];
            EncryptUtil.genSecureRandom().nextBytes(bArr);
            return bArr;
        } catch (Exception e) {
            HwDrmLog.e(LOG_TAG, "generate secure random error" + HwDrmLog.printException(e));
            return new byte[0];
        }
    }
}
