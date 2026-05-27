package com.huawei.watchface;

import com.huawei.hwdevice.phoneprocess.mgr.exercise.utils.seuqneceutils.SequenceDetailFieldConfig;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.watchface.utils.HwLog;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes8.dex */
public final class dz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SecureRandom f11506a = EncryptUtil.genSecureRandom();

    public static String a(int i) {
        StringBuilder sb = new StringBuilder(i);
        for (int i2 = 0; i2 < i; i2++) {
            try {
                if (SequenceDetailFieldConfig.CHAR.equalsIgnoreCase(f11506a.nextInt(2) % 2 == 0 ? SequenceDetailFieldConfig.CHAR : "num")) {
                    sb.append((char) (f11506a.nextInt(26) + (f11506a.nextInt(2) % 2 == 0 ? 65 : 97)));
                } else {
                    sb.append(String.valueOf(f11506a.nextInt(10)));
                }
            } catch (Exception e) {
                HwLog.e("RandomUtils", "getStringRandom Exception:" + HwLog.printException(e));
            }
        }
        return sb.toString();
    }

    public static int b(int i) {
        return f11506a.nextInt(i);
    }
}
