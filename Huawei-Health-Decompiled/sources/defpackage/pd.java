package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.app.EnvUtils;

/* JADX INFO: loaded from: classes9.dex */
public class pd {
    public static String b() {
        return nf.e;
    }

    public static String d(Context context) {
        if (EnvUtils.d()) {
            return "https://mobilegw.alipaydev.com/mgw.htm";
        }
        if (EnvUtils.a()) {
            return "https://mobilegw.dl.alipaydev.com/mgw.htm";
        }
        if (context == null) {
            return nf.d;
        }
        String str = nf.d;
        return TextUtils.isEmpty(str) ? nf.d : str;
    }
}
