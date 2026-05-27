package defpackage;

import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes8.dex */
public final class wxc {
    public static SecureRandom c() {
        EncryptUtil.setBouncycastleFlag(true);
        return EncryptUtil.genSecureRandom();
    }

    public static byte[] a(int i) {
        EncryptUtil.setBouncycastleFlag(true);
        return EncryptUtil.generateSecureRandom(i);
    }
}
