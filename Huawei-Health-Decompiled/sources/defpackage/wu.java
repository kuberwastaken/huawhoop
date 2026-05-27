package defpackage;

import com.fasterxml.jackson.core.Base64Variant;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes9.dex */
public final class wu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Base64Variant f18937a;
    public static final Base64Variant c;
    public static final Base64Variant d;
    public static final Base64Variant e;

    static {
        Base64Variant base64Variant = new Base64Variant("MIME", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        d = base64Variant;
        c = new Base64Variant(base64Variant, "MIME-NO-LINEFEEDS", Integer.MAX_VALUE);
        e = new Base64Variant(base64Variant, "PEM", true, '=', 64);
        StringBuilder sb = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
        sb.setCharAt(sb.indexOf(Marker.ANY_NON_NULL_MARKER), '-');
        sb.setCharAt(sb.indexOf("/"), '_');
        f18937a = new Base64Variant("MODIFIED-FOR-URL", sb.toString(), false, (char) 0, Integer.MAX_VALUE);
    }

    public static Base64Variant d() {
        return c;
    }

    public static Base64Variant c(String str) throws IllegalArgumentException {
        String str2;
        Base64Variant base64Variant = d;
        if (base64Variant.f1658a.equals(str)) {
            return base64Variant;
        }
        Base64Variant base64Variant2 = c;
        if (base64Variant2.f1658a.equals(str)) {
            return base64Variant2;
        }
        Base64Variant base64Variant3 = e;
        if (base64Variant3.f1658a.equals(str)) {
            return base64Variant3;
        }
        Base64Variant base64Variant4 = f18937a;
        if (base64Variant4.f1658a.equals(str)) {
            return base64Variant4;
        }
        if (str == null) {
            str2 = "<null>";
        } else {
            str2 = "'" + str + "'";
        }
        throw new IllegalArgumentException("No Base64Variant with name " + str2);
    }
}
