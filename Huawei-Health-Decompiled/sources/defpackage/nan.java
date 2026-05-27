package defpackage;

import com.huawei.operation.utils.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* JADX INFO: loaded from: classes6.dex */
public class nan {
    private static String b;
    private static String[] e = {"0", "1", "2"};

    public static String a() {
        return b;
    }

    public static void c(String str) {
        if (mzd.e("ODSA_SUPPORT_URL_ENCODER_TOKEN", (Boolean) false).booleanValue()) {
            try {
                b = URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException unused) {
                mza.c("TokenUtils", "UnsupportedEncodingException.");
            }
        } else {
            b = str;
        }
        StringBuilder sb = new StringBuilder("update token to xxx, length is ");
        sb.append(str != null ? Integer.valueOf(str.length()) : Constants.NULL);
        mza.a("TokenUtils", sb.toString());
    }
}
