package defpackage;

import com.huawei.hwdevice.phoneprocess.mgr.exercise.utils.seuqneceutils.SequenceDetailFieldConfig;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public final class nns {
    private static SecureRandom d = EncryptUtil.genSecureRandom();

    public static String a(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            if (SequenceDetailFieldConfig.CHAR.equalsIgnoreCase(d.nextInt(2) % 2 == 0 ? SequenceDetailFieldConfig.CHAR : "num")) {
                sb.append((char) (d.nextInt(26) + (d.nextInt(2) % 2 == 0 ? 65 : 97)));
            } else {
                sb.append(String.valueOf(d.nextInt(10)));
            }
        }
        return sb.toString();
    }
}
