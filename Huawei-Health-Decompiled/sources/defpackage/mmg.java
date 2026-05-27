package defpackage;

import android.text.TextUtils;
import com.huawei.operation.utils.Constants;
import java.net.URI;
import java.net.URISyntaxException;

/* JADX INFO: loaded from: classes6.dex */
public class mmg {
    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String scheme = new URI(str.trim().replaceAll(" ", Constants.PERCENT_20).replaceAll("\\^", "%5E")).getScheme();
            return scheme == null ? "" : scheme;
        } catch (URISyntaxException unused) {
            mly.a("UriUtils", "URISyntaxException", true);
            return "";
        }
    }
}
